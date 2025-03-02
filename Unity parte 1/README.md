# Unity parte 1: Criação de um jogo de sobrevivência à zumbis para Web

## Aula 01 - Cenário e Personagem Jogador

### Atividade 04 - Criando o cenário:

- Baixar a pasta zipada "Inicio.zip", descompactá-la e a abrir na Unity;

#### Unity:

- Cena: onde o jogo será construído;
- Hierarquia: conteúdo (objetos) de uma cena;

#### Atalhos:

- `W`: ferramenta de Movimentação;
- `Q` ou `Botão do meio do Mouse`: ferramenta Mão (serve para arrastar a cena);
- `Alt + Botão esquerdo do Mouse`: rotaciona a cena;
- `E`: ferramenta de Rotação;
- `Alt + Botão direito do Mouse` ou `Scroll Up/Down`: altera o zoom da cena;

### Atividade 07 - Para saber mais - Navegação no Unity:

#### Modo Voo:

- "Se você se segurar o botão direito do mouse na Cena, você poderá rotacionar a câmera. Então se você apertar algumas das teclas WASD você pode navegar como se estivesse voando pela Cena. Utilize as teclas Q e E para ir para cima e para baixo e segure Shift para aumentar a velocidade de Voo".

#### Movimentação com as Setas:

- "Você pode usar as Setas​ do Teclado para se movimentar pela cena da mesma forma que quando utiliza o modo de Voo. O Shift ​faz com que a movimentação seja mais rápida".

### Atividade 08 - Colocando cor no cenário:

- É possível alterar a disposição de janelas (Layout) da Unity em um dropdown no canto superior direito;
- Para as próximas aulas, será utilizado o Layout "Tall";

#### Materiais e Texturas:

- Um Material representa a forma como um objeto se comportará com a luz;
- Uma Textura representa a cor/desenho de um material;
- A extensão de um arquivo de Material é ".mat";
- A propriedade "Albedo" de um Material representa sua Textura;
- Para adicionar um Material em um Objeto da Cena, basta arrastá-lo ao Objeto;

#### Prefabs:

- Um Prefab não é nada mais que um Objeto "Pré-fabricado", ou seja, um Objeto genérico que será utilizado várias vezes na Cena;
- Para criar um Prefab, basta arrastar o Objeto desejado da aba "Hierarchy" para a aba "Project";
- A extensão de um arquivo de Prefab é ".prefab";

#### Cenário:

- Na Cena, quando a ferramenta de Movimentação estiver selecionada (tecla W), é possível selecionar um Objeto por um de seus vértices. Para isso, deve-se segurar a tecla V (ferramenta **Snap**), selecionar um vértice com o botão Esquerdo do Mouse e arrastá-lo até outro vértice para "grudá-los";
- `Ctrl + D`: Duplicar Objeto;

### Atividade 11 - Personagem no jogo:

- Com o mouse sobre a Cena, ao pressionar a tecla `F` o foco é alternado ao Objeto que está atualmente selecionado (pode-se verificar o Objeto selecionado na aba "Hierarchy");
- Adicionar o Prefab "Personagens" à Hierarquia da Cena;
- O Objeto "Personagens" está no plural pois possui vários personagens dentro dele. Para alterná-los, expanda o Objeto "Personagens", altere a propriedade "Ativo" do personagem atual para `false`, selecione um novo personagem e altere a propriedade "Ativo" deste para `true`;
- Transform: componente de um Objeto que contém sua posição, rotação e escala (cada um desses componentes possui o valor X, Y e Z);

#### Script:

- Método `Update()`: executado constantemente, uma vez a cada Frame;
- Um Script deve ser executado em um Objeto. Para atribuí-lo a um Objeto, basta arrastá-lo aos "Components" do Objeto (ao selecionar um Objeto, os "Components" aparecerão na aba "Inspector");

#### Movimentação:

