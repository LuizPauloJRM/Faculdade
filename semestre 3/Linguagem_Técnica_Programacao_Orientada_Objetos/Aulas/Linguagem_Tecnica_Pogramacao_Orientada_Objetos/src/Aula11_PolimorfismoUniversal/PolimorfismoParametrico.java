package Aula11_PolimorfismoUniversal;

public class PolimorfismoParametrico {
    public static void main(String[] args) {
        // Criando uma instância de Caixa para armazenar um Integer
        Caixa<Integer> caixaInteiro = new Caixa<>();
        caixaInteiro.guardar(123);
        System.out.println("Conteúdo da caixa de inteiros: " + caixaInteiro.obter());

        // Criando uma instância de Caixa para armazenar um String
        Caixa<String> caixaString = new Caixa<>();
        caixaString.guardar("Olá, Mundo!");
        System.out.println("Conteúdo da caixa de strings: " + caixaString.obter());
    }
}


