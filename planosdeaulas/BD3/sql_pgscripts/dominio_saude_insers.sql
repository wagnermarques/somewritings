insert into pacientes (nome,sexo) values
('Ada Lovelace','f'),
('Donald Knuth','m'),
('Grace Hopper','f'),
('Dennis Ritchie','m');

insert into especialidades (nome) values
('urologista'),
('ginecologista'),
('clinica geral');

insert into profissionais (nome) values
('DrFeelGoodUro'),
('DrJekyllGineco'),
('DrRay');

-- Paciente Ada NAO NAO NAO deveria ser atendida pelo urologista
insert into consultas (especialidade_id,pac_id,profiss_id) values (1,1,1);

