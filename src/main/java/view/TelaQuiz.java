/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author 0068948
 */
public class TelaQuiz extends javax.swing.JPanel {

    /**
     * Creates new form FLM
     */
    public TelaQuiz() {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaOpcao.png").getPath()));
            g.drawImage(imagem, 0, 0, this);

        } catch (IOException ex) {
            System.out.println("Arquivo não existente");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testeAntigoBtn = new javax.swing.JLabel();
        perfilBtn = new javax.swing.JLabel();
        inicioBtn = new javax.swing.JLabel();
        pesquisarBtn = new javax.swing.JLabel();
        novoTesteBtn = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        testeAntigoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        testeAntigoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testeAntigoBtnMouseClicked(evt);
            }
        });
        add(testeAntigoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 310, 60));

        perfilBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        perfilBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perfilBtnMouseClicked(evt);
            }
        });
        add(perfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 690, 60, 60));

        inicioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inicioBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioBtnMouseClicked(evt);
            }
        });
        add(inicioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 690, 70, 60));

        pesquisarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesquisarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisarBtnMouseClicked(evt);
            }
        });
        add(pesquisarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 690, 60, 60));

        novoTesteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        novoTesteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                novoTesteBtnMouseClicked(evt);
            }
        });
        add(novoTesteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 310, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void perfilBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilBtnMouseClicked
        FramePrincipal.trocaPainel("tela perfil", new TelaPerfil());
    }//GEN-LAST:event_perfilBtnMouseClicked

    private void inicioBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioBtnMouseClicked
        FramePrincipal.trocaPainel("tela inicio", new TelaInicio());
    }//GEN-LAST:event_inicioBtnMouseClicked

    private void pesquisarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarBtnMouseClicked
        FramePrincipal.trocaPainel("tela pesquisar", new TelaPesquisar());
    }//GEN-LAST:event_pesquisarBtnMouseClicked

    private void testeAntigoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testeAntigoBtnMouseClicked
        FramePrincipal.trocaPainel("tela testeAntigo", new TelaTesteAntigo());
    }//GEN-LAST:event_testeAntigoBtnMouseClicked

    private void novoTesteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novoTesteBtnMouseClicked
        FramePrincipal.trocaPainel("tela novoTeste", new TelaEscolhaFML());
    }//GEN-LAST:event_novoTesteBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel inicioBtn;
    private javax.swing.JLabel novoTesteBtn;
    private javax.swing.JLabel perfilBtn;
    private javax.swing.JLabel pesquisarBtn;
    private javax.swing.JLabel testeAntigoBtn;
    // End of variables declaration//GEN-END:variables
}
