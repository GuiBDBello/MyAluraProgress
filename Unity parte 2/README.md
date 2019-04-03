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


## Aula 02 - Audio, Cenário e Iluminação

### Atividade 01 - Música no Jogo:

- Criar uma pasta "Audio" e jogar os "Assets" baixados nela;
- http://teknoaxe.com/Home.php: site que contém músicas gratuitas para utilizar no seu jogo;
- Criar um Objeto vazio (*Empty*) e nomeá-lo "ControlaAudio";
- Criar um Script de nome "ControlaAudio";

#### Audio Source:

- Em "ControlaAudio", adicione o componente "Audio Source";
- AudioClip: propriedade que contém o clipe de áudio a ser tocado pela fonte ("Audio Source");
- Adicione uma música ('You_Cant_Dodge_a_Laser_01') na propriedade "AudioClip" do componente "Audio Source" do Objeto "ControlaAudio";
- Loop: define se o "AudioClip" rodará repetidamente;
- O "Audio Source" apenas funciona pois o Objeto "Main Camera" já vem, por padrão, com um componente chamado "Audio Listener";

#### Script (ControlaAudio):

- `private AudioSource meuAudioSource;`: cria uma variável do tipo "AudioSource";
- `meuAudioSource = GetComponent<AudioSource>();`: dentro do método `Start()`, obtém a referência ao componente "Audio Source" do Objeto que contém o Script;
- `public static AudioSource instancia;`: cria uma variável estática, ou seja, que compartilha seu valor em todos os lugares que é utilizada;

#### Debug:

- No canto superior esquerdo da Unity, clique no ícone de Lista e selecione "Debug". Todas as variáveis privadas aparecerão, facilitando a vida do desenvolvedor;

#### Start e Awake:

- O método `Start()` é executado quando o Script é habilitado, antes do primeiro `Update()`;
- O método `Awake()` é executado antes do `Start()`, e mesmo se o Script não estiver habilitado. Cria referências entre os Scripts, inicialização;
- Tanto o `Start()` e o `Awake()` são chamados apenas uma vez durante o ciclo de vida de um Script em um Objeto. Ou seja, mesmo que o Script seja desabilitado e reabilitado, nenhum desses métodos será executado novamente;

### Atividade 04 - Sons do Jogo:

- Uma forma de tocar sons no jogo é armazená-los em variáveis do tipo "AudioClip" e chamá-los a partir de um "AudioSource";
- O método "PlayOneShot(AudioClip)" recebe como parâmetro um clipe de som, que é tocado apenas uma vez e é encerrado;

#### Script (ControlaJogador):

- `public AudioClip SomDeDano;`: cria uma variável que armazenará um clipe de som;
- `ControlaAudio.instancia.PlayOneShot(SomDeDano);`: acessa a variável estática "instancia" no Script "ControlaAudio" e executa o método "PlayOneShot(AudioClip)" da classe "AudioSource" que faz um "AudioClip" tocar uma vez só;

#### Script (ControlaArma):

- `public AudioClip SomDoTiro;`: cria uma variável que armazenará um clipe de som;
- `ControlaAudio.instancia.PlayOneShot(SomDoTiro);`: executa o método "PlayOneShot", tocando o "AudioClip" 'SomDoTiro';

#### Script (Bala):

- - `public AudioClip SomDeMorte;`: cria uma variável que armazenará um clipe de som;
- `ControlaAudio.instancia.PlayOneShot(SomDoTiro);`: executa o método "PlayOneShot", tocando o "AudioClip" 'SomDoTiro';

### Atividade 08 - Aumentando o Cenário do Jogo:

#### Rotacionando Colisor:

- Crie um Objeto vazio (*Empty*) dentro do Objeto que receberá o Colisor;
- Crie um "Collider" (**Ex.:** "Box Collider") no Objeto;
- No componente "Box Collider", selecione a engrenagem e clique em "Copy Component";
- Remova o Colisor;
- No Objeto vazio, no componente "Transform", selecione a engrenagem e clique em "Paste Component As New";
- Rotacione o "Transform" do Objeto vazio;

### Atividade 11 - Iluminação:

- Toda Cena é criada, por padrão, com uma Câmera e uma Luz (direcional);

#### Luz Direcional (*Directional Light*):

- "Simula" o Sol. A posição da Luz não a influencia, ou seja, incide igualmente sob todos os Objetos da Cena;

#### Luz Holofote (*Spot Light*):

- "Simula" uma Lanterna. Ela é lançada para frente, no formato de cone, começando da ponta e aumentando o ângulo de sua abertura;

