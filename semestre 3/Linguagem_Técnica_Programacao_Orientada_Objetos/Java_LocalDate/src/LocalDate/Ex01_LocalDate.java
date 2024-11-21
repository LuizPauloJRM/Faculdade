package LocalDate;
/*8.	Exercícios
8.1.	Mostre quantos anos, dias, meses, minutos e segundo se passaram desde o seu nacismento.
*/
import java.time.LocalDate;
import java.time.Period;
import java.time.Duration;
import java.time.LocalDateTime;

public class Ex01_LocalDate {

    public static void main(String[] args) {
        LocalDate nascimento = LocalDate.of(1999, 1, 1);
        LocalDate hoje = LocalDate.now();
        Period diferenca = Period.between(nascimento, hoje);

        LocalDateTime dataHoraNascimento = LocalDateTime.of(1999, 1, 1, 0, 0);
        LocalDateTime agora = LocalDateTime.now();
        Duration duracao = Duration.between(dataHoraNascimento, agora);

        System.out.println("Anos: " + diferenca.getYears());
        System.out.println("Meses: " + diferenca.getMonths());
        System.out.println("Dias: " + diferenca.getDays());
        System.out.println("Minutos: " + duracao.toMinutes());
        System.out.println("Segundos: " + duracao.toSeconds());
    }
}

