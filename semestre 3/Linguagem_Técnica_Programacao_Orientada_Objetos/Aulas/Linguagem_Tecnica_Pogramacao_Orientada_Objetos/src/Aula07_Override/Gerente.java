package Aula07_Override;

//Gerente.java
public class Gerente extends Funcionario {
 double bonus;

 // Construtor da classe Gerente
 public Gerente(String nome, double salario, double bonus) {
     super(nome, salario); // Chama o construtor da superclasse
     this.bonus = bonus;
 }

 // Sobrescreve o método trabalhar da classe Funcionario
 @Override
 public void trabalhar() {
     System.out.println(nome + " está gerenciando a equipe.");
 }

 // Método para calcular o salário anual com bônus
 @Override
 public double calcularSalarioAnual() {
     return super.calcularSalarioAnual() + bonus;
 }
}
