use master;

drop database if exists lojainfo
go

CREATE DATABASE lojainfo;
Go

PRINT '#######################################'
PRINT N'####    MOSTRANDO OS BANCOS       ####'
PRINT '#######################################'

Exec sp_databases;
Go

PRINT '#######################################'
PRINT N'####   CRIANDO AS TABELAS         ####'
PRINT '#######################################'

use lojainfo;
create table  tb_clientes(
       id_cliente int PRIMARY KEY identity(1,1),
       nome nvarchar(50) not null,
       endereco nvarchar(100),
       fone nvarchar(15),
       email nvarchar(70),
)

create table  tb_clientes_auditoria(
       id_auditoria int PRIMARY KEY identity(1,1),
       id_cliente int,
       nome nvarchar(50) not null,
       endereco nvarchar(100),
       fone nvarchar(15),
       email nvarchar(70),
       acao_de_auditoria nvarchar(255),
       data_de_auditoria datetime
)

create table tb_hardware(
       id_hardware int PRIMARY KEY identity(1,1),
       descricao nvarchar(50) not null,
       preco_unit decimal,
       qtde_atual int,
       qtde_minima int,
       img image DEFAULT NULL
)

create table tb_vendas(
       id_venda int primary key identity(1,1),
       id_cliente int not null,
       data date not null,
       vlr_total decimal (8,2) not null,
       desconto decimal(8,2),
       vlr_pago decimal(8,2)
)

create table tb_vendas_itens(
       id_item int PRIMARY KEY identity(1,1),
       id_venda int not null,
       id_hardware int not null,
       qtde_item int not null,
       total_item decimal(8,2) not null
)
Go

PRINT '########################################################'
PRINT N'####   mostrando que nao tem dados nas tabelas     ####'
PRINT '########################################################'
select * from tb_clientes
select * from tb_hardware
GO


PRINT '########################################################'
PRINT N'####   inserindo registros     ####'
PRINT '########################################################'
print N'Inserindo alguns clientes...'
insert into tb_clientes values ('jeferson','av eteczl 1', '11-99999-9999','email...')

-- alguns hardwares pra serem vendidos
print N'#####Inserindo alguns hardwares...'
insert into tb_hardware values ('gabinete', 50, 10, 10, NULL)
insert into tb_hardware values ('processador', 50, 10, 10, NULL)
insert into tb_hardware values ('placa mae', 50, 10, 10, NULL)

print N'#####Mostrando os clientes inseridos'
select * from tb_clientes

print N'#####Mostrando os hardwares inseridos'
select * from tb_hardware
GO

print N'#####:( Aqui temos um problema inserindo uma venda pro cliente 500 sendo que o cliente 500 nao existe'
insert into tb_vendas VALUES (500,'10/02/2018',80,10,70)
select * from tb_vendas;
Go


PRINT '#######################################'
PRINT '#### MOSTRANDO AS TABELAS DO BANCO ####'
PRINT '#######################################'

Exec sp_tables 'lojainfo'
Go

/*
https://technet.microsoft.com/pt-br/library/ms187953(v=sql.105).aspx
*/

PRINT '#######################################'
PRINT '####CRIANDO NOSSA PRIMEIRA TRIGGER ####'
PRINT '#######################################'
Go

    CREATE TRIGGER trgAfterInsertCliente ON tb_clientes 
    FOR INSERT
    AS
    declare @cliid int;
    declare @clinome varchar(100);
    declare @cliend varchar(100);
    declare @clifone varchar(100);
    declare @cliemail varchar(100);

    declare @audit_action varchar(100);
    
    select @cliid=i.id_cliente from inserted i;	
    select @clinome=i.nome from inserted i;	
    select @cliend=i.endereco from inserted i;	
    select @clifone=i.fone from inserted i
    select @cliemail=i.email from inserted i

    set @audit_action='Registro Inserido -- [Triger do tipo Afet Insert na tb_clientes].';

    insert into tb_clientes_auditoria (id_cliente,nome,endereco,fone,email,acao_de_auditoria,data_de_auditoria) 
    values(@cliid,@clinome,@cliend,@clifone,@cliemail,@audit_action,getdate());

    
    PRINT 'FIM DA EXECUCAO DA TRIGUER after inser cliente.'
    GO


PRINT '###################################################'
PRINT '#### inserindo um reg pra ver a trigger rodar  ####'
PRINT '###################################################'

insert into tb_clientes values ('jefTrig','av 1Trig', '11-9999Trig','emailTrig...')

PRINT '###################################################'
PRINT '#### select na nossa tbl de auditoria          ####'
PRINT '###################################################'
select * from tb_clientes_auditoria

