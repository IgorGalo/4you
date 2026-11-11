package ia4you;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Questionário do 4YOU. As perguntas e a tabela de gêneros vêm do projeto original
 * (TelaPerguntas.java e Analise.java); aqui os dois ficam lado a lado em vez de
 * espalhados em dezenas de switch/case.
 */
final class Questionario {

    record Pergunta(String enunciado, String opcao1, String opcao2) {}

    static final int NUM_PERGUNTAS = 5;
    static final int OPCAO_1 = 1, OPCAO_2 = 2, NENHUMA = 3;

    static final Map<Categoria, List<Pergunta>> P = new EnumMap<>(Categoria.class);

    /** GENEROS[categoria][pergunta][opção 1 ou 2] — mesma tabela do antigo calculaResultado(). */
    private static final Map<Categoria, String[][]> GENEROS = new EnumMap<>(Categoria.class);

    static {
        P.put(Categoria.FILME, List.of(
            new Pergunta("O que você prefere:", "explorar narrativas que despertam uma sensação de medo e suspense", "se envolver mais nas histórias das relações humanas, com personagens enfrentando os desafios emocionais"),
            new Pergunta("O que você prefere:", "narrativas que desafiem sua capacidade de dedução e mantêm você intrigado do início ao fim", "narrativas exploram terras desconhecidas, desafios emocionantes e jornadas inesperadas"),
            new Pergunta("O que você prefere:", "filmes que retratam momentos intensos e emocionais que fazem você refletir sobre a complexidade da vida", "filmes que proporcionem momentos leves e divertidos, capazes de arrancar um sorriso mesmo nas situações mais inusitadas"),
            new Pergunta("O que você prefere:", "prestar atenção na trilha sonora e nas performances musicais integradas à história", "se empolgar com tramas cheias de adrenalina e reviravolta"),
            new Pergunta("O que você prefere:", "narrativas que exploram mundos imaginários e conceitos futuristas, desafiando os limites da realidade", "tramas que exploram a realidade, oferecendo uma perspectiva mais profunda sobre diferentes assuntos e experiências de vida")));
        P.put(Categoria.LIVRO, List.of(
            new Pergunta("O que você prefere:", "se perder em histórias românticas que despertam emoções profundas", "mergulhar em narrativas que oferecem uma visão mais fiel e detalhada da vida cotidiana"),
            new Pergunta("O que você prefere:", "tramas que envolvem desvendar segredos e resolver enigmas", "buscar a adrenalina das aventuras cheias de reviravoltas e desafios emocionantes"),
            new Pergunta("O que você prefere:", "explorar a vida real e as experiências de pessoas reais por meio de biografias", "escapar para mundos imaginários repletos de fantasia e criatividade"),
            new Pergunta("O que você prefere:", "se encantar mais com a profundidade e atemporalidade das obras clássicas", "a leveza e proximidade do cotidiano encontradas nas crônicas ao escolher seus livros"),
            new Pergunta("O que você prefere:", "tramas que exploram as complexidades emocionais e os desafios da vida", "obras que proporcionam momentos leves e sorrisos com sua abordagem mais cômica")));
        P.put(Categoria.MUSICA, List.of(
            new Pergunta("O que você prefere:", "ser atraído pelas batidas eletrizantes das guitarras", "mergulhar na sofisticação harmônica e improvisação envolvente"),
            new Pergunta("O que você prefere:", "atmosferas sombrias e melancólicas do gótico", "se perder na energia contagiante e em ritmos dançantes"),
            new Pergunta("O que você prefere:", "a grandiosidade e tradição das peças clássicas", "se deixar envolver pela energia contagiante e as melodias pop coreanas"),
            new Pergunta("O que você prefere:", "se entregar mais às batidas animadas e letras vibrantes", "encontrar uma conexão especial com os ritmos relaxantes e mensagens positivas"),
            new Pergunta("O que você prefere:", "refrãos cativantes e batidas populares", "histórias envolventes e o som característico do interior")));

        GENEROS.put(Categoria.FILME, new String[][]{
            {"terror", "romance"}, {"mistério", "aventura"}, {"drama", "comédia"},
            {"musical", "ação"}, {"ficção científica", "documentário"}});
        GENEROS.put(Categoria.LIVRO, new String[][]{
            {"romance", "realismo"}, {"mistério", "aventura"}, {"biografia", "ficção"},
            {"literatura clássica", "crônica"}, {"drama", "comédia"}});
        GENEROS.put(Categoria.MUSICA, new String[][]{
            {"rock", "jazz"}, {"gótico/dark", "samba"}, {"música clássica", "K-pop"},
            {"funk", "reggae"}, {"pop", "sertanejo"}});
    }

    static List<Pergunta> perguntas(Categoria c) {
        return P.get(c);
    }

    /** Converte as respostas (1, 2 ou 3 = nenhuma) na lista de gêneros escolhidos. */
    static List<String> generos(Categoria c, int[] respostas) {
        List<String> out = new ArrayList<>();
        String[][] tabela = GENEROS.get(c);
        for (int i = 0; i < NUM_PERGUNTAS; i++) {
            if (respostas[i] == OPCAO_1 || respostas[i] == OPCAO_2) {
                out.add(tabela[i][respostas[i] - 1]);
            }
        }
        return out;
    }
}
