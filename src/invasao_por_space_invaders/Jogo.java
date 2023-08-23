package invasao_por_space_invaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Jogo extends JFrame {

    private static final int FPS = 100 / 20;
    private static final int JANELA_ALTURA = 680;
    private static final int JANELA_LARGURA = 540;
    private final Invader[][] invasores = new Invader[11][5];
    private final boolean[] controleTecla = new boolean[5];
    private final Invader.Tipos[] tipoPorLinha = {Tipos.PEQUENO, Tipos.MEDIO, Tipos.MEDIO, Tipos.GRANDE, Tipos.GRANDE};
    private final JPanel tela;
    private final Graphics g2d;
    private final BufferedImage buffer;


    public Jogo() {
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
                setaTecla(e.getKeyCode(), true);
            }
        });

        buffer = new BufferedImage(JANELA_LARGURA, JANELA_ALTURA, BufferedImage.TYPE_INT_RGB);

        g2d = buffer.createGraphics();

        tela = new JPanel() {
            private static final long serialVerionUID = 1L;

            public void paintComponent(Graphics g) {
                g.drawImage(buffer, 0, 0, null);
            }
        };

        getContentPane().add(tela);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setVisible(true);
    }

    private void setaTecla(int tecla, boolean pressionada) {
        switch (tecla) {
            case KeyEvent.VK_UP:
                controleTecla[0] = pressionada;
                break;
            case KeyEvent.VK_DOWN:
                controleTecla[1] = pressionada;
                break;
            case KeyEvent.VK_LEFT:
                controleTecla[2] = pressionada;
                break;
            case KeyEvent.VK_RIGHT:
                controleTecla[3] = pressionada;
                break;
            case KeyEvent.VK_SPACE:
                controleTecla[4] = pressionada;
                break;
        }
    }

    private int vidas = 3;

    private Elemento vida = new Tanque();
    private Elemento tiroTanque;
    private Elemento tiroChefe;
    private Elemento[] tiros = new Tiro[3];
    private Texto texto = new Texto();
    private int linhaBase = 60;
    private int espacamento = 15;
    private int destruidos = 0;
    private int dir;
    private int totalInimigo;
    private int contadorEspera;
    boolean novaLinha;
    boolean moverInimigo;
    private int contador;
    private int pontos;
    private int level = 1;
    private Random random = new Random();
    private Elemento[] nivel;

    private void carregarJogo() {
        int total = 0;
        int _LARG = 10;


        for (int i = 0; i < invasores.length; i++) {
            for (int j = 0; j < invasores[i].length; j++) {
                Invader e = new Invader(tipoPorLinha[j]);

                e.setAtivo(true);

                e.setPx(i * e.getLargura() + (i + 1) * espacamento);
                e.setPy(j * e.getAltura() + j * espacamento + linhaBase);

                invasores[i][j] = e;
            }
        }
    }
}
