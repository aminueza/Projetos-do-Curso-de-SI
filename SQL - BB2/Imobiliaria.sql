drop table if exists proprietario cascade;
create table if not exists proprietario(
codprop bigserial, 
nomeprop varchar(50) not null, 
foneprop varchar(20), 
emailprop varchar(50), 
cpfprop varchar(14),
constraint codprop_pkey primary key (codprop)
);

drop table if exists inquilino cascade;
create table if not exists inquilino(
codinq bigserial, 
nomeinq varchar(50)not null, 
foneinq varchar(20), 
emailinq varchar(50), 
cpfinq varchar(14),
constraint codinq_pkey primary key (codinq)
);

drop table if exists tipoimovel cascade;
create table if not exists tipoimovel(
codtipo bigserial, 
desctipo varchar(50),
constraint codtipo_pkey primary key (codtipo)
);

drop table if exists imovel cascade;
create table if not exists imovel (
codimovel bigserial, 
endimovel varchar(80) not null, 
metragemimovel float, 
numquartos integer, 
codprop integer,
codtipo integer,
constraint codimovel_pkey primary key (codimovel),
foreign key (codprop) references proprietario(codprop), 
foreign key (codtipo)references tipoimovel(codtipo)
);

drop table if exists corretor cascade;
create table if not exists corretor (
codcor bigserial, 
creci varchar(10), 
nomecor varchar(50)not null, 
fonecor varchar(20), 
emailcor varchar(50),
constraint codcor_pkey primary key (codcor)
);

drop table if exists venda cascade;
create table if not exists venda(
codvenda bigserial,
valorvenda float, 
datavenda date, 
codprop integer,
codcor integer,
codimovel integer,
constraint codvenda_pkey primary key (codvenda),
foreign key (codprop) references proprietario(codprop), 
foreign key (codcor) references corretor(codcor), 
foreign key (codimovel) references imovel(codimovel)
);

drop table if exists aluguel cascade;
create table if not exists aluguel(
codaluguel bigserial,
mesesaluguel integer, 
valoraluguel float, 
datainicio date, 
datafim date, 
codinq integer,
codcor integer,
codimovel integer,
constraint codaluguel_pkey primary key (codaluguel),
foreign key (codinq) references inquilino(codinq), 
foreign key (codcor) references corretor(codcor), 
foreign key (codimovel) references imovel(codimovel)
);

---DML-----

CREATE OR REPLACE FUNCTION inserir_proprietario(varchar(50),varchar(20),varchar(50),varchar(14)) RETURNS void AS $$

BEGIN

INSERT INTO proprietario(nomeprop, foneprop, emailprop, cpfprop) 
	VALUES ($1, $2, $3, $4); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_proprietario('Januario', '99876545', 'januario@gmail.com', '07845687398');

SELECT * FROM proprietario;
---------------------
CREATE OR REPLACE FUNCTION inserir_inquilino(varchar(50),varchar(20),varchar(50),varchar(14)) RETURNS void AS $$

BEGIN

INSERT INTO inquilino(nomeinq, foneinq, emailinq, cpfinq) 
	VALUES ($1, $2, $3, $4); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_inquilino('James', '99874535', 'james@gmail.com', '07455687397');

SELECT * FROM inquilino;
--------------------------------------------
CREATE OR REPLACE FUNCTION inserir_tpimovel(varchar(50)) RETURNS void AS $$

BEGIN

INSERT INTO tipoimovel(desctipo) 
	VALUES ($1); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_tpimovel('Casa');
SELECT inserir_tpimovel('Apartamento');
SELECT inserir_tpimovel('Comercial');

SELECT * FROM tipoimovel;
--------------------------------------------------
CREATE OR REPLACE FUNCTION inserir_imovel(varchar(80), float, integer) RETURNS void AS $$

BEGIN

INSERT INTO imovel(endimovel, metragemimovel, numquartos) 
	VALUES ($1, $2, $3); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_imovel('Rua Doutor Sebastiao Pedrosa', '20', '3');

SELECT * FROM imovel;
--------------------------------------------
CREATE OR REPLACE FUNCTION inserir_corretor(varchar(10), varchar(50),varchar(20),varchar(50)) RETURNS void AS $$

BEGIN

INSERT INTO corretor(creci, nomecor, fonecor, emailcor) 
	VALUES ($1, $2, $3, $4); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_corretor('3210', 'Joao', '33334444', 'joao@zelare.com');

SELECT * FROM corretor;

---------------------------------------------
CREATE OR REPLACE FUNCTION inserir_venda(float) RETURNS void AS $$

BEGIN

INSERT INTO venda(valorvenda, datavenda) 
	VALUES ($1, now()); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_venda('500000');

SELECT * FROM venda;

---------------------------------------------
CREATE OR REPLACE FUNCTION inserir_aluguel(integer, float) RETURNS void AS $$

BEGIN

INSERT INTO aluguel(mesesaluguel, valoraluguel, datainicio, datafim) 
	VALUES ($1 , $2, now(), now() + INTERVAL'6 month'); 

END;

$$ LANGUAGE plpgsql;

SELECT inserir_aluguel('6', '500');

SELECT * FROM aluguel;

