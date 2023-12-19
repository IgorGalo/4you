package control;
import dao.ItemDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;
import model.Item;
import model.Usuario;

public class PesquisaControl {
    
    private UsuarioDAO sa;
    private ItemDAO iDAO;

    public PesquisaControl() {
        this.sa = new UsuarioDAO();
        this.iDAO = new ItemDAO();
    }
    
    public ArrayList<Usuario> pesquisaUsuarios(String texto) {
        return this.sa.buscaUsuarios(texto);
    }
    
    public ArrayList<Item> pesquisaItens(String texto) {
        return this.iDAO.buscaItens(texto);
    }
}