- Para movimentar o personagem, será utilizado o Objeto "transform" e o método `Translate(Vector3 direcao)`, cujo parâmetro é a direção da translação;
- Vector3 é um objeto que possui três valores: X, Y e Z. Ele é utilizado para obter posições na Cena 3D, nos três eixos;
- **Ex.:** transform.Translate(Vector3.forward);
- `Vector3.forward`: propriedade do Vector3 que retorna um Vector3 com valor positivo no eixo Z. Retorno: Vector3 com os valores (0, 0, 1);

#### Modo Jogo:

- Todas as alterações feitas na Cena em "Modo Jogo" (quando o "Play" está selecionado) são perdidas ao encerrar esse modo;
- Para tornar o "Modo Jogo" mais visível, é possível alterar a cor do Editor enquanto nesse modo;
- Para isso, deve-se acessar o menu 'Edit > Preferences... > Colors' e alterar "Playmode tint" para a cor desejada;

### Atividade 14 - Movimentação com as setas:

#### Input:

- Componente que manipula as entradas de dados;
- `Input.GetAxis("Eixo")`: retorna um eixo, de nome "Eixo". É possível acessar todos os Eixos em 'Edit > Project Settings... > Input';
- **Ex.:** Input.GetAxis("Horizontal");
- Os eixos possuem valores decimais entre -1 e 1. No eixo "Horizontal", seu valor neutro (quando nenhuma tecla é pressionada) é 0. Quando é pressionada a tecla "seta para a Esquerda" o valor é alterado para -1, e "seta para a Direita" altera-o para 1;
- Os valores decimais são os valores de transição entre 0 e -1 ou 1;

#### Movimentação com Input:

- **Ex.:** `transform.Translate(new Vector3(Input.GetAxis("Horizontal"), 0.0f, Input.GetAxis("Vertical")));`

### Atividade 17 - Movimentação por segundo:

#### Aba "Game":

- A aba "Game" mostra a Cena que está aberta. Toda Cena possui uma câmera;

#### Câmera:

- É possível visualizar uma _prévia_ de uma Câmera na janela "Camera Preview", que é aberta ao selecionar uma Câmera da Cena;

#### Movimentação por segundo:

- Na aba "Game", ao clicar em "Stats" são mostradas informações, como FPS (_Frames Per Second_). O método `Update()` é executado "FPS" vezes por segundo, ou seja, uma vez a cada quadro do jogo;
- `Time.deltaTime`: tempo que a Unity demora para rodar cada Frame. Essa propriedade é utilizada para executar um código apenas uma vez por segundo ao multiplicá-la por algum valor;
- **Ex:** velocidade * Time.deltaTime;

#### Variáveis public:

- As variáveis com modificador de acesso "público" (_public_) são mostradas diretamente no "Inspector" do Script que contém a variável;
- Isso é útil para testar valores diferentes em tempo de execução, ou até para realizar testes;


## Aula 02 - Animação, Colisão e Física

### Atividade 01 - Animando o jogador:

- **Obs.:** Para esse exemplo, serão utilizadas Animações que foram criadas e exportadas por um programa externo à Unity (**Ex.:** Blender);

#### Importar Animações:

- Deve-se selecionar no editor da Unity o arquivo com as Animações, e no "Inspector" selecionar a caixa "Import Animation" e pressionar "Apply";

#### Animações:

- O arquivo importado possui diversas animações. Para verificar os "Frames" de cada Animação, é necessário abrir o arquivo "Animacoes.txt", que possui o seguinte padrão: `'Nome da Animação': 'frameInicial' - 'frameFinal'`;
- Para separar as Animações, selecione o arquivo que as contém, e no "Inspector", na seção "Clips", selecione um Clipe e digite o quadro inicial ("Start") e o quadro final ("End") do Clipe desejado;
- Para adicionar novos Clipes, pressione o botão com o símbolo de adição ("+") e defina suas propriedades;
- Cada Clipe criado adiciona uma nova Animação ao arquivo das Animações. Para adicionar uma Animação a um Objeto, arraste-a para o Objeto que deve realizar a Animação (**Ex.:** arraste a Animação "Correr" ao Objeto "Jogador");
- Animator (Componente): Componente que controla as Animações;
- Avatar: forma como o Modelo 3D lidará com as Animações aplicadas;
- Loop Time: propriedade de um Clipe que indica se ele rodará repetidamente;

