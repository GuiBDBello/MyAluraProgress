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
