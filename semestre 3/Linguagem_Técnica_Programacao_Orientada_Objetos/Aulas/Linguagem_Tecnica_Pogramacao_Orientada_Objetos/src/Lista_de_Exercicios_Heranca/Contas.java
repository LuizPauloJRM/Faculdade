package Lista_de_Exercicios_Heranca;
import java.util.ArrayList;
import java.util.Scanner;

public class Contas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ContaBancaria> contas = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Incluir dados da conta");
            System.out.println("2. Sacar valor");
            System.out.println("3. Depositar valor");
            System.out.println("4. Mostrar novo saldo (poupança)");
            System.out.println("5. Mostrar dados da conta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    scanner.nextLine(); // Limpar o buffer
                    String cliente = scanner.nextLine();
                    System.out.print("Digite o número da conta: ");
                    int numeroConta = scanner.nextInt();
                    System.out.print("Digite o saldo inicial: ");
                    float saldoInicial = scanner.nextFloat();

                    System.out.println("Tipo de conta: 1 - Poupança, 2 - Especial");
                    int tipoConta = scanner.nextInt();
                    if (tipoConta == 1) {
                        System.out.print("Digite o dia do rendimento: ");
                        int diaRendimento = scanner.nextInt();
                        contas.add(new ContaPoupanca(cliente, numeroConta, saldoInicial, diaRendimento));
                    } else if (tipoConta == 2) {
                        System.out.print("Digite o limite de crédito: ");
                        float limiteCredito = scanner.nextFloat();
                        contas.add(new ContaEspecial(cliente, numeroConta, saldoInicial, limiteCredito));
                    }
                    break;

                case 2:
                    System.out.print("Digite o número da conta para saque: ");
                    numeroConta = scanner.nextInt();
                    System.out.print("Digite o valor a ser sacado: ");
                    float valorSaque = scanner.nextFloat();
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumeroConta() == numeroConta) {
                            conta.sacarValor(valorSaque);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da conta para depósito: ");
                    numeroConta = scanner.nextInt();
                    System.out.print("Digite o valor a ser depositado: ");
                    float valorDeposito = scanner.nextFloat();
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumeroConta() == numeroConta) {
                            conta.depositarValor(valorDeposito);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Digite o número da conta poupança: ");
                    numeroConta = scanner.nextInt();
                    System.out.print("Digite a taxa de rendimento: ");
                    float taxaRendimento = scanner.nextFloat();
                    for (ContaBancaria conta : contas) {
                        if (conta instanceof ContaPoupanca && conta.getNumeroConta() == numeroConta) {
                            ((ContaPoupanca) conta).calcularNovoSaldo(taxaRendimento);
                            System.out.println("Novo saldo da conta poupança: R$ " + conta.getSaldoConta());
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextInt();
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumeroConta() == numeroConta) {
                            System.out.println("Dados da conta:");
                            System.out.println("Cliente: " + conta.getCliente());
                            System.out.println("Número da Conta: " + conta.getNumeroConta());
                            System.out.println("Saldo: R$ " + conta.getSaldoConta());
                            if (conta instanceof ContaPoupanca) {
                                System.out.println("Tipo: Conta Poupança");
                            } else if (conta instanceof ContaEspecial) {
                                System.out.println("Tipo: Conta Especial");
                            }
                            break;
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

