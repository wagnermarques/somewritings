use lojainfo
GO

create table  tb_clientes(
       id_cliente int PRIMARY KEY identity(1,1),
       nome nvarchar(50) not null,
       endereco nvarchar(100),
       fone nvarchar(15),
       email nvarchar(70),
)
GO

create table tb_hardware(
       id_hardware int PRIMARY KEY identity(1,1),
       descricao nvarchar(50) not null,
       preco_unit decimal,
       qtde_atual int,
       qtde_minima int,
       img image DEFAULT NULL
)
GO

create table tb_vendas(
       id_venda int primary key identity(1,1),
       id_cliente int not null,
       data date not null,
       vlr_total decimal (8,2) not null,
       desconto decimal(8,2),
       vlr_pago decimal(8,2)
)
GO

create table tb_vendas_itens(
       id_item int PRIMARY KEY identity(1,1),
       id_venda int not null,
       id_hardware int not null,
       qtde_item int not null,
       total_item decimal(8,2) not null
)
GO

-- pra ver se as tabelas foram criadas mesmo....
SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME LIKE '%'

