print N'-*-*-*-*-*-select_agregacoes.sql-*-*-*-*-*-'
use lojainfo;
GO
print N'@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@'
select 'Select * from tb_vendas'
select * from tb_vendas

select 'Select * from tb_vendas_itens'
select * from tb_vendas_itens
Go

print N'>>>Vamos ver qual foi o valor da venda(compra) de cada cliente?'
select v.id_venda as IdVendaDaTblVendas,
       sum(i.pco_vda) as VlrPagoPelosItens
       from
       tb_clientes c
       join tb_vendas v
              on c.id_cliente = v.id_cliente
       join tb_vendas_itens as i
              on v.id_venda = i.id_venda
              group by v.id_venda

Go

print N'>>>Vamos ver qual foi o valor da venda(compra) de cada cliente?'
select v.id_venda as IdVendaDaTblVendas,
       sum(i.pco_vda) as VlrPagoPelosItens
       from
       tb_clientes c
       join tb_vendas v
              on c.id_cliente = v.id_cliente
       join tb_vendas_itens as i
              on v.id_venda = i.id_venda
              group by v.id_venda

Go

print N'>>>Agora vamos o nome dos clientes pra quem foi feita essas vendas'
select c.nome as Cliente,          
       v.id_venda as IdVendaDaTblVendas,
       sum(i.pco_vda) as VlrPagoPelosItens
       from
       tb_clientes c
       join tb_vendas v
              on c.id_cliente = v.id_cliente
       join tb_vendas_itens as i
              on v.id_venda = i.id_venda
              group by v.id_venda,c.nome

Go


