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

//Relaciona a interface com o banco de dados para adicionar um item nele
    public void addItem(Vector<String> itens, String tipoItem) {
        boolean veri;
        for (int i = 0; i < 3; i++) {
            veri = itemdao.consultaNomeItem(itens.get(i));
            itens.remove(i);
        }
        itemdao.addItemDAO(itens, tipoItem);
    }

//Relaciona a interface com o banco de dados para consultar um item dele
    public Vector<Item> consultaNomesItens() {
        Vector<Item> vetNome = itemdao.consultaItens();

        return vetNome;
    }

//Relaciona a interface com o banco de dados para cadastrar a imagem de um item no banco
    public void cadastraImagemItem(byte[] bytes, String nomeItem) {
        boolean veri;
        for (int i = 0; i < 3; i++) {
            if (!itemdao.consultaNomeItem(nomeItem)) {
                itemdao.cadastrarImagemItem(bytes, nomeItem);
            }
        }
    }

//Relaciona a interface com o banco de dados para consultar a imagem de um item do banco
    public Icon consultaImagem(String nomeItem) {
        Imagem imagemBanco = itemdao.consultarImagem(nomeItem);

        if (imagemBanco != null) {
            ByteArrayInputStream bayts = new ByteArrayInputStream(imagemBanco.getImg());
            try {
                BufferedImage img = ImageIO.read(bayts);
                ImageIcon imgIcon = new ImageIcon(img.getScaledInstance(189, 206, Image.SCALE_SMOOTH));
                Icon icon = imgIcon;
                return icon;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            return null;
        }
    }

//Relaciona a interface com o banco de dados para atualizar a avaliação de um item no banco
    public int atualizaAvaliacao(int nota, String nomeItem) {

        int notaConsultada = itemdao.consultaAvaliacao(nomeItem);
        int novaNota = (notaConsultada + nota) / 2;

        itemdao.addAvaliacao(nomeItem, novaNota);

        return novaNota;
    }
}
