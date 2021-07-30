CREATE TABLE pedido (
	id SERIAL NOT NULL,
	id_forma_pagamento integer NOT NULL,
	id_status integer NOT NULL,
	valor_total numeric(19,2) NULL,
	id_usuario integer NULL,
	CONSTRAINT pk_pedido PRIMARY KEY (id),
	CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);