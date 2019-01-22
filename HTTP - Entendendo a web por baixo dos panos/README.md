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
