CREATE DATABASE IF NOT EXISTS PROJETOPOO;
USE projetopoo;
SET AUTOCOMMIT = 0;

CREATE TABLE IF NOT EXISTS PESSOA (
	ID INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(40) NOT NULL,
	DTNASCIMENTO DATE NOT NULL,
	RG VARCHAR() NOT NULL
);

CREATE TABLE IF NOT EXISTS MORADOR(
	MPESSOA INT PRIMARY KEY,
	BLOCO VARCHAR(10) NOT NULL,
	NAPT INT NOT NULL,
	CODESTACIONAMENTO INT,
	CONSTRAINT FK_PESSOA FOREIGN KEY(MPESSOA) REFERENCES PESSOA(ID)
);

CREATE TABLE IF NOT EXISTS VISITANTE(
	MPESSOA INT PRIMARY KEY,
	MMORADORRESPONSAVEL INT NOT NULL,
	TIPOVISITANTE ENUM('PRESTADORSERVICO','VISITANTE') NOT NULL,
	CONSTRAINT FK_VISITANTE_PESSOA FOREIGN KEY(MPESSOA) REFERENCES PESSOA(ID),
	CONSTRAINT FK_VISITANTE_MORADOR FOREIGN KEY(MMORADORRESPONSAVEL) REFERENCES PESSOA(ID)
);

CREATE TABLE IF NOT EXISTS FUNCIONARIO(
	MPESSOA INT PRIMARY KEY,
	TIPOFUNCIONARIO ENUM('SEGURANCA','ZELADOR','FAXINEIRA','PORTEIRO'),
	CONSTRAINT FUNCIONARIO_PESSOA FOREIGN KEY(MPESSOA) REFERENCES PESSOA(ID)
);

CREATE TABLE IF NOT EXISTS LOGENTRADA(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	MPESSOA INT NOT NULL,
	DESCRICAOACAO VARCHAR(50) NOT NULL,
	DATAENTRADA DATETIME NOT NULL,
	MAVISITAR INT NOT NULL,
	CONSTRAINT FK_LOGENTRADA_PESSOA FOREIGN KEY(MPESSOA) REFERENCES PESSOA(ID),
	CONSTRAINT FK_LOGENTRADA_AVISITAR FOREIGN KEY(MAVISITAR) REFERENCES MORADOR(MPESSOA)
);

CREATE TABLE IF NOT EXISTS BLOCO(
	NOME VARCHAR(10)
);
