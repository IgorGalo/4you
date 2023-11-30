package control;

import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FramePrincipal;
import view.TelaInicio;

public class UsuarioControl {

    public Retornos cadastraUsuario(String nomeCompleto, String nomeUsuario, String senha, String email) {
        if (nomeCompleto.equalsIgnoreCase("") || nomeUsuario.equalsIgnoreCase("")
                || senha.equalsIgnoreCase("") || email.equalsIgnoreCase("")) {
            return Retornos.ERRODEPREENCHIMENTO;
        } else {
            Usuario dados = new Usuario();
            dados.setNomeCompleto(nomeCompleto);
            dados.setNomeUsuario(nomeUsuario);
            dados.setEmail(email);
            dados.setSenha(senha);

            UsuarioDAO sa = new UsuarioDAO();
            boolean cadastrou = sa.cadastrarUsuario(dados);

            if (!cadastrou) {
                return Retornos.ERRODECADASTRO;
            } else {
                return Retornos.OK;
            }
        }
    }
    
    public Retornos entrar(String nome, String senha, String nomeuser){
        Usuario filtro = new Usuario();
        if (nome.contains("@")) {
            filtro.setEmail(nome);
        } else {
            filtro.setNomeUsuario(nome.trim());
            filtro.getNomeUsuario();
            nomeuser = nome.trim();
            System.out.println(nomeuser);
        }
        filtro.setSenha(senha);

        UsuarioDAO servicos = new UsuarioDAO();
        Usuario resultado = servicos.consultarPorFiltro(filtro);

        if (resultado != null) {
            return Retornos.OK;
        } else {
            return Retornos.ERROLOGIN;
        }
    }
}
