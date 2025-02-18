package banco_digital;
//Classe pública , todas pastas ver esse pacote 
public class Conta {//começo da classe
	//Criando atributos (Variáveis de classe,caracteristicas )
	private String numAgencia;
	private String numConta;
	private String cpf;
	private double saldo;
	//Método construtor : Mesmo nome da classe , para inicializar os atributos
	//Colocando valores cpf,conta,agencia ...
	//This variável da classe 
	public Conta(String numAgencia,String numConta,String cpf) {//Parâmetros do método construtor
		this.numAgencia = numAgencia;
		this.numConta=numConta;
		this.cpf=cpf;
		this.saldo=0.0;//Saldo inicial 
	}
	
	//Métodos para imprimir os dados
	public void imprimirDados() {
		System.out.println("Agencia: "+numAgencia+"\n"+"Conta: "+numConta+"\n"+"CPF: "+cpf+"\n"+"Saldo: "+saldo);
	}
	public void depositar(double valor) {
		saldo = saldo + valor;
		System.out.println("Depósito efetuado no valor R$ "+valor);		
	}
	public void sacar(double valor) {
		saldo = saldo -valor;
		System.out.println("Foi efetuado um saque no valor R$ "+valor);
	}
}//término da classe 
