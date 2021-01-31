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
- `javax.jms.Session`: Uma sessão pode ser criada à partir de uma conexão. É uma camada que fica entre a `Connection` e o `MessageConsumer`, e abstrai a parte de "trabalho transacional" e a confirmação do recebimento de mensagem. Além disso, também serve para produzir o `MessageConsumer`. É o objeto responsável pela criação de diversos componentes do *JMS* como `Producer`, `Consumer`, `Browser` e implementações de `Message`.

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
- A fila entrega as mensagens apenas para um consumidor. Em caso de haver mais de um *Consumer* rodando ao mesmo tempo, a carga de mensagens é balanceada automaticamente. No mundo de padrões de integração esse modelo de entrega se chama *Competing Consumers*: http://www.enterpriseintegrationpatterns.com/patterns/messaging/CompetingConsumers.html

### Atividade 06 - Trabalhando de forma distribuída:

- Utilize o comando `ipconfig` (Windows) ou `ifconfig` (Unix) para obter o *IP* da máquina atual.
- Altere, no `jndi.properties`, o valor da propriedade `java.naming.provider.url` para o *IP* da máquina atual.
- Ambas as aplicações que representam o `Producer` e o `Consumer` devem possuir o mesmo *IP* configurado na propriedade acima.
- Mas essas configurações no `jndi.properties` podem variar de *MOM* para *MOM*, alguns precisam de autenticação e autorização, ou de alguma configuração a mais. No caso do *ActiveMQ*, é bem simples, basta colocar seu *ip*, o *ip* da sua máquina, no arquivo `jndi.properties` do produtor e dos consumidores.

### Atividade 08 - Para saber mais: Usando um Properties:

- Podemos usar duas formas de configuração do contexto *JNDI*:

1) Arquivo `jndi.properties`:
```
java.naming.factory.initial = org.apache.activemq.jndi.ActiveMQInitialContextFactory

java.naming.provider.url = tcp://192.168.0.94:61616

queue.financeiro = fila.financeiro
```
2) Classe Properties:
```
Properties properties = new Properties();

properties.setProperty("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
properties.setProperty("java.naming.provider.url", "tcp://192.168.0.94:61616");
properties.setProperty("queue.financeiro", "fila.financeiro");

InitialContext context = new InitialContext(properties);
```

## Aula 05 - Tópicos e assinaturas duráveis

### Atividade 01 - Tópicos e assinaturas duráveis:

- *Broadcast*: Enviar a mesma mensagem para vários consumidores.
- *Topics*: Diferente das *Queues*, os *Topics* são entregues para todos que têm interesse na mensagem.
- Criar um *Topic*: Vá no painel *web* do *ActiveMQ* e clique em *Topics*. Após, digite o *Topic Name* e clique em *Create*.

#### Tópico:

- Altere a propriedade `topic.MyTopic` do arquivo `jndi.properties` para `topic.loja`, e altere seu valor para `topico.loja`.
- Altere o `Destination` para `Topic` (incluindo o *casting*) e o parâmetro do `lookup` para `loja`.
- Não sabe quantos consumidores terá. É necessário avisá-lo quem receberá a mensagem.
- Por padrão, não armazena a mensagem. É necessário configurá-lo.
- `connection.setClientID("estoque");`: Identifica a conexão.
- No lugar de `MessageConsumer consumer = session.createConsumer(topico);`, é utilizado `MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura");`.
- É necessário executar ao menos uma vez o consumidor antes de enviar uma mensagem, para que essa `"assinatura"` fique registrada no *ActiveMQ* para que a mensagem seja armazenada até ser entregue na próxima vez que o consumidor estiver rodando.
- Agora, se existir diversos consumidores definidos (isso ocorre pela execução de um `cliendID` diferente) todos terão suas mensagens armazenadas até ser entregue.

## Aula 06 - Selectores e propriedades da Mensagem JMS

### Atividade 01 - Selectores e propriedades da Mensagem JMS:

- Uma fila e um tópico produzem a mensagem da mesma forma, porém entregam de formas diferentes.
- Se não houver ninguém "inscrito" no tópico, a mensagem será perdida.
- A fila faz **balanceamento** (divide as mensagens entre os consumidores), o tópico faz **difusão** (entrega todas as mensagens para todos os consumidores "inscritos").
- Na fila, o *Producer* também é conhecido por *Sender* e o *Consumer* por *Receiver*.
- No tópico, o *Producer* também é conhecido por *Publisher* e o *Consumer* por *Subscriber*.
- O *Subscriber* pode decidir não receber algumas mensagens que atingirem certas condições.

#### Selector:

- `session.createDurableSubscriber(topico, "assinatura", "messageSelector", false);`: Retorna um `Consumer`. O *MessageSelector* não pode validar um valor dentro do *body* da mensagem. Ele busca dentro dos cabeçalhos e seletores da mensagem. O código a seguir deve substituir a `String` `messageSelector`:
- **Ex.:** `"JMSType = 'car' AND color = 'blue' AND weight > 2500"`.
- **Ex.2:** `ebook is null OR ebook=false`.
- E, no *Producer* deve-se adicionar o seguinte código:
- **Ex.:**
```
TextMessage message = session.createTextMessage("<pedido><id>123</id><e-book>false</e-book></pedido>");
message.setBooleanProperty("ebook", true);
```
- O último parâmetro (`noLocal`) se referencia à conexão. O valor `false` define se deve receber mensagens da própria conexão. **Obs.:** Como nós utilizamos uma nova conexão para enviar as mensagens, isso não irá influenciar durante as aulas.

### Atividade 06 - Para saber mais: Selective Consumer:

- Novamente o *JMS* segue um padrão de integração, o *Selective Consumer*.
- http://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageSelector.html
- Uma desvantagem seria que a regra/condição do recebimento da mensagem está nos consumidores. Muitas vezes queremos centralizar essas regras no lado do servidor. Para isso não devemos usar *Selective Consumers* e sim apenas consumidores simples. No lado do servidor (*ActiveMQ*) aplicaríamos um filtro, central, que define se a mensagem pode passar ou não.
- E claro que existe também para isso um padrão de integração, o *Message Filter*: http://www.enterpriseintegrationpatterns.com/patterns/messaging/Filter.html
- O *JMS* e *ActiveMQ* não dão suporte ao este comportamento mas existem *brokers* mais sofisticados onde isso é possível. Exemplos disso são os *Enterprise Service Bus* (*ESB*) que implementam a maioria dos padrões de integração.
