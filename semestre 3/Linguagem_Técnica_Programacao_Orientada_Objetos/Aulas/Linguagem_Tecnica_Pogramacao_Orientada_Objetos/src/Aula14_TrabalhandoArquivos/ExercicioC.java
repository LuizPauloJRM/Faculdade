package Aula14_TrabalhandoArquivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExercicioC {
    public static void main(String[] args) {
        // Lê o arquivo com a frase
        File arquivo = new File("entrada.txt");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Filtra as consoantes
                for (char c : linha.toCharArray()) {
                    if (isConsonant(c)) {
                        System.out.print(c);
                    }
                }
                System.out.println();  // Nova linha após cada linha do arquivo
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
    // Método para verificar se o caractere é uma consoante
    private static boolean isConsonant(char c) {
        return Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1;
    }
}
