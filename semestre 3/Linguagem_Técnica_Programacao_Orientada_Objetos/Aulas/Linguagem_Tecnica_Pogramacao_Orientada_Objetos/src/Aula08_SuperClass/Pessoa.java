package Aula08_SuperClass;
//Pessoa.java
public class Pessoa {
 protected String nome;
 protected int idade;

 // Construtor da classe Pessoa
 public Pessoa(String nome, int idade) {
     this.nome = nome;
     this.idade = idade;
 }

 // Método da superclasse Pessoa
 public void apresentar() {
     System.out.println("Olá, meu nome é " + nome + " e eu tenho " + idade + " anos.");
 }
}
