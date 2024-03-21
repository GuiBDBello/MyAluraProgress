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

Tip: If you're in the camera view you can press the shortcut 'shift + `' to enter the 'walk' navigation mode. If you're familiar with FPS video game controls (WASD to move around), this'll be a much easier way to navigate your scene. Left Click to confirm new camera position, or right click/esc to cancel
