use lojainfo
GO

print N'Vamos inserir denovo aquela venda pra um cliente que nao existe'
insert into tb_vendas VALUES (500,'10/02/2018',80,10,70)
select * from tb_vendas;
