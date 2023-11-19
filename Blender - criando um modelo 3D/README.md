# Blender: criando um modelo 3D

## Conhecendo o Blender

### O Blender

#### Layout

O Blender possui diversos modos de layout, que podem ser vistos na parte superior da ferramenta. Alguns deles são:
- Layout
- Modeling
- Sculpting
- UV Editing
- Texture Paint
- Animation

Para "resetar" o layout, selecione o botão "File" no menu superior, selecione "Defaults" e "Load Factory Settings".

Cada Layout possui uma diferente distribuição de janelas.

#### Janelas

O Blender possui várias janelas, e vários tipos de janelas.
- Você pode identificar o tipo de uma janela pelo ícone do canto superior esquerdo da própria janela.
- É possível alterar o tipo de uma janela ao selecionar esse ícone e selecionar outro tipo de janela.
- Para abrir uma nova janela, posicione o mouse na extremidade esquerda superior da janela, clique, segure e arraste o mouse para o centro da janela.
- Para fechar uma janela, posicione o mouse na "listra" entre as janelas, clique com o botão direito, selecione "Join Areas" e selecione a área que você quer remover.

### Câmara e objetos

- Botão do meio do mouse: Rotaciona a cena em torno de um objeto.
- Shift + Botão do meio do mouse: Movimento "Pan" pela cena.
- Ctrl + Botão do meio do mouse: Zoom.
- Numpad 0: Mosta a visão do objeto "Câmera" da sua cena.
- Shift + Spacebar, G: Ferramenta de movimentação (Move).
- Shift + Spacebar, R: Ferramenta de rotação (Rotate).
- Shift + Spacebar, S: Ferramenta de escala (Scale).

## Criando o ambiente

### Blocando o modelo

#### Ponto de origem

O Blender possui um "ponto de origem" que é visível na tela por um ícone de um cursor com um círculo pontilhado. Tudo o que for criado na cena será criado na posição desse cursor.
- Shift + Botão direito do mouse: Altera o ponto de origem para o local clicado.

#### Objetos

- No menu superior, selecione "Add" e selecione um dos tipos disponíveis. Um objeto do tipo selecionado será criado no seu ponto de origem. Ao criar um objeto, aparecerá uma janela no canto inferior esquerdo com as propriedades iniciais do objeto. Você pode alterá-las antes de "criar" efetivamente aquele objeto.

#### Atalhos

- G: Ferramenta de movimentação.
- G + X ou Y ou Z: Movimenta o objeto apenas no eixo selecionado.
- S: Ferramenta de escala.
- S + X ou Y ou Z: Escala o objeto apenas no eixo selecionado.
- R: Ferramenta de rotação.
- Shift + A: Atalho para adicionar um objeto.
- Shift + D: Duplica um objeto.
- X ou Delete: Deleta um objeto da cena.

### Propriedades dos objetos

- Um objeto 3D possui vértices, arestas (linhas) e faces.
- Para editar vértices, arestas e faces de um objeto, é necessário alterar o modo de edição do Blender no canto superior esquerdo, no dropdown onde está escrito "Object Mode". O modo "Edit Mode" permite alterar essas propriedades de um objeto. Ao lado direito do dropdown do tipo de edição, após selecionar "Edit Mode", é possível escolher a seleção de vértices (tecla de atalho "1"), arestas (tecla de atalho "2") ou faces (tecla de atalho "3").
- É importante diferenciar o modo de edição do modo de objeto. É necessário sair do modo de edição para persistir as mudanças em um objeto.
- O modo de edição não permite selecionar ou apagar objetos, ou selecionar outros objetos.

### Editando com modificadores

Na janela de propriedades do objeto, selecione "Modifier Properties (o ícone de uma chave de boca/chave de aperto).
- É possível adicionar modificadores aos objetos.
- Bevel: Cria uma "borda suavizada".
- Build: Cria um "tijolo" e duplica-o para ir construindo o objeto.
- Mirror: Espelha o objeto.
- Após adicionar um modificador, é possível alterar as propriedades dele.
- É preciso "aplicar" o modificador para confirmar as mudanças.

## Texturizando

### Texturização

- É possível aplicar um Material nos objetos. O Material possui propriedades de cor, textura, reflexão, opacidade, etc.
- Uma das formas de "pintar" um objeto é através de sua Mesh (malha).

#### UV Editing

"Transforma" um objeto 3D em 2D. "Abre" as faces para visualizar o objeto em um plano 2D.
- É possível definir imagens para as faces.

