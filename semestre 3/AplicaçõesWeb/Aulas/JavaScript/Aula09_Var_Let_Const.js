var nome = "Luiz";
console.log(nome); // Exibe "Luiz"

function exemploVar() {
  var idade = 25;
  console.log(idade); // Exibe 25
}

exemploVar();
// console.log(idade); // Gera um erro, pois `idade` está no escopo da função

let cidade = "São Paulo";
console.log(cidade); // Exibe "São Paulo"

if (true) {
  let bairro = "Centro";
  console.log(bairro); // Exibe "Centro"
}

// console.log(bairro); // Gera um erro, pois `bairro` está no escopo do bloco if

const pais = "Brasil";
console.log(pais); // Exibe "Brasil"

// pais = "Argentina"; // Gera um erro, pois `pais` é uma constante
