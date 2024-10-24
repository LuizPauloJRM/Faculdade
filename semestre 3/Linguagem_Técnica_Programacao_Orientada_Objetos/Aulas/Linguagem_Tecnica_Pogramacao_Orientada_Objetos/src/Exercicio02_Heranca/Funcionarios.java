package Exercicio02_Heranca;
public class Funcionarios {
    protected String nome;
    protected String endereco;
    protected String telefone;

    public Funcionarios(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
    }
}
