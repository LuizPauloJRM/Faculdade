package Aula14_TrabalhandoArquivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExercicioB {
    public static void main(String[] args) {
        // Lê a frase do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();
        
        // Filtra as vogais
        StringBuilder vogais = new StringBuilder();
        for (char c : frase.toCharArray()) {
            if (isVowel(c)) {
                vogais.append(c);
            }
        }
        
        // Cria o arquivo e escreve as vogais
        File arquivo = new File("vogais.txt");
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write(vogais.toString());
            System.out.println("Vogais gravadas no arquivo 'vogais.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
        
        scanner.close();
    }
    
    // Método para verificar se o caractere é uma vogal
    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

