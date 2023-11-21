package control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import view.FramePrincipal;
import view.TelaResultado;

public class Analise {

    public void calculaResultado(ButtonModel p1, ButtonModel p2, ButtonModel p3, ButtonModel p4,
            ButtonModel p5, ButtonModel p6, ButtonModel p7, ButtonModel p8, ButtonModel p9, ButtonModel p10, ArrayList<JRadioButton> todosRadioBtn, int escolha) {

        int perg1 = 0, perg2 = 0, perg3 = 0, perg4 = 0, perg5 = 0, perg6 = 0, perg7 = 0, perg8 = 0, perg9 = 0, perg10 = 0;

        Vector<String> opcoes = new Vector<>();

        for (int i = 0; i < todosRadioBtn.size(); i++) {
            if (todosRadioBtn.get(i).getModel() == p1) {
                System.out.println(i);
                perg1 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p2) {
                System.out.println(i);
                perg2 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p3) {
                System.out.println(i);
                perg3 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p4) {
                System.out.println(i);
                perg4 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p5) {
                System.out.println(i);
                perg5 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p6) {
                System.out.println(i);
                perg6 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p7) {
                System.out.println(i);
                perg7 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p8) {
                System.out.println(i);
                perg8 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p9) {
                System.out.println(i);
                perg9 = i;
            }

            if (todosRadioBtn.get(i).getModel() == p10) {
                System.out.println(i);
                perg10 = i;
            }
        }
//        for (int i = 0; i < opcoes.size(); i++) {
//            switch (opcoes.get(i)) {
//                case 1:
//
//                    break;
//                default:
//         }
//           throw new AssertionError();
//            }
//        }

        switch (perg1) {
            case 0:
                switch (escolha) {
                    case 1:
                        opcoes.add("terror");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 1:

                break;
            case 2:

                break;
        }

        switch (perg2) {
            case 3:
                switch (escolha) {
                    case 1:
                        opcoes.add("romance");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 4:

                break;
            case 5:

                break;
        }

        switch (perg3) {
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
        }

        switch (perg4) {
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
        }

        switch (perg5) {
            case 12:

                break;
            case 13:

                break;
            case 14:

                break;
        }

        switch (perg6) {
            case 15:

                break;
            case 16:

                break;
            case 17:

                break;
        }

        switch (perg7) {
            case 18:

                break;
            case 19:

                break;
            case 20:

                break;
        }

        switch (perg8) {
            case 21:

                break;
            case 22:

                break;
            case 23:

                break;
        }

        switch (perg9) {
            case 24:

                break;
            case 25:

                break;
            case 26:

                break;
        }

        switch (perg10) {
            case 27:

                break;
            case 28:

                break;
            case 29:

                break;
        }

        if (opcoes.size() > 3) {

            Collections.shuffle(opcoes);

            String pesquisa = opcoes.get(0);
        }

        FramePrincipal.trocaPainel("resultado", new TelaResultado());

    }
}
