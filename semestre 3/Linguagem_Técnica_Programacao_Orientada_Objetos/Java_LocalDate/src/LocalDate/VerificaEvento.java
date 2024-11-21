package LocalDate;
import java.util.Scanner;

public class VerificaEvento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventoEvento evento = new EventoEvento();

        while (true) {
            System.out.println("Digite a data que você acha que o homem pisou na lua (formato: yyyy-MM-dd): ");
            String palpite = scanner.nextLine();

            try {
                if (evento.verificarData(palpite)) {
                    evento.mostrarDetalhesEvento();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro ao processar a data. Tente novamente! Ex: 1969-07-20.");
            }
        }

        scanner.close();
    }
}

