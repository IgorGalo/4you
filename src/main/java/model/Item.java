package model;

public class Item {
    
    private int IDitem;
    private String tipoItem;
    private String nomeItem;
    private String descricao;
    private String categoria;
    private int avaliacao;

    public Item(int IDitem, String tipoItem, String nomeItem, String descricao, String categoria, int avaliacao) {
        this.IDitem = IDitem;
        this.tipoItem = tipoItem;
        this.nomeItem = nomeItem;
        this.descricao = descricao;
        this.categoria = categoria;
        this.avaliacao = avaliacao;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
