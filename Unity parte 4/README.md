# Unity parte 4 - Chefão, partículas e menu

## Aula 01 - Vida do Chefe

### Atividade 03 - Barra de Vida:

- É possível posicionar elementos da interface como se estivessem no cenário do jogo;
- 'Screen Space - Overlay': modo de renderização de um Canvas que renderiza os elementos da interface na "tela" do jogo;
- 'World Space': modo de renderização de um Canvas que renderiza os elementos da interface no espaço do "mundo" do jogo;

### Atividade 06 - Vida como Billboard:

- Billboard: sprite que sempre "olha" para a câmera;

#### Script (Billboard):

- `transform.LookAt(transform.position - Camera.main.transform.forward);`: define a rotação do Objeto como o oposto da direção que a câmera aponta, baseando-se em sua posição;

### Atividade 08 - Cor da Barra de Vida:

- Criar uma imagem com uma cor branca;
- Script;
- Atribuí-la ao Objeto 'Fill' (filho do 'Slider');
- Definir cor Máxima e Mínima;
- Inverter o efeito 'Billboard';
- Remover o Objeto 'Background' (filho do 'Slider');

#### Lerp:

- Linear Interpolation: alteração linear de um valor até outro;

#### Script:

- `public Image ImageSlider;`: obtém a referência da Slider utilizada na cena;
- `public Color CorDaVidaMaxima, CorDaVidaMinima;`: define (no Inspector) as cores que serão interpoladas;
- `float porcentagemDaVida = (float) Vida / VidaInicial;`: obtém um valor (entre 0 e 1) para representar a porcentagem da vida;
- `Color corDaVida = Color.Lerp(CorDaVidaMinima, CorDaVidaMaxima, porcentagemDaVida);`: interpola os valores, retornando a cor que representa a porcentagem entre as duas cores;
- `ImageSlider.color = corDaVida;`: altera a cor da Imagem;
