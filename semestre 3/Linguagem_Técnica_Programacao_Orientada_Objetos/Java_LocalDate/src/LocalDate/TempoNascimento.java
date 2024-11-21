package LocalDate;
import java.time.LocalDate;
import java.time.Period;
import java.time.Duration;
import java.time.LocalDateTime;

public class TempoNascimento {

    public static void main(String[] args) {
        LocalDate nascimento = LocalDate.of(2000, 1, 1); // Insira sua data de nascimento
        LocalDate hoje = LocalDate.now();
        Period diferenca = Period.between(nascimento, hoje);

        LocalDateTime dataHoraNascimento = LocalDateTime.of(2000, 1, 1, 0, 0);
        LocalDateTime agora = LocalDateTime.now();
        Duration duracao = Duration.between(dataHoraNascimento, agora);

        System.out.println("Anos: " + diferenca.getYears());
        System.out.println("Meses: " + diferenca.getMonths());
        System.out.println("Dias: " + diferenca.getDays());
        System.out.println("Minutos: " + duracao.toMinutes());
        System.out.println("Segundos: " + duracao.toSeconds());
    }
}

