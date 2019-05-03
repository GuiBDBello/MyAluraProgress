# Unity parte 3: Criando um chefão e refinando o jogo

## Aula 01 - Kit Médico

### Atividade 06 - Zumbi gerar Kit Médico:

- `Random.value`: retorna um número decimal entre 0 e 1;
- `if (Random.value <= porcentagem) { }`: verifica se o valor aleatório é válido, em que 'porcentagem' deve ser um número decimal de ponto flutuante entre 0 e 1;
- `Destroy(objeto, tempo);`: método que destrói um Objeto 'objeto' após passar 'tempo' segundos;

#### Unity IDE:

- Na Unity, é possível 'travar' uma janela, para que ela não seja alterada ao selecionar outros Objetos, clicando no ícone de "Cadeado" no topo dessa janela;


## Aula 02 - Interface

### Atividade 01 - Quantidade de Zumbis Mortos:

- `GameObject.FindObjectOfType(typeof(Script)) as Script;`: retorna um 'Script' do tipo 'GameObject', e converte esse Objeto em 'Script';