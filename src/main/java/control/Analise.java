package control;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
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
import org.jsoup.nodes.Element;
import view.FramePrincipal;
import view.TelaResultado;

public class Analise {

    private ItemControl itemC = new ItemControl();
    
//Analisa as respostas e gera combinações dos gêneros 
    public void calculaResultado(Vector<Integer> opcoes, int escolha, JRadioButton opcao1Btn, JRadioButton opcao2Btn, JRadioButton nenhumaBtn) {

        System.out.println(opcoes);

        Vector<String> generos = new Vector<>();

        switch (opcoes.get(0)) {
            case 1:
                switch (escolha) {
                    case 1:
                        generos.add("terror"); // filme
                        break;
                    case 2:
                        generos.add("romance");
                        break;
                    case 3:
                        generos.add("rock");
                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("romance"); // filme
                        break;
                    case 2:
                        generos.add("realismo");
                        break;
                    case 3:
                        generos.add("jazz");
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
                        generos.add("misterio"); // filme
                        break;
                    case 2:
                        generos.add("misterio");
                        break;
                    case 3:
                        generos.add("gotico");
                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("aventura"); // filme
                        break;
                    case 2:
                        generos.add("aventura");
                        break;
                    case 3:
                        generos.add("samba");
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
                        generos.add("drama"); // filme
                        break;
                    case 2:
                        generos.add("biografia");
                        break;
                    case 3:
                        generos.add("classico");
                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("comedia"); // filme
                        break;
                    case 2:
                        generos.add("fantasia");
                        break;
                    case 3:
                        generos.add("K-pop");
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
                        generos.add("musical"); // filme
                        break;
                    case 2:
                        generos.add("classico");
                        break;
                    case 3:
                        generos.add("funk");
                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("acao"); // filme
                        break;
                    case 2:
                        generos.add("cronica");
                        break;
                    case 3:
                        generos.add("reggae");
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
                        generos.add("ficcaocientifica"); // filme
                        break;
                    case 2:
                        generos.add("drama");
                        break;
                    case 3:
                        generos.add("pop");
                        break;
                }
                break;

            case 2:
                switch (escolha) {
                    case 1:
                        generos.add("documentario"); // filme
                        break;
                    case 2:
                        generos.add("comedia");
                        break;
                    case 3:
                        generos.add("sertanejo");
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
        } else {

            if (opcoes.size() > 5) {

                Collections.shuffle(generos);

            }
            pesquisa = generos.get(0) + "+" + generos.get(1) + "+" + generos.get(2);
        }

        switch (escolha) {
            case 1:
                fazPesquisaFilme(pesquisa);
                break;
            case 2:
                fazPesquisaLivro(pesquisa);
                break;
            case 3:
                fazPesquisaMusica(pesquisa);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void fazPesquisaLivro(String pesquisa) {
        Vector<Icon> iconVet = new Vector<>();
        Vector<String> resultado = new Vector<>();
        Vector<String> resultadoAutores = new Vector<>();

        try {

            Document doc = (Document) Jsoup.connect("https://www.google.com/search?q=livros+" + pesquisa + "&sourceid=chrome&ie=UTF-8"
                    + "").get();

            Elements htmlElements = doc.getAllElements();

            for (Element e : htmlElements) {
                conexaoLivros(e, resultado, resultadoAutores, 0);
            }
            for (int i = 0, numLivro = 1; i < 3; i++, numLivro = numLivro + 2) {
                iconVet.add(PesquisaImagens(doc, numLivro, resultado, i));
            }
        } catch (Exception ex) {

            try {
                Document doc = (Document) Jsoup.connect("https://www.google.com/search?q=livros+"
                        + pesquisa.split("\\W")[0] + "&sourceid=chrome&ie=UTF-8").get();
                Elements htmlElements = doc.getAllElements();

                for (Element e : htmlElements) {
                    conexaoLivros(e, resultado, resultadoAutores, 0);
                }
                for (int i = 0, numLivro = 1; i < 3; i++, numLivro = numLivro + 2) {
                    iconVet.add(PesquisaImagens(doc, numLivro, resultado, i));
                }
            } catch (IOException ex1) {
                Logger.getLogger(Analise.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(resultado.get(i) + " de " + resultadoAutores.get(i));
        }
        itemC.addItem(resultado, "Livro");
        FramePrincipal.trocaPainel("tela resultado", new TelaResultado(resultado, iconVet));

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
                iconVet.add(PesquisaImagens(doc, numFilme, resultado, IndiceImg));
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
                            iconVet.add(PesquisaImagens(doc1, 1, resultado, 0));

                            break;

                        case 2:
                            Document doc2 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                    + pesquisa.split("\\W")[0] + pesquisa.split("\\W")[2]
                                    + "&sourceid=chrome&ie=UTF-8").get();
                            System.out.println(doc2.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            resultado.add(doc2.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);

                            iconVet.add(PesquisaImagens(doc2, 1, resultado, 1));

                            break;

                        case 3:
                            Document doc3 = (Document) Jsoup.connect("https://www.google.com/search?q=filmes+"
                                    + pesquisa.split("\\W")[1] + pesquisa.split("\\W")[2]
                                    + "&sourceid=chrome&ie=UTF-8").get();
                            System.out.println(doc3.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            resultado.add(doc3.getElementsByAttribute("data-ttl").html().split("data-original-name")[1].split("\"")[1]);
                            iconVet.add(PesquisaImagens(doc3, 1, resultado, 2));

                            break;

                    }

                } catch (Exception Erro) {
//                    java.util.logging.Logger.getLogger(Analise.class
//                            .getName()).log(java.util.logging.Level.SEVERE, null, Erro);
//                    System.out.println("ok");
                }

            }

        }
        itemC.addItem(resultado, "Filme");
        FramePrincipal.trocaPainel("tela resultado", new TelaResultado(resultado, iconVet));
    }

    private void fazPesquisaMusica(String pesquisa) {
        Vector<Icon> iconVet = new Vector<>();
        Vector<String> resultado = new Vector<>();
        Vector<String> resultadoAutores = new Vector<>();

        BufferedInputStream ArqMusicas;
        try {
            ArqMusicas = new BufferedInputStream(new URL("https://itunes.apple.com/search?term=" + pesquisa + "&entity=musicTrack&limit=10").openStream());

            String Music = new String(ArqMusicas.readAllBytes());

            String[] VetMus = new String[Music.split("\n").length];

            for (int i = 0; i < Music.split("\n").length; i++) {

                VetMus[i] = Music.split("\n")[i];
            }
            int limiteMusicas = 10;
            for (int i = 6; i <= limiteMusicas; i = i + 2) {
                if (i > 6) {
                    for (int j = 6; j < i; j = j + 2) {
                        if (VetMus[i].split(":")[8].split("\"")[1].equalsIgnoreCase(VetMus[j].split(":")[8].split("\"")[1]) /* && VetMus[i].split(":")[6].split("\"")[1].equalsIgnoreCase(VetMus[j].split(":")[6].split("\"")[1])*/) {

                            System.out.println("Repetido");
                            limiteMusicas = limiteMusicas + 2;

                        } else {
                            resultado.add(VetMus[i].split(":")[8].split("\"")[1]);
                            resultadoAutores.add(VetMus[i].split(":")[6].split("\"")[1]);
                            iconVet.add(PesquisaImagensMusicas(VetMus[i]));
                            break;

                        }
                    }
                } else {
                    resultado.add(VetMus[i].split(":")[8].split("\"")[1]);
                    resultadoAutores.add(VetMus[i].split(":")[6].split("\"")[1]);
                    iconVet.add(PesquisaImagensMusicas(VetMus[i]));

                }

                //<editor-fold defaultstate="collapsed" desc="Testes audio">
//
//                System.out.println(VetMus[i + 1].split("\"")[3]);
//                URL oUrl = new URL(VetMus[i + 1].split(VetMus[i + 1].split("\"")[3]).toString());
//                
//                
//                
//                Clip oClip = AudioSystem.getClip();
//                AudioInputStream oStream = AudioSystem.getAudioInputStream(oUrl);
//                oClip.open(oStream);
//                oClip.loop(0);
            }

//            JSONObject objtjson = new JSONObject(new String(ArqMusicas.readAllBytes()));
//            
//                BufferedReader in = new BufferedReader(marcaLeitura);
//                System.out.println(in.readLine());
            // </editor-fold>
        } catch (Exception ERRO) {
            //Caso erro na pesquisa, fazer pesquisa por categorias separadamente
            BufferedInputStream ArqMusicas1, ArqMusicas2, ArqMusicas3;

            try {
                for (int i = 1; i <= 3; i++) {
                    switch (i) {
                        case 1:
                            ArqMusicas1 = new BufferedInputStream(new URL("https://itunes.apple.com/search?term=" + pesquisa.split("\\W")[0] + "&entity=musicTrack&limit=10").openStream());

                            String Music1 = new String(ArqMusicas1.readAllBytes());

                            String[] VetMus1 = new String[Music1.split("\n").length];

                            resultado.add(VetMus1[i].split(":")[8].split("\"")[1]);
                            resultadoAutores.add(VetMus1[i].split(":")[6].split("\"")[1]);
                            iconVet.add(PesquisaImagensMusicas(VetMus1[i]));

                            break;
                        case 2:
                            ArqMusicas2 = new BufferedInputStream(new URL("https://itunes.apple.com/search?term=" + pesquisa.split("\\W")[1] + "&entity=musicTrack&limit=10").openStream());

                            String Music2 = new String(ArqMusicas2.readAllBytes());

                            String[] VetMus2 = new String[Music2.split("\n").length];

                            resultado.add(VetMus2[i].split(":")[8].split("\"")[1]);
                            resultadoAutores.add(VetMus2[i].split(":")[6].split("\"")[1]);
                            iconVet.add(PesquisaImagensMusicas(VetMus2[i]));
                            break;
                        case 3:
                            ArqMusicas3 = new BufferedInputStream(new URL("https://itunes.apple.com/search?term=" + pesquisa.split("\\W")[2] + "&entity=musicTrack&limit=10").openStream());

                            String Music3 = new String(ArqMusicas3.readAllBytes());

                            String[] VetMus3 = new String[Music3.split("\n").length];

                            resultado.add(VetMus3[i].split(":")[8].split("\"")[1]);
                            resultadoAutores.add(VetMus3[i].split(":")[6].split("\"")[1]);
                            iconVet.add(PesquisaImagensMusicas(VetMus3[i]));
                            break;
                    }
                }
            } catch (Exception Erro) {

            }
        }
        for (int i = 0; i < resultado.size(); i++) {
            System.out.println(resultado.get(i) + " de " + resultadoAutores.get(i));
        }
        itemC.addItem(resultado, "Musica");
        FramePrincipal.trocaPainel("tela resultado", new TelaResultado(resultado, iconVet));

    }

    private Icon PesquisaImagens(Document doc, int numFilme, Vector<String> resultado, int indice) {
        try {
            String base64Image =/* "data:image/jpeg;base64," + */ doc.getAllElements().toString().split("data:image/jpeg;base64,")[numFilme].split("'")[0];
            base64Image = base64Image.replace("\\" + "x" + "3" + "d", "=");

            byte[] decode = Base64.getDecoder().decode(base64Image);
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(decode));

            itemC.cadastraImagemItem(decode, resultado.get(indice));

            ImageIcon icon = new ImageIcon(img);

            return icon;
        } catch (IOException ex) {
            System.err.println("ERRO img");
            Logger
                    .getLogger(Analise.class
                            .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    private void conexaoLivros(Element e, Vector<String> resultado, Vector<String> resultadoAutores, int verificação) {

        //System.out.println(e.classNames());
        if (e.classNames().contains("dAassd")) {
            Elements nomeFilme = e.getElementsByClass("FozYP");
            String nomeStr = "";
            String autor = "";
            if (!nomeFilme.isEmpty()) {
                autor += (nomeFilme.last() + "").split(">")[1].split("<")[0].split(",")[0].trim();
                nomeFilme.remove(nomeFilme.size() - 1); //autor
                for (Element eSub : nomeFilme) {

                    //System.out.print(eSub.html());
                    nomeStr += eSub.html() + " ";
                }
            }
            resultado.add(nomeStr);
            resultadoAutores.add(autor);

        }

    }

    private Icon PesquisaImagensMusicas(String InfoMus) {
        try {

            Document doc = (Document) Jsoup.connect(InfoMus.split(":")[13].split("\"")[1] + ":" + InfoMus.split(":")[14].split("\"")[0]).get();
            String UrlImg = doc.getAllElements().toString().split("property=\"og:image\" content=\"")[1].split("\"")[0];
            BufferedImage img = ImageIO.read(new URL(UrlImg));
            ImageIcon icon = new ImageIcon(img);
            return icon;

        } catch (Exception ex) {
            Logger.getLogger(Analise.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
