package Aula05_Heranca;
//Classe Filha (ou Subclasse) que herda de Animal
public class Cachorro extends Animal {

 // Construtor da classe Cachorro
 public Cachorro(String nome) {
     super(nome);  // Chama o construtor da superclasse (Animal)
 }

 // Método sobrescrito da classe Animal
 @Override
 public void fazerSom() {
     System.out.println("O cachorro " + nome + " late: Au Au!");
 }

 // Método específico da classe Cachorro
 public void abanarRabo() {
     System.out.println(nome + " está abanando o rabo.");
 }
}
