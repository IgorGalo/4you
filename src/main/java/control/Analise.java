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

        if (opcoes.size() > 4) {

            Collections.shuffle(opcoes);

        }
        String pesquisa = opcoes.get(0) + "+" + opcoes.get(1) + "+" + opcoes.get(2) + "+" + opcoes.get(3);

//        } else {
//            String pesquisa = opcoes.get(0) + "+" + opcoes.get(1) + "+" + opcoes.get(2);
//        }
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

            Document doc = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+" + pesquisa + "&sourceid=chrome&ie=UTF-8").get();
            int ÍndiceTítulos = 2, LimitePesquisas = 10;

            //<editor-fold defaultstate="collapsed" desc="Cálculos do Padrão e Limite">
            for (int i = 1; i < 10; i = i + 2) {
                try {

                    String y = doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1];
                } catch (Exception ERRO) {
                    ÍndiceTítulos = 1;
                    LimitePesquisas = 5;
                }
                // </editor-fold>

            }
            for (int i = 1; i <= LimitePesquisas; i = i + ÍndiceTítulos) {
                System.out.println(doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1]);
            }
            // </editor-fold>
        } catch (Exception ex /*Caso a pesquisa com 3 filmes de Erro*/) {
//um for dentro do outro c pá

            int indices = 0, NumeroRepet = 0;
            if (pesquisa.split("\\W").length == 3) {
                System.out.println("NRep=2");
                NumeroRepet = 5;
            } else {
                if (pesquisa.split("\\W").length == 4) {
                    System.out.println("NRep=1");
                    NumeroRepet = 3;
                } else {
                    System.out.println("Alargou o balaio");
                }
            }
            for (int i = 1; i <= 6; i++) {
                System.out.println("R");

                //          terror+musical+aventura+ficcaocientifica
                try {
                    switch (i) {
                        case 1:
                            Document doc1 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                    + pesquisa.split("\\W")[0] + pesquisa.split("\\W")[1]
                                    + "&sourceid=chrome&ie=UTF-8").get();
                            for (int j = 1; j < NumeroRepet; j = j + 2) {

                                System.out.println(doc1.getElementsByAttribute("data-ttl").html().split("data-original-name")[j].split("\"")[1]);
                            }
                            break;

                        case 2:
                            Document doc2 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                    + pesquisa.split("\\W")[0] + pesquisa.split("\\W")[2]
                                    + "&sourceid=chrome&ie=UTF-8").get();
                            for (int j = 1; j < NumeroRepet; j = j + 2) {

                                System.out.println(doc2.getElementsByAttribute("data-ttl").html().split("data-original-name")[j].split("\"")[1]);

                            }
                            break;

                        case 3:
                            Document doc3 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                    + pesquisa.split("\\W")[1] + pesquisa.split("\\W")[2]
                                    + "&sourceid=chrome&ie=UTF-8").get();
                            for (int j = 1; j < NumeroRepet; j = j + 2) {

                                System.out.println(doc3.getElementsByAttribute("data-ttl").html().split("data-original-name")[j].split("\"")[1]);
                            }
                            break;

                    }
                    if (pesquisa.split("\\W").length == 4) {
                        System.out.println(";;");
                        switch (i) {

                            case 4:
                                Document doc4 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                        + pesquisa.split("\\W")[3] + pesquisa.split("\\W")[0]
                                        + "&sourceid=chrome&ie=UTF-8").get();
                                System.out.println(doc4.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                                break;
                            case 5:
                                Document doc5 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                        + pesquisa.split("\\W")[3] + pesquisa.split("\\W")[1]
                                        + "&sourceid=chrome&ie=UTF-8").get();
                                System.out.println(doc5.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                                break;
                            case 6:
                                Document doc6 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                        + pesquisa.split("\\W")[3] + pesquisa.split("\\W")[2]
                                        + "&sourceid=chrome&ie=UTF-8").get();
                                System.out.println(doc6.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                                break;
                        }
                    }

                } catch (Exception Erro) {
                    //               java.util.logging.Logger.getLogger(Teste.class.getName()).log(java.util.logging.Level.SEVERE, null, Erro);
                    System.out.println("ok");
                }

            }

        }
    }

}
