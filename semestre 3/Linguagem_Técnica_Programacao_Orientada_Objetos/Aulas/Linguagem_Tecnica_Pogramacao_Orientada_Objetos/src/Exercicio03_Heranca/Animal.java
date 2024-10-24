package Exercicio03_Heranca;
//Animal.java
public class Animal {
 private String nome;
 private int idade;

 // Construtor da classe Animal
 public Animal(String nome, int idade) {
     this.nome = nome;
     this.idade = idade;
 }

 // Método fazerSom (a ser sobrescrito nas subclasses)
 public void fazerSom() {
     System.out.println("O animal está fazendo um som.");
 }

 // Método para exibir as informações do animal
 public void info() {
     System.out.println("Nome: " + nome + ", Idade: " + idade + " anos.");
 }
}
