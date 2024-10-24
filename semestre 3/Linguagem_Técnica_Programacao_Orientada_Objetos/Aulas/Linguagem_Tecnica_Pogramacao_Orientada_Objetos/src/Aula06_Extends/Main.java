package Aula06_Extends;
//Main.java
public class Main {
 public static void main(String[] args) {
     Carro carro = new Carro("Toyota", 2020, 4);
     carro.acelerar();         // Saída: O carro da marca Toyota está acelerando.
     carro.abrirPortas();      // Saída: O carro tem 4 portas abertas.

     Bicicleta bicicleta = new Bicicleta("Caloi", 2018, 18);
     bicicleta.acelerar();     // Saída: O veículo está acelerando.
     bicicleta.mudarMarcha(3); // Saída: A bicicleta mudou para a marcha 3.
 }
}
