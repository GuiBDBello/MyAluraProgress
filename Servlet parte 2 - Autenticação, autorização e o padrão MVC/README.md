# Servlet Parte 2: Autenticação, autorização e o padrão MVC

## Aula 01 - Criando o controlador

### Atividade 09 - Separando ações:

- Ao refatorar um Servlet, é necessário prestar atenção nos *JSP*'s que possuem código estático referenciado àquele Servlet;
- `response.sendRedirect("entrada?acao=ListaEmpresas");`: enviando parâmetros em um redirecionamento;

### Atividade 12 - Para saber mais: Outro mapeamento:

- No curso, o controlador foi mapeado para a URL `/entrada`;
- **Ex.:** `http://localhost:8080/gerenciador/entrada?acao=ListaEmpresas`
- Porém, é muito comum no mercado que controladores utilizem o mapeamento `/`, assim permitindo usar o nome da URL para definir a ação;
- **Ex.:** `http://localhost:8080/gerenciador/listaEmpresas`
- O método `getRequestURI()`, do objeto `HttpServletRequest`, devolve exatamente essa informação: `String url = request.getRequestURI();`;


## Aula 02 - O padrão MVC

### Atividade 04 - Escondendo JSP:

- Um JSP nunca deve ser chamado diretamente. É uma boa prática que o *Controller* o chame;
- Crie um diretório chamado `jsp/` ou `view/` dentro do diretório `WEB-INF`. Isso impossibilita o navegador de acessar seus arquivos *.jsp* diretamente, pois o diretório `WEB-INF` não é acessível a partir do navegador;

### Atividade 07 - Melhorando o controlador:

#### Class:

- Existe uma Classe chamada `Class`, que pertence ao pacote `java.lang`;
- `Class classe = Class.forName("nomeDaClasse")`: retorna e carrega em memória a Classe com o nome 'nomeDaClasse', que deve ser seu *Full Qualified Name* (pacote + nome da Classe);
- Essa API que permite instanciar/utilizar uma Classe como um Objeto, é chamada de *Reflection*;
- `Object obj = classe.newInstance();`: cria uma nova instância/Objeto;
- Após, criaremos uma Interface 'Acao', e realizaremos um *casting* de Object para a nossa Interface, que será implementada em todas as ações;
- As Classes que implementam as ações (Classe que encapsula um único método) fazem parte de um padrão de projeto chamado de *Command*;


## Aula 03 - Formulário de login

### Atividade 07 - Para saber mais: O padrão JAAS:

- O Tomcat e mundo de Servlet já possuem uma forma padrão para trabalhar com login, senha, permissões e os recursos protegidos. Tudo isso pode ser configurado através do arquivo **web.xml** e uma pequena configuração no servidor Tomcat.
- A ideia é que aplicação web defina que deve ter um login, quais são as permissões e os recursos (URLs) protegidos. Tudo isso fica no **web.xml**.
- No outro lado, o Tomcat fica com a responsabilidade de carregar os usuários e as permissões. Uma forma simples de fazer isso é usar o arquivo **tomcat-users.xml** dentro do projeto Servers, na pasta Tomcat.
- Tudo isso foi definido dentro de um outro padrão, chamado Java Autenthication and Authorization Service (JAAS - API padrão do Java para segurança), no entanto, ele não é tão utilizado em aplicações web Java.


## Aula 04 - HttpSession

### Atividade 02 - Trabalhando com sessão:

- HTTP trata cada requisição isoladamente;
- *SessionID*: identificação do Usuário para o navegador. É criada automaticamente;
- Quando chegar uma requisição que o Tomcat não "reconhece", ele cria o *SessionID* dela e envia essa identificação para o navegador, para que essa identificação seja utilizada nas próximas requisições;
- A partir do *SessionID* o Tomcat sabe que está comunicando com o mesmo navegador e, assim, com o mesmo usuário;

#### Developer tools:

