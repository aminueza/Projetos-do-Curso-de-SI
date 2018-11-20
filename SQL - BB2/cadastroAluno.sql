DROP TABLE IF EXISTS telefone cascade;
DROP TABLE IF EXISTS endereco cascade;
DROP TABLE IF EXISTS curso cascade;
DROP TABLE IF EXISTS disciplina cascade;
DROP TABLE IF EXISTS professor cascade;
DROP TABLE IF EXISTS discurso cascade;
DROP TABLE IF EXISTS aula cascade;
DROP TABLE IF EXISTS aluno cascade;

CREATE TABLE IF NOT EXISTS telefone (
  id_tel serial NOT NULL,
  tel_home varchar(20) NOT NULL,
  tel_cel varchar(20) NOT NULL,
  CONSTRAINT id_tel_pkey PRIMARY KEY (id_tel)
);

CREATE TABLE IF NOT EXISTS endereco (
  id_end serial NOT NULL,
  rua varchar(20) NOT NULL,
  cidade varchar(20) NOT NULL,
  numero integer NOT NULL,
  sigla_estado char(2) NOT NULL,
  nome_estado varchar(20) NOT NULL,
  CONSTRAINT id_end_pkey PRIMARY KEY (id_end)
);

CREATE TABLE IF NOT EXISTS curso (
  id_curso serial NOT NULL,
  nome_curso varchar(20) NOT NULL,
  t_credito integer NOT NULL,
  CONSTRAINT id_curso_pkey PRIMARY KEY (id_curso)
);

CREATE TABLE IF NOT EXISTS aluno (
  id_aluno serial NOT NULL,
  nome_aluno varchar(20) NOT NULL,
  nota integer NOT NULL,
  id_tel serial NOT NULL references telefone (id_tel),
  id_end serial NOT NULL references endereco (id_end),
  id_curso serial NOT NULL references curso (id_curso),
  CONSTRAINT id_aluno_pkey PRIMARY KEY (id_aluno)
);

CREATE TABLE IF NOT EXISTS disciplina (
  id_disc serial NOT NULL,
  nome_disc varchar(20) NOT NULL,
  qnt_credito integer NOT NULL,
  CONSTRAINT id_disc_pkey PRIMARY KEY (id_disc)
);

CREATE TABLE IF NOT EXISTS disCurso (
  id_discurso serial NOT NULL,
  id_disc serial NOT NULL references disciplina (id_disc),
  id_curso serial NOT NULL references curso (id_curso),
  CONSTRAINT id_discurso_pkey PRIMARY KEY (id_discurso)
);

CREATE TABLE IF NOT EXISTS professor (
  id_prof serial NOT NULL,
  nome_prof varchar(20) NOT NULL,
  admissao integer NOT NULL,
  CONSTRAINT id_prof_pkey PRIMARY KEY (id_prof)
);

CREATE TABLE IF NOT EXISTS aula (
  id_aula serial NOT NULL,
  semestre varchar(20) NOT NULL,
  nota integer NOT NULL,
  id_aluno serial NOT NULL references aluno (id_aluno),
  id_dis serial NOT NULL references disciplina (id_disc),
  id_prof serial NOT NULL references professor (id_prof)
  CONSTRAINT id_aula_pkey PRIMARY KEY (id_aula)
);

--DML Cadastro de Alunos


SELECT * FROM telefone;
SELECT * FROM endereco;
SELECT * FROM aluno;
SELECT * FROM curso;
SELECT * FROM disciplina;
SELECT * FROM endereco;
SELECT * FROM disCurso;
SELECT * FROM professor;
SELECT * FROM aula;

INSERT INTO telefone (tel_home, tel_cel) values ('8333388943', '8393391376');
INSERT INTO telefone (tel_home, tel_cel) values ('8333388967', '8387161105');
INSERT INTO telefone (tel_home, tel_cel) values ('8333368942', '8391050538');

INSERT INTO endereco ("rua", "cidade", "numero", "sigla_estado", "nome_estado") values ('Joao da Mata', 'Campina Grande', '28', 'PB', 'Paraiba');
INSERT INTO endereco ("rua", "cidade", "numero", "sigla_estado", "nome_estado") values ('Joao da Mata', 'Campina Grande', '28', 'PB', 'Paraiba');
INSERT INTO endereco ("rua", "cidade", "numero", "sigla_estado", "nome_estado") values ('Joao da Silva', 'Campina Grande', '56', 'PB', 'Paraiba');

INSERT INTO curso ("nome_curso", "t_credito") values ('SI', '5600');
INSERT INTO curso ("nome_curso", "t_credito") values ('Direito', '5900');
INSERT INTO curso ("nome_curso", "t_credito") values ('Medicina', '8000');
INSERT INTO curso ("nome_curso", "t_credito") values ('Jogos', '3800');

INSERT INTO aluno ("nome_aluno", "nota") values ('Amanda', '9');
INSERT INTO aluno ("nome_aluno", "nota") values ('Aline', '8');
INSERT INTO aluno ("nome_aluno", "nota") values ('Washington', '7');
INSERT INTO aluno ("nome_aluno", "nota") values ('Renata', '7');

INSERT INTO disciplina ("nome_disc", "qnt_credito") values ('ATAL', '80');
INSERT INTO disciplina ("nome_disc", "qnt_credito") values ('LABDB', '80');
INSERT INTO disciplina ("nome_disc", "qnt_credito") values ('BD', '80');
INSERT INTO disciplina ("nome_disc", "qnt_credito") values ('CASI', '80');

INSERT INTO professor ("nome_prof", "admissao") values ('Adriano', '2012');
INSERT INTO professor ("nome_prof", "admissao") values ('Bruno Brito', '2010');
INSERT INTO professor ("nome_prof", "admissao") values ('Isabel', '2011');
INSERT INTO professor ("nome_prof", "admissao") values ('Fabricio', '2009');

INSERT INTO aula ("semestre", "nota") values ('2015.1', '8');