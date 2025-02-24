package ex03_PassagemParametro;
import java.util.Scanner;
public class Exemplo
{
public static void main(String[] args)
{
Calculo var = new Calculo();
Scanner x = new Scanner(System.in);
float valor1,valor2,opcao;
System.out.println("Entre com dois valores");
valor1 = x.nextFloat();
valor2 = x.nextFloat();
System.out.println("Obter a divisão normal(1) "
+ "ou o resto da divisão(2)?");
opcao = x.nextFloat();
if(opcao==1)
System.out.println("Resultado = "
+var.divisaoNormal(valor1,valor2));
else
System.out.println("Resultado = "
+var.restoDivisao(valor1,valor2));
}
}
