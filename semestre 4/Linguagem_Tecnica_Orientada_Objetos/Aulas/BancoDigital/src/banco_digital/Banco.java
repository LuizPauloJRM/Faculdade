package banco_digital;

public class Banco {
	public static void main(String[]args) {
		Conta c1 =new Conta("123-1","500.001","046.654.135-64");
		Conta c2 =new Conta("254-1","487.002","665.001.168-98");
		//Chamando o método imprimir dados da classe conta 
		c1.imprimirDados();
		c2.imprimirDados();
		c1.depositar(1000);
		c2.depositar(600);
		c1.imprimirDados();
		c2.imprimirDados();
		c1.sacar(200);
		c1.imprimirDados();
		c2.sacar(50);
		c2.imprimirDados();
	}
}
