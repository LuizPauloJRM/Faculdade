
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

  for(let i=0;i<8;i++){
    let atributo = nomesAtributo[i];
    let imagem = imagens[atributo];

    if(imagem){
      let div = document.createElement("div");
      div.classList.add("carousel-item");
      if(primeiro){
        div.classList.add("active");
        primeiro = false;
      }
      let img = document.createElement("img");
      img.src = imagem;
      img.classList.add("d-block","w-100");
      img.alt = "Imagem do pokemon "+name+" tipo: "+atributo;
      img.title = "Imagem do pokemon "+name+" tipo: "+atributo;

      div.appendChild(img);
      carousel.appendChild(div);
    }
  }
  let h2 = document.createElement("h2");
  h2.textContent = name.toUpperCase();
  let pokemonInfo = document.getElementById('pokemonInfo');
  pokemonInfo.appendChild(h2);

  let p1 = document.createElement("p");
  let strong1 = document.createElement("strong");
  strong1.textContent = "Altura: ";
  p1.appendChild(strong1);
  let span1 = document.createElement("span");
  span1.textContent = data.height / 10+" m";
  p1.appendChild(span1); 
  pokemonInfo.appendChild(p1);

  let p2 = document.createElement("p");
  let strong2 = document.createElement("strong");
  strong2.textContent = "Peso: ";
  p2.appendChild(strong2);
  let span2 = document.createElement("span");
  span2.textContent = data.weight / 10+" Kg";
  p2.appendChild(span2); 
  pokemonInfo.appendChild(p2);

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