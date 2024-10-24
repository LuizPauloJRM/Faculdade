package Exercicio03_Heranca;

//Cachorro.java
public class Cachorro extends Animal {

 // Construtor da classe Cachorro
 public Cachorro(String nome, int idade) {
     super(nome, idade); // Chama o construtor da superclasse Animal
 }

 // Sobrescreve o método fazerSom
 @Override
 public void fazerSom() {
     System.out.println("Au Au");
 }
}