- Ao abrir as ferramentas do desenvolvedor em seu navegador, selecione a aba *Network* e realize uma nova requisição. Selecione a requisição e selecione a aba *Cookies*. Nessa aba estará listado um *JSESSIONID*, que o Tomcat criou e devolveu na resposta;
- O navegador, após receber o *Cookie* pela primeira vez, sempre responderá a requisição com o este *Cookie* que foi gerado;
- Juntamente à criação do *Cookie*, é criado um Objeto `HttpSession` e associado ao *Cookie*;

#### HttpSession:

- `HttpSession`: Objeto para o Usuário guardar informações dele;
- `HttpSession sessao = request.getSession();`: retorna o Objeto `HttpSession` relacionado ao *Cookie* da requisição;
- Enquanto o Usuário está utilizando a aplicação, esse Objeto permanece "vivo"/válido, em memória no servidor;
- Assim como o Sistema Operacional busca as informações em memória primeiro em *Cache* e depois em *RAM*, o JSP busca os atributos primeiro na *request* e depois na *session*;

### Atividade 05 - Testando o login:

- `if (sessao.getAttribute("usuarioLogado") == null) { return "redirect:entrada?acao=LoginForm"; }`: utiliza o atributo "pendurado" na *session* para verificar se o login foi efetivado. Se não foi, redireciona para a página de login;

### Atividade 06 - Autorizando o acesso:

- `boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;`: verifica se o usuário não está logado, utilizando o atributo "pendurado" na *session*;
- `boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));`: verifica se a ação executada é uma ação protegida por login (apenas o próprio login não é protegido);
- `if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) { response.sendRedirect("entrada?acao=LoginForm"); return; }`: redireciona para a página de login e encerra o método;

### Atividade 07 - Implementando o logout:

#### Servlet:

- `sessao.removeAttribute("usuarioLogado");`: remove o atributo "pendurado" que representava o *Cookie* da sessão do usuário;
- `sessao.invalidade();`: remove o Objeto `HttpSession` e todos os Objetos associados, e destrói o *Cookie*;

#### JSP:

- `<a href="entrada?acao=Logout">Sair</a>`: cria um link clicável que realiza o *logout*;

#### Importando conteúdo no JSP:

- `<c:import url="logout-parcial.jsp" />`: tag da taglib **core** da biblioteca *JSTL* que permite importar o conteúdo de um arquivo (normalmente *.html* ou *.jsp*) em seu *.jsp*;

### Atividade 09 - Para saber mais: Timeout da sessão:

- O Objeto `HttpSession` tem um *timeout* associado. Se você não usa a aplicação por um determinado tempo, o Tomcat automaticamente remove o objeto `HttpSession` da memória. O padrão do Tomcat 9 é de 30 minutos, ou seja, se você não usar a aplicação por 30 min, você será deslogado!!
- Isso é configurável através do nosso **web.xml**:
`
<session-config>
    <!-- 10 min -->
    <session-timeout>10</session-timeout>
</session-config>
`

#### Cookie transiente:

- Também chamado de ***session cookie***. Ao contrário do *Cookie* persistente, só vive enquanto o navegador está aberto;

### Atividade 11 - O que aprendemos?:

- Por padrão, o navegador não envia nenhuma identificação sobre o usuário
- Quando o Tomcat recebe uma nova requisição (sem identificação), gerará um ID
- O ID fica salvo no cookie de nome `JSessionID`
- O ID é um *hash* (número aleatório)
- O cookie é anexado à resposta HTTP
- O navegador reenvia o cookie automaticamente nas próximas requisições
- O Tomcat gera, além do ID, um objeto chamado `HttpSession`
- A vida do objeto `HttpSession` fica atrelado ao ID
- Para ter acesso à `HttpSession`, basta chamar `request.getSession()`
- Usamos a `HttpSession` para guardar dados sobre o usuário (login, permissões, carrinho de compra)
- A `HttpSession` tem um ciclo de vida e será automaticamente invalidada


## Aula 05 - Aplicando filtros

### Atividade 02 - Primeiro filtro:

- É possível aplicar um filtro nas requisições antes delas chegarem ao *Controller*;
- Um filtro é muito semelhante à um *Servlet*. Porém, ele possui uma responsabilidade a mais: ele pode barrar uma requisição;
- Para implementar um filtro, deve-se implementar a Interface `Filter`;
- **Cuidado!** No mundo Java, existem diversas implementações de `Filter`. Para nossos fins, devemos utilizar a Classe `Filter` que provém do pacote `javax.servlet.Filter`;
- Assim como o Servlet, o Filter também é uma Interface que implementa apenas um método, o `doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`;
- `chain.doFilter(request, response);`: se esse método não for chamado dentro de uma implementação de `Filter`, a requisição fica parada;
- Em um `Filter` também deve ser mapeada uma *url*, da mesma forma como é mapeada em um Servlet (`WebServlet("/entrada")`). Essa é a *url* da requisição a qual o Filtro será aplicado;

### Atividade 04 - Filtro de autorização:

- Ao implementar filtros utilizando notações, a ordem de execução desses filtros não é controlada por você. Para alterar essa ordem, deve-se definí-la no arquivo **web.xml**;

### Atividade 05 - Ordem de execução:

- A ordem dos filtros no arquivo **web.xml** é a ordem que o Tomcat irá executá-los;
- A nomenclatura "filtro" é utilizada quando nos referimos à Servlets. Quando nos referimos à *Frameworks* (*Spring*, *EJB*, *VRaptor*), esses "filtros" são chamados de "interceptadores";
- Apesar do conceito ser o mesmo, **filtros** são mais relacionados ao mundo Web, enquanto **interceptadores** estão mais relacionados com os *frameworks*;

### Atividade 08 - Para saber mais: Interceptor ou Filter:

- O filtro fica antes do controlador e o interceptador depois. O filtro é um componente do mundo de Servlets e se preocupa em filtrar requisições (é ligado ao mundo web), enquanto um interceptador "filtra" chamadas de ações ou outros métodos. Os interceptadores são específicos do framework (por exemplo, Spring) e até funciona sem Servlets.

### Atividade 10 - O que aprendemos?:

- Um Filter e Servlet são bem parecidos
- Comparado com Servlet, o Filter tem o poder de parar o fluxo
- Para escrever um filtro, devemos implementar a interface `javax.servlet.Filter`
- Para mapear o filtro, usamos a anotação `@WebFilter` ou o **web.xml**
- Vários filtros podem funcionar numa cadeia (um chama o próximo, mas todos são independentes)
- Para definir a ordem de execução, devemos mapear os filtros no web.xml
- Um filtro recebe como parâmetro, do método `doFilter`, um `ServletRequest` e um `ServletResponse`
- Ambos, `ServletRequest` e `ServletResponse`, são interfaces mais genéricas do que `HttpServletRequeest` e `HttpServletResponse`
- Para chamar o próximo filtro na cadeia, usamos o objeto `FilterChain`


## Aula 06 - Introdução ao Web Services

### Atividade 02 - O que é um Web Service?:

- Quando o cliente que utiliza a aplicação não entende HTML, deve-se retornar outro formato de dados;
- Para isso, existe o *JSON* e o *XML*, que retornam apenas os dados requisitados, sem estrutura de layout;
- Web Service: é um serviço chamado através do protocolo **HTTP** que retorna os dados em um formato genérico (*JSON*/*XML*);

### Atividade 04 - Serviço com JSON:

- *JSON*: notação que define dados no formato de um Objeto JavaScript;

#### Gson:

- Copie e cole o arquivo `gson-2.8.5.jar` no diretório `WEB-INF > lib` de seu projeto;
- `Gson gson = new Gson();`: cria um novo Objeto Gson;
- `String json = gson.toJson(empresas);`: converte uma Lista Java para um *JSON*;
- `response.setContentType("application/json");`: define o tipo do conteúdo da resposta em seu cabeçalho;
- `response.getWriter().print(json);`: retorna o *JSON* na resposta da requisição;
