CREATE TABLE usuario (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	cpf varchar(255) NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	telefone varchar(255) NULL,
	CONSTRAINT pk_usuario PRIMARY KEY (id)
);