// Define a função principal que será executada ao clicar em "Buscar"
async function getPokemon() {


  // Captura o valor digitado no input (ID do Pokémon)
  const id = document.getElementById('pokemonId').value;

  // Faz a requisição para a API principal da PokéAPI
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);

  // Se o Pokémon não existir (erro 404 ou outro)
  if (!response.ok) {
    document.getElementById('pokemonInfo').innerHTML = '<p>Pokémon não encontrado.</p>';
    return; // Encerra a execução da função
  }

  // Converte a resposta da API (JSON → objeto JavaScript)
  const data = await response.json();

  // Extrai o nome do Pokémon da resposta
  const name = data.name;


  // Captura a div onde as imagens serão inseridas
  let carousel = document.getElementById("carousel");

  // "data.sprites" contém todas as imagens do Pokémon (frente, costas, shiny etc.)
  let imagens = data.sprites;

  // "Object.keys" retorna os nomes das propriedades (nomes dos tipos de imagem)
  let nomesAtributo = Object.keys(imagens);

  // Variável para marcar o primeiro item do carousel como ativo
  let primeiro = true;

  // Variável que armazenará o HTML das imagens
  let itens;

  // Percorre os primeiros 8 atributos (imagens principais)
  for (let i = 0; i < 8; i++) {
    let atributo = nomesAtributo[i];  // nome da chave (ex: front_default)
    let imagem = imagens[atributo];   // URL da imagem

    // Se a imagem existir (nem todos os atributos têm imagem)
    if (imagem) {
      if (primeiro) {
        // O primeiro item precisa ter a classe "active" para aparecer inicialmente
        itens = `
          <div class="carousel-item active">
            <img src="${imagem}" alt="${name}" class="d-block w-100">
          </div>`;
        primeiro = false; // Depois do primeiro, os demais não terão "active"
      } else {
        itens += `
          <div class="carousel-item">
            <img src="${imagem}" alt="${name}" class="d-block w-100">
          </div>`;
      }
    }
  }
  //console.log(imagens);

  // Insere o HTML das imagens dentro do carousel
  carousel.innerHTML = itens;

  // Monta o HTML com as informações do Pokémon (dados gerais)
  let dados = `
    <h2>${name.toUpperCase()}</h2>
    <p><strong>Altura:</strong> ${data.height / 10} m</p>
    <p><strong>Peso:</strong> ${data.weight / 10} kg</p>
    <p><strong>Ordem:</strong> ${data.order}</p>
    <p><strong>Tipos:</strong> ${data.types.map(t => t.type.name).join(', ')}</p>
    <p><strong>Gênero:</strong> ${genderInfo}</p>
  `;

  // Exibe o HTML de informações dentro da div "pokemonInfo"
  document.getElementById('pokemonInfo').innerHTML = dados;
}
