# JMS e ActiveMQ: Mensageria com Java

## Aula 01 - Introdução ao Mensageria com ActiveMQ

### Atividade 01 - Introdução ao Mensageria com ActiveMQ:

- Não podemos perder um pedido só porque o sistema de geração de notas não funciona.
- Para evitarmos problemas de comunicação entre sistemas, precisamos desacoplá-los através de um bloco arquitetural que fica entre eles (*middleware*).
- O objetivo do *middleware* é desacoplar os dois lados, isto é, as duas aplicações.
- O *middleware* "empacota" os dados do pedido, guarda esses dados em uma mensagem e entrega essa mensagem depois. Isso é denominado de *Middleware* Orientado a Mensagem (*MOM*).
- Arquiteturamente desacoplado, e com uma comunicação **assíncrona**.

#### ActiveMQ:

- *Middleware* Orientado a Mensagem (*MOM*). Não é um servidor de aplicação, é um *Message Broker*.
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

### Atividade 07 - Para saber mais: Estilos de integração:

- https://www.enterpriseintegrationpatterns.com

Os 4 estilos são:
- Mensageria
- RPC
- Banco de dados compartilhado
- Troca de arquivos

## Aula 02 - Consumindo mensagens com JMS

### Atividade 01 - Consumindo mensagens com JMS:

- O *MOM* desacopla quem produz a mensagem (*producer*) de quem consome a mensagem (*consumer*).
- *JMS* (*Java Messaging Service*) é um padrão *JavaEE* de mensageria.
- `lookup`: Recurso muito comum em ambientes *JavaEE* para descobrir ou pegar um recurso que o servidor disponibiliza. É feito através da classe `InitialContext` que por sua vez se baseia no arquivo de configuração `jndi.properties`. Esse arquivo e essa classe fazem parte de um outro padrão *JavaEE*, o **JNDI** (*Java Naming and Directory Interface*).

#### JMS:

- `javax.jms.Connection`: Classe que estabelece uma conexão com o *ActiveMQ*.
- `javax.jms.ConnectionFactory`: Fábrica de `Connection`. A fábrica é fornecida pelo *MOM*. O *ActiveMQ* disponibiliza uma espécie de "registro", conhecido por `JNDI`, obtido através de `lookup`.
- `javax.naming.InitialContext`: Classe necessária para obter a `ConnectionFactory` do *MOM*.
- `(ConnectionFactory) context.lookup("ConnectionFactory");`: Utiliza o `InitialContext` para obter o `ConnectionFactory` do *MOM*. Retorna um `Object`, por isso é necessário o *casting* pra `ConnectionFactory`.
- É necessário abrir a conexão: `connection.start();`.
- E fechar a conexão, o contexto e a sessão: `connection.close();`, `context.close();` e `session.close()`.
- `javax.jms.Session`: Uma sessão pode ser criada à partir de uma conexão. É uma camada que fica entre a `Connection` e o `MessageConsumer`, e abstrai a parte de "trabalho transacional" e a confirmação do recebimento de mensagem. Além disso, também serve para produzir o `MessageConsumer`.

#### JNDI Support:

- https://activemq.apache.org/jndi-support
- Crie um arquivo `jndi.properties` em seu *classpath* (pasta `src` do projeto), com o seguinte conteúdo:
```
java.naming.factory.initial = org.apache.activemq.jndi.ActiveMQInitialContextFactory

# use the following property to configure the default connector
java.naming.provider.url = vm://localhost

# use the following property to specify the JNDI name the connection factory
# should appear as. 
#connectionFactoryNames = connectionFactory, queueConnectionFactory, topicConnectionFactry

# register some queues in JNDI using the form
# queue.[jndiName] = [physicalName]
queue.MyQueue = example.MyQueue


# register some topics in JNDI using the form
# topic.[jndiName] = [physicalName]
topic.MyTopic = example.MyTopic
```
- Altere a propriedade `java.naming.provider.url` para a instância do *ActiveMQ* que você quer utilizar. **Ex.:** `tcp://localhost:61616`
- Altere o nome da propriedade `queue.MyQueue` para `queue.financeiro`, e o valor da propriedade para `fila.financeiro` (que foi o nome da fila criada no *ActiveMQ* na aula passada).

#### Consumer:

