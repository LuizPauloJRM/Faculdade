package Aula06_Extends;
//Veiculo.java
public class Veiculo {
 String marca;
 int ano;

 // Construtor da classe Veiculo
 public Veiculo(String marca, int ano) {
     this.marca = marca;
     this.ano = ano;
 }

 // Método da superclasse Veiculo
 public void acelerar() {
     System.out.println("O veículo está acelerando.");
 }
}
