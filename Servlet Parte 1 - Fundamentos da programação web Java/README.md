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

### Atividade 05 - Redirecionamento pelo navegador:

- Um redirecionamento ocorre quando a resposta de uma requisição representa uma ordem para o navegador realizar outra requisição;
- Esse ato (o navegador realizar a requisição a partir de uma resposta) é chamado de "Redirecionamento *client-side";
- "Redirecionamento *server-side*" é quando um dispatcher de um Servlet chama outro Servlet;
- `response.sendRedirect("listEmpresas");`: envia uma nova requisição para `listEmpresas`;
- Ao redirecionar uma requisição, é criada uma nova requisição. Portanto, todos os atributos "pendurados" na requisição anterior serão perdidos;


## Aula 07 - Completando o CRUD

### Atividade 02 - Apresentando as funcionalidades:

- *Create*: criação do registro/objeto;
- *Read*: leitura de registro(s), objeto(s);
- *Update*: atualizar registro/objeto;
- *Delete*: remover registro/objeto;

### Atividade 04 - Removendo uma empresa:

#### JSP:

- `<a href="/gerenciador/removeEmpresa?id=${empresa.id}">remover</a>`: adiciona um link, que realizará uma requisição para um Servlet que remove a empresa da lista;
- Utilizaremos o ID da Empresa para identificá-la;

#### Servlet:

- `String paramId = request.getParameter("id");`: retorna uma String que representa um parâmetro 'id' "pendurado" na requisição;
- `Integer id = Integer.valueOf(paramId);`: converte a String 'paramId' para Integer;
- `lista.remove(id);`: Remove a empresa da lista;
- **Cuidado!** Ao iterar por uma lista, não altere a quantidade de elementos dessa lista. Isso causará uma `ConcurrentModificationException`;
- Para evitar que a exceção acima ocorra, utiliz- um `Iterator`;
- **Ex.:** `Iterator<Empresa> it = lista.iterato-();`
- E, para obter seus elementos, utilize `it.hasN-xt()` e `it.next()` (semelhante ao `Scanner`);
- **Ex.:** `while(it.hasNext()) { Empresa emp = -t.next(); }`
- Utilize o `Iterator` também para remover um elemento (dentro de um laço);
- **Ex.:** `if(emp.getId() == id) { it.remove() };`
- Para finalizar, redirecione a resposta para atualizar a lista de empresas;
- **Ex.:** `response.sendRedirect("listaEmpresas");`

### Atividade 06 - Formulário de alteração:

- Para alterar os dados de uma empresa, criaremos um Servlet que mostrará as informações da empresa, e outro Servlet que altera seus dados;
- O Servlet `MostraEmpresaServlet` deve despachar a requisição para `formaAlteraEmpresa.jsp`;
- **Ex.:** `request.setAttribute("empresa", empresa); RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp"); rd.formard(request, response);`
- É possível utilizar uma taglib para definir um valor a um atributo HTML;
- **Ex.:** `Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />`

### Atividade 07 - Alterando empresa:

- Busca uma Empresa pelo ID e altera seus dados;


## Aula 08 - Deploy da aplicação

### Atividade 02 - Conhecendo o web.xml:

- O arquivo `web.xml`, antigamente, era obrigatório em projetos Java Web. Atualmente ele é opcional;
- É um arquivo de configuração relacionado aos Servlets;
- `<welcome-file>index.html</welcome-file>`: arquivo mostrado quando é carregado apenas o *ContextRoot* da aplicação. É possível utilizar várias dessas tags em sequência, onde o próximo arquivo é mostrado caso o anterior não seja encontrado;

#### Definindo um Servlet no web.xml:

- `<servlet><servlet-name>OiMundoServlet</servlet-name><servlet-class>br.com.alura.gerenciador.servlet.OiMundoServlet</servlet-class></servlet>`: define uma Classe como um Servlet;
- `<servlet-mapping><servlet-name>OiMundoServlet</servlet-name><url-pattern>/ola</url-pattern></servlet-mapping>`: define o mapeamento de um Servlet;
- A tag `<servlet-name>` serve para vincular o Servlet com um mapeamento;
- Um dos motivos do `web.xml` ter se tornado opcional foi o surgimento das anotações, que simplificam toda essa configuração em apenas uma linha: `@WebServlet(urlPatterns="/ola")`;

### Atividade 05 - Inversão de controle:

#### Relembrando:

- Uma das vantagens de utilizar o `web.xml` é que todas suas configurações ficam em apenas um lugar, enquanto com anotações elas ficam espalhadas pelas Classes;
- "Servlet é um Objeto que você consegue chamar através do protocolo HTTP", e quem realiza a chamada é o Tomcat. Ou seja, é possível utilizar um navegador para fazer uma requisição ao Tomcat para ele executar um Objeto específico;

#### Tomcat:

- Os projetos desenvolvidos nas aulas não possuem o método `main`. Quem possui esse método é o Tomcat, nosso `ServletContainer`. Tomcat é o *middleware* entre o navegador e o Servlet;
- O Tomcat instancia o Objeto quando o mapeamento associado ao Servlet é chamado. O Objeto é instanciado apenas uma vez, independente de quantas requisições são feitas;
- Os Servlets, por padrão, possuem escopo **Singleton**, ou seja, possuem uma instância única até o encerramento da aplicação;

#### Inversão de controle (*IOC*):

- Inversão de controle: o método principal da aplicação (`main`) não instancia os Objetos, apenas cria as Classes, quem instancia é o Tomcat;
- O Tomcat não possibilita configurações, como: alteração de escopo do Servlet, gerencia transação com banco de dados, regras de segurança, etc.;
- Para realizar configurações mais sofisticadas, existe o **Spring MVC**, que realiza todas as configurações acima e muitas outras;

### Atividade 08 - Para saber mais: Tomcat sem preguiça:

- `loadOnStartup`: possibilita que o Tomcat instancie o Servlet em sua inicialização;
- **Ex.:** `@WebServlet(urlPatterns="/oi", loadOnStartup=1)`

### Atividade 09 - Deploy da aplicação:

#### Deploy WAR - Web ARchive:

- Clicar com o botão direito do mouse sob o projeto > Export > WAR file;
- Selecionar o caminho do arquivo a ser exportado em *Destination*;
- Para fazer o deploy, mova o arquivo `.war` gerado para a pasta `webapps` dentro da pasta do Tomcat;

#### Inicializar Tomcat por CLI:

- Abrir Prompt ou Terminal;
- Ir até 'diretório de instalação do Tomcat'/bin/;
- Executar `startup.bat` ou `startup.sh`;

#### UnsupportedClassVersionError:

- Versão do Tomcat e da aplicação são diferentes. Para corrigir, deve-se alterar a versão do Java utilizada para compilar a aplicação ou alterar a versão do Java que o Tomcat utiliza, nas variáveis do ambiente;

#### Alterar porta:

- Abra o arquivo 'diretório de instalação do Tomcat'/conf/server.xml;
- Utilize a busca (`Ctrl + F`) com parâmetro "8080" e altere a porta para "80";
