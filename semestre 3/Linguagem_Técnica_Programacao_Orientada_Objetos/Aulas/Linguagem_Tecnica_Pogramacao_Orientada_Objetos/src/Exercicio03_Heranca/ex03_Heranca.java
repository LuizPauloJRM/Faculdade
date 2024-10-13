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
public class ex03_Heranca {
	  Animal cachorro = new Cachorro("Marley", 5);
      cachorro.status();
      cachorro.somAnimal();

      Animal gato = new Gato("Pequeno", 3);
      gato.status();
      gato.somAnimal();
}