### Atividade 04 - Sistema de animações Mecanim:

- É possível adicionar várias Animações em um Animator;

#### Animator:

- Set as Layer Default State: define a Animação padrão de um Objeto;
- Make Transition: faz uma Transição entre duas Animações;
- Parameters: parâmetros que definem as trocas entre as Animações. Podem ser dos tipos `Float`, `Int`, `Bool` ou `Trigger`;

#### Transition:

- Has Exit Time: define se, no término de uma Animação, ocorre uma Transição;
- Conditions: define quando uma Transição deve ser efetuada. Utiliza Parâmetros;

#### Unity:

- Criar Transições entre as Animações "Idle" e "Correr";
- Criar um Parâmetro do tipo `Bool` chamado "Movendo";
- Adicionar Condições nas Transições entre "Idle" e "Correr" utilizando o Parâmetro "Movendo";
- Remover "Has Exit Time" de ambas Transições;

#### Script:

- `Vector3.zero`: propriedade do Vector3 que retorna um Vector3 com valor 0 nos três eixos. Retorno: Vector3 com os valores (0, 0, 1);
- `GetComponent<'Componente'>()`: retorna um Componente da Unity;
- **Ex.:** `GetComponent<Animator>.SetBool("Movendo", true)`;

### Atividade 08 - Movimentando a câmera:

#### Unity:

- Criar um novo Script chamado "ControlaCamera";
- Adicionar o Script ao Objeto "Main Camera";
- Criar uma referência ao Objeto "Jogador";
- Atribuir o Objeto Jogador à sua referencia no Script "ControlaCamera";

#### Script:

- `public GameObject Jogador;`: cria uma nova referência a Jogador
- `Vector3 distCompensar = transform.position - Jogador.transform.position;`: distância entre o Jogador e a Câmera;
- `transform.position = Jogador.transform.position - distCompensar`: altera a posição da Câmera para o Jogador, levando em consideração a posição atual da Câmera;

### Atividade 10 - Colisão:

#### Adicionar Collider:

- Selecionar o Objeto que receberá o "Collider";
- Em "Inspector" selecionar '"Add Component" > "Physics" > "'Shape' Collider"';

#### Alterar Collider:

- No Componente "'Shape' Collider" é possível alterar o Colisor do Objeto, selecionando "Edit Collider";
- Selecionar um dos cubos que surgiram em torno do Objeto e arrastar;
- Alguns tipos de "Colliders", como o "Capsule Collider", possuem algumas propriedades adicionais, como "Radius" e "Direction";

#### Mesh Collider:

- O "Mesh Collider" é um Colisor que deve ser usado com cautela, pois depende da complexidade do Objeto a que ele é atribuído. Se ele for atribuído a um Objeto complexo, a performance do jogo poderá decair;

### Atividade 13 - Sistema de física:

- Rigidbody: adiciona um Componente físico de "Corpo Rígido" ao Objeto, o impedindo de atravessar Colisores;
- Constraints: propriedade de Rigidbody que permite impedir a Posição e Rotação do Objeto nos eixos X, Y e Z;

#### Movimentação pela Física:

- Para mover um Objeto utilizando física, deve-se obter seu "Rigidbody" e utilizar um de seus métodos disponíveis para realizar a movimentação;
- `MovePosition('posicao');`: move o Objeto para a posição 'posicao';
- **Ex.:** `GetComponent<Rigidbody>().MovePosition(GetComponent<Rigidbody>().position + (direcao * Velocidade * Time.deltaTime));`: move o Objeto para uma posição relativamente à posição atual do "Rigidbody";
- **Obs.:** Ao mover algum Objeto utilizando **física**, deve-se escrever o código dentro do método `FixedUpdate() { }`;
- O método `FixedUpdate() { }` é executado, por padrão, uma vez a cada 0,02 segundos (ou 50 vezes por segundo);

