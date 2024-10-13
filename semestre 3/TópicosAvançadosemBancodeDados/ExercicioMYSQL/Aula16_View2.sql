create database view2;
use view2;
CREATE TABLE curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);
CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
CREATE TABLE disciplina (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
CREATE TABLE notas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT,
    disciplina_id INT,
    nota DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES aluno(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (disciplina_id) REFERENCES disciplina(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
INSERT INTO curso (nome) VALUES ('Sistemas de Informação'), ('Engenharia de Software');
INSERT INTO aluno (nome, sobrenome, curso_id) VALUES 
('Maria', 'Silva', 1),
('João', 'Souza', 2);
INSERT INTO disciplina (nome, curso_id) VALUES 
('Banco de Dados', 1),
('Programação', 2);
INSERT INTO notas (aluno_id, disciplina_id, nota) VALUES 
(1, 1, 9.5),
(2, 2, 8.7);
CREATE VIEW vw_notas_alunos AS
SELECT 
    a.nome AS aluno_nome,
    a.sobrenome AS aluno_sobrenome,
    d.nome AS disciplina_nome,
    n.nota
FROM 
    notas n
JOIN 
    aluno a ON n.aluno_id = a.id
JOIN 
    disciplina d ON n.disciplina_id = d.id;
SELECT * FROM vw_notas_alunos;
