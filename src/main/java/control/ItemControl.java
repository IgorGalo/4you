package control;

import dao.ItemDAO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Imagem;
import model.Item;

public class ItemControl {

    private Item ITEM;
    private ItemDAO itemdao = new ItemDAO();

    public void addItem(Vector<String> itens, String tipoItem) {
        itemdao.addItem(itens, tipoItem);
    }
    public void cadastraImagemItem(byte[] bytes, String nomeItem){
        itemdao.cadastrarImagemItem(bytes, nomeItem);
    }
    
    public ImageIcon consultaImagem(String nomeItem) {
        Imagem imagemBanco = itemdao.consultarImagem(nomeItem);

        if (imagemBanco != null) {
            ByteArrayInputStream bayts = new ByteArrayInputStream(imagemBanco.getImg());
            try {
                BufferedImage img = ImageIO.read(bayts);
                ImageIcon imgConvertida = new ImageIcon(img.getScaledInstance(189, 206, Image.SCALE_SMOOTH));
                return imgConvertida;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            return null;
        }
    }
    
    public int atualizaAvaliacao(int nota, String nomeItem){
        int notaConsultada = itemdao.consultaAvaliacao(nomeItem);
        int novaNota = (notaConsultada + nota)/2;
        
        itemdao.addAvaliacao(nomeItem, novaNota);
        
        return novaNota;
    }
}
