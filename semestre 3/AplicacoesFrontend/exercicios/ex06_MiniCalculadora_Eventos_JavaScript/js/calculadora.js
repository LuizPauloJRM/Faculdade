// Função que soma os valores digitados
function somar() {
    // Pega o valor do input com id="v1"
    var num1 = pegaValor("v1");

    // Pega o valor do input com id="result"
    var num2 = pegaValor("result");

    // Converte os valores para número usando o operador +
    // Se a string estiver vazia, vira 0
    var soma = +num1 + +num2;

    // Aqui estava o erro:
    // você escreveu pegaHtml.innerHTML (mas pegaHtml é uma função, não elemento)
    // O correto seria atualizar o <p id="resultado">
    pegaHtml("resultado").innerHTML = "Resultado: " + soma;

    // Outro erro: você escreveu document.pegaHtml(...)
    // Isso não existe. O correto é:
    pegaHtml("result").value = soma;
}

// Função auxiliar: retorna o elemento pelo ID
function pegaHtml(id) {
    return document.getElementById(id);
}

// Função auxiliar: retorna o valor do elemento pelo ID
function pegaValor(id) {
    return document.getElementById(id).value;
}

// Função chamada ao clicar em um número
function num(valor) {
    // Pega o input do resultado
    var resultado = pegaHtml("result");

    // Aqui no seu código original você sobrescrevia o resultado com valor de v1.
    // Isso fazia o resultado não funcionar direito.
    // O correto é ir adicionando os números clicados no campo result.
    resultado.value = resultado.value + valor;

    // Se você quiser, pode também salvar o valor clicado em v1
    pegaHtml("v1").value = valor;
}
