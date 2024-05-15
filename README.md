
# Projeto Agenda

Projeto de teste para vaga no Luiza Labs, e para tal este recurso foi criado utilizando o padrão de arquitetura-hexagonal, onde os recurso de tomadas de decisão ficão de maneira "centralizada", e os recurso de conexões e libs, como banco de dados e serviços externos são configurados de maneira "independente" através de "portas".




## Donwload do projeto

Através do git bash, é possível fazer o download do projeto através do comando, no diretório onde se deseja baixar o projeto.
```bash
  git clone https://github.com/Aledrao/agenda.git
```

## Banco de dados
Para a persistência dos recurso, foi criado um database utilizando o banco de dados postgresql, e para a criação de seus recursos é necessário executar os comandos no query tools no pg admin, no console do sistema operacional, ou gerando arquivos com extensão *.sql, e executar através das ferramentas sitadas anteriormente.
Primeiro digite o comando para gerar o database.
Em seguida executar os comandos de criação de tabelas e inserção de dados.

OBSERVAÇÃO: Se sua opção for por digitar os comandos um a um no console, ignore as opções BEGIN e COMMIT. Apenas os utilize, para executar através de arquivo ou do Query tool no pgadmin.

- Comando para criar o database
```bash
  CREATE DATABASE agenda
```
- Comando para criar as tabelas e inserir dados ao banco.
```bash
  BEGIN;

CREATE SEQUENCE pessoa_id_seq;

CREATE TABLE IF NOT EXISTS pessoa (
	id INTEGER NOT NULL DEFAULT NEXTVAL('pessoa_id_seq') UNIQUE,
	nome VARCHAR(255) NOT NULL UNIQUE,
	login VARCHAR(25) NOT NULL UNIQUE,
	email VARCHAR(100) NOT NULL UNIQUE
);

ALTER SEQUENCE pessoa_id_seq OWNED BY pessoa.id;

CREATE SEQUENCE agenda_id_seq;

CREATE TABLE IF NOT EXISTS agenda (
	id INTEGER NOT NULL DEFAULT NEXTVAL('agenda_id_seq'),
	envio date,
	ultima_atualizacao date,
	mensagem VARCHAR(255) NOT NULL,
	destinatario INTEGER NOT NULL,
	remetente INTEGER NOT NULL,
	FOREIGN KEY (destinatario) REFERENCES pessoa(id),
	FOREIGN KEY (remetente) REFERENCES pessoa(id)
);

ALTER SEQUENCE agenda_id_seq OWNED BY agenda.id;

INSERT INTO pessoa (nome, login, email) VALUES ('Alex Souza', 'alex', 'alex@teste.com.br');
INSERT INTO pessoa (nome, login, email) VALUES ('Luiza Labs', 'luiza', 'luiza@teste.com.br');

COMMIT;
```
## Build do projeto

Para buildar o projeto, digite o comando abaixo no console do sistema operacional, ou selecione a opção na sua ide favorita (essa opção depende de cada ferramenta).

```bash
  mvn clean install -U
```
## Teste
Para testar o projeto e seus endpoints, foi incluido a raiz do projeto o arquivo **teste-luiza-labs.postman_collection.json**, para ser importado no postman e acessar os endpoints com o projeto em execução.
## Autor

- [Aledrao](https://github.com/Aledrao)

