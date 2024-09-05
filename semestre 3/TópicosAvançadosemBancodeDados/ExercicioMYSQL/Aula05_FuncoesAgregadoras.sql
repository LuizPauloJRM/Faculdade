CREATE TABLE tb_cargo 
(  
  id_cargo INT NOT NULL PRIMARY KEY,  
    nm_cargo VARCHAR(60) NOT NULL,  
    salario DECIMAL(9,2) NOT NULL
);
CREATE TABLE  tb_departamento 
( 
  id_departamento INT NOT NULL PRIMARY KEY,  
  nm_departamento VARCHAR(40) NOT NULL
);

CREATE TABLE tb_empregado
(  
matricula INT(11) NOT NULL PRIMARY KEY,  
nome VARCHAR(80) NOT NULL,  
dt_nascimento DATE NOT NULL,  
sexo ENUM('M', 'F') NOT NULL,  
dt_admissao DATE NOT NULL,  
fk_cargo INT NOT NULL,  
fk_departamento INT NOT NULL,  
FOREIGN KEY (fk_cargo) REFERENCES tb_cargo (id_cargo),  
FOREIGN KEY (fk_departamento) REFERENCES tb_departamento (id_departamento)
);
insert into tb_cargo (id_cargo, nm_cargo, salario) values 
(1, 'Advogado' , 9200.00),
(2, 'Administrador', 6500.00),
(3, 'Contador', 5600.00),
(4, 'Estagiário', 980.00),
(5, 'Gerente de Projeto', 8300.00),
(6, 'Programador', 7500.00),
(7, 'Administrador de Banco de Dados', 5990.00),
(8, 'Cientista de Dados', 8700.00),
(9, 'Secretária', 2200.00);

select sum(salario) as soma_salario from tb_cargo;
SELECT nm_cargo, salario
FROM tb_cargo
WHERE salario = (SELECT MAX(salario) FROM tb_cargo)
   OR salario = (SELECT MIN(salario) FROM tb_cargo);
select 
	e.nome as nome_empregado,
    e.dt_admissao as admissao, 
    c.nm_cargo as cargo
from 
	tb_cargo c,
    tb_empregado e
where 
	id_cargo =fk_cargo;
select e.nome as NomeEmpregado, e.matricula as Matricula, c.nm_cargo as NomeCargo, c.salario as Salario
from tb_empregado e, tb_cargo c
where e.fk_cargo = c.id_cargo;

select e.nome as NomeEmpregado, e.matricula as Matricula, c.nm_cargo as NomeCargo, c.salario as Salario, d.nm_departamento as NomeDepartamento
from tb_empregado e, tb_cargo c, tb_departamento d
where e.fk_cargo = c.id_cargo and e.fk_departamento = d.id_departamento;

select 	nm_cargo, salario	   	
	From tb_cargo
Where salario > (select avg(salario) from tb_cargo)


