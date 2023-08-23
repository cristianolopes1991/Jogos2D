package invasao_por_space_invaders;

import javax.swing.*;

public class Jogo extends JFrame {

    private Invader[][] invasores = new Invader[11][5];

    private Invader.Tipos[] tipoPorLinha = { Tipos.PEQUENO, Tipos.MEDIO, Tipos.MEDIO, Tipos.GRANDE, Tipos.GRANDE };

    private void carregarJogo(){
        for(int i = 0; i < invasores.length; i++) {
            for(int j = 0; j < invasores[i].length; j++) {
                Invader e = new Invader(tipoPorLinha[j]);

                e.setAtivo(true);

                e.setPx(i * e.getLargura() + (i + 1) * espacamento);
                e.setPy(j * e.getAltura() + j * espacamento + linhaBase);

                invasores[i][j] = e;
            }
        }
    }
}
