alert("Bem vindo!");

function somar(){
    var num1 = document.getElementById("v1").value;
    var num2 = parseInt(document.getElementById("v2").value,10);
    //o num1 está sendo convertido com o uso do + na frente
    //o num2 está sendo convertido pelo uso da função parseInt
    alert(+num1 + num2);
}