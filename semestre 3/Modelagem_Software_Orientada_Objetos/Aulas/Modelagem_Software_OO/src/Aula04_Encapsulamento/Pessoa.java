package Aula04_Encapsulamento;

public class Pessoa {
	private String nome;//Atributo privado 
	private int idade; 
	//Construtor
	public Pessoa(String nome,int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	//Getter para acessar o nome 
	public String getNome() {
		return nome;
	}
	//Setter para modificar o nome 
	public void setNome() {
		this.nome=nome;
	}
	//Getter para acessar idade 
	public int getIdade() {
		return idade;
	}
	//Setter para modificar a idade (com regras de validação)
	public void setIdade(int idade){
		if (idade>0) {
			this.idade=idade;
		}
	}
}
