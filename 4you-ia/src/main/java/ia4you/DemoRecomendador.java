package ia4you;

import java.util.ArrayList;
import java.util.List;

/** Modo --demo: respostas fixas, sem internet e sem chave. Serve só para ver a interface. */
final class DemoRecomendador implements Recomendador {

    @Override
    public List<Sugestao> sugerir(Categoria c, List<String> generos, List<String> evitar) throws InterruptedException {
        Thread.sleep(700);
        List<Sugestao> todas = switch (c) {
            case FILME -> List.of(
                new Sugestao("O Iluminado", "The Shining", "Stanley Kubrick", 1980, "Terror psicológico com um mistério que prende até o fim."),
                new Sugestao("Zodíaco", "Zodiac", "David Fincher", 2007, "Investigação lenta e obsessiva, ótima para quem gosta de dedução."),
                new Sugestao("Os Outros", "The Others", "Alejandro Amenábar", 2001, "Suspense gótico com um final que reorganiza tudo."),
                new Sugestao("Se7en", "Se7en", "David Fincher", 1995, "Crime sombrio com tensão constante."),
                new Sugestao("Um Corpo que Cai", "Vertigo", "Alfred Hitchcock", 1958, "Mistério clássico sobre obsessão e identidade."),
                new Sugestao("Ilha do Medo", "Shutter Island", "Martin Scorsese", 2010, "Thriller psicológico cheio de reviravoltas."));
            case LIVRO -> List.of(
                new Sugestao("O Nome da Rosa", "Il nome della rosa", "Umberto Eco", 1980, "Mistério medieval com clima sombrio."),
                new Sugestao("Dom Casmurro", "Dom Casmurro", "Machado de Assis", 1899, "Clássico cheio de dúvida e ambiguidade."),
                new Sugestao("Rebecca", "Rebecca", "Daphne du Maurier", 1938, "Romance gótico e envolvente."),
                new Sugestao("O Hobbit", "The Hobbit", "J. R. R. Tolkien", 1937, "Aventura leve e inesquecível."),
                new Sugestao("Capitães da Areia", "Capitães da Areia", "Jorge Amado", 1937, "Vida real e emoção em um clássico brasileiro."),
                new Sugestao("Frankenstein", "Frankenstein", "Mary Shelley", 1818, "Gótico clássico com dilemas profundos."));
            case MUSICA -> List.of(
                new Sugestao("Roda Viva", "Roda Viva", "Chico Buarque", 1967, "Letra intensa e arranjo marcante."),
                new Sugestao("Smells Like Teen Spirit", "Smells Like Teen Spirit", "Nirvana", 1991, "Guitarras eletrizantes e energia pura."),
                new Sugestao("Take Five", "Take Five", "Dave Brubeck Quartet", 1959, "Jazz sofisticado e improvisação envolvente."),
                new Sugestao("Construção", "Construção", "Chico Buarque", 1971, "Samba-poesia que conta uma história."),
                new Sugestao("Bohemian Rhapsody", "Bohemian Rhapsody", "Queen", 1975, "Rock teatral e ousado."),
                new Sugestao("Águas de Março", "Águas de Março", "Tom Jobim e Elis Regina", 1972, "Bossa nova leve e inesquecível."));
        };
        List<Sugestao> out = new ArrayList<>();
        for (Sugestao s : todas) {
            if (!evitar.contains(s.titulo) && out.size() < 3) out.add(s);
        }
        for (Sugestao s : todas) { // se já mostrou tudo, recomeça
            if (out.size() < 3 && !out.contains(s)) out.add(s);
        }
        return out;
    }
}
