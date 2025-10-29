/**
 * Função principal responsável por buscar as informações do Pokémon na API.
 * Utiliza o conceito de async/await para lidar com a operação assíncrona (requisição HTTP).
 */
async function getPokemon() {

    //  Captura o número que o usuário digitou
    let id = document.getElementById('pokemonId').value;

    // Verifica se o usuário digitou algo
    if (!id) {
        document.getElementById('pokemonInfo').innerHTML = '<p>Por favor, digite um número.</p>';
        return; // Sai da função caso o campo esteja vazio
    }

    // Monta a URL de busca da API
    // A PokéAPI fornece dados sobre todos os pokémons usando /pokemon/{id}
    const url = `https://pokeapi.co/api/v2/pokemon/${id}`;

    try {
        //  Faz a requisição para a API (aguarda a resposta)
        const response = await fetch(url);

        //  Caso o Pokémon não exista (erro 404)
        if (!response.ok) {
            document.getElementById('pokemonInfo').innerHTML = '<p>Pokémon não encontrado.</p>';
            return;
        }

        // Converte a resposta para JSON (aguarda o processamento)
        let data = await response.json();

        //  Extrai informações principais do Pokémon
        let name = data.name;       // Nome
        let height = data.height;   // Altura (em decímetros)
        let weight = data.weight;   // Peso (em hectogramas)
        let types = data.types.map(t => t.type.name).join(', '); // Tipos (ex: fire, water)

        //  Cria um array com as imagens (sprites) disponíveis
        let sprites = [];

        if (data.sprites.front_default)
            sprites.push({ url: data.sprites.front_default, label: 'Frente' });

        if (data.sprites.back_default)
            sprites.push({ url: data.sprites.back_default, label: 'Costas' });

        if (data.sprites.front_shiny)
            sprites.push({ url: data.sprites.front_shiny, label: 'Frente Shiny' });

        if (data.sprites.back_shiny)
            sprites.push({ url: data.sprites.back_shiny, label: 'Costas Shiny' });

        // Monta o HTML dinamicamente (usando template string)
        let html = `
            <h2>${name.toUpperCase()}</h2>
            <div id="carouselPokemon" class="carousel slide" data-bs-ride="false">
              <div class="carousel-inner">
        `;

        // Cria um item do carousel para cada imagem
        sprites.forEach((sprite, index) => {
            html += `
              <div class="carousel-item ${index === 0 ? 'active' : ''}">
                <img src="${sprite.url}" class="d-block w-100" alt="${sprite.label}">
                <p class="text-center mt-2"><small>${sprite.label}</small></p>
              </div>
            `;
        });

        // Adiciona botões de navegação (voltar e avançar)
        html += `
              </div>
              <button class="carousel-control-prev" type="button" data-bs-target="#carouselPokemon" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Anterior</span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselPokemon" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Próximo</span>
              </button>
            </div>

            <!-- Exibe altura, peso e tipos -->
            <div class="info-text">
                <p><strong>Altura:</strong> ${(height / 10).toFixed(1)} m</p>
                <p><strong>Peso:</strong> ${(weight / 10).toFixed(1)} kg</p>
                <p><strong>Tipos:</strong> ${types}</p>
            </div>
        `;

        //  Exibe tudo dentro da div pokemonInfo
        document.getElementById('pokemonInfo').innerHTML = html;

    } catch (error) {
        //  Caso ocorra erro de rede ou outro problema
        document.getElementById('pokemonInfo').innerHTML = `<p>Erro ao buscar Pokémon: ${error.message}</p>`;
    }
}
