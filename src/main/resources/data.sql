INSERT INTO ALUNO(nome_aluno,serie,mensagem) VALUES ('Renan','7º','olá');
INSERT INTO ALUNO(nome_aluno,serie,mensagem) VALUES ('ARTHUR','8º','olá2');


INSERT INTO ESCOLA(nome_escola) VALUES('Alquimia');
INSERT INTO ESCOLA(nome_escola) VALUES('CNEC');

UPDATE ALUNO SET escola_id = 1 WHERE ID = 1;
UPDATE ALUNO SET escola_id = 1 WHERE ID = 2;
