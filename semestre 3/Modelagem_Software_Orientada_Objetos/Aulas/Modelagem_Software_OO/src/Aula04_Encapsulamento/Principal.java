package Aula04_Encapsulamento;

public class Principal {

	public static void main(String[] args) {
		Pessoa pessoa =new Pessoa("Luiz",25);
		//Acessando atributos através dos métodos
		System.out.println("Nome: "+pessoa.getNome());
		System.out.println("Idade: "+pessoa.getIdade());
		//Modificando os valores 
		pessoa.setNome();
		pessoa.setIdade(30);
		System.out.println("Novo nome: "+pessoa.getNome());
		System.out.println("Nova idade: "+pessoa.getIdade());
		
	}

}
