use lojainfo;
GO
Select "Selec * tb_vendas"
select * from tb_vendas;
print N' Ei mas aqui nao tem todos os clientes, e o ralf?'
print N' Vamos ter que usar o tb_clientes porque é nela que tem todos os clientes'
select * from tb_clientes c join tb_vendas v on c.id_cliente = v.id_cliente;
print N' É mas ainda nao apareceu todos os clientes e sim só os que compraram alguma coisa.'
print N' Pra que aparece todos os clientes, mesmo que que nao tenham vendas pra eles...'
print N' precimas incluílos todos com left join'
select c.id_cliente as IdClienteDaTblCliente,
       v.id_cliente as IdClienteDaTblVendas,
       c.nome from
       tb_clientes c
       left join tb_vendas v
       on c.id_cliente = v.id_cliente;

Select 'Se tem left join, tem right join, certo?'
Print N' Vamos colar do lado direito TODOS OS ITENS DA TABELA ITENS DE PRODUTO'
Print N' Òbvio que os itens de produtos vendidos se relacionam com o id da venda certo?'
Print N' Vamos fazer um join primeiro e depois um right join pra tabela itens de venda'
print N' Ja que os itens estao relacionados com idVenda, vamos incluir o campo id venda na projecao da nossa query'

select c.id_cliente as IdClienteDaTblCliente,
       v.id_cliente as IdClienteDaTblVendas,
       c.nome as nomeCliente,
       v.id_venda as IdVendaDaTblVendas
       from
       tb_clientes c
       left join tb_vendas v
              on c.id_cliente = v.id_cliente

print N' O resultado acima mostra que nem todos os registros de clientes tem uma venda associada'
print N' quando o registro nao tem uma venda associada o IdVendaDaTblVendas é NULL'
print N' quando é NULL, esse registro nao tera itens, caso contrario tera'
print N' vamos agora fazer o join com os itens vendidos em cada venda'
print N' que tal dar-mos uma olhada na tabela id_vendas_itens?'
select * from tb_vendas_itens;

print N'[QUERY ITENS COMPRAS1]  Agora vai a nossa query pra mostrar do lado direito os itens de cada compra'
select c.id_cliente as IdClienteDaTblCliente,
       v.id_cliente as IdClienteDaTblVendas,
       c.nome as nomeCliente,
       v.id_venda as IdVendaDaTblVendas,
       i.id_item as idItem,
       i.id_hardware as idHardware,
       i.qtde_item as qtde,
       i.total_item as vlrTotItem
       from
       tb_clientes c
       left join tb_vendas v
              on c.id_cliente = v.id_cliente
       join tb_vendas_itens as i
              on v.id_venda = i.id_venda


print N'[QUERY ITENS COMPRAS2]  Agora vai a nossa query pra mostrar do lado direito os itens de cada compra'
select c.id_cliente as IdClienteDaTblCliente,
       v.id_cliente as IdClienteDaTblVendas,
       c.nome as nomeCliente,
       v.id_venda as IdVendaDaTblVendas,
       i.id_item as idItem,
       i.id_hardware as idHardware
       from
       tb_clientes c
       left join tb_vendas v
              on c.id_cliente = v.id_cliente
       left join tb_vendas_itens as i
              on v.id_venda = i.id_venda


