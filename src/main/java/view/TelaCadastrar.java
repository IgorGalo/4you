package view;

import control.Retornos;
import control.UsuarioControl;
import dao.UsuarioDAO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.Imagem;
import model.Usuario;

public class TelaCadastrar extends javax.swing.JPanel {

    public TelaCadastrar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailTxt = new javax.swing.JTextField();
        usuarioTxt = new javax.swing.JTextField();
        senhaTxt = new javax.swing.JTextField();
        nomeTxt = new javax.swing.JTextField();
        conectarBtn = new javax.swing.JLabel();
        nextBtn = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailTxt.setBackground(new java.awt.Color(43, 24, 33));
        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(255, 255, 255));
        emailTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailTxt.setBorder(null);
        emailTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });
        add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 290, 60));

        usuarioTxt.setBackground(new java.awt.Color(43, 24, 33));
        usuarioTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usuarioTxt.setForeground(new java.awt.Color(255, 255, 255));
        usuarioTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuarioTxt.setBorder(null);
        usuarioTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuarioTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTxtActionPerformed(evt);
            }
        });
        add(usuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 290, 70));

        senhaTxt.setBackground(new java.awt.Color(43, 24, 33));
        senhaTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        senhaTxt.setForeground(new java.awt.Color(255, 255, 255));
        senhaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        senhaTxt.setBorder(null);
        senhaTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        senhaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaTxtActionPerformed(evt);
            }
        });
        add(senhaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 290, 60));

        nomeTxt.setBackground(new java.awt.Color(43, 24, 33));
        nomeTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTxt.setForeground(new java.awt.Color(255, 255, 255));
        nomeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeTxt.setBorder(null);
        nomeTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nomeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTxtActionPerformed(evt);
            }
        });
        add(nomeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 290, 60));

        conectarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conectarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conectarBtnMouseClicked(evt);
            }
        });
        add(conectarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 670, 100, 20));

        nextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextBtnMouseClicked(evt);
            }
        });
        add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 620, 290, 30));
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaCadastrar.png").getPath()));
            g.drawImage(imagem, 0, 0, this);

        } catch (IOException ex) {
            System.out.println("Arquivo não existente");
        }
    }
    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void usuarioTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTxtActionPerformed

    private void senhaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaTxtActionPerformed

    private void nextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseClicked
        UsuarioControl usuarioC = new UsuarioControl();

        Retornos resultado = usuarioC.cadastraUsuario(nomeTxt.getText(), usuarioTxt.getText(), senhaTxt.getText(), emailTxt.getText());

        if (resultado.isRetorno() == false) {
            JOptionPane.showMessageDialog(this, resultado.getMensagem());
        } else {
            FramePrincipal.trocaPainel("tela inicio", new TelaInicio());
        }

    }//GEN-LAST:event_nextBtnMouseClicked

    private void conectarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conectarBtnMouseClicked
        FramePrincipal.trocaPainel("tela entrar", new TelaEntrar());
    }//GEN-LAST:event_conectarBtnMouseClicked

    private void nomeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel conectarBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel nextBtn;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField senhaTxt;
    private javax.swing.JTextField usuarioTxt;
    // End of variables declaration//GEN-END:variables
}
