import java.io.IOException;
import java.util.Scanner;

public class Fecha_caixa {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Tabuleiro jogo1 = new Tabuleiro();
        Boolean fechaPrograma = false;
        String inputFileName = "Rank_Fecha_Caixa.csv";
        System.out.println("Bem vindo ao jogo Fecha_caixa");

        while (!(fechaPrograma)) {
            
            int comando = Comando.opcaoMenu(in);
            switch (comando) {
                case 0:
                    Comando.jogo(jogo1, in);
                    break;
                case 1:
                    jogo1.mudaNome(in);
                    break;
                case 2:
                    Comando.regras(in);
                    break;
                case 3:
                    Cria_rank.lePlacar(inputFileName);
                    break;
                case 4:
                    fechaPrograma = true;
                    break;
                default:
                    System.out.println("Não existe o comando");

            }
        }

        in.close();
    }
}