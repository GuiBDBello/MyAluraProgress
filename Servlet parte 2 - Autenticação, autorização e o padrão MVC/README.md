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
