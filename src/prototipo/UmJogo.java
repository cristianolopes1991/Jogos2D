package prototipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class UmJogo extends JFrame {

    private final int FPS = 1000 / 20;
    private final JPanel tela;
    private final boolean jogando = true;
    private final boolean fimDeJogo = false;
    private final Elemento tiro;
    private final Elemento jogador;
    private final Elemento[] blocos;
    private int pontos;
    private final int larg = 50; //Largura padrão
    private final int linhaLimite = 350;
    private final Random r = new Random();
    private final boolean[] controleTecla = new boolean[4];

    public UmJogo() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        tiro = new Elemento(0, 0, 1, 0);
        jogador = new Elemento(0, 0, larg, larg);
        jogador.velocidade = 5;

        blocos = new Elemento[5];
        for (int i = 0; i < blocos.length; i++) {
            int espaco = i * larg + 10 * (i + 1);
            blocos[i] = new Elemento(espaco, 0, larg, larg);
            blocos[i].velocidade = 1;
        }

        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, tela.getWidth(), tela.getHeight());

                g.setColor(Color.RED);
                g.fillRect(tiro.x, tiro.y, tiro.largura, tela.getHeight());
                g.setColor(Color.GREEN);

                g.fillRect(jogador.x, jogador.y, jogador.largura, jogador.altura);

                g.setColor(Color.BLUE);
                for (Elemento bloco : blocos) {
                    g.fillRect(bloco.x, bloco.y, bloco.largura, bloco.altura);
                }

                g.setColor(Color.GRAY);
                g.drawLine(0, linhaLimite, tela.getWidth(), linhaLimite);

                g.drawString("Pontos: " + pontos, 0, 10);
            }
        };

        getContentPane().add(tela);
        setResizable(false);
        jogador.x = tela.getWidth() / 2 - jogador.x / 2;
        jogador.y = tela.getHeight() - jogador.altura;
        tiro.altura = tela.getHeight() - jogador.altura;
    }

    public void inicia() {

    }

    private void atualizaJogo(){
        if(fimDeJogo)
            return;

        if(controleTecla[2])
            jogador.x -= jogador.velocidade;

        else if(controleTecla[3])
            jogador.x += jogador.velocidade;

        if(jogador.x < 0)
            jogador.x = tela.getWidth() - jogador.largura;

        if(jogador.x + jogador.largura > tela.getWidth())
            jogador.x = 0;

        tiro.y = 0;
        tiro.x = jogador.x + jogador.largura / 2;
    }

    class Elemento {
        public int x, y, largura, altura;
        public float velocidade;

        public Elemento(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.largura = width;
            this.altura = height;
        }
    }
}
