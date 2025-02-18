package Aula02_ModelagemSoftware;
import java.util.Scanner;

public class Jogo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDados dado1 = new JogoDados(6);
        JogoDados dado2 = new JogoDados(6);

        // Criando jogadores
        System.out.print("\033[33mDigite o nome do Jogador 1: \033[0m");
        Jogador jogador1 = new Jogador(scanner.nextLine());

        System.out.print("\033[33mDigite o nome do Jogador 2: \033[0m");
        Jogador jogador2 = new Jogador(scanner.nextLine());

        System.out.println("\n\033[35m🔹 Iniciando o jogo! O primeiro a somar 7 vence 🔹\033[0m\n");

        boolean jogoAtivo = true;

        while (jogoAtivo) {
            // Turno do Jogador 1
            int pontuacao1 = jogador1.jogarDados(dado1, dado2);
            if (pontuacao1 == 7) {
                System.out.println("\n\033[32m🎉 " + jogador1.getNome() + " atingiu 7 pontos e venceu o jogo!\033[0m");
                break;
            }

            // Turno do Jogador 2
            int pontuacao2 = jogador2.jogarDados(dado1, dado2);
            if (pontuacao2 == 7) {
                System.out.println("\n\033[32m🎉 " + jogador2.getNome() + " atingiu 7 pontos e venceu o jogo!\033[0m");
                break;
            }
        }

        scanner.close();
    }
}