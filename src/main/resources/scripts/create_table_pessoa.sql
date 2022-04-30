CREATE TABLE IF NOT EXISTS pessoa (

  id SERIAL NOT NULL,
  nome VARCHAR(100) NOT NULL,
  sobrenome VARCHAR(250),
  email VARCHAR(100) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  ativo BOOLEAN NOT NULL,

  PRIMARY KEY (id)
);

INSERT INTO pessoa(nome, sobrenome, email, cpf, ativo)
VALUES('RUBENS', 'BARRICHELLO', 'rubinho@f1.com.br', '92532363967', 'true');

COMMIT;