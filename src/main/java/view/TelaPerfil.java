/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.UsuarioControl;
import dao.UsuarioDAO;
import java.awt.Graphics;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Imagem;

public class TelaPerfil extends javax.swing.JPanel {

    private UsuarioControl usuarioC = new UsuarioControl();
    private UsuarioDAO sa = new UsuarioDAO();

    public TelaPerfil() {
        initComponents();
        Icon imagemPerfilInicio = new ImageIcon("src\\main\\resources\\labelperfil.png");
        labelperfil.setIcon(imagemPerfilInicio);
        adicionarImagemDoBancoParaMudarIcon();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaPerfil.png").getPath()));
            g.drawImage(imagem, 0, 0, this);

        } catch (IOException ex) {
            System.out.println("Arquivo não existente");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alteraBtn = new javax.swing.JLabel();
        quizBtn = new javax.swing.JLabel();
        inicioBtn = new javax.swing.JLabel();
        pesquisarBtn = new javax.swing.JLabel();
        labelperfil = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alteraBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alteraBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alteraBtnMouseClicked(evt);
            }
        });
        add(alteraBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 250, 50));

        quizBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quizBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quizBtnMouseClicked(evt);
            }
        });
        add(quizBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 690, 70, 60));

        inicioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicioBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioBtnMouseClicked(evt);
            }
        });
        add(inicioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 690, 50, 60));

        pesquisarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesquisarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisarBtnMouseClicked(evt);
            }
        });
        add(pesquisarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 690, 60, 60));

        labelperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labelPerfil.png"))); // NOI18N
        add(labelperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, 280));
    }// </editor-fold>//GEN-END:initComponents

    private void quizBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quizBtnMouseClicked
        FramePrincipal.trocaPainel("tela escolhaFML", new TelaEscolhaFML());
    }//GEN-LAST:event_quizBtnMouseClicked

    private void inicioBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioBtnMouseClicked
        FramePrincipal.trocaPainel("tela inicio", new TelaInicio());
    }//GEN-LAST:event_inicioBtnMouseClicked

    private void pesquisarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarBtnMouseClicked
        FramePrincipal.trocaPainel("tela pesquisar", new TelaPesquisar());
    }//GEN-LAST:event_pesquisarBtnMouseClicked

    private void alteraBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alteraBtnMouseClicked
        JFileChooser janelaArquivo = new JFileChooser();
        janelaArquivo.setFileFilter(new FileNameExtensionFilter("tipos de imagem", "PNG", "png", "JPEG", "jpeg", "JPG", "jpg"));
        TelaEntrar user = new TelaEntrar();

        int operacao = janelaArquivo.showSaveDialog(janelaArquivo);

        if (operacao == JFileChooser.APPROVE_OPTION) {
            usuarioC.editarPerfil(janelaArquivo);
            adicionarImagemDoBancoParaMudarIcon();
        }
    }//GEN-LAST:event_alteraBtnMouseClicked
    public void adicionarImagemDoBancoParaMudarIcon() {

        UsuarioControl usuarioC = new UsuarioControl();

        ImageIcon imgConvertida = usuarioC.adicionarImagemDoBanco();

        if (imgConvertida == null) {

        } else {
            labelperfil.setIcon(imgConvertida);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alteraBtn;
    private javax.swing.JLabel inicioBtn;
    private javax.swing.JLabel labelperfil;
    private javax.swing.JLabel pesquisarBtn;
    private javax.swing.JLabel quizBtn;
    // End of variables declaration//GEN-END:variables
}
