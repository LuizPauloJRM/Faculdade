package Aula08_ClasseAbstrata;

//Subclasse Retangulo que herda de FormaGeometrica
class Retangulo extends FormaGeometrica {
 private double largura, altura;

 public Retangulo(double largura, double altura) {
     this.largura = largura;
     this.altura = altura;
 }

 @Override
 double calcularArea() {
     return largura * altura;
 }
}
