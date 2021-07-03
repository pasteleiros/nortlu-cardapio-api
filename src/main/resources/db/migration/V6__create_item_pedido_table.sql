CREATE TABLE item_pedido (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	descricao varchar(255) NULL,
	foto varchar(255) NULL,
	nome varchar(255) NULL,
	valor numeric(19,2) NULL,
	id_categoria int8 NULL,
	id_pedido int8 NOT NULL,
	CONSTRAINT pk_item_pedido PRIMARY KEY (id),
	CONSTRAINT fk_pedido FOREIGN KEY (id_pedido) REFERENCES pedido(id),
	CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id)
);