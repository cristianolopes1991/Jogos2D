package prototipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InterativoMouse extends JFrame {
    private final int FPS = 1000 / 20; // 50
    private final JPanel tela;
    private int px, py;
    private Point mouseClick = new Point();
    private boolean jogando = true;

    public InterativoMouse() {
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

        tela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Clique do mouse
                mouseClick = e.getPoint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //Botão mouse pressionado
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //Botão mouse liberado
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //Mouse entrou na tela
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Mouse saiu da tela
            }
        });

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

    private void atualizaJogo(){
        px = mouseClick.x;
        py = mouseClick.y;
    }

    public static void main(String[] args) {
        InterativoMouse jogo = new InterativoMouse();
        jogo.inicia();
    }
}
