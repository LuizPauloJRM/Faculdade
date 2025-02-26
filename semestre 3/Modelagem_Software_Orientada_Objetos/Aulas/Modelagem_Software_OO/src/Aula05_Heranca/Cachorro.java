package Aula05_Heranca;

class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome); // Chama o construtor da superclasse
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " late: Au au!");
    }
}