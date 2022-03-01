create table if not exists pacientes(
       id serial PRIMARY KEY,
       nome varchar(40) not null,
       sexo varchar(20),
       obito boolean
       );

create table if not exists profissionais(
       id serial PRIMARY KEY,
       nome varchar(50)
       );

create table if not exists especialidades(
       id serial,
       nome varchar(50)
       );

create table if not exists consultas(
       id serial PRIMARY KEY,
       especialidade_id integer,
       profiss_id integer
       );

create table if not exists obitos(
       id serial PRIMARY KEY,
       obs text
       );


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



