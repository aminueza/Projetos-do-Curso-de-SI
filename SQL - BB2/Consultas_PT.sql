select fase, documento from despesas WHERE payday BETWEEN '2010/10/10' AND '2014/12/12'ORDER BY cod_superior;

select fase, documento from despesas WHERE valor < '100,000,000.00' ORDER BY cod_superior;

select documento, nome_superior, nome_gestora from despesas ORDER BY cod_superior;

select documento, nome_favorecido, nome_sub from despesas ORDER BY cod_superior;

select documento, nome_funcao from despesas ORDER BY cod_superior;

select documento, valor from despesas ORDER BY cod_superior;

select * from despesas