### Atividade 16 - Para saber mais: Documentação e Comentário de Código:

#### Manual da Unity:

- https://docs.unity3d.com/Manual/

#### Manual da Unity (Componente Animator):

- https://docs.unity3d.com/Manual/class-Animator.html

#### Documentação de "Scripting":

- https://docs.unity3d.com/ScriptReference/

#### Documentação de "Scripting" (Animator):

- https://docs.unity3d.com/ScriptReference/Animator.html
- **Public Functions** são todos os métodos disponibilizados pelo Animator;

#### Documentação de "Scripting" (MonoBehaviour):

- https://docs.unity3d.com/ScriptReference/MonoBehaviour.html
- **Messages** são todos os métodos disponibilizados pela Unity para utilizar nos Scripts;

#### Comentários:

- `// Comentário de uma linha`;


## Aula 03 - Criando o Zumbi Inimigo

### Atividade 01 - Zumbi inimigo:

- Em 'Assets > Modelos3D > Personagens > Animacoes', selecione Animacoes_Zumbi;
- Após selecionado, no "Inspector" existem três abas: "Model", "Rig" e "Animations";

#### Model:

- "Scale Factor": escala do Objeto a ser animado. É uma boa prática seguir a mesma proporção desta propriedade para todos os Objetos;
- "Import Materials": a Unity nem sempre importa os Materiais de outros programas corretamente. Por esse motivo, na aula essa opção estava desmarcada, e realizamos a importação separadamente;

#### Rig:

- São as "Juntas" do Modelo animado. Configura como a Unity lida com as animações importadas de outros programas;
- "Animation Type": o tipo do "Corpo" do Modelo a ser animado;
- "Configure...": abre uma Cena com as configurações do Avatar. É possível ver todas as juntas do Modelo e modificá-las;

Em suma, o Rig:
- Configura o comportamento das articulações dos personagens;
- Especifica se é um humanóide;
- Visualiza o funcionamento do esqueleto;
- Cria um Avatar para definir o comportamento da Unity em relação às animações;

### Atividade 02 - Zumbi seguir o jogador:

- `Vector3 direcao = Objeto.transform.position - transform.position;`: diferença entre "onde quero estar" ('Objeto') e "onde estou" (Objeto que contém o Script);
- `GetComponent<Rigidbody>().MovePosition(GetComponent<Rigidbody>().position + direcao.normalized * Velocidade * Time.deltaTime);`: move o Objeto que contém o Script até 'Objeto'. A 'direcao' deve ser normalizada ("normaliza" os valores dos eixos do Vector3 entre 0 e 1). 'Velocidade' é multiplicado pelo valor normalizado;

### Atividade 04 - Zumbi perseguindo o Jogador:

#### Normalização:

- Pega um Vetor de algum tamanho e transforma em outro que sempre tem tamanho até no máximo 1;
- https://docs.unity3d.com/ScriptReference/Vector3.Normalize.html

### Atividade 05 - Rotação do Zumbi:

- `Vector3.Distance(Vector3 a, Vector3 b);`: retorna um float, que é a distância entre 'a' e 'b';
- Quaternion: estrutura utilizada para rotação;
- `Quaternion.LookRotation(direcao);`: retorna um Quaternion com a rotação para a 'direcao';
- `GetComponent<Rigidbody>().MoveRotation(Quaternion rotacao);`: altera a rotação do Objeto para 'rotacao';

### Atividade 08 - Criando a bala no jogo:

#### Mesclar Animações:

- Na janela "Animator", em "Layers", selecione "+" para criar uma nova Camada de Animação;
- Nas propriedades da camada (clique na engrenagem), deve-se criar uma Máscara para obter apenas uma parte da Animação;

