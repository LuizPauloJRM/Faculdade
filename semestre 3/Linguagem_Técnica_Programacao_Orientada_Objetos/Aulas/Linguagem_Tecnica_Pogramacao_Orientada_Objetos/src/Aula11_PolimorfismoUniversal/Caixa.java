package Aula11_PolimorfismoUniversal;

	class Caixa<T>{
	    private T objeto;

	    // Método para armazenar um objeto do tipo T
	    public void guardar(T objeto) {
	        this.objeto = objeto;
	    }

	    // Método para obter o objeto do tipo T
	    public T obter() {
	        return this.objeto;
	    }
	}
