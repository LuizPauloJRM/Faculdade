package LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ZoneDateTime {

    public static void main(String[] args) {
        LocalDateTime brasilia = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm VV");
        
        ZonedDateTime fusoSaoPaulo = ZonedDateTime.of(brasilia,ZoneId.of("America/Sao_Paulo"));
        System.out.println(fusoSaoPaulo.format(formato));
        
        ZonedDateTime fusoNewYork = fusoSaoPaulo.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(fusoNewYork.format(formato));
    }
}

