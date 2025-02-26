package Aula08_ClasseAbstrata;
//Subclasse Circulo que herda de FormaGeometrica
class Circulo extends FormaGeometrica {
 private double raio;

 public Circulo(double raio) {
     this.raio = raio;
 }

 @Override
 double calcularArea() {
     return Math.PI * Math.pow(raio, 2);
 }
}

