package dao;

import tool.Conexao;
import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Usuario consultarPorFiltro(Usuario filtro) {
        try {
            Usuario retorno = new Usuario();
            Connection c = Conexao.obterConexao();

            String sql = "SELECT * FROM fiyyou.usuario ";
            if ((filtro.getNomeUsuario() != null && !filtro.getNomeUsuario().equalsIgnoreCase(""))
                    || (filtro.getEmail() != null && !filtro.getEmail().equalsIgnoreCase(""))
                    || (filtro.getSenha() != null && !filtro.getSenha().equalsIgnoreCase(""))) {
                sql += "WHERE ";
                boolean useiFiltro = false;
                if (filtro.getNomeUsuario() != null && !filtro.getNomeUsuario().equalsIgnoreCase("")) {
                    sql += "nomeusuario = '" + filtro.getNomeUsuario() + "' ";
                    useiFiltro = true;
                }
                if (filtro.getEmail() != null && !filtro.getEmail().equalsIgnoreCase("")) {
                    sql += "email = '" + filtro.getEmail() + "'";
                    useiFiltro = true;
                }
                if (filtro.getSenha() != null && !filtro.getSenha().equalsIgnoreCase("")) {
                    if (useiFiltro) {
                        sql += " AND ";
                    }
                    sql += "senha = '" + filtro.getSenha() + "'";
                    useiFiltro = true;
                }
            }
            System.out.println("Nossa isntrução SQL: " + sql);
            Statement consulta = c.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);

            c.close();
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(Servicos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage() + "Erro: ");
            return null;
        }
    }
}
