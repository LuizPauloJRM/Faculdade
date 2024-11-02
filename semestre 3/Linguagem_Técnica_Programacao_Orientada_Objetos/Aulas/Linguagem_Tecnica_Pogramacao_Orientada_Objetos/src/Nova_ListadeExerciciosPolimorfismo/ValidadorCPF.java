package Nova_ListadeExerciciosPolimorfismo;

import javax.swing.JOptionPane;
import java.util.Random;

public class ValidadorCPF {

    public static void main(String[] args) {
        String opcaoMenu = "Escolha uma opção:\n1 - Validar CPF\n2 - Criar CPF\n3 - Sair";
        int opcao;

        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(opcaoMenu));
                switch (opcao) {
                    case 1:
                        String cpf = JOptionPane.showInputDialog("Digite o CPF para validar:");
                        boolean isValido = isValido(cpf);
                        JOptionPane.showMessageDialog(null, isValido ? "CPF válido" : "CPF inválido");
                        break;
                    case 2:
                        int[] novoCpf = gerarCPF();
                        JOptionPane.showMessageDialog(null, "CPF gerado: " + arrayToString(novoCpf));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Encerrando o programa. Até logo!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            }
        } while (opcao != 3);
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static boolean isValido(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }

        int[] cpfArray = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
        }

        return validarDigitos(cpfArray);
    }

    private static boolean validarDigitos(int[] cpf) {
        int primeiroDigito = calcularDigito(cpf, 9);
        int segundoDigito = calcularDigito(cpf, 10);
        return (primeiroDigito == cpf[9] && segundoDigito == cpf[10]);
    }

    private static int calcularDigito(int[] cpf, int posicao) {
        int soma = 0;
        int peso = posicao + 1;

        for (int i = 0; i < posicao; i++) {
            soma += cpf[i] * (peso--);
        }

        int resto = (soma * 10) % 11;
        return (resto == 10) ? 0 : resto;
    }

    public static int[] gerarCPF() {
        Random random = new Random();
        int[] cpf = new int[11];

        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        cpf[9] = calcularDigito(cpf, 9);
        cpf[10] = calcularDigito(cpf, 10);

        return cpf;
    }
}
