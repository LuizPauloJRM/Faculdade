package exercicios02_Sobrecarga_Metodo;

public class ContaBancaria {
		private String numeroConta;
		private Double saldoConta;
		public ContaBancaria(String numeroConta) {
	        this.numeroConta = numeroConta;
	        this.saldoConta = (double) 0;
	    }

	    public void depositar(double valor) {
	        this.saldoConta += valor;
	    }

	    public void depositar(double valor, String descricao) {
	        this.saldoConta += valor;
	        System.out.println("Depósito: " + descricao);
	    }

	    public double getSaldo() {
	        return saldoConta;
	    }
	}
	

