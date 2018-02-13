use lojainfo
GO

print N'Lembra que a gente tinha inserido alguns registros só pra mostrar que nossas tabelas haviam sido criadas?'
print N'Pois é. Agora vamos zerar esses registros'
print N'Entao, apagando registro anteriores...'
delete from tb_clientes;
delete from tb_hardware;
delete from tb_vendas;
delete from tb_vendas_itens;
GO

print N'=============================================='
print N'Agora sim, Inserindo alguns clientes'
insert into tb_clientes values ('Jeferson','Aguia Haia 123','11-99999-9999','jef@dom.com'),
 ('Carlos','Aguia Haia 456','11-99999-9999','carlos@dom.com'),
 ('Ralf','Aguia Haia 789','11-99999-9999','ralf@dom.com');
GO
print N'select * from tb_clientes'
select * from tb_clientes;



print N'=============================================='
print N'Agora inserindo alguns hardwares...'
insert into tb_hardware values
('gabinete',     60.50, 100, 10, NULL),
('processador', 300.50, 100, 10, NULL),
('placa mãe',   100.50, 100, 10, NULL),
('Dico Rígido',  80.90, 100, 10, NULL),
('Monitor',     300.20, 100, 10, NULL);
GO

print N'select * from tb_hardware'
select * from tb_hardware


print N'=============================================='
print N'Inserindo a Venda para os clientes Jeferson e Carlos'
print N'dessa vez vamos desprezar a terceira forma normal pra simplificar.'
insert into tb_vendas values (2,'2018-02-10', 8471, 100, 8371),
 (3,'2018-02-10',1086,0,1086);
GO

print N'select * from tb_vendas'
select * from tb_vendas



print N'=============================================='
print N'Inserindo itens da compra do Jerferson'
insert into tb_vendas_itens values (3,4,10, 600.50),
(3,5,10,3005),
(3,6,10,1050),
(3,7,10,809),
(3,8,10,3002);


print N'Inserindo itens da compra do Carlos'
insert into tb_vendas_itens values (4,4,1,60.50),
(4,5,1,300.50),
(4,6,1,105),
(4,7,1,80.9),
(4,8,1,3002);
GO

print N'select * from tb_vendas_itens'
select * from tb_vendas_itens


