package control;

import javax.swing.ButtonModel;
import view.FramePrincipal;
import view.TelaResultado;

public class Analise {
    
    public void calculaResultado(ButtonModel p1, ButtonModel p2, ButtonModel p3,ButtonModel p4,
            ButtonModel p5,ButtonModel p6,ButtonModel p7,ButtonModel p8,ButtonModel p9,ButtonModel p10){
        System.out.println(p1.getSelectedObjects());
        
        FramePrincipal.trocaPainel("resultado", new TelaResultado());
    }

}
