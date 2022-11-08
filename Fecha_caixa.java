import java.util.Scanner;

public class Fecha_caixa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Bem vindo ao jogo Fecha_caixa");
        Comando.regras(in);
        boolean tabuleiro[] = new boolean[9];
        boolean acabou = false;
        while(!acabou){
            Comando.dados(tabuleiro);
            String a = in.next();
            Comando.acabou(acabou, tabuleiro);
        }
        
        in.close();
    }
}