#### Máscara:

- Para criar uma Máscara, vá na janela '"Project" > Create > Avatar Mask';
- Ao selecionar a Máscara criada, aparecerão os Avatares que podem ser aplicados à Máscara;
- Selecione "Humanoid" e desmarque tudo, **exceto os Braços**;

#### Nova Camada ("Layer"):
- Em suas propriedades (engrenagem), selecione a Máscara criada e altere seu Peso ("Weight") para 1;
- No Animator, selecione a Camada criada;
- Não altere o valor da Mescla ("Blending") que deve ser "Override";

#### Bala:

- Adicionar um Cubo (renomeá-lo para "Bala");
- `R`: ferramenta de Escala;
- Criar novo Material e adicionar uma Cor (Albedo);
- Adicionar o novo Material à "Bala";
- Criar um Prefab da "Bala";

### Atividade 10 - Atirando:

- `Input.GetButtonDown("Fire1")`: retorna um boolean que verifica o clique no botão Esquerdo do Mouse;
- É possível ver todos os Inputs em 'Edit > Project Settings > Input';
- `Instantiate(Object objeto, Vector3 posicao, Quaternion rotacao);`: 

#### Cano da Arma:

- Para "simular" o cano da Arma (posição de onde as Balas serão criadas) será criado um Objeto Vazio ("Empty") e adicioná-lo ao Objeto Jogador;

#### Obter valores em Modo "Play":

Os valores dos Objetos do Jogo sempre são reiniciados quando o Jogo inicia e encerra o Modo "Play". Porém, há um "truque" para obter valores de Componentes durante o Modo "Play";
- Para obter valores de um Transform, pressione "Play" e, logo após, "Pause";
- Posicione o Objeto no local desejado e pressione na engrenagem dentro do Componente Transform;
- Selecione "Copy Component";
- Encerre o Modo "Play";
- No mesmo Objeto, vá no Transform, clique na engrenagem e selecione "Paste Component Values";

#### Script (Bala):

- `GetComponent<Rigidbody>().MovePosition(GetComponent<Rigidbody>().position + transform.forward * Velocidade * Time.deltaTime);`: move a Bala para frente, considerando sua rotação ('transform'), 'Velocidade' e taxa de atualização;


## Aula 04 - Interações entre os Personagens

### Atividade 01 - Rotação do jogador:

- Ray: Objeto da Unity que representa um Raio na Cena;
- Camera: Objeto da Unity que representa o tipo Câmera;

#### Script:

- `Ray raio = Camera.main.ScreenPointToRay(Input.mousePosition);`: retorna um "Ray", que sai da Câmera Principal e aponta à posição do Mouse;
- `Debug.DrawRay(raio.origin, raio.direction * 100, Color.red);`: desenha um "Ray" na tela;
- `raio.origin`: posição inicial do Raio;
- `raio.direction`: posição final do Raio. Por padrão, é um "Ray" bem pequeno, por isso é feita a multiplicação por 100;
- `Color.red`: retorna a propriedade 'Vermelha' de 'Cor';
- `RaycastHit impacto;`: cria uma variável para armazenar a posição que o Raio toca no chão;
- `Physics.Raycast(raio, out impacto, distancia);`: retorna um boolean, que é o "lançamento" de um Raio 'raio', verificando com o 'impacto' em uma distância 'distancia';
- `out`: palavra-chave que indica que uma variável não possui valor, mas receberá dentro do bloco atual;
- `Vector3 posicaoMiraJogador = impacto.point - transform.position;`: posição do 'impacto.point' a partir da posição do Objeto que recebe o Script ("Jogador");
- `posicaoMiraJogador.y = transform.position.y;`: "anula" a rotação no eixo Y da mira do Jogador;

- `Ctrl + Shift + P`: pause;

### Atividade 02 - Rotação do jogador 2:

