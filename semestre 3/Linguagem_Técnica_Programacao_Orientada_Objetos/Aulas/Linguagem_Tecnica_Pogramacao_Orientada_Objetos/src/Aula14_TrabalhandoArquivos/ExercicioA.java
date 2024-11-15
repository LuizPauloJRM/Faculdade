package Aula14_TrabalhandoArquivos;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExercicioA {
    public static void main(String[] args) {
        // Criando um scanner para ler o nome do arquivo
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo (exemplo.txt): ");
        String nomeArquivo = scanner.nextLine();
        
        // Criando o objeto File
        File arquivo = new File(nomeArquivo);
        
        // Verificando se o arquivo existe
        if (arquivo.exists()) {
            // Tamanho do arquivo
            System.out.println("Tamanho do arquivo: " + arquivo.length() + " bytes");
            
            // Caminho completo até o arquivo
            System.out.println("Caminho completo: " + arquivo.getAbsolutePath());
            
            // Data da última modificação
            long lastModified = arquivo.lastModified();
            Date data = new Date(lastModified);
            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            System.out.println("Última modificação: " + dateFormat.format(data));
        } else {
            System.out.println("Arquivo não encontrado.");
        }
        
        scanner.close();
    }
}
