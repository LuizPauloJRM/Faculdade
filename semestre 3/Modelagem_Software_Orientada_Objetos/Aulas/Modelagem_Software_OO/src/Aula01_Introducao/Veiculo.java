package Aula01_Introducao;

public class Veiculo {//Informações
	  	protected String modelo;
	    protected String marca;
	    protected int ano;

	    public Veiculo(String modelo, String marca, int ano) {
	        this.modelo = modelo;
	        this.marca = marca;
	        this.ano = ano;
	    }
	    public void exibirInfo() {//Método para exibir informações
	        System.out.println("Modelo: " + modelo + ", Marca: " + marca + ", Ano: " + ano);
	    }
	    
}
