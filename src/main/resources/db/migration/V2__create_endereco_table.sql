CREATE TABLE endereco (
	id SERIAL NOT NULL,
	bairro varchar(255) NULL,
	cep varchar(255) NULL,
	cidade varchar(255) NULL,
	complemento varchar(255) NULL,
	logradouro varchar(255) NULL,
	numero integer NOT NULL,
	observacao varchar(255) NULL,
	CONSTRAINT pk_endereco PRIMARY KEY (id)
);