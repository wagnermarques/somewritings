create table if not exists pacientes(
       id serial PRIMARY KEY,
       nome varchar(40) not null,
       sexo varchar(1),
       obito boolean DEFAULT false);

create table if not exists profissionais(
       id serial PRIMARY KEY,
       nome varchar(50),
       insertedAt  timestamp default now ( ));

create table if not exists especialidades(
       id serial PRIMARY KEY,
       nome varchar(50),
       insertedAt  timestamp default now ( ));

create table if not exists consultas(
       id serial PRIMARY KEY,       
       especialidade_id integer, 
       pac_id integer,
       profiss_id integer,
       insertedAt  timestamp default now ( ));

create table if not exists obitos(
       id serial PRIMARY KEY,
       obs text,
       insertedAt  timestamp default now ( ));


ALTER TABLE consultas
ADD CONSTRAINT FkEspecialidadeDaConsulta FOREIGN KEY
    (especialidade_id)
REFERENCES
    especialidades(id);

ALTER TABLE consultas
ADD CONSTRAINT FkProfissionalDaConsulta FOREIGN KEY   
    (profiss_id)
REFERENCES
    profissionais(id);



