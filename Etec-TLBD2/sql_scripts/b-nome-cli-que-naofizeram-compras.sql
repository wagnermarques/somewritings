use lojainfo


print N'.'
print N'.'
print N'.'
print N'####### CONSULTA select c.id_cliente, c.nome from tb_clientes as c'
print N'Apenas o cliente 5 Ken Thompson nao comprou nada'
print N'-----------------------------------------------'
select c.nome
  from tb_clientes as c
  left join tb_vendas as v on c.id_cliente = v.id_cliente where v.id_cliente is null
