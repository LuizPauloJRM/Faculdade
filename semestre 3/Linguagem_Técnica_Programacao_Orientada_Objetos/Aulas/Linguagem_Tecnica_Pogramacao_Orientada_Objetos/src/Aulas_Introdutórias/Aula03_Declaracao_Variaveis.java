package Aulas_Introdutórias;
import java.util.Scanner;
public class Aula03_Declaracao_Variaveis {

	public static void main(String[] args) {
		//Crie a classe chamada DeclaracaoVariaveis.java e dentro do método main faça o seguinte:
		//Declare uma variável do tipo String para armazenar o nome de um carro;
		//Declare uma variável do tipo int para armazenar a velocidade máxima desse carro;
		//Declare uma variável do tipo float para armazenar o tempo de aceleração de 0 a 100 desse
		//carro;
		//Declare uma variável do tipo double para armazenar o preço desse carro;
		//Leia pelo teclado o nome, a velocidade máxima, o tempo de aceleração de 0 a 100 e preço
		//de um carro, e armazene nas referidas variáveis;
		//Mostre uma frase com todas essas informações.
		Scanner scanner = new Scanner(System.in);
		String carro;
		int velocidadeMaxima;
		float tempoAceleracao;
		double preco;
		System.out.println("Digite o nome do carro: ");
		carro=scanner.nextLine();
		System.out.println("Digite o tempo de aceleracao que o carro atinge: ");
		tempoAceleracao=scanner.nextFloat();
		System.out.println("Digite a velocidade máxima do carro: ");
		velocidadeMaxima=scanner.nextInt();
		System.out.println("Digite o valor do carro R$: ");
		preco=scanner.nextDouble();
		System.out.println("O carro " + carro + " tem uma velocidade máxima de "+ velocidadeMaxima + " km/h, acelera de 0 a 100 km/h em " +tempoAceleracao + " segundos e custa R$ " + preco + "."); 
				
                 
		

	}

}
