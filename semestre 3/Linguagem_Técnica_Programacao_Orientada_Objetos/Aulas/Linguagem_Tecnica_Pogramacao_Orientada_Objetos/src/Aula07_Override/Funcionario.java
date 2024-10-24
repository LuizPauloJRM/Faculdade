package Aula07_Override;
//Funcionario.java
public class Funcionario {
 String nome;
 double salario;

 // Construtor da classe Funcionario
 public Funcionario(String nome, double salario) {
     this.nome = nome;
     this.salario = salario;
 }

 // Método trabalhar, que será sobrescrito nas subclasses
 public void trabalhar() {
     System.out.println(nome + " está trabalhando de forma genérica.");
 }

 // Método para calcular o salário anual
 public double calcularSalarioAnual() {
     return salario * 12;
 }
}
