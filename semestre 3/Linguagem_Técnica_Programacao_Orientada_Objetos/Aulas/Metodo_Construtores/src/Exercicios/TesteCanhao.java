package Exercicios;
import java.util.Scanner;
public class TesteCanhao {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        // Lê os valores de entrada
	        System.out.print("Digite a velocidade de lançamento (m/s): ");
	        double velocidade = scanner.nextDouble();

	        System.out.print("Digite o ângulo de lançamento (graus): ");
	        double angulo = scanner.nextDouble();

	        // Cria o objeto Canhao
	        ex02Canhao canhao = new ex02Canhao(velocidade, angulo);

	        // Calcula o alcance
	        double alcance = canhao.calcularAlcance();
	        System.out.printf("O alcance do tiro é de: %.2f metros\n", alcance);

	        // Verifica se o tiro atingiu o alvo
	        if (alcance >= 300 && alcance <= 350) {
	            System.out.println("O tiro acertou o alvo!");
	        } else {
	            System.out.println("O tiro não acertou o alvo.");
	        }

	}

}
