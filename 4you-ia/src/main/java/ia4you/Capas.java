package ia4you;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 * Confirma que a obra sugerida pela IA existe e busca a capa em APIs públicas e gratuitas:
 * iTunes Search (filmes e músicas) e Open Library (livros). Nenhuma exige chave.
 * Se o título não for encontrado, a sugestão fica marcada como "não verificada".
 */
final class Capas {

    // Não são final só para os testes poderem apontar para um servidor falso.
    static String ITUNES = "https://itunes.apple.com/search";
    static String OPENLIB = "https://openlibrary.org/search.json";
    static String OPENLIB_CAPA = "https://covers.openlibrary.org/b/id/";

    private static final HttpClient HTTP = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(8)).followRedirects(HttpClient.Redirect.ALWAYS).build();

    private Capas() {}

    /** Nunca lança exceção: se algo falhar, a sugestão só fica sem capa e não verificada. */
    static void preencher(Categoria c, Sugestao s) {
        try {
            switch (c) {
                case FILME -> itunes(s, "media=movie&entity=movie&country=BR", s.titulo, s.tituloOriginal);
                case MUSICA -> itunes(s, "media=music&entity=song&country=BR", s.titulo + " " + s.criador, s.titulo);
                case LIVRO -> openLibrary(s);
            }
        } catch (Exception e) {
            System.err.println("Capa de \"" + s.titulo + "\": " + e.getMessage());
        }
    }

    private static void itunes(Sugestao s, String filtro, String... termos) throws Exception {
        for (String termo : termos) {
            if (termo == null || termo.isBlank()) continue;
            String url = ITUNES + "?" + filtro + "&limit=5&term=" + enc(termo);
            for (Object o : Json.arr(Json.obj(Json.parse(get(url))).get("results"))) {
                Map<String, Object> r = Json.obj(o);
                String nome = Json.str(r.get("trackName"));
                if (bate(nome, s)) {
                    s.verificado = true;
                    s.fonte = "iTunes";
                    String arte = Json.str(r.get("artworkUrl100")).replace("100x100bb", "400x400bb");
                    if (!arte.isBlank()) s.capa = baixa(arte);
                    return;
                }
            }
        }
    }

    private static void openLibrary(Sugestao s) throws Exception {
        List<String> titulos = List.of(s.titulo, s.tituloOriginal);
        for (String t : titulos) {
            if (t == null || t.isBlank()) continue;
            String url = OPENLIB + "?limit=5&fields=title,cover_i&title=" + enc(t) + "&author=" + enc(s.criador);
            for (Object o : Json.arr(Json.obj(Json.parse(get(url))).get("docs"))) {
                Map<String, Object> d = Json.obj(o);
                if (bate(Json.str(d.get("title")), s)) {
                    s.verificado = true;
                    s.fonte = "Open Library";
                    int id = Json.inteiro(d.get("cover_i"));
                    if (id > 0) s.capa = baixa(OPENLIB_CAPA + id + "-M.jpg");
                    return;
                }
            }
        }
    }

    /** Compara títulos ignorando acentos, maiúsculas e pontuação. */
    static boolean bate(String candidato, Sugestao s) {
        String n = norm(candidato);
        if (n.length() < 3) return false;
        for (String t : new String[]{s.titulo, s.tituloOriginal}) {
            String m = norm(t);
            if (m.length() >= 3 && (n.contains(m) || m.contains(n))) return true;
        }
        return false;
    }

    static String norm(String t) {
        if (t == null) return "";
        return Normalizer.normalize(t, Normalizer.Form.NFD)
            .replaceAll("\\p{M}", "").toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    private static String enc(String t) {
        return URLEncoder.encode(t, StandardCharsets.UTF_8);
    }

    private static String get(String url) throws Exception {
        HttpRequest rq = HttpRequest.newBuilder(URI.create(url)).timeout(Duration.ofSeconds(12))
            .header("User-Agent", "4you-ia-prototype/1.0").GET().build();
        return HTTP.send(rq, HttpResponse.BodyHandlers.ofString()).body();
    }

    private static BufferedImage baixa(String url) throws Exception {
        HttpRequest rq = HttpRequest.newBuilder(URI.create(url)).timeout(Duration.ofSeconds(12))
            .header("User-Agent", "4you-ia-prototype/1.0").GET().build();
        byte[] bytes = HTTP.send(rq, HttpResponse.BodyHandlers.ofByteArray()).body();
        return ImageIO.read(new ByteArrayInputStream(bytes));
    }
}
