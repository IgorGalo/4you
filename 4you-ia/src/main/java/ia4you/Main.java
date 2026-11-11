package ia4you;

import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        boolean demo = Arrays.asList(args).contains("--demo");
        String gemini = System.getenv("GEMINI_API_KEY");
        String openai = System.getenv("OPENAI_API_KEY");

        Recomendador rec;
        if (demo) {
            rec = new DemoRecomendador();
        } else if (gemini != null && !gemini.isBlank()) {
            rec = new GeminiClient(gemini);          // gratuito (Google AI Studio)
        } else if (openai != null && !openai.isBlank()) {
            rec = new OpenAiClient(openai);          // pago (créditos pré-pagos)
        } else {
            String msg = "Defina a variável de ambiente GEMINI_API_KEY (gratuita, em aistudio.google.com)\n"
                + "ou OPENAI_API_KEY (paga).\nPara só ver a interface, rode com --demo.";
            System.err.println(msg);
            JOptionPane.showMessageDialog(null, msg, "4YOU", JOptionPane.WARNING_MESSAGE);
            return;
        }
        SwingUtilities.invokeLater(() -> new Tela(rec, demo).setVisible(true));
    }
}