#### Texture Paint

Permite "pintar" um objeto 3D.
- É possível utilizar cores para pintar as faces.
- Para pintar, é necessário criar um Material.
    - Para criar um Material, selecione o dropdown do Material (no Blender 4 está no menu superior da janela direita de Texture Paint), selecione o botão "+" e selecione o tipo do Material (Ex.: Base Color).

##### Shading

- Características e Materiais que o objeto possui. Ex.: Nível de reflexão, nível de opacidade, etc.

### Aplicando cores

- Para adicionar uma cor em um objeto, é necessário adicionar um Material.
    - Selecione o objeto, vá na janela de propriedades e selecione o penúltimo ícone de cima para baixo (o ícone de um círculo).
    - Selecione "New" e altere o nome do Material criado. Ex.: telhado
- Para visualizar as cores/texturas, é necessário alterar o modo de visualização do Blender, nos ícones do canto superior direito da janela principal de layout.
- **Obs.:** Para aplicar o mesmo Material em vários objetos:
    - Adicione o Material em um objeto
    - Selecione todos os objetos segurando Shift
    - Selecione por último o objeto com o Material já aplicado
    - Pressione Ctrl + L
    - Selecione Link Materials

### Para saber mais: Modos de texturização

#### Hand painting

A forma mais usada para games é o hand painting, que consiste em aplicar a mesma técnica que criamos para fazer o dado: nós precisamos separar o objeto em uma malha e levar essa malha para um software de pintura, pintar manualmente cada parte do objeto e levar de volta para o Blender. Podemos também pintar dentro do próprio Blender, mas normalmente são usadas outras ferramentas para pintura, como Photoshop, Paint Tool SAI, entre outras.

#### Shading

O processo de shading é quando usamos materiais e configurações mais complexas de como a luz interage com o objeto para conseguirmos construir nossa cor. É um processo mais complexo e usado principalmente para animações e modelos mais realistas.

### Animando

Para animar, é preciso adicionar Keyframes na linha do tempo do Blender, e então dar "Play" para que o Blender "percorra" as modificações entre os Keyframes.

#### Link to Parent

- Select > Select all by Type > Mesh
- Segure Shift e selecione o objeto que será o "pai"
- Clique com o botão direito do mouse e selecione Parent > Object

## Renderizando

### Motores de render

- É possível alterar o motor de render do Blender no canto superior esquerdo do painel de propriedades, selecionando o ícone de câmera fotográfica (Render properties). O campo "Render Engine" permite alterar o motor de renderização utilizado pelo Blender.

### Renderizando

- Alterar nas propriedades do Render: Render Engine > Cycles
- Habilitar nas propriedades do Render: Sampling > Denoise
- Selecionar na janela de propriedades, o ícone "World" > Ray Visibility > Deselecionar "Camera"
- Selecionar no menu superior Render > Render image (ou F12).

### Exportando a animação

- A renderização é feita da visão da câmera virtual. É preciso ajustar a câmera virtual para renderizar o que essa câmera está vendo.
- Após selecionar a câmera, é possível modificar as propriedades da câmera virtual na janela de propriedades do objeto, no ícone da câmera ("Data").
- Existe outra forma mais fácil de arrumar a visualização da câmera: na janela principal da cena, ao lado direito dos Gizmos, existe uma setinha para a esquerda. Clique e arraste essa seta para a esquerda, um menu irá abrir. Nesse meu, selecione a aba "View", e em "Lock", selecione "Camera to View". Após isso, selecione "Toggle the camera view" (atalho: Numpad 0). Agora você pode navegar pela cena e essa será a visão da câmera até você deselecionar o "Camera to View".

#### Otimizando a renderização

- Nas propriedades do render (Render Properties):
    - A propriedade "Sampling > Render > Max Samples" permite otimizar a performance do render, renderizando menos imagens em uma renderização. Altere o valor de 4096 para 8
    - Em Sampling > Viewport > Denoise, alterar o "Denoiser" para OptiX.
    - Em Sampling > Render > Denoise, alterar o "Denoiser" para OptiX.
- Nas propriedades de saída (Output Properties):
    - É possível selecionar o diretório de saída dos renders em "Output".
    - Para renderizar uma animação e gerar um vídeo, é necessário alterar o valor de "Output > File Format" de PNG para um dos formatos de vídeo. Ex.: AVI JPEG.
