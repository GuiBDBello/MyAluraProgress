# Introdução ao Blender 2.8: Modelagem poligonal

## Aula 01 - Começando os trabalhos em um ambiente 3D

### Atividade 05 - Ferramentas de navegação:

- `Botão esquerdo do mouse`: Seleciona um objeto.
- `Barra de espaço`: Inicia a animação que está na *timeline*.
- `Canvas`/`Viewport`/`3D View`: Janela principal onde são feitas as modelagens, animações, texturizações, etc.

#### Navegação:

- `Botão do meio do mouse`: *Rotate*/*Orbit*.
- `Shift + Botão do meio do mouse`: *Pam*.
- `Ctrl + Botão do meio do mouse`: *Zoom*.

### Atividade 07 - Navegando entre viewports:

- `Ctrl + Alt + Q`: Ativa a *quad view*.
- É possível criar *viewports* customizadas. Clique com o `Botão esquerdo do mouse` em uma das bordas da imagem e arraste o *mouse* verticalmente ou horizontalmente, ou clique com o `Botão direito do mouse` em uma das bordas e selecione `Split Area`, e então arraste o *mouse* e clique com o `Botão esquerdo do mouse` para dividir a janela.
- Para fechar, clique com o `Botão direito do mouse` e selecione `Join Area`. Então, clique com o `Botão esquerdo do mouse` em outra janela para que elas se juntem em uma só.

### Atividade 09 - As ferramentas de manipulação:

- Segure `Shift` e clique com o `Botão esquerdo do mouse` para selecionar vários objetos.
- Segure `Ctrl` e clique com o `Botão esquerdo do mouse` para deselecionar objetos.
- `G`: Movimenta o objeto selecionado.
- `S`: Escala o objeto selecionado.
- `R`: Rotaciona o objeto selecionado.
- **Obs.:** Após pressionar `G`, `S` ou `R`, pressione `X`, `Y` ou `Z` para editar o objeto em apenas um dos eixos. Para concluir a edição, pressione o `Botão esquerdo do mouse`.
- `Ctrl + Z`: Desfaz.
- `Ctrl + Shift + Z`: Refaz.
- `Delete`: Exclui o objeto.

#### Visão ortográfica:

- Segue `Alt` e utilize o `Botão do meio do mouse` para visualizar o objeto em visão ortogonal. Clique para ir até o ponto no eixo atual ou altere o eixo de visão ao clicar e arrastar o *mouse*.
- `Numpad 1`: Visão de frente.
- `Numpad 3`: Visão da direita.
- `Numpad 7`: Visão de cima.
- `Numpad 9`: Visão de baixo.
- `Ctrl + Numpad 1`: Visão de trás.

### Atividade 11 - Lidando com primitivas:

- `Shift + A`: Abre o menu de adição de primitivas.
- Objetos são adicionados onde o `Cursor 3D` está posicionado.
- Ao adicionar um objeto, aparecerá um menu no canto esquerdo inferior do *canvas*, que permite editar as propriedades do objeto. **Obs.:** Essas alterações só são possíveis de serem feitas antes de movimentar, escalonar, rotacionar ou selecionar outro objeto.
- `N`: Abre as propriedades do objeto.

## Aula 02 - A pré-produção do projeto

### Atividade 01 - Ferramentas de seleção:

- `W`: Alterna entre as ferramentas de seleção entre laço, retângulo, pintura, e assim por diante.

### Atividade 02 - A formação dos polígonos:

#### O que são Polígonos?

- Você já deve ter visto na escola que os polígonos são figuras fechadas compostas por segmentos de reta.
- Traduzindo para a nossa linguagem 3D, polígonos são figuras fechadas compostas por segmento de *edges* que compõem todos os objetos dentro da computação gráfica.
- Nós consideramos um polígono aquele cuja figura é composta por 4 lados ou mais.
- Tudo que estiver com mais de 4 lados nós chamados de *N polygons*, os quais dependendo da situação, não é bom para o 3D.
- O que tiver menos que 4 lados, chamamos de triângulos, e 2 triângulos podem formar um poligono de 4 lados.
- Considerando então, que os polígonos são figuras fechadas compostas por *edges*, do que seriam formadas as *edges*? As *edges* são formadas por um Ponto (*vertex*) inicial "A" que vai até um ponto (*Vertex*) final "B". Sendo assim, quando tivermos um Ponto Inicial e um Ponto Final, podemos ter uma *edge*.
- Para que possamos navegar entre esses componentes dentro do *Blender*, devemos entrar no modo de *Edit Mode*, através do menu localizado na parte superior do *Blender*, ou simplesmente utilizando a tecla de atalho `Tab` e em seguida clicar `1`.
- Quando estamos no modo de edição do objeto podemos alternar entre os elementos de *Vertex*, *Edge* e *Face*.
- Os elementos podem também ser movimentados, e podemos usar as ferramentas de seleção, como vimos nas atividades anteriores, tais quais ferramentas de *Scale* e *Rotate* para os elementos individuais.

### Atividade 03 - Editando meshes para modelagem:

#### Edit Mode:

- `A` 2 vezes rapidamente: Deseleciona tudo.
- `1`: Seleção de *Vertex*.
- `2`: Seleção de *Edge*.
- `3`: Seleção de *Face*.
- `Ctrl + R`: *Loop Cut*.
- `E`: *Extrude*.

### Atividade 05 - O bevel e connect vertex path:

- `Ctrl + B`: *Bevel*.
- `J`: *Connect path*. Une dois *vertex*, criando uma *edge*.
- `Z`: Abre as opções de *Shading* (*Rendered*, *Look Dev*, *Solid* e *Wireframe*).
- `B`: Seleção em retângulo.
