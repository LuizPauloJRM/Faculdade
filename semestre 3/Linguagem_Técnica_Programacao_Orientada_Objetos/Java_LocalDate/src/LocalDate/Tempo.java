package LocalDate;
import java.time.Instant;

public class Tempo {

    public static void main(String[] args) {
        Instant agora = Instant.now();
        System.out.println(agora);
        double x;
        for(int i=0;i<99999;i++)
            x = Math.pow(i,i);
        agora = Instant.now();
        System.out.println(agora);
    }
}
