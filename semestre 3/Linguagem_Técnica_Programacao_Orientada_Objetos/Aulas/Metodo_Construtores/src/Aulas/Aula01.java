package Aulas;

public class Aula01 {
	private int valor;
    private String nome;

    // Construtor para inicializar valor e nome
    public Aula01(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    // Métodos de encapsulamento para valor
    public void setValor(int numero) {
        valor = numero;
    }

    public int getValor() {
        return valor;
    }

    // Método de encapsulamento para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
	}

