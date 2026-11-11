package ia4you;

import java.util.List;

interface Recomendador {
    /**
     * @param generos gêneros escolhidos no questionário (pode estar vazia)
     * @param evitar  títulos já sugeridos antes, para não repetir
     */
    List<Sugestao> sugerir(Categoria categoria, List<String> generos, List<String> evitar) throws Exception;
}
