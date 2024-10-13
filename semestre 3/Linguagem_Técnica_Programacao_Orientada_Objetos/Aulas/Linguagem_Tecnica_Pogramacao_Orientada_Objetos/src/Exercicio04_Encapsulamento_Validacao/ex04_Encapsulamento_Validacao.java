
package Exercicio04_Encapsulamento_Validacao;
import java.util.Scanner;
/*### Exercício 4: Sistema de Votação (Encapsulamento com Validação)
**Objetivo:** Criar uma classe `Eleitor` com validação de idade.
**Passos:**
1. Defina a classe `Eleitor` com os atributos `private String nome` e `private int idade`.
2. Crie métodos getters e setters, validando no setter da
 idade que só são aceitas idades maiores ou iguais a 16.
3. Adicione um método `public boolean podeVotar()` que retorna
 true se a idade for maior ou igual a 18.
4. Teste a classe no método `main` com diferentes idades.*/
public class ex04_Encapsulamento_Validacao {
	public static void main(String[]args) {
	     // Entrada de dados
        Scanner teclado = new Scanner(System.in);

        // Digitar o nome
        System.out.println("Digite seu nome: ");
        String nome = teclado.nextLine();

        // Idade
        System.out.println("Digite sua idade: ");
        int idade = teclado.nextInt();

        // Objeto eleitor com o nome e idade
        Eleitor eleitor = new Eleitor(nome, idade);

        // Exibindo o status do eleitor
        System.out.println("\nStatus do Eleitor:");
        eleitor.menorIdade();
        eleitor.maiorIdade();
	}
}
