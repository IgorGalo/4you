/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.UsuarioControl;
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
        Icon imagemPerfilInicio = new ImageIcon("src\\main\\resources\\perfil.png");
        labelperfil.setIcon(imagemPerfilInicio);
        adicionarImagemDoBancoParaMudarIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        perfilLabel = new javax.swing.JLabel();
        editarPerfilBtn = new javax.swing.JButton();
        labelperfil = new javax.swing.JLabel();
        inicioBtn1 = new javax.swing.JButton();
        quizBtn = new javax.swing.JButton();
        pesqBtn = new javax.swing.JButton();
        perfilBtn = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(83, 41, 71));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 68, 190)));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 400));

        editarPerfilBtn.setBackground(new java.awt.Color(83, 41, 71));
        editarPerfilBtn.setForeground(new java.awt.Color(233, 68, 190));
        editarPerfilBtn.setText("Editar Perfil");
        editarPerfilBtn.setBorderPainted(false);
        editarPerfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPerfilBtnActionPerformed(evt);
            }
        });

        inicioBtn1.setBackground(new java.awt.Color(83, 41, 71));
        inicioBtn1.setForeground(new java.awt.Color(233, 68, 190));
        inicioBtn1.setText("🏠");
        inicioBtn1.setBorderPainted(false);
        inicioBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBtn1ActionPerformed(evt);
            }
        });

        quizBtn.setBackground(new java.awt.Color(83, 41, 71));
        quizBtn.setForeground(new java.awt.Color(233, 68, 190));
        quizBtn.setText("❔");
        quizBtn.setBorderPainted(false);
        quizBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizBtnActionPerformed(evt);
            }
        });

        pesqBtn.setBackground(new java.awt.Color(83, 41, 71));
        pesqBtn.setForeground(new java.awt.Color(233, 68, 190));
        pesqBtn.setText("🔎");
        pesqBtn.setBorderPainted(false);
        pesqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqBtnActionPerformed(evt);
            }
        });

        perfilBtn.setBackground(new java.awt.Color(83, 41, 71));
        perfilBtn.setForeground(new java.awt.Color(233, 68, 190));
        perfilBtn.setText("👤");
        perfilBtn.setBorderPainted(false);
        perfilBtn.setEnabled(false);
        perfilBtn.setMaximumSize(new java.awt.Dimension(31, 23));
        perfilBtn.setMinimumSize(new java.awt.Dimension(31, 23));
        perfilBtn.setPreferredSize(new java.awt.Dimension(31, 23));
        perfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(perfilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(inicioBtn1)
                        .addGap(88, 88, 88)
                        .addComponent(pesqBtn)
                        .addGap(94, 94, 94)
                        .addComponent(quizBtn)
                        .addGap(88, 88, 88)
                        .addComponent(perfilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editarPerfilBtn)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(76, 80, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(perfilLabel)
                .addGap(13, 13, 13)
                .addComponent(labelperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editarPerfilBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesqBtn)
                        .addComponent(quizBtn)
                        .addComponent(perfilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inicioBtn1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void perfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilBtnActionPerformed

    }//GEN-LAST:event_perfilBtnActionPerformed

    private void pesqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqBtnActionPerformed
        FramePrincipal.trocaPainel("painel pesquisar", new TelaPesquisar());
    }//GEN-LAST:event_pesqBtnActionPerformed

    private void quizBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizBtnActionPerformed
        FramePrincipal.trocaPainel("painel quiz", new TelaQuiz());
    }//GEN-LAST:event_quizBtnActionPerformed

    private void inicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBtn1ActionPerformed
        FramePrincipal.trocaPainel("painel inicio", new TelaInicio());
    }//GEN-LAST:event_inicioBtn1ActionPerformed
    public void adicionarImagemDoBancoParaMudarIcon() {

        UsuarioControl usuarioC = new UsuarioControl();

        ImageIcon imgConvertida = usuarioC.adicionarImagemDoBanco();

        if (imgConvertida == null) {

        } else {
            labelperfil.setIcon(imgConvertida);
        }
    }

    private void editarPerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPerfilBtnActionPerformed
        JFileChooser janelaArquivo = new JFileChooser();
        janelaArquivo.setFileFilter(new FileNameExtensionFilter("tipos de imagem", "PNG", "png", "JPEG", "jpeg", "JPG", "jpg"));
        TelaEntrar user = new TelaEntrar();

        int operacao = janelaArquivo.showSaveDialog(janelaArquivo);

        if (operacao == JFileChooser.APPROVE_OPTION) {
            usuarioC.editarPerfil(janelaArquivo);
            adicionarImagemDoBancoParaMudarIcon();
        }
    }//GEN-LAST:event_editarPerfilBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editarPerfilBtn;
    private javax.swing.JButton inicioBtn1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelperfil;
    private javax.swing.JButton perfilBtn;
    private javax.swing.JLabel perfilLabel;
    private javax.swing.JButton pesqBtn;
    private javax.swing.JButton quizBtn;
    // End of variables declaration//GEN-END:variables
}
