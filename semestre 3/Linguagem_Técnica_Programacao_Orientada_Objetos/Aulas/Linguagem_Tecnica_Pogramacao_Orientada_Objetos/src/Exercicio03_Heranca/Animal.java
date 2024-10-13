package Exercicio03_Heranca;
public class Animal {
	private String nome;
	private int idade;
	
public void Animal(String nome , int idade) {
	this.nome=nome;
	this.idade=idade;
}
public void somAnimal(){
	System.out.println("Som de um animal");
}
public void status() {
	System.out.println("Nome: "+nome+"idade: "+idade);
	
}
}
