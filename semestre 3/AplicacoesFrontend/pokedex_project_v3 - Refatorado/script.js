//Async assincrona para buscar dados do Pokémon elava ser chamada no evento onclick do botão 
//Assim que o botão for clicado a função será executada
//e os dados do Pokémon serão buscados na API e exibidos na página
//sync await para esperar a resposta da API antes de continuar a execução do código
//fetch para buscar dados da API do Pokémon await para esperar a resposta da API antes de continuar a execução do código
//para consumir essa api utilizei a documentação oficial https://pokeapi.co/docs/v2
//Exibir os dados do Pokémon na página HTML
//Utilizei o Bootstrap para estilizar a página e criar o carrossel de imagens
//Link do Bootstrap: https://getbootstrap.com/docs/5.3/getting-started/introduction/
//Como fiz para consumir a API e exibir os dados do Pokémon na página HTML
//1. Criei um input para o usuário digitar o ID do Pokémon
//2. Criei um botão que chama a função getPokemon() quando clicado
//3. Na função getPokemon(), busquei os dados do Pokémon na API usando fetch e await
//4. Extraí os dados relevantes do Pokémon (nome, altura, peso, ordem, tipos e gênero)
//5. Criei elementos HTML dinamicamente para exibir os dados do Pokémon na página
//6. Adicionei as imagens do Pokémon ao carrossel do Bootstrap
//7. Exibi os dados do Pokémon na seção designada da página HTML  
//Entendendo a estrutura da API do Pokémon e como extrair os dados necessários
//Utilizando o console do navegador para debugar e verificar os dados retornados pela API
//Testando diferentes IDs de Pokémon para garantir que a funcionalidade esteja correta
//Ajustando o layout e o estilo da página para melhorar a experiência do usuário
//Adicionando tratamento de erros para casos em que o ID do Pokémon não exista na API
async function getPokemon() {
  const id = document.getElementById('pokemonId').value;
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);
  if (!response.ok) {
    document.getElementById('pokemonInfo').innerHTML = '<p>Pokémon não encontrado.</p>';
    return;
  }

  const data = await response.json();
  const name = data.name;

  let genderInfo = buscarGenero(name);

  let carousel = document.getElementById("carousel");
  let imagens = data.sprites;
  let nomesAtributo = Object.keys(imagens);
  let primeiro = true;

  for (let i = 0; i < 8; i++) {
    let atributo = nomesAtributo[i];
    let imagem = imagens[atributo];

    if (imagem) {
      let div = document.createElement("div");
      div.classList.add("carousel-item");
      if (primeiro) {
        div.classList.add("active");
        primeiro = false;
      }
      let img = document.createElement("img");
      img.src = imagem;
      img.classList.add("d-block", "w-100");
      img.alt = "Imagem do pokemon " + name + " tipo: " + atributo;
      img.title = "Imagem do pokemon " + name + " tipo: " + atributo;

      div.appendChild(img);
      carousel.appendChild(div);
    }
  }
  let h2 = document.createElement("h2");
  h2.textContent = name.toUpperCase();
  let pokemonInfo = document.getElementById('pokemonInfo');
  pokemonInfo.appendChild(h2);
  //Criar elementos HTML dinamicamente para exibir os dados do Pokémon
  let p1 = document.createElement("p");
  let strong1 = document.createElement("strong");
  strong1.textContent = "Altura: ";
  p1.appendChild(strong1);
  let span1 = document.createElement("span");
  span1.textContent = data.height / 10 + " m";
  p1.appendChild(span1);
  pokemonInfo.appendChild(p1);
  //Adicionar os dados do Pokémon aos elementos HTML criados
  let p2 = document.createElement("p");
  let strong2 = document.createElement("strong");
  strong2.textContent = "Peso: ";
  p2.appendChild(strong2);
  let span2 = document.createElement("span");
  span2.textContent = data.weight / 10 + " Kg";
  p2.appendChild(span2);
  pokemonInfo.appendChild(p2);
  //Repetir para os outros dados do Pokémon
  let p3 = document.createElement("p");
  let strong3 = document.createElement("strong");
  strong3.textContent = "Ordem: ";
  p3.appendChild(strong3);
  let span3 = document.createElement("span");
  span3.textContent = data.order;
  p3.appendChild(span3);
  pokemonInfo.appendChild(p3);

  let p4 = document.createElement("p");
  let strong4 = document.createElement("strong");
  strong4.textContent = "Tipos: ";
  p4.appendChild(strong4);
  let span4 = document.createElement("span");
  span4.textContent = data.types.map(t => t.type.name).join(', ');
  p4.appendChild(span4);
  pokemonInfo.appendChild(p4);
  //Gênero do Pokémon
  let p5 = document.createElement("p");
  let strong5 = document.createElement("strong");
  strong5.textContent = "Genero: ";
  p5.appendChild(strong5);
  let span5 = document.createElement("span");
  span5.textContent = genderInfo;
  p5.appendChild(span5);
  pokemonInfo.appendChild(p5);

  /*let dados = `
    <h2>${name.toUpperCase()}</h2>
    <p><strong>Altura:</strong> ${data.height / 10} m</p>
    <p><strong>Peso:</strong> ${data.weight / 10} kg</p>
    <p><strong>Ordem:</strong> ${data.order}</p>
    <p><strong>Tipos:</strong> ${data.types.map(t => t.type.name).join(', ')}</p>
    <p><strong>Gênero:</strong> ${genderInfo}</p>
  `;
  document.getElementById('pokemonInfo').innerHTML = dados;*/
}
//Função para buscar o gênero do Pokémon async await para esperar a resposta da API antes de continuar a execução do código
async function buscarGenero(name) {
  let genderInfo = "Gênero não identificado";

  try {
    const genders = ["male", "female", "genderless"];
    let genderLabels = [];
    for (let gender of genders) {
      const genderResponse = await fetch(`https://pokeapi.co/api/v2/gender/${gender}`);
      if (genderResponse.ok) {
        const genderData = await genderResponse.json();
        const pokemonNames = genderData.pokemon_species_details.map(p => p.pokemon_species.name);
        if (pokemonNames.includes(name)) {
          genderLabels.push(gender.charAt(0).toUpperCase() + gender.slice(1));
        }
      }
    }
    genderInfo = genderLabels.length > 0 ? genderLabels.join(' / ') : "Sem gênero definido";
  } catch (e) {
    console.error("Erro ao buscar gênero:", e);
  }
  return genderInfo;
}