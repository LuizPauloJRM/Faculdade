package Aula02_ModelagemSoftware;
import java.util.Random;
import java.util.Scanner;
public class JogoDados {
	    private int faces;

	    public JogoDados(int faces) {
	        this.faces = faces;
	    }

	    public int rolar() {
	        Random random = new Random();
	        return random.nextInt(faces) + 1;
	    }
	
}
