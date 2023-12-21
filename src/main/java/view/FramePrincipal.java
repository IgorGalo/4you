package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class FramePrincipal extends javax.swing.JFrame {

    private static JScrollPane painelRolagem;
    private static JPanel painelTroca;
    private static CardLayout baralhoPaineis;
    private static Hashtable<String, JPanel> historicoPaineis;
    private static List<String> telasReaproveitadas = Arrays.asList("tela cadastrar", "tela entrar", "tela escolhaFML", "tela inicio", "tela quiz");

    public FramePrincipal() {
        initComponents();
        configuraTrocaPaineis();
        trocaPainel("tela timer", new TelaTimer());
        telaComTimer();
    }

    public static void trocaPainel(String nome, JPanel novoPainel) {

        //se o novo painel não estive no histórico
        if (!historicoPaineis.containsKey(nome) || !telasReaproveitadas.contains(nome)) {

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

    private void telaComTimer() {

        SwingWorker trocar = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    Thread.sleep(2000);
                    trocaPainel("tela entrar", new TelaEntrar());
                } catch (InterruptedException ex) {
                    System.err.println("não há o que fazer...");
                }
                return null;
            }
        };

        trocar.execute();

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1372, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    }//GEN-LAST:event_formWindowActivated

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
