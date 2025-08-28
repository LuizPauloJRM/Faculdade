
var nome = window.prompt("Qual o seu nome?")
alert("Seja bem-vindo " + nome + "!")
function somar() {
    var num1 = document.getElementById("v1").value;
    var num2 = document.getElementById("result").value;
    //o num1 está sendo convertido com o uso do + na frente
    //o num2 está sendo convertido pelo uso da função parseInt
    var soma = +num1 + +num2;
    document.getElementById("resultado").innerHTML += soma;
    document.getElementById("result").value = soma;

}
function num(valor) {
    document.getElementById("result").value = document.getElementById("v1").value;
    document.getElementById("v1").value = valor;
}
