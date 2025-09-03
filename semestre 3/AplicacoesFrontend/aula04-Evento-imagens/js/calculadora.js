
function somar(){
    var num1 = pegaValor("v1");
    var num2 = pegaValor("result");
    //o num1 está sendo convertido com o uso do + na frente
    //o num2 está sendo convertido pelo uso da função parseInt
    var soma = +num1 + +num2;
    pegaHtml.innerHTML+=soma;
    document.pegaHtml("result").value = soma;
}
function pegaHtml(id){
    return document.getElementById(id);
}
function pegaValor(id){
    return document.getElementById(id).value;
}
function num(valor){
    var resultado =   pegaHtml("result");
    resultado.value = pegaValor("v1");
    pegaHtml("v1").value = valor;
}
