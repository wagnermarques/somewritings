use lojainfo
GO

select * from tb_clientes
select * from tb_hardware
GO

print N'Inserindo alguns clientes...'
insert into tb_clientes values ('jeferson','av eteczl 1', '11-99999-9999','email...')
GO

-- alguns hardwares pra serem vendidos
print N'Inserindo alguns hardwares...'
insert into tb_hardware values ('gabinete', 50, 10, 10, NULL)
insert into tb_hardware values ('processador', 50, 10, 10, NULL)
insert into tb_hardware values ('placa mae', 50, 10, 10, NULL)

print N'Mostrando os clientes inseridos'
select * from tb_clientes

print N'Mostrando os hardwares inseridos'
select * from tb_hardware
GO

print N':( Aqui temos um problema inserindo uma venda pro cliente 500 sendo que o cliente 500 nao existe'
insert into tb_vendas VALUES (500,'10/02/2018',80,10,70)
select * from tb_vendas;

