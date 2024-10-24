package Aula07_Override;
//Main.java
public class Class_Principal {
 public static void main(String[] args) {
     // Criando objeto Gerente
     Gerente gerente = new Gerente("Alice", 10000, 5000);
     gerente.trabalhar(); // Saída: Alice está gerenciando a equipe.
     System.out.println("Salário anual de Alice: " + gerente.calcularSalarioAnual());

     // Criando objeto Desenvolvedor
     Desenvolvedor desenvolvedor = new Desenvolvedor("Luiz", 8000);
     desenvolvedor.trabalhar(); // Saída: Luiz está escrevendo código.
     System.out.println("Salário anual de Luiz: " + desenvolvedor.calcularSalarioAnual());
 }
}
