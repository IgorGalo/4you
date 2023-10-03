/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.Hashtable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FramePrincipal extends javax.swing.JFrame {

    private static JScrollPane painelRolagem;
    private static JPanel painelTroca;
    private static CardLayout baralhoPaineis;
    private static Hashtable<String, JPanel> historicoPaineis;

    public FramePrincipal() {
        initComponents();

        configuraTrocaPaineis();
        
        //this.setLocationRelativeTo(null);

        trocaPainel("escolha", new TelaEscolha());

    }

    private void configuraTrocaPaineis() {

        this.setLayout(new BorderLayout());

        historicoPaineis = new Hashtable<>();
        baralhoPaineis = new CardLayout();
        painelRolagem = new JScrollPane();

        painelTroca = new JPanel(baralhoPaineis);

        this.add(painelRolagem);
        painelRolagem.setViewportView(painelTroca);
    }

    public static void trocaPainel(String nome, JPanel novoPainel) {

        //se o novo painel não estive no histórico
        if (!historicoPaineis.containsKey(nome)) {

            painelTroca.add(novoPainel, nome);
            baralhoPaineis.show(painelTroca, nome);

            //estamos ajustando o tamanho do painelTroca ao tamanho do novoPainel
            painelTroca.setPreferredSize(novoPainel.getPreferredSize());

            historicoPaineis.put(nome, novoPainel);
        } else {
            //a chave esta dentro do historico
            baralhoPaineis.show(painelTroca, nome);
            painelTroca.setPreferredSize(historicoPaineis.get(nome).getPreferredSize());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 455));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
