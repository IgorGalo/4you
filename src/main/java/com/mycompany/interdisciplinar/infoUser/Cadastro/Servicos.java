package com.mycompany.interdisciplinar.infoUser.Cadastro;

import com.mycompany.interdisciplinar.dadosUsuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Servicos {
    
    public void cadastrarUsuario(Usuario dados) throws SQLException {

        Connection c = Conexao.obterConexao();

        String sql = "INSERT INTO fiyyou.USUARIO (NomeCompleto, NomeUsuario, Email, Senha)"
                + " VALUES (?, ?, ? , ?)";

        PreparedStatement insercao = c.prepareStatement(sql);
        
        insercao.setString(1, dados.getNomeCompleto());
        insercao.setString(2, dados.getNomeUsuario());
        insercao.setString(3, dados.getEmail());
        insercao.setString(4, dados.getSenha());
        insercao.executeQuery();
        c.close();
    }

}
