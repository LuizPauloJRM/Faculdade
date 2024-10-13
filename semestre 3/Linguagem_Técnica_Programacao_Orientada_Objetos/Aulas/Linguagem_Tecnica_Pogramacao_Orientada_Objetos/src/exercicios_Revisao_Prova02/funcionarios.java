package exercicios_Revisao_Prova02;

public class funcionarios {
	private String nome;
	private String cargo;
	private Double salario;
	  public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getCargo() {
	        return cargo;
	    }

	    public void setCargo(String cargo) {
	        this.cargo = cargo;
	    }

	    public double getSalario() {
	        return salario;
	    }

	    public void setSalario(double salario) {
	        this.salario = salario;
	    }

	    public void aumentarSalario(double percentual) {
	        this.salario += this.salario * percentual / 100;
	    }
	}
