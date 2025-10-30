
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
  let itens;

  for(let i=0;i<8;i++){
    let atributo = nomesAtributo[i];
    let imagem = imagens[atributo];

    if(imagem){
      if(primeiro){
        itens = `<div class="carousel-item active">
        <img src="${imagem}" alt="${name}" class="d-block w-100">
      </div>`;
        primeiro = false;
      } else {
        itens += `<div class="carousel-item">
        <img src="${imagem}" alt="${name}" class="d-block w-100">
      </div>`;
      }
    }
  }
  carousel.innerHTML = itens;
  let dados = `
    <h2>${name.toUpperCase()}</h2>
    <p><strong>Altura:</strong> ${data.height / 10} m</p>
    <p><strong>Peso:</strong> ${data.weight / 10} kg</p>
    <p><strong>Ordem:</strong> ${data.order}</p>
    <p><strong>Tipos:</strong> ${data.types.map(t => t.type.name).join(', ')}</p>
    <p><strong>Gênero:</strong> ${genderInfo}</p>
  `;
  document.getElementById('pokemonInfo').innerHTML = dados;
}

async function buscarGenero(name){
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