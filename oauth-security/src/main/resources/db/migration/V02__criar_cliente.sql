CREATE TABLE cliente (
  codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  ativo BOOLEAN NOT NULL,
  logradouro VARCHAR(100),
  numero VARCHAR(10),
  complemento VARCHAR(50),
  bairro VARCHAR(80),
  cep VARCHAR(10),
  cidade VARCHAR(100),
  estado VARCHAR(2),
  criado DATE NOT NULL,
  editado DATE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;