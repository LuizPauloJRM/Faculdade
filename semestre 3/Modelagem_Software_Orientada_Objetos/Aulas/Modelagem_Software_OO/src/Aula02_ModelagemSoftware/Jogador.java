package Aula02_ModelagemSoftware;

class Jogador {
    private String nome;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }
    public int jogarDados(JogoDados dado1, JogoDados dado2) {
        int resultado1 = dado1.rolar();
        int resultado2 = dado2.rolar();
        int soma = resultado1 + resultado2;
        pontuacao = soma; // A pontuação sempre reflete a soma da rodada

        System.out.println("\033[36m🎲 " + nome + " rolou " + resultado1 + " e " + resultado2 + " (Total: " + soma + ")\033[0m");
        return pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}