# Eclipse: Produtividade Extrema na IDE com Java

## Aula 01 - Menos erros, mais produtividade

### Atividade 01 - Menos erros, mais produtividade:

- `Ctrl + M`: maximiza a janela com foco.
- Digite `main` e pressione `Ctrl + Space` e `Enter`: gera o método `public static void main(String[] args)`.
- Digite `new Obj` e pressione `Ctrl + Space`: gera o construtor da classe que inicia com o nome `Obj`. É possível navegar entre os atributos do construtor com a tecla `Tab` e a tecla `Esc` sai da navegação.
- Se uma variável não existe, pressione `Ctrl + 1` e selecione `Create local variable`. Isso também importa as classes necessárias automaticamente.
- Se um valor não foi atribuído à uma variável, vá até sua linha, pressione `Ctrl + 1` e selecione `Assign statement to new local variable`.
- Digite `syso` e pressione `Ctrl + Space` para abreviar a criação do método `System.out.println()`.
- `Ctrl + F11`: executa o método `main`.
- `F3`: abre a classe em que o cursor está sobreposto.
- `Ctrl + Page Down` e `Ctrl + Page Up`: troca de aba.

### Atividade 03 - (Obrigatório)Instalação do Eclipse e do projeto:

- Importar um projeto: `Ctrl + 3` e comece a digitar `existing projects into workspace` até que a opção de Import apareça, então pressione `Enter`.

### Atividade 06 - Instanciando a data de nascimento:

- `Ctrl + .`: move o cursor para o erro mais próximo.

### Atividade 07 - Impressão do funcionário:

- Digite `syserr` e pressione `Ctrl + Space` para abreviar a criação do método `System.err.println()`.
- Digite `systrace` e pressione `Ctrl + Space` para abreviar a criação do método `System.out.println("Classe.metodoAtual()")`.
- `Alt + Shift + X`: executar a classe.
- `Alt + Shift + X` + `J`: executar a classe como *Java application*.

### Atividade 08 - Navegando nas abas do editor:

- `Ctrl + F6`: seleciona uma das classes abertas no editor e vai até ela.

## Aula 02 - Gerando conteúdo eficientemente

### Atividade 01 - Gerando conteúdo eficientemente:

- `Ctrl + N`, digite `class` e pressione `Enter`: abre o wizard para criar uma nova classe.
- `Shift + Tab`: navega ao campo anterior.
- `Alt + Shift + A`: ativa o modo de seleção em bloco. Com esse modo, é possível editar várias linhas ao mesmo tempo. Para isso, segure a tecla `Shift` e mova o cursor com as setas.
- `Ctrl + 3`: como se fosse uma "busca" no Eclipse. Permite chamar qualquer menu por uma parte de seu nome ou por suas iniciais. **Ex.:** Digite "`Ctrl + 3` e `ggas`" para aparecer a opção *Generate Getters and Setters*.
- `Ctrl + Alt + Seta para baixo`: copia a linha atual para a linha abaixo. Se utilizar a tecla `Seta para cima`, copia a linha atual para a linha acima.

### Atividade 05 - Gerando getters e setters:

Existem várias maneiras de fazer o que desejamos no Eclipse, para escolhermos aquela que nos torna mais produtivos.

No caso dos getters e setters, além do menu podemos, por exemplo:

- Com o cursor em cima do nome do atributo, Ctrl+1 e "Create getter e setter for 'nomeDoAtributo'"
- Com o cursor em cima do nome do atributo, Alt+Shift+T e selecione Encapsulate Field, ou Ctrl + 3 encapsulate (ou ef). Nesse caso além dos getters e setters criados, os usos atuais do atributo podem ser mudados pra usar os getters/setters
- Dentro da classe, numa linha em branco fora de método, digite get ou set e escolha o getter/setter desejado

## Aula 03 - Melhorando a organização

### Atividade 01 - Melhorando a organização:

- `Ctrl + Shift + F`: identa e formata seu código.
- `Alt + Shift + R`: refatorar a palavra/classe/variável em que o cursor se encontra.
- `Alt + Seta para cima` e `Alt + Seta para baixo`: move o conteúdo da linha em que o cursor se encontra.
- `Alt + Shift + M`: extrai o código selecionado para um método.

### Atividade 09 - Refatorando no eclipse:

- `Alt + T`: abre o menu de refatoração.

Dentre as várias refatorações possíveis, podemos destacar:

- *Rename* (`alt + shift + R` ou `ctrl + 2 R`) - para melhorar o nome de algum elemento
- *Extract Method* (`alt + shift + M`) - para extrair um método de um código já existente
- *Extract Variable* (`alt + shift + L`) - para extrair uma variável a partir de alguma expressão
- *Move* (`alt + shift + V`) - para mover algum elemento para um lugar onde ele faça mais sentido
- *Change Method Signature* (`alt + shift + C`) - para mudar a assinatura de um método, adicionando, removendo ou reordenando parâmetros, trocando o tipo de retorno, mudando o nome, etc.
- *Inline* (`alt + shift + I`) - É o contrário do Extract Method/Variable. Para substituir uma chamada de método pelo seu corpo

## Aula 04 - Localizando de forma eficiente

### Atividade 01 - Localizando de forma eficiente:

- `Ctrl + Shift + R`: localiza e abre um recurso de um projeto aberto.
- `Ctrl + Shift + T`: localiza e abre uma classe de um projeto aberto. É possível abreviar as palavras, utilizando apenas as letras maiúsculas (caso a classe tenha o nome escrito em *camel-case*).
- `F3`: abre a classe sob o cursor em uma nova janela, ou vai até a declaração de uma variável ou método.
- `Ctrl + O`: abre uma caixa de diálogo com todos os membros da classe.
- `Ctrl + T`: mostra as implementações disponíveis de uma classe, ou todas as classes que sobrescrevem um método.
- `Alt + Seta para a esquerda`: volta para a referência anterior.
- `Alt + Seta para a direita`: avança para a próxima referência.
- `Ctrl + Shift + G`: (*Find Usages*) mostra os lugares onde um método é utilizado.
- `Ctrl + Alt + H`: (*Call Hierarchy*) mostra os usos de um método, e também outros métodos que o invocam.
- `Ctrl + F`: busca dentro do arquivo aberto na janela atual.
- `Ctrl + J`: busca incremental. `Ctrl + K` vai até a próxima palavra e `Ctrl + Shift + K` volta à palavra anterior.
- `Ctrl + H`: busca em vários arquivos, em uma pasta ou em todo *workspace*. `Ctrl + .` vai ao próximo resultado e `Ctrl + ,` volta ao resultado anterior.

### Atividade 04 - Encontrando métodos da classe mãe:

- `Ctrl + O` + `Ctrl + O` (duas vezes): mostra os métodos e atributos herdados pela classe.

### Atividade 05 - Diferenciando atributos de métodos:

- Ao pressionarmos `ctrl + O`, como o Eclipse faz para diferenciar os diversos tipos de membros de nossa classe, como atributos, métodos e construtores?

O Eclipse usa diversos símbolos para cada tipo de membro:
- **Quadrados vermelhos** para membros que são private;
- **Círculos verdes** para membros que são public;
- **Losangos amarelos** para membros que são protected;
- **Triângulos azuis** para membros que são default;

A diferenciação entre atributos e métodos é feita através do tamanho do símbolo, pequeno para atributos, grande para métodos. Além disso também são utilizadas letras para elementos especiais, como construtores, onde além do desenho também aparece a letra C.

### Atividade 09 - Outras formas de ver hierarquias:

- Enquanto o `ctrl + T` mostra uma tela com a hierarquia, o `F4` e o `ctrl + alt + H` abrem uma *view* com a hierarquia e os membros do tipo consultado.
- O `ctrl + alt + H` tem a vantagem de buscar qualquer tipo para sabermos sua hierarquia.

### Atividade 10 - Buscando referências:

- Os atalhos terminados em G são um pouco relacionados, todos tem a ver com busca de um termo qualquer no workspace.
- `ctrl + G`: Busca a declaração de um termo (classe, atributo, método) no workspace.
- `ctrl + shift + G`: Busca os usos de um termo no workspace, em arquivos Java.
- `ctrl + alt + G`: Busca o termo textualmente, em todos os arquivos da workspace.

## Aula 05 - Mais flexibilidade ao gerar conteúdo

### Atividade 01 - Mais flexibilidade ao gerar conteúdo:

- `Ctrl + 3` e digite `equals` ou `Alt + Shift + S`: *Generate hashCode() and equals()...*.
- `Ctrl + Shift + W`: fecha todas as janelas de editores abertas.
- `Alt + Shift + T`: Abre o menu **Refactor**. Vá em *Extract superclass...* para extrair a superclasse.

## Aula 06 - Escrevendo Menos Código com Templates

### Atividade 01 - Escrevendo Menos Código com Templates:

- `Ctrl + 3` e digite `delegate`: *Generate Delegate Methods*.
- O *Eclipse* gera estruturas de código, como:
1. O método `main`;
2. Várias estruturas de `for` diferentes, e `foreach`;
3. Várias formas de imprimir o conteúdo, `syserr`, `sysout`, `systrace`;
4. `while`, `if`, e vários outros;
- Todas essas "estruturas de código" pré-configuradas são **templates**. São pequenas estruturas de código configuráveis utilizadas para criar trechos pré-definidos.
- Para consultar os **templates** existentes, acesse `Window > Preferences > Java > Editor > Templates`.
- É possível criar um **template** na janela do item acima, clicando no botão `New...`. Então, dê um nome, selecione o contexto (escopo) em que o **template** pode ser utilizado, dê uma descrição a ele e em `Pattern` coloque o bloco de código deste. É possível, também, utilizar variáveis do *Eclipse* dentro do campo `Pattern`, para deixar o **template** dinâmico.
- **Ex.:** `private static final ${type:newType(org.apache.log4j.Logger)} logger = Logger.getLogger(${enclosing_type});`
- É possível também colocar um `javadoc` no **template**.

