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
- A extensão de um arquivo de Material é '.mat';
- A propriedade "Albedo" de um Material representa sua Textura;
- Para adicionar um Material em um Objeto da Cena, basta arrastá-lo ao Objeto;

#### Prefabs:

- Um Prefab não é nada mais que um Objeto "Pré-fabricado", ou seja, um Objeto genérico que será utilizado várias vezes na Cena;
- Para criar um Prefab, basta arrastar o Objeto desejado da aba "Hierarchy" para a aba "Project";
- A extensão de um arquivo de Prefab é '.prefab';

#### Cenário:

- Na Cena, quando a ferramenta de Movimentação estiver selecionada (tecla W), é possível selecionar um Objeto por um de seus vértices. Para isso, deve-se segurar a tecla V (ferramenta **Snap**), selecionar um vértice com o botão Esquerdo do Mouse e arrastá-lo até outro vértice para "grudá-los";
- `Ctrl + D`: Duplicar Objeto;

### Atividade 11 - Personagem no jogo:

- Com o mouse sobre a Cena, ao pressionar a tecla `F` o foco é alternado ao Objeto que está atualmente selecionado (pode-se verificar o Objeto selecionado na aba 'Hierarchy');
- Adicionar o Prefab 'Personagens' à Hierarquia da Cena;
- O Objeto 'Personagens' está no plural pois possui vários personagens dentro dele. Para alterná-los, expanda o Objeto 'Personagens', altere a propriedade "Ativo" do personagem atual para "false", selecione um novo personagem e altere a propriedade "Ativo" deste para "true";
- Transform: componente de um Objeto que contém sua posição, rotação e escala (cada um desses componentes possui o valor X, Y e Z);

#### Script:

- Método Update(): executado constantemente, uma vez a cada Frame;
- Um Script deve ser executado em um Objeto. Para atribuí-lo a um Objeto, basta arrastá-lo aos 'Components' do Objeto (ao selecionar um Objeto, os 'Components' aparecerão na aba 'Inspector');

#### Movimentação:

- Para movimentar o personagem, será utilizado o Objeto 'transform' e o método 'Translate(Vector3 direcao)', cujo parâmetro é a direção da translação;
- Vector3 é um objeto que possui três valores: X, Y e Z. Ele é utilizado para obter posições na Cena 3D, nos três eixos;
- **Ex.:** transform.Translate(Vector3.forward);
- `Vector3.forward`: propriedade do Vector3 que retorna um Vector3 com valor positivo no eixo Z. Retorno: Vector3 com os valores (0, 0, 1);

#### Modo Jogo:

- Todas as alterações feitas na Cena em "Modo Jogo" (quando o "Play" está selecionado) são perdidas ao encerrar esse modo;
- Para tornar o "Modo Jogo" mais visível, é possível alterar a cor do Editor enquanto nesse modo;
- Para isso, deve-se acessar o menu 'Edit > Preferences... > Colors' e alterar 'Playmode tint' para a cor desejada;
