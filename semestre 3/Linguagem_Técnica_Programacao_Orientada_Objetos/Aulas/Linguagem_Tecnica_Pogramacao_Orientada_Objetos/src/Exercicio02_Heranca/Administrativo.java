package Exercicio02_Heranca;

public class Administrativo extends Funcionarios {
    private String cargo;
    private double salario;

    public Administrativo(String nome, String endereco, String telefone, String cargo, double salario) {
        super(nome, endereco, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: R$ " + salario);
    }
}
