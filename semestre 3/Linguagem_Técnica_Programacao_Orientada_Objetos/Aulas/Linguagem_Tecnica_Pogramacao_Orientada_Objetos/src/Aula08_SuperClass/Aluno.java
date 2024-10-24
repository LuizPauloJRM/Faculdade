package Aula08_SuperClass;
//Aluno.java
public class Aluno extends Pessoa {
 private String curso;

 // Construtor da classe Aluno
 public Aluno(String nome, int idade, String curso) {
     super(nome, idade); // Chama o construtor da superclasse Pessoa
     this.curso = curso;
 }

 // Sobrescreve o método apresentar da superclasse Pessoa
 @Override
 public void apresentar() {
     super.apresentar(); // Chama o método da superclasse
     System.out.println("Eu sou aluno do curso de " + curso + ".");
 }
}
