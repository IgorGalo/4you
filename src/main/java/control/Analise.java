package control;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import view.FramePrincipal;
import view.TelaResultado;

public class Analise {

    public void calculaResultado(Vector<Integer> opcoes, int escolha, JRadioButton opcao1Btn, JRadioButton opcao2Btn, JRadioButton nenhumaBtn) {

        System.out.println(opcoes);

        Vector<String> generos = new Vector<>();

        switch (opcoes.get(0)) {
            case 1:
                switch (escolha) {
                    case 1:
                        generos.add("comedia"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("drama"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 3:
                break;
            default:
                throw new AssertionError();
        }

        switch (opcoes.get(1)) {
            case 1:
                switch (escolha) {
                    case 1:
                        generos.add("documentario"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("ficcaocientifica"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 3:
                break;
            default:
                throw new AssertionError();
        }

        switch (opcoes.get(2)) {
            case 1:
                switch (escolha) {
                    case 1:
                        generos.add("acao"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("msuical"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 3:
                break;
            default:
                throw new AssertionError();
        }

        switch (opcoes.get(3)) {
            case 1:
                switch (escolha) {
                    case 1:
                        generos.add("terror"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("romance"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 3:
                break;
            default:
                throw new AssertionError();
        }

        switch (opcoes.get(4)) {
            case 1:
                switch (escolha) {
                    case 1:
                        generos.add("mistério"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("aventura"); // filme
                        break;
                    case 2:
                        //livro opcoes.add("");
                        break;
                    case 3:

                        break;
                }
                break;

            case 3:
                break;
            default:
                throw new AssertionError();
        }

        Vector<String> resultado = new Vector<>();
        String pesquisa;

        if (generos.isEmpty()) {
            pesquisa = "novos";
            System.out.println(pesquisa);
        } else {

            if (opcoes.size() > 5) {

                Collections.shuffle(generos);

            }
            pesquisa = generos.get(0) + "+" + generos.get(1) + "+" + generos.get(2);

            System.out.println(opcoes + " " + pesquisa);
        }

        System.out.println(generos);
        System.out.println(pesquisa);

        switch (escolha) {
            case 1:
//                resultado = fazPesquisaFilme(pesquisa);
                fazPesquisaFilme(pesquisa);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void fazPesquisaFilme(String pesquisa) {
        Vector<Icon> iconVet = new Vector<>();
        Vector<String> resultado = new Vector<>();
        try {

            Document doc = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+" + pesquisa + "&sourceid=chrome&ie=UTF-8").get();
            int ÍndiceTítulos = 2, LimitePesquisas = 6;

            //<editor-fold defaultstate="collapsed" desc="Cálculos do Padrão e Limite">
            for (int i = 1; i < 10; i = i + 2) {
                try {
                    String y = doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1];
                } catch (Exception ERRO) {
                    ÍndiceTítulos = 1;
                    LimitePesquisas = 3;
                }
            }
            // </editor-fold>

            for (int i = 1, IndiceImg = 0, numFilme = 1; i <= LimitePesquisas; IndiceImg++, numFilme = numFilme + 2, i = i + ÍndiceTítulos) {
                System.out.println(doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1]);
                resultado.add(doc.getElementsByAttribute("data-ttl").html().split("data-original-name")[i].split("\"")[1]);
                iconVet.add(PesquisaImagens(doc, numFilme));

            }
        } catch (Exception ex /*Caso a pesquisa com 3 filmes de Erro*/) {

            for (int i = 1; i <= 3; i++) {
                //          terror+musical+aventura
                try {
                    switch (i) {
                        case 1:
                            Document doc1 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                    + pesquisa.split("\\W")[0] + pesquisa.split("\\W")[1]
                                    + "&sourceid=chrome&ie=UTF-8").get();
                            System.out.println(doc1.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            resultado.add(doc1.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            iconVet.add(PesquisaImagens(doc1, 1));

                            break;

                        case 2:
                            Document doc2 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                    + pesquisa.split("\\W")[0] + pesquisa.split("\\W")[2]
                                    + "&sourceid=chrome&ie=UTF-8").get();
                            System.out.println(doc2.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            resultado.add(doc2.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            iconVet.add(PesquisaImagens(doc2, 1));

                            break;

                        case 3:
                            Document doc3 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                    + pesquisa.split("\\W")[1] + pesquisa.split("\\W")[2]
                                    + "&sourceid=chrome&ie=UTF-8").get();
                            System.out.println(doc3.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            resultado.add(doc3.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            iconVet.add(PesquisaImagens(doc3, 1));

                            break;

                    }

                } catch (Exception Erro) {
//                    java.util.logging.Logger.getLogger(Analise.class
//                            .getName()).log(java.util.logging.Level.SEVERE, null, Erro);
//                    System.out.println("ok");
                }

            }

        }
        ItemControl itemC = new ItemControl();
        itemC.addItem(resultado, "Filme");
        FramePrincipal.trocaPainel("tela resultado", new TelaResultado(resultado, iconVet));
    }

    private Icon PesquisaImagens(Document doc, int numFilme) {
        try {
            String base64Image =/* "data:image/jpeg;base64," + */ doc.getAllElements().toString().split("data:image/jpeg;base64,")[numFilme].split("'")[0];
            base64Image = base64Image.replace("\\" + "x" + "3" + "d", "=");

            byte[] decode = Base64.getDecoder().decode(base64Image);
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(decode));

            ImageIcon icon = new ImageIcon(img);

            return icon;
        } catch (IOException ex) {
            System.err.println("ERRO img");
            Logger.getLogger(Analise.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
