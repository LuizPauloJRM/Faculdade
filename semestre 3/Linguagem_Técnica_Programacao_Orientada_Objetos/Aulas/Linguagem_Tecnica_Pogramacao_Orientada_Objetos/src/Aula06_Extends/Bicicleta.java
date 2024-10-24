package Aula06_Extends;
//Bicicleta.java
public class Bicicleta extends Veiculo {
 int marchas;

 // Construtor da classe Bicicleta
 public Bicicleta(String marca, int ano, int marchas) {
     super(marca, ano); // Chama o construtor da superclasse
     this.marchas = marchas;
 }

 // Método específico da classe Bicicleta
 public void mudarMarcha(int novaMarcha) {
     System.out.println("A bicicleta mudou para a marcha " + novaMarcha + ".");
 }
}
