package control;

import dao.ItemDAO;
import java.util.Vector;
import javax.swing.Icon;
import model.Item;

public class ItemControl {

    private Item ITEM;
    private ItemDAO itemdao = new ItemDAO();

    public void addItem(Vector<String> itens, String tipoItem) {
        itemdao.addItem(itens, tipoItem);
    }
}
