use lojainfo
GO

-- pro caso de vc quizer rmover uma fk...
-- alter table tb_vendas DROP CONSTRAINT fk_vda_cli
-- alter table tb_vendas_itens DROP CONSTRAINT fk_itens_vda

print N'Temos que remover aquela venda ERRADA'
print N'pra poder inserir a nossa FK'
delete from tb_vendas where id_cliente = 500;

print N'Agora sim vamos criar os relacionamentos'
alter table tb_vendas
      ADD CONSTRAINT fk_vda_cli
      FOREIGN KEY (id_cliente) REFERENCES tb_clientes(id_cliente)

alter table tb_vendas_itens
      ADD CONSTRAINT fk_itens_vda
      FOREIGN KEY (id_venda) REFERENCES tb_vendas(id_venda)

-- listando as chaves estrangeiras em cada tabela
print N'Vamos ver as definicoes das tabelas tb_venas e tb_vendas_itens'
EXEC sp_help  'tb_vendas'
EXEC sp_help  'tb_vendas_itens'

