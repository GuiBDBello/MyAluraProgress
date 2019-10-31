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

### Atividade 12 - MYSQL por linha de comando:

- No Terminal, defina a variável de ambiente do MySQL ou acesse seu diretório de instalação e execute os comandos:
- `mysql -h localhost -u root -p`: acessa o MySQL no servidor `localhost`, usuário `root` e com uma senha (digitada a seguir).
- `USE world`: comando equivalente ao duplo clique em um esquema para selecioná-lo antes de rodar um comando.
- `EXIT`: sai do MySQL.


## Aula 03 - Gerenciando as tabelas do banco de dados

### Atividade 01 - Tipos de dados:

- Propriedade *UNSIGNED*: não permite sinal no número. Por isso o conjunto de valores válidos aumentam.
- Erros de *OUT OF RANGE*: vão ocorrer quando os valores estourarem os limites.

#### Tipos numéricos:

- Inteiros: `TINYINT`, `SMALLINT`, `MEDIUMINT`, `INT`, `BIGINT`
- Decimais (ponto flutuante): `FLOAT`, `DOUBLE` (arredonda quando o valor for maior que o máximo)
- Decimais (fixos): `DECIMAL` ou `NUMERIC` **Ex.:** `DECIMAL(5,2)` armazena entre -999,99 e 999,99
- `BIT`: **Ex.:** `BIT(1)` 1 ou 0, `BIT(2)` 01, 10, 00 ou 11

#### Atributos dos campos numéricos:

- `SIGNED` ou `UNSIGNED`: vai possuir ou não sinal no número.
- `ZEROFILL`: preenche com Zeros os espaços **Ex.:** `INT(4)` se armazenarmos o valor 5, será gravado 0005.
- `AUTO_INCREMENT`: sequência auto incrementada.

#### Data e Hora:

- `DATE`: 1000-01-01 até 9999-12-31
- `DATETIME`: 1000-01-01 00:00:00 até 9999-12-31 23:59:59
- `TIMESTAMP`: 1970-01-01 00:00:01 UTC até 2038-01-19 UTC
- `TIME`: -838:59:59 e 839:59:59
- `YEAR`: 1901 até 2155 (pode ser expresso no formato 2 ou 4 dígitos)

#### Strings:

- `CHAR`: cadeia de caracteres com valor fixo (de 0 a 255).
- **Ex.:** Em um campo `CHAR(4)`, ao armazenar a String `"aa"`, o banco irá armazenar a String `"  aa"`.
- `VARCHAR`: cadeia de caracteres com valor variado (de 0 a 255).
- **Ex.:** Em um campo `VARCHAR(4)`, ao armazenar a String `"aa"`, o banco irá armazenar a String `"aa"`.
- `BINARY`: cadeia de caracteres com valor fixo (de 0 a 255), expressos em binário.
- `VARBINARY`: cadeia de caracteres com valor variado (de 0 a 255), expressos em binário.
- `BLOB`: binário longo. Podemos ter: `TINYBLOB`, `BLOB`, `MEDIUMBLOB`, `LONGBLOB`.
- `TEXT`: texto longo. Podemos ter: `TINYTEXT`, `TEXT`, `MEDIUMTEXT`, `LONGTEXT`.
- `ENUM`: permite armazenar uma lista pré-definida de valores.
- **Ex.:** `Size ENUM('x-small', 'small', 'medium', 'large', 'x-large')` campo `Size` só pode ter os valores pré-determinados.

#### Atributos dos campos String:

- `SET` e `COLLATE`: que tipo de conjunto de caracteres serão suportados.

#### SPACIAL:

- `GEOMETRY`: área de um mapa.
- `POINT`: latitude e longitude.
- `LINESTRING`: área de um mapa.
- `POLYGON`: área de um mapa.

### Atividade 03 - Criando a primeira tabela:

