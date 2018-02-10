create table tb_clientes(
id_cliente int primary key identity(1,1),
nome nvarchar(50) not null,
endereco nvarchar(100),
fone nvarchar(15),
email nvarchar(70
)

create table tb_hardoware(
id_hardware int primary key identity(1,1),
desc nvarchar(50) not null,
preco_unit decimal,
qtde_atual int,
qtde_minima int,
img image
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
id_item int not null,
id_venda int not null,
id_hardware int not null,
qtde_item int not null,
total_item decimal(8,2) not null
)

