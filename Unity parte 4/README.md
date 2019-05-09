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


## Aula 02 - Retoques no Chefe do Jogo

### Atividade 01 - Aviso de Chefe Criado:

- Criar um texto (UI) e desativá-lo;
- Criar uma Co-rotina para fazer o texto sumir após um tempo;

#### Co-rotina:

- Ativar o texto;
- Aguardar um tempo com o texto na tela, para que o jogador leia-o;
- Diminuir o "Alpha" do texto, baseado em um tempo, até fazê-lo desaparecer;
- Desativar o texto;

#### Script (ControlaInterface):

- `public Text Texto;`: cria uma variável do tipo Text;
- `public void MostrarTexto() { }`: método criado para mostrar o texto;
- `StartCoroutine(1, Texto);`: inicia a co-rotina;
- `IEnumerator DesaparecerTexto(float tempo, Text texto) { }`: co-rotina que fará o texto 'texto' desaparecer após 'tempo' segundos;
- `texto.gameObject.SetActive(true);`: ativa o texto 'texto' no jogo;
- `Color corTexto = texto.color;`: obtém a cor padrão do texto 'texto';
- `corTexto.a = 1;`: inicia o valor do "Alpha" do texto 'texto' com seu valor máximo (1, ou 100%);
- `texto.color = corTexto;` : iniciar a cor do texto 'texto' com seu valor padrão;
- `yield return new WaitForSeconds(1)`: aguarda 1 segundo com o texto na tela antes de prosseguir;
- `float contador = 0;`: define uma variável que irá representar o tempo que passou;
- `while(texto.color.a > 0) { }`: itera sobre o "Alpha" do texto, até que ele desapareça;
- `contador += Time.deltaTime / tempo;`: incrementa o contador, baseado no tempo 'tempo', indo do valor 0 até 1;
- `corTexto.a = Mathf.Lerp(1, 0, contador)`: altera a cor de 100% até 0%, baseado no contador;
- `texto.color = corTexto;`: atribui a cor que está desaparecendo 'corTexto' à cor do texto 'texto';
- `if (texto.color.a <= 0) { // Desativa o texto }`: verifica se o "Alpha" está zerado, e desativa o texto 'texto';
- `texto.gameObject.SetActive(false);`: desativa o texto 'texto' no jogo;
- `yield return null`: dentro do while, obriga a cada instrução do laço aguardar um frame antes de prosseguir;

#### Script (GeradorChefe):

- `private ScriptInterface scriptInterface;`: cria uma variável que receberá o Script que controla a Interface (comumente adicionado ao Canvas);
- `scriptInterface = GameObject.FindObjectOfType(typeof(ScriptInterface)) as ScriptInterface;`: retorna a referência ao Script da Interface;
- `scriptInterface.MostrarTexto();`: ativa a variável 'Texto' criada no Script que controla a Interface;
