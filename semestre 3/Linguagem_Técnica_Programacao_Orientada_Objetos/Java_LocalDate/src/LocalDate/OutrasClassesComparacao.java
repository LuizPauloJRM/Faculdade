package LocalDate;
/*
 Podemos utilizar também outras duas classes para fazer comparações entre datas.
•	Period: usa as unidades ano, mês e dia para representar um período de tempo. 
Veja mais em: https://docs.oracle.com/javase/8/docs/api/java/time/Period.html

Os principais métodos são:
o	between() 
o	getYears ()
o	getMonths ()
o	getDays () 
Para utilizar getYears (), getMonths () ou getDays (), antes você precisa inicializar o período com o método between().
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class OutrasClassesComparacao {

    public static void main(String[] args) {
        LocalDate data = LocalDate.of(1970, 9, 11);
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Period periodo = Period.between(data, hoje);
        System.out.println("Data de referência: " + data.format(formatoData));
        System.out.println("Data atual: " + hoje.format(formatoData));

        System.out.println("Já faz " + periodo.getYears() + " anos "
                + periodo.getMonths() + " meses "
                + periodo.getDays() + " dias desde "
                + data.format(formatoData) + "\n\n\n");
    }
}

