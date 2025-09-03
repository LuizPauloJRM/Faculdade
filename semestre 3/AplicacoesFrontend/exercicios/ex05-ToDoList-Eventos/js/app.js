// Espera todo o conteúdo HTML ser carregado antes de rodar o JS
document.addEventListener('DOMContentLoaded', () => {
    // Selecionamos os elementos principais do DOM
    const form = document.getElementById('form-task');   // formulário
    const input = document.getElementById('task-input'); // campo de texto
    const list = document.getElementById('task-list');  // lista UL onde ficam as tarefas

    // Definimos uma chave única para salvar no localStorage
    const STORAGE_KEY = 'todo.tasks.v1';

    // ---------------------------
    // EVENTO: envio do formulário
    // ---------------------------
    form.addEventListener('submit', (e) => {
        e.preventDefault(); // Impede que o form recarregue a página
        const text = input.value.trim(); // Remove espaços extras antes/depois
        if (!text) return; // Se for vazio, não faz nada
        addTask(text);     // Chama a função para criar e adicionar uma nova tarefa
        input.value = '';  // Limpa o campo
        input.focus();     // Mantém o cursor no campo
        saveTasks();       // Salva no localStorage
    });

    // ---------------------------
    // FUNÇÃO: cria um <li> e adiciona na lista
    // ---------------------------
    function addTask(text) {
        const li = document.createElement('li'); // Cria um novo elemento <li>
        li.textContent = text;                   // Define o texto
        li.tabIndex = 0;                         // Permite navegar até ele com TAB
        list.appendChild(li);                    // Adiciona dentro da UL
    }

    // ---------------------------
    // EVENTO: clique em tarefa (marca/desmarca como concluída)
    // ---------------------------
    list.addEventListener('click', (e) => {
        const li = e.target.closest('li'); // Pega o <li> clicado
        if (!li || !list.contains(li)) return; // Garante que seja um <li> válido
        li.classList.toggle('done'); // Alterna a classe "done" (adiciona/remove)
        saveTasks();                  // Atualiza localStorage
    });

    // ---------------------------
    // EVENTO: duplo clique em tarefa (remove a tarefa)
    // ---------------------------
    list.addEventListener('dblclick', (e) => {
        const li = e.target.closest('li'); // Pega o <li> clicado
        if (!li || !list.contains(li)) return;
        li.remove(); // Remove o item do DOM
        saveTasks();
    });

    // ---------------------------
    // FUNÇÃO: salvar lista no localStorage
    // ---------------------------
    function saveTasks() {
        // Converte cada <li> em um objeto { text, done }
        const items = Array.from(list.children).map(li => ({
            text: li.textContent,
            done: li.classList.contains('done')
        }));
        // Converte o array em JSON e salva
        localStorage.setItem(STORAGE_KEY, JSON.stringify(items));
    }

    // ---------------------------
    // FUNÇÃO: carregar lista do localStorage
    // ---------------------------
    function loadTasks() {
        const raw = localStorage.getItem(STORAGE_KEY); // Recupera dados
        if (!raw) return; // Se não existir nada, sai da função
        try {
            const items = JSON.parse(raw); // Converte JSON em array de objetos
            // Para cada item salvo, recriamos o <li>
            items.forEach(item => {
                const li = document.createElement('li');
                li.textContent = item.text;
                if (item.done) li.classList.add('done'); // Marca se estava concluída
                li.tabIndex = 0;
                list.appendChild(li);
            });
        } catch (err) {
            console.error('Erro ao ler tarefas do storage', err);
        }
    }

    // ---------------------------
    // Inicialização: carrega as tarefas salvas ao abrir a página
    // ---------------------------
    loadTasks();
});
