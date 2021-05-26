CREATE TABLE funcionarios(
  id  serial PRIMARY KEY,
  nome varchar(20)
);

CREATE TABLE setores(
 id serial primary key,
 nome varchar(20),
 id_func integer
);

ALTER TABLE setores
      ADD CONSTRAINT fkFuncionarioSetor
      FOREIGN KEY (id_func) REFERENCES funcionario(id);
