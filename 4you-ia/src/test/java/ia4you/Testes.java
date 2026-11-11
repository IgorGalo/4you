package ia4you;

import com.sun.net.httpserver.HttpServer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.imageio.ImageIO;

public class Testes {
    static int falhas = 0;
    static void ok(boolean c, String nome) { System.out.println((c ? "OK   " : "FALHA ") + nome); if (!c) falhas++; }

    public static void main(String[] a) throws Exception {
        // 1) Json
        var m = Json.obj(Json.parse("{\"a\":[1,2.5,\"x\\n\\u00e9\\\"\"],\"b\":{\"c\":null,\"d\":true}}"));
        ok(Json.arr(m.get("a")).size() == 3 && Json.str(Json.arr(m.get("a")).get(2)).equals("x\né\""), "Json parse + escapes");
        ok(Json.parse(Json.aspas("ol\"á\n\\")).equals("ol\"á\n\\"), "Json aspas <-> parse (round-trip)");

        // 2) Questionario (mesma tabela do Analise.java)
        ok(Questionario.generos(Categoria.FILME, new int[]{1,1,1,3,3}).equals(List.of("terror","mistério","drama")), "gêneros filme 1,1,1,3,3");
        ok(Questionario.generos(Categoria.MUSICA, new int[]{2,2,2,2,2}).equals(List.of("jazz","samba","K-pop","reggae","sertanejo")), "gêneros música 2,2,2,2,2");
        ok(Questionario.generos(Categoria.LIVRO, new int[]{3,3,3,3,3}).isEmpty(), "tudo 'nenhuma' => lista vazia (antes quebrava com IndexOutOfBounds)");

        // 3) Normalização / verificação
        Sugestao s = new Sugestao("O Iluminado", "The Shining", "Kubrick", 1980, "");
        ok(Capas.bate("The Shining (1980)", s) && Capas.bate("O ILUMINADO", s) && !Capas.bate("Titanic", s), "bate() ignora acento/caixa e rejeita título errado");

        // 4) Servidor falso: OpenAI + iTunes + OpenLibrary
        HttpServer srv = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        final String[] corpoRecebido = new String[1], authRecebido = new String[1];
        srv.createContext("/v1/chat/completions", ex -> {
            corpoRecebido[0] = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            authRecebido[0] = ex.getRequestHeaders().getFirst("Authorization");
            String conteudo = "{\"sugestoes\":[{\"titulo\":\"O Iluminado\",\"titulo_original\":\"The Shining\",\"criador\":\"Stanley Kubrick\",\"ano\":1980,\"motivo\":\"Terror com mistério.\"},"
                + "{\"titulo\":\"Livro Inexistente\",\"titulo_original\":\"Nope\",\"criador\":\"Ninguém\",\"ano\":2000,\"motivo\":\"alucinação\"},"
                + "{\"titulo\":\"Zodíaco\",\"titulo_original\":\"Zodiac\",\"criador\":\"David Fincher\",\"ano\":2007,\"motivo\":\"x\"}]}";
            String resp = "{\"choices\":[{\"message\":{\"content\":" + Json.aspas(conteudo) + "}}]}";
            byte[] b = resp.getBytes(StandardCharsets.UTF_8);
            ex.getResponseHeaders().add("Content-Type", "application/json");
            ex.sendResponseHeaders(200, b.length); ex.getResponseBody().write(b); ex.close();
        });
        srv.createContext("/itunes", ex -> {
            String q = ex.getRequestURI().getQuery();
            String resp = q.contains("Shining") || q.contains("Iluminado")
                ? "{\"resultCount\":1,\"results\":[{\"trackName\":\"O Iluminado\",\"artworkUrl100\":\"http://127.0.0.1:" + srv_port(ex) + "/img/100x100bb.jpg\"}]}"
                : "{\"resultCount\":0,\"results\":[]}";
            byte[] b = resp.getBytes(StandardCharsets.UTF_8);
            ex.sendResponseHeaders(200, b.length); ex.getResponseBody().write(b); ex.close();
        });
        srv.createContext("/img", ex -> {
            BufferedImage im = new BufferedImage(40, 60, BufferedImage.TYPE_INT_RGB);
            ByteArrayOutputStream bo = new ByteArrayOutputStream(); ImageIO.write(im, "jpg", bo);
            // nota: a URL real terminaria em 400x400bb; o servidor falso aceita qualquer coisa em /img
            ex.sendResponseHeaders(200, bo.size()); ex.getResponseBody().write(bo.toByteArray()); ex.close();
        });
        srv.start();
        int porta = srv.getAddress().getPort();
        Capas.ITUNES = "http://127.0.0.1:" + porta + "/itunes";

        OpenAiClient cli = new OpenAiClient("chave-teste", "http://127.0.0.1:" + porta + "/v1");
        List<Sugestao> r = cli.sugerir(Categoria.FILME, List.of("terror", "mistério"), List.of("Psicose"));
        ok(r.size() == 3 && r.get(0).titulo.equals("O Iluminado") && r.get(0).ano == 1980, "OpenAiClient interpreta a resposta JSON");
        ok("Bearer chave-teste".equals(authRecebido[0]), "envia Authorization: Bearer");
        ok(corpoRecebido[0].contains("json_schema") && corpoRecebido[0].contains("NÃO repita estes: Psicose") && corpoRecebido[0].contains("terror, mistério"), "corpo da requisição tem schema, gêneros e lista 'evitar'");
        ok(Json.obj(Json.parse(corpoRecebido[0])).containsKey("model"), "corpo da requisição é JSON válido");

        for (Sugestao x : r) Capas.preencher(Categoria.FILME, x);
        ok(r.get(0).verificado && r.get(0).capa != null && r.get(0).fonte.equals("iTunes"), "item real: verificado + capa baixada");
        ok(!r.get(1).verificado && r.get(1).capa == null, "item inventado: não verificado, sem capa");
        srv.stop(0);

        // 5) erro 401
        HttpServer e = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        e.createContext("/v1/chat/completions", ex -> {
            byte[] b = "{\"error\":{\"message\":\"Incorrect API key\"}}".getBytes();
            ex.sendResponseHeaders(401, b.length); ex.getResponseBody().write(b); ex.close();
        });
        e.start();
        try {
            new OpenAiClient("chave-teste", "http://127.0.0.1:" + e.getAddress().getPort() + "/v1").sugerir(Categoria.LIVRO, List.of(), List.of());
            ok(false, "erro 401 deveria lançar exceção");
        } catch (java.io.IOException ex) {
            ok(ex.getMessage().contains("Chave da API inválida"), "erro 401 vira mensagem amigável: " + ex.getMessage());
        }
        e.stop(0);


        // 6) GeminiClient com servidor falso
        HttpServer g = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        final String[] gCorpo = new String[1], gChave = new String[1], gPath = new String[1];
        g.createContext("/v1beta/", ex -> {
            gCorpo[0] = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            gChave[0] = ex.getRequestHeaders().getFirst("x-goog-api-key");
            gPath[0] = ex.getRequestURI().getPath();
            String conteudo = "{\"sugestoes\":[{\"titulo\":\"Dom Casmurro\",\"titulo_original\":\"Dom Casmurro\",\"criador\":\"Machado de Assis\",\"ano\":1899,\"motivo\":\"Clássico.\"}]}";
            String resp = "{\"candidates\":[{\"content\":{\"parts\":[{\"text\":" + Json.aspas(conteudo) + "}]},\"finishReason\":\"STOP\"}]}";
            byte[] b = resp.getBytes(StandardCharsets.UTF_8);
            ex.sendResponseHeaders(200, b.length); ex.getResponseBody().write(b); ex.close();
        });
        g.start();
        List<Sugestao> gr = new GeminiClient("chave-gemini", "http://127.0.0.1:" + g.getAddress().getPort() + "/v1beta")
            .sugerir(Categoria.LIVRO, List.of("romance"), List.of());
        ok(gr.size() == 1 && gr.get(0).criador.equals("Machado de Assis") && gr.get(0).ano == 1899, "GeminiClient interpreta a resposta");
        ok("chave-gemini".equals(gChave[0]) && gPath[0].endsWith(":generateContent"), "Gemini: chave no header x-goog-api-key e endpoint generateContent");
        ok(gCorpo[0].contains("responseSchema") && gCorpo[0].contains("application/json") && Json.obj(Json.parse(gCorpo[0])).containsKey("contents"), "Gemini: corpo é JSON válido com schema");
        g.stop(0);

        HttpServer g2 = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        g2.createContext("/v1beta/", ex -> {
            byte[] b = "{\"error\":{\"message\":\"quota\"}}".getBytes();
            ex.sendResponseHeaders(429, b.length); ex.getResponseBody().write(b); ex.close();
        });
        g2.start();
        try {
            new GeminiClient("x", "http://127.0.0.1:" + g2.getAddress().getPort() + "/v1beta").sugerir(Categoria.FILME, List.of(), List.of());
            ok(false, "429 deveria lançar exceção");
        } catch (java.io.IOException ex) {
            ok(ex.getMessage().contains("Limite gratuito"), "Gemini 429 vira mensagem amigável");
        }
        g2.stop(0);

        // 7) Gemini com 503 temporário: deve tentar de novo e conseguir
        GeminiClient.ESPERA_MS = 10;
        final int[] chamadas = {0};
        HttpServer g3 = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        g3.createContext("/v1beta/", ex -> {
            ex.getRequestBody().readAllBytes();
            chamadas[0]++;
            String resp;
            int codigo;
            if (chamadas[0] < 3) {
                codigo = 503; resp = "{\"error\":{\"message\":\"high demand\"}}";
            } else {
                codigo = 200;
                String conteudo = "{\"sugestoes\":[{\"titulo\":\"X\",\"titulo_original\":\"X\",\"criador\":\"Y\",\"ano\":2000,\"motivo\":\"z\"}]}";
                resp = "{\"candidates\":[{\"content\":{\"parts\":[{\"text\":" + Json.aspas(conteudo) + "}]}}]}";
            }
            byte[] b = resp.getBytes(StandardCharsets.UTF_8);
            ex.sendResponseHeaders(codigo, b.length); ex.getResponseBody().write(b); ex.close();
        });
        g3.start();
        List<Sugestao> g3r = new GeminiClient("x", "http://127.0.0.1:" + g3.getAddress().getPort() + "/v1beta")
            .sugerir(Categoria.FILME, List.of(), List.of());
        ok(g3r.size() == 1 && chamadas[0] == 3, "Gemini: 503, 503, depois sucesso na 3ª tentativa (chamadas=" + chamadas[0] + ")");
        g3.stop(0);

        // 8) 503 persistente: desiste com mensagem clara depois de 4 tentativas
        final int[] c2 = {0};
        HttpServer g4 = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        g4.createContext("/v1beta/", ex -> {
            ex.getRequestBody().readAllBytes(); c2[0]++;
            byte[] b = "{\"error\":{\"message\":\"high demand\"}}".getBytes();
            ex.sendResponseHeaders(503, b.length); ex.getResponseBody().write(b); ex.close();
        });
        g4.start();
        try {
            new GeminiClient("x", "http://127.0.0.1:" + g4.getAddress().getPort() + "/v1beta").sugerir(Categoria.FILME, List.of(), List.of());
            ok(false, "503 persistente deveria lançar exceção");
        } catch (java.io.IOException ex) {
            ok(c2[0] == 4 && ex.getMessage().contains("sobrecarregado"), "Gemini: 503 persistente desiste após 4 tentativas com mensagem clara");
        }
        g4.stop(0);

        System.out.println(falhas == 0 ? "\nTODOS OS TESTES PASSARAM" : "\n" + falhas + " FALHA(S)");
        System.exit(falhas);
    }

    static int srv_port(com.sun.net.httpserver.HttpExchange ex) { return ex.getLocalAddress().getPort(); }

}
