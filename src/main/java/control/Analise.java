package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
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
                        opcoes.add("amor");
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
                switch (escolha) {
                    case 1:
                        opcoes.add("drama");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 7:

                break;
            case 8:

                break;
        }

        switch (perg4) {
            case 9:
                switch (escolha) {
                    case 1:
                        opcoes.add("musical");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 10:

                break;
            case 11:

                break;
        }

        switch (perg5) {
            case 12:
                switch (escolha) {
                    case 1:
                        opcoes.add("ficçãocientífica");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 13:

                break;
            case 14:

                break;
        }

        switch (perg6) {
            case 15:
                switch (escolha) {
                    case 1:
                        opcoes.add("documentário");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 16:

                break;
            case 17:

                break;
        }

        switch (perg7) {
            case 18:
                switch (escolha) {
                    case 1:
                        opcoes.add("comédia");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 19:

                break;
            case 20:

                break;
        }

        switch (perg8) {
            case 21:
                switch (escolha) {
                    case 1:
                        opcoes.add("aventura");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 22:

                break;
            case 23:

                break;
        }

        switch (perg9) {
            case 24:
                switch (escolha) {
                    case 1:
                        opcoes.add("ação");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 25:

                break;
            case 26:

                break;
        }

        switch (perg10) {
            case 27:
                switch (escolha) {
                    case 1:
                        opcoes.add("mistério");
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }
                break;
            case 28:

                break;
            case 29:

                break;
        }

        if (opcoes.size() > 3) {

            Collections.shuffle(opcoes);

        }

        String pesquisa = opcoes.get(0) + "+" + opcoes.get(1) + "+" + opcoes.get(2);

        System.out.println(opcoes + " " + pesquisa);

        ArrayList<String> resultado = new ArrayList<>();

        switch (escolha) {
            case 1:
                fazPesquisaFilme(pesquisa);
                break;
            default:
                throw new AssertionError();
        }

        FramePrincipal.trocaPainel("resultado", new TelaResultado(resultado));

    }

    private void fazPesquisaFilme(String pesquisa) {

        try {
            ArrayList<String> resultado = new ArrayList<>();
            Document doc = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+" + pesquisa + "&rlz=1C1GCEU_pt-BRBR1051BR1051&oq=filmes" + pesquisa + "&sourceid=chrome&ie=UTF-8"
                    + "").get();
            int w = 2, z = 10;
            for (int i = 1; i < 10; i = i + 2) {
                try {
                    String y = doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1];
                } catch (Exception ERRO) {
                    w = 1;
                    z = 5;
                }

            }
            for (int i = 1; i <= z; i = i + w) {
                System.out.println(doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1]);
                resultado.add(doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1]);
            }   
            //return resultado;
        } catch (IOException ex) {
            Logger.getLogger(Analise.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }

}
