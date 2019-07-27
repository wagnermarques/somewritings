print N'-*-*-*-*-*-create_tables_tests.sql-*-*-*-*-*-'

use lojainfo
GO

print N'*----*-----*----*-----*'

print N'>>> select * from tb_clientes'
select * from tb_clientes

print N'>>>select * from tb_hardware'
select * from tb_hardware
GO

print N'>>>Inserindo alguns clientes...'
insert into tb_clientes values
       ('NomeDeTeste','enderecoTeste',20,'m','11-99999-9999','email...')
GO

print N'>>>Inserindo alguns hardwares pra serem vendidos'
insert into tb_hardware values ('gabinete', 50, 10, 10, NULL)
insert into tb_hardware values ('processador', 50, 10, 10, NULL)
insert into tb_hardware values ('placa mae', 50, 10, 10, NULL)

print N'>>>Mostrando os clientes inseridos'
select * from tb_clientes

print N'>>>Mostrando os hardwares inseridos'
select * from tb_hardware
GO

print N'>>>  :(  Aqui temos um problema!'
print N'>>>  inserindo uma venda pro cliente 500 sendo que o cliente 500 nao existe'
insert into tb_vendas
       (id_cliente,data,desconto)
       VALUES (500,'10/02/2018',0.1)
       
select * from tb_vendas;

