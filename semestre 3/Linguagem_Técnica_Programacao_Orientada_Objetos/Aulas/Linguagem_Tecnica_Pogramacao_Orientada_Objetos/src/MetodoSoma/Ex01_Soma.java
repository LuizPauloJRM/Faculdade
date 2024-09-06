package MetodoSoma;

public class Ex01_Soma {

	public static void main(String[] args) {
		// Criando um objeto da classe Operacoes
        Operacoes operacao = new Operacoes();

        // Chamando o método somaValores da classe Operacoes
        int resultado = operacao.somaValores(2, 3);
        System.out.println("A soma de 2 e 3 é: " + resultado);
	}

}
