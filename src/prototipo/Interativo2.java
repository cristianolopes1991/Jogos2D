package prototipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Interativo2 extends JFrame {

    private final boolean[] controleTeclas = new boolean[4];
    private final int FPS = 1000 / 20; //50
    private JPanel tela;
    private int px;
    private int py;
    private boolean jogando = true;

    public Interativo2() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                setaTecla(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setaTecla(e.getKeyCode(), false);
            }
        });

        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                int x = tela.getWidth() / 2 - 20 + px;
                int y = tela.getHeight() / 2 - 20 + py;

                g.setColor(Color.BLUE);
                g.fillRect(x, y, 40, 40);
                g.drawString("Agora eu estou em " + x + "x" + y, 5, 10);
            }
        };

        getContentPane().add(tela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }

    public void inicia() {
        long prxAtualizacao = 0;

        while (jogando) {
            if (System.currentTimeMillis() >= prxAtualizacao) {
                atualizaJogo();
                tela.repaint();

                prxAtualizacao = System.currentTimeMillis() + FPS;
            }
        }
    }

    private void atualizaJogo() {
        if (controleTeclas[0]) py--;
        else if (controleTeclas[1]) py++;


        if (controleTeclas[2]) px--;
        else if(controleTeclas[3])
            px++;
    }

    private void setaTecla(int tecla, boolean pressionada) {
        switch (tecla) {
            case KeyEvent.VK_ESCAPE:
                //Tecla ESC
                jogando = false;
                dispose();
                break;
            case KeyEvent.VK_UP:
                //Seta para cima
                controleTeclas[0] = pressionada;
                break;
            case KeyEvent.VK_DOWN:
                //Seta para baixo
                controleTeclas[1] = pressionada;
                break;
            case KeyEvent.VK_LEFT:
                //Seta para esquerda
                controleTeclas[2] = pressionada;
                break;
            case KeyEvent.VK_RIGHT:
                //Seta para direita
                controleTeclas[3] = pressionada;
                break;
        }
    }

    public static void main(String[] args) {
        Interativo2 jogo = new Interativo2();
        jogo.inicia();
    }
}
