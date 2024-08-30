Create database database_ibge;
use database_ibge;
CREATE TABLE tb_regioes (  
  	id INT NOT NULL PRIMARY KEY,  
	nome VARCHAR(40) NOT NULL,  
	sigla VARCHAR(2) NOT NULL
) ;
insert into tb_regioes (id,nome,sigla) 
Values
(1, 'Norte', 'N'),
(2, 'Nordeste', 'NE'),
(3, 'Sudeste', 'SE'),
(4, 'Sul', 'S'),
(5, 'Centro-Oeste', 'CO');
CREATE TABLE tb_estados (
  id INT NOT NULL PRIMARY KEY,
  nome VARCHAR(60) NOT NULL,
  sigla VARCHAR(2) NOT NULL,
  id_regiao INT DEFAULT NULL,
  FOREIGN KEY (id_regiao) REFERENCES tb_regioes (id)
);
insert into tb_estados (id,nome,sigla,id_regiao) Values
(11, 'Rondônia', 'RO', 1),
(12, 'Acre', 'AC', 1),
(13, 'Amazonas', 'AM', 1),
(14, 'Roraima', 'RR', 1),
(15, 'Pará', 'PA', 1),
(16, 'Amapá', 'AP', 1),
(17, 'Tocantins', 'TO', 1);
show tables;
desc tb_regioes;
desc tb_estados;
/*
Select
1 – Selecione todos os dados da tabela tb_regiões
2 – Selecione apenas o nome das regiões 
3 – Selecione todos os dados da tabela tb_estados
4 – Selecione apenas o nome do estado e a sigla dos estados
5 – Selecione o id_região da tabela estados de forma distinta;
*/
/*Selecionando todos os dados da tabela regiões*/
SELECT * FROM tb_regioes;
/*Selecionando apenas o nome das regioes da tabela*/
SELECT nome FROM tb_regioes;
/*Selecionando tudo da tabela estado  */
SELECT * FROM tb_estados;
/*Apenas nome*/
SELECT nome From tb_estados;
/*WHERE*/








