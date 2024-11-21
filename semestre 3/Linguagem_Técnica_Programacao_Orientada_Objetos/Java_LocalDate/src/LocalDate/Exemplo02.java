package LocalDate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exemplo02 {
    public static void main(String[] args) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("MMM/yyyy hh:mm");

        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();
        LocalDateTime dataHora = LocalDateTime.now();
        LocalDate dataDefinida = LocalDate.of(2001, 9, 11);
        LocalDate textoConvertido = LocalDate.parse("2020-02-26");
        System.out.println(data.format(formatoData));
        System.out.println(hora.format(formatoHora));
        System.out.println(dataHora.format(formatoDataHora));
        System.out.println(dataDefinida.format(formatoData));
        System.out.println(textoConvertido.format(formatoData));
    }
}
