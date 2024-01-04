package dao;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.Imagem;
import model.Item;
import model.Usuario;
import tool.Conexao;

//SQLs de inserção, consulta e update no banco
public class ItemDAO {

    Connection c = Conexao.obterConexao();

    public ArrayList<Item> buscaItens(String texto) {
        String sql = "SELECT * FROM fiyyou.itens WHERE nomedoitem ILIKE '" + texto + "%'";
        ArrayList<Item> todosItens = new ArrayList<>();

        try (PreparedStatement trans = this.c.prepareStatement(sql)) {
            ResultSet resultadoBanco = trans.executeQuery();
            while (resultadoBanco.next()) {
                Item item = new Item(resultadoBanco.getInt("avaliacao"),
                        resultadoBanco.getString("tipoItem"),
                        resultadoBanco.getString("nomedoitem"),
                        resultadoBanco.getString("comentario"));

                todosItens.add(item);
            }
            return todosItens;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosItens;
    }

    public void addItemDAO(Vector<String> itens, String tipoItem) {
        int qtd = itens.size();

        String sql = "INSERT INTO fiyyou.itens (nomedoitem, avaliacao, tipoitem, comentario) "
                + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement insercao = this.c.prepareStatement(sql)) {

            for (int i = 0; i < qtd; i++) {
                insercao.setString(1, itens.get(i));
                insercao.setInt(2, 0);
                insercao.setString(3, tipoItem);
                insercao.setString(4, "");
                insercao.execute();
                System.out.println("teste");
            }
            c.close();

        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage() + " ");
        }
    }

    public boolean addAvaliacao(String nomeItem, int novaAvaliacao) {
        String sql = "UPDATE fiyyou.itens SET avaliacao = ? WHERE nomedoItem = ?;";
        try (PreparedStatement insercao = this.c.prepareStatement(sql)) {
            insercao.setInt(1, novaAvaliacao);
            insercao.setString(2, nomeItem);
            insercao.execute();
            c.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Imagem consultarImagem(String nomeItem) {
        try {
            Imagem retorno = null;

            String sql = "SELECT * FROM fiyyou.imageitem WHERE ";

            if (nomeItem != null && !nomeItem.equalsIgnoreCase("")) {
                sql += "nomeitem = '" + nomeItem.trim() + "'";

            }

            Statement consulta = this.c.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);

            c.close();
            if (resultado.next()) {
                retorno = new Imagem(resultado.getBytes("imagem"));
            }
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage() + "Erro: ");
            return null;
        }
    }

    public Vector<Imagem> consultarTodasImagensItens() {
        try {
            Vector<Imagem> retorno = null;

            String sql = "SELECT * FROM fiyyou.imageitem";

            Statement consulta = this.c.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);

            c.close();
            while (resultado.next()) {
                retorno.add(new Imagem(resultado.getBytes("imagem")));
            }
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage() + "Erro: ");
            return null;
        }
    }

    public boolean consultaNomeItem(String nomeItem) {

        String sql = "SELECT * FROM fiyyou.itens WHERE nomedoitem = '" + nomeItem + "'";

        try (PreparedStatement trans = this.c.prepareStatement(sql)) {
            ResultSet resultadoBanco = trans.executeQuery();
            if (resultadoBanco.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public int consultaAvaliacao(String nomeItem) {

        String sql = "SELECT avaliacao FROM fiyyou.itens WHERE nomedoitem = '" + nomeItem + "'";

        try (PreparedStatement trans = this.c.prepareStatement(sql)) {
            ResultSet resultadoBanco = trans.executeQuery();
            if (resultadoBanco.next()) {
                return resultadoBanco.getInt("avaliacao");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public Vector<Item> consultaItens() {

        Vector<Item> nomeItens = new Vector<>();

        String sql = "SELECT * FROM fiyyou.itens";

        try (PreparedStatement trans = this.c.prepareStatement(sql)) {
            ResultSet resultadoBanco = trans.executeQuery();
            while (resultadoBanco.next()) {
                Item item = new Item(resultadoBanco.getInt("avaliacao"), resultadoBanco.getString("tipoitem"),
                        resultadoBanco.getString("nomedoitem"), resultadoBanco.getString("comentario"));
                nomeItens.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomeItens;
    }

    public void cadastrarImagemItem(byte[] bytes, String nomeItem) {

        ByteArrayInputStream byteinput = new ByteArrayInputStream(bytes);

        String sql = "INSERT INTO fiyyou.imageitem (nomeitem, imagem)"
                + " VALUES (?, ?)";
        try {
            PreparedStatement insercao = this.c.prepareStatement(sql);
            insercao.setString(1, nomeItem);
            insercao.setBinaryStream(2, byteinput, (int) bytes.length);
            insercao.execute();
            c.close();

        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }

    }

}
