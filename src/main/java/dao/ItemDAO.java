package dao;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
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
                Item item = new Item(resultadoBanco.getInt("iditem"),
                        resultadoBanco.getInt("avaliacao"),
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

    public boolean addItem(Vector<String> itens, String tipoItem) {
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
        ArrayList<Item> item = buscaItens(nomeItem);

        String sql = " ";
        return true;
    }
    
    public boolean cadastrarImagemItem(byte[] bytes, String nomeItem) {

        ByteArrayInputStream byteinput = new ByteArrayInputStream(bytes);

        String sql = "INSERT INTO fiyyou.itens (nomeusuario, imagem)"
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
