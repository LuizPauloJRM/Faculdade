package Aula06_Polimorfismo;

//Classe principal
public class Principal {
 public static void main(String[] args) {
     Animal meuAnimal1 = new Cachorro(); // Polimorfismo
     Animal meuAnimal2 = new Gato(); // Polimorfismo

     meuAnimal1.emitirSom(); // Saída: O cachorro late: Au au!
     meuAnimal2.emitirSom(); // Saída: O gato mia: Miau!
 }
}

