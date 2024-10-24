package Aula06_Extends;
//Carro.java
public class Carro extends Veiculo {
 int portas;

 // Construtor da classe Carro
 public Carro(String marca, int ano, int portas) {
     super(marca, ano); // Chama o construtor da superclasse
     this.portas = portas;
 }

 // Método sobrescrito da superclasse Veiculo
 @Override
 public void acelerar() {
     System.out.println("O carro da marca " + marca + " está acelerando.");
 }

 // Método específico da classe Carro
 public void abrirPortas() {
     System.out.println("O carro tem " + portas + " portas abertas.");
 }
}

