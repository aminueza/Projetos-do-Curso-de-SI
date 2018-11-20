﻿DROP TABLE IF EXISTS LOGIN CASCADE;
CREATE TABLE IF NOT EXISTS LOGIN(
 COD_LOGIN BIGSERIAL NOT NULL UNIQUE,
 LOGIN VARCHAR(30) NOT NULL,
 SENHA VARCHAR(50) NOT NULL,
 CONSTRAINT COD_LOGIN_PKEY PRIMARY KEY (COD_LOGIN)
);

DROP TABLE IF EXISTS ESTADO CASCADE;
CREATE TABLE IF NOT EXISTS ESTADO(
 COD_ESTADO INTEGER NOT NULL UNIQUE,
 SIGLA VARCHAR(2),
 NOME_EST VARCHAR(30),
 CONSTRAINT COD_EST_PKEY PRIMARY KEY (COD_ESTADO)
);

DROP TABLE IF EXISTS CIDADE CASCADE;
CREATE TABLE IF NOT EXISTS CIDADE(
 COD_CIDADE BIGSERIAL NOT NULL UNIQUE,
 NOME_CID VARCHAR(40),
 COD_ESTADO INTEGER,
 CONSTRAINT COD_CIDADE_PKEY PRIMARY KEY (COD_CIDADE),
 FOREIGN KEY(COD_ESTADO) REFERENCES ESTADO(COD_ESTADO)
);

DROP TABLE IF EXISTS AREA_PROFISSIONAL CASCADE;
CREATE TABLE IF NOT EXISTS AREA_PROFISSIONAL (
 COD_AREA_PROFISSIONAL BIGSERIAL NOT NULL UNIQUE,
 AREA_PROFI_DESC  VARCHAR(30)NOT NULL,
 CONSTRAINT COD_AREA_PROFISSIONAL_PKEY PRIMARY KEY (COD_AREA_PROFISSIONAL)
);

DROP TABLE IF EXISTS CANDIDATO CASCADE;
CREATE TABLE IF NOT EXISTS CANDIDATO(
 COD_CAND BIGSERIAL NOT NULL UNIQUE,
 CAND_NOME VARCHAR(100) NOT NULL,
 CAND_CPF CHAR (11)NOT NULL,
 CAND_RUA VARCHAR(100)NOT NULL ,
 CAND_CEP CHAR(8)NOT NULL,
 CAND_COMPLEMENTO VARCHAR(30),
 CAND_FIXO CHAR(10),
 CAND_CELULAR CHAR(11),
 CAND_DT_NASC CHAR(8) NOT NULL,
 CAND_SEXO CHAR(1) NOT NULL,
 COD_ESTADO INTEGER,
 COD_CIDADE INTEGER,
 COD_AREA_PROFISSIONAL INTEGER,
 COD_USUARIO INTEGER,
 CONSTRAINT COD_CAND_PKEY PRIMARY KEY (COD_CAND),
 FOREIGN KEY(COD_ESTADO) REFERENCES ESTADO(COD_ESTADO),
 FOREIGN KEY(COD_CIDADE) REFERENCES CIDADE(COD_CIDADE),
 FOREIGN KEY(COD_AREA_PROFISSIONAL) REFERENCES AREA_PROFISSIONAL(COD_AREA_PROFISSIONAL)
);

DROP TABLE IF EXISTS USUARIO CASCADE;
CREATE TABLE IF NOT EXISTS USUARIO(
 COD_CAND INTEGER,
 COD_LOGIN INTEGER,
 FOREIGN KEY(COD_CAND) REFERENCES CANDIDATO(COD_CAND),
 FOREIGN KEY(COD_LOGIN) REFERENCES LOGIN(COD_LOGIN)
);

