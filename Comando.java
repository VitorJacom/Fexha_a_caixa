import java.util.Scanner;

public class Comando {
    /**mostra as opcao
     * @param in
     * @return a opcao do menu
     */
    public static int opcaoMenu(Scanner in) {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|  0- Iniciar o jogo  |  1- Alterar nome do jogador |  2- Mostrar as regras  | 3- Mostrar o ranking | 4 - Fechar o jogo |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");

        return in.nextInt();
    }


    
    /**
     * @param jogo
     * @param in
     */
    public static void jogo(Tabuleiro jogo, Scanner in) {
        if(jogo.pegaNome()== null){jogo.mudaNome(in);}
        Tabuleiro dummy = new Tabuleiro();
        boolean acabou =false;
        while(!acabou){;

            Comando.opcaoJogo(jogo);
            Comando.mostraTabuleiro(jogo);
            System.out.print("/---------------------------\\");
            Comando.mostraTabuleiroDummy(dummy);
            boolean ff= Comando.acao(jogo, dummy, in);
            if(ff){ break;}
            acabou=Comando.acabou(acabou, jogo);
        }
        jogo.resetaJogo();
        
    }

    /**
     * @param jogo
     * @param dummy
     * @param in
     * @return
     */
    public static boolean acao(Tabuleiro jogo, Tabuleiro dummy, Scanner in) {
            String opcao = in.next().toUpperCase();
            try{
                 int casaFechada = Integer.parseInt(opcao);
                 dummy.mudaTabuleiro(casaFechada);
                 return false;
                
            }catch(NumberFormatException exception){
                switch (opcao) {
                    case "X":
                        Comando.verificao(jogo, dummy,in);
                        return false;
                
                    case "O":
                  
                        return false;

                    case "FF":
                  
                        return true;

                    case "R":
                        Comando.rolaDado(jogo);
                        return false;

                    default:

                        return false;
                }
             }
        
    }

    /**
     * @param jogo
     * @param dummy
     * @param in
     */
    public static void verificao(Tabuleiro jogo, Tabuleiro dummy,Scanner in) {
        int casaFechada = 0;
        for (int i = 0; i < (dummy.pegaTabuleiro()).length; i++) {
            if(dummy.pegaTabuleiro()[i]){
                casaFechada += i+1;
            }  
        }

        for (int i = 0; i < (dummy.pegaTabuleiro()).length; i++) {
                if(dummy.pegaTabuleiro()[i]){
                    if(jogo.pegaTabuleiro()[i]){
                        System.out.println("A CASA JA FOI FECHADA \n");

                        return;
                    }
                }
        }
        if(casaFechada!=jogo.mostraDados()){
            System.out.println("PRECISA USAR O NUMERO EXATO DOS DADOS \n");
            
            return;
        }
        for (int i = 0; i < (dummy.pegaTabuleiro()).length; i++) {
            if(dummy.pegaTabuleiro()[i]){
                jogo.mudaTabuleiro(i+1);
            }

        }
        dummy.resetaTabuleiro();
        jogo.resetaDados();

        
        
    }

    /**
     * 
     */
    public static void opcaoJogo(Tabuleiro jogo) {
        System.out.println("| Escolha as casas para fechar ou abri-las |");
        System.out.println("| R - Para rolar os dados | X- Para fechar | O - para passar a vez | FF - Para desistir |"); 
        if(jogo.mostraDados()>0){ System.out.println("Valor dos dados {" + jogo.mostraDados()+ "}");}
    }

    /**
     * @param jogo
     */
    public static void rolaDado(Tabuleiro jogo){
        if((jogo.pegaTabuleiro())[6] && (jogo.pegaTabuleiro())[7] && (jogo.pegaTabuleiro())[8] ){
            System.out.println("\n  Rolando o dado \n");
            try { Thread.sleep (1000); } catch (InterruptedException ex) {}

            int dado = (int)(Math.random() * 6) + 1;
            System.out.print("       ["+ dado + "]  ");
            System.out.println("\n");
            jogo.mudaDados(dado);
            return;
        }
        System.out.println("\n Rolando os dados \n");
        try { Thread.sleep (1000); } catch (InterruptedException ex) {}
        

        int dados = 0;
        for (int index = 0; index < 2; index++) {
            int dado = (int)(Math.random() * 6) + 1;
            dados += dado;
            System.out.print("   ["+ dado + "]  ");
        }
        System.out.println("\n");
        jogo.mudaDados(dados);
        return;
    }

    /**
     * @param tabuleiro
     * Imprime o tabuleiro
     */
    public static void mostraTabuleiro(Tabuleiro jogo) {
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < (jogo.pegaTabuleiro()).length; i++) {
            System.out.print("|");
            if((jogo.pegaTabuleiro())[i]){
                System.out.print("X");
            }else{
                System.out.print(i+1);
            }
            System.out.print("|");
        }
        System.out.println();
    }

    /**
     * @param jogo
     */
    public static void mostraTabuleiroDummy(Tabuleiro jogo) {
        System.out.println();
        System.out.print(" ");
        for (int i = 0; i < (jogo.pegaTabuleiro()).length; i++) {
            System.out.print("|");
            if((jogo.pegaTabuleiro())[i]){
                System.out.print("X");
            }else{
                System.out.print(" ");
            }
            System.out.print("|");
        }
        System.out.println();
    }


    /**
     * @param acabou
     * @param tabuleiro
     * @return acabou
     * Verifica o tabuleiro se todas as casas estao fechadas se nao o jogo continua
     */
    public static boolean acabou(boolean acabou, Tabuleiro jogo) {
        acabou = true;
        for (int i = 0; i < (jogo.pegaTabuleiro()).length; i++) {
            if(!((jogo.pegaTabuleiro())[i])){
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
