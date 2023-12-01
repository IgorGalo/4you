package control;

import dao.UsuarioDAO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Imagem;
import model.Usuario;
import view.FramePrincipal;
import view.TelaEntrar;
import view.TelaInicio;
import view.TelaPerfil;

public class UsuarioControl {

    private Usuario dados = new Usuario();
    private UsuarioDAO sa = new UsuarioDAO();

    public Retornos cadastraUsuario(String nomeCompleto, String nomeUsuario, String senha, String email) {
        if (nomeCompleto.equalsIgnoreCase("") || nomeUsuario.equalsIgnoreCase("")
                || senha.equalsIgnoreCase("") || email.equalsIgnoreCase("")) {
            return Retornos.ERRODEPREENCHIMENTO;
        } else {

            dados.setNomeCompleto(nomeCompleto);
            dados.setNomeUsuario(nomeUsuario);
            dados.setEmail(email);
            dados.setSenha(senha);

            boolean cadastrou = sa.cadastrarUsuario(dados);

            if (!cadastrou) {
                return Retornos.ERRODECADASTRO;
            } else {
                return Retornos.OK;
            }
        }
    }

    public Retornos entrar(String nome, String senha, String nomeuser) {
        if (nome.contains("@")) {
            dados.setEmail(nome);
        } else {
            dados.setNomeUsuario(nome.trim());
            dados.getNomeUsuario();
            nomeuser = nome.trim();
            System.out.println(nomeuser);
        }
        dados.setSenha(senha);

        Usuario resultado = sa.consultarPorFiltro(dados);

        if (resultado != null) {
            return Retornos.OK;
        } else {
            return Retornos.ERROLOGIN;
        }
    }

    public ImageIcon adicionarImagemDoBanco() {
        UsuarioDAO servicos = new UsuarioDAO();
        Imagem imagemBanco = servicos.consultarImagem();

        if (imagemBanco != null) {
            ByteArrayInputStream bais = new ByteArrayInputStream(imagemBanco.getImg());
            try {
                BufferedImage img = ImageIO.read(bais);
                ImageIcon imgConvertida = new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                return imgConvertida;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            return null;
        }
    }

    public byte[] converterImagemParaByte(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        byte[] bytes = bos.toByteArray();

        return bytes;
    }

    public Image cadastrarImagem(Imagem imgembyte, String endereco, File arquivo) {

        sa.cadastrarImagem(imgembyte, endereco);

        BufferedImage img = null;
        try {
            img = ImageIO.read(arquivo);
            Image imgFinal = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            return imgFinal;
        } catch (IOException ex) {
            Logger.getLogger(TelaPerfil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void editarPerfil(JFileChooser janelaArquivo) {

        try {
            File arquivo = janelaArquivo.getSelectedFile();
            String endereco = arquivo.getPath();
            System.out.println(endereco);

            byte[] byteImage = converterImagemParaByte(new File(endereco));

            Imagem imgembyte = new Imagem(byteImage);

            UsuarioDAO sa = new UsuarioDAO();
            Imagem retorno = sa.consultarImagem();
            if (retorno == null) {
                cadastrarImagem(imgembyte, endereco, arquivo);
            } else {
                sa.deletaImagem();
                cadastrarImagem(imgembyte, endereco, arquivo);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
