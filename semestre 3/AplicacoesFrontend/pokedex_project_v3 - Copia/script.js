/**
 * async função para buscar e exibir informações de um Pokémon baseado no ID fornecido pelo usuário. 
 * Faço e espero uma requisição para a API do PokéAPI. Uma resposta é recebida e processada. 
 * Não aguarda a conclusão da requisição antes de continuar a execução do código.
 * async/await é usado para lidar com a operação assíncrona de busca. Não dependo do retorno imediato da API. 
 * A função aguarda a resposta antes de continuar. 
 * 
 * Exemplo sync: Um pagamento online onde o usuário é redirecionado para a página de confirmação imediatamente 
 * após clicar no botão de pagamento, sem esperar a confirmação do banco.
 * 
 * Exemplo async/await: Um aplicativo de mensagens que aguarda a confirmação do servidor antes de mostrar que 
 * a mensagem foi enviada com sucesso. 
 */
async function getPokemon() {
  // Captura o valor digitado pelo usuário no input
  const id = document.getElementById('pokemonId').value;

  // Validação: verifica se o usuário digitou algum valor
  if (!id) {
    document.getElementById('pokemonInfo').innerHTML = '<p>Por favor, digite um número.</p>';
    return;
  }

  /**
   * fetch é usado para fazer uma requisição HTTP para a API do PokéAPI, buscando informações do Pokémon 
   * com o ID fornecido.
   * A resposta da requisição é aguardada usando await, garantindo que o código só continue após a resposta 
   * ser recebida.
   * Se a resposta não for bem-sucedida (status diferente de 200), uma mensagem de erro é exibida.
   * Caso contrário, os dados do Pokémon são extraídos da resposta JSON e exibidos na página.
   */
  const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);

  // Verifica se a requisição foi bem-sucedida
  if (!response.ok) {
    document.getElementById('pokemonInfo').innerHTML = '<p>Pokémon não encontrado.</p>';
    return;
  }

  /* Aguardo a conversão da resposta para JSON */
  const data = await response.json();
  const name = data.name;

  /**
   * Coletando todas as sprites (imagens) disponíveis do Pokémon
   * A API fornece diferentes ângulos e versões (normal e shiny)
   * Armazenamos em um array para facilitar a criação do carousel
   */
  const sprites = [];

  // Adiciona sprite frontal padrão se disponível
  if (data.sprites.front_default) {
    sprites.push({ url: data.sprites.front_default, label: 'Frente' });
  }

  // Adiciona sprite de costas padrão se disponível
  if (data.sprites.back_default) {
    sprites.push({ url: data.sprites.back_default, label: 'Costas' });
  }

  // Adiciona sprite frontal shiny (versão rara/brilhante) se disponível
  if (data.sprites.front_shiny) {
    sprites.push({ url: data.sprites.front_shiny, label: 'Frente Shiny' });
  }

  // Adiciona sprite de costas shiny se disponível
  if (data.sprites.back_shiny) {
    sprites.push({ url: data.sprites.back_shiny, label: 'Costas Shiny' });
  }

  /**
   * Criando o HTML do carousel dinamicamente
   * O carousel do Bootstrap permite navegar entre múltiplas imagens
   * data-bs-ride="false" desabilita a transição automática
   */
  let carouselHTML = `
    <h2>${name.toUpperCase()}</h2>
    <div id="carouselPokemon" class="carousel slide" data-bs-ride="false">
      <div class="carousel-inner">
  `;

  /**
   * Loop para criar cada item do carousel
   * O primeiro item (index === 0) recebe a classe 'active' para ser exibido inicialmente
   * Cada sprite é adicionada como um carousel-item com sua respectiva label
   */
  sprites.forEach((sprite, index) => {
    carouselHTML += `
      <div class="carousel-item ${index === 0 ? 'active' : ''}">
        <img src="${sprite.url}" class="d-block w-100" alt="${sprite.label}">
        <p class="text-center mt-2"><small>${sprite.label}</small></p>
      </div>
    `;
  });

  /**
   * Adicionando os controles de navegação do carousel (setas)
   * data-bs-target="#carouselPokemon" conecta os botões ao carousel específico
   * data-bs-slide="prev" e "next" definem a direção da navegação
   */
  carouselHTML += `
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
    <div class="info-text">
      <p><strong>Altura:</strong> ${data.height / 10} m</p>
      <p><strong>Peso:</strong> ${data.weight / 10} kg</p>
      <p><strong>Tipos:</strong> ${data.types.map(t => t.type.name).join(', ')}</p>
    </div>
  `;

  /* Exibo as informações do Pokémon na página */
  /* Aguardando a reposta da requisição */
  /* Manipulando o DOM para mostrar os dados do Pokémon */
  /* Usando template literals para formatar a saída */
  document.getElementById('pokemonInfo').innerHTML = carouselHTML;
}