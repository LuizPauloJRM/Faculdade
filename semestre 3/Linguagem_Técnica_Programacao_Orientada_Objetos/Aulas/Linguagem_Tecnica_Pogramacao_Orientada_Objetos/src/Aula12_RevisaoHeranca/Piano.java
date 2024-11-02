package Aula12_RevisaoHeranca;
class Piano extends Instrumento {
    @Override
    public void emitirSom() {
        System.out.println("O piano faz: Plim Plim!");
    }
}
