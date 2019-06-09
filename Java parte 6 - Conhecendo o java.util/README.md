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
