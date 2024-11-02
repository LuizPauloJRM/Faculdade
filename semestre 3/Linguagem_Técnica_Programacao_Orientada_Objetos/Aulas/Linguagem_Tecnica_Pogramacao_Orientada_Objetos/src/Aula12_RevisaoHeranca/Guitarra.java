package Aula12_RevisaoHeranca;
class Guitarra extends Instrumento {
    @Override
    public void emitirSom() {
        System.out.println("A guitarra faz: Strum Strum!");
    }
}