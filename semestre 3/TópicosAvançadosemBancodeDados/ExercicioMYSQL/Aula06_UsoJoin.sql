use blog_php;
 select 
	e.matricula, 
    e.nome, 
    d.nm_departamento as departamento
    
from
	tb_empregado e, 
    tb_departamento d 
where 
	fk_departamento = id_departamento   
order by nome;
insert into tb_estados (id,nome,sigla,id_regiao) Values
(11, 'Rondônia', 'RO', 1),
(12, 'Acre', 'AC', 1),
(13, 'Amazonas', 'AM', 1),
(14, 'Roraima', 'RR', 1),
(15, 'Pará', 'PA', 1),
(16, 'Amapá', 'AP', 1),
(17, 'Tocantins', 'TO', 1);

