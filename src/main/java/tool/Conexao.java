package tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    
    private static String url = "jdbc:postgresql://200.18.128.56/aula";
    private static String usuario = "aula";
    private static String senha = "aula";

    private static Connection ifConexao;

    public static Connection obterConexao() {

        try {
            Class.forName("org.postgresql.Driver");

            ifConexao = DriverManager.getConnection(url, usuario, senha);
            //System.out.println("Deu certo!");
            return ifConexao;
        } catch (ClassNotFoundException ex) {
            System.out.println("Deu erro: classe não encontrada " + ex.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Deu erro: erro de sql " + ex.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
