package Aulas_Introdutórias;
import java.util.Scanner;
public class Aula04 {

	public static void main(String[] args) {
		// Desenvolva um programa em Java que lê quatro valores (A, B, C e D), calcula e mostra a
		//diferença entre o produto de A e B e do produto de C e D.
		//Resultado = (AB) – (CD)
		Scanner scanner = new Scanner(System.in);
        // Lendo os valores A, B, C e D
        System.out.print("Digite o valor de A: ");
        int A = scanner.nextInt();

        System.out.print("Digite o valor de B: ");
        int B = scanner.nextInt();

        System.out.print("Digite o valor de C: ");
        int C = scanner.nextInt();

        System.out.print("Digite o valor de D: ");
        int D = scanner.nextInt();

        // Calculando a diferença entre o produto de A e B e o produto de C e D
        int diferenca = (A * B) - (C * D);

        // Mostrando o resultado
        System.out.println("A diferença é: " + diferenca);

	}

}
