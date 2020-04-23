# Java: Dominando as Collections

## Aula 01 - Trabalhando com ArrayList

### Atividade 01 - Trabalhando com ArrayList:

- `ArrayList`: é um tipo genérico de dados em Java. É possível especificar seu tipo, da seguinte forma: `ArrayList<String>`;
- **Ex.:** `ArrayList<String> aulas = new ArrayList<String>();`
- `aulas.add("")`: adiciona um elemento à lista criada;
- Ao *printar* a lista no console, é chamado o método `toString` herdado de `AbstractCollection`, que concatena todos elementos da lista antes de mostrá-los;
- `aulas.remove(0)`: remove o primeiro elemento da lista. É possível também passar no parâmetro o objeto/instância do elemento a ser removido;
- O Eclipse possui um *autocomplete* para a palavra `foreach` (e pressionar `ctrl + espaço`), que cria um laço iterando a coleção mais próxima;
- `aulas.get(0)`: obtém o primeiro elemento da lista;
- `aulas.size()`: diferente de um *array*, que utiliza a palavra-chave `length`, uma coleção utiliza o método `size()` para retornar sua quantidade de elementos;
- `aulas.forEach(action)`: performa uma ação (implementação da interface `Consumer`) para cada elemento da coleção;
- **Ex.:** `aulas.forEach(aula -> { System.out.println("percorrendo :" + aula); });`
- A classe `Collections` possui diversos métodos estáticos e pode ser utilizada para ordenar coleções;
- **Ex.:** `Collections.sort(aulas)`: ordena a lista `aulas` por ordem alfabética;

## Aula 02 - Listas de objetos

### Atividade 01 - Listas de objetos:

- `Collections.sort()` sabe ordenar Strings, mas não `Aula`. Isso ocorre pois a classe `String` possui um método chamado `compareTo()`;
- `string1.compareTo(string2);`: retorna um número negativo se `string1` for "menor" que `string2`, retorna um número positivo se `string2` for menor que `string1` ou retorna zero se ambas forem iguais;
- Para comparar uma Aula, é necessário adicionar a seguinte linha à classe `Aula`: `implements Comparable<Aula>` e sobrescrever o método `int compareTo(Aula outraAula)`;
- Para comparar por mais de um critério, o método `sort()` possui uma implementação que aceita mais de um parâmetro, sendo o segundo um `Comparator`:
- **Ex.:** `Collections.sort(aulas, java.util.Comparator.comparing(Aula::getTempo));`
- Outra forma de realizar a mesma coisa é a seguinte:
- **Ex.:** `aulas.sort(Comparator.comparing(Aula::getTempo));`

#### Quick Access:

- No Eclipse, selecione a caixa de busca *Quick Access* (ou pressione `Ctrl + 3`) e digite *gcuf* para encontrar o atalho de *Generate Constructor Using Fields*;

## Aula 03 - Relacionamentos com coleções

### Atividade 01 - Relacionamentos com coleções:

- **Dica.:** É possível criar uma variável local ao utilizar `Ctrl + 1` em um *statement*;
- Quando for retornar referências de objetos, o ideal é retornar uma cópia, ou um objeto imutável;
- `Collections.unmodifiableList(aulas);`: retorna uma coleção de aulas *read-only*;
- Ao tentar modificar uma coleção *unmodifiable*, ocorre uma exceção em runtime `java.lang.UnsupportedOperationException`;


## Aula 04 - Mais práticas com relacionamentos

### Atividade 01 - Mais práticas com relacionamentos:

- `List<Aula> aulas = new ArrayList<>(aulasImutaveis);`: cria uma nova lista `aulas` utilizando como base a lista `aulasImutaveis`;

### Atividade 06 - Outros métodos de Collections.:

- `Collections.reverse()`: inverte a ordem de uma lista;
- `Collections.shuffle()`: embaralha aleatoriamente a ordem de uma lista;
- `Collections.singletonList()`: devolve uma lista imutável que contêm um único elemento especificado;
- `Collections.nCopies()`: retorna uma lista imutável com a quantidade escolhida de um determinado elemento;


## Aula 05 - O poder dos sets

### Atividade 01 - O poder dos sets:

- `Set` (conjunto): estrutura de dados semelhante à lista (também herda de `Collection`) que armazena seus elementos sem uma ordem determinada;
- **Ex.:** `Set<String> alunos = new HashSet<>();`
- Em um `Set` não há garantia na ordem dos elementos que o compõe. Por não possuir essa ordenação, um `Set` não possui métodos de acesso, como por exemplo o `get()`;
- Um `Set` não aceita elementos repetidos;
- A maior vantagem do `Set` é a velocidade em casos específicos, como na utilização dos métodos `contains()` e `remove()`;
- `Collections.sort()` só é aplicável para `List`;


## Aula 06 - Aplicando o Set no modelo

### Atividade 01 - Aplicando o Set no modelo:

#### Quick access:

- No Eclipse, selecione a caixa de busca *Quick Access* (ou pressione `Ctrl + 3`) e digite *ggas* para encontrar o atalho de *Generate Getters and Setters*;

### Atividade 05 - Collections.emptySet():

