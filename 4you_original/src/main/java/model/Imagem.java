package model;

//Parâmetros para o funcionamento de uma imagem 

public class Imagem {

    private byte[] img;

    public Imagem(byte[] img) {
        this.img = img;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

}