DROP TABLE IF EXISTS VAGA CASCADE;
CREATE TABLE IF NOT EXISTS VAGA(
 COD_VAGA BIGSERIAL NOT NULL UNIQUE,
 VAG_NOME VARCHAR(50),
 VAG_LOCAL VARCHAR(80) NOT NULL,
 VAG_CARGO VARCHAR (50) NOT NULL,
 VAG_DESCR VARCHAR(300) NOT NULL,
 VAG_SALARIO  DECIMAL(10,2), 
 VAG_PRET_SALARIAL DECIMAL(10,2),
 VAG_COD_AREA_PROFI INTEGER,
 VAG_BENEF VARCHAR(200),
 COD_AREA_PROFISSIONAL INTEGER,
 CONSTRAINT COD_VAGA_PKEY PRIMARY KEY (COD_VAGA),
 FOREIGN KEY(COD_AREA_PROFISSIONAL) REFERENCES AREA_PROFISSIONAL(COD_AREA_PROFISSIONAL)
);

DROP TABLE IF EXISTS EMPRESA CASCADE;
CREATE TABLE IF NOT EXISTS EMPRESA(
 COD_EMPR BIGSERIAL NOT NULL UNIQUE,
 EMPR_NOME VARCHAR(60) NOT NULL,
 CAND_CNPJ INT NOT NULL,
 CAND_RUA VARCHAR(100)NOT NULL ,
 CAND_CEP CHAR(8)NOT NULL,
 CAND_COMPLEMENTO VARCHAR(30),
 COD_ESTADO INTEGER,
 COD_CIDADE INTEGER,
 COD_VAGA INTEGER,
 COD_CAND INTEGER,
 CONSTRAINT COD_EMPR_PKEY PRIMARY KEY (COD_EMPR),
 FOREIGN KEY(COD_ESTADO) REFERENCES ESTADO(COD_ESTADO),
 FOREIGN KEY(COD_CIDADE) REFERENCES CIDADE(COD_CIDADE),
 FOREIGN KEY(COD_VAGA) REFERENCES VAGA(COD_VAGA),
 FOREIGN KEY(COD_CAND) REFERENCES CANDIDATO(COD_CAND)
);

----------------DML-----------------------------
CREATE OR REPLACE FUNCTION inserir_login(VARCHAR(30), VARCHAR(50)) RETURNS void AS $$

BEGIN

INSERT INTO login(login, senha) 
	VALUES ($1 , md5($2)); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_login('aminueza', '262632');

SELECT * FROM LOGIN;
-----------------------------------------------
CREATE OR REPLACE FUNCTION inserir_estado(INTEGER, VARCHAR(2), VARCHAR(30)) RETURNS void AS $$

BEGIN

INSERT INTO estado(cod_estado, sigla, nome_est) 
	VALUES ($1, $2, $3); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_estado(12,'AC','Acre');
SELECT inserir_estado(27,'AL','Alagoas');
SELECT inserir_estado(13,'AM','Amazonas');
SELECT inserir_estado(16,'AP','Amapá');
SELECT inserir_estado(29,'BA','Bahia');
SELECT inserir_estado(23,'CE','Ceará');
SELECT inserir_estado(53,'DF','Distrito Federal');
SELECT inserir_estado(32,'ES','Espírito Santo');
SELECT inserir_estado(52,'GO','Goiás');
SELECT inserir_estado(21,'MA','Maranhão');
SELECT inserir_estado(31,'MG','Minas Gerais');
SELECT inserir_estado(50,'MS','Mato Grosso do Sul');
SELECT inserir_estado(51,'MT','Mato Grosso');
SELECT inserir_estado(15,'PA','Pará');
SELECT inserir_estado(25,'PB','Paraíba');
SELECT inserir_estado(26,'PE','Pernambuco');
SELECT inserir_estado(22,'PI','Piauí');
SELECT inserir_estado(41,'PR','Paraná');
SELECT inserir_estado(33,'RJ','Rio de Janeiro');
SELECT inserir_estado(24,'RN','Rio Grande do Norte');
SELECT inserir_estado(11,'RO','Rondônia');
SELECT inserir_estado(14,'RR','Roraima');
SELECT inserir_estado(43,'RS','Rio Grande do Sul');
SELECT inserir_estado(42,'SC','Santa Catarina');
SELECT inserir_estado(28,'SE','Sergipe');
SELECT inserir_estado(35,'SP','São Paulo');
SELECT inserir_estado(17,'TO','Tocantins');

SELECT * FROM ESTADO;