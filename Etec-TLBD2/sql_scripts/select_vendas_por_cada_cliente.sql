print N'-*-*-*-*-*-select_vendas_por_cada_cliente.sql-*-*-*-*-*-'

use lojainfo;
GO

Print N'##########################################################'
Select 'Select * tb_clientes'
Select * tb_clientes
Go

Print N'##########################################################'
select  id_cliente, nome, idade, sexo, endereco, fone, email from tb_clientes
Go

Print N'##########################################################'
print N'Abaixo vemos as vendas mas o cliente e mostrado com id, queremos ver o nome deles'
Select "Select * tb_vendas"
select * from tb_vendas;
Go

print N'>>>>Essa query faz com que o nome do cliente apareca'
select 'select v.id_venda,c.nome,v.data,v.desconto from tb_vendas v join tb_clientes c on c.id_cliente = v.id_cliente;'
select v.id_venda,c.nome,v.data,v.desconto from tb_vendas v join tb_clientes c on c.id_cliente = v.id_cliente;
Go

print N' >>>>> É mas ainda nao apareceu todos os clientes e sim só os que compraram alguma coisa.'
print N' Pra que aparece todos os clientes, mesmo que que nao tenham vendas pra eles...'
print N' precisamos incluílos todos com left join'
select c.id_cliente as IdClienteDaTblCliente,
       v.id_cliente as IdClienteDaTblVendas,
       c.nome from
       tb_clientes c
       left join tb_vendas v
       on c.id_cliente = v.id_cliente;
Go

Print N'>>>>>Se tem left join, tem right join, certo?'
Print N' Vamos colar do lado direito o id da venda, assim a gente sabe qual foi a venda exatamente do cliente'
Print N' Esse he um passo a caminho de se obter posteriormente qual cliente comprou qual produto'
Print N' Pensa comigo, nao da pra saber quais itens foram comprados pelo cliente sem antes identificar qual foi exatamente a venda '
print N' que foi feita pra ele'
print N' o que identifica a venda he o id dela, entao vamos fazer isso'

select c.id_cliente as IdClienteDaTblCliente,
       v.id_cliente as IdClienteDaTblVendas,
       c.nome as nomeCliente,
       v.id_venda as IdVendaDaTblVendas
       from
       tb_clientes c
       left join tb_vendas v
              on c.id_cliente = v.id_cliente
Go


print N' >>>>>> O resultado acima mostra que nem todos os registros de clientes tem uma venda associada'
print N' quando o registro nao tem uma venda associada o IdVendaDaTblVendas é NULL'
print N' quando é NULL, esse registro nao tera itens, caso contrario tera'
print N' vamos agora fazer o join com os itens vendidos em cada venda'
print N' que tal dar-mos uma olhada na tabela id_vendas_itens?'
print N'[QUERY ITENS COMPRAS1]  Agora vai a nossa query pra mostrar do lado direito os itens de cada compra'
select c.id_cliente as IdClienteDaTblCliente,
       v.id_cliente as IdClienteDaTblVendas,
       c.nome as nomeCliente,
       v.id_venda as IdVendaDaTblVendas,
       i.id_item as idItem,
       i.id_hardware as idHardware,
       i.qtde_item as qtde
       from
       tb_clientes c
       left join tb_vendas v
              on c.id_cliente = v.id_cliente
            join tb_vendas_itens as i
              on v.id_venda = i.id_venda
Go

print N'>>>> Bom, agora o obvio he querer saber o nome de cada item e nao o id dele'
print N'Isso vai facilitar pro leitor saber qual he o produto pelo nome'
select c.id_cliente as IdClienteDaTblCliente,
       v.id_cliente as IdClienteDaTblVendas,
       c.nome as nomeCliente,
       v.id_venda as IdVendaDaTblVendas,
       i.id_item as idItem,
       i.id_hardware as idHardware,
       hardw.descricao as DescricaoDoProduto
       from
       tb_clientes c
       left join tb_vendas v
              on c.id_cliente = v.id_cliente
       left join tb_vendas_itens as i
              on v.id_venda = i.id_venda
       left join tb_hardware as hardw
              on i.id_hardware = hardw.id_hardware


