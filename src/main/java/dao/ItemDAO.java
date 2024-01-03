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
import javax.swing.Icon;
import model.Imagem;
import model.Item;
import model.Usuario;
import tool.Conexao;

public class ItemDAO {

    Connection c = Conexao.obterConexao();

    public ArrayList<Item> buscaItens(String texto) {
        String sql = "SELECT * FROM fiyyou.itens WHERE nomedoitem ILIKE '" + texto + "%'";
        ArrayList<Item> todosItens = new ArrayList<>();

        try (PreparedStatement trans = this.c.prepareStatement(sql)) {
            //vamos ao banco buscar os dados resultado da sql definida
            ResultSet resultadoBanco = trans.executeQuery();
            //transformr as tuplas(linhas) em objetos do tipo statustime
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

    public boolean addItemDAO(Vector<String> itens, String tipoItem) {
        String sql = "INSERT INTO fiyyou.itens (nomedoitem, tipoitem, avaliacao, comentario)"
                + " VALUES (?, ?, ?, ?)";
        System.out.println("passou");
        try {
            PreparedStatement insercao = c.prepareStatement(sql);
            for (int i = 0; i < itens.size(); i++) {
                insercao.setString(1, itens.get(i));
                insercao.setString(2, tipoItem);
                insercao.setInt(3, 0);
                insercao.setString(4, "");

                insercao.execute();
            }
            c.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean addAvaliacao(String nomeItem, int novaAvaliacao) {
        String sql = "UPDATE fiyyou.itens SET avaliacao = ? WHERE nomedoItem = ?;";
        try (PreparedStatement insercao = c.prepareStatement(sql);) {
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

            String sql = "SELECT * FROM fiyyou.imagens WHERE ";

            if (nomeItem != null && !nomeItem.equalsIgnoreCase("")) {
                sql += "nomeusuario = '" + nomeItem.trim() + "'";

            }

            Statement consulta = c.createStatement();
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

    public int consultaAvaliacao(String nomeItem) {

        String sql = "SELECT avaliacao FROM fiyyou.itens WHERE nomedoitem = '" + nomeItem + "'";

        try (PreparedStatement trans = this.c.prepareStatement(sql)) {
            //vamos ao banco buscar os dados resultado da sql definida
            ResultSet resultadoBanco = trans.executeQuery();
            if (resultadoBanco.next()) {
                return resultadoBanco.getInt("avaliacao");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
    
    public Vector<String> consultaItens() {
        
        Vector<String> nomeItens = new Vector<>();
        
        String sql = "SELECT * FROM fiyyou.itens";

        try (PreparedStatement trans = this.c.prepareStatement(sql)) {
            ResultSet resultadoBanco = trans.executeQuery();
            while (resultadoBanco.next()) {
                Item item = new Item(resultadoBanco.getInt("avaliacao"), resultadoBanco.getString("tipoitem"),
                        resultadoBanco.getString("nomedoitem"), resultadoBanco.getString("comentario"));
                nomeItens.add(resultadoBanco.getString("nomedoitem"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomeItens;
    }
    
    public boolean cadastrarImagemItem(byte[] bytes, String nomeItem) {

        ByteArrayInputStream byteinput = new ByteArrayInputStream(bytes);

        String sql = "INSERT INTO fiyyou.imageitem (nomeitem, imagem)"
                + " VALUES (?, ?)";
        //File arquivo = new File(arq);

        //fis = new FileInputStream(arquivo);
        try {
            PreparedStatement insercao = c.prepareStatement(sql);

            insercao.setString(1, nomeItem);
            insercao.setBinaryStream(2, byteinput, (int) bytes.length);
            insercao.execute();
            c.close();
            return true;

        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
            return false;
        }

    }

}
