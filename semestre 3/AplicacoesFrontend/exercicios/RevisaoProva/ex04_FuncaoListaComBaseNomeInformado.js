// Função que lista um produto específico com base no nome informado
function listarProduto(produto) {

    // Criação de 3 objetos representando produtos
    var produto1 = { marca: "Logitech", fabricante: "Logitech", nome: "MX MASTER 3S" };
    var produto2 = { marca: "Multilaser", fabricante: "China", nome: "Multi 3AB" };
    var produto3 = { marca: "Razer", fabricante: "Razer EUA", nome: "GamerXR" };

    // Colocamos os produtos dentro de um ARRAY (usando colchetes [])
    var produtos = [produto1, produto2, produto3];

    // Percorre o array de produtos
    for (var i = 0; i < produtos.length; i++) {

        // Verifica se o nome do produto atual é igual ao informado na função
        if (produtos[i].nome === produto) {
            // Se encontrar, retorna o objeto completo do produto correspondente
            return produtos[i];
        }
    }

    // Se nenhum produto for encontrado, retorna uma mensagem de aviso
    return "Produto não encontrado.";
}
// Exemplo de chamada da função:
console.log(listarProduto("MX MASTER 3S")); // Retorna o objeto da Logitech
console.log(listarProduto("GamerXR"));      // Retorna o objeto da Razer
console.log(listarProduto("Outro"));        // Retorna "Produto não encontrado."