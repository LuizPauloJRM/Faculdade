package Aula12_RevisaoHeranca;
public class HerancaInstrumento {
    public static void main(String[] args) {
        // Criando instâncias das classes
        Instrumento meuInstrumento = new Instrumento();
        Instrumento minhaGuitarra = new Guitarra();
        Instrumento meuPiano = new Piano();

        // Chamando o método emitirSom para cada instância
        meuInstrumento.emitirSom();    // Saída: O instrumento emite um som genérico
        minhaGuitarra.emitirSom();     // Saída: A guitarra faz: Strum Strum!
        meuPiano.emitirSom();          // Saída: O piano faz: Plim Plim!
    }
}