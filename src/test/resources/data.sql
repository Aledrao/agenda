SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO pessoa (id, nome, login, email) VALUES (1, 'Alex Souza', 'alex', 'alex@teste.com.br');
INSERT INTO pessoa (id, nome, login, email) VALUES (2, 'Luiza Labs', 'luiza', 'luiza@teste.com.br');

INSERT INTO agenda(id, envio, ultima_atualizacao, mensagem, destinatario, remetente)
	VALUES (20, current_timestamp, null, 'Teste unitário em banco em memória', 1, 2);

INSERT INTO agenda(id, envio, ultima_atualizacao, mensagem, destinatario, remetente)
	VALUES (21, current_timestamp, null, 'Apoio para teste unitário de banco', 2, 1);
