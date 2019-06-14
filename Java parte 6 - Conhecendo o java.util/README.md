# Java parte 6: Conhecendo o java.util

## Aula 01 - Conhecendo Arrays

### Atividade 02 - Começando com Arrays:

- Array é um Objeto, portanto, é necessário inicializá-lo utilizando a palavra `new`;
- **Ex.:** `int[] idades = new int[5];`
- O Array é inicializado com valores padrão, como uma Classe (int = 0, String = null);
- Para acessar uma posição do Array, utiliza-se colchetes e o número da posição;
- **Ex.:** `int idade1 = idades[0];`
- Ao tentar acessar uma posição que não existe, ocorre um `ArrayIndexOutOfBoundsException`;
- `idades.length;`: atributo de um Objeto do tipo Array que retorna o tamanho daquele Array;
- É possível fazer um laço com base num Array, utilizando-o como critério de parada;
- **Ex.:** `for(int i = 0; i < idades.length; i++) { }`

### Atividade 05 - Array de referências:

#### Revisão:

- Arrays são Objetos;
- É necessário delimitar explicitamente o tamanho e o tipo de um Array em sua inicialização;
- Um Array é inicializado com os valores padrões de seu tipo;
- A primeira posição de um Array é a posição [0];

#### Array de referências:

- Ao atribuir uma referência a um Array, é criado um "clone" da referência, que aponta ao mesmo Objeto em memória da referência original;
- Objetos =/= Referências;

### Atividade 09 - Forma literal:

- *Literal*, nesse contexto, significa usar valores diretamente, menos burocrático, mais direto;
- **Ex.:** `int[] refs = {1, 2, 3, 4, 5};`

### Atividade 10 - O que aprendemos?

- Um array é uma estrutura de dados e serve para guardar elementos (valores primitivos ou referências)
- Arrays usam colchetes (`[]`) sintaticamente
- Arrays têm um tamanho fixo!
- Um array também é um objeto!
- Arrays são zero-based (o primeiro elemento se encontra na posição `0`)
- Um array é sempre inicializado com os valores padrões.
- Ao acessar uma posição inválida recebemos a exceção `ArrayIndexOutOfBoundException`
- Arrays possuem um atributo `length` para saber o tamanho

## Aula 02 - Guardando qualquer referência

### Atividade 01 - Array do tipo Object:

- Type cast: utilizando parênteses, é possível realizar uma conversão do tipo de um dado `(Tipo) dado`;
- **Ex.:** `(String) cpf; (Object) ContaCorrente`
- `ClassCastException`: exceção que ocorre quando é utilizado *type cast* em uma Classe específica, para convertê-la para uma Classe mais genérica;
- Um Array de um tipo genérico pode receber seus tipos específicos (polimorfismo). Por exemplo, um Array de `Conta[]` pode receber `ContaCorrente` e `ContaPoupanca`;

### Atividade 03 - Cast explicito e implícito:

#### Cast explícito e implícito:

- Type Cast: conversão de um tipo para outro;

#### Cast implícito e explícito de primitivos:

- **Ex.:** `int numero = 3; double valor = numero; //cast implícito`
- **Ex.:** `int numero = 3; double valor = (double) numero; //cast explícito`

#### Cast implícito e explícito de referências:

- **Ex.:** `ContaCorrente cc1 = new ContaCorrente(22, 33); Conta conta = cc1; //cast implicito`
- **Ex.:** `ContaCorrente cc1 = new ContaCorrente(22, 33); Conta conta = (Conta) cc1; //cast explícito mas desnecessário`

### Atividade 08 - Entendendo o array String args:

- `String[] args`: parâmetros de inicialização da aplicação;
- Pelo Terminal, utiliza-se o comando `java nomeClasseCompilada.class arg1 arg2`;
- Pelo Eclipse, vá em 'Run > Run Configurations... > Arguments > Program arguments' e insira seus valores;


## Aula 03 - ArrayList e Generics

### Atividade 04 - Conhecendo ArrayList:

- `ArrayList`: pertence ao pacote java.util. Estrutura de dados que contém uma lista;
- **Ex.:** `ArrayList lista = new ArrayList();`
- `lista.add(Object objeto);`: permite adicionar a referência 'objeto' à próxima posição disponível do ArrayList 'lista';
- `lista.size();`: retorna a quantidade de referências adicionadas no ArrayList 'lista';
- `lista.get(int indice);`: retorna a referência na posição 'indice' do ArrayList 'lista';
- `lista.remove(int indice);`: remove a referência na posição 'indice';

#### Foreach:

- `for(Object o : lista) { }`: sintaxe do *foreach* em Java. "Para cada Objeto 'o' dentro de 'lista', faça...";

### Atividade 09 - Introdução ao Generics:

- `ArrayList<Conta> lista = new ArrayList<Conta>;`: cria uma lista que contém, especificamente, referências do tipo 'Conta'. Esses caracteres (`<>`), no Java, simbolizam *Generics*;

### Atividade 13 - Outras formas de inicialização:

#### Lista com capacidade predefinida:

- `ArrayList lista = new ArrayList(26); //capacidade inicial`: define, no construtor, um tamanho limitado à ArrayList 'lista';

#### Lista a partir de outra:

- `ArrayList nova = new ArrayList(lista); //criando baseado na primeira lista`: cria um novo ArrayList 'nova' inicializado com os valores do ArrayList 'lista';


## Aula 04 - Equals e mais listas

### Atividade 01 - O método equals:

- `lista.contains(objeto);`: retorna um boolean que representa se a referência 'objeto' está contida no ArrayList 'lista'. Esse método não compara o **conteúdo** dos objetos, ele compara se é o **mesmo objeto**. Esse método, internamente, chama outro método, o `lista.equals(objeto)`;
- Agora, no código, iremos sobrescrever o método `equals(Object)` para verificar se o conteúdo do objeto é igual ao conteúdo de outro objeto (ao contrário do código padrão, que verifica se é o **mesmo** objeto);

### Atividade 04 - List e LinkedList:

- Um ArrayList e um LinkedList compartilham vários métodos (`contains()`, `size()`, `remove()`, etc). Isso ocorre pois ambas Classes implementam a interface `List`;

#### ArrayList:

- Pros:
1. Fácil acesso em qualquer elemento, diretamente pelo índice;
2. Fácil adição de um elemento em qualquer posição;
3. Fácil iteração;
- Cons:
1. Capacidade limitada;
2. Ao remover um elemento, é necessário reorganizar toda a lista a partir do elemento removido;

#### LinkedList:

- Ao contrário do ArrayList, o LinkedList não utiliza um Array por baixo dos panos;
- Assim como todas listas, possui uma sequência de inserção/obtenção dos dados e índices para determinar as posições;
- Cada elemento de uma LinkedList possui uma referência para identificar qual é o elemento anterior e outra referência para o posterior;
- O primeiro elemento da lista é o elemento que não possui referência a um elemento anterior, e o último elemento não possui referência a um elemento posterior;
- Pros:
1. Fácil reorganização da lista, pois são alteradas apenas as referências do elemento anterior e próximo;
- Cons:
1. Toda busca na lista começa no primeiro elemento, vai ao próximo elemento da lista, e segue assim até encontrar o que busca;

### Atividade 08 - De Array para List:

- A Classe `java.util.Arrays` possui vários métodos estáticos auxiliares para trabalhar com arrays;
- **Ex.:** `List<String> argumentos = Arrays.asList(args);`


## Aula 05 - Vector e a interface Collection

### Atividade 01 - A alternativa threadsafe:

- `java.util.Vector`: Assim como a ArrayList, o Vector também utiliza um Array;
- Ao utilizar *Threads*, é necessário utilizar a Classe Vector. Nem ArrayList nem LinkedList são *thread safe*, apenas o Vector;
- É possível manipular uma lista de Vector através de várias pilhas de execução;
- Porém um Vector possui um custo maior de desempenho;

### Atividade 04 - A interface Collection:

