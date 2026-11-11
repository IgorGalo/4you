package ia4you;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/** Interface Swing do 4YOU: início → 5 perguntas → carregando → 3 cards de resultado. */
final class Tela extends JFrame {

    private static final long serialVersionUID = 1L;

    static final Color FUNDO = new Color(0x2B1920);
    static final Color CARD = new Color(0x3A232C);
    static final Color ROSA = new Color(0xFF1F8E);
    static final Color TEXTO = new Color(0xF4E6EC);
    static final Color SUAVE = new Color(0xC9A9B7);
    static final int CAPA_W = 180, CAPA_H = 260;

    private final Recomendador recomendador;
    private final boolean offline;

    private final CardLayout cartas = new CardLayout();
    private final JPanel raiz = new JPanel(cartas);

    // estado do questionário
    private Categoria categoria;
    private int[] respostas = new int[Questionario.NUM_PERGUNTAS];
    private int indice;
    private final List<String> jaSugeridos = new ArrayList<>();

    // tela de perguntas
    private final JLabel lblProgresso = rotulo("", 14, SUAVE);
    private final JLabel lblEnunciado = rotulo("", 22, TEXTO);
    private final JRadioButton rb1 = radio(), rb2 = radio(), rb3 = radio();
    private final ButtonGroup grupo = new ButtonGroup();
    private final JButton btnProxima = botao("Próxima");

    // tela de resultado
    private final JLabel lblTituloResultado = rotulo("", 26, ROSA);
    private final JLabel lblBaseadoEm = rotulo("", 14, SUAVE);
    private final JPanel painelCards = new JPanel(new GridLayout(1, 3, 18, 0));

    Tela(Recomendador recomendador, boolean offline) {
        super("4YOU" + (offline ? " (modo demo)" : ""));
        this.recomendador = recomendador;
        this.offline = offline;

        raiz.setBackground(FUNDO);
        raiz.add(montaInicio(), "inicio");
        raiz.add(montaPerguntas(), "perguntas");
        raiz.add(montaCarregando(), "carregando");
        raiz.add(montaResultado(), "resultado");
        setContentPane(raiz);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(960, 640);
        setLocationRelativeTo(null);
    }

    // ---------------------------------------------------------------- telas

