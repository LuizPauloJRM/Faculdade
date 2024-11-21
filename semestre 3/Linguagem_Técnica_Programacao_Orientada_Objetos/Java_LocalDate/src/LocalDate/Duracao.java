package LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
/*•	Duration:  usa as unidades dias, horas, milissegundos, minutos, nanossegundos e segundos para representar uma quantidade de tempo. A classe Period não consegue fazer isso. 
Veja mais em: https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html 

Os principais métodos são:
o	between() 
o	toDays()
o	toHours()
o	toMinutes ()
o	toMillis ()      10⁻³ segundos
o	toNanos ()    10⁻⁹ segundos
*/
public class Duracao{

    public static void main(String[] args) {
        LocalDateTime data = LocalDateTime.of(1970, 9, 11, 20, 30, 00);
        LocalDateTime hoje = LocalDateTime.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Duration duracao = Duration.between(data, hoje);
        System.out.println("Data de referência: " + data.format(formatoData));
        System.out.println("Data atual: " + hoje.format(formatoData)+"\n\n");

        System.out.println("Dias que se passaram: "+duracao.toDays());
        System.out.println("Horas que se passaram: "+duracao.toHours());
        System.out.println("Minutos que se passaram: "+duracao.toMinutes());
        System.out.println("Milissegundos que se passaram: "+duracao.toMillis());
        System.out.println("Nanosegundos que se passaram: "+duracao.toNanos());

    }
}
