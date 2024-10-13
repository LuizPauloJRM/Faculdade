create database cascata;
use cascata;
create table funcionarios(
	id int auto_increment primary key,
    nome varchar (100),
    sobrenome varchar(100)
);
create table dependente(
	id int auto_increment primary key, 
    nome varchar(100),
    funcionario_id int,
    foreign key (funcionario_id) references funcionarios(id)
    on delete cascade /*Exclui dependentes automaticamente se o funcionarioo for removido*/ 
    on update cascade /**/
);
/*Inserindo registros na tabela funcionarios*/
insert into funcionarios (nome,sobrenome)
values ('João','Silva'),
	   ('Maria','Oliveira'),
       ('Carlos','Santos');
select * from funcionarios;
/*Inserindo na tabela dependente*/
INSERT INTO dependente (nome, funcionarios_id)
VALUES 
('Pedro', 1),
('Ana', 1),
('Laura', 2);
