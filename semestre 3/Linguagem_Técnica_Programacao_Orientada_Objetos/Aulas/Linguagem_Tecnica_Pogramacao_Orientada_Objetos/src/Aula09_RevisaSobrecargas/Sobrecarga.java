package Aula09_RevisaSobrecargas;

public class Sobrecarga {
    public static void main(String[] args) {
    	
        Calculadora calc = new Calculadora();
        int resultado1 = calc.somar(5, 10);
        System.out.println("Soma de dois inteiros: " + resultado1);
        
        int resultado2 = calc.somar(5, 10, 15);
        System.out.println("Soma de três inteiros: " + resultado2);

        double resultado3 = calc.somar(5.5, 10.5);
        System.out.println("Soma de dois doubles: " + resultado3);
    }
}
