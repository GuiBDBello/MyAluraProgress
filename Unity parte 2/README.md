# Unity parte 2: Iluminação, interface e boas práticas

## Aula 01 - Interface na Unity

### Atividade 03 - Vida do Jogador:

#### Script:

- `void TomarDano() { Vida -= 30; }`: método que tira 'Vida' do 'Jogador';
- `Jogador.GetComponent<ControlaJogador>().TomarDano();`: acessa o Script "ControlaJogador" e executa o método 'TomarDano';

### Atividade 06 - Game Over pela Vida:

#### Script:

- `if (Vida <= 0) { /* Game Over */ }`: gera o "Game Over" quando o 'Jogador' estiver com a 'Vida' menor ou igual a zero;
- `void TomarDano(int dano) { Vida -= dano }`: diminui a 'Vida' do 'Jogador' baseado no 'dano';
- `int dano = Random.Range(20, 30);`: define um 'dano' variável que o 'Jogador' receberá;

### Atividade 09 - Slider de vida:

- Slider: barra de "rolagem" que contém um valor numérico. Pode ser utilizado para Menus, Barras de Vida e outros propósitos;
- Ao criar interfaces (UI), é recomendado utilizar o "Modo 2D" do editor. Para ativá-lo, clique no botão "2D", abaixo do título da aba "Scene";
- Remover o Objeto filho "Handle Slide Area";
- Value: propriedade que contém o valor da Slider;
- Para preencher a Slider completamente, selecione "Fill Area"  e, no "Inspector", zere os valores "Left" e "Right" do componente "Rect Transform";
- No Objeto filho de "Fill Area", "Fill", realizar o mesmo processo;
- Interactable: define se a Slider é interativa pelo input do usuário;
- Âncora: posição "fixa", relativa à tela, que um Objeto tem como referência para "acompanhar";

### Atividade 12 - Fazer a Slider Funcionar:

- Criar novo Script "ControlaInterface" e adicioná-lo ao "Canvas";
- "Min Value": o valor numérico mínimo do Slider;
- "Max Value": o valor numérico máximo do Slider;
- "Whole Numbers": define que a "Slider" conterá apenas números inteiros;

#### Script (ControlaInterface):

- `private ControlaJogador scriptControlaJogador;`: cria uma variável do tipo "ControlaJogador", que é o nome de um Script;
- `scriptControlaJogador = GameObject.FindWithTag("Jogador").GetComponent<ControlaJogador>();`: acessa os "Game Objects", busca o Jogador pela 'Tag' e retorna a referência do Script "ControlaJogador";
- `using UnityEngine.UI;`: importa a biblioteca que processa a Interface (UI) da Unity;
- `public Slider SliderVidaJogador;`: cria uma variável do tipo "Slider", que será a Vida do Jogador;
- `SliderVidaJogador.value = scriptControlaJogador.Vida;`: atualiza a "Slider de Vida" do Jogador. Deve ser inserido no método `AtualizarSliderVidaJogador()`;
- `SliderVidaJogador.maxValue = scriptControlaJogador.Vida;`: define a "Vida" inicial do Jogador. Deve ser inserido no método `Start()`;
- `public void AtualizarSliderVidaJogador() { }`: método que atualiza a "Vida" do Jogador. Deve ser chamado no método `TomarDano(dano)`;

#### Script (ControlaJogador):

- `public ControlaInterface scriptControlaInterface;`: cria uma variável do tipo "ControlaInterface", que referencia o Script "ControlaInterface";
- `scriptControlaInterface.AtualizarSliderVidaJogador()`: executa o método "AtualizarSliderVidaJogador". Deve ser chamado no método `TomarDano(dano)`;

### Atividade 14 - Embelezar a barra de vida:

- https://kenney.nl: site que contém pacotes de "Assets" pagos e gratuitos para utilizar no seu jogo;
- https://fonts.google.com: site que contém fontes gratuitas para utilizar no seu jogo;
- https://www.1001fonts.com: site que contém fontes gratuitas (possui filtro para uso comercial) para utilizar no seu jogo;
- Criar uma pasta "Interface" e jogar os "Assets" baixados nela;
- Para utilizar as imagens como *UI*, deve-se alterar a propriedade "Texture Type" delas, de 'Default' para 'Sprite';

#### Barra de Vida:

- Selecione o "Botao_Verde01" e altere o seu "Texture Type" para 'Sprite';
- Selecione "Fill" dentro do Objeto "Slider" e, no componente "Image", adicione a Sprite 'Botao_Verde01' à propriedade "Source Image";
- Para editar a imagem, será utilizado o "Sprite Editor", que serve para alterar as configurações dos Sprites;

#### Sprite Editor:

- Selecione uma Sprite e clique em "Sprite Editor";
- Border: define os "cortes" de um Sprite;
- Altere todos os campos de "Border" para 10 e clique em "Apply";
- No componente "Image" do Objeto "Fill", altere a propriedade "Image Type" para 'Sliced';
- Faça o mesmo processo no Objeto "Background", utilizando 'Botao_Cinza05', mas altere a propriedade "Color" para 'Vermelho' (utilize o *Color Picker*);

#### *9-slice scaling*:

- Técnica de redimensionamento de imagens que consiste em redimensionar proporcionalmente uma imagem, dividindo-a em um *grid* de nove partes;
- Cada parte do *grid* será redimensionada em apenas um eixo, minimizando a distorção ao redimensionar um Sprite;
- Topo-esquerda: inalterável;
- Topo-centro: redimensiona horizontalmente;
- Topo-direita: inalterável;
- Centro-esquerda: redimensiona verticalmente;
- Centro: redimensiona horizontalmente e verticalmente (proporcionalmente);
- Centro-direita: redimensiona verticalmente;
- Baixo-esquerda: inalterável;
- Baixo-centro: redimensiona horizontalmente;
- Baixo-direita: inalterável;

#### Script:

- `AtualizarSliderVidaJogador();`: método deve ser chamado no `Start()`, após atualizar o valor máximo ("maxValue") da Barra de Vida;

### Atividade 16 - Para saber mais - Pixels e Canvas:

#### Canvas:

- Controla como os elementos de interface serão renderizados;
- Todos os elementos de interface devem ser filhos do Canvas;
- *Screen Space Overlay*: modo de renderização que faz com que o Canvas seja renderizado por cima da tela do jogo. Preenche toda a tela e muda de tamanho de acordo com a tela;
- *Canvas Scaler*: muda o tamanho e densidade de pixels dos Objetos filhos do Canvas;
- Por padrão, os elementos de interface na Unity vem com a escala de 100 pixels para cada 1 unidade;
- https://docs.unity3d.com/Manual/UICanvas.html: documentação do Canvas;
- https://docs.unity3d.com/Manual/script-CanvasScaler.html: documentação do Canvas Scaler;
