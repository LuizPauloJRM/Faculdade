package MetodoSoma;
import java.util.Scanner;
public class DobrarValores {
	public static int dobrar(int valor) {
		return valor * 2;
	}
	public static void main (String [] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.print("Digite um número inteiro : ");
		int valor1 = scanner.nextInt();
		System.out.println("Digite outro valor inteiro: ");
		int valor2 = scanner.nextInt();
		int resultado1=dobrar(valor1);
		int resultado2=dobrar(valor2);
		System.out.println("O dobro de " + valor1 + " é " + resultado1);
        System.out.println("O dobro de " + valor2 + " é " + resultado2);
	}
}
