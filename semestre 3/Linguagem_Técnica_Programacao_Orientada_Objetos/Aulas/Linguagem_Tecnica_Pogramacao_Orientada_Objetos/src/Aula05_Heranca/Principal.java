package Aula05_Heranca;
public class Principal {
    public static void main(String[] args) {
        // Criando uma instância de Cachorro
        Cachorro cachorro = new Cachorro("Rex");

        // Acessando método da superclasse (herdado) e método sobrescrito
        cachorro.fazerSom();      // Saída: O cachorro Rex late: Au Au!
        
        // Acessando método específico da subclasse
        cachorro.abanarRabo();    // Saída: Rex está abanando o rabo.
    }
}
