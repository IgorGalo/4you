package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;

public class TelaEscolhaFML extends javax.swing.JPanel {
    private Vector<Integer> botaoSel = new Vector<>();
    
    public TelaEscolhaFML() {
        initComponents();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaEscolhaFML.png").getPath()));
            g.drawImage(imagem, 0, 0, this);

        } catch (IOException ex) {
            System.out.println("Arquivo não existente");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        musicaBtn = new javax.swing.JLabel();
        filmeBtn = new javax.swing.JLabel();
        livroBtn = new javax.swing.JLabel();
        perfilBtn = new javax.swing.JLabel();
        iniciopBtn = new javax.swing.JLabel();
        pesquisarBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        musicaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        musicaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musicaBtnMouseClicked(evt);
            }
        });
        add(musicaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 200, 80));

        filmeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filmeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filmeBtnMouseClicked(evt);
            }
        });
        add(filmeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, 210, 80));

        livroBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        livroBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                livroBtnMouseClicked(evt);
            }
        });
        add(livroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 200, 80));

        perfilBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        perfilBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perfilBtnMouseClicked(evt);
            }
        });
        add(perfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 690, 60, 60));

        iniciopBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciopBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciopBtnMouseClicked(evt);
            }
        });
        add(iniciopBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 690, 70, 60));

        pesquisarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesquisarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisarBtnMouseClicked(evt);
            }
        });
        add(pesquisarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 690, 60, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telaEscolhaFML.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void musicaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicaBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Musica", new TelaPerguntas(3, 1, botaoSel));
    }//GEN-LAST:event_musicaBtnMouseClicked

    private void filmeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filmeBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Filme", new TelaPerguntas(1, 1, botaoSel));
    }//GEN-LAST:event_filmeBtnMouseClicked

    private void livroBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_livroBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Livro", new TelaPerguntas(2, 1, botaoSel));
    }//GEN-LAST:event_livroBtnMouseClicked

    private void perfilBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilBtnMouseClicked
        FramePrincipal.trocaPainel("tela perfil", new TelaPerfil());
    }//GEN-LAST:event_perfilBtnMouseClicked

    private void iniciopBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciopBtnMouseClicked
        FramePrincipal.trocaPainel("tela inicio", new TelaInicio());
    }//GEN-LAST:event_iniciopBtnMouseClicked

    private void pesquisarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarBtnMouseClicked
        FramePrincipal.trocaPainel("tela pesquisar", new TelaPesquisar());
    }//GEN-LAST:event_pesquisarBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel filmeBtn;
    private javax.swing.JLabel iniciopBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel livroBtn;
    private javax.swing.JLabel musicaBtn;
    private javax.swing.JLabel perfilBtn;
    private javax.swing.JLabel pesquisarBtn;
    // End of variables declaration//GEN-END:variables
}
