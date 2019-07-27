print N'-*-*-*-*-*-inserts.sql-*-*-*-*-*-'
use lojainfo
GO

print N'>>>Lembra que a gente tinha inserido alguns registros só pra mostrar que nossas tabelas haviam sido criadas?'
print N'>>>Pois é. Agora vamos zerar esses registros'
print N'>>Entao, apagando registro anteriores...'
delete from tb_clientes;
delete from tb_hardware;
delete from tb_vendas;
delete from tb_vendas_itens;
GO

print N'=============================================='
print N'>>> Agora sim, Inserindo alguns clientes'
insert into tb_clientes values
        ('Huguinho','Aguia Haia 123' ,20,'m','11-99999-9999','hug@dom.com'),
        ('Zezinho','Aguia Haia 456'  ,50,'m','11-99999-9999','zez@dom.com'),
        ('Luizinho','Aguia Haia 789' ,60,'m','11-99999-9999','lui@dom.com'),
        ('Monica','Aguia Haia 789'   ,30,'f','11-99999-9999','mon@dom.com'), 
        ('Luluzinha','Aguia Haia 789',40,'f','11-99999-9999','lulu@dom.com');
GO

print N'>>> select * from tb_clientes'
select * from tb_clientes;



print N'=============================================='
print N'>>> Inserindo alguns hardwares...'
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
print N'Inserindo a Venda para os clientes Zezinho e Luizinho'
insert into tb_vendas values
       (2,'2018-02-10', NULL),
       (3,'2018-02-20', 0.1);
GO

print N'select * from tb_vendas'
select * from tb_vendas
Go


print N'=============================================='
print N'Inserindo itens da compra do Zezinho'

insert into tb_vendas_itens
       (id_venda,id_hardware,qtde_item,pco_vda)
       values
       (3,4,10, 600.50),
       (3,5,10,3005),
       (3,6,10,1050),
       (3,7,10,809),
       (3,8,10,3002);
Go

print N'=============================================='
print N'Inserindo itens da compra do Luizinho'
insert into tb_vendas_itens
       (id_venda,id_hardware,qtde_item,pco_vda)
       values
        (4,4,1,60),
        (4,5,1,300),
        (4,6,1,101),
        (4,7,1,80),
        (4,8,1,300);
GO

print N'select * from tb_vendas_itens'
select * from tb_vendas_itens


