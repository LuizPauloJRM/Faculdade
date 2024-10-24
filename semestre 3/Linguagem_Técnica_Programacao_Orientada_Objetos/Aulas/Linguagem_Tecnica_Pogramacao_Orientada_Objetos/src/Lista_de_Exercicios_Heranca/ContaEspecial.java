package Lista_de_Exercicios_Heranca;
public class ContaEspecial extends ContaBancaria {
    private float limiteCredito;

    public ContaEspecial(String cliente, int numeroConta, float saldoInicial, float limiteCredito) {
        super(cliente, numeroConta, saldoInicial);
        this.limiteCredito = limiteCredito;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void sacarValor(float valor) {
        if (valor > 0) {
            if (getSaldoConta() + limiteCredito >= valor) {
                setSaldoConta(getSaldoConta() - valor);
            } else {
                System.out.println("Limite de crédito excedido!");
            }
        } else {
            System.out.println("Valor do saque não pode ser negativo.");
        }
    }
}
