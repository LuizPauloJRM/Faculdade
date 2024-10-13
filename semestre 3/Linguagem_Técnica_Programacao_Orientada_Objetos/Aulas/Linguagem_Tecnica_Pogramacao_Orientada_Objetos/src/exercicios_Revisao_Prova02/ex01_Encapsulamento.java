package exercicios_Revisao_Prova02;
/*### Exercício 1: Sistema de Gestão de Funcionários (Encapsulamento)
**Objetivo:** Criar uma classe `Funcionario` que encapsula atributos 
*e fornece métodos para manipulação.
**Passos:**
1. Defina a classe `Funcionario` com os atributos 
`private String nome`, `private String cargo`, e `private double salario`.
2. Crie os métodos getters e setters para cada atributo.
3. Adicione um método `public void aumentarSalario(double percentual)` 
que aumenta o salário com base em um percentual fornecido.
4. Teste a classe no método `main` 
para garantir que os atributos estão acessíveis apenas através dos métodos.*/
public class ex01_Encapsulamento {

	public static void main(String[] args) {
		funcionarios funcionarios = new funcionarios();
        funcionarios.setNome("Luiz");
        funcionarios.setCargo("Desenvolvedor");
        funcionarios.setSalario(8710);
        
        System.out.println("Salário antes do aumento: " + funcionarios.getSalario());
        funcionarios.aumentarSalario(10);
        System.out.println("Salário após aumento: " + funcionarios.getSalario());

	}

}
