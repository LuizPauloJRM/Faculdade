package Exercicio04_Encapsulamento_Validacao;

public class Eleitor {
	//Validacao idade do eleitor com nome e status
	private String nomeEleitor;
	private int idade;
//Construtor 
public Eleitor(String nomeEleitor,int idade) {
	  this.nomeEleitor = nomeEleitor;
      this.idade = idade;
}
//Get e Set
public String getNomeEleitor() {
	return nomeEleitor;
}
public void setNomeEleitor() {
	this.nomeEleitor=nomeEleitor;
}
public int getIdade(){
	return idade;
}
public void setIdade(int idade) {
    if (idade >= 0) { // Verificação de idade válida
        this.idade = idade;
    } else {
        System.out.println(" Não é uma idade válida.");
    }
}

//Métodos
public void menorIdade() {
	if(idade <=18) {
		System.out.println(nomeEleitor+" Eleitor é menor de idade, voto não obrigatório");
	}
}
public void maiorIdade() {
	if(idade>=18) {
		System.out.println(nomeEleitor+" Maior de idade , vote!");
	}
}
}
