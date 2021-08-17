CREATE TABLE produto (
	id SERIAL NOT NULL,
	descricao varchar(255) NULL,
	foto varchar(255) NULL,
	nome varchar(255) NULL,
	valor numeric(19,2) NULL,
	id_categoria integer NULL,
	CONSTRAINT pk_produto PRIMARY KEY (id),
	CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);