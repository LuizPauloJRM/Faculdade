create database db_ibge;
USE db_ibge;
/*Criar a tabela tb_regioes*/

/* Criar a tabela tb_regioes para armazenar informações sobre as regiões */
CREATE TABLE tb_regioes 
(  
  	id INT NOT NULL PRIMARY KEY,  
	nome_regiao VARCHAR(40) NOT NULL,  
	sigla_regiao VARCHAR(2) NOT NULL
);
