# Blender: entendendo o Box Modeling

## Organizando o Workspace

### Concept e Modelsheet

- Concept Art: Processo prévio à modelagem 3D. A arte conceitual serve como referência para o modelo 3D.
- Modelsheet: Modelo técnico para ser replicado no ambiente 3D. Deve possuir uma visão frontal, uma visão lateral e (opcional) a visão traseira.
- Blueprint: Semelhante ao Modelsheet, mas com uma definição muito mais técnica. Mais usado para plantas baixas de casas.

### Inserindo referência

- No modo Layout, você pode adicionar uma referência para seu modelo 3D.

Formas de inserir referências:

1) Utilizar um elemento plano.
- Shift + A > Mesh > Plane
- S (escalar)
- No menu de propriedades > Material > New
- Renomear o Material para "modelsheet"
- Em "Base color", clicar no círculo amarelo e selecionar "Image Texture"
- No botão abaixo, clicar em "Open" e selecionar a imagem de referência
- Alterar o modo de visualização do Viewport (Viewport Shading) para "Material Preview"

2) Utilizar outra View como referência visual.
- Abrir uma nova View
- Alterar o tipo da View no canto superior esquerdo para "Image Editor"
- Clicar em "Open" no menu superior, e selecionar a imagem de referência

3) Utilizar uma referência.
- Shift + A > Image > Reference
- Selecionar a imagem de referência

### Organizando a área de trabalho

- Mudar o modo de trabalho para "Modeling".
- Gerar uma nova View (clicar no canto da janela e arrastar).
- Gerar outra View, no lado esquerdo, de cima para baixo, deixando a tela dividida no meio, sendo que no lado direito existe uma View e no lado esquerdo existem duas Views.
- Na janela do canto superior esquerdo, selecione o eixo X dos Gizmos.
- Na janela do canto inferior esquerdo, selecione o eixo Y dos Gizmos.
Obs.: Shift + Numpad 1/3/7 altera as perspectivas.
- Shift + A > Image > Reference, e selecione a imagem de referência.
- Selecione as referências e, no menu de propriedades, em "Data", deselecionar "Perspective".

## Modelando a lâmina

### Forma base da lâmina

- Tab: Alterna entre "Object Mode" e "Edit Mode".
- Alt + Z: Raio X do modelo 3D.
- Botão esquerdo do mouse + Arrasta: Seleciona vários vértices/arestas/faces.
Obs.: Com o Raio X ativo, a seleção múltipla vai selecionar as arestas que estão atrás também.

### Criando o fio da lâmina

- Shift + Spacebar, Ctrl + R: Loop Cut.

### Finalizando a lâmina

- No "Object Mode", selecione o objeto, clique com o botão direito do mouse e selecione "Shade Smooth".
- Selecionar o objeto novamente, no menu de propriedades, selecione o sub-menu "Data" > Normals, e habilite o "Auto Smooth".
- Shift + Spacebar, K: Knife. "Liga" vértices, criando novas arestas entre eles. Para utilizar, clique em um vértice com o botão esquerdo do mouse e arraste até outro vértice. Ao soltar o botão esquerdo do mouse, pressione Spacebar para concluir o "corte".

### Criando o cabo

- As meshes primitivas do Blender possuem um ponto de origem em seu centro.
- Para utilizar o modificador Mirror, é necessário alterar o ponto de origem do objeto. Para isso, primeiro certifique-se de estar no "Object Mode", então selecione a ferramenta de movimentação (Shift + Spacebar, G) e selecione no menu de propriedades, o sub-menu "Tool". Em Options > Transform > Affect Only, selecione "Origins". Agora você pode mover a origem do objeto para o canto dele.
- Mirror: Selecione um objeto, no menu de propriedades selecione o sub-menu "Modifier Properties", clique em "Add Modifier" e selecione o modificador "Mirror". O objeto será duplicado no eixo selecionado, a partir do seu ponto de origem.

### Extrusão do cabo

- E: A ferramenta de extrusão tem a capacidade de criar novas faces a partir da face selecionada, ou uma nova aresta a partir da aresta selecionada, e até mesmo um vértice a partir do vértice selecionado.

### Finalizando o cabo

- Antes de aplicar o modificador "Mirror", remova as faces que ficam "dentro" do espelho. Para isso, selecione as faces e pressione "Delete" > Faces.
- Para aplicar o "Mirror", selecione o objeto, vá no menu de propriedades, sub-menu "Modifiers", e clique no ícone de "Check" > Apply.
- Shift + Spacebar, I: Inset Faces. Gera novas faces a partir de outras faces selecionadas.

## Extra

Tip: If you're in the camera view you can press the shortcut 'shift + `' to enter the 'walk' navigation mode. If you're familiar with FPS video game controls (WASD to move around), this'll be a much easier way to navigate your scene. Left Click to confirm new camera position, or right click/esc to cancel
