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

### Atividade 04 - Modificando o Gerador:

- Criar Objetos vazios para representar as posições que o Chefe poderá ser criado;
- Calcular qual desses Objetos está mais distante do Jogador;
- Atribui a posição mais distante entre o Jogador e o Gerador como a posição em que o Chefe será instanciado;

#### Script (GeradorChefe):

- `public Transform[] PosicoesDeGeracao;`: vetor de posições que o Chefe poderá ser criado;
- `private Transform jogador`: referência do Jogador utilizada para calcular a distância entre as posições de geração do Chefe;
- `jogador = GameObject.FindWithTag("Jogador").transform;`: retorna o transform do Jogador;
- `Vector3 CalcularPosicaoMaisDistanteDoJogador() { }`: método que irá retornar a posição de geração mais distante do jogador;
- `Vector3 posicaoDeMaiorDistancia = Vector3.zero;`: inicia o valor da posição;
- `float maiorDistancia = 0;`: define uma variável para realizar a validação da maior distância entre o jogador e o gerador do Chefe;
- `foreach(Transform posicao in PosicoesPossiveisDeGeracao) { // Código }`: para cada posição da coleção (vetor), execute o código;
- `float distanciaEntreOJogador = Vector3.Distance(posicao.position, jogador.position);`: dentro do foreach, obtém a distância entre o jogador e a posição atual;
- `if (distanciaEntreOJogador > maiorDistancia) { }`: verifica se a posição atual é maior que a maior posição encontrada até agora;
- `maiorDistancia = distanciaEntreOJogador;`: se entrou no if, atribui a distância atual à maior distância encontrada até agora;
- `posicaoDeMaiorDistancia = posicao.position;`: se entrou no if, atribui a posição atual à posição de maior distância encontrada até agora;
- `return posicaoDeMaiorDistancia;`: retorno do método;


## Aula 03 - Menu

### Atividade 01 - Menu do Jogo:

- Duplicar a cena, renomeá-la e abrí-la;
- Remover os geradores de inimigos;
- Remover Script da câmera e posicioná-la para visualizar o jogador e o hotel;
- Remover elementos de interface, que se encontram no Canvas;
- Adicionar botões 'Jogar' e 'Sair';
- Alterar a música do menu;
- Adicionar texto para representar o título do jogo;
- Remover Scripts do 'Jogador';
- Duplicar Animator 'Jogador', renomeá-lo para 'JogadorMenu' e alterá-lo;

### Atividade 03 - Programação dos Botões:

- Selecione o botão;
- No Inspector, vá até a seção 'On Click()';
- Selecione o Objeto que contém o Script;
- Selecione o método a ser executado no clique do botão;

#### Platform dependent compilation:

- `#if UNITY_STANDALONE`: inicia a 'Platform dependent compilation' para a plataforma 'STANDALONE';
- `#if UNITY_EDITOR`: inicia a 'Platform dependent compilation' para a plataforma 'EDITOR';
- `#endif`: encerra a execução do 'Platform dependent compilation';

#### Script (ControlaMenu):

- `using UnityEngine.SceneManagement;`: importa a biblioteca que gerencia as cenas da Unity;
- `SceneManager.LoadScene("game");`: carrega a cena 'game';
- `Application.Quit();`: fecha o jogo;
- `UnityEditor.EditorApplication.isPlaying = false;`: encerra a execução da aplicação pelo Editor;
