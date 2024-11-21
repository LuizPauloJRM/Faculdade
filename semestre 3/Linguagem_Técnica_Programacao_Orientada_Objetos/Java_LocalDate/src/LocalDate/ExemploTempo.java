import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ExemploTempo {

    public static void main(String[] args) {
        LocalDate data = LocalDate.now(); // retorna a data neste instante
        LocalTime hora = LocalTime.now(); // retorna a hora neste instante
        LocalDateTime dataHora = LocalDateTime.now(); // retorna a data e hora neste instante
        LocalDate dataDefinida = LocalDate.of(2001, 9, 11); // data de ataque às torres gêmeas
        LocalDate textoConvertido = LocalDate.parse("2020-02-26"); // data de início da pandemia no Brasil
        
        System.out.println(data);
        System.out.println(hora);
        System.out.println(dataHora);
        System.out.println(dataDefinida);
        System.out.println(textoConvertido);
    }
}


