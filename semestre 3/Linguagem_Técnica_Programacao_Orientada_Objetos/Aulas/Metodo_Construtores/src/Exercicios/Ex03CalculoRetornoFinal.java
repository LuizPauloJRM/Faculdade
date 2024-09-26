package Exercicios;
/* Crie uma classe com um método com duas variáveis de instância: aceleração e distância, depois crie
os métodos gets e sets para cada um desses campos da classe, crie também um método que calcula e
retorna a velocidade final.*/
public class Ex03CalculoRetornoFinal {
		  // Variáveis de instância
	    private double aceleracao;
	    private double distancia;

	    // Construtor
	    public Ex03CalculoRetornoFinal(double aceleracao, double distancia) {
	        this.aceleracao = aceleracao;
	        this.distancia = distancia;
	    }

	    // Método get para aceleração
	    public double getAceleracao() {
	        return aceleracao;
	    }

	    // Método set para aceleração
	    public void setAceleracao(double aceleracao) {
	        this.aceleracao = aceleracao;
	    }

	    // Método get para distância
	    public double getDistancia() {
	        return distancia;
	    }

	    // Método set para distância
	    public void setDistancia(double distancia) {
	        this.distancia = distancia;
	    }

	    // Método para calcular a velocidade final usando a Equação de Torricelli
	    public double calcularVelocidadeFinal() {
	        // Considera-se que a velocidade inicial (V1) é zero.
	        double velocidadeFinal = Math.sqrt(2 * aceleracao * distancia); // Equação de Torricelli: V² = 2 * a * d
	        return velocidadeFinal; // Retorna a velocidade final em m/s
	    

	}

}
