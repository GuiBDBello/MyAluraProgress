# HTTP: Entendendo a web por baixo dos panos

## Aula 01 - O que é HTTP?

### Atividade 03 - O que é o HTTP:

- O HTTP é independente de plataforma, asism como de navegadores

#### Cliente-servidor:

- É um modelo arquitetural, a internet inteira é baseada nessa arquitetura onde há um cliente que solicita e um servidor que responde

> Os protocolos são definidos, especificados e disponibilizados para implementação em ambas as partes, para consultar a especificação do HTTP, você pode utilizar o seguinte endereço: https://tools.ietf.org/html/rfc2616

- O HTTP é um protocolo que define as regras de comunicação entre cliente e servidor na internet

#### O que aprendemos nesse capítulo?

* Na internet sempre tem um cliente e um servidor
* Entre o cliente e o servidor precisam haver regras de comunicação
* As regras são definidas dentro de um protocolo
* HTTP é o protocolo mais importante na internet

### Atividade 07 - Para saber mais: Peer-To-Peer:

> O modelo Cliente-Servidor tenta centralizar o trabalho no servidor, mas isso também pode gerar gargalos. Se cada Cliente pudesse ajudar no trabalho, ou seja, assumir um pouco da responsabilidade do servidor, seria muito mais rápido. Essa é a ideia do P2P! Não há mais uma clara divisão entre Cliente-Servidor, cada cliente também é servidor e vice-versa!

- Isto é útil quando você precisa distribuir um trabalho ou necessita baixar algo de vários lugares diferentes. Faz sentido?
- Usando algum aplicativo de Torrent, o protocolo utilizado não é o HTTP, e sim o protocolo P2P, como BitTorrent ou Gnutella.


## Aula 02 - A web segura - HTTPS

### Atividade 01 - HTTPS - A versão segura do HTTP:

#### Requisição:

- São dados enviados do navegador ao servidor
- Nas ferramentas do desenvolvedor (F12), a aba 'Network' mostra todas as requisições que o navegador realizou
- O HTTP envia texto puro, enquanto o HTTPS implementa uma camada a mais de segurança
- Essa camada se chama SSL/TLS (*Secure Sockets Layer/Transport Layer Security*)

### Atividade 03 - Funcionamento do HTTPS:

- Para o navegador reconhecer o protocolo HTTPS de um site, é necessário que o site possua uma identidade
- Essa identidade, na web, é chamada de 'Certificado Digital'
- O certificado digital possui uma chave pública, que serve para criptografar os dados que o navegador envia ao servidor
- No servidor, uma chave privada descriptografa esses dados
- Nas ferramentas do desenvolvedor (F12), a aba 'Security' possui os certificados da página, que mostram dados como a validade do certificado
- O certificado digital é emitido por uma 'Autoridade Certificadora', que é um órgão/entidade confiável, que garante a identidade do site e a validade do certificado

### Atividade 07 - Para Saber Mais: As chaves do HTTPS:

#### Assimétrica:

- Duas chaves envolvidas (pública e privada)
- É segura, porém lenta

#### Simétrica:

- Uma chave apenas
- É rápida, porém não tão segura

#### HTTPS:

- O HTTPS utiliza ambas, simétrica e assimétrica
- É gerada uma chave simétrica em tempo de execução, apenas para o cliente e o servidor que se comunicam naquele momento
- A chave simétrica é enviada ao servidor utilizando a criptografia assimétrica, e então é utilizada para o restante da comunicação
- Ou seja, o HTTPS começa com criptografia **assimétrica** para depois mudar para criptografia **simétrica**
- A chave simétrica é gerada no início da comunicação e reaproveitada nas requisições seguintes


## Aula 03 - Endereços sob seu domínio

### Atividade 01 - Endereços:

Para essa atividade, utilizaremos como referência o endereço ' http://www.alura.com.br '
- 'Domínio': Olhando da direita para a esquerda, o domínio é o 'br'. Representa o *top level domain*, a raíz do domínio
- 'Subdomínio': www.alura.com é um sub-domínio. 'www' é um sub-domínio opcional
- Implicitamente, as máquinas na internet utilizam os endereços de IP para comunicarem-se. Podemos obter o endereço de IP de um site rodando o comando:
`nslookup 'endereco'`: traz informações de um site, como nome/domínio e endereço IP

#### DNS:

- **Domain Name System**: serviço que resolve o nome de um domínio, retornando implicitamente um endereço IP

### Atividade 04 - Portas:

- 'http\://sub-dominio.dominio.top-level-domain**:80**': A porta é definida após o *top level domain*, pelos caracteres dois pontos (:) e o número da porta (padrão HTTP **:80**, padrão HTTPS **:443**)

### Atividade 06 - Recursos:

- URL são endereços da WEB
- Uma URL começa com o **protocolo** (http://), seguido pelo **domínio** (\w\w\w.alura.com.br)
- Após o domínio (e a porta, caso explícita) é especificado o caminho para um **recurso** (course/http-fundamentos)
- Recurso é algo concreto que pode ser acessado

#### URL:

- **Uniform Resource Locator**: `protocolo://dominio:porta/caminho/recurso`

### Atividade 09 - Para saber mais: URI ou URL?:

- Tl;dr: Uma URL é uma URI. No contexto do desenvolvimento web, ambas as siglas são válidas para falar de endereços na web. As siglas são praticamente sinônimos e são utilizadas dessa forma
- Uma URL é uma URI, mas nem todas as URI's são URL's! Existem URI's que identificam um recurso sem definir o endereço, nem o protocolo. Em outras palavras, uma URL representa uma identificação de um recurso (URI) através do endereço, mas nem todas as identificações são URL's.


## Aula 04 - O cliente pede e o servidor responde

### Atividade 01 - Modelo Requisição e Resposta:

- HTTP é '*Stateless*', ou seja, cada requisição é única, não reutiliza dados de requisições anteriores
- O servidor, ao verificar credenciais de acesso, retorna um "código" ao cliente, para não ser necessário verificar as mesmas credenciais a cada requisição
- Esse código é o conceito de 'Sessão'

#### Sessão:

- Maneira de lidar com um usuário logado
- Uma sessão salva informações do usuário

#### Cookies:

- Informações guardadas no navegador durante uma sessão, como credenciais de acesso

#### HTTP (REQUEST-RESPONSE):

- O protocolo HTTP segue o modelo **Requisição-Resposta**
- Uma requisição precisa ter todas as informações para o servidor gerar a resposta

### Atividade 04 - O que é um cookie?

- É um pequeno arquivo de texto, normalmente criado pela aplicação web, para guardar algumas informações sobre usuário no navegador
- Para visualizar um cookie (Google Chrome): 

> Configurações -> Privacidade -> Configurações de conteúdo... -> Todos os cookies e dados de site...


## Aula 05 - Depurando a requisição HTTP

### Atividade 01 - Depurando o método HTTP:

- Abrir as 'Ferramentas do desenvolvedor' (F12 / Ctrl + Shift + I) na aba 'Network'
- Ao carregar a página, aparecerão todas as requisições que o navegador realizou
- Aparecem informações de cada requisição, como 'Nome', 'Status', 'Tamanho', 'Duração'...
- Ao selecionar uma requisição, são mostradas informações como o 'Método da requisição', 'Código do Status', 'Endereço IP', 'Data'...
- Ao clicar com o botão direito do mouse na primeira linha (onde estão os nomes das colunas) podem ser alterados os dados das requisições que serão mostrados
- Ao realizar uma requisição HTTP, normalmente é retornado pelo servidor uma resposta em formato HTML, que seria a página da web
- Cada novo recurso (seja Javascript, CSS, imagens) é uma nova requisição que o navegador efetua

#### Método GET do HTTP:

- É utilizado para **receber informações**, sem modificar algo no servidor

#### Código de resposta (Status):

- 200: OK
- 301: Moved Permanently
- 404: Not Found
- 500: Internal Server Error

#### Redirecionando entre sites:

- Ao realizar uma requisição ao alura utilizando HTTP, automaticamente é chamado o site seguro HTTPS
- Isso acontece pois o servidor retorna o 'Status' 301, com a nova localização
- Esse comportamento é chamado de *Redirecionamento pelo navegador*, ou **Redirecionamento no lado do cliente**
- Quando ocorre esse comportamento (Status 301), é adicionado também o cabeçalho 'Location', que indica para onde o navegador realizará uma nova requisição

### Atividade 03 - Código de sucesso:

- A tabela completa de mensagens HTTP pode ser vista em: https://www.w3schools.com/tags/ref_httpmessages.asp

### Atividade 05 - Depurando os códigos de resposta HTTP:

#### Status Code:

- 2xx: Successful responses
- 3xx: Redirection messages
- 4xx: Client error responses
- 5xx: Server error responses

### Atividade 11 - Para saber mais: Mais códigos HTTP:

- https://httpstatusdogs.com/
- https://http.cat/

- https://httpstatuses.com/


## Aula 06 - Parâmetros da requisição

### Atividade 03 - Parâmetros na requisição com métodos GET e POST:

- O parâmetro na URL é indicado após o caractere '?'
- Pode-se concatenar vários parâmetros utilizando o caractere '&'

#### Parâmetros com Método GET:

- Uma característica da requisição 'GET' é enviar os parâmetros pela URL. Isso é útil caso a URL queira ser guardada, ou compartilhada
- **Ex.:** `https://www.youtube.com/results?search_query=Algum+Video`, onde o parâmetro é 'search_query'

#### Parâmetros com Método POST:

- Com o Método 'POST' o navegador envia os dados no corpo da requisição, e não na URL

### Atividade 09 - Para saber mais: Outros métodos HTTP e Web Services:

#### Web Service:

Um Web Service disponibiliza uma funcionalidade na web, através do protocolo HTTP

- Os dados de um Web Service não são retornados em HTML; eles são retornados num formato independente da visualização, como XML ou JSON

### Atividade 10 - O que aprendemos?

- GET: Receber dados (params na URL)
- POST: Submeter dados (params no corpo da requisição)
- DELETE: Remover um recurso
- PUT: Atualizar um recurso

- Ao desenvolver aplicações web, na maioria dos casos utiliza-se apenas 'GET' e 'POST'. Já quando trabalha-se com serviços (Web Services), são frequentemente utilizados os métodos 'DELETE' e 'PUT'


## Aula 07 - Serviços na web com REST

### Atividade 01 - Serviços Web -REST:

- As aplicações que disponibilizam serviços para outras são chamadas de webservices
- Uma API de utilização é documentada para uma integração eficiente entre sistemas
- Um serviço (web service) normalmente envia o retorno no formato em XML/JSON

#### XML (eXtensible Markup Language):

- Linguagem de marcação que trabalha com dados em um modelo hierárquico

#### JSON (Javascript Object Notation):

- Notação Javascript para Orientação a Objetos, baseado em 'chave-valor' e array
- No lado do cliente (aplicação), pode-se indicar o formato de resposta que é aceita pelo servidor

### Atividade 05 - O que é REST?:

- A mesma URI pode ser utilizada, desde que seja alterado o Método
- A arquitetura REST une a URI ao Método e à Ação

#### REST (REpresentational State Transfer):

Modelo arquitetural REST:
- Recurso (URI)
- Operações (GET/POST/PUT/DELETE)
- Representação (JSON/XML/HTML)

#### Recurso:

- As URIs representam recursos, não ações
- Em sistemas REST, nossas URIs devem conter apenas substantivos, que são nossos recursos

#### Operações:

- GET: recupera informações sobre o recurso identificado pela URI. Ex: listar restaurante, visualizar o restaurante 1. Uma requisição GET não deve modificar nenhum recurso do seu sistema, ou seja, não deve ter nenhum efeito colateral, você apenas recupera informações do sistema.
- POST: adiciona informações usando o recurso da URI passada. **Ex:** adicionar um restaurante. Pode adicionar informações a um recurso ou criar um novo recurso.
- PUT: adiciona (ou modifica) um recurso na URI passada. **Ex:** atualizar um restaurante.
- DELETE: remove o recurso representado pela URI passada. **Ex:** remover um restaurante.

#### Representação:

- Quando fazemos uma aplicação não trafegamos um recurso pela rede, apenas uma representação dele. E essa representação pode ser feita de diferentes formas como JSON, XML ou HTML.

### Atividade 08 - O que aprendemos?

- REST é um padrão arquitetural para comunicações entre aplicações
- Ele aproveita a estrutura do HTTP
- Recursos são definidos via URI
- Operações com métodos HTTP(GET/POST/PUT/DELETE)
- Cabeçalhos(Accept/Content-Type) são usados para especificar as representações(JSON,XML,...)

### Atividade 09 - Para saber mais: tipos de dados:

- Em alguns cabeçalhos do HTTP devemos especificar algum formato. Os formatos são chamados na documentação de **MIME types**. E na definição do cabeçalho usamos a seguinte estrutura: tipo/subtipo.

São tipos conhecidos:

`text, image, application, audio e video`

E alguns subtipos:

`text -> text/plain, text/html, text/css, text/javascript
image -> image/gif, image/png, image/jpeg
audio -> audio/midi, audio/mpeg, audio/webm, audio/ogg, audio/wav
video -> video/mp4
application -> application/xml,  application/pdf`

- Outros formatos: https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types


## Aula 08 - HTTP2 - Por uma web mais eficiente

### Atividade 01 - HTTP2 - Dados binários, GZIP ativo e TLS:

#### CURL:

- Programa que efetua uma requisição de fora do browser
- `curl -v www.dominio.com`: faz uma requisição "verbosa" ao site digitado. Essa chamada mostra dados HTTP como a requisição, URL, usuário que realizou a chamada, além da resposta do servidor e os headers da 'Request' e da 'Response'
- O conteúdo HTML (corpo da resposta) é comprimido pelo GZIP, cujo objetivo é diminuir a quantidade de informações trafegadas (principalmente nos 'Smartphones')

- O HTTP2 não envia texto puro, envia binário
- O HTTP2 possui outro algoritmo para compressão dos dados binários, chamado HPACK
- Além disso, o HTTP2 também criptografa os dados com TLS
