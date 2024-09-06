package Metodos;

public class BoasVindas {

    public static void main(String[] args) {
        BoasVindas bv = new BoasVindas();
        bv.mensagem1();
        bv.mensagem2("Luiz Paulo");
    }

    // Método que exibe uma mensagem de boas-vindas
    public void mensagem1() {
        System.out.println("Bem-vindo ao programa!");
    }

    // Método que exibe uma mensagem personalizada
    public void mensagem2(String nome) {
        System.out.println("Bem-vindo, " + nome + "!");
    }
}
