
/*Meu objeto produto*/ 
const produtos = [
    { id: 1, nome: "notebook", ano: 2018 },
    { id: 2, nome: "smartphone", ano: 2022 },
    { id: 3, nome: "tablet", ano: 2023 },
    { id: 4, nome: "monitor", ano: 2024 },
    { id: 5, nome: "teclado", ano: 2025 }
];

const listaProdutos = document.getElementById('listaProdutos');
produtos.forEach(prod => {
    const li = document.createElement('li');
    li.classList.add('list-group-item');
    li.textContent = `${prod.id} - ${prod.nome} (${prod.ano})`;
    listaProdutos.appendChild(li);
});

const buscarBtn = document.getElementById('buscarBtn');
const produtoInput = document.getElementById('produtoInput');
const resultado = document.getElementById('resultado');

buscarBtn.addEventListener('click', () => {
    const nomeBusca = produtoInput.value.trim();
    const produtoEncontrado = produtos.find(prod => prod.nome === nomeBusca);

    if (produtoEncontrado) {
        resultado.textContent = JSON.stringify(produtoEncontrado, null, 2);
    } else {
        resultado.textContent = "Produto não encontrado.";
    }
});