- `Quaternion novaRotacao = Quaternion.LookRotation(posicaoMiraJogador);`: retorna uma rotação a partir de uma posição;
- `GetComponent<Rigidbody>().MoveRotation(novaRotacao)`: altera a rotação do Objeto ("Jogador") para 'novaRotacao', fazendo o Objeto "olhar" para a posição;
- `public LayerMask MascaraChao;`: cria uma "Máscara" do Chão, para o Raio acertar apenas o Chão;
- `Physics.Raycast(raio, out impacto, distancia, mascara)`: adiciona a Máscara 'mascara' para o Raio impactar apenas com os Objetos que possuem a Camada ("Layer") 'mascara';

#### Layer:

- Para adicionar uma Camada, selecione o Objeto na janela "Hierarchy" e, em "Inspector", no canto superior direito, selecione a caixa ao lado direito de "Layer" ("Add Layer...");
- Crie uma nova Camada;
- Atribua essa nova Camada nos Objetos que o Jogador irá caminhar;
- Na variável pública criada no "Jogador", selecione a Camada criada para o Chão;

### Atividade 05 - Destruir os zumbis:

- Para verificar uma colisão, no Componente 'Shape' Collider, deve-se marcar a propriedade "Is Trigger";
- Quando essa propriedade está ativa, o método `OnTriggerEnter` é disparado sempre que houver uma colisão com outro Objeto;

#### Script (OnTriggerEnter):

- `void OnTriggerEnter(Collider objetoDeColisao) { }`: método chamado quando há uma colisão. Recebe como parâmetro o Objeto da colisão;
- `Destroy(objetoDeColisao.gameObject)`: método que destrói o Objeto que a Bala colide;

#### Tag:

- É uma forma de "etiquetar" um Objeto, reconhecendo-o como parte de um Padrão;
- Para adicionar uma nova 'Tag', selecione um Objeto na janela "Hierarchy" e, em "Inspector", no canto superior direito, selecione a caixa ao lado direito de 'Tag' ("Add Tag...");
- Clique no "+" e dê um nome para a 'Tag'. Nesse caso, será "Inimigo";
- Selecione o Objeto novamente, selecione, em "Inspector", a caixa ao lado direito de 'Tag' e selecione "Inimigo";
- Para verificar uma 'Tag' no código, pode-se utilizar um "if";
- **Ex.:** `if (objetoDeColisao.tag == "Inimigo") { /* Destrói inimigo */ }`;

### Atividade 08 - Zumbi atacar jogador:

#### Animator:

- Adicionar a "Animacoes_Ataque", que se encontra em 'Assets > Modelos3D > Personagens > Animacoes' no Animator de um dos Zumbis (após, a modificação será aplicada ao Prefab);
- Criar uma Transição de "Zumbi_Andar" para "Ataque" e vice-versa;
- Adicionar um novo Parâmetro (Bool) chamado "Atacando";
- Desmarcar "Has Exit Time" e adicionar a Condição "Atacando" em ambas Transições;

#### Script:

- `GetComponent<Animator>().SetBool("Atacando", 'bool');`: altera a animação do Zumbi, onde 'bool' pode ser `true` ou `false`;

### Atividade 10 - Reiniciar o jogo:

#### Eventos de Animação:

- Selecione o arquivo "Animacoes_Ataque", que se localiza em 'Assets > Modelos3D > Personagens > Animacoes';
- Em "Events", selecione o 'Frame' da Animação que o Ataque é efetivado, selecione "Add Event", nomeie-o "AtacaJogador" e clique em "Apply";
- No Script, crie o método `AtacaJogador`, que será chamado no 'Frame' que o Evento foi criado na Animação;

#### UI:

- Canvas: Objeto que representa a tela do jogo. Comporta os elementos da Interface do Usuário (UI) da Unity;
- Text: Objeto que contém um texto;
- `T`: ferramenta de Retângulo. Lida com os elementos da UI;
- Paragraph: propriedade do Objeto "Text" que permite Alinhar verticalmente, horizontalmente, definir se há "sobrecarga" da caixa de texto, etc.;

#### Escala de Tempo:

- `Time.timeScale`: propriedade da classe "Time" que representa a escala de tempo do jogo, na Unity;
- `Time.timeScale = 0;`: para o tempo do jogo;
- `Time.timeScale = 1;`: valor padrão da escala de tempo da Unity;

#### Acessando variáveis de outros Scripts:

- Uma variável pública pode ser acessada por Scripts externos. Para isso, basta ter uma referência ao Objeto, e utilizar `Objeto.GetComponent<Script>().Variavel>`;

#### Script (ControlaJogador):

- `public GameObject TextoGameOver;`: cria uma variável que referencia um Objeto "Text";
- `public bool Vivo;`: cria uma variável que irá definir se o Jogador está vivo ou não;
- `if (Vivo == false) { /* Clique para reiniciar */ }`: 
- `void Start() { Time.timeScale = 1; }`: define, ao reiniciar o jogo, que a escala de tempo retorna ao normal;

#### Script (ControlaInimigo):

- `Jogador.GetComponent<ControlaJogador>().TextoGameOver.SetActive(true);`: obtém a referência da variável pública "TextoGameOver" no Script "ControlaJogador" do Objeto Jogador, e altera seu valor "Active";
- `Jogador.GetComponent<ControlaJogador>().Vivo = false;`: define, ao jogador ser atacado, que sua variável 'Vivo' recebe o valor `false`;

#### SceneManagement:

- `using UnityEngine.SceneManagement;`: importa a biblioteca da Unity que lida com Cenas;
- `SceneManager.LoadScene("game");`: método da classe "SceneManager" que carrega a Cena "game";


## Aula 05 - Finalizando o Jogo:

### Atividade 01 - Gerador de zumbis:

- Criar um Script para realizar a Geração dos Zumbis ("GeradorZumbis"), e jogá-lo em um Objeto vazio ("Empty");
- Selecione o Objeto e, no "Inspector", selecione no canto superior esquerdo o cubo, e selecione um Ícone, para deixar o Objeto vazio visível na Cena;
- Criar uma nova 'Tag' "Jogador";
- Como o Objeto "Zumbi" é um Prefab, ele não recebeu o Objeto "Jogador" da "Hierarchy", definido como variável pública em seu Script. Para recebê-lo, é possível realizar uma busca, utilizando o método `FindWithTag` da classe GameObject;
- "Aleatorizar" um tipo de Zumbi diferente, dentro dos 27 tipos disponíveis, para dar maior diversidade visual ao jogo;

#### Script (GeradorZumbis):

- `public GameObject Zumbi;`: cria uma variável que referencia o Prefab do Zumbi;
- `Instantiate(Zumbi, transform.position, transform.rotation);`: método adicionado dentro de `Update()` que instancia um novo Objeto Zumbi na Cena;
- `float contadorTempo = 0;`: variável que servirá para definir um tempo para esperar;
- `contadorTempo += Time.deltaTime;`: incrementa na variável 'contadorTempo' o tempo que levou para carregar o Frame atual;
- `public float TempoGerarZumbi = 1;`: cria uma variável que irá gerenciar o tempo que cada Zumbi é gerado;
- `if (contadorTempo >= TempoGerarZumbi) { /* Gera um Zumbi e zera o contador */}`: verifica se está na hora de gerar um zumbi;

#### Script (ControlaInimigo):

- `GameObject.FindWithTag("Jogador");`: método da classe GameObject, que retorna um GameObject, ao realizar uma busca em todos os Objetos, que contenha a 'Tag' "Jogador";
- `int geraTipoZumbi = Random.Range(1, 28);`: variável que recebe um número aleatório entre 1 e 28 (até 27);
- `transform.GetChild(geraTipoZumbi).gameObject.SetActive(true);`: ativa um Objeto, utilizando um índice de número aleatório, que se encontra dentro do Objeto "Zumbi";

### Atividade 04 - Organização e otimização:

#### Boas práticas:

- Variáveis públicas iniciam com letra **Maiúscula** (*PascalCase* ou *UpperCamelCase*);
- Variáveis não-públicas iniciam com letra **minúscula** (*camelCase* ou *lowerCamelCase*);
- Se uma variável não possui um modificador de acesso, por padrão, ela recebe o modificador `private`;
- Para evitar repetição de código, é possível armazenar componentes da Unity em variáveis;
- **Ex.:** `private Rigidbody rigidbodyJogador = GetComponent<Rigidbody>();` **Obs.:** para seguir boas práticas, a inicialização da variável deve ser feita no método `Start() { }`;
- É uma boa prática separar os "Assets" em pastas correspondentes, como 'Animacoes' para as Animações e Máscaras, etc.;
- Além disso, Objetos vazios ("Empty") podem ser utilizados para separar os Objetos do jogo por categoria. **Ex.:** Objeto "Cenario" será "pai" do 'Hotel', do 'Chao', etc.;

### Atividade 07 - Finalização do cenário:

- Serão utilizados os Objetos (Prefabs) disponibilizados pela Alura para finalizar o Cenário do jogo, fechando a área jogável, colocando Objetos onde haviam apenas colisores e "escondendo" o final do mapa;

### Atividade 10 - Publicação do jogo:

- 'File > Build Settings...': abre a janela para gerar a Build do jogo;

#### Build Settings...:

- "Scenes In Build: Cenas que o jogo contém;
- "Platform": a Plataforma que a Build será gerada para rodar o jogo. **Selecionar WebGL**;

#### Player Settings...:

- Propriedades do jogo no Cliente (onde o jogo irá rodar);
- "Default Screen Width": largura padrão da tela;
- "Default Screen Height": altura padrão da tela (**alterar para 540**, para rodar no maior número de dispositivos possível);
- "Run In Background": define se o jogo irá (ou não) pausar quando estiver desfocado, ou com a janela minimizada (**marcar essa opção**);

#### Build:

- Selecione o diretório para gerar a Build;
- Zipe o diretório;

#### Publicação:

- Registre-se ou realize o login em https://itch.io/
- Vá em 'Feed';
- 'Create new project';
- 'Title': nomeie o jogo;
- 'Kind of project': selecione "HTML"
- 'Pricing': selecione "No payments"
- 'Upload files': envie o arquivo .zip gerado na Build e marque "This file will be player in the browser"
- 'Embed options': digite as mesmas dimensões definidas na Unity, em 'Player Settings...';
- 'Visibility & access': selecione "Restricted";
- 'Restricted access settings': marque "Also allow a password to view page" e escolha uma senha;
- Clique em Save & view page, e tudo pronto, jogo publicado!
- Agora é possível compartilhar seu jogo com qualquer pessoa, apenas enviando o link de sua página. Lembre-se de enviar a senha também;

### Atividade 12 - Conclusão do curso:

#### Resumão:

- Navegação dinâmica (na Cena);
- Criação de cenário;
- Utilização de materiais e texturas;
- Desenvolvimento de movimentos dos personagens por meio de código (Script);
- Utilização das animações por meio do sistema *Mecanim* da Unity, que é bem complexo;
- Utilização do sistema de animação no código do jogo (Animator);
- Adição de colisão em objetos, mantendo a coerência;
- Utilização da física para mover objetos (Rigidbody);
- Configuramos inputs para atirar com o clique do mouse e mover a personagem com as setas;
- Criação de interfaces para imprimir *Game Over* quando os inimigos atingirem a heroína;
- Criação dinâmica de zumbis, por meio de "GeradorZumbis";
- Fizemos o balanço final;
- E por fim, publicamos o jogo na web, para que o link possa ser enviado a qualquer pessoa (itch.io).
