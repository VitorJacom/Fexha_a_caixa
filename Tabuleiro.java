import java.util.Scanner;

public class Tabuleiro {
    private boolean[] tabuleiro;

    private String jogador;

    private int dados;

    private int pontoAcumalado;

    public Tabuleiro() {
        tabuleiro = new boolean[9];
        jogador = null;
        dados = 0;
        pontoAcumalado = 0;
    }

    public void mudaNome(Scanner in) {
        System.out.println("Escreva nome do jogador");
        System.out.println("O nome pecisa ser tudo junto");
        jogador = in.next();
    }

    public String pegaNome() {
        return jogador;
    }

    public boolean[] pegaTabuleiro() {
        return tabuleiro;
    }

    public void mudaTabuleiro(int casa) {
        if (tabuleiro[casa - 1]) {
            tabuleiro[casa - 1] = false;
        } else {
            tabuleiro[casa - 1] = true;

        }

    }

    public void resetaTabuleiro() {
        tabuleiro = new boolean[9];
    }

    public void mudaDados(int n) {
        dados = n;
    }

    public int mostraDados() {
        return dados;
    }

    public void resetaDados() {
        dados = 0;
    }

    public void resetaJogo() {
        tabuleiro = new boolean[9];
        dados = 0;
        pontoAcumalado = 0;
    }

    public void acumalaPonto(int p) {
        pontoAcumalado += p;
    }

    public int mostraPonto() {
        return pontoAcumalado;
    }

    public void resetaPonto() {
        pontoAcumalado = 0;
    }

    
}

