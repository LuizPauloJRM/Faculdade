
package aulas12.aula12;


public class ExemploPolimorfismo {
    public static void main(String[] args) {
        // Polimorfismo universal: referência de Animal usada para objetos das subclasses
        Animal animal1 = new Cachorro();
        Animal animal2 = new Gato();
        Animal animal3 = new Passaro();

        // Chamada do método sobrescrito
        animal1.emitirSom(); // Saída: Latindo como um cachorro.
        animal2.emitirSom(); // Saída: Miando como um gato.
        animal3.emitirSom(); // Saída: Cantando como um pássaro.

        // Outra abordagem: uso de arrays para demonstrar flexibilidade
        Animal[] animais = {new Cachorro(), new Gato(), new Passaro()};
        for (Animal animal : animais) {
            animal.emitirSom();
        }
    }
}
