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
