package Aula08_ClasseAbstrata;

//Classe abstrata FormaGeometrica
abstract class FormaGeometrica {
 // Método abstrato (deve ser implementado nas subclasses)
 abstract double calcularArea();

 // Método concreto
 public void exibirInfo() {
     System.out.println("Sou uma forma geométrica.");
 }
}
