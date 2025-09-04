// Tipos primitivos em JavaScript
let numero = 10;           // Number
let texto = "Olá mundo";   // String
let booleano = true;       // Boolean
let nulo = null;           // Null
let indefinido;            // Undefined

// Tipos de referência
let array = [1, 2, 3];     // Array (object)
let objeto = { nome: "Ana", idade: 20 }; // Object

// Exemplo de verificação de tipo
console.log(typeof numero);      // "number"
console.log(typeof texto);       // "string"
console.log(typeof booleano);    // "boolean"
console.log(typeof nulo);        // "object" (curiosidade do JS)
console.log(typeof indefinido);  // "undefined"
console.log(typeof array);       // "object"
console.log(typeof objeto);      // "object"