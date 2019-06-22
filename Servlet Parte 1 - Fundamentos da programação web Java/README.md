# Servlet Parte 1: Fundamentos da programação web Java

## Aula 01 - Fundamentos da Web e a API de Servlets

### Atividade 03 - Criando Ambiente:

#### Pré-requisitos:

- *Java Runtime Environtment* (JRE);
- Eclipse IDE *for Java EE Developers*;
- *Apache Tomcat*;

#### Configurar Tomcat no Eclipse:

- Na aba 'Servers', adicione um novo Server;
- Selecione `Apache > Tomcat v9.0 Server`;
- Selecione o diretório Tomcat descompactado;

#### Iniciar Tomcat no Eclipse:

- Na aba 'Servers', selecione um Server e pressione no botão 'Start the server' (`Ctrl + Alt + R`);

#### Servlet (Tomcat):

- Une programação Java com Web (HTTP e HTML);
- A porta padrão que o Tomcat utiliza é a porta 8080;
- Após iniciar o seu Server, é possível acessá-lo pelo navegador pela URL `http://localhost:8080`;

### Atividade 06 - Primeiro projeto Java Web:

- `File > New > Dynamic Web Project`: cria um novo projeto Web dinâmico;
- Nomear o projeto (para essa aula, será nomeado 'gerenciador');
- Na última tela da criação do projeto, selecione 'Generate web.xml deployment descriptor';

#### Associar projeto ao Tomcat:

- Na aba 'Servers', clique com o botão direito no seu Server, selecione 'Add and Remove...' e adicione seu projeto;

#### WebContent:

- A pasta WebContent guarda os arquivos HTML, então criaremos o arquivo `bem-vindo.html` nela;
- Na URL, para acessar esse arquivo, digite `http://localhost:8080/gerenciador/bem-vindo.html`;
