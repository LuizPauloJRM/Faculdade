package Aula07_Polimorfismo_Sobrecarga;

public class Principal {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println(calc.soma(2, 3)); // Saída: 5
        System.out.println(calc.soma(2, 3, 4)); // Saída: 9
    }
}
