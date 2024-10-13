/*O sistema de e-commerce é responsável por gerenciar clientes, produtos, pedidos, categorias de produtos e informações sobre
pagamentos. O banco de dados deve armazenar informações de clientes, produtos, categorias, detalhes dos pedidos e histórico de
pagamentos. A estrutura do banco deve permitir fácil integração entre essas informações para que os usuários possam fazer pedidos e
que o sistema gerencie os dados de forma eficiente.*/
show databases;
create database Ecommerce;
use Ecommerce;
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(15),
    endereco VARCHAR(255),
    cidade VARCHAR (100),
    estado VARCHAR (50),
    data_cadastro DATE DEFAULT (CURRENT_DATE())
);

/*O sistema de e-commerce é responsável por gerenciar clientes, produtos, pedidos, categorias de produtos e informações sobre
pagamentos. O banco de dados deve armazenar informações de clientes, produtos, categorias, detalhes dos pedidos e histórico de
pagamentos. A estrutura do banco deve permitir fácil integração entre essas informações para que os usuários possam fazer pedidos e
que o sistema gerencie os dados de forma eficiente.*/
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao varchar(255)
);
/*Produtos*/
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    estoque INT NOT NULL,
    categoria_id INT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);
/*Pedidos*/
CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) default 'Pendente',
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
/*O sistema de e-commerce é responsável por gerenciar clientes, produtos, pedidos, categorias de produtos e informações sobre
pagamentos. O banco de dados deve armazenar informações de clientes, produtos, categorias, detalhes dos pedidos e histórico de
pagamentos. A estrutura do banco deve permitir fácil integração entre essas informações para que os usuários possam fazer pedidos e que
o sistema gerencie os dados de forma eficiente.*/
CREATE TABLE detalhes_pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    produto_id INT,
    quantidade INT NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES produtos(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
/*Tabela pagamentos*/
CREATE TABLE pagamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    metodo_pagamento VARCHAR(50) NOT NULL,
    valor_pago DECIMAL(10, 2) NOT NULL,
    status_pagamento VARCHAR(50) DEFAULT 'Pendente',
    FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
INSERT INTO clientes (nome, sobrenome, email, telefone, endereco, cidade, estado) VALUES 
('João', 'Silva', 'joao.silva@email.com', '123456789', 'Rua 1, 123', 'São Paulo', 'SP'),
('Maria', 'Oliveira', 'maria.oliveira@email.com', '987654321', 'Rua 2, 456', 'Rio de Janeiro', 'RJ');
INSERT INTO categorias (nome, descricao) VALUES 
('Eletrônicos', 'Dispositivos eletrônicos e gadgets'),
('Livros', 'Livros de diversos gêneros');
INSERT INTO produtos (nome, descricao, preco, estoque, categoria_id) VALUES 
('Smartphone', 'Smartphone de última geração', 2500.00, 50, 1),
('Notebook', 'Notebook para uso diário', 3500.00, 30, 1),
('Livro de Programação', 'Livro sobre linguagens de programação', 80.00, 100, 2);
INSERT INTO pedidos (cliente_id, status, total) VALUES 
(1, 'Em Processamento', 2580.00),
(2, 'Concluído', 80.00);
INSERT INTO detalhes_pedido (pedido_id, produto_id, quantidade, preco) VALUES 
(1, 1, 1, 2500.00),  -- Pedido do João, Smartphone
(1, 3, 1, 80.00),    -- Pedido do João, Livro de Programação
(2, 3, 1, 80.00);    -- Pedido da Maria, Livro de Programação
INSERT INTO pagamentos (pedido_id, metodo_pagamento, valor_pago, status_pagamento) VALUES 
(1, 'Cartão de Crédito', 2580.00, 'Pago'),
(2, 'Boleto', 80.00, 'Pago');
/*Consulta de dados*/
CREATE VIEW vw_pedidos_completos AS
SELECT 
    p.id AS pedido_id,
    c.nome AS cliente_nome,
    c.sobrenome AS cliente_sobrenome,
    d.nome AS produto_nome,
    dp.quantidade,
    dp.preco,
    p.total,
    pg.metodo_pagamento,
    pg.status_pagamento
FROM 
    pedidos p
JOIN 
    clientes c ON p.cliente_id = c.id
JOIN 
    detalhes_pedido dp ON p.id = dp.pedido_id
JOIN 
    produtos d ON dp.produto_id = d.id
JOIN 
    pagamentos pg ON p.id = pg.pedido_id;

SELECT * FROM vw_pedidos_completos;







