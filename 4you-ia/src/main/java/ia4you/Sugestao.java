package ia4you;

import java.awt.image.BufferedImage;

/** Um item sugerido pela IA (e, depois, enriquecido com capa e verificação). */
final class Sugestao {
    final String titulo;
    final String tituloOriginal;
    final String criador;   // diretor, autor ou artista
    final int ano;
    final String motivo;

    BufferedImage capa;      // null se não encontrada
    boolean verificado;      // true se o item existe na base consultada
    String fonte = "";       // "iTunes", "Open Library"...

    Sugestao(String titulo, String tituloOriginal, String criador, int ano, String motivo) {
        this.titulo = titulo;
        this.tituloOriginal = tituloOriginal;
        this.criador = criador;
        this.ano = ano;
        this.motivo = motivo;
    }
}
