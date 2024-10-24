package Aula05_Heranca;

//Classe Pai (ou Superclasse)
public class Animal {
 String nome;

 // Construtor da classe Animal
 public Animal(String nome) {
     this.nome = nome;
 }

 // Método da classe Animal
 public void fazerSom() {
     System.out.println("O animal faz um som.");
 }
}

