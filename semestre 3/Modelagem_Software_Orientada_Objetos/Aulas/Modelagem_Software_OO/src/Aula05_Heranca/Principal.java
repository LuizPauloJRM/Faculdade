package Aula05_Heranca;


//Classe principal para testar a herança
public class Principal {
 public static void main(String[] args) {
     Cachorro cachorro = new Cachorro("Rex");
     Gato gato = new Gato("Mimi");

     cachorro.emitirSom(); // Saída: Rex late: Au au!
     gato.emitirSom(); // Saída: Mimi mia: Miau!
 }
}