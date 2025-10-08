/**
 * ALUNO: Luiz Paulo Medeiros
 * MATRICULA: 202310962
 * fontes de pesquisa: 
 * https://www.geradorcpf.com/algoritmo_do_cpf.htm
 * https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/  
 * 
 * 
 * Cpf tem 11 digitos 
 * preciso calcular o primeiro numero verificador
 * multiplicar cada digito do numero 10 até 2 
 * deixando os dois ultimos de fora 
 * módulo de 11
 * 
 * Agora o segundo numero 
 * agora pego os 9 digitos somo mais o primeiro numero que restou da operação 
 * módulo 11
 * 1×10 = 10
    1×9 = 9
    1×8 = 8
    4×7 = 28
    4×6 = 24
    4×5 = 20
    7×4 = 28
    7×3 = 21
    7×2 = 14
    Somar todos os resultados 162 valor final
    dibidir por 11
    162/11 = 14 resto 8
 */
let cadastros = [];
function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g, '');
    if (cpf.length !== 11 || /^(\d)\1+$/.test(cpf)) return false;

    /*Validação do digito 1*/
    let soma = 0;
    for (let i = 0; i < 9; i++) soma += parseInt(cpf.charAt(i)) * (10 - i);
    let digito1 = (soma % 11 < 2) ? 0 : 11 - (soma % 11);
    if (digito1 !== parseInt(cpf.charAt(9))) return false;
    soma = 0;

    /*validacao do digito 2*/
    for (let i = 0; i < 10; i++) soma += parseInt(cpf.charAt(i)) * (11 - i);
    let digito2 = (soma % 11 < 2) ? 0 : 11 - (soma % 11);
    if (digito2 !== parseInt(cpf.charAt(10))) return false;
    return true;
}
document.getElementById("cadForm").onsubmit = function (e) {
    e.preventDefault();
    const nome = document.getElementById("nome");
    const cpf = document.getElementById("cpf");
    const mensagem = document.getElementById("msg");
    if (nome === "" || !validarCPF(cpf)) {
        mensagem.textContent = " Nome ou CPF inválido!";
        return;
    }

    if (cadastros.some(c => c.cpf === cpf)) {
        mensagem.textContent = "CPF já cadastrado!";
        return;
    }
    cadastros.push({ nome, cpf });
    mensagem.textContent = "Cadastro realizado!";
    document.getElementById("nome");
    document.getElementById("cpf");
}
// Verificação de CPF
document.getElementById("verificarBtn").onclick = function () {
    const cpf = document.getElementById("cpfVerificar").value.trim();
    const mensagem = document.getElementById("msg");
    if (!validarCPF(cpf)) {
        mensagem.textContent = " CPF inválido!";
        return;
    }
    const encontrado = cadastros.find(c => c.cpf === cpf);
    if (encontrado) {
        mensagem.textContent = ` CPF cadastrado: ${encontrado.nome}`;
    } else {
        mensagem.textContent = " CPF não encontrado!";
    }
}