    private JPanel montaInicio() {
        JPanel p = coluna();
        p.add(Box.createVerticalGlue());
        p.add(centro(rotulo("4YOU", 64, ROSA)));
        p.add(Box.createVerticalStrut(8));
        p.add(centro(rotulo("O que você quer descobrir hoje?", 20, TEXTO)));
        p.add(Box.createVerticalStrut(36));
        JPanel linha = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 0));
        linha.setOpaque(false);
        for (Categoria c : Categoria.values()) {
            JButton b = botao(c.rotulo);
            b.addActionListener(e -> iniciar(c));
            linha.add(b);
        }
        p.add(linha);
        p.add(Box.createVerticalGlue());
        return p;
    }

    private JPanel montaPerguntas() {
        JPanel p = coluna();
        p.setBorder(new EmptyBorder(40, 70, 40, 70));
        grupo.add(rb1); grupo.add(rb2); grupo.add(rb3);
        for (JRadioButton r : List.of(rb1, rb2, rb3)) r.addActionListener(e -> btnProxima.setEnabled(true));
        btnProxima.addActionListener(e -> proxima());

        p.add(esquerda(lblProgresso));
        p.add(Box.createVerticalStrut(14));
        p.add(esquerda(lblEnunciado));
        p.add(Box.createVerticalStrut(24));
        p.add(esquerda(rb1));
        p.add(Box.createVerticalStrut(14));
        p.add(esquerda(rb2));
        p.add(Box.createVerticalStrut(14));
        p.add(esquerda(rb3));
        p.add(Box.createVerticalGlue());
        p.add(esquerda(btnProxima));
        return p;
    }

    private JPanel montaCarregando() {
        JPanel p = coluna();
        p.add(Box.createVerticalGlue());
        p.add(centro(rotulo("Consultando a IA…", 24, TEXTO)));
        p.add(Box.createVerticalStrut(18));
        JProgressBar barra = new JProgressBar();
        barra.setIndeterminate(true);
        barra.setMaximumSize(new Dimension(320, 10));
        barra.setForeground(ROSA);
        barra.setBackground(CARD);
        barra.setBorderPainted(false);
        barra.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(barra);
        p.add(Box.createVerticalGlue());
        return p;
    }

    private JPanel montaResultado() {
        JPanel p = coluna();
        p.setBorder(new EmptyBorder(24, 40, 20, 40));
        painelCards.setOpaque(false);

        JButton outras = botao("Outras sugestões");
        outras.addActionListener(e -> buscar());
        JButton recomecar = botao("Recomeçar");
        recomecar.addActionListener(e -> cartas.show(raiz, "inicio"));
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 0));
        botoes.setOpaque(false);
        botoes.add(outras);
        botoes.add(recomecar);

        p.add(centro(lblTituloResultado));
        p.add(Box.createVerticalStrut(4));
        p.add(centro(lblBaseadoEm));
        p.add(Box.createVerticalStrut(18));
        p.add(painelCards);
        p.add(Box.createVerticalStrut(14));
        p.add(centro(rotulo("<html><center>Sugestões geradas por IA, que pode errar. "
            + "✔ = obra confirmada em uma base pública; ⚠ = não foi possível confirmar.</center></html>", 12, SUAVE)));
        p.add(Box.createVerticalStrut(12));
        p.add(botoes);
        return p;
    }

    // ---------------------------------------------------------------- fluxo

    private void iniciar(Categoria c) {
        categoria = c;
        indice = 0;
        respostas = new int[Questionario.NUM_PERGUNTAS];
        jaSugeridos.clear();
        mostraPergunta();
        cartas.show(raiz, "perguntas");
    }

    private void mostraPergunta() {
        Questionario.Pergunta q = Questionario.perguntas(categoria).get(indice);
        lblProgresso.setText(categoria.rotulo + " · pergunta " + (indice + 1) + " de " + Questionario.NUM_PERGUNTAS);
        lblEnunciado.setText(q.enunciado());
        rb1.setText(html("1 — " + q.opcao1()));
        rb2.setText(html("2 — " + q.opcao2()));
        rb3.setText(html("Nenhuma das duas"));
        grupo.clearSelection();
        btnProxima.setEnabled(false);
        btnProxima.setText(indice == Questionario.NUM_PERGUNTAS - 1 ? "Ver resultado" : "Próxima");
    }

    private void proxima() {
        respostas[indice] = rb1.isSelected() ? Questionario.OPCAO_1
            : rb2.isSelected() ? Questionario.OPCAO_2 : Questionario.NENHUMA;
        indice++;
        if (indice < Questionario.NUM_PERGUNTAS) mostraPergunta();
        else buscar();
    }

    /** Chama a IA e as APIs de capa fora da thread da interface, para a janela não travar. */
    private void buscar() {
        cartas.show(raiz, "carregando");
        final List<String> generos = Questionario.generos(categoria, respostas);
        final List<String> evitar = new ArrayList<>(jaSugeridos);
        final Categoria cat = categoria;

        new SwingWorker<List<Sugestao>, Void>() {
            @Override
            protected List<Sugestao> doInBackground() throws Exception {
                List<Sugestao> lista = recomendador.sugerir(cat, generos, evitar);
                if (!offline) {
                    List<CompletableFuture<Void>> tarefas = new ArrayList<>();
                    for (Sugestao s : lista) tarefas.add(CompletableFuture.runAsync(() -> Capas.preencher(cat, s)));
                    tarefas.forEach(CompletableFuture::join);
                }
                return lista;
            }

            @Override
            protected void done() {
                try {
                    List<Sugestao> lista = get();
                    for (Sugestao s : lista) jaSugeridos.add(s.titulo);
                    mostraResultado(cat, generos, lista);
                } catch (Exception e) {
                    Throwable causa = e.getCause() != null ? e.getCause() : e;
                    JOptionPane.showMessageDialog(Tela.this, html(esc(String.valueOf(causa.getMessage())), 420),
                        "Não foi possível obter sugestões", JOptionPane.ERROR_MESSAGE);
                    cartas.show(raiz, "inicio");
                }
            }
        }.execute();
    }

    void mostraResultado(Categoria cat, List<String> generos, List<Sugestao> lista) {
        lblTituloResultado.setText("Sugestões de " + cat.plural + " para você");
        lblBaseadoEm.setText(generos.isEmpty() ? "Sem preferência de gênero: seleção variada"
            : "Baseado em: " + String.join(", ", generos));
        painelCards.removeAll();
        for (Sugestao s : lista) painelCards.add(card(cat, s));
        painelCards.revalidate();
        painelCards.repaint();
        cartas.show(raiz, "resultado");
    }

    // ---------------------------------------------------------------- componentes

    private JPanel card(Categoria cat, Sugestao s) {
        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.setBackground(CARD);
        c.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ROSA, 2, true), new EmptyBorder(12, 12, 12, 12)));

        BufferedImage img = s.capa != null ? s.capa : placeholder(cat);
        JPanel capa = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        capa.setOpaque(false);
        capa.add(new JLabel(new ImageIcon(ajusta(img))));
        capa.setMaximumSize(new Dimension(Integer.MAX_VALUE, CAPA_H));

        JLabel titulo = rotulo(html("<b>" + esc(s.titulo) + "</b>", 200), 16, TEXTO);
        String sub = esc(s.criador) + (s.ano > 0 ? " · " + s.ano : "");
        JLabel criador = rotulo(html(sub, 200), 13, SUAVE);
        JLabel motivo = rotulo(html("<i>" + esc(s.motivo) + "</i>", 200), 12, TEXTO);
        JLabel selo = s.verificado
            ? rotulo("✔ confirmado (" + s.fonte + ")", 12, new Color(0x7DDC9A))
            : rotulo(offline ? "modo demo" : "⚠ não confirmado", 12, new Color(0xFFC857));

        c.add(esquerda(capa));
        c.add(Box.createVerticalStrut(10));
        c.add(esquerda(titulo));
        c.add(Box.createVerticalStrut(2));
        c.add(esquerda(criador));
        c.add(Box.createVerticalStrut(8));
        c.add(esquerda(motivo));
        c.add(Box.createVerticalGlue());
        c.add(Box.createVerticalStrut(8));
        c.add(esquerda(selo));
        return c;
    }

    /** Redimensiona mantendo a proporção, para caber em CAPA_W x CAPA_H. */
    private static Image ajusta(BufferedImage img) {
        double f = Math.min((double) CAPA_W / img.getWidth(), (double) CAPA_H / img.getHeight());
        return img.getScaledInstance(Math.max(1, (int) (img.getWidth() * f)),
            Math.max(1, (int) (img.getHeight() * f)), Image.SCALE_SMOOTH);
    }

    /** Capa genérica quando a API de imagens não achou nada. */
    static BufferedImage placeholder(Categoria cat) {
        BufferedImage img = new BufferedImage(CAPA_W, CAPA_H, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setPaint(new GradientPaint(0, 0, new Color(0x4A2735), 0, CAPA_H, new Color(0x241017)));
        g.fillRect(0, 0, CAPA_W, CAPA_H);
        g.setColor(ROSA);
        g.setStroke(new BasicStroke(2));
        g.drawRoundRect(8, 8, CAPA_W - 17, CAPA_H - 17, 16, 16);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        String t = cat.singular.toUpperCase();
        g.drawString(t, (CAPA_W - g.getFontMetrics().stringWidth(t)) / 2, CAPA_H / 2 + 8);
        g.dispose();
        return img;
    }

    // ---------------------------------------------------------------- helpers de estilo

    private static JPanel coluna() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(FUNDO);
        return p;
    }

    private static JLabel rotulo(String txt, int tam, Color cor) {
        JLabel l = new JLabel(txt);
        l.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, tam));
        l.setForeground(cor);
        return l;
    }

    private static JRadioButton radio() {
        JRadioButton r = new JRadioButton();
        r.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        r.setForeground(TEXTO);
        r.setOpaque(false);
        r.setFocusPainted(false);
        r.setIcon(bolinha(false));
        r.setSelectedIcon(bolinha(true));
        r.setIconTextGap(12);
        return r;
    }

    /** Ícone de seleção no tema do app (o padrão do Swing some no fundo escuro). */
    private static Icon bolinha(boolean marcada) {
        BufferedImage img = new BufferedImage(22, 22, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(ROSA);
        g.setStroke(new BasicStroke(2));
        g.drawOval(2, 2, 17, 17);
        if (marcada) g.fillOval(6, 6, 10, 10);
        g.dispose();
        return new ImageIcon(img);
    }

    private static JButton botao(String txt) {
        JButton b = new JButton(txt);
        b.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        b.setForeground(Color.WHITE);
        b.setBackground(ROSA);
        b.setOpaque(true);
        b.setBorder(new EmptyBorder(10, 28, 10, 28));
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private static JComponent centro(JComponent c) {
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
        return c;
    }

    private static JComponent esquerda(JComponent c) {
        c.setAlignmentX(Component.LEFT_ALIGNMENT);
        return c;
    }

    private static String html(String corpo) {
        return html(corpo, 540);
    }

    private static String html(String corpo, int largura) {
        return "<html><body style='width:" + largura + "px'>" + corpo + "</body></html>";
    }

    private static String esc(String t) {
        return t.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
