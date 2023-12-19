package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Item;
import tool.Conexao;

public class ItemDAO {

    Connection c = Conexao.obterConexao();

    public ArrayList<Item> buscaItens(String texto) {
        String sql = "SELECT * FROM public.itens WHERE nomedoitem ILIKE '" + texto + "%'";
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

}
