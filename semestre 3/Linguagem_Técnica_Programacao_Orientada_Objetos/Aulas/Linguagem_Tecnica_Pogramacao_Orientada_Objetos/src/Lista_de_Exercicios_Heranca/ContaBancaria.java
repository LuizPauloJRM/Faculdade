package Lista_de_Exercicios_Heranca;
public class ContaBancaria {
    private String cliente;
    private int numeroConta;
    private float saldoConta;

    public ContaBancaria(String cliente, int numeroConta, float saldoInicial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldoConta = saldoInicial;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(float saldoConta) {
        this.saldoConta = saldoConta;
    }

    public void sacarValor(float valor) {
        if (valor > 0) {
            if (saldoConta >= valor) {
                saldoConta -= valor;
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Valor do saque não pode ser negativo.");
        }
    }

    public void depositarValor(float valor) {
        if (valor > 0) {
            saldoConta += valor;
        } else {
            System.out.println("Valor do depósito não pode ser negativo.");
        }
    }
}
