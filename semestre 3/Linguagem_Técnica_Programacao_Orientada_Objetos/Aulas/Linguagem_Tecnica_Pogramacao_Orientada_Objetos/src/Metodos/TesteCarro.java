package Metodos;

public class TesteCarro {

	public static void main(String[] args) {
		// Criando uma instância da classe Carro
        Carro meuCarro = new Carro();

        // Chamando o método acelerar com diferentes valores de velocidade
        meuCarro.acelerar(60);  // Acelerando a 60 km/h
        meuCarro.acelerar(100); // Acelerando a 100 km/h
        meuCarro.acelerar(120); // Acelerando a 120 km/h
    }
}
