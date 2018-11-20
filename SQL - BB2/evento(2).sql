DROP TABLE IF EXISTS Evento CASCADE;
DROP TABLE IF EXISTS Cliente_empresa CASCADE;
DROP TABLE IF EXISTS Cliente_pessoa CASCADE;
DROP TABLE IF EXISTS Cliente CASCADE;
DROP TABLE IF EXISTS Empresa CASCADE;
DROP TABLE IF EXISTS Funcionario CASCADE;
DROP TABLE IF EXISTS Localidade CASCADE;
DROP TABLE IF EXISTS Deposito CASCADE;
DROP TABLE IF EXISTS Material CASCADE;
DROP TABLE IF EXISTS Funcionario_Gerencia CASCADE;
DROP TABLE IF EXISTS Empresa_Funcionario CASCADE;
DROP TABLE IF EXISTS Evento_Local CASCADE;
DROP TABLE IF EXISTS Local_Material CASCADE;
DROP TABLE IF EXISTS Cliente_Evento CASCADE;
DROP TABLE IF EXISTS Cliente_Material CASCADE;


CREATE TABLE IF NOT EXISTS Evento (
	ID_Evento SERIAL NOT NULL,
	data_evento VARCHAR(30),
	categoria VARCHAR(30),
	tipo VARCHAR(30),
	CONSTRAINT ID_Evento_Pkey PRIMARY KEY (ID_Evento)
);

CREATE TABLE IF NOT EXISTS Cliente (
	ID_cliente SERIAL NOT NULL,
	nome VARCHAR(50),
	login VARCHAR(20),
	senha VARCHAR(20),
	CONSTRAINT ID_cliente_Pkey PRIMARY KEY (ID_cliente)
);

CREATE TABLE IF NOT EXISTS Cliente_empresa (
	CNPJ VARCHAR(14) PRIMARY KEY,
	ID_cliente_emp INTEGER NOT NULL,
	FOREIGN KEY(ID_cliente_emp) REFERENCES Cliente (ID_cliente)
);

CREATE TABLE IF NOT EXISTS Cliente_pessoa (
	CPF VARCHAR(12) NOT NULL,
	sexo VARCHAR(15),
	ID_cliente_pess INTEGER,
	FOREIGN KEY(ID_cliente_pess) REFERENCES Cliente (ID_cliente),
	CONSTRAINT CPF_Pkey PRIMARY KEY (CPF)
);

CREATE TABLE IF NOT EXISTS Empresa (
	nome VARCHAR(50),
	ID_empresa SERIAL NOT NULL,
	CNPJ VARCHAR(14),
	CONSTRAINT ID_empresa_Pkey PRIMARY KEY (ID_empresa)
);

CREATE TABLE IF NOT EXISTS Funcionario (
	nome VARCHAR(50),
	senha VARCHAR(30),
	login VARCHAR(30),
	CPF_Fun VARCHAR(12) NOT NULL,
	sexo VARCHAR(10),
	CONSTRAINT CPF_Fun_Pkey PRIMARY KEY (CPF_Fun)
);

CREATE TABLE IF NOT EXISTS Localidade (
	ID_local SERIAL NOT NULL,
	ID_Evento VARCHAR(30),
	endereco VARCHAR(50),
	nome VARCHAR(50),
	CONSTRAINT ID_local_Pkey PRIMARY KEY (ID_local)
);

CREATE TABLE IF NOT EXISTS Deposito (
	nome VARCHAR(50),
	ID_deposito SERIAL UNIQUE NOT NULL,
	capacidade DECIMAL(10),
	ID_Evento INTEGER,
	FOREIGN KEY(ID_Evento) REFERENCES Evento (ID_Evento)
);

CREATE TABLE IF NOT EXISTS Material (
	ID_material SERIAL NOT NULL,
	preco DECIMAL(10),
	nome VARCHAR(50),
	qualidade VARCHAR(30),
	ID_deposito INTEGER,
	FOREIGN KEY(ID_deposito) REFERENCES Deposito (ID_deposito),
	CONSTRAINT ID_material_Pkey PRIMARY KEY (ID_material)
);

CREATE TABLE IF NOT EXISTS Funcionario_Gerencia (
	CPF VARCHAR(12),
	possui_CPF VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Empresa_Funcionario  (
	data_contrato TIMESTAMP,
	CPF VARCHAR(12),
	ID_empresa INTEGER,
	ducarao VARCHAR(10),
	FOREIGN KEY(CPF) REFERENCES Funcionario (CPF_Fun),
	FOREIGN KEY(ID_empresa) REFERENCES Empresa (ID_empresa)
);

CREATE TABLE IF NOT EXISTS Evento_Local (
	ID_Evento INTEGER,
	ID_local INTEGER,
	FOREIGN KEY(ID_Evento) REFERENCES Evento (ID_Evento),
	FOREIGN KEY(ID_local) REFERENCES Localidade (ID_local)
);

CREATE TABLE IF NOT EXISTS Local_Material (
	ID_local INTEGER,
	ID_material INTEGER,
	FOREIGN KEY(ID_local) REFERENCES Localidade (ID_local),
	FOREIGN KEY(ID_material) REFERENCES Material (ID_material)
);

CREATE TABLE IF NOT EXISTS Cliente_Evento (
	data_contrato TIMESTAMP,
	valor VARCHAR(10),
	ID_empresa SERIAL,
	ID_Evento SERIAL,
	ID_cliente SERIAL,
	PRIMARY KEY(ID_empresa,ID_Evento,ID_cliente)
);

CREATE TABLE IF NOT EXISTS Cliente_Material (
	ID_cliente INTEGER,
	ID_material INTEGER,
	FOREIGN KEY(ID_cliente) REFERENCES Cliente (ID_cliente),
	FOREIGN KEY(ID_material) REFERENCES Material (ID_material)
);

ALTER TABLE Cliente_empresa ADD FOREIGN KEY(ID_cliente_emp) REFERENCES Cliente (ID_cliente);
ALTER TABLE Cliente_pessoa ADD FOREIGN KEY(ID_cliente_pess) REFERENCES Cliente (ID_cliente);

