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

### Atividade 04 - Texto e Cursos do Mouse:

- 'File > Build Settings... > Player Settings... > Default Cursor': define uma textura/sprite para substituir o cursor do mouse;
- 'File > Build Settings... > Player Settings... > Cursor hotspot': define um 'offset' que altera a posição do "clique" do cursor;


## Aula 03 - Polimento no Gerador

### Atividade 04 - Balanceando Quantidade de Zumbis:

#### Vincular novo Objeto:

- `Script script = Instantiate(objeto, posicao, rotacao).GetComponent<Script>();`: obtém a referência do Script de nome 'Script' utilizado no Objeto instanciado;
- `script.objetoScript = this;`: atribui à propriedade 'objetoScript' o Script em que esse código é executado. Nesse caso, o `this` retorna um Objeto do tipo Script;
- `if(Time.timeSinceLevelLoad > tempoProximoEvento) { tempoProximoEvento = Time.timeSinceLevelLoad + tempoDeCadaEvento; }`: realiza uma verificação para rodar um evento a cada 'tempoProximoEvento' segundos, onde 'tempoDeCadaEvento' é o tempo de espera entre os eventos;
