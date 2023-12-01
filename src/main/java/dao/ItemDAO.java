package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Item;
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
                        resultadoBanco.getString("tipoitem"), 
                        resultadoBanco.getString("nomeDoItem"), 
                        resultadoBanco.getString("descricao"), 
                        resultadoBanco.getString("categoria"), 
                        resultadoBanco.getInt("avaliacao"));
                      
                todosItens.add(item);
            }

        } catch (SQLException ex) {

            System.out.println("erro na execucao do select");
        }
        return todosItens;

    }
    
}
