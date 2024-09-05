/*
Selecione todos os empregados cadastrados na tabela tb_empregado.
SELECT * FROM tb_empregado;
Liste todos os cargos disponíveis na tabela tb_cargo.
SELECT * FROM tb_cargo;
Exiba o nome e a data de nascimento de todos os empregados do sexo feminino.
SELECT nome, dt_nascimento FROM tb_empregado WHERE sexo = 'F';
Calcule a soma total dos salários dos cargos na tabela tb_cargo.
SELECT SUM(salario) AS soma_salarios FROM tb_cargo;
Determine a média salarial dos cargos na tabela tb_cargo.
SELECT AVG(salario) AS media_salarios FROM tb_cargo;
Identifique o maior e o menor salário oferecido entre todos os cargos.
SELECT MAX(salario) AS maior_salario, MIN(salario) AS menor_salario FROM tb_cargo;
Conte quantos departamentos estão cadastrados na tabela tb_departamento.
SELECT COUNT(*) AS quantidade_departamentos FROM tb_departamento;
Liste todos os empregados com seus respectivos cargos (nome do cargo e salário).
SELECT e.nome, c.nm_cargo, c.salario 
FROM tb_empregado e, tb_cargo c 
WHERE e.fk_cargo = c.id_cargo;
Liste todos os empregados junto com o nome de seu departamento.
SELECT e.nome, d.nm_departamento 
FROM tb_empregado e, tb_departamento d 
WHERE e.fk_departamento = d.id_departamento;
Selecione os empregados que foram admitidos depois de 01/01/2015.
SELECT * FROM tb_empregado WHERE dt_admissao > '2015-01-01';
Encontre os empregados cujo salário é superior à média salarial de todos os cargos.
SELECT e.nome 
FROM tb_empregado e, tb_cargo c 
WHERE e.fk_cargo = c.id_cargo AND c.salario > (SELECT AVG(salario) FROM tb_cargo);
Liste o nome, matrícula, nome do cargo, salário e nome do departamento de cada empregado.
SELECT e.nome, e.matricula, c.nm_cargo, c.salario, d.nm_departamento 
FROM tb_empregado e, tb_cargo c, tb_departamento d
WHERE e.fk_cargo = c.id_cargo AND e.fk_departamento = d.id_departamento;
Use uma subquery para determinar o cargo com o maior salário e listar todos os empregados que ocupam esse cargo.
SELECT e.nome, c.nm_cargo 
FROM tb_empregado e, tb_cargo c 
WHERE e.fk_cargo = c.id_cargo AND c.salario = (SELECT MAX(salario) FROM tb_cargo);
Selecione os cargos que têm um salário menor do que o salário médio de todos os cargos.
SELECT nm_cargo 
FROM tb_cargo 
WHERE salario < (SELECT AVG(salario) FROM tb_cargo);
Atualize o salário do cargo 'Estagiário' para R$ 1200,00.
UPDATE tb_cargo 
SET salario = 1200.00 
WHERE nm_cargo = 'Estagiário';
Delete um departamento que não tenha nenhum empregado associado a ele.
DELETE FROM tb_departamento 
WHERE id_departamento NOT IN (SELECT fk_departamento FROM tb_empregado);
Insira um novo empregado na tabela tb_empregado.
INSERT INTO tb_empregado (matricula, nome, dt_nascimento, sexo, dt_admissao, fk_cargo, fk_departamento) 
VALUES (132, 'João Silva', '1992-04-23', 'M', '2022-01-10', 1, 300);
Faça uma lista dos empregados agrupados pelo nome do departamento.
SELECT d.nm_departamento, e.nome 
FROM tb_empregado e, tb_departamento d 
WHERE e.fk_departamento = d.id_departamento;
Selecione os empregados que fazem aniversário no mês de julho.
SELECT nome, dt_nascimento 
FROM tb_empregado 
WHERE MONTH(dt_nascimento) = 7;
Liste todos os cargos junto com o número de empregados que ocupam cada cargo.
SELECT c.nm_cargo, COUNT(e.matricula) AS quantidade_empregados
FROM tb_cargo c, tb_empregado e
WHERE c.id_cargo = e.fk_cargo
GROUP BY c.id_cargo;
*/
show tables;
/*Selecionando todos empregadores na tabela empregados*/
select  * from tb_empregado;
/*Listando todos os cargos da tabela empregado*/
select * from tb_cargo;
/*Nome e a data de nascimento de todos os empregados do sexo feminino*/
select nome,dt_nascimento from tb_empregado where sexo = 'F';
/*Calculando salarios da tabela cargo*/
select sum (salario) as soma_salarios from tb_cargo;
/*Média salárial dos cargos*/
select avg (salario) as media_salarios from tb_cargo;
/*Maior e menor salário de cada cargo*/
select max(salario) as maior_salario, min(salario) as menor_salario from tb_cargo;
/*Quantidade de departamentos*/
select count(*) as quantidade_departamentos from tb_departamento;
select * from tb_empregado;
select * from tb_cargo;
use blog_php;
SELECT * FROM tb_departamento;
