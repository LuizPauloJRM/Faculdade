package Aula01_Introducao;

	class Moto extends Veiculo {
	    private int cilindradas;

	    public Moto(String modelo, String marca, int ano, int cilindradas) {
	        super(modelo, marca, ano);
	        this.cilindradas = cilindradas;
	    }
	    @Override
	    public void exibirInfo() {
	        super.exibirInfo();
	        System.out.println("Cilindradas: " + cilindradas);
	    }
	
}
