# JMS e ActiveMQ: Mensageria com Java

## Aula 01 - Introdução ao Mensageria com ActiveMQ

### Atividade 01 - Introdução ao Mensageria com ActiveMQ:

- Não podemos perder um pedido só porque o sistema de geração de notas não funciona.
- Para evitarmos problemas de comunicação entre sistemas, precisamos desacoplá-los através de um bloco arquitetural que fica entre eles (*middleware*).
- O objetivo do *middleware* é desacoplar os dois lados, isto é, as duas aplicações.
- O *middleware* "empacota" os dados do pedido, guarda esses dados em uma mensagem e entrega essa mensagem depois. Isso é denominado de *Middleware* Orientado a Mensagem (*MOM*).
- Arquiteturamente desacoplado, e com uma comunicação **assíncrona**.

#### ActiveMQ:

- *Middleware* Orientado a Mensagem (*MOM*).
- **Obs.:** No Windows é preciso executar o script `InstallService.bat` no terminal da pasta `win32` ou `win64` antes de seguir os próximos passos.
- Acesse por linha de comando o diretório `{ACTIVEMQ_HOME}/bin/` (no *Windows* talvez seja preciso entrar na pasta `win32` ou `win64`) e execute `activemq start` ou `sh activemq console`. O comando inicia o *ActiveMQ* em *foreground*, útil para *debugging*. Também inicia o *WebConsole* no endereço `http://0.0.0.0:8161` ou `localhost:8161`.
- Acesse o *WebConsole*, clique em *Manage ActiveMQ broker* e utilize o usuário `admin` e senha `admin` para acessar.

##### WebConsole:

- *Connections*: Mostra as conexões ativas com o *MOM*.
- *Queues*: Destinos do *MOM*. As mensagens são enviadas primeiramente para uma fila, onde são armazenadas. O *ActiveMQ* organiza as filas.

###### Queues:

- Para criar uma fila, digite o nome desejado e clique em `Create`.
- Para enviar uma mensagem, em *Operations*, clique em `Send To`. Defina o *Destination*, o *Message body* e clique em `Send`.
- (*Windows*) `java -cp activemq-all-5.12.0.jar;aula-jms.jar br.com.caelum.TesteMensageria`: Executa a aplicação disponibilizada na aula. É possível consumir ou enviar mensagens, utilizando os parâmetros: `consome` e `envia X` (onde `X` é a quantidade de mensagens enviadas).
