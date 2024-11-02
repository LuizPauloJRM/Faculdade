package Nova_ListadeExerciciosPolimorfismo;

import java.util.Random;

public class GeradorCPF {

    // Método para verificar se o CPF é válido
    public static boolean isCpfValido(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false; // Verifica se o CPF não é nulo, se tem 11 dígitos e se contém apenas números
        }

        int[] cpfArray = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfArray[i] = Character.getNumericValue(cpf.charAt(i)); // Converte cada caractere em um inteiro
        }

        return validarDigitos(cpfArray);
    }

    // Método auxiliar para validar os dígitos verificadores
    private static boolean validarDigitos(int[] cpf) {
        int primeiroDigito = calcularDigito(cpf, 9);
        int segundoDigito = calcularDigito(cpf, 10);
        return (primeiroDigito == cpf[9] && segundoDigito == cpf[10]);
    }

    // Método para calcular os dígitos verificadores
    private static int calcularDigito(int[] cpf, int posicao) {
        int soma = 0;
        int peso = posicao + 1;

        for (int i = 0; i < posicao; i++) {
            soma += cpf[i] * (peso--);
        }

        int resto = (soma * 10) % 11;
        return (resto == 10) ? 0 : resto;
    }

    // Método que gera um CPF válido como array de int
    public static int[] gerarCpfValido() {
        Random rand = new Random();
        int[] cpf = new int[11];

        // Gera os primeiros 9 dígitos aleatoriamente
        for (int i = 0; i < 9; i++) {
            cpf[i] = rand.nextInt(10);
        }

        // Calcula os dígitos verificadores
        cpf[9] = calcularDigito(cpf, 9);
        cpf[10] = calcularDigito(cpf, 10);

        return cpf;
    }

    // Método auxiliar para exibir o array de CPF como string
    public static String cpfParaString(int[] cpf) {
        StringBuilder sb = new StringBuilder();
        for (int num : cpf) {
            sb.append(num);
        }
        return sb.toString();
    }
}
