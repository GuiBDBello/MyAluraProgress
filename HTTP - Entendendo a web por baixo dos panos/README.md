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
