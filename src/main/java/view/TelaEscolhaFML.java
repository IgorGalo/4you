package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaEscolhaFML extends javax.swing.JPanel {

    public TelaEscolhaFML() {
        initComponents();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaFML.png").getPath()));
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
        voltarBtn = new javax.swing.JLabel();

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

        voltarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarBtnMouseClicked(evt);
            }
        });
        add(voltarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 70));
    }// </editor-fold>//GEN-END:initComponents

    private void musicaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicaBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Musica", new TelaPerguntas(2, 1));
    }//GEN-LAST:event_musicaBtnMouseClicked

    private void filmeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filmeBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Filme", new TelaPerguntas(1, 1));
    }//GEN-LAST:event_filmeBtnMouseClicked

    private void livroBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_livroBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Livro", new TelaPerguntas(3, 1));
    }//GEN-LAST:event_livroBtnMouseClicked

    private void voltarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarBtnMouseClicked
        FramePrincipal.trocaPainel("tela quiz", new TelaQuiz());
    }//GEN-LAST:event_voltarBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel filmeBtn;
    private javax.swing.JLabel livroBtn;
    private javax.swing.JLabel musicaBtn;
    private javax.swing.JLabel voltarBtn;
    // End of variables declaration//GEN-END:variables
}
