package Aula07_Override;
//Desenvolvedor.java
public class Desenvolvedor extends Funcionario {

 // Construtor da classe Desenvolvedor
 public Desenvolvedor(String nome, double salario) {
     super(nome, salario); // Chama o construtor da superclasse
 }

 // Sobrescreve o método trabalhar da classe Funcionario
 @Override
 public void trabalhar() {
     System.out.println(nome + " está escrevendo código.");
 }
}
