package ia4you;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Leitor de JSON mínimo (sem dependências): objetos, listas, strings, números, true/false/null. */
final class Json {
    private final String s;
    private int i;

    private Json(String s) { this.s = s; }

    static Object parse(String texto) {
        Json j = new Json(texto);
        j.ws();
        Object v = j.valor();
        j.ws();
        if (j.i != texto.length()) throw j.erro("texto sobrando após o JSON");
        return v;
    }

    @SuppressWarnings("unchecked")
    static Map<String, Object> obj(Object o) {
        return o instanceof Map ? (Map<String, Object>) o : Map.of();
    }

    @SuppressWarnings("unchecked")
    static List<Object> arr(Object o) {
        return o instanceof List ? (List<Object>) o : List.of();
    }

    static String str(Object o) {
        return o == null ? "" : String.valueOf(o);
    }

    static int inteiro(Object o) {
        return o instanceof Number n ? n.intValue() : 0;
    }

    /** Escapa um texto para ser colocado dentro de um JSON (com as aspas). */
    static String aspas(String t) {
        StringBuilder sb = new StringBuilder("\"");
        for (char c : t.toCharArray()) {
            switch (c) {
                case '"' -> sb.append("\\\"");
                case '\\' -> sb.append("\\\\");
                case '\n' -> sb.append("\\n");
                case '\r' -> sb.append("\\r");
                case '\t' -> sb.append("\\t");
                default -> {
                    if (c < 0x20) sb.append(String.format("\\u%04x", (int) c));
                    else sb.append(c);
                }
            }
        }
        return sb.append('"').toString();
    }

    // ---- parser ----

    private Object valor() {
        if (i >= s.length()) throw erro("fim inesperado");
        char c = s.charAt(i);
        return switch (c) {
            case '{' -> objeto();
            case '[' -> lista();
            case '"' -> texto();
            case 't' -> literal("true", Boolean.TRUE);
            case 'f' -> literal("false", Boolean.FALSE);
            case 'n' -> literal("null", null);
            default -> numero();
        };
    }

    private Map<String, Object> objeto() {
        Map<String, Object> m = new LinkedHashMap<>();
        i++; ws();
        if (peek('}')) { i++; return m; }
        while (true) {
            ws();
            String k = texto();
            ws(); esperar(':'); ws();
            m.put(k, valor());
            ws();
            if (peek(',')) { i++; continue; }
            esperar('}');
            return m;
        }
    }

    private List<Object> lista() {
        List<Object> l = new ArrayList<>();
        i++; ws();
        if (peek(']')) { i++; return l; }
        while (true) {
            ws();
            l.add(valor());
            ws();
            if (peek(',')) { i++; continue; }
            esperar(']');
            return l;
        }
    }

    private String texto() {
        esperar('"');
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c == '"') return sb.toString();
            if (c != '\\') { sb.append(c); continue; }
            char e = s.charAt(i++);
            switch (e) {
                case 'n' -> sb.append('\n');
                case 't' -> sb.append('\t');
                case 'r' -> sb.append('\r');
                case 'b' -> sb.append('\b');
                case 'f' -> sb.append('\f');
                case 'u' -> { sb.append((char) Integer.parseInt(s.substring(i, i + 4), 16)); i += 4; }
                default -> sb.append(e); // \" \\ \/
            }
        }
        throw erro("string sem fechamento");
    }

    private Object numero() {
        int ini = i;
        while (i < s.length() && "+-0123456789.eE".indexOf(s.charAt(i)) >= 0) i++;
        if (ini == i) throw erro("valor inválido");
        return Double.parseDouble(s.substring(ini, i));
    }

    private Object literal(String txt, Object v) {
        if (!s.startsWith(txt, i)) throw erro("valor inválido");
        i += txt.length();
        return v;
    }

    private void ws() { while (i < s.length() && Character.isWhitespace(s.charAt(i))) i++; }
    private boolean peek(char c) { return i < s.length() && s.charAt(i) == c; }
    private void esperar(char c) { if (!peek(c)) throw erro("esperava '" + c + "'"); i++; }
    private IllegalArgumentException erro(String m) { return new IllegalArgumentException("JSON inválido (posição " + i + "): " + m); }
}