- `javax.jms.MessageConsumer`: Consumidor do *JMS*.
- `connection.createSession(false, Session.AUTO_ACKNOWLEDGE);`: Retorna uma `Session`. O primeiro argumento define que não é necessário chamar `session.commit()` ou `session.rollback()`, o segundo argumento define que o recebimento da mensagem deve ser confirmada automaticamente.
- `session.createConsumer(fila)`: Retorna um `MessageConsumer`. O argumento `fila` representa um `Destination`.
- `javax.jms.Destination`: O destino representa o lugar concreto onde a mensagem será salva dentro do *MOM*. O *ActiveMQ* ou *MOM* em geral pode ter vários consumidores e receber mensagens de vários clientes. Para organizar o recebimento e a entrega das mensagens criamos destinos (`Destination`) no *MOM*.
- `Destination fila = (Destination) context.lookup("financeiro");`: Obtém a fila criada no *ActiveMQ* definida na propriedade `queue.xpto` do arquivo `jndi.properties`.
- `Message message = consumer.receive();`: Recebe uma mensagem.

#### Dica:

- `new Scanner(System.in).nextLine();`: Para a execução no local dessa linha e aguarda pelo *input*.

### Atividade 10 - Para saber mais: Rodar ActiveMQ em memoria:

- É possível subir o *ActiveMQ* a partir de uma aplicação *Java*. Para isso, basta alterar o arquivo `jndi.properties`:
```
#java.naming.provider.url = tcp://hostname:61616
java.naming.provider.url = vm://localhost
```
- Isso pode ser útil quando queremos ter as vantagens do *MOM* dentro de uma aplicação *web*, por exemplo, sem precisar manter uma instância separada do *ActiveMQ*.

## Aula 03 - Recebendo mensagens com MessageListener

### Atividade 01 - Recebendo mensagens com MessageListener:

- `javax.jms.MessageListener`: Fica esperando, de forma contínua, o recebimento de mensagens.
- Define um objeto que será responsável por receber e tratar a mensagem:
```
consumer.setMessageListener(new MessageListener() {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        System.out.println(textMessage.getText());
    }
});`
```
- *Docs* da *API* do *JMS*: https://s3.amazonaws.com/caelum-online-public/jms/jms-apidocs.zip
- A interface `Message` possui algumas subinterfaces, e uma dessas é a `TextMessage`. É possível obter o conteúdo de uma `TextMessage` com o método `getText()`.

### Atividade 05 - Para saber mais: Design Pattern Observer:

- **Ex.:**
```
botao.setActionListener(new ActionListener() { //classe anônima
    public void actionPerformed(ActionEvent event) {
        //tratamento do evento
    }
});
```
- Quando o botão for acionado ele notifica todos os listeners cadastrados. De forma mais genérica, um lado cria um evento (o botão) e tem um outro lado que recebe o evento (o `ActionListener`). Ambos estão desacoplados.
- O *JMS* segue o mesmo padrão de projeto *Observer*! A diferença é que *JMS* é remoto ou distribuído. Ou seja, no padrão *Observer* originalmente descrito no livro GOF, tudo acontece na memória, o *Observer* desacopla objetos. Com *JMS*, a comunicação entre *Producer* e *Consumer* é remota, desacoplamento arquitetural.
- Para fazer a comparação com o exemplo apresentado na pergunta: O botão seria um produtor de mensagem (ainda não criamos um produtor pelo *JMS*, apenas usamos o console de administração, isso vem no próximo capítulo). O `ActionListener` representa o `MessageListener` do mundo *JMS* e o `ActionEvent` seria a `Message`. Faz sentido?
- Mais informações sobre este padrão *Observer* na página do *Enterprise Integration Patterns*: http://www.enterpriseintegrationpatterns.com/patterns/messaging/ObserverJmsExample.html

## Aula 04 - Enviando e distribuindo mensagens com JMS

### Atividade 01 - Enviando mensagens e Competição entre Consumidores:

- `javax.jms.MessageProducer`: Produtor do *JMS*.
```
MessageProducer producer = session.createProducer(fila);
TextMessage message = session.createTextMessage("<pedido><id>123</id></pedido>");
producer.send(message);
```
- A fila entrega as mensagens apenas para um consumidor. Em caso de haver mais de um *Consumer* rodando ao mesmo tempo, a carga de mensagens é balanceada automaticamente.
