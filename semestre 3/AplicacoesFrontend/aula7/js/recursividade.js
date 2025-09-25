function calcular(num){
    let resultado = fibonacci(+num);
    alert(resultado);
}
function fibonacci(num){
 if(num<=1){
    return num;
 }
 return fibonacci(num-1) + fibonacci(num-2);
}