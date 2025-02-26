package Aula07_Polimorfismo_Sobrecarga;
class Calculadora {
    // Método soma com dois parâmetros
    public int soma(int a, int b) {
        return a + b;
    }

    // Método soma com três parâmetros (sobrecarga)
    public int soma(int a, int b, int c) {
        return a + b + c;
    }
}
    
