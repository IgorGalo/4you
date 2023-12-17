package view;

public class TelaEscolhaFML extends javax.swing.JPanel {

    public TelaEscolhaFML() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        musicaBtn = new javax.swing.JLabel();
        filmeBtn = new javax.swing.JLabel();
        livroBtn = new javax.swing.JLabel();
        perfilBtn = new javax.swing.JLabel();
        inicioBtn = new javax.swing.JLabel();
        pesquisarBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        musicaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                musicaBtnMouseClicked(evt);
            }
        });
        add(musicaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 200, 80));

        filmeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filmeBtnMouseClicked(evt);
            }
        });
        add(filmeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, 210, 80));

        livroBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                livroBtnMouseClicked(evt);
            }
        });
        add(livroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 200, 80));

        perfilBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perfilBtnMouseClicked(evt);
            }
        });
        add(perfilBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 690, 60, 60));

        inicioBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioBtnMouseClicked(evt);
            }
        });
        add(inicioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 690, 70, 60));

        pesquisarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesquisarBtnMouseClicked(evt);
            }
        });
        add(pesquisarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 690, 60, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telaFML.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
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

    private void musicaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musicaBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Musica", new TelaPerguntas(2));
    }//GEN-LAST:event_musicaBtnMouseClicked

    private void filmeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filmeBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Filme", new TelaPerguntas(1));
    }//GEN-LAST:event_filmeBtnMouseClicked

    private void livroBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_livroBtnMouseClicked
        FramePrincipal.trocaPainel("tela perguntas Livro", new TelaPerguntas(3));
    }//GEN-LAST:event_livroBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel filmeBtn;
    private javax.swing.JLabel inicioBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel livroBtn;
    private javax.swing.JLabel musicaBtn;
    private javax.swing.JLabel perfilBtn;
    private javax.swing.JLabel pesquisarBtn;
    // End of variables declaration//GEN-END:variables
}
