import java.util.Scanner;

public class Comando {
    /**mostra as opcao
     * @param in
     * @return a opcao do menu
     */
    public static int opcaoMenu(Scanner in) {
        System.out.println("-------------");
        System.out.println("|  0- Iniciar o jogo  |  1- Inserir o nome do jogador |  2- Mostrar as regras  | 3- Mostrar o ranking | 4 - Fechar o jogo |"+
        "5- Mostrar");
        return in.nextInt();
    }

    

    /**
     * @param tabuleiro
     * Imprime o tabuleiro
     */
    public static void mostraTabuleiro(boolean[] tabuleiro) {
        System.out.println();
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print("|");
            if(tabuleiro[i]){
                System.out.print("X");
            }else{
                System.out.print(i+1);
            }
            System.out.print("|");
        }
        System.out.println();
    }

    /**
     * @param tabuleiro
     * @return dados 
     * valor que foi sorteado nos dados
     */
    public static int dados(boolean[] tabuleiro) {;
        tabuleiro[8] = true; tabuleiro[7]=true; tabuleiro[6]=false;
        int quatidadeDados = tabuleiro.length/6;
        int dados = 0;
        if(tabuleiro[8] && tabuleiro[7] && tabuleiro[6]){
            // ^ ^
            //  v
        }else if((tabuleiro.length%6)>0){
            quatidadeDados += 1;
            
        }
        for (int index = 0; index < quatidadeDados; index++) {
            int dado = (int)(Math.random() * 6) + 1;
            dados += dado;
            System.out.println("dado "+ (index+1) +": " +dado);
        }
        return dados;
    }

    /**
     * @param acabou
     * @param tabuleiro
     * @return acabou
     * Verifica o tabuleiro se todas as casas estao fechadas se nao o jogo continua
     */
    public static boolean acabou(boolean acabou, boolean[] tabuleiro) {
        acabou = true;
        for (int i = 0; i < tabuleiro.length; i++) {
            if(!(tabuleiro[i])){
                acabou = false;
            }
        }
        return acabou;
    }

    /**
     * @param in 
     * verifica se o jogador quer saber das regras
     */
    public static void regras(Scanner in) {
        System.out.println("Deseja saber as regras?");
        System.out.println("S/N");
        String visualizar = in.next().toUpperCase();
            if (visualizar.equals("N")){ return;}
                System.out.println();
                System.out.println("O objetivo do jogo é totalizar o menor número de pontos tentando fechar todas as casas do tabuleiro.");
                System.out.println("A pontuação de um jogador corresponde aos valores totais obtidos nos dados e que não foram" +
                "aproveitados para fechar nenhuma casa.");
                try { Thread.sleep (5000); } catch (InterruptedException ex) {}
                System.out.println("\nInicialmente todas as casas numeradas de 1 até 9 são deixadas abertas. E inicia-se a partida com"+ 
                "o lançamento de dois dados.");
                try { Thread.sleep (5000); } catch (InterruptedException ex) {}
                System.out.print("O jogador deve decidir quais casas ou números do tabuleiro irá fechar para que sua soma coincida com o"+
                "valor total obtido nos dados.");
                try { Thread.sleep (5000); } catch (InterruptedException ex) {}
                System.out.println("\nPor exemplo, se o jogador obtiver 6 e 4 nos dados, a soma será 10. Portanto, ele poderá optar em fechar"+
                "qualquer combinação que totalize 10: 1 e 9; 2 e 8; 3 e 7; 4 e 6; 1, 2 e 7; 1, 3 e 6; 1, 4 e 5; 2, 3 e 5; 1, 2,"+
                " 3 e 4. Os valores da soma devem ser aproveitados integralmente.");
                try { Thread.sleep (5000); } catch (InterruptedException ex) {}
                System.out.println("\nSe o jogador tirar 2 e 7, cuja soma é 9, poderá fechar apenas a casa 9, ou qualquer outra combinação de"+
                "casas que totalize exatamente 9.");
                try { Thread.sleep (5000); } catch (InterruptedException ex) {}
                System.out.println("\nO jogador continua jogando os 2 dados e escolhendo que casas ainda abertas devem ser fechadas, até"+
                "fechar as casas de números 7, 8 e 9. A partir do fechamento destas 3 casas, o jogador passará a lançar apenas 1 dado.");
                try { Thread.sleep (5000); } catch (InterruptedException ex) {}
                System.out.println("\nO jogo prossegue até se fechar todas as casas e, sempre que não for possível aproveitar o valor total da"+
                "soma dos dados, acumula-se este valor como pontuação. Quanto menor a pontuação, maior foi o"+
                "aproveitamento dos valores dos dados e tanto melhor terá sido o desempenho do jogador.");
                System.out.println();
                System.out.println();
                return;
            }
    
}
