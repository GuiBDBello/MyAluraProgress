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
