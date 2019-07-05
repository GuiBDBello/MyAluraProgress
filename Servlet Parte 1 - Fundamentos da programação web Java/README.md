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

### Atividade 08 - Finalmente, o primeiro servlet:

#### Servlet:

- Um Servlet é um "Objeto" em um projeto que roda no Server (Tomcat);
- Uma Classe Java que representa um Servlet deve herdar de `HttpServlet`;
- Sobrescreveremos o método `service(HttpServletRequest, HttpServletResponse)`, que recebe um Objeto Java que representa a requisição e outroque representa a resposta;
- `@WebServlet(urlPatterns="/oi")`: define que uma Classe é um WebServlet, e define o nome do Servlet;
- Removeremos o conteúdo do método, e adicionaremos:
`PrintWriter out = resp.getWriter(); //escrevendo a resposta da requisição no navegador
out.println("<html>");
out.println("<body>");
out.println("Oi mundo! Parabéns, você escreveu seu primeiro Servlet!");
out.println("</body>");
out.println("</html>");
System.out.println("O Servlet 'OiMundoServlet' foi chamado");`

### Atividade 13 - O que aprendemos?:

- Apache Tomcat ou apenas Tomcat é um servidor web em Java
- Tomcat entende o protocolo HTTP e roda por padrão no `http://localhost:8080`
- O projeto Java faz parte da URL, no nosso caso: `http://localhost:8080/gerenciador`
- Uma aplicação web Java pode ter páginas HTML
- Uma servlet é um objeto Java que podemos chamar a partir de uma requisição HTTP
- Para mapear a URL para uma servlet usamos a anotação `@WebServlet`
- Uma servlet deve estender a classe `HttpServlet` e sobrescrever um determinado método (por exemplo `service`)


## Aula 02 - Trabalhando com POST e GET

### Atividade 02 - Enviando parâmetros:

- É possível criar um Servlet diretamente pelo Eclipse. Para isso, siga os passos:
  1. `File > New > Servlet`;
  2. Em Class name, nomeie o Servlet e pressione `Next >`;
  3. Selecione o URL mapping, pressione `Edit...`, altere o mapeamento da URL e pressione `Next >`;
  4. Deselecione 'Constructors from superclass', 'doGet' e 'doPost' e marque 'service';

#### Parâmetros na URL:

- Para passar parâmetros na URL, deve-se utilizar o símbolo `?`. Para concatenar mais parâmetros, utiliza-se `&`;
- **Ex.:** `localhost:8080/gerenciador/novaEmpresa?nome=Alura&cnpj=xx.xxx.xxx/0001-??`
- É possível obter os parâmetros da requisição utilizando `request.getParameter("nome");`;

### Atividade 04 - Metodos GET e POST:

- As Ferramentas do Desenvolvedor (*Developer Tools*) estão presentes em qualquer navegador moderno;
- É possível obter informações sobre as requisições feitas no navegador acessando a aba *Network*;
- Ao selecionar a requisição, são mostradas várias informações sobre o protocolo HTTP, sobre o navegador, etc.;

#### Criando uma requisição POST:

- Na pasta *WebContent*, crie um arquivo HTML chamado `formNovaEmpresa.html`;
- Crie um formulário, utilizando a tag `<form>` com o atributo `action` que possui como valor o caminho ao qual será feita a requisição (ao submeter o formulário);
- Dentro do form, defina os atributos `type` e `name`;
- **Ex.:** `<form action="/gerenciador/novaEmpresa"> Nome: <input type="text" name="nome" /> </form>`
- Agora, dentro do formulário, crie um botão para submetê-lo: `<input type="submit" />`
- Por padrão, um `<form>` realiza uma requisição do tipo `GET`. Para alterá-la para `POST`, basta adicionar o atributo `method="post"` na tag `<form>`;

### Atividade 07 - Apenas POST:

- `doPost(HttpServletRequest, HttpServletResponse) { }`: método semelhante ao `service(HttpServletRequest, HttpServletResponse)` da aula anterior, porém, este aceita apenas requisições `POST`. Antagônico ao `doGet(HttpServletRequest, HttpServletResponse)`. Ao tentar realizar um método `GET` nessa `URL`, ocorrerá o código 405 - *Method Not Allowed*;


## Aula 03 - Definindo o nosso modelo

### Atividade 02 - Definindo modelo:

- Crie uma Classe `Empresa` para armazenar os atributos de uma empresa;
- Crie uma Classe `Banco` com atributos estáticos para "simular" um banco de dados;

### Atividade 05 - Listando empresas com servlets:

- Crie um novo Servlet e, com o `PrintWriter`, escreva uma lista (`<ul>`) com itens (`<li>`) dentro dela, mostrando as Empresas cadastradas;
- `static { }`: um bloco estático é executado quando a máquina virtual carrega a Classe;
- Esse bloco será utilizado apenas para testes. Ele serve para cadastrar dados no banco por padrão, para ele não ser inicializado vazio;


## Aula 04 - Páginas dinâmicas com JSP

### Atividade 02 - Primeiro JSP:

