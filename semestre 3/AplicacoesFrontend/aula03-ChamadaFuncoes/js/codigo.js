//alert("Bem vindo!");

function somar() {
    var num1 = document.getElementById("v1").value;
    var num2 = parseInt(document.getElementById("v2").value, 10);
    //o num1 está sendo convertido com o uso do + na frente
    //o num2 está sendo convertido pelo uso da função parseInt
    //alert(+num1 + num2);
    var soma = +num1 + num2;
    //document.writeln(soma);//document.write sobrescreve toda página
    //document.getElementById("resultado").innerHTML = soma;
    document.getElementById("resultado").innerHTML = "A soma é: " + soma;//document.getElementById= seleciona o elemento com id resultado e innerHTML insere o valor trocando meu HTML dentro da tag ,colocando a soma dentro do meu HTML 
    document.getElementById("result").value = soma;//inserindo o valor da soma dentro do input com id result , value insere o valor dentro do input
}