### Atividade 06 - Criando seu próprio template:

```
for (${iterable_type} ${iterable_element} : ${iterable}) {
    System.out.println(${iterable_element});${cursor}
}
```

## Aula 07 - Explorando Views e perspectivas

### Atividade 01 - Explorando Views e perspectivas:

- Na *View* *Package Explorer*, selecione o ícone com duas setas (*Link with Editor*) para facilitar encontrar classes abertas na *View* *Editor*.
- Na *View* *Problems* aparecem os *warnings* e *errors* do projeto. O atalho `Ctrl + 1` permite corrigir os *warnings* que possuem o ícone da lâmpada (*quick fix*/correção automática).
- A *View* *Javadoc* mostra o `javadoc` do item onde o cursor se encontra.
- A *View* *Declaration* mostra a declaração do item onde o cursor está posicionado, o que possibilita ver o código de uma classe sem precisar abrí-la.
- A *View* *Task List* pertence a um plugin chamado **Mylin**, que é um gerenciador de tarefas capaz de se comunicar com ferramentas como o *Jira*, *Bugzilla* e o *Track*. 
- A *View* *Outline* mostra o perfil de uma classe, ou seja, seus membros. É visível também pelo atalho `Ctrl + O`.

#### Comentários especiais:

- `//TODO`: algo que precisa ser feito.
- `//FIXME`: algum bug que precisa ser corrigido.
- `//XXX`: algo que precisa ser refatorado.
- Essas são *task tags*, e você pode definir suas próprias com `Ctrl + 3` e digite `task tags`.
- A *View* *Tasks* lista todas as tarefas criadas a partir dos comentários especiais do código.

#### Local history:

- O *Eclipse* guarda as alterações que você fez em um arquivo no *local history*.
- Para acessá-lo, clique com o botão direito do mouse sobre uma classe e selecione `Compare With > Local History...`. Selecione uma versão para ver as diferenças.

#### Perspectiva:

- Agrupamento de *Views* para uma determinada fase ou tipo de desenvolvimento de software.
- `Ctrl + F8`: altera a perspectiva ativa.

### Atividade 08 - Melhor uso das perspectivas:

- *Java*: Criação de novas classes, interfaces, enums
- *Java EE*: Criação e configuração de EJBs, WebServices, Servlets
- *Java EE*: Criação de projetos robustos, compostos de vários módulos
- *JPA*: Criação e configuração de entidades
- *Web*: Criação de arquivos JSP, CSS, HTML, Javascript
- *Debug*: fazer o debug de aplicações
- *Team Synchronising*: interagir com o sistema de controle de versão

## Aula 08 - Testando e Debugando sua aplicação

### Atividade 01 - Testando e Debugando sua aplicação:

- `Ctrl + N`, digite `junit` e selecione `JUnit Test Case` em uma classe para criar o teste dessa classe (altere apenas o *source folder*).
- `Ctrl + F11` ou `Alt + Shift + X` e depois `T`: executa uma classe de teste.
- `Ctrl + Alt + Seta para baixo`: duplica um bloco de código para baixo.

#### Debug:

- *Breakpoints*: dê dois cliques na barra azul do lado esquerdo do editor para adicionar um *breakpoint*, ou utilize o atalho `Ctrl + Shift + B`.
- `Alt + Shift + D` e `T`: executar em modo de debug.
- `F6`: executa a linha atual e vai para a próxima linha.
- É possível ver o valor das variáveis na *View* *Variables* ou colocando o mouse sobre a mesma.
- `F5`: vai até a primeira linha do próximo método que o *Java* executaria.
- `Ctrl + R`: (*run to line*) pula até a linha onde o cursor está.
- `Ctrl + Shift + D`: abre um pop-up com o valor retornado por uma expressão antes de executá-la. Se pressionado novamente, é aberta a *View* *Display*, onde é possível executar qualquer código.
- `Ctrl + Shift + I`: abre um pop-up com o valor da inspeção selecionada. Se pressionado novamente, é aberta a *View* *Expressions*, onde podemos acompanhar o valor de expressões de código.
- `F7`: retorna ao método externo.
- `F8`: resume até o final ou até o próximo *breakpoint*.
- `Ctrl + F2`: para a execução atual.
