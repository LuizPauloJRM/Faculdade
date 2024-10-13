Create database SistemaGestaoAcademica;
use SistemaGestaoAcademica;
create table curso(
	id int auto_increment primary key,
    nome varchar(100) not null
);
/*Tabela professores*/
create table professores(
	id int auto_increment primary key,
    nome varchar (100) not null,
    sobrenome varchar (100) not null
);
CREATE TABLE disciplinas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    professores_id INT, 
    curso_id INT,
    FOREIGN KEY (professores_id) REFERENCES professores(id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    FOREIGN KEY (curso_id) REFERENCES curso(id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
);
CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE nota (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT,
    disciplina_id INT,
    nota DECIMAL(4,2) NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

