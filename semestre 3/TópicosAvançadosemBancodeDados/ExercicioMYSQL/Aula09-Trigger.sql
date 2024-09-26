/*Trigger*/
create database exemploTrigger;
use exemploTrigger;
CREATE TABLE Clientes ( 
	ClienteID INT AUTO_INCREMENT PRIMARY KEY, 
	Nome VARCHAR(100) NOT NULL, 
	Idade INT NOT NULL, 
	CodigoPostal VARCHAR(10) NOT NULL 
);
CREATE TABLE Historico_Clientes (
    HistoricoID INT AUTO_INCREMENT PRIMARY KEY,
    ClienteID INT NOT NULL,
    Nome VARCHAR(100) NOT NULL,
    Idade INT NOT NULL,
    CodigoPostal VARCHAR(10) NOT NULL,
    DataAlteracao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Usuario VARCHAR(50) NOT NULL
);
DELIMITER // 
CREATE TRIGGER trg_auditoria_clientes
AFTER UPDATE ON Clientes
FOR EACH ROW
BEGIN
    INSERT INTO Historico_Clientes (ClienteID, Nome, Idade, CodigoPostal, Usuario)
    VALUES (OLD.ClienteID, OLD.Nome, OLD.Idade, OLD.CodigoPostal, USER());
END;
// DELIMITER ;
desc clientes;
desc Historico_Clientes;
/*Testando Trigger*/
/*Atualizando um cliente*/
UPDATE Clientes
SET Nome = 'João Pereira', Idade = 30
WHERE ClienteID = 1;
/* Verificando o histórico de auditoria*/
SELECT * FROM Historico_Clientes;
show tables;
desc clientes;




