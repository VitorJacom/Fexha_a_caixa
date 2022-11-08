import java.util.Scanner;

public class Fecha_caixa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean tabuleiro[] = new boolean[9];
        Boolean fechaPrograma = false;
        System.out.println("Bem vindo ao jogo Fecha_caixa");
        while (!(fechaPrograma)){
            int comando = Comando.opcaoMenu(in);
            switch (comando) {
                case 0:
                    boolean acabou = false;
                    while(!acabou){
                    Comando.mostraTabuleiro(tabuleiro);
                    Comando.dados(tabuleiro);
                    String a = in.next();
                    if(a.equals("X")){
                        break;
                    }
                    acabou=Comando.acabou(acabou, tabuleiro);
                    }
                    break;
                case 1:
                    System.out.println("nome");
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