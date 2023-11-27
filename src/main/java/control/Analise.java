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
            ButtonModel p5, ArrayList<JRadioButton> todosRadioBtn, int escolha) {

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
            case 0://1° opção
                switch (escolha) {
                    case 1:
                        opcoes.add("comedia"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;
            case 1://2° opção
                switch (escolha) {
                    case 1:
                        opcoes.add("drama"); //filme
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }

                break;
            case 2:

                break;
        }

        switch (perg2) {
            case 3:
                switch (escolha) {
                    case 1:
                        opcoes.add("documentario"); // filme
                        break;
                    case 2:
                        //opcoes.add("ficção+científica");
                        break;
                    case 3:

                        break;
                }
                break;
            case 4:
                switch (escolha) {
                    case 1:
                        opcoes.add("ficcaocientifica"); // filme
                        break;
                    case 2:
                        break;
                    case 3:

                        break;
                }

                break;
            case 5:

                break;
        }

        switch (perg3) {
            case 6:
                switch (escolha) {
                    case 1:
                        opcoes.add("acao");
                        break;
                    case 2:
                      //  opcoes.add("musical");
                        break;
                    case 3:

                        break;
                }
                break;
            case 7:
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
            case 8:

                break;
        }

        switch (perg4) {
            case 9:
                switch (escolha) {
                    case 1:
                        opcoes.add("terror");
                        break;
                    case 2:
                        //opcoes.add("romance");
                        break;
                    case 3:

                        break;
                }
                break;
            case 10:
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
            case 11:

                break;
        }

        switch (perg5) {
            case 12:
                switch (escolha) {
                    case 1:
                        opcoes.add("misterio");
                        break;
                    case 2:
                        //opcoes.add("aventura");
                        break;
                    case 3:

                        break;
                }
                break;
            case 13:
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
            case 14:

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

            Document doc = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+" + pesquisa + "&sourceid=chrome&ie=UTF-8"
                    + "").get();
            int w = 2, z = 10;

            //<editor-fold defaultstate="collapsed" desc="Cálculos do Padrão e Limite">
            for (int i = 1; i < 10; i = i + 2) {
                try {

                    String y = doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1];
                } catch (Exception ERRO) {
                    w = 1;
                    z = 5;
                }
                // </editor-fold>

            }
            for (int i = 1; i <= z; i = i + w) {
                System.out.println(doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1]);
            }
            // </editor-fold>

        } catch (Exception ex /*Caso a pesquisa com 3 filmes de Erro*/) {
            try {
//                java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                //<editor-fold defaultstate="collapsed" desc="Pesquisa 3 primeiros Filmes com as 2 primeiras características">

                Vector<String> VetImg = new Vector<>();
                Document doc = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+" + pesquisa.split("\\W")[0] + pesquisa.split("\\W")[1] + "&sourceid=chrome&ie=UTF-8"
                        + "").get();
                //<editor-fold defaultstate="collapsed" desc="Cálculos do Padrão e Limite">
                int w = 2, z = 6;

                for (int i = 1; i < 10; i = i + 2) {
                    try {

                        String y = doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1];
                    } catch (Exception ERRO) {
                        w = 1;
                        z = 3;
                    }
                    // </editor-fold>

                }
                for (int i = 1; i <= z; i = i + w) {
                    System.out.println(doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1]);
                }
                // </editor-fold>

            } catch (IOException ex1) {
                //          java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex1);
                System.out.println("Erro na primeira parte da pesquisa de 3 fatores");
            }
            try {
                //<editor-fold defaultstate="collapsed" desc="Pesquisa 2 ultimos Filmes com as 2 ultimas características">

                Vector<String> VetImg = new Vector<>();

                Document doc = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+" + pesquisa.split("\\W")[1] + pesquisa.split("\\W")[2] + "&sourceid=chrome&ie=UTF-8"
                        + "").get();

                //<editor-fold defaultstate="collapsed" desc="Cálculos do Padrão e Limite">
                int w = 2, z = 4;
                for (int i = 1; i < 10; i = i + 2) {
                    try {

                        String y = doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1];
                    } catch (Exception ERRO) {
                        w = 1;
                        z = 2;
                    }
                    // </editor-fold>

                }
                for (int i = 1; i <= z; i = i + w) {
                    System.out.println(doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1]);
                }
                // </editor-fold>

            } catch (IOException ex1) {
                //          java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex1);
                System.out.println("Erro na segunda parte da pesquisa de 3 fatores");
            }

        }


    }

}
