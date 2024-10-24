package Exercicio03_Heranca;
/*### Exercício 3: Sistema de Gerenciamento de Animais (Herança)
**Objetivo:** Criar uma hierarquia de classes para diferentes tipos de animais.
**Passos:**
1. Defina a classe `Animal` com atributos `private String nome` e
 `private int idade`, e um método `public void fazerSom()`.
2. Crie subclasses `Cachorro` e `Gato` que herdam de `Animal`.
3. Sobreponha o método `fazerSom()` em `Cachorro` para retornar "Au Au" 
e em `Gato` para retornar "Miau".
4. Adicione um método `public void info()` em `Animal` para exibir informações.
5. Teste as classes no método `main`, criando instâncias de `Cachorro` e `Gato`.*/
//Main.java
public class ex03_Heranca {
 public static void main(String[] args) {
     // Criando um objeto Cachorro
     Animal cachorro = new Cachorro("Marley", 5);
     cachorro.info();       // Exibe as informações do cachorro
     cachorro.fazerSom();   // Exibe "Au Au"

     // Criando um objeto Gato
     Animal gato = new Gato("Pequeno", 3);
     gato.info();           // Exibe as informações do gato
     gato.fazerSom();       // Exibe "Miau"
 }
}

