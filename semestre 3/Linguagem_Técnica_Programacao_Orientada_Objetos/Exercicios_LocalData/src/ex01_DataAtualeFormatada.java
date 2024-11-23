package Exercicios_LocalData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ex01_DataAtualeFormatada {

    public static void main(String[] args) {
        // Obter a data atual
        LocalDate dataAtual = LocalDate.now();

        // Criar os formatadores
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Formatar a data
        String dataFormatada1 = dataAtual.format(formato1);
        String dataFormatada2 = dataAtual.format(formato2);

        // Exibir os formatos
        System.out.println("Data no formato dd/MM/yyyy: " + dataFormatada1);
        System.out.println("Data no formato yyyy-MM-dd: " + dataFormatada2);
    }
}

