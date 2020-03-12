use lojainfo

print N'.'
print N'.'
print N'.'
print N'####### CONSULTA select c.id_cliente, c.nome from tb_clientes as c'
print N'esses sao os clientes que cadastrados'
print N'-----------------------------------------------'
select c.id_cliente, c.nome from tb_clientes as c

print N'.'
print N'.'
print N'.'
print N'####### CONSULTA select v.id_cliente from tb_vendas as v'
print N'essas sao as vendas realizadas para cada cliente'
print N'-----------------------------------------------'
select v.id_cliente from tb_vendas as v

print N'.'
print N'.'
print N'.'
print N'####### CONSULTA clientes que realizaram compra'
print N'esses sao os clientes que realizaram compras'
print N'perceba que o cliente 5, Ken Thompson nao esta listado'
print N'-----------------------------------------------'
select c.id_cliente as id_clienteFromTbCliente,
       v.id_cliente as id_clienteFromTbVendas,
       c.nome from tb_clientes as c join tb_vendas as v on c.id_cliente = v.id_cliente
