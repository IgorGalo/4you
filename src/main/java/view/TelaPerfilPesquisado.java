package view;

import control.UsuarioControl;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class TelaPerfilPesquisado extends javax.swing.JPanel {

    private String nomePesquisado;

    public TelaPerfilPesquisado(String nomePesquisado) {
        initComponents();
        this.nomePesquisado = nomePesquisado;
        trocaNome();
        adicionarImagemDoBanco();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaOutroPerfil.png").getPath()));
            g.drawImage(imagem, 0, 0, this);

        } catch (IOException ex) {
            System.out.println("Arquivo não existente");
        }
    }

    private void trocaNome() {
        nomeLbl.setText(this.nomePesquisado);
    }

    private void adicionarImagemDoBanco() {
                
        UsuarioControl usuarioC = new UsuarioControl();

        ImageIcon imgConvertida = usuarioC.adicionarImagemDoBanco();

        if (imgConvertida == null) {

        } else {
            labelperfil.setIcon(imgConvertida);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLbl = new javax.swing.JLabel();
        labelperfil = new javax.swing.JLabel();
        perfilBtn = new javax.swing.JLabel();
        quizBtn = new javax.swing.JLabel();
        inicioBtn = new javax.swing.JLabel();
        pesquisarBtn = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomeLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeLbl.setForeground(new java.awt.Color(255, 255, 255));
        nomeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeLbl.setText("NOME DE USUÁRIO");
        nomeLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(nomeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 230, 50));

        labelperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/labelPerfil.png"))); // NOI18N
        add(labelperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        perfilBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        perfilBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perfilBtnMouseClicked(evt);
            }
        });
        add(perfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 690, 60, 60));

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
    }// </editor-fold>//GEN-END:initComponents

    private void perfilBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilBtnMouseClicked
        FramePrincipal.trocaPainel("tela perfil", new TelaPerfil());
    }//GEN-LAST:event_perfilBtnMouseClicked

    private void quizBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quizBtnMouseClicked
        FramePrincipal.trocaPainel("tela quiz", new TelaEscolhaFML());
    }//GEN-LAST:event_quizBtnMouseClicked

    private void inicioBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioBtnMouseClicked
        FramePrincipal.trocaPainel("tela inicio", new TelaInicio());
    }//GEN-LAST:event_inicioBtnMouseClicked

    private void pesquisarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesquisarBtnMouseClicked
        FramePrincipal.trocaPainel("tela pesquisar", new TelaPesquisar());
    }//GEN-LAST:event_pesquisarBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel inicioBtn;
    private javax.swing.JLabel labelperfil;
    private javax.swing.JLabel nomeLbl;
    private javax.swing.JLabel perfilBtn;
    private javax.swing.JLabel pesquisarBtn;
    private javax.swing.JLabel quizBtn;
    // End of variables declaration//GEN-END:variables

}
