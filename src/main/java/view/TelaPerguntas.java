/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.Analise;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author flavi
 */
public class TelaPerguntas extends javax.swing.JPanel {

    private int escolha;
    private int vez;
    private ButtonGroup perguntaGroup;
    private Vector<Integer> botaoSelecionado;

    public TelaPerguntas(int escolha, int vez, Vector<Integer> vet) {
        initComponents();
        perguntaGroup = new ButtonGroup();
        perguntaGroup.add(opcao1Btn);
        perguntaGroup.add(opcao2Btn);
        perguntaGroup.add(nenhumaBtn);
        perguntaTxt.setLineWrap(true);
        this.escolha = escolha;
        this.botaoSelecionado = vet;
        this.vez = vez;
        adicionaPergunta();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage imagem;

        try {
            imagem = ImageIO.read(new File(getClass().getResource("/telaQuizCmc.png").getPath()));
            g.drawImage(imagem, 0, 0, this);

        } catch (IOException ex) {
            System.out.println("Arquivo não existente");
        }
    }

    private void adicionaPergunta() {
        switch (this.escolha) {
            case 1:
                switch (this.vez) {
                    case 1: // terror e romance
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- explorar narrativas que despertam uma sensação de medo e suspense;\n"
                                + "2- prefere se envolver mais nas histórias das relações humanas, com personagens enfrentando os desafios emocionais?");
                        break;
                    case 2: // misterio e aventura
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- narrativas que desafiem sua capacidade de dedução e mantêm você intrigado do início ao fim;\n"
                                + "2- narrativas exploram terras desconhecidas, desafios emocionantes e jornadas inesperadas?");
                        break;
                    case 3: // drama comédia 
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- filmes que retratam momentos intensos e emocionais que fazem você refletir sobre a complexidade da vida;\n"
                                + "2- filmes que proporcionem momentos leves e divertidos, capazes de arrancar um sorriso mesmo nas situações mais inusitadas?");
                        break;
                    case 4: //musical e acao
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- prestar atenção na trilha sonora e nas performances musicais integradas à história;\n"
                                + "2- se empolgar com tramas cheias de adrenalina e reviravolta?");
                        break;
                    case 5: //ficcao e doc
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- narrativas que exploram mundos imaginários e conceitos futuristas, desafiando os limites da realidade;\n"
                                + "2- tramas que exploram a realidade, oferecendo uma perspectiva mais profunda sobre diferentes assuntos e experiências de vida?");
                        break;
                }
                break;

            case 2:
                switch (this.vez) {
                    case 1: // terror e romance
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- se perder em histórias românticas que despertam emoções profundas;\n"
                                + "2- mergulhar em narrativas que oferecem uma visão mais fiel e detalhada da vida cotidiana?");
                        break;
                    case 2: // misterio e aventura
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- cativar por tramas que envolvem desvendar segredos e resolver enigmas;\n"
                                + "2- buscar a adrenalina das aventuras cheias de reviravoltas e desafios emocionantes?");
                        break;
                    case 3: // drama comédia 
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- explorar a vida real e as experiências de pessoas reais por meio de biografias;\n"
                                + "2- escapar para mundos imaginários repletos de fantasia e criatividade?");
                        break;
                    case 4: //musical e acao
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- se encantar mais com a profundidade e atemporalidade das obras clássicas;\n"
                                + "2- a leveza e proximidade do cotidiano encontradas nas crônicas ao escolher seus livros?");
                        break;
                    case 5: //ficcao e doc
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- se inclinar mais para tramas que exploram as complexidades emocionais e os desafios da vida;\n"
                                + "2- obras que proporcionam momentos leves e sorrisos com sua abordagem mais cômica?");
                        break;
                }
                break;
            case 3:
                switch (this.vez) {
                    case 1: // terror e romance
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- ser atraído pelas batidas eletrizantes das guitarras;\n"
                                + "2- mergulhar na sofisticação harmônica e improvisação envolvente?");
                        break;
                    case 2: // misterio e aventura
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- atmosferas sombrias e melancólicas do gótico;\n"
                                + "2- se perder na energia contagiante e em ritmos dançantes?");
                        break;
                    case 3: // drama comédia 
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- a grandiosidade e tradição das peças clássicas;\n"
                                + "2- se deixar envolver pela energia contagiante e as melodias pop coreanas?");
                        break;
                    case 4: //musical e acao
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- se entregar mais às batidas animadas e letras vibrantes;\n"
                                + "2- encontrar uma conexão especial com os ritmos relaxantes e mensagens positivas?");
                        break;
                    case 5: //ficcao e doc
                        perguntaTxt.setText("O que você prefere:\n"
                                + "1- refrãos cativantes e batidas populares;\n"
                                + "2- histórias envolventes e o som característico do interior?");
                        break;
                }
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        cadastrarBtn = new javax.swing.JButton();
        cadastrarBtn1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        perguntaTxt = new javax.swing.JTextArea();
        nenhumaBtn = new javax.swing.JRadioButton();
        opcao1Btn = new javax.swing.JRadioButton();
        opcao2Btn = new javax.swing.JRadioButton();
        nextBtn = new javax.swing.JLabel();
        voltarBtn = new javax.swing.JLabel();

        cadastrarBtn.setBackground(new java.awt.Color(233, 68, 190));
        cadastrarBtn.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        cadastrarBtn.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarBtn.setText("CADASTRAR");
        cadastrarBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 68, 190)));
        cadastrarBtn.setBorderPainted(false);

        cadastrarBtn1.setBackground(new java.awt.Color(233, 68, 190));
        cadastrarBtn1.setFont(new java.awt.Font("Swis721 LtEx BT", 0, 14)); // NOI18N
        cadastrarBtn1.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarBtn1.setText("CADASTRAR");
        cadastrarBtn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 68, 190)));
        cadastrarBtn1.setBorderPainted(false);
        cadastrarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBtn1ActionPerformed(evt);
            }
        });

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(253, 40, 141));
        jScrollPane4.setBorder(null);
        jScrollPane4.setForeground(new java.awt.Color(43, 24, 33));

        perguntaTxt.setEditable(false);
        perguntaTxt.setBackground(new java.awt.Color(253, 40, 141));
        perguntaTxt.setColumns(20);
        perguntaTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        perguntaTxt.setForeground(new java.awt.Color(255, 255, 255));
        perguntaTxt.setRows(5);
        perguntaTxt.setWrapStyleWord(true);
        perguntaTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(253, 40, 141), 0));
        perguntaTxt.setSelectedTextColor(new java.awt.Color(253, 40, 141));
        jScrollPane4.setViewportView(perguntaTxt);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 810, 160));

        nenhumaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(nenhumaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 310, 80));

        opcao1Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(opcao1Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 461, 300, 80));

        opcao2Btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(opcao2Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 310, 80));

        nextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nextBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextBtnMouseClicked(evt);
            }
        });
        add(nextBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 670, 300, 40));

        voltarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarBtnMouseClicked(evt);
            }
        });
        add(voltarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 20, 80, 60));
    }// </editor-fold>//GEN-END:initComponents


    private void cadastrarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBtn1ActionPerformed

    }//GEN-LAST:event_cadastrarBtn1ActionPerformed

    private void voltarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarBtnMouseClicked
        FramePrincipal.trocaPainel("tela escolhaFML", new TelaEscolhaFML());
    }//GEN-LAST:event_voltarBtnMouseClicked

    private void nextBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextBtnMouseClicked
        if (this.vez < 6) {
            if (nenhumaBtn.isSelected() || opcao1Btn.isSelected() || opcao2Btn.isSelected()) {
                if (opcao1Btn.isSelected()) {
                    this.botaoSelecionado.add(1);
                    System.out.println(this.botaoSelecionado);
                    System.out.println("1");
                }
                if (opcao2Btn.isSelected()) {
                    this.botaoSelecionado.add(2);
                    System.out.println(this.botaoSelecionado);
                    System.out.println("2");
                }
                if (nenhumaBtn.isSelected()) {
                    this.botaoSelecionado.add(3);
                    System.out.println(this.botaoSelecionado);
                    System.out.println("n");
                }
                FramePrincipal.trocaPainel("tela perguntas", new TelaPerguntas(this.escolha, this.vez + 1, this.botaoSelecionado));

            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma opção");
            }
        } else {
            Analise analise = new Analise();
            System.out.println(this.botaoSelecionado);
            analise.calculaResultado(this.botaoSelecionado, escolha, opcao1Btn, opcao2Btn, nenhumaBtn);
        }
    }//GEN-LAST:event_nextBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cadastrarBtn;
    private javax.swing.JButton cadastrarBtn1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton nenhumaBtn;
    private javax.swing.JLabel nextBtn;
    private javax.swing.JRadioButton opcao1Btn;
    private javax.swing.JRadioButton opcao2Btn;
    private javax.swing.JTextArea perguntaTxt;
    private javax.swing.JLabel voltarBtn;
    // End of variables declaration//GEN-END:variables
}
