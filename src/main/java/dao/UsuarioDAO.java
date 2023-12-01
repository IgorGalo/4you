package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import tool.Conexao;
import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Imagem;

public class UsuarioDAO {

    static String user;
    Connection c = Conexao.obterConexao();

    public boolean cadastrarUsuario(Usuario dados) {

        String sql = "INSERT INTO fiyyou.USUARIO (NomeCompleto, NomeUsuario, Email, Senha)"
                + " VALUES (?, ?, ? , ?)";

        try {
            PreparedStatement insercao = c.prepareStatement(sql);

            insercao.setString(1, dados.getNomeCompleto());
            insercao.setString(2, dados.getNomeUsuario());

            insercao.setString(3, dados.getEmail());
            insercao.setString(4, dados.getSenha());
            insercao.execute();
            c.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean cadastrarImagem(Imagem dados, String arq) {

        FileInputStream fis = null;
        try {

            String sql = "INSERT INTO fiyyou.IMAGENS (nomeusuario, imagem)"
                    + " VALUES (?, ?)";
            File arquivo = new File(arq);
            fis = new FileInputStream(arquivo);
            try {
                PreparedStatement insercao = c.prepareStatement(sql);

                insercao.setString(1, user);
                insercao.setBinaryStream(2, fis, (int) arquivo.length());
                //insercao.setBytes(2, dados.getImg());
                //insercao.setBytes(2, dados.getImg());
                insercao.execute();
                c.close();
                return true;

            } catch (SQLException ex) {
                System.out.println("" + ex.getMessage());
                return false;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("" + ex.getMessage());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Usuario consultarPorFiltro(Usuario filtro) {
        try {
            Usuario retorno = null;

            String sql = "SELECT * FROM fiyyou.usuario ";
            if ((filtro.getNomeUsuario() != null && !filtro.getNomeUsuario().equalsIgnoreCase(""))
                    || (filtro.getEmail() != null && !filtro.getEmail().equalsIgnoreCase(""))
                    && (filtro.getSenha() != null && !filtro.getSenha().equalsIgnoreCase(""))) {
                sql += "WHERE ";
                boolean useiFiltro = false;
                if (filtro.getNomeUsuario() != null && !filtro.getNomeUsuario().equalsIgnoreCase("")) {
                    sql += "nomeusuario = '" + filtro.getNomeUsuario().trim() + "'";
                    useiFiltro = true;

                    user = filtro.getNomeUsuario();
                }
                if (filtro.getEmail() != null && !filtro.getEmail().equalsIgnoreCase("")) {
                    sql += "email = '" + filtro.getEmail().trim() + "'";
                    useiFiltro = true;

                    user = filtro.getEmail();
                }
                if (filtro.getSenha() != null && !filtro.getSenha().equalsIgnoreCase("")) {
                    if (useiFiltro) {
                        sql += " AND ";
                    }
                    sql += "senha = '" + filtro.getSenha().trim() + "'";
                    useiFiltro = true;
                }
            }
            Statement consulta = c.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);

            c.close();
            if (resultado.next()) {
                retorno = new Usuario(resultado.getString("nomeusuario"));
            }
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage() + "Erro: ");
            return null;
        }
    }

    public Imagem consultarImagem() {
        try {
            Imagem retorno = null;

            String sql = "SELECT * FROM fiyyou.imagens WHERE ";

            if (user != null && !user.equalsIgnoreCase("")) {
                sql += "nomeusuario = '" + user.trim() + "'";

            }

            Statement consulta = c.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);

            c.close();
            if (resultado.next()) {
                retorno = new Imagem(resultado.getBytes("imagem"));
            }
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage() + "Erro: ");
            return null;
        }
    }

    public boolean deletaImagem() {
        boolean retorno = false;

        String sql = "DELETE FROM fiyyou.imagens WHERE nomeusuario = ?";
        try (PreparedStatement delete = c.prepareCall(sql)) {
            delete.setString(1, user.trim());
            delete.execute();
            retorno = true;
        } catch (SQLException ex) {
            System.out.println("Erro ao apagar imagem do banco;" + ex.getMessage());
            retorno = false;
        }
        return retorno;
    }
    
    public ArrayList<Usuario> buscaUsuarios(String texto) {
        String sql = "SELECT * FROM fiyyou.usuario WHERE nomeusuario LIKE '" + texto + "%'";
        
        ArrayList<Usuario> todosUsuarios = new ArrayList<>();
        try (PreparedStatement trans = this.c.prepareStatement(sql)) {
            //vamos ao banco buscar os dados resultado da sql definida
            ResultSet resultadoBanco = trans.executeQuery();

            //transformr as tuplas(linhas) em objetos do tipo statustime
            while (resultadoBanco.next()) {
                Usuario usuario = new Usuario(resultadoBanco.getInt("idusuario"),
                        resultadoBanco.getString("nomecompleto"),
                        resultadoBanco.getString("nomeusuario"),
                        resultadoBanco.getString("email"),
                        resultadoBanco.getString("senha"));
                todosUsuarios.add(usuario);
            }

        } catch (SQLException ex) {

            System.out.println("erro na execucao do select");
        }
        return todosUsuarios;

    }
}
