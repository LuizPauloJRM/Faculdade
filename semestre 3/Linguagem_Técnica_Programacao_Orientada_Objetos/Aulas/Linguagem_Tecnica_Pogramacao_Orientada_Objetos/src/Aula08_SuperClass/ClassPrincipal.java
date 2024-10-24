package Aula08_SuperClass;
//Main.java
public class ClassPrincipal {
 public static void main(String[] args) {
     // Criando objeto Aluno
     Aluno aluno = new Aluno("Carlos", 20, "Engenharia");
     aluno.apresentar(); // Saída: Olá, meu nome é Carlos e eu tenho 20 anos. Eu sou aluno do curso de Engenharia.

     // Criando objeto Professor
     Professor professor = new Professor("Ana", 45, "Matemática");
     professor.apresentar(); // Saída: Olá, meu nome é Ana e eu tenho 45 anos. Eu sou professor de Matemática.
 }
}
