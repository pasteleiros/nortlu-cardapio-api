CREATE TABLE itens_pedidos (
	id_produto integer NOT NULL,
	id_pedido integer NOT NULL,
	CONSTRAINT fk_produto FOREIGN KEY (id_produto) REFERENCES produto(id),
	CONSTRAINT fk_pedido FOREIGN KEY (id_pedido) REFERENCES pedido(id)
);