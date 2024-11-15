package Aula14_TrabalhandoArquivos;

import java.io.*;

public class ExercicioD {
    public static void main(String[] args) {
        // Lê o arquivo de entrada
        File arquivoEntrada = new File("entrada.txt");
        File arquivoSaida = new File("saida.txt");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Texto copiado para 'saida.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever no arquivo: " + e.getMessage());
        }
    }
}

