import java.util.Scanner;

public class Tabuleiro {
    private boolean[] tabuleiro;

    private String jogador;

    private int dados;

    private int pontoAcumalado;

    /**
     * Construtor do objeto
     */
    public Tabuleiro() {
        tabuleiro = new boolean[9];
        jogador = null;
        dados = 0;
        pontoAcumalado = 0;
    }

    /**
     * @param in Scanner do terminal
     *           Muda o nome do jogador
     */
    public void mudaNome(Scanner in) {
        System.out.println("Escreva nome do jogador");
        System.out.println("O nome pecisa ser tudo junto");
        jogador = in.next();
    }

    /**
     * @return o nome do jogador
     * 
     */
    public String pegaNome() {
        return jogador;
    }

    /**
     * @return o tabuleiro do jogo
     */
    public boolean[] pegaTabuleiro() {
        return tabuleiro;
    }

    /**
     * @param casa do tabuleiro do jogo em formato de array
     *             fecha ou abre a casa solicitada
     */
    public void mudaTabuleiro(int casa) {
        if (tabuleiro[casa - 1]) {
            tabuleiro[casa - 1] = false;
        } else {
            tabuleiro[casa - 1] = true;

        }

    }

    /**
     * abre todas as casas
     */
    public void resetaTabuleiro() {
        tabuleiro = new boolean[9];
    }

    /**
     * @param n numero do dado
     *          muda o valor dos dados
     */
    public void mudaDados(int n) {
        dados = n;
    }

    /**
     * @return dados retorna o valor dos dados
     * 
     */
    public int mostraDados() {
        return dados;
    }

    /**
     * reseta o valor dos dados
     */
    public void resetaDados() {
        dados = 0;
    }

    /**
     * reseta os items do jogo menos o nome do jogador
     */
    public void resetaJogo() {
        tabuleiro = new boolean[9];
        dados = 0;
        pontoAcumalado = 0;
    }

    /**
     * @param p o valor para ser incrementado
     *          acumula pontos perdidos nos dados
     */
    public void acumalaPonto(int p) {
        pontoAcumalado += p;
    }

    /**
     * @return pontoAcumalado valor dos pontoAcumalado
     */
    public int mostraPonto() {
        return pontoAcumalado;
    }

    /**
     * reseta os pontosAcumulados
     */
    public void resetaPonto() {
        pontoAcumalado = 0;
    }

}
