# Introdução ao SQL com MySQL: Manipule e consulte dados

## Aula 01 - Instalando e configurando o MYSQL

### Atividade 02 - História do SQL:

- DDL (*Data Definition Language*): manipulação da estrutura do banco de dados. Criar, apagar e alterar o banco, tabelas ou índices.
- DML (*Data Manipulation Language*): gerencia os dados. Incluir, alterar, excluir e consultar informações dentro das tabelas.
- DCL (*Data Control Language*): administra o banco de dados. Acessos, usuários, permissões, rotina de crescimento, armazenamento, administração de processos, etc.

### Atividade 04 - Instalando o MySQL Server:

- MySQL e WorkBench: https://dev.mysql.com/downloads/installer/


## Aula 02 - Manipulando o banco de dados

### Atividade 01 - Definições:

- Chave primária: campos que suas combinações não podem se repetir dentro das linhas/registros da tabela.
- Chave estrangeira: ligação entre duas tabelas.
- Índice: instrumento que facilita encontrar elementos da tabela de maneira mais rápida.
- Esquema: grupo de tabelas.
- View: agrupamento de tabelas.
- Procedures e Funções: lógica estruturada utilizando comandos SQL.
- Trigger: aviso/alerta programado para ser disparado quando algum comando específico for executado.

### Atividade 05 - Conhecendo o Workbench:

- `SELECT`: comando SQL para realizar buscas em tabelas.
- **Ex.:** `SELECT * FROM CITY;` seleciona todos os campos da tabela `CITY`.

#### Workbench:

- É necessário dar um duplo clique em um *SCHEMA* antes de executar qualquer comando, para que o comando seja executado no *SCHEMA* selecionado.

### Atividade 06 - Criando um banco de dados:

- `CREATE {DATABASE | SCHEMA} [IF NOT EXISTS] db_name`: cria um novo banco de dados/esquema `db_name` se já não existir algum com esse nome.
- **Ex.:** `CREATE DATABASE SUCOS;` cria um banco de dados com o nome `SUCOS`.
- **Obs.:** no MySQL, *DATABASE* e *SCHEMA* são sinônimos.
- No Windows, o arquivo `my.ini` (arquivo de inicialização do MySQL) é criado no diretório `C:\ProgramData\MySQL\MySQL Server 8.0`. Esse arquivo contém diversas variáveis de ambiente:
- `datadir`: caminho onde os bancos são criados.

### Atividade 08 - Criando um banco de dados usando assistente:

- Clique com o botão direito na janela *SCHEMAS* e selecione *Create Schema...*. Digite o nome do banco e selecione o *Charset* e *Collation*. Ao clicar em *Apply*, o Workbench irá abrir uma tela e mostrar o comando utilizado para criar esse banco/esquema.

### Atividade 10 - Apagando banco de dados:

- `DROP {DATABASE | SCHEMA} [IF EXISTS] db_name`: exclui o banco de dados/esquema `db_name`, se ele existir.
