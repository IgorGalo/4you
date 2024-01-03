package model;

public class Item {
    
    private String tipoItem;
    private String nomeItem;
    private String comentario;
    private int avaliacao;

    public Item(int avaliacao, String tipoItem, String nomedoItem, String comentario) {
        this.tipoItem = tipoItem;
        this.nomeItem = nomedoItem;
        this.comentario = comentario;
        this.avaliacao = avaliacao;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return this.nomeItem + " - " + this.tipoItem;
    }
}
