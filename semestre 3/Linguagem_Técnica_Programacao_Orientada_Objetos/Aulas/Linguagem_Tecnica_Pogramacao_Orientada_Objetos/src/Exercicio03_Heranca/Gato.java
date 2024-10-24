package Exercicio03_Heranca;
//Gato.java
public class Gato extends Animal {

 // Construtor da classe Gato
 public Gato(String nome, int idade) {
     super(nome, idade); // Chama o construtor da superclasse Animal
 }

 // Sobrescreve o método fazerSom
 @Override
 public void fazerSom() {
     System.out.println("Miau");
 }
}
