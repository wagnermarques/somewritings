use master
GO

drop database lojainfo;
GO

create database lojainfo;
GO

use lojainfo;

create table tb_clientes(
       id_cliente int PRIMARY KEY IDENTITY(1,1),
       nome nvarchar(50) not null,
       endereco nvarchar(100),
       idade int NOT NULL,
       sexo char(1) NOT NULL,
       fone nvarchar(15),
       email nvarchar(70),
)
GO

create table tb_hardware(
       id_hardware int PRIMARY KEY IDENTITY(1,1),
       descricao nvarchar(50) not null,
       preco_unit decimal NOT NULL,
       qtde_atual int NOT NULL, --0 caso nao tenha no estoque
       qtde_minima int,
       img image DEFAULT NULL
)
GO

create table tb_vendas(
       id_venda int primary key IDENTITY(1,1),
       id_cliente int not null,
       dataDaVda date not null,
       desconto decimal(3,2)
)
GO

create table tb_vendas_itens(
       id_item int PRIMARY KEY identity(1,1),
       id_venda int not null,
       id_hardware int not null,
       qtde_item int not null,
       pco_vda decimal(8,2) not null
)
GO

print N'->->-> insert into tb_clientes values...'
insert into tb_clientes values
        ('Ada Lovelace','Ada Address'           ,20,'f','11-99999-9999','hug@dom.com'),
        ('Linuz Torvalds','Linus Address'       ,50,'m','11-99999-9999','zez@dom.com'),
        ('Richard Stallman','Stallman Address'  ,60,'m','11-99999-9999','lui@dom.com'),
        ('Denis Ritchie','Denis Ritchie Address',30,'m','11-99999-9999','mon@dom.com'), 
        ('Ken Thompson','Ken Thompson Address'  ,40,'m','11-99999-9999','lulu@dom.com');
GO

       

print N'->->-> insert into tb_hardware...'
insert into tb_hardware (descricao, preco_unit,qtde_atual,qtde_minima,img) values
('gabinete',      60.50, 100, 10, NULL),
('processador',  300.50, 100, 10, NULL),
('placa mãe',    100.50, 100, 10, NULL),
('Disco Rígido',  80.90, 100, 10, NULL),
('Monitor',      300.20, 100, 10, NULL),
('Plca Video',   100.20, 100, 10, NULL);
GO

print N'->->-> insert into tb_vendas...'
insert into tb_vendas (id_cliente,dataDaVda,desconto) values
       (1,'2020-03-01', NULL),
       (1,'2020-03-02', NULL),
       (1,'2020-03-03', 0.05),
       (1,'2020-03-04', 0.2),
       (2,'2018-03-01', 0.0),
       (2,'2018-03-02', 0.0),
       (3,'2018-03-01', 0.0),
       (4,'2018-03-01', NULL);
GO

print N'->->-> insert into tb_vendas_itens...'
insert into tb_vendas_itens
       (id_venda,id_hardware,qtde_item,pco_vda)
       values
       (1,1,1,60.50),
       (1,3,1,100.50),
       (1,2,1,300.50),
       (2,4,1,80.90),
       (3,5,1,300.20),
       (4,1,2,300.20),
       (4,5,2,300.20),
       (4,2,2,300.50),
       (4,3,2,100.50),
       (4,4,2,80.90),
       (5,3,1,100.50),       
       (5,2,1,300.50),
       (6,1,1,60.50),
       (6,4,1,80.90),
       (6,5,1,300.20),
       (7,2,10,100),
       (7,3,10,180),
       (7,1,10,20),
       (7,4,10,100),
       (7,5,10,100);
Go