#### Luz de Ponto (*Point Light*):

- É lançada a partir de um ponto para todas as direções, igualmente;

#### Configurações de Iluminação:

- Podem ocorrer erros na Iluminação de uma Cena quando ela é carregada durante a execução do jogo;
- '*Window* > *Rendering* > *Lighting Settings*': acessa as propriedades de Iluminação da Unity;
- Em *Lightmapping Settings*, a propriedade "Auto Generate" pode ocasionar esse problema. Para corrigir isso, desmarque a opção "Auto Generate" e selecione "Generate Lighting". Agora, a Cena será carregada com as Luzes já computadas;
- **Obs.:** enquanto a propriedade "Auto Generate" está desmarcada, ao adicionar mais Luzes à Cena a Iluminação deve ser gerada novamente;

## Aula 03 - Boas práticas de código

### Atividade 01 - Refatorando a Movimentação:

- Criar Script "MovimentoPersonagem";

#### Script (MovimentoPersonagem):

- `private Rigidbody meuRigidbody`: variável que conterá o Rigidbody do Objeto (Personagem/Inimigo);
- `meuRigidbody = GetComponent<Rigidbody>();`: obtém a referência do componente Rigidbody. Inserido no `Awake()`;
- `public void Movimentar(Vector3 direcao, float velocidade) { }`: método que irá movimentar um Objeto (Personagem/Inimigo) utilizando seu Rigidbody;
- `meuRigidbody.MovePosition(meuRigidbody.position + direcao.normalized * velocidade * Time.deltaTime)`: conteúdo do método `Movimentar(direcao, velocidade)`;
- `public void Rotacionar(Vector3 direcao)`: método que irá rotacionar um Objeto (Personagem/Inimigo) utilizando seu Rigidbody;
- `meuRigidbody.MoveRotation(Quaternion.LookRotation(direcao));`: conteúdo do método `Rotacionar(direcao)`;

#### Script (ControlaInimigo):

- `private MovimentoPersonagem movimentoInimigo;`: cria uma variável do tipo "MovimentoPersonagem";
- `movimentoInimigo = GetComponent<MovimentoPersonagem>();`: obtém a referência do componente Script "MovimentoPersonagem";
- `movimentoInimigo.Movimentar(direcao, velocidade);`: executa o método criado no Script "MovimentoPersonagem";
- `movimentoInimigo.Rotacionar(direcao);`: executa o método criado no Script "MovimentoPersonagem";

### Atividade 03 - Refatorando a Animação:

- Criar Script "AnimacaoPersonagem";

#### Script (AnimacaoPersonagem):

- `private Animator meuAnimator`: variável que conterá o Animator do Objeto (Personagem/Inimigo);
- `meuAnimator = GetComponent<Animator>();`: obtém a referência do componente Animator. Inserido no `Awake()`;
- `public void Atacar(bool estado) { }`: método que irá animar um Objeto (Personagem/Inimigo) utilizando seu Animator;
- `meuAnimator.SetBool("Atacando", estado);`: conteúdo do método `Atacar(estado)` que altera a animação "Atacando" para o 'estado' recebido;
- 

#### Script (ControlaInimigo):

- `private AnimacaoPersonagem animacaoInimigo;`: cria uma variável do tipo "AnimacaoPersonagem";
- `animacaoInimigo = GetComponent<AnimacaoPersonagem>();`: obtém a referência do componente Script "AnimacaoPersonagem";
- `animacaoInimigo.Atacar(true);` ou `animacaoInimigo.Atacar(false);`: executa o método criado no Script "AnimacaoPersonagem";

### Atividade 06 - Refatorando a Jogador:

- Criar Script "MovimentoJogador";

#### Herança:

- Para evitar a duplicação de código e o Script "MovimentoJogador" possuir os métodos de "MovimentaPersonagem", é possível aplicar a Herança;
- `public class MovimentoJogador : MovimentoPersonagem { }`: "MovimentoJogador" herda "MovimentoPersonagem" (inclusive as Heranças de "MovimentoPersonagem");

#### Animator:

- Parâmetro de transição `Float`: realiza a transição da Animação utilizando Condições como *Greater* e *Less* do que um valor de ponto flutuante;
- **Dica:** utilizar o valor de ponto flutuante '0.1', pois como o valor mínimo é '0.0', a condição "Less" nunca iria se concretizar;

#### Script:

- `Animator.SetFloat("Parametro", valor);`: define o valor do parâmetro "Parametro" de uma Animação;
- `Vector3.magnitude;`: tamanho de um vetor Vector3;
