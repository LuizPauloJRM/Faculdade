
package Exercicios;
import java.util.Scanner;
//Imagine que você está tentando fazer um jogo de luta medieval com canhões, e tenta simular a
//realidade. Para isso você precisa utilizar equações da física para determinar o alcance da bala do
//canhão. Imagine também que o alvo está a 300 metros do canhão e tem 50 metros de
//comprimento. Faça um programa que calcula o alcance a partir da velocidade de lançamento e
//do ângulo de tiro, e verifica se o tiro acertará alguma parte do alvo, utilizando as seguintes
//alcance = alcance máximo que o tiro de canhão poderá alcançar
//V0 = velocidade inicial do tiro de canhão
//θ = ângulo de tiro
//g = aceleração da gravidade (considere como sendo 9,8 m/s2)
public class Ex01 {

	public static void main(String[] args) {
		  Scanner scanner = new Scanner(System.in);

	        // Constantes
	        double g = 9.8; // Aceleração da gravidade em m/s²
	        double alvoInicial = 300; // Distância do início do alvo em metros
	        double alvoFim = 350; // Distância do fim do alvo em metros (comprimento do alvo é 50m)

	        // Entrada de dados
	        System.out.print("Digite a velocidade inicial do tiro (m/s): ");
	        double v0 = scanner.nextDouble(); // Velocidade inicial do tiro

	        System.out.print("Digite o ângulo de tiro (graus): ");
	        double angulo = scanner.nextDouble(); // Ângulo de lançamento em graus

	        // Conversão do ângulo para radianos
	        double anguloRad = Math.toRadians(angulo);

	        // Cálculo do alcance
	        double alcance = (Math.pow(v0, 2) * Math.sin(2 * anguloRad)) / g;

	        // Exibição do resultado do alcance
	        System.out.printf("O alcance do tiro foi de: %.2f metros\n", alcance);

	        // Verificação se o tiro acertará o alvo
	        if (alcance >= alvoInicial && alcance <= alvoFim) {
	            System.out.println("O tiro acertou o alvo!");
	        } else {
	            System.out.println("O tiro não acertou o alvo.");
	        }

		
	}

}
