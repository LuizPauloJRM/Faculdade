package Exercicios;
import java.util.Scanner;
public class Exemplo03 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê os valores de entrada
        System.out.print("Digite a aceleração (m/s²): ");
        double aceleracao = scanner.nextDouble();

        System.out.print("Digite a distância percorrida (metros): ");
        double distancia = scanner.nextDouble();

        // Cria o objeto Ex03CalculoRetornoFinal
        Ex03CalculoRetornoFinal Ex03CalculoRetornoFinal = new Ex03CalculoRetornoFinal(aceleracao, distancia);

        // Calcula a velocidade final
        double velocidadeFinal = Ex03CalculoRetornoFinal.calcularVelocidadeFinal();
        System.out.printf("A velocidade final é de: %.2f m/s\n", velocidadeFinal);
	}
}
