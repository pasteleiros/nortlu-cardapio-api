CREATE TABLE usuario_endereco (
	id_usuario int8 NOT NULL,
	id_endereco int8 NOT NULL,
	CONSTRAINT fk_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id),
	CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);