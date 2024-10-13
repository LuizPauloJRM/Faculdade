package exercicios02_Sobrecarga_Metodo;
/*### Exercício 2: Sistema de Contas Bancárias (Sobrecarga de Método)
**Objetivo:** Criar uma classe `ContaBancaria` que permite diferentes formas de depósito.
**Passos:**
1. Defina a classe `ContaBancaria` com atributos `private String numeroConta` 
e `private double saldo`.
2. Crie o método `public void depositar(double valor)` para depósitos simples.
3. Sobrecarga o método `depositar` para permitir um depósito com descrição: 
`public void depositar(double valor, String descricao)`.
4. Crie um método `public double getSaldo()` para retornar o saldo.
5. Teste a classe no método `main`, realizando depósitos e exibindo o saldo.*/
public class ex02_Sobrecarga_Metodo {
	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria("123456");
        conta.depositar(355);
        System.out.println("Saldo: " + conta.getSaldo());
        conta.depositar(80, "Depósito inicial");
        System.out.println("Saldo: " + conta.getSaldo());

	}

}
