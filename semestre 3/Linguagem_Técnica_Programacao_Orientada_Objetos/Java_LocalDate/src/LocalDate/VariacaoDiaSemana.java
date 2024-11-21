package LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class VariacaoDiaSemana {
    public static void main(String[] args) {
        DateTimeFormatter semana1 = DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter semana2 = DateTimeFormatter.ofPattern("E");
        DateTimeFormatter mes1 = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter mes2 = DateTimeFormatter.ofPattern("MMM");
        DateTimeFormatter mes3 = DateTimeFormatter.ofPattern("MMMM");
        LocalDate data = LocalDate.now();
        System.out.println(data.format(semana1));
        System.out.println(data.format(semana2));
        System.out.println(data.format(mes1));
        System.out.println(data.format(mes2));
        System.out.println(data.format(mes3));
    }
}

