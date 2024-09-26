/*
1. Exercício 1: Criar uma tabela com restrição CHECK
Crie uma tabela chamada Funcionarios que tenha as colunas ID, Nome, Salario e Idade. O salário deve ser maior que 0 e a idade deve ser entre 18 e 65.
2. Exercício 2: Adicionar restrição UNIQUE
Na tabela Funcionarios, adicione uma restrição UNIQUE na coluna Nome, para garantir que não existam funcionários com o mesmo nome.
3. Exercício 3: Criar uma TRIGGER para logar atualizações
Crie uma TRIGGER que insira um registro em uma tabela chamada LogAlteracoes sempre que o salário de um funcionário for atualizado na tabela Funcionarios. A tabela LogAlteracoes deve armazenar o ID do funcionário, 
o valor anterior do salário, o novo valor do salário e a data da alteração.
4. Exercício 4: Criar uma TRIGGER para evitar exclusão de funcionários com salário alto
Crie uma TRIGGER que impeça a exclusão de funcionários com salário superior a 10000. Exiba uma mensagem de erro personalizada.
5. Exercício 5: Criar uma STORED PROCEDURE para inserir funcionários
Crie uma STORED PROCEDURE chamada InserirFuncionario que insira um novo funcionário na tabela Funcionarios, 
mas faça as seguintes validações antes de inserir:
O nome do funcionário deve ser único.
A idade deve estar entre 18 e 65.
O salário deve ser maior que 0.
*/
create database exerciciosRestricoes01;
use exerciciosRestricoes01;
/*Tabela com restrição CHECK*/
CREATE TABLE Funcionarios (
    ID INT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Salario DECIMAL(10, 2) CHECK (Salario > 0),
    Idade INT CHECK (Idade BETWEEN 18 AND 65)
);
/*Restrição UNIQUE*/
Alter table Funcionarios add constraint unique(Nome);

/*Criar uma trigger e logar atualizações*/
delimiter//



//delimiter





