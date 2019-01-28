use lojainfo;
GO

print N'[QUERY AGREG1] '

print N'[QUERY ITENS COMPRAS1]  Agora vai a nossa query pra mostrar do lado direito os itens de cada compra'
select v.id_venda as IdVendaDaTblVendas,
       c.nome as nomeCliente,
       sum(i.total_item) as VlrDaVenda
       from
       tb_clientes c
       join tb_vendas v
              on c.id_cliente = v.id_cliente
       join tb_vendas_itens as i
              on v.id_venda = i.id_venda
       group by v.id_venda, c.nome

