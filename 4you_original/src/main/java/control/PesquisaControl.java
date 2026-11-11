package control;
import dao.ItemDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;
import model.Item;
import model.Usuario;

public class PesquisaControl {
    
    private UsuarioDAO sa;
    private ItemDAO iDAO;

//Construtor
    public PesquisaControl() {
        this.sa = new UsuarioDAO();
        this.iDAO = new ItemDAO();
    }
    
//Relaciona a interface com a pesquisa dos usuários da aplicação    
    public ArrayList<Usuario> pesquisaUsuarios(String texto) {
        return this.sa.buscaUsuarios(texto);
    }
    
//Relaciona a interface com a pesquisa dos itens da aplicação    
    public ArrayList<Item> pesquisaItens(String texto) {
        return this.iDAO.buscaItens(texto);
    }
}
