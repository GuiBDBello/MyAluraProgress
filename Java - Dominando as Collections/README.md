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

- No Eclipse, selecione a caixa de busca *Quick Access* e digite *gcuf* para encontrar o atalho de *Generate Constructor Using Fields*;

## Aula 03 - Relacionamentos com coleções

### Atividade 01 - Relacionamentos com coleções:

- **Dica.:** É possível criar uma variável local ao utilizar `Ctrl + 1` em um *statement*;
- Quando for retornar referências de objetos, o ideal é retornar uma cópia, ou um objeto imutável;
- `Collections.unmodifiableList(aulas);`: retorna uma coleção de aulas *read-only*;
- Ao tentar modificar uma coleção *unmodifiable*, ocorre uma exceção em runtime `java.lang.UnsupportedOperationException`;
