package Aula01_Introducao;

public class Estacionamento {
    public static void main(String[] args) {
        carro carro1 = new carro("Civic", "Honda", 2022, 4);
        Moto moto1 = new Moto("CBR 600", "Honda", 2021, 600);

        System.out.println("Informações do Carro:");
        carro1.exibirInfo();
        
        System.out.println("\nInformações da Moto:");
        moto1.exibirInfo();
    }
}
