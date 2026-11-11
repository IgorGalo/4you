package ia4you;

enum Categoria {
    FILME("filme", "filmes", "Filmes"),
    LIVRO("livro", "livros", "Livros"),
    MUSICA("música", "músicas", "Músicas");

    final String singular, plural, rotulo;

    Categoria(String singular, String plural, String rotulo) {
        this.singular = singular;
        this.plural = plural;
        this.rotulo = rotulo;
    }
}
