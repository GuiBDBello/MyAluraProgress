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
