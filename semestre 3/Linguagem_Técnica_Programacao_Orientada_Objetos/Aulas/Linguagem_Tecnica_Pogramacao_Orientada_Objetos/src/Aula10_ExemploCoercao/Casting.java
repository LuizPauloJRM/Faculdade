package Aula10_ExemploCoercao;

public class Casting {
    public static void main(String[] args) {
        double numeroDouble = 7.9;
        int numeroInteiro = (int) numeroDouble;  // Casting explícito de double para int

        System.out.println("Número convertido: " + numeroInteiro);  // Saída: Número convertido: 7
    }
}
