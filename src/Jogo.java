import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Jogada[] jogadas = Jogada.values(); // Irá criar um array [] com os valores do enum -> [{PEDRA, PAPEL, TESOURA}]
        Random rand = new Random();

        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        jogador2.setNome("CPU");

        System.out.println("\n==============================");
        System.out.println("=== PEDRA, PAPEL E TESOURA ===");
        System.out.println("==============================");

        System.out.println("\nDigite o nome do Jogador 1:");
        String nome_jogador1 = sc.nextLine();
        jogador1.setNome(nome_jogador1);

        System.out.println("\n" + jogador1.getNome() + " VS " + jogador2.getNome() + "\n");

        for (int i = 0; i < 11; i++) { // for para o número de rodadas

            System.out.println("============================================");
            System.out.println("             RODADA " + (i + 1));
            System.out.println("============================================");

            int indice_jogada = rand.nextInt(jogadas.length); // Irá randomizar um índice (int) dentro do comprimento do array, no caso iria randomizar esses indices: [0,1,2] -> [PEDRA,PAPEL,TESOURA].
            jogador2.setJogada(jogadas[indice_jogada]); // Irá setar a jogada com o valor de jogadas com base no índice randomizado. Ex: jogadas[0] = jogadas[PEDRA]

            System.out.println("\nQual jogada você deseja fazer " + jogador1.getNome() + "?");
            System.out.println("1 - PEDRA\n2 - PAPEL\n3 - TESOURA");
            System.out.printf("\nSua escolha: ");
            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    jogador1.setJogada(Jogada.PEDRA);
                    break;
                case 2:
                    jogador1.setJogada(Jogada.PAPEL);
                    break;
                case 3:
                    jogador1.setJogada(Jogada.TESOURA);
                    break;
            }

            System.out.println("\n------------------ JOGADAS ------------------");
            System.out.println(jogador1.getNome() + " jogou: " + jogador1.getJogada());
            System.out.println("CPU jogou: " + jogador2.getJogada());
            System.out.println("--------------------------------------------");

            Resultado resultado = jogador1.getJogada().compara(jogador2.getJogada());

            System.out.println("\n************** RESULTADO **************");
            switch (resultado) { //Aqui vamos fazer comparações do ponto de vista do jogador 1, pois foi ele que chamou o metodo compara, logo os resultados serão do ponto de vista do jogador 1.
                case VITORIA:
                    System.out.println("🏆 Vitória de " + jogador1.getNome() + "!");
                    break;
                case DERROTA:
                    System.out.println("💀 Vitória de " + jogador2.getNome() + "!");
                    break;
                case EMPATE:
                    System.out.println("🤝 Empate!");
                    break;
            }
            System.out.println("**************************************\n");
        }

        sc.close();
    }
}
