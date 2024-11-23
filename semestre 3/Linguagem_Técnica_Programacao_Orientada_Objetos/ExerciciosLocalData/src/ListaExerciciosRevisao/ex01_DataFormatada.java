package ListaExerciciosRevisao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*- **Exercício 1: Data Atual e Formatação**
    - Objetivo: Criar um programa que exiba a data atual em diferentes formatos.
    - Use LocalDate.now() para obter a data atual.
    - Utilize DateTimeFormatter para formatar a data em dd/MM/yyyy e yyyy-MM-dd.
    - Imprima as datas formatadas.*/
public class ex01_DataFormatada {

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
