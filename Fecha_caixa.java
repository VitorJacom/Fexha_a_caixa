import java.util.Scanner;

public class Fecha_caixa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Tabuleiro jogo1 = new Tabuleiro();
        Boolean fechaPrograma = false;
        System.out.println("Bem vindo ao jogo Fecha_caixa");

        while (!(fechaPrograma)){
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
                    System.out.println("rank");
                    break;
                case 4:
                    fechaPrograma = true;
                    break;
                default:
                    System.out.println("Não existe o comando");;

                
            }
        }




        
        in.close();
    }
}