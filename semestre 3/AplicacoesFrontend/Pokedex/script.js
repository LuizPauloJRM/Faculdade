/**
 * Event listener para permitir busca ao pressionar Enter
 * Melhora a usabilidade permitindo que o usuário não precise clicar no botão
 */
document.addEventListener('DOMContentLoaded', function () {
    const input = document.getElementById('pokemonId');

    input.addEventListener('keypress', function (event) {
        if (event.key === 'Enter') {
            getPokemon();
        }
    });

    // Adiciona foco automático no input quando a página carrega
    input.focus();

    // Event listeners para os inputs da arena de batalha
    const pokemon1Input = document.getElementById('pokemon1Id');
    const pokemon2Input = document.getElementById('pokemon2Id');

    // Permite pressionar Enter nos inputs da arena também
    pokemon1Input.addEventListener('keypress', function (event) {
        if (event.key === 'Enter') {
            selectPokemon(1);
        }
    });

    pokemon2Input.addEventListener('keypress', function (event) {
        if (event.key === 'Enter') {
            selectPokemon(2);
        }
    });
});

// ========== SISTEMA DE ARENA DE BATALHA ==========

/**
 * Objeto para armazenar os dados dos Pokémon selecionados para batalha
 * Mantém as informações completas de cada Pokémon para cálculos de batalha
 */
const battlePokemon = {
    pokemon1: null,  // Armazena dados do Pokémon 1
    pokemon2: null   // Armazena dados do Pokémon 2
};

/**
 * Função para selecionar um Pokémon para a arena de batalha
 * @param {number} slot - 1 para Pokémon 1, 2 para Pokémon 2
 * Similar à função getPokemon, mas otimizada para o sistema de batalha
 */
async function selectPokemon(slot) {
    // Determina qual input usar baseado no slot (1 ou 2)
    const inputId = slot === 1 ? 'pokemon1Id' : 'pokemon2Id';
    const id = document.getElementById(inputId).value;

    // Validação: verifica se o usuário digitou algum valor
    if (!id) {
        showBattleError(slot, 'Digite um número de Pokémon.');
        return;
    }

    // Validação: verifica se o número está dentro do range válido
    if (id < 1 || id > 1010) {
        showBattleError(slot, 'Digite um número entre 1 e 1010.');
        return;
    }

    try {
        /**
         * Busca os dados do Pokémon na API
         * Usa await para aguardar a resposta antes de continuar
         */
        const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`);

        if (!response.ok) {
            throw new Error('Pokémon não encontrado');
        }

        // Converte a resposta para JSON
        const data = await response.json();

        /**
         * Armazena os dados do Pokémon no objeto battlePokemon
         * Salva no slot correspondente (pokemon1 ou pokemon2)
         */
        if (slot === 1) {
            battlePokemon.pokemon1 = data;
        } else {
            battlePokemon.pokemon2 = data;
        }

        // Renderiza o card do Pokémon selecionado
        renderBattleCard(data, slot);

        // Verifica se ambos os Pokémon foram selecionados para mostrar botão de batalha
        checkBattleReady();

    } catch (error) {
        showBattleError(slot, 'Erro ao buscar Pokémon. Tente outro número.');
    }
}

/**
 * Função para renderizar o card compacto do Pokémon na arena
 * Mostra apenas informações essenciais para a batalha (imagem, nome, HP, ataque)
 * @param {object} data - Dados do Pokémon retornados pela API
 * @param {number} slot - Slot onde renderizar (1 ou 2)
 */
function renderBattleCard(data, slot) {
    // Determina em qual div renderizar baseado no slot
    const cardId = slot === 1 ? 'pokemon1Card' : 'pokemon2Card';

    // Pega a sprite (imagem) do Pokémon - prioriza arte oficial
    let sprite = data.sprites.front_default;
    if (data.sprites.other && data.sprites.other['official-artwork']) {
        sprite = data.sprites.other['official-artwork'].front_default;
    }

    /**
     * Calcula estatísticas importantes para a batalha
     * HP: pontos de vida
     * Attack: poder de ataque
     * Defense: capacidade de defesa
     */
    const hp = data.stats.find(s => s.stat.name === 'hp').base_stat;
    const attack = data.stats.find(s => s.stat.name === 'attack').base_stat;
    const defense = data.stats.find(s => s.stat.name === 'defense').base_stat;

    // Cria o HTML do card compacto
    const cardHTML = `
    <img src="${sprite}" alt="${data.name}">
    <h4>${data.name.toUpperCase()}</h4>
    <span style="background: linear-gradient(135deg, #667eea, #764ba2); color: white; padding: 3px 10px; border-radius: 10px; font-size: 12px;">
      #${String(data.id).padStart(4, '0')}
    </span>
    
    <!-- Barra de HP -->
    <div class="hp-bar">
      <div class="hp-label">
        <span>❤️ HP</span>
        <span>${hp}</span>
      </div>
      <div style="background: #e0e0e0; border-radius: 10px; overflow: hidden;">
        <div class="hp-fill" style="width: ${(hp / 255) * 100}%"></div>
      </div>
    </div>
    
    <!-- Estatísticas resumidas -->
    <div style="display: flex; justify-content: space-around; margin-top: 10px; font-size: 14px;">
      <div><strong>⚔️</strong> ${attack}</div>
      <div><strong>🛡️</strong> ${defense}</div>
    </div>
    
    <!-- Tipos do Pokémon -->
    <div style="margin-top: 10px;">
      ${data.types.map(t => `<span class="type-badge type-${t.type.name}" style="font-size: 11px; padding: 3px 10px;">${t.type.name}</span>`).join('')}
    </div>
  `;

    // Insere o HTML no card correspondente
    document.getElementById(cardId).innerHTML = cardHTML;
}

/**
 * Função para verificar se ambos os Pokémon foram selecionados
 * Se sim, mostra o botão "INICIAR BATALHA"
 */
function checkBattleReady() {
    const battleButton = document.getElementById('battleButtonContainer');

    // Verifica se ambos os Pokémon foram selecionados
    if (battlePokemon.pokemon1 && battlePokemon.pokemon2) {
        battleButton.style.display = 'block';
        // Adiciona animação de aparecer
        battleButton.style.animation = 'fadeIn 0.5s ease-out';
    } else {
        battleButton.style.display = 'none';
    }
}

/**
 * Função principal que executa a batalha entre os dois Pokémon
 * Sistema simples baseado em comparação de estatísticas
 */
function startBattle() {
    // Limpa resultados anteriores
    document.getElementById('battleResult').innerHTML = '';

    // Pega os dados dos dois Pokémon
    const p1 = battlePokemon.pokemon1;
    const p2 = battlePokemon.pokemon2;

    /**
     * Calcula o "poder total" de cada Pokémon
     * Soma todas as estatísticas base para determinar força geral
     * Stats considerados: HP, Attack, Defense, Special Attack, Special Defense, Speed
     */
    const p1Power = p1.stats.reduce((sum, stat) => sum + stat.base_stat, 0);
    const p2Power = p2.stats.reduce((sum, stat) => sum + stat.base_stat, 0);

    /**
     * Sistema de vantagem de tipos
     * Alguns tipos têm vantagem sobre outros (ex: fogo > grama)
     * Retorna multiplicador de dano
     */
    const typeAdvantage = calculateTypeAdvantage(p1, p2);

    // Aplica o multiplicador de tipo ao poder do Pokémon 1
    const p1FinalPower = p1Power * typeAdvantage;

    /**
     * Adiciona um fator de aleatoriedade (crítico)
     * 10% de chance de crítico que adiciona 30% de poder extra
     */
    const p1Critical = Math.random() < 0.1 ? 1.3 : 1;
    const p2Critical = Math.random() < 0.1 ? 1.3 : 1;

    const p1TotalPower = p1FinalPower * p1Critical;
    const p2TotalPower = p2Power * p2Critical;

    // Determina o vencedor comparando os poderes totais
    let winner, loser, winnerPower, loserPower;

    if (p1TotalPower > p2TotalPower) {
        winner = p1;
        loser = p2;
        winnerPower = p1TotalPower;
        loserPower = p2TotalPower;
    } else {
        winner = p2;
        loser = p1;
        winnerPower = p2TotalPower;
        loserPower = p1TotalPower;
    }

    // Renderiza o resultado da batalha com animação
    displayBattleResult(winner, loser, winnerPower, loserPower, p1Critical > 1, p2Critical > 1, typeAdvantage);
}

/**
 * Função para calcular vantagem de tipos
 * Sistema simplificado de efetividade de tipos
 * @param {object} attacker - Pokémon atacante
 * @param {object} defender - Pokémon defensor
 * @returns {number} - Multiplicador de dano (0.5 = fraco, 1 = normal, 2 = efetivo)
 */
function calculateTypeAdvantage(attacker, defender) {
    /**
     * Tabela simplificada de efetividade de tipos
     * Chave: tipo do atacante
     * Valor: array de tipos que recebem dano super efetivo
     */
    const typeChart = {
        fire: ['grass', 'ice', 'bug', 'steel'],
        water: ['fire', 'ground', 'rock'],
        grass: ['water', 'ground', 'rock'],
        electric: ['water', 'flying'],
        ice: ['grass', 'ground', 'flying', 'dragon'],
        fighting: ['normal', 'ice', 'rock', 'dark', 'steel'],
        poison: ['grass', 'fairy'],
        ground: ['fire', 'electric', 'poison', 'rock', 'steel'],
        flying: ['grass', 'fighting', 'bug'],
        psychic: ['fighting', 'poison'],
        bug: ['grass', 'psychic', 'dark'],
        rock: ['fire', 'ice', 'flying', 'bug'],
        ghost: ['psychic', 'ghost'],
        dragon: ['dragon'],
        dark: ['psychic', 'ghost'],
        steel: ['ice', 'rock', 'fairy'],
        fairy: ['fighting', 'dragon', 'dark']
    };

    // Pega o primeiro tipo do atacante
    const attackerType = attacker.types[0].type.name;
    const defenderTypes = defender.types.map(t => t.type.name);

    // Verifica se há vantagem de tipo
    if (typeChart[attackerType]) {
        for (let defenderType of defenderTypes) {
            if (typeChart[attackerType].includes(defenderType)) {
                return 2; // Super efetivo!
            }
        }
    }

    return 1; // Dano normal
}

/**
 * Função para exibir o resultado da batalha com animações e log detalhado
 * Mostra o vencedor, estatísticas e eventos da batalha
 */
function displayBattleResult(winner, loser, winnerPower, loserPower, p1Crit, p2Crit, typeAdv) {
    const resultDiv = document.getElementById('battleResult');

    // Pega a sprite do vencedor
    let winnerSprite = winner.sprites.front_default;
    if (winner.sprites.other && winner.sprites.other['official-artwork']) {
        winnerSprite = winner.sprites.other['official-artwork'].front_default;
    }

    /**
     * Cria o HTML do resultado com:
     * - Imagem do vencedor
     * - Placar de poder
     * - Log detalhado da batalha
     */
    const resultHTML = `
    <div class="winner">
      <h2>🏆 ${winner.name.toUpperCase()} VENCEU!</h2>
      <img src="${winnerSprite}" alt="${winner.name}" style="width: 200px; height: 200px; object-fit: contain;">
      
      <!-- Placar -->
      <div style="margin: 20px 0; font-size: 1.2em;">
        <strong>${winner.name.toUpperCase()}</strong>: ${Math.round(winnerPower)} pontos<br>
        <strong>${loser.name.toUpperCase()}</strong>: ${Math.round(loserPower)} pontos
      </div>
      
      <!-- Log da batalha -->
      <div class="battle-log">
        <h4>📜 Log da Batalha:</h4>
        <p>⚔️ ${winner.name.toUpperCase()} vs ${loser.name.toUpperCase()}</p>
        ${typeAdv > 1 ? `<p>✨ ${winner.name.toUpperCase()} tem vantagem de tipo! (2x de dano)</p>` : ''}
        ${p1Crit ? `<p>💥 ${battlePokemon.pokemon1.name.toUpperCase()} acertou um GOLPE CRÍTICO!</p>` : ''}
        ${p2Crit ? `<p>💥 ${battlePokemon.pokemon2.name.toUpperCase()} acertou um GOLPE CRÍTICO!</p>` : ''}
        <p>🎯 ${winner.name.toUpperCase()} causou mais dano e venceu a batalha!</p>
        <p>😵 ${loser.name.toUpperCase()} foi derrotado!</p>
      </div>
      
      <!-- Botão para nova batalha -->
      <button onclick="resetBattle()" style="margin-top: 20px; padding: 12px 30px; border: none; border-radius: 10px; background: linear-gradient(135deg, #667eea, #764ba2); color: white; font-weight: bold; cursor: pointer; font-size: 16px;">
        🔄 Nova Batalha
      </button>
    </div>
  `;

    // Insere o resultado na página
    resultDiv.innerHTML = resultHTML;
    resultDiv.classList.add('winner');

    // Rola suavemente até o resultado
    resultDiv.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
}

/**
 * Função para resetar a arena de batalha
 * Limpa todos os dados e permite uma nova batalha
 */
function resetBattle() {
    // Limpa os dados armazenados
    battlePokemon.pokemon1 = null;
    battlePokemon.pokemon2 = null;

    // Limpa os cards visuais
    document.getElementById('pokemon1Card').innerHTML = '';
    document.getElementById('pokemon2Card').innerHTML = '';

    // Limpa os inputs
    document.getElementById('pokemon1Id').value = '';
    document.getElementById('pokemon2Id').value = '';

    // Esconde o botão de batalha
    document.getElementById('battleButtonContainer').style.display = 'none';

    // Limpa o resultado
    document.getElementById('battleResult').innerHTML = '';
    document.getElementById('battleResult').classList.remove('winner');

    // Rola de volta para o topo da arena
    document.getElementById('battle-panel').scrollIntoView({ behavior: 'smooth' });
}

/**
 * Função para exibir mensagens de erro no sistema de batalha
 * @param {number} slot - Slot onde ocorreu o erro (1 ou 2)
 * @param {string} message - Mensagem de erro a ser exibida
 */
function showBattleError(slot, message) {
    const cardId = slot === 1 ? 'pokemon1Card' : 'pokemon2Card';

    document.getElementById(cardId).innerHTML = `
    <div style="padding: 20px; text-align: center;">
      <div style="font-size: 40px; margin-bottom: 10px;">❌</div>
      <p style="color: #ff4757; font-weight: 600; font-size: 14px;">${message}</p>
    </div>
  `;
}/**
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

// Variável global para armazenar o ID do Pokémon atual (útil para navegação anterior/próximo)
let currentPokemonId = null;

async function getPokemon() {
    // Captura o valor digitado pelo usuário no input
    const id = document.getElementById('pokemonId').value;

    // Validação: verifica se o usuário digitou algum valor
    if (!id) {
        showError('Por favor, digite um número.');
        return;
    }

    // Validação: verifica se o número está dentro do range válido
    if (id < 1 || id > 1010) {
        showError('Digite um número entre 1 e 1010.');
        return;
    }

    // Chama a função auxiliar que faz a busca
    await fetchPokemonData(id);
}

/**
 * Função auxiliar que realiza a busca do Pokémon na API
 * Separada para reutilização em outras funcionalidades (aleatório, anterior, próximo)
 */
async function fetchPokemonData(id) {
    // Mostra o loading spinner enquanto busca os dados
    showLoading(true);

    // Limpa a área de informações antes de buscar novos dados
    document.getElementById('pokemonInfo').innerHTML = '';

    try {
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
            throw new Error('Pokémon não encontrado');
        }

        /* Aguardo a conversão da resposta para JSON */
        const data = await response.json();

        // Armazena o ID atual para navegação
        currentPokemonId = data.id;

        // Atualiza o input com o ID correto (útil quando vem de navegação)
        document.getElementById('pokemonId').value = data.id;

        // Renderiza as informações do Pokémon
        renderPokemon(data);

    } catch (error) {
        showError(error.message || 'Erro ao buscar Pokémon. Tente novamente.');
    } finally {
        // Esconde o loading independentemente do resultado
        showLoading(false);
    }
}

/**
 * Função para renderizar as informações do Pokémon na tela
 * Organiza a criação do HTML do carousel e das informações
 */
function renderPokemon(data) {
    const name = data.name;

    /**
     * Coletando todas as sprites (imagens) disponíveis do Pokémon
     * A API fornece diferentes ângulos e versões (normal e shiny)
     * Armazenamos em um array para facilitar a criação do carousel
     */
    const sprites = [];

    // Adiciona sprite frontal padrão se disponível
    if (data.sprites.front_default) {
        sprites.push({ url: data.sprites.front_default, label: '👁️ Frente' });
    }

    // Adiciona sprite de costas padrão se disponível
    if (data.sprites.back_default) {
        sprites.push({ url: data.sprites.back_default, label: '🔄 Costas' });
    }

    // Adiciona sprite frontal shiny (versão rara/brilhante) se disponível
    if (data.sprites.front_shiny) {
        sprites.push({ url: data.sprites.front_shiny, label: '✨ Frente Shiny' });
    }

    // Adiciona sprite de costas shiny se disponível
    if (data.sprites.back_shiny) {
        sprites.push({ url: data.sprites.back_shiny, label: '✨ Costas Shiny' });
    }

    // Adiciona sprites oficiais de alta qualidade se disponíveis
    if (data.sprites.other && data.sprites.other['official-artwork']) {
        const artwork = data.sprites.other['official-artwork'].front_default;
        if (artwork) {
            sprites.unshift({ url: artwork, label: '🎨 Arte Oficial' });
        }
    }

    /**
     * Criando o HTML do carousel dinamicamente
     * O carousel do Bootstrap permite navegar entre múltiplas imagens
     * data-bs-ride="false" desabilita a transição automática
     */
    let carouselHTML = `
    <h2>${name.charAt(0).toUpperCase() + name.slice(1)}</h2>
    
    <!-- Badge com número do Pokémon -->
    <div style="margin-bottom: 15px;">
      <span style="background: linear-gradient(135deg, #667eea, #764ba2); color: white; padding: 5px 15px; border-radius: 20px; font-weight: bold;">
        #${String(data.id).padStart(4, '0')}
      </span>
    </div>
    
    <div id="carouselPokemon" class="carousel slide" data-bs-ride="false">
      <!-- Indicadores do carousel (bolinhas) -->
      <div class="carousel-indicators">
  `;

    // Cria os indicadores (bolinhas) para cada sprite
    sprites.forEach((sprite, index) => {
        carouselHTML += `
      <button type="button" data-bs-target="#carouselPokemon" data-bs-slide-to="${index}" 
        ${index === 0 ? 'class="active" aria-current="true"' : ''} 
        aria-label="Slide ${index + 1}"></button>
    `;
    });

    carouselHTML += `
      </div>
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
        <img src="${sprite.url}" class="d-block w-100" alt="${sprite.label}" loading="lazy">
        <p class="text-center mt-2" style="font-weight: 600; color: #667eea;">
          ${sprite.label}
        </p>
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
    
    <!-- Informações básicas do Pokémon -->
    <div class="info-text">
      <p><strong>📏 Altura:</strong> ${(data.height / 10).toFixed(1)} m</p>
      <p><strong>⚖️ Peso:</strong> ${(data.weight / 10).toFixed(1)} kg</p>
      
      <!-- Tipos do Pokémon com badges coloridos -->
      <p><strong>🏷️ Tipos:</strong><br>
        ${data.types.map(t => `<span class="type-badge type-${t.type.name}">${t.type.name}</span>`).join('')}
      </p>
      
      <!-- Habilidades do Pokémon -->
      <p><strong>💪 Habilidades:</strong><br>
        ${data.abilities.map(a => a.ability.name).join(', ')}
      </p>
      
      <!-- Stats do Pokémon com barras de progresso -->
      <div style="margin-top: 20px;">
        <strong>📊 Estatísticas:</strong>
        ${renderStats(data.stats)}
      </div>
    </div>
  `;

    /* Exibo as informações do Pokémon na página */
    /* Aguardando a reposta da requisição */
    /* Manipulando o DOM para mostrar os dados do Pokémon */
    /* Usando template literals para formatar a saída */
    document.getElementById('pokemonInfo').innerHTML = carouselHTML;
}

/**
 * Função para renderizar as estatísticas do Pokémon com barras de progresso
 * Mostra visualmente os valores de HP, ataque, defesa, etc.
 */
function renderStats(stats) {
    let statsHTML = '';

    // Nomes amigáveis para as estatísticas
    const statNames = {
        'hp': 'HP',
        'attack': 'Ataque',
        'defense': 'Defesa',
        'special-attack': 'Atq. Especial',
        'special-defense': 'Def. Especial',
        'speed': 'Velocidade'
    };

    stats.forEach(stat => {
        const statName = statNames[stat.stat.name] || stat.stat.name;
        const statValue = stat.base_stat;
        // Calcula a porcentagem (considerando 255 como máximo possível)
        const percentage = (statValue / 255) * 100;

        statsHTML += `
      <div class="stat-bar">
        <div class="stat-bar-label">
          <span>${statName}</span>
          <span>${statValue}</span>
        </div>
        <div style="background: #e0e0e0; border-radius: 10px; overflow: hidden;">
          <div class="stat-bar-fill" style="width: ${percentage}%"></div>
        </div>
      </div>
    `;
    });

    return statsHTML;
}

/**
 * Função para buscar um Pokémon aleatório
 * Gera um número aleatório entre 1 e 1010 (total de Pokémon disponíveis na API)
 */
function getRandomPokemon() {
    const randomId = Math.floor(Math.random() * 1010) + 1;
    fetchPokemonData(randomId);
}

/**
 * Função para buscar o Pokémon anterior
 * Decrementa o ID atual em 1 (com validação de limite mínimo)
 */
function getPreviousPokemon() {
    if (!currentPokemonId) {
        showError('Busque um Pokémon primeiro.');
        return;
    }

    if (currentPokemonId > 1) {
        fetchPokemonData(currentPokemonId - 1);
    } else {
        showError('Este é o primeiro Pokémon!');
    }
}

/**
 * Função para buscar o próximo Pokémon
 * Incrementa o ID atual em 1 (com validação de limite máximo)
 */
function getNextPokemon() {
    if (!currentPokemonId) {
        showError('Busque um Pokémon primeiro.');
        return;
    }

    if (currentPokemonId < 1010) {
        fetchPokemonData(currentPokemonId + 1);
    } else {
        showError('Este é o último Pokémon!');
    }
}

/**
 * Função para mostrar/esconder o loading spinner
 * Melhora a experiência do usuário mostrando feedback visual durante a busca
 */
function showLoading(show) {
    const spinner = document.getElementById('loadingSpinner');
    spinner.style.display = show ? 'block' : 'none';
}

/**
 * Função para exibir mensagens de erro
 * Centraliza o tratamento de erros com feedback visual consistente
 */
function showError(message) {
    document.getElementById('pokemonInfo').innerHTML = `
    <div style="padding: 30px; text-align: center;">
      <div style="font-size: 60px; margin-bottom: 15px;">❌</div>
      <p style="color: #ff4757; font-weight: 600; font-size: 18px;">${message}</p>
    </div>
  `;
}

/**
 * Event listener para permitir busca ao pressionar Enter
 * Melhora a usabilidade permitindo que o usuário não precise clicar no botão
 */
document.addEventListener('DOMContentLoaded', function () {
    const input = document.getElementById('pokemonId');

    input.addEventListener('keypress', function (event) {
        if (event.key === 'Enter') {
            getPokemon();
        }
    });

    // Adiciona foco automático no input quando a página carrega
    input.focus();
});