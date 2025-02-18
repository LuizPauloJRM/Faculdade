package Aula01_Introducao; 

public class carro extends Veiculo {
    private int portas;

    // Construtor
    public carro(String modelo, String marca, int ano, int portas) {
        super(modelo, marca, ano);
        this.portas = portas;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Número de portas: " + portas);
    }
}
