package Aula06_Polimorfismo;

//Subclasse Gato
class Gato extends Animal {
 @Override
 public void emitirSom() {
     System.out.println("O gato mia: Miau!");
 }
}