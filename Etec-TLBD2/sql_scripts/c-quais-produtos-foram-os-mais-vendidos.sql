use lojainfo


print N'.'
print N'.'
print N'.'
print N'####### CONSULTA: select * from tb_vendas_itens'
print N'Acho que podemos comecar perguntando quais foram os produtos vendidos...'
print N' eis abaixo os produtos vendidos'
print N'-----------------------------------------------'
select * from tb_vendas_itens

print N'.'
print N'.'
print N'.'
print N'####### CONSULTA: select id_hardware, sum(qtde_item) as qtdeVendida from tb_vendas_itens as i group by id_hardware order by qtdeVendida'
print N'vc viu que tem a coluna qtde_item que contem a qtde q foi vendida do item'
print N'essa he uma informacao que interessa, o problema he que o mesmo item aparece muitas vezes'
print N'entao vamos agrupar os itens repetidos somando a qtede_itens'
print N'he isso que vc ve nessa query abaixo'
print N'-----------------------------------------------'
select
        i.id_hardware,
        sum(i.qtde_item) as qtdeVendida
from
        tb_vendas_itens as i
        group by id_hardware
        order by qtdeVendida

print N'.'
print N'.'
print N'.'
print N'####### CONSULTA: select * from tb_vendas_itens'
print N'Bom, agora queremos o nome e nao o id de cada item'
print N'Vamos fazer um join com a tabela de cadastro de prodtos'
print N'Primeiro vamos pegar uma versao do join sem o group by pra facilitar a compreensao'
print N'Depois a gente poe de novo o group by
print N'-----------------------------------------------'
select
        i.id_hardware,
        h.descricao,
        sum(i.qtde_item) as qtdeVendida
from tb_vendas_itens as i
join tb_hardware as h
      on h.id_hardware = i.id_hardware
      group by h.descricao,i.id_hardware
      order by qtdeVendida desc

