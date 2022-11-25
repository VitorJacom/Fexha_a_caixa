import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cria_rank {
    /**
     * @param inputFileName
     * @throws IOException
     * 
     *                     Le o placar, se existir o placar vai mostrar em ordem de
     *                     menos pontos perdidos
     *                     Se nao tiver nenhum jogador ganhado ainda ele vai falar
     *                     que precisa ao menos ter um
     *                     ganhador
     */
    public static void lePlacar(String inputFileName) throws IOException {
        String arquivo;
        int linhas = 0;
        String[][] ordemPlacar;

        int ranking = 1;
        try (Scanner rank = new Scanner(new File(inputFileName))) {
            while ((rank.hasNextLine())) {
                arquivo = rank.nextLine();
                linhas++;

            }

        } catch (FileNotFoundException e) {
            System.out.println("Placar nao foi criado, precisa ao menos ter ganho um jogo");
            return;
        }

        ordemPlacar = new String[linhas][2];

        try (Scanner rank = new Scanner(new File(inputFileName))) {

            for (int i = 0; i < ordemPlacar.length; i++) {
                arquivo = rank.nextLine();
                String[] placar = arquivo.split(";");
                ordemPlacar[i][0] = placar[0];
                ordemPlacar[i][1] = placar[1];
            }
        } catch (FileNotFoundException e) {
        }

        SelectionSort(ordemPlacar);

        for (int i = 0; i < ordemPlacar.length; i++) {
            System.out.println("[" + ranking++ + "--> " + ordemPlacar[i][0] + " ]" + "Pontos perdidos -->" +
                    ordemPlacar[i][1]);
        }

    }

    /**
     * @param jogo
     * @param inputFileName
     * @throws IOException
     * 
     *                     Adiciona o ganhador no arquivo csv dos ranking
     */
    public static void addPlacar(Tabuleiro jogo, String inputFileName) throws IOException {
        try (Scanner rank = new Scanner(new File(inputFileName))) {
            String textToAppend = jogo.pegaNome() + ";" + Integer.toString(jogo.mostraPonto());
            FileWriter adiciona = new FileWriter(inputFileName, true);
            adiciona.write(textToAppend + "\n");
            adiciona.close();

        } catch (FileNotFoundException e) {
            try (FileWriter inputFile = new FileWriter(inputFileName)) {
                for (int i = 0; i < jogo.pegaNome().length(); i++) {
                    inputFile.write((jogo.pegaNome()).charAt(i));
                }
                inputFile.write(";");
                inputFile.write(Integer.toString(jogo.mostraPonto()));
                System.out.println("\n");

            } catch (IOException exception) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * @param ordem
     *              Organiza os vetores do placar
     */
    public static void SelectionSort(String[][] ordem) {
        for (int i = 0; i < ordem.length; i++) {
            int idMenor = i;
            for (int j = i; j < ordem.length; j++) {
                if ((Integer.parseInt(ordem[j][1]) < (Integer.parseInt(ordem[idMenor][1])))) {
                    idMenor = j;
                }
            }
            if (idMenor != i) {
                String auxilioNome = ordem[i][0];
                String auxilioPonto = ordem[i][1];

                ordem[i][0] = ordem[idMenor][0];
                ordem[i][1] = ordem[idMenor][1];

                ordem[idMenor][0] = auxilioNome;
                ordem[idMenor][1] = auxilioPonto;
            }
        }
    }

}
