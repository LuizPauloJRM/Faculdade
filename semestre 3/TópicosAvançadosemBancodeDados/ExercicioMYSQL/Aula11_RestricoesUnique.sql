create database loja;
use loja;
create table clientes2(
	clienteID int auto_increment primary key,
    Nome varchar(100) not null,
	Idade INT NOT NULL,
    CodigoPostal varchar(10) not null,
    unique (nome)
);
insert into
	clientes2(Nome,Idade,CodigoPostal)
values
	('Ana',25,'12345');
create database restricoes;
use restricoes;
create table clientes3(
	clienteID int auto_increment primary key,
    Nome varchar(100) not null,
	Idade INT NOT NULL,
    CodigoPostal varchar(10) not null,
    unique (nome)
);

begin
/*Verificando existencia */
	IF EXISTS (SELECT 1 FROM clientes3 WHERE Nome = p_nome)THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erro: O cliente já existe';
	ELSE
		insert into clientes3 (Nome,Idade,CodigoPostal)
		values (p_Nome, p_Idade,p_CodigoPostal);
	end if;
end//
delimiter;