- Misturar Java e HTML não parece correto... para não fazer isso, existe uma tecnologia chamada *Java Server Pages* (JSP);
- Scriptlet (`<% %>`): bloco de código Java;
- **Ex.:** `<% String nomeEmpresa = "Alura"; %>`
- Um JSP é interpretado no lado do servidor (*back-end*), não no cliente (*front-end*);
- `<% out.println(nomeEmpresa); %>` ou `<%= nomeEmpresa %>`: escreve a variável 'nomeEmpresa' no navegador;

### Atividade 06 - Despachando a requisição:

- É possível separar as responsabilidades da aplicação: o Servlet realiza as operações e controla o banco de dados enquanto o JSP se responsabiliza pela parte visual;
- `RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");`: retorna um `RequestDispatcher`, a requisição "despacha-a", chamando o JSP após executar o Servlet;
- `rd.forward(request, response);`: "despacha" a requisição e a resposta para chamar o JSP definido acima;
- `request.setAttribute("empresa", empresa.getNome());`: "pendura" um atributo com um valor, para ser utilizado no JSP;
- `<% String nomeEmpresa = (String) request.getAttribute("empresa"); %>`: retorna um Objeto (`Object`, por isso é necessário o *Casting*) definido no Servlet (o atributo "pendurado") para dentro do Scriptlet;

### Atividade 08 - JSP para listar empresas:

- `<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>`: faz uma "declaração da página" para importar Classes do Servlet;

### Atividade 10 - O que aprendemos?:

- JSP significa Java Server Pages
- JSP é uma página automaticamente processada pelo Tomcat
- Para gerar HTML dinamicamente no JSP usamos Scriplets
- Um scriptlet `<% %>` é um código Java dentro do HTML
- Um scriptlet só funciona em uma página JSP
- Usamos o `RequestDispatcher` para chamar um JSP a partir da servlet
- Obtemos o RequestDispatcher a partir do `HttpServletRequest`
- Usamos a requisição para colocar ou pegar um atributo `(setAttribute(.., ..)` ou `getAttribute(..)`)


## Aula 05 - JSTL e Expression Language

### Atividade 02 - Conhecendo Expression Language:

- `${ 3 + 3 }`: sintaxe utilizada para interpretar e imprimir uma "expressão";

### Atividade 05 - Conhecendo JSTL:

- JSTL (*Java Standard Taglib*): biblioteca que contém tags HTML, como, por exemplo, `<foreach>`;
- `<foreach></foreach>`: tag HTML utilizada para fazer um laço;
- `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`: procura, dentro dos arquivos *.jar* na pasta `WebContent/WEB-INF/lib/`, uma biblioteca com essa *uri* e define um *prefix* para acessar suas tags;
- **Ex.:** `<c:forEach items="${empresas}" var="empresa"><li>${empresa.nome}</li></c:forEach>`

### Atividade 08 - Usando a taglib core:

- *core*: controle de fluxo;
- **Ex.:** `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`
- *fmt*: formatação/i18n (internacionalização);
- **Ex.:** `<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>`;
- *sql*: executar SQL;
- *xml*: gerar XML;

#### Context root:

- Nas *Properties* do projeto, em *Web Project Settings*, o valor de *Context root* é o valor "inicial" da URL. Isso pode ser obtido pela tag `url`;
- **Ex.:** `<c:url value="/gerenciador/novaEmpresa" var="linkNovaEmpresaServlet" />`
- É possível utilizar a variável em outras tags, por exemplo: `<form action="${linkNovaEmpresaServlet}" method="post">`;

#### Condições:

- A tag `if` existe para definir uma condição no JSP, através do atributo `test`. **Lembre-se que necessário importar a *taglib* `core` para utilizar essa e outras tags**;
- **Ex.:** `<c:if test="${not empty empresa}">Empresa ${empresa} cadastrada!</c:if>`
- **Ex.:** `<c:if test="${empty empresa}">Nenhuma empresa cadastrada!</c:if>`

### Atividade 10 - Usando a taglib fmt:

#### java.util.Date:

- `private Date dataAbertura = new Date();`: Classe Java que lida com datas. Seu formato padrão é: *Weekday Month Day hour:minute:second timezonecode year*;

#### FMT:

- `<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>`: importa a taglib de formatação;
- `<fmt:formatDate value="" />`: tag utilizada para formatar datas. Seu formato padrão é: *Dia* de *mês* de *ano*;
- `pattern="dd/MM/yyyy"`: atributo da tag `<fmt:formatDate>`;

#### SimpleDateFormat:

- `SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")`: cria um formato de formatação de data;
- `Date dataAbertura = sdf.parse(paramDataEmpresa);`: retorna um Objeto do tipo `Date` com a formatação de `SimpleDateFormat`;

#### "Catch and rethrow":

- Dispara uma exceção dentro do bloco `catch` de outra exceção;


## Aula 06 - Redirecionando o fluxo

### Atividade 02 - Quando o dispatcher não atende:

- Anteriormente despachamos uma requisição do Servlet ao JSP. É possível, também, despachar uma requisição de um Servlet para outro Servlet;
