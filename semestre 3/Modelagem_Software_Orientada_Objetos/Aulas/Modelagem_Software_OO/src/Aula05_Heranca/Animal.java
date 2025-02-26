package Aula05_Heranca;

class Animal {
    String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void emitirSom() {
        System.out.println("O animal faz um som.");
    }
}
