package ia4you;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Mesma ideia do OpenAiClient, mas usando a API do Gemini (Google AI Studio),
 * que tem camada gratuita e não exige cartão de crédito.
 */
final class GeminiClient implements Recomendador {

    // Gemini usa um subconjunto do OpenAPI para o schema (tipos em maiúsculas).
    private static final String SCHEMA = """
        {"type":"OBJECT","properties":{"sugestoes":{"type":"ARRAY","items":{"type":"OBJECT","properties":{
          "titulo":{"type":"STRING"},
          "titulo_original":{"type":"STRING"},
          "criador":{"type":"STRING"},
          "ano":{"type":"INTEGER"},
          "motivo":{"type":"STRING"}},
          "required":["titulo","titulo_original","criador","ano","motivo"]}}},
          "required":["sugestoes"]}""";

    /** Pausa base entre tentativas quando o Gemini está sobrecarregado (os testes reduzem isso). */
    static long ESPERA_MS = 2000;
    private static final int TENTATIVAS = 4;

    private final HttpClient http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(15)).build();
    private final String chave;
    private final String modelo;
    private final String baseUrl;

    GeminiClient(String chave) {
        this(chave, env("GEMINI_BASE_URL", "https://generativelanguage.googleapis.com/v1beta"));
    }

    GeminiClient(String chave, String baseUrl) {
        this.chave = chave;
        this.modelo = env("GEMINI_MODEL", "gemini-3.8-flash");
        this.baseUrl = baseUrl;
    }

    @Override
    public List<Sugestao> sugerir(Categoria c, List<String> generos, List<String> evitar)
            throws IOException, InterruptedException {

        String corpo = "{\"systemInstruction\":{\"parts\":[{\"text\":" + Json.aspas(OpenAiClient.SISTEMA) + "}]}"
            + ",\"contents\":[{\"role\":\"user\",\"parts\":[{\"text\":"
            + Json.aspas(OpenAiClient.prompt(c, generos, evitar)) + "}]}]"
            + ",\"generationConfig\":{\"responseMimeType\":\"application/json\",\"responseSchema\":" + SCHEMA + "}}";

        HttpRequest rq = HttpRequest.newBuilder(URI.create(baseUrl + "/models/" + modelo + ":generateContent"))
            .timeout(Duration.ofSeconds(60))
            .header("x-goog-api-key", chave)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(corpo)).build();

        // 503 (alta demanda) e 500/504 costumam ser passageiros: tenta de novo com pausa crescente.
        HttpResponse<String> resp = http.send(rq, HttpResponse.BodyHandlers.ofString());
        for (int t = 1; t < TENTATIVAS && (resp.statusCode() == 503 || resp.statusCode() == 500 || resp.statusCode() == 504); t++) {
            Thread.sleep(ESPERA_MS * t);
            resp = http.send(rq, HttpResponse.BodyHandlers.ofString());
        }
        Map<String, Object> json = Json.obj(Json.parse(resp.body()));

        if (resp.statusCode() != 200) {
            String msg = Json.str(Json.obj(json.get("error")).get("message"));
            int st = resp.statusCode();
            if (st == 400 && msg.toLowerCase().contains("api key")) msg = "Chave da API inválida. " + msg;
            if (st == 403) msg = "Chave sem permissão. " + msg;
            if (st == 404) msg = "Modelo \"" + modelo + "\" indisponível. Defina a variável GEMINI_MODEL com um "
                + "modelo atual do Google AI Studio. Detalhe do Google: " + msg;
            if (st == 503) msg = "O modelo continua sobrecarregado depois de " + TENTATIVAS + " tentativas. "
                + "Tente de novo em alguns minutos ou use outro modelo (variável GEMINI_MODEL). " + msg;
            if (st == 429) msg = "Limite gratuito de uso atingido. Espere alguns minutos e tente de novo. " + msg;
            throw new IOException("Erro " + st + " do Gemini: " + msg);
        }

        Map<String, Object> candidato = Json.obj(Json.arr(json.get("candidates")).isEmpty()
            ? null : Json.arr(json.get("candidates")).get(0));
        List<Object> partes = Json.arr(Json.obj(candidato.get("content")).get("parts"));
        if (partes.isEmpty()) {
            throw new IOException("O Gemini não devolveu conteúdo (motivo: " + Json.str(candidato.get("finishReason")) + ").");
        }
        String texto = Json.str(Json.obj(partes.get(0)).get("text"));

        List<Sugestao> out = new ArrayList<>();
        for (Object o : Json.arr(Json.obj(Json.parse(texto)).get("sugestoes"))) {
            Map<String, Object> m = Json.obj(o);
            out.add(new Sugestao(Json.str(m.get("titulo")), Json.str(m.get("titulo_original")),
                Json.str(m.get("criador")), Json.inteiro(m.get("ano")), Json.str(m.get("motivo"))));
        }
        if (out.isEmpty()) throw new IOException("A IA não devolveu nenhuma sugestão.");
        return out;
    }

    private static String env(String nome, String padrao) {
        String v = System.getenv(nome);
        return v == null || v.isBlank() ? padrao : v;
    }
}
