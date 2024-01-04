package view;

import control.PesquisaControl;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
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
        escolhaPesquisa.add(itensBtn);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaPesquisa.png").getPath()));
            g.drawImage(imagem, 0, 0, this);

        } catch (IOException ex) {
            System.out.println("Arquivo não existente");
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioBtn = new javax.swing.JRadioButton();
        itensBtn = new javax.swing.JRadioButton();
        perfilBtn = new javax.swing.JLabel();
        quizBtn = new javax.swing.JLabel();
        inicioBtn = new javax.swing.JLabel();
        pesqBtn = new javax.swing.JLabel();
        resultadoList = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList();
        pesqTxt = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(500, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuarioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(usuarioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 150, 30));

        itensBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(itensBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 150, 30));

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

        pesqBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pesqBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pesqBtnMouseClicked(evt);
            }
        });
        add(pesqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1167, 50, 50, 50));

        resultadoList.setBorder(null);
        resultadoList.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N

        resultList.setBackground(new java.awt.Color(43, 24, 33));
        resultList.setBorder(null);
        resultList.setForeground(new java.awt.Color(255, 255, 255));
        resultList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        resultList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultListMouseClicked(evt);
            }
        });
        resultadoList.setViewportView(resultList);

        add(resultadoList, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 190, 910, 470));

        pesqTxt.setBackground(new java.awt.Color(43, 24, 33));
        pesqTxt.setForeground(new java.awt.Color(255, 255, 255));
        pesqTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pesqTxt.setBorder(null);
        pesqTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(pesqTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 910, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void perfilBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilBtnMouseClicked
        FramePrincipal.trocaPainel("tela perfil", new TelaPerfil());
    }//GEN-LAST:event_perfilBtnMouseClicked

    private void quizBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quizBtnMouseClicked
        FramePrincipal.trocaPainel("tela escolhaFML", new TelaEscolhaFML());
    }//GEN-LAST:event_quizBtnMouseClicked

    private void inicioBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioBtnMouseClicked
        FramePrincipal.trocaPainel("tela inicio", new TelaInicio());
    }//GEN-LAST:event_inicioBtnMouseClicked

    private void pesqBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pesqBtnMouseClicked
        this.pesquisa = new PesquisaControl();

        if (usuarioBtn.isSelected()) {
            this.todosUsuarios = this.pesquisa.pesquisaUsuarios(pesqTxt.getText());
            DefaultListModel<Usuario> user = new DefaultListModel<>();
            user.addAll(todosUsuarios);
            resultList.setModel(user);

        } else if (itensBtn.isSelected()) {
            this.todosItens = this.pesquisa.pesquisaItens(pesqTxt.getText());
            DefaultListModel<Item> item = new DefaultListModel<>();
            item.addAll(todosItens);
            resultList.setModel(item);
        } else {
            JOptionPane.showMessageDialog(this, "É preciso informar a categoria da pesquisa!");
        }
    }//GEN-LAST:event_pesqBtnMouseClicked

    private void resultListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultListMouseClicked
        if (usuarioBtn.isSelected()) {
            int indice = resultList.getSelectedIndex();
            Usuario nomeuser = todosUsuarios.get(indice);
            nome = nomeuser.getNomeUsuario();
            System.out.println(nome);
            FramePrincipal.trocaPainel("Painel perfil pesquisado", new TelaPerfilPesquisado(nome));
        } else if (itensBtn.isSelected()) {
            int indice = resultList.getSelectedIndex();
            Item nomeitem = todosItens.get(indice);
            nome = nomeitem.getNomeItem();
            System.out.println(nome);
            FramePrincipal.trocaPainel("Painel avaliar item pesquisado", new TelaItemPesquisado(nome));
        } else {

        }
    }//GEN-LAST:event_resultListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel inicioBtn;
    private javax.swing.JRadioButton itensBtn;
    private javax.swing.JLabel perfilBtn;
    private javax.swing.JLabel pesqBtn;
    private javax.swing.JTextField pesqTxt;
    private javax.swing.JLabel quizBtn;
    private javax.swing.JList resultList;
    private javax.swing.JScrollPane resultadoList;
    private javax.swing.JRadioButton usuarioBtn;
    // End of variables declaration//GEN-END:variables
}
