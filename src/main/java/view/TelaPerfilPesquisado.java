package view;

import control.UsuarioControl;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TelaPerfilPesquisado extends javax.swing.JPanel {

    private String nomePesquisado;

    public TelaPerfilPesquisado(String nomePesquisado) {
        initComponents();
        this.nomePesquisado = nomePesquisado;
        trocaNome();
        adicionarImagemDoBanco();
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

        jPanel4 = new javax.swing.JPanel();
        perfilLabel = new javax.swing.JLabel();
        labelperfil = new javax.swing.JLabel();
        inicioBtn1 = new javax.swing.JButton();
        quizBtn = new javax.swing.JButton();
        pesqBtn = new javax.swing.JButton();
        perfilBtn = new javax.swing.JButton();
        nomeLbl = new javax.swing.JLabel();
        voltarBtn = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(83, 41, 71));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 68, 190)));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 400));

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
        pesqBtn.setEnabled(false);
        pesqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqBtnActionPerformed(evt);
            }
        });

        perfilBtn.setBackground(new java.awt.Color(83, 41, 71));
        perfilBtn.setForeground(new java.awt.Color(233, 68, 190));
        perfilBtn.setText("👤");
        perfilBtn.setBorderPainted(false);
        perfilBtn.setMaximumSize(new java.awt.Dimension(31, 23));
        perfilBtn.setMinimumSize(new java.awt.Dimension(31, 23));
        perfilBtn.setPreferredSize(new java.awt.Dimension(31, 23));
        perfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilBtnActionPerformed(evt);
            }
        });

        nomeLbl.setForeground(new java.awt.Color(233, 68, 190));
        nomeLbl.setText("nome do perfil");

        voltarBtn.setBackground(new java.awt.Color(83, 41, 71));
        voltarBtn.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        voltarBtn.setForeground(new java.awt.Color(233, 68, 190));
        voltarBtn.setText("<<VOLTAR");
        voltarBtn.setBorder(null);
        voltarBtn.setBorderPainted(false);
        voltarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarBtnActionPerformed(evt);
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
                        .addGap(212, 212, 212)
                        .addComponent(nomeLbl))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(labelperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltarBtn)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(voltarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(perfilLabel)
                .addGap(13, 13, 13)
                .addComponent(labelperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
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
            .addGap(0, 514, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBtn1ActionPerformed
        FramePrincipal.trocaPainel("painel inicio", new TelaInicio());
    }//GEN-LAST:event_inicioBtn1ActionPerformed

    private void quizBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizBtnActionPerformed
        FramePrincipal.trocaPainel("painel quiz", new TelaQuiz());
    }//GEN-LAST:event_quizBtnActionPerformed

    private void pesqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqBtnActionPerformed
    }//GEN-LAST:event_pesqBtnActionPerformed

    private void perfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilBtnActionPerformed
        FramePrincipal.trocaPainel("painel perfil", new TelaPerfil());
    }//GEN-LAST:event_perfilBtnActionPerformed

    private void voltarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarBtnActionPerformed
        FramePrincipal.trocaPainel("tela pesquisa", new TelaPesquisar());
    }//GEN-LAST:event_voltarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicioBtn1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelperfil;
    private javax.swing.JLabel nomeLbl;
    private javax.swing.JButton perfilBtn;
    private javax.swing.JLabel perfilLabel;
    private javax.swing.JButton pesqBtn;
    private javax.swing.JButton quizBtn;
    private javax.swing.JButton voltarBtn;
    // End of variables declaration//GEN-END:variables

}
