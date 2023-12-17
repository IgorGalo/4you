package view;

import control.PesquisaControl;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Item;
import model.Usuario;

public class TelaPesquisar extends javax.swing.JPanel {

    private ButtonGroup escolhaPesquisa;
    PesquisaControl pesquisa = new PesquisaControl();
    ArrayList<Usuario> todosUsuarios = new ArrayList<>();
    ArrayList<Item> todosItens = new ArrayList<>();
    public String nome;


    public TelaPesquisar() {
        initComponents();
        config();
    }

    private void config() {
        escolhaPesquisa = new ButtonGroup();
        escolhaPesquisa.add(usuarioBtn);
        escolhaPesquisa.add(itemBtn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicioBtn = new javax.swing.JButton();
        quizBtn = new javax.swing.JButton();
        pesqBtn = new javax.swing.JButton();
        perfilBtn = new javax.swing.JButton();
        inicioBtn1 = new javax.swing.JButton();
        quizBtn2 = new javax.swing.JButton();
        pesqBtn2 = new javax.swing.JButton();
        perfilBtn2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        perfilLabel = new javax.swing.JLabel();
        inicioBtn3 = new javax.swing.JButton();
        quizBtn3 = new javax.swing.JButton();
        pesqBtn1 = new javax.swing.JButton();
        perfilBtn1 = new javax.swing.JButton();
        pesqTxt = new javax.swing.JTextField();
        pesquisarBtn = new javax.swing.JButton();
        usuarioBtn = new javax.swing.JRadioButton();
        itemBtn = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadoList = new javax.swing.JList();

        inicioBtn.setBackground(new java.awt.Color(83, 41, 71));
        inicioBtn.setForeground(new java.awt.Color(233, 68, 190));
        inicioBtn.setText("INICIO");
        inicioBtn.setBorderPainted(false);
        inicioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBtnActionPerformed(evt);
            }
        });

        quizBtn.setBackground(new java.awt.Color(83, 41, 71));
        quizBtn.setForeground(new java.awt.Color(233, 68, 190));
        quizBtn.setText("QUIZ");
        quizBtn.setBorderPainted(false);

        pesqBtn.setBackground(new java.awt.Color(83, 41, 71));
        pesqBtn.setForeground(new java.awt.Color(233, 68, 190));
        pesqBtn.setText("PESQUISA");
        pesqBtn.setBorderPainted(false);
        pesqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqBtnActionPerformed(evt);
            }
        });

        perfilBtn.setBackground(new java.awt.Color(83, 41, 71));
        perfilBtn.setForeground(new java.awt.Color(233, 68, 190));
        perfilBtn.setText("PERFIL");
        perfilBtn.setBorderPainted(false);
        perfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilBtnActionPerformed(evt);
            }
        });

        inicioBtn1.setBackground(new java.awt.Color(83, 41, 71));
        inicioBtn1.setForeground(new java.awt.Color(233, 68, 190));
        inicioBtn1.setText("🏠");
        inicioBtn1.setBorderPainted(false);
        inicioBtn1.setEnabled(false);
        inicioBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBtn1ActionPerformed(evt);
            }
        });

        quizBtn2.setBackground(new java.awt.Color(83, 41, 71));
        quizBtn2.setForeground(new java.awt.Color(233, 68, 190));
        quizBtn2.setText("❔");
        quizBtn2.setBorderPainted(false);
        quizBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizBtn2ActionPerformed(evt);
            }
        });

        pesqBtn2.setBackground(new java.awt.Color(83, 41, 71));
        pesqBtn2.setForeground(new java.awt.Color(233, 68, 190));
        pesqBtn2.setText("🔎");
        pesqBtn2.setBorderPainted(false);
        pesqBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqBtn2ActionPerformed(evt);
            }
        });

        perfilBtn2.setBackground(new java.awt.Color(83, 41, 71));
        perfilBtn2.setForeground(new java.awt.Color(233, 68, 190));
        perfilBtn2.setText("👤");
        perfilBtn2.setBorderPainted(false);
        perfilBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilBtn2ActionPerformed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(500, 400));

        jPanel4.setBackground(new java.awt.Color(83, 41, 71));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(233, 68, 190)));
        jPanel4.setPreferredSize(new java.awt.Dimension(500, 400));

        inicioBtn3.setBackground(new java.awt.Color(83, 41, 71));
        inicioBtn3.setForeground(new java.awt.Color(233, 68, 190));
        inicioBtn3.setText("🏠");
        inicioBtn3.setBorderPainted(false);
        inicioBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioBtn3ActionPerformed(evt);
            }
        });

        quizBtn3.setBackground(new java.awt.Color(83, 41, 71));
        quizBtn3.setForeground(new java.awt.Color(233, 68, 190));
        quizBtn3.setText("❔");
        quizBtn3.setBorderPainted(false);
        quizBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizBtn3ActionPerformed(evt);
            }
        });

        pesqBtn1.setBackground(new java.awt.Color(83, 41, 71));
        pesqBtn1.setForeground(new java.awt.Color(233, 68, 190));
        pesqBtn1.setText("🔎");
        pesqBtn1.setBorderPainted(false);
        pesqBtn1.setEnabled(false);
        pesqBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqBtn1ActionPerformed(evt);
            }
        });

        perfilBtn1.setBackground(new java.awt.Color(83, 41, 71));
        perfilBtn1.setForeground(new java.awt.Color(233, 68, 190));
        perfilBtn1.setText("👤");
        perfilBtn1.setBorderPainted(false);
        perfilBtn1.setMaximumSize(new java.awt.Dimension(31, 23));
        perfilBtn1.setMinimumSize(new java.awt.Dimension(31, 23));
        perfilBtn1.setPreferredSize(new java.awt.Dimension(31, 23));
        perfilBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilBtn1ActionPerformed(evt);
            }
        });

        pesqTxt.setBackground(new java.awt.Color(83, 41, 71));
        pesqTxt.setForeground(new java.awt.Color(255, 255, 255));
        pesqTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pesqTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 68, 190)));

        pesquisarBtn.setBackground(new java.awt.Color(83, 41, 71));
        pesquisarBtn.setForeground(new java.awt.Color(233, 68, 190));
        pesquisarBtn.setText("🔎");
        pesquisarBtn.setBorder(null);
        pesquisarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarBtnActionPerformed(evt);
            }
        });

        usuarioBtn.setBackground(new java.awt.Color(83, 41, 71));
        usuarioBtn.setForeground(new java.awt.Color(233, 68, 190));
        usuarioBtn.setText("Usuário");

        itemBtn.setForeground(new java.awt.Color(233, 68, 190));
        itemBtn.setText("Item");

        resultadoList.setBackground(new java.awt.Color(83, 41, 71));
        resultadoList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 68, 190)));
        resultadoList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultadoListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resultadoList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(perfilLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(inicioBtn3)
                            .addGap(88, 88, 88)
                            .addComponent(pesqBtn1)
                            .addGap(94, 94, 94)
                            .addComponent(quizBtn3)
                            .addGap(88, 88, 88)
                            .addComponent(perfilBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(pesquisarBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pesqTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addComponent(usuarioBtn)
                    .addGap(58, 58, 58)
                    .addComponent(itemBtn)
                    .addContainerGap(177, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesqTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(perfilLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesqBtn1)
                        .addComponent(quizBtn3)
                        .addComponent(perfilBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inicioBtn3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usuarioBtn)
                        .addComponent(itemBtn))
                    .addContainerGap(337, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inicioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBtnActionPerformed
    }//GEN-LAST:event_inicioBtnActionPerformed

    private void pesqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqBtnActionPerformed
    }//GEN-LAST:event_pesqBtnActionPerformed

    private void perfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilBtnActionPerformed
    }//GEN-LAST:event_perfilBtnActionPerformed

    private void inicioBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBtn1ActionPerformed
    }//GEN-LAST:event_inicioBtn1ActionPerformed

    private void quizBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizBtn2ActionPerformed
    }//GEN-LAST:event_quizBtn2ActionPerformed

    private void pesqBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqBtn2ActionPerformed
    }//GEN-LAST:event_pesqBtn2ActionPerformed

    private void perfilBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilBtn2ActionPerformed
    }//GEN-LAST:event_perfilBtn2ActionPerformed

    private void quizBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizBtn3ActionPerformed
        FramePrincipal.trocaPainel("painel quiz", new TelaEscolhaFML());
    }//GEN-LAST:event_quizBtn3ActionPerformed

    private void pesqBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqBtn1ActionPerformed
    }//GEN-LAST:event_pesqBtn1ActionPerformed

    private void perfilBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilBtn1ActionPerformed
        FramePrincipal.trocaPainel("painel perfil", new TelaPerfil());
    }//GEN-LAST:event_perfilBtn1ActionPerformed

    private void inicioBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioBtn3ActionPerformed
        FramePrincipal.trocaPainel("painel inicio", new TelaInicio());
    }//GEN-LAST:event_inicioBtn3ActionPerformed

    private void pesquisarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarBtnActionPerformed
        this.pesquisa = new PesquisaControl();

        if (usuarioBtn.isSelected()) {
            this.todosUsuarios = this.pesquisa.pesquisaUsuarios(pesqTxt.getText());
            DefaultListModel<Usuario> user = new DefaultListModel<>();
            user.addAll(todosUsuarios);

            resultadoList.setModel(user);
            
        } else if (itemBtn.isSelected()) {
            this.todosItens = this.pesquisa.pesquisaItens(pesqTxt.getText());
            DefaultListModel<Item> item = new DefaultListModel<>();
            item.addAll(todosItens);

            resultadoList.setModel(item);
        }else {
            JOptionPane.showMessageDialog(this, "É preciso informar a categoria da pesquisa!");
        }
    }//GEN-LAST:event_pesquisarBtnActionPerformed

    private void resultadoListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultadoListMouseClicked
       if (usuarioBtn.isSelected()) {
            int indice = resultadoList.getSelectedIndex();
            Usuario nomeuser = todosUsuarios.get(indice);
            nome = nomeuser.getNomeUsuario();
            System.out.println(nome);
            FramePrincipal.trocaPainel("Painel perfil pesquisado", new TelaPerfilPesquisado(nome));
        } else if (itemBtn.isSelected()) {
            int indice = resultadoList.getSelectedIndex();
            Item nomeitem = todosItens.get(indice);
            nome = nomeitem.getNomeItem();
            System.out.println(nome);
            FramePrincipal.trocaPainel("Painel avaliar item pesquisado", new TelaItemPesquisado(nome));
        } else {

        }
    }//GEN-LAST:event_resultadoListMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicioBtn;
    private javax.swing.JButton inicioBtn1;
    private javax.swing.JButton inicioBtn3;
    private javax.swing.JRadioButton itemBtn;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton perfilBtn;
    private javax.swing.JButton perfilBtn1;
    private javax.swing.JButton perfilBtn2;
    private javax.swing.JLabel perfilLabel;
    private javax.swing.JButton pesqBtn;
    private javax.swing.JButton pesqBtn1;
    private javax.swing.JButton pesqBtn2;
    private javax.swing.JTextField pesqTxt;
    private javax.swing.JButton pesquisarBtn;
    private javax.swing.JButton quizBtn;
    private javax.swing.JButton quizBtn2;
    private javax.swing.JButton quizBtn3;
    private javax.swing.JList resultadoList;
    private javax.swing.JRadioButton usuarioBtn;
    // End of variables declaration//GEN-END:variables
}
