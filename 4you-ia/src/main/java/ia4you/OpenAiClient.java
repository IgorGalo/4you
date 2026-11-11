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
 * Chama a API da OpenAI (Chat Completions) pedindo uma resposta em JSON com schema fixo.
 * Substitui todo o código de scraping do Google que existia no Analise.java.
 */
final class OpenAiClient implements Recomendador {

    private static final String SCHEMA = """
        {"type":"object","properties":{"sugestoes":{"type":"array","items":{"type":"object","properties":{
          "titulo":{"type":"string"},
          "titulo_original":{"type":"string"},
          "criador":{"type":"string"},
          "ano":{"type":"integer"},
          "motivo":{"type":"string"}},
          "required":["titulo","titulo_original","criador","ano","motivo"],
          "additionalProperties":false}}},
          "required":["sugestoes"],"additionalProperties":false}""";

    static final String SISTEMA =
        "Você é um curador cultural que recomenda filmes, livros e músicas. "
        + "Sugira SOMENTE obras reais e conhecidas, com título e autor corretos. "
        + "Se não tiver certeza de que uma obra existe, não a sugira. "
        + "Responda sempre em português do Brasil.";

    private final HttpClient http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(15)).build();
    private final String chave;
    private final String modelo;
    private final String baseUrl;

    OpenAiClient(String chave) {
        this(chave, env("OPENAI_BASE_URL", "https://api.openai.com/v1"));
    }

    OpenAiClient(String chave, String baseUrl) {
        this.chave = chave;
        this.modelo = env("OPENAI_MODEL", "gpt-4o-mini");
        this.baseUrl = baseUrl;
    }

    @Override
    public List<Sugestao> sugerir(Categoria c, List<String> generos, List<String> evitar)
            throws IOException, InterruptedException {

        String corpo = "{\"model\":" + Json.aspas(modelo)
            + ",\"messages\":[{\"role\":\"system\",\"content\":" + Json.aspas(SISTEMA)
            + "},{\"role\":\"user\",\"content\":" + Json.aspas(prompt(c, generos, evitar)) + "}]"
            + ",\"response_format\":{\"type\":\"json_schema\",\"json_schema\":{\"name\":\"sugestoes\",\"strict\":true,\"schema\":"
            + SCHEMA + "}}}";

        HttpRequest.Builder rb = HttpRequest.newBuilder(URI.create(baseUrl + "/chat/completions"))
            .timeout(Duration.ofSeconds(60))
            .header("Authorization", "Bearer " + chave)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(corpo));

        // Opcionais — são os mesmos "organization" e "project" do slide da aula.
        String org = System.getenv("OPENAI_ORG_ID"), proj = System.getenv("OPENAI_PROJECT_ID");
        if (org != null && !org.isBlank()) rb.header("OpenAI-Organization", org);
        if (proj != null && !proj.isBlank()) rb.header("OpenAI-Project", proj);

        HttpResponse<String> resp = http.send(rb.build(), HttpResponse.BodyHandlers.ofString());
        Map<String, Object> json = Json.obj(Json.parse(resp.body()));

        if (resp.statusCode() != 200) {
            String msg = Json.str(Json.obj(json.get("error")).get("message"));
            if (resp.statusCode() == 401) msg = "Chave da API inválida ou ausente. " + msg;
            if (resp.statusCode() == 429) msg = "Limite de uso ou saldo insuficiente na conta. " + msg;
            throw new IOException("Erro " + resp.statusCode() + " da OpenAI: " + msg);
        }

        Map<String, Object> mensagem = Json.obj(Json.obj(Json.arr(json.get("choices")).get(0)).get("message"));
        if (mensagem.get("refusal") != null) {
            throw new IOException("O modelo recusou o pedido: " + Json.str(mensagem.get("refusal")));
        }

        List<Sugestao> out = new ArrayList<>();
        for (Object o : Json.arr(Json.obj(Json.parse(Json.str(mensagem.get("content")))).get("sugestoes"))) {
            Map<String, Object> m = Json.obj(o);
            out.add(new Sugestao(Json.str(m.get("titulo")), Json.str(m.get("titulo_original")),
                Json.str(m.get("criador")), Json.inteiro(m.get("ano")), Json.str(m.get("motivo"))));
        }
        if (out.isEmpty()) throw new IOException("A IA não devolveu nenhuma sugestão.");
        return out;
    }

    static String prompt(Categoria c, List<String> generos, List<String> evitar) {
        StringBuilder p = new StringBuilder();
        p.append("Sugira exatamente 3 ").append(c.plural).append(". ");
        if (generos.isEmpty()) {
            p.append("O usuário não tem preferência de gênero: surpreenda com obras variadas e bem avaliadas. ");
        } else {
            p.append("Gêneros/estilos preferidos do usuário: ").append(String.join(", ", generos))
             .append(". Procure obras que combinem esses gostos. ");
        }
        if (!evitar.isEmpty()) {
            p.append("NÃO repita estes: ").append(String.join("; ", evitar)).append(". ");
        }
        p.append("Em 'criador' coloque o ")
         .append(c == Categoria.FILME ? "diretor" : c == Categoria.LIVRO ? "autor" : "artista ou banda")
         .append(". Em 'titulo' use o nome como é conhecido no Brasil e em 'titulo_original' o nome original. ")
         .append("Em 'motivo' escreva uma frase curta explicando por que combina com o gosto do usuário.");
        return p.toString();
    }

    private static String env(String nome, String padrao) {
        String v = System.getenv(nome);
        return v == null || v.isBlank() ? padrao : v;
    }
}
