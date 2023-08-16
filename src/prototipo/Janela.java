package prototipo;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {

    private final JPanel tela;

    public Janela() {
        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
            }
        };
        super.getContentPane().add(tela);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Janela();
    }
}
