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