- `Set<String> nomes = Collections.emptySet();`: cria um conjunto vazio;
- `nomes.add("Paulo");`: retorna a exceção `UnsupportedOperationException`, pois um conjunto destinado a ser vazio não pode ter um elemento;

### Atividade 06 - Para saber mais: Coleções threadsafe:

- `Set<Aluno> alunosSincronizados = Collections.synchronizedSet(alunos);`: retorna uma nova coleção que pode ser compartilhada entre threads sem perigos;


## Aula 07 - Equals e hashcode

### Atividade 01 - Equals e hashcode:

- Ao comparar dois objetos, deve-se utilizar o método `equals()` da classe `Object`. Esse método deve ser sobrescrito em sua classe para realizar a comparação desejada;
- Como o `equals()` recebe um `Object` como parâmetro, deve-se realizar um *cast* para o tipo desejado;
- **Ex.:**
```
@Override
public boolean equals(Object obj) {
	Aluno outro = (Aluno) obj;
	return this.nome.equals(outro.nome);
}
```
- Para evitar comparações com um `nome` nulo, deve-se adicionar programação defensiva no construtor do objeto:
- **Ex.:** `if (nome == null) throw new NullPointerException("nome não pode ser null");`
- Ao reescrever o método `equals()`, também é necessário reescrever o `hashCode()`;
- O método `hashCode()` é como se fosse um "identificador único" do objeto;
- A classe `String` já realiza uma implementação própria do `hashCode()`, como mostrado abaixo:
- **Ex.:**
```
@Override
public int hashCode() {
	return this.nome.hashCode();
}
```

### Atividade 05 - Para saber mais: O contrato do método equals:

- Existe um contrato mais avançado que devemos seguir para implementar um método `equals` eficiente: https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-
- No Eclipse você pode pressionar `Ctrl + 3` e digitar *equals*;


## Aula 08 - Outros sets e iterators

### Atividade 01 - Outros sets e iterators:

- `LinkedHashSet`: ao contrário de `HashSet`, o `LinkedHashSet` armazena os elementos na mesma ordem que forem inseridos;
- `TreeSet`: funciona apenas para classes que são `Comparable`. Armazena na ordem "natural" (léxica, para *Strings*) dos objetos. Possui até um construtor que recebe um `Comparator`;

#### Iterator:

- Antigamente, antes do Java 5, quando não havia uma forma de realizar um *enhanced for* (ou *for each*), era utilizado o `Iterator`;
- `Iterator`: objeto que todas coleções dão acesso que serve para **iterar** entre os objetos dentro da coleção;
- **Ex.:** `Iterator<Aluno> iterador = alunos.iterator();`
- `iterador.hasNext()`: pede ao `iterador` se há um próximo elemento na coleção;
- `iterador.next()`: devolve o próximo elemento da coleção;

#### Vector:

- Antigamente, no Java 1.2, existiam as *collections* "antigas", como a `Vector`;
- `Vector`: é muito parecida com `ArrayList`, mas ela é *thread-safe*;


## Aula 10 - Mapas

### Atividade 01 - Mapas:

- `Map<K,V>`: um mapa é uma estrutura de dados que associa uma chave (*key*) com um valor (*value*). A implementação mais comumente utilizada é o `HashMap`;
- **Ex.:** `Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();`
- `this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno)`: insere no mapa `matriculaParaAluno` o aluno `aluno` utilizando como chave o `numeroMatricula` do aluno. Se a chave já existir nesse mapa, o valor será substituído, perdendo o valor anterior;
- `matriculaParaAluno.containsKey(numero)`: retorna um `boolean` que representa se o mapa `matriculaParaAluno` possui um elemento com a chave `numero`;

#### Outras Implementações:

- O `HashMap`, como foi dito anteriormente, é uma das implementações mais usadas de `Map`. Mas temos outras como o `LinkedHashMap`, bastante parecido com o `LinkedHashSet`, que guarda a ordem de inserção. Ou seja, se fôssemos imprimir o `LinkedHashMap`, a impressão apareceria na ordem em que foi inserida.
- Outro exemplo de `Map`, porém muito antigo, é o `HashTable`, uma implementação bem antiga de `Map`, pouco usada mas que é uma *thread safe*. Ou seja, é seguro usá-lo em um programa que tenha programação concorrente. Porém, comumente, a pessoa que necessita de um `Map` *thread safe* estudará mais sobre `threads` e utilizará `HashMap`.

#### java.util:

- É muito importante lembrar de pesquisar no Javadoc do java.util, pois existe muita coisa já implementada e vários códigos reutilizáveis: não reinvente a roda!
- https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html

### Atividade 07 - Para saber mais: Chaves e Valores:

- *The Map interface provides three collection views, which allow a map's contents to be viewed as a set of keys, collection of values, or set of key-value mappings.*
- Ou seja, temos uma coleção de chaves, uma coleção de valores, e uma coleção das associações. O interessante é que podemos acessar cada uma das coleções. Para acessar apenas as chaves use o método `keySet()` do `Map`. Para acessar os valores existe o método `values()`.
- `Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();`: retorna um `Set` de `Entry` com os elementos do mapa;
- **Ex.:** `associacoes.forEach(associacao -> System.out.println(associacao.getKey() + " - " + associacao.getValue()));`
