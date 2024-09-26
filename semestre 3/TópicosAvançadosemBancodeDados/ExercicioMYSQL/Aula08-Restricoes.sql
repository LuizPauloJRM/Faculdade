create database aula08;
create table cliente(
	ClienteID INT AUTO_INCREMENT PRIMARY KEY,
	Nome VARCHAR(100) NOT NULL,
	Idade INT NOT NULL,
	CodigoPostal VARCHAR(10) NOT NULL,
	/* Restringe a idade a um intervalo válido (exemplo: entre 18 e 120 anos)*/
	CONSTRAINT chk_idade CHECK (Idade BETWEEN 18 AND 120),
	/* Garante que o código postal tenha o formato correto (exemplo: 5 dígitos)*/
	CONSTRAINT chk_codigo_postal CHECK (CodigoPostal REGEXP '^[0-9]{5}$')
    );
    desc cliente;
    /*Inserindo dados validos*/
    INSERT INTO cliente (Nome, Idade, CodigoPostal) VALUES ('João Silva', 25, '12345'), ('Maria Souza', 40, '54321');
    /*Inserindo dados inválidos*/
    /*Este comando resultará em erro devido à idade fora do intervalo permitido*/
    INSERT INTO cliente (Nome, Idade, CodigoPostal) VALUES ('Pedro Santos', 15, '67890');
	/*Este comando resultará em erro devido ao formato incorreto do código postal*/
	INSERT INTO cliente (Nome, Idade, CodigoPostal) VALUES ('Ana Lima', 30, 'ABCDE');
    show tables;
    desc cliente;


    

