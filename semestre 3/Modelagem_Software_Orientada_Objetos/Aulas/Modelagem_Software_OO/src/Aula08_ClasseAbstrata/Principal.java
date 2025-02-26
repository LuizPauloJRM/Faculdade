package Aula08_ClasseAbstrata;
//Classe principal
public class Principal{
 public static void main(String[] args) {
     FormaGeometrica circulo = new Circulo(5.0);
     FormaGeometrica retangulo = new Retangulo(4.0, 6.0);

     System.out.println("Área do círculo: " + circulo.calcularArea()); // Saída: 78.53
     System.out.println("Área do retângulo: " + retangulo.calcularArea()); // Saída: 24.0

     circulo.exibirInfo(); // Método concreto da superclasse
 }
}