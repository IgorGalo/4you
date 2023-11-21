package control;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import view.FramePrincipal;
import view.TelaResultado;

public class Analise {

    public void calculaResultado(ButtonModel p1, ButtonModel p2, ButtonModel p3, ButtonModel p4,
            ButtonModel p5, ButtonModel p6, ButtonModel p7, ButtonModel p8, ButtonModel p9, ButtonModel p10, ArrayList<JRadioButton> todosRadioBtn) {

        int opcao1 = 0, opcao2 = 0, opcao3 = 0, opcao4 = 0, opcao5 = 0, opcao6 = 0, opcao7 = 0, opcao8 = 0, opcao9 = 0, opcao10 = 0;

        Vector<Integer> opcoes = new Vector<>();

        for (int i = 0; i < todosRadioBtn.size(); i++) {
            if (todosRadioBtn.get(i).getModel() == p1) {
                System.out.println(i);
                opcao1 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p2) {
                System.out.println(i);
                opcao2 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p3) {
                System.out.println(i);
                opcao3 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p4) {
                System.out.println(i);
                opcao4 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p5) {
                System.out.println(i);
                opcao5 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p6) {
                System.out.println(i);
                opcao6 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p7) {
                System.out.println(i);
                opcao7 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p8) {
                System.out.println(i);
                opcao8 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p9) {
                System.out.println(i);
                opcao9 = i;
                opcoes.add(i);
            }

            if (todosRadioBtn.get(i).getModel() == p10) {
                System.out.println(i);
                opcao10 = i;
                opcoes.add(i);
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

        switch (opcao1) {
            case 0:
                
                break;
            case 1:

                break;
            case 2:

                break;
        }
        
        switch (opcao1) {
            case 0:
                
                break;
            case 1:

                break;
            case 2:

                break;
        }
        
        switch (opcao1) {
            case 0:
                
                break;
            case 1:

                break;
            case 2:

                break;
        }
        
        switch (opcao1) {
            case 0:
                
                break;
            case 1:

                break;
            case 2:

                break;
        }
        
        switch (opcao1) {
            case 0:
                
                break;
            case 1:

                break;
            case 2:

                break;
        }

        FramePrincipal.trocaPainel("resultado", new TelaResultado());

    }
}
