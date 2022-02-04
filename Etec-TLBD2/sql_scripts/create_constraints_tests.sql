print N'-*-*-*-*-*-create_constraints_tests.sql-*-*-*-*-*-'

use lojainfo
GO

print N'>>>Vamos inserir denovo aquela venda pra um cliente que nao existe'
insert into tb_vendas
       (id_cliente,data,desconto)
       VALUES
       (500,'10/02/2018',0.1)
select * from tb_vendas;