- `java.util.List` aceita objetos duplicados, `java.util.Set` não aceita;
- Para entender melhor o Set, é necessário entender o método `hashCode()` da Classe Object;
- Um Set não é sequencial, como uma List;
- List e Set implementam a interface `Collection`;


## Aula 06 - As classes Wrappers

### Atividade 01 - Autoboxing e Unboxing:

- Arrays aceitam tipos primitivos e referências, enquanto Listas aceitam apenas referências;
- Ao adicionar um valor de tipo primitivo em uma Lista, o Java automaticamente cria um Objeto para armazenar esse valor. Essa transformação automática chama-se *Autoboxing*;

### Atividade 02 - Métodos da classe Integer:

- No Java, existe uma Classe para cada tipo primitivo;
- Essas Classes são chamadas de *Wrappers*, pois "embrulham" o tipo primitivo;
- Esses *Wrappers* pertencem ao pacote `java.lang`;

#### Integer:

- O construtor padrão, que recebe um int, está *deprecated*. A forma correta de se instanciar um Objeto Integer é utilizar o método estático `Integer.valueOf(int);`. Internamente, esse método instancia um Objeto do tipo `Integer`;
- `Integer.intValue();`: retorna o valor primitivo do Objeto. Essa conversão chama-se *Unboxing*;
- `Integer.valueOf(String);`: uma das sobrecargas do método `valueOf()`. Converte uma `String` para um `Integer`. Também conhecido por *Parsing*;
- `Integer.parseInt(String);`: realiza uma conversão de uma `String` para um tipo primitivo `int`;
- `Integer.doubleValue();`: converte o `Integer` em um `double`, retornando-o;
- `Integer.MAX_VALUE;`: retorna o maior valor possível que um `Integer` suporta (inverso de `Integer.MIN_VALUE`);
- `Integer.SIZE;`: retorna a quantidade de BITS de um `Integer`;
- `Integer.BYTES;`: retorna a quantidade de BYTES de um `Integer`;

### Atividade 06 - A classe Number:

- (8 bytes) `double`	-> `java.lang.Double`
- (4 bytes) `float`		-> `java.lang.Float`
- (8 bytes) `long`		-> `java.lang.Long`
- (4 bytes) `int`		-> `java.lang.Integer`
- (2 bytes) `short`		-> `java.lang.Short`
- (1 bytes) `byte`		-> `java.lang.Byte`
- (2 bytes) `char`		-> `java.lang.Character`
- 			`boolean`	-> `java.lang.Boolean`

#### Boolean:

- `Boolean.TRUE;`: atributo estático da Classe `Boolean` que retorna o valor `true` (inverso de `Boolean.FALSE`);

#### Number:

- `java.lang.Number`: Classe-mãe de todas Classes que utilizam números para representar seus valores. Através do Polimorfismo, é possível acessar um `Integer`, `Float`, `Double`... utilizando uma referência do tipo `Number`;


## Aula 07 - Ordenação de listas

### Atividade 01 - Ordenando listas:

#### Comparator:

- `Interface` Java, proveniente do pacote `java.util`;
- Para utilizá-la, deve-se criar uma nova Classe que implemente a `interface` Comparator, juntamente ao método `compare(T o1, T o2)`;
- `compare(T o1, T o2)`: verifica se um Objeto 'o1' do tipo 'T' é maior que 'o2', do mesmo tipo. É retornado um inteiro negativo, zero ou um inteiro positivo se o primeiro argumento é menor, igual ou maior que o segundo;
- `lista.sort(comparator);`: ordena uma `List` 'lista' baseada no critério definido na Classe do Objeto `Comparator` 'comparator';

#### Eclipse:

- Em `Source > Organize Imports` (ou utilize o atalho, `Ctrl + Shift + O`), todas as dependências necessárias são importadas e as dependências que não estão sendo utilizadas são removidas;
- `Ctrl + Shift + T`: atalho que abre uma janela e permite buscar uma Classe específica dentro das dependências do seu projeto;
- Ao digitar `foreach`, pressionar `Ctrl + Espaço` e pressionar `Enter`, o Eclipse cria um laço *foreach* utilizando uma `List` que se encontra próxima da linha atual;
