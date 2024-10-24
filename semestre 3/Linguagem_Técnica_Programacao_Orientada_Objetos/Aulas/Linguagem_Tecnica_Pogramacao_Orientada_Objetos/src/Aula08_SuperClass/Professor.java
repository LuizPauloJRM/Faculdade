package Aula08_SuperClass;
//Professor.java
public class Professor extends Pessoa {
 private String disciplina;

 // Construtor da classe Professor
 public Professor(String nome, int idade, String disciplina) {
     super(nome, idade); // Chama o construtor da superclasse Pessoa
     this.disciplina = disciplina;
 }

 // Sobrescreve o método apresentar da superclasse Pessoa
 @Override
 public void apresentar() {
     super.apresentar(); // Chama o método da superclasse
     System.out.println("Eu sou professor de " + disciplina + ".");
 }
}
