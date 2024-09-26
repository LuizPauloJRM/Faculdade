package Exercicios;
/*Crie uma classe com um método com duas variáveis de instância: velocidade e ângulo, 
depois crie
os métodos gets e sets para cada um desses campos da classe, 
crie também um método que calcula e retorna o alcance.
Crie outra classe com o método main que lê
 os valores da velocidade e ângulo e chama o método da
primeira classe que calcula o alcance. Por fim mostre a informação se atingiu o alvo ou não.
b) Imagine que você está fazendo um jogo sobre Corrida de Dragsters
(um tipo corrida envolvendo
um veículo leve com motores extremamente potentes, especialmente projetados para provas de
arrancadas em retas). O código abaixo visa criar um programa onde você deve entrar com o
valor da aceleração e da distância e o referido programa calcula a velocidade final, usando a
Equação de Torricelli:
V 2 V1 2* a * distância 2  
Observações:
 Considera-se que a velocidade inicial (V1) é zero.
 A velocidade é calculada originalmente em m/s e deve ser convertida para km/h antes de
mostrar o resultado na tela. Para isso o programa deve multiplicar a velocidade calculada
por 3.6.*/
public class ex02Canhao {
	  private double velocidade;
	    private double angulo;
	    private static final double GRAVIDADE = 9.8; // Constante da gravidade

	    // Construtor
	    public ex02Canhao(double velocidade, double angulo) {
	        this.velocidade = velocidade;
	        this.angulo = angulo;
	    }

	    // Método get para velocidade
	    public double getVelocidade() {
	        return velocidade;
	    }

	    // Método set para velocidade
	    public void setVelocidade(double velocidade) {
	        this.velocidade = velocidade;
	    }

	    // Método get para angulo
	    public double getAngulo() {
	        return angulo;
	    }

	    // Método set para angulo
	    public void setAngulo(double angulo) {
	        this.angulo = angulo;
	    }

	    // Método para calcular o alcance
	    public double calcularAlcance() {
	        double anguloRad = Math.toRadians(angulo); // Converte o ângulo para radianos
	        return (Math.pow(velocidade, 2) * Math.sin(2 * anguloRad)) / GRAVIDADE; // Calcula o alcance
	    }
	
		

	}
