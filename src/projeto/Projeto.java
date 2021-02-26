package projeto;

import javax.swing.JFrame;
import view.JFrameInicial;

public class Projeto {

    public static void main(String[] args) {
        JFrameInicial inicial = new JFrameInicial();
        inicial.setExtendedState(JFrame.MAXIMIZED_BOTH);
        inicial.setVisible(true);
    }
    
}
