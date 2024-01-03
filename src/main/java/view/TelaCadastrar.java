package view;

import control.Retornos;
import control.UsuarioControl;
import dao.UsuarioDAO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.Imagem;
import model.Usuario;

public class TelaCadastrar extends javax.swing.JPanel {

    public TelaCadastrar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailTxt = new javax.swing.JTextField();
        usuarioTxt = new javax.swing.JTextField();
        senhaTxt = new javax.swing.JTextField();
        nomeTxt = new javax.swing.JTextField();
        conectarBtn = new javax.swing.JLabel();
        nextBtn = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailTxt.setBackground(new java.awt.Color(43, 24, 33));
        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(204, 204, 204));
        emailTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailTxt.setText("E-MAIL");
        emailTxt.setBorder(null);
        emailTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emailTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTxtFocusLost(evt);
            }
        });
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });
        add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 290, 60));

        usuarioTxt.setBackground(new java.awt.Color(43, 24, 33));
        usuarioTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usuarioTxt.setForeground(new java.awt.Color(204, 204, 204));
        usuarioTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuarioTxt.setText("NOME DE USUÁRIO");
        usuarioTxt.setBorder(null);
        usuarioTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuarioTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usuarioTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usuarioTxtFocusLost(evt);
            }
        });
        usuarioTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTxtActionPerformed(evt);
            }
        });
        add(usuarioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 290, 70));

        senhaTxt.setBackground(new java.awt.Color(43, 24, 33));
        senhaTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        senhaTxt.setForeground(new java.awt.Color(204, 204, 204));
        senhaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        senhaTxt.setText("SENHA");
        senhaTxt.setBorder(null);
        senhaTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        senhaTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                senhaTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                senhaTxtFocusLost(evt);
            }
        });
        senhaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaTxtActionPerformed(evt);
            }
        });
        add(senhaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 290, 60));

        nomeTxt.setBackground(new java.awt.Color(43, 24, 33));
        nomeTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nomeTxt.setForeground(new java.awt.Color(204, 204, 204));
        nomeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeTxt.setText("NOME COMPLETO");
        nomeTxt.setBorder(null);
        nomeTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nomeTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomeTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeTxtFocusLost(evt);
            }
        });
        nomeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTxtActionPerformed(evt);
            }
        });
        add(nomeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 290, 60));

        conectarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conectarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                conectarBtnMouseClicked(evt);
            }
        });
        add(conectarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 670, 100, 20));

        nextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextBtnMouseClicked(evt);
            }
        });
        add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 620, 290, 30));
    }// </editor-fold>//GEN-END:initComponents
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaCadastrar.png").getPath()));
            g.drawImage(imagem, 0, 0, this);

        } catch (IOException ex) {
            System.out.println("Arquivo não existente");
        }
    }
    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void usuarioTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTxtActionPerformed

    private void senhaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaTxtActionPerformed

//Verifica e pegar as informações do usuário para cadastrá-lo posteriormente no banco de dados     
    private void nextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseClicked
        UsuarioControl usuarioC = new UsuarioControl();

        Retornos resultado = usuarioC.cadastraUsuario(nomeTxt.getText(), usuarioTxt.getText(), senhaTxt.getText(), emailTxt.getText());

        if (resultado.isRetorno() == false) {
            JOptionPane.showMessageDialog(this, resultado.getMensagem());
        } else {
            FramePrincipal.trocaPainel("tela inicio", new TelaInicio());
            //usuarioC.cadastrarImagem(imgembyte, TOOL_TIP_TEXT_KEY, arquivo)
        }

    }//GEN-LAST:event_nextBtnMouseClicked

    private void conectarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_conectarBtnMouseClicked
        FramePrincipal.trocaPainel("tela entrar", new TelaEntrar());
    }//GEN-LAST:event_conectarBtnMouseClicked

    private void nomeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTxtActionPerformed

    private void nomeTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeTxtFocusGained
        if (nomeTxt.getText().equalsIgnoreCase("NOME COMPLETO")) {
            nomeTxt.setText("");
        }
    }//GEN-LAST:event_nomeTxtFocusGained

    private void nomeTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeTxtFocusLost
        if (nomeTxt.getText().equalsIgnoreCase("")) {
            nomeTxt.setText("NOME COMPLETO");
        }
    }//GEN-LAST:event_nomeTxtFocusLost

    private void emailTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTxtFocusGained
        if (emailTxt.getText().equalsIgnoreCase("E-MAIL")) {
            emailTxt.setText("");
        }
    }//GEN-LAST:event_emailTxtFocusGained

    private void emailTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTxtFocusLost
        if (emailTxt.getText().equalsIgnoreCase("")) {
            emailTxt.setText("E-MAIL");
        }
    }//GEN-LAST:event_emailTxtFocusLost

    private void usuarioTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioTxtFocusGained
        if (usuarioTxt.getText().equalsIgnoreCase("NOME DE USUÁRIO")) {
            usuarioTxt.setText("");
        }
    }//GEN-LAST:event_usuarioTxtFocusGained

    private void usuarioTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuarioTxtFocusLost
        if (usuarioTxt.getText().equalsIgnoreCase("")) {
            usuarioTxt.setText("NOME DE USUÁRIO");
        }
    }//GEN-LAST:event_usuarioTxtFocusLost

    private void senhaTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_senhaTxtFocusGained
        if (senhaTxt.getText().equalsIgnoreCase("SENHA")) {
            senhaTxt.setText("");
        }
    }//GEN-LAST:event_senhaTxtFocusGained

    private void senhaTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_senhaTxtFocusLost
        if (senhaTxt.getText().equalsIgnoreCase("")) {
            senhaTxt.setText("SENHA");
        }
    }//GEN-LAST:event_senhaTxtFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel conectarBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel nextBtn;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField senhaTxt;
    private javax.swing.JTextField usuarioTxt;
    // End of variables declaration//GEN-END:variables
}
