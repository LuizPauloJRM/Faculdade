package Aula14_TrabalhandoArquivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ExercicioE {
    public static void main(String[] args) {
        File arquivo = new File("numeros.txt");
        
        try (FileWriter writer = new FileWriter(arquivo)) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int num = random.nextInt(100) + 1; // Gera números de 1 a 100
                writer.write(num + "\n");
            }
            System.out.println("Números aleatórios gravados em 'numeros.txt'.");
            
            // Lendo os números e verificando os primos
            verificarPrimos(arquivo);
        } catch (IOException e) {
            System.out.println("Erro ao gravar ou ler o arquivo: " + e.getMessage());
        }
    }
    
    // Método para verificar se o número é primo
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método para ler o arquivo e contar os números primos
    private static void verificarPrimos(File arquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            int primosCount = 0;
            while ((linha = reader.readLine()) != null) {
                int num = Integer.parseInt(linha);
                if (isPrime(num)) {
                    primosCount++;
                }
            }
            System.out.println("Quantidade de números primos: " + primosCount);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