- `CREATE TABLE`: comando utilizado para criar uma tabela no esquema/banco de dados selecionado.
- **Ex.:**
```
CREATE TABLE tbCliente
(
CPF VARCHAR(11),
NOME VARCHAR(100),
ENDERECO1 VARCHAR(150),
ENDERECO2 VARCHAR(150),
BAIRRO VARCHAR(50),
CIDADE VARCHAR(50),
ESTADO VARCHAR(50),
CEP VARCHAR(8),
IDADE SMALLINT,
SEXO VARCHAR(1),
LIMITE_CREDITO FLOAT,
VOLUME_COMPRA FLOAT,
PRIMEIRA_COMPRA BIT(1)
)
```

### Ativdade 05 - Criando a tabela pelo assistente:

- No Workbench, clique com o botão direito em `Tables` dentro de seu esquema, e selecione `Create Table...`.
- Em *Table Name*, digite `tbProduto`.
- Clique abaixo de *Column Name*, digite o nome da coluna e em *Datatype* selecione seu tipo.
- Após definir as colunas, clique em *Apply*.

### Atividade 06 - Apagando tabelas:

- Utilizando o assistente do Workbench: clique com o botão direito em cima de uma tabela e selecione `Drop Table...` e depois em `Drop Now`.
- Utilizando SQL: `DROP TABLE tbCliente2`


## Aula 04 - Manutenção dos dados nas tabelas

### Atividade 01 - Inserindo registros na tabela:

- `INSERT INTO`: comando utilizado para inserir dados em uma tabela.
- **Ex.:**
```
INSERT INTO tbProduto (PRODUTO, NOME, EMBALAGEM, TAMANHO, SABOR, PRECO_LISTA)
	VALUES ('1040107', 'Light - 350 ml - Melância', 'Lata', '350 ml', 'Melância', 4.56);
```

### Atividade 05 - Alterando registros:

- `UPDATE`: comando utilizado para alterar dados de uma tabela.
- **Ex.:**
```
UPDATE tbProduto SET EMBALAGEM = 'Lata', PRECO_LISTA = 2.46
    WHERE PRODUTO = '544931';
```

### Atividade 07 - Excluindo registros:

- `DELETE`: comando utilizado para excluir dados de uma tabela.
- **Ex.:** `DELETE FROM tbProduto WHERE PRODUTO = '1078680';`

### Atividade 09 - Incluindo a chave primária:

- `ALTER TABLE`: comando utilizado para alterar a estrutura de uma tabela.
- **Ex.:** `ALTER TABLE tbProduto ADD PRIMARY KEY (PRODUTO);`
- A chave primária impede que existam dois registros com o mesmo valor do campo que possui essa chave.

### Atividade 11 - Manipulando datas e campos lógicos:

- `ADD COLUMN`: comando utilizado, em conjunto com o comando `ALTER TABLE`, para adicionar uma nova coluna à uma tabela.
- **Ex.:** `ALTER TABLE tbCliente ADD COLUMN (DATA_NASCIMENTO DATE);`
- Em SQL não existe o tipo *boolean*. Para representar um dado com valor lógico, utiliza-se o `BIT(1)` (o valor `0` representa `false` e `1` representa `true`).
- Um campo do tipo `DATE` possui o seguinte padrão: `'yyyy-mm-dd'`.
- **Ex** `INSERT INTO tbCliente (DATA_NASCIMENTO) VALUES ('1989-10-05');`


## Aula 05 - Consultando os dados

### Atividade 01 - Incluindo dados na tabela:

- `SELECT`: comando utilizado para consultar dados de uma tabela.
- **Ex.:** `SELECT * FROM tbCliente;`
- Em uma consulta, é possível selecionar apenas alguns campos:
- **Ex.:** `SELECT CPF, NOME FROM tbCliente;`
- `LIMIT`: limita os registros retornados de uma consulta:
- **Ex.:** `SELECT CPF, NOME FROM tbCliente LIMIT 5;`
- `ALIAS`: "pseudônimo"/nome fantasia/apelido de um campo.
- **Ex.:** `SELECT CPF AS CPF_CLIENTE, NOME AS NOME_CLIENTE FROM tbCliente;`
