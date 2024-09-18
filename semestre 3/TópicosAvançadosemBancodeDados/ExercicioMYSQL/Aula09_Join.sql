use db_company;
select matricula, nome,  nm_cargo, salario 
from  tb_empregado , tb_cargo 
where fk_cargo = id_cargo order by nome;
/*Selecione  matricula e nome do empregado, nome do cargo e salario de todos os empregados – usando JOIN*/ 
select matricula, nome,  nm_cargo, salario 
from  tb_empregado  INNER JOIN tb_cargo 
ON fk_cargo = id_cargo 
order by nome; 
/*Selecione  matricula e nome do empregado, nome do cargo e salario de todos os empregados - usando INNER JOIN*/
select matricula, nome,  nm_cargo, salario 
from  tb_empregado  INNER JOIN tb_cargo 
ON fk_cargo = id_cargo order by nome; 
/*Selecione nome do empregado, nome do departamento de todos os empregados em ordem alfabética de nome - usando INNER JOIN*/
 select matricula, nome, nm_departamento 
from  tb_empregado INNER JOIN tb_departamento 
ON  fk_departamento = id_departamento   
order by nome;
/*Selecione nome dos departamentos e nome de todos os empregados, 
deve aparecer o nome de todos os departamentos inclusive os departamentos que não tem empregados trabalhando - usando LEFT JOIN*/
select matricula, nome, nm_departamento 
from  tb_departamento LEFT JOIN tb_empregado
ON  fk_departamento = id_departamento ;

/*O mesmo resultado pode ser obtido pelo select usando o right join - apenas invertendo a ordem das tabelas no comando from */
select matricula, nome, nm_departamento 
from  tb_empregado RIGHT JOIN tb_departamento
ON  fk_departamento = id_departamento ;
/*Selecione apenas os nome dos departamentos que não tem empregados trabalhando - usando LEFT JOIN*/
select matricula, nome, nm_departamento 
from  tb_departamento LEFT JOIN tb_empregado
ON  fk_departamento = id_departamento   
WHERE fk_departamento is null;
/*Selecione apenas os nome dos departamentos que não tem empregados trabalhando - usando RIGHT JOIN*/
select matricula, nome, nm_departamento 
from  tb_empregado RIGHT JOIN tb_departamento
/**/
ON  fk_departamento = id_departamento 
WHERE fk_departamento is null;

