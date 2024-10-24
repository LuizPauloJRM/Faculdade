package Lista_de_Exercicios_Heranca;
public class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    public ContaPoupanca(String cliente, int numeroConta, float saldoInicial, int diaRendimento) {
        super(cliente, numeroConta, saldoInicial);
        this.diaRendimento = diaRendimento;
    }

    public int getDiaRendimento() {
        return diaRendimento;
    }

    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }

    public void calcularNovoSaldo(float taxaRendimento) {
        float novoSaldo = getSaldoConta() + (getSaldoConta() * taxaRendimento / 100);
        setSaldoConta(novoSaldo);
    }
}

