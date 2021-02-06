# Blender 3D: Modelagem inorgânica

## Aula 01 - Começando os trabalhos em um ambiente 3D

### Atividade 01 - Introdução:

- *Concept*: Imagem base para exemplificar e auxilar na modelagem do *prop*.
- *Prop*: Objeto 3D.

### Atividade 03 - Arquivo para estudo:

- `File > OPEN` ou `Ctrl + O`: Abre um arquivo no *Blender* (com extensão `.blend`).

### Atividade 04 - Ferramentas de Navegação:

- *PAN*: `Shift + Botão do meio do mouse`.
- *ROTATE*: `Botão do meio do mouse`.
- *ZOOM*: `Ctrl + Botão do meio do mouse`.

### Atividade 06 - O rotate around selection:

- Para que possamos ter um melhor controle sobre o *rotate* em nosso *canvas* no *Blender*, devemos ativar a opção "*rotate around selection*" localizada no menu `File > User Preferences > Interface`.

### Atividade 07 - Navegando entre as viewports:

- *Toggle Quad View* (`Ctrl + Alt + Q`): Habilita as *views* *top*, *right*, *front* e perspectiva.
- Clicando no pequeno ícone no canto superior do *canvas*, e arrastando para o lado ou para baixo, criamos uma nova janela.
- No menu inferior de cada *view*, temos a opção `view`, onde podemos alterar para qual vista queremos.
- `5 do teclado numérico`: Desativa a opção de perspectiva para as *views*.
- Caso desejamos desfazer estas *views*, basta selecionarmos o mesmo ícone de criação, porém o mantemos pressionando e arrastamos nossa *view* para cima da desejada, veja que surge uma seta, indicando que o mesmo vai sobrepor a outra *view*, após termos deixado somente uma *view*, voltamos para o modo perspectiva, teclado 5.

### Atividade 09 - Ferramentas de manipulação:

- **Obs.:** Para que possamos selecionar nossos objetos, clicamos no objeto desejado com o `Botão esquerdo do mouse`, e para voltarmos uma ação utilizamos o `Ctrl + Z`.
- *MOVE*: Com um objeto selecionado, clicamos em nosso **manipulador 3D** e selecionamos o ícone de seta, podemos observar que nos surge 3 coordenadas, onde podemos movimentar nosso objeto na coordenada desejada, e caso clicamos no círculo branco o movimentamos livremente.
- *ROTATE*: O mesmo principio do *move* vale para o *rotate*, basta selecionarmos o ícone representado por um pequeno arco.
- *SCALE*: E não foge deste principio o *scale*, onde selecionando o ícone ao lado do *rotate*, conseguimos escalonar nosso objeto, ou seja aumentar ele de tamanho conforme desejarmos.
- Após feito as alterações podemos pressionar `A` novamente para deselecionar nossa seleção.

#### Ferramentas de manipulação Rápidas:

- *MOVE RÁPIDO* (`G`): Para isso basta selecionarmos algum objeto, e utilizarmos a tecla `G` (*move*) em seguida a coordenada que queremos movimentar o objeto, ou seja teclamos `G` em seguida teclamos `X`, `Y` ou `Z` e para concluirmos a alteração do objeto clicamos com o `Botão esquerdo do mouse`.
- *ROTATE RÁPIDO* (`R`): Repetimos o mesmo procedimento do *move*, porém selecionamos objeto desejado e utilizamos a tecla de atalho `R` em seguida finalizamos a alteração clicando com `Botão esquerdo do mouse`.
- *SCALE RÁPIDO* (`S`): Para o *scale*, é o mesmo procedimento, porém selecionamos objeto desejado e utilizamos a tecla de atalho `S` em seguida finalizamos a alteração clicando com `Botão esquerdo do mouse`.

### Atividade 11 - Lidando com Primitivas:

- *3D Cursor*: Reposicionado com o `botão esquerdo do mouse`. Serve como ponto de criação de objetos na cena.
- `Del + Enter`: Apaga um objeto da cena.
- `Add > Mesh > Cube`: Adiciona um cubo na cena no local onde está posicionado o *3D cursor*.
- Existem diversos outros primitivos além do cubo, como `UV Sphere`, `Cone`, etc.
- `Shift + C`: Centraliza o *3D Cursor*.
- `Shift + A`: Atalho para adicionar objetos à cena.
- `N`: Abre as propriedades de um objeto. Nas propriedades também é possível mover um objeto pelas coordenadas em *Location*, e `Esc` para a alteração.

## Aula 02 - A pré-produção do projeto

### Atividade 01 - Ferramentas de seleção:

- `Botão direito do mouse`: Seleciona um objeto no *canvas*/cena. Segure `Shift` pressionado para ir adicionando mais objetos à seleção.
- `B` ("Seleção em janela"): Habilita selecionar mais de um objeto. Para deseleção mantenha `Shift` pressionado e clique no objeto.
- `Ctrl + Botão esquerdo do mouse`: Também permite selecionar mais de um objeto ao segurar e arrastar o *mouse*. Para deselecionar, utilize `Ctrl + Shift + Botão esquerdo do mouse`.
- `A`: Seleciona/deseleciona todos elementos da cena.

### Atividade 03 - Editando meshas modelagem:

- `Ctrl + N` e `Enter`: Faz um *reset* na cena.
- *Outliner*: Menu que fica no lado direito superior da tela em que aparecem todos os elementos da cena. É possível ocultar um elemento da cena clicando no ícone de olho, alinhado à direita do nome do elemento no *outliner*.
- `File > Import > Wavefront (.obj)`: Importa um objeto de extensão `.obj`.

#### Modo de edição:

- No canto inferior esquerdo, há um seletor que, por padrão, está escrito *Object Mode*. Clique nele e selecione *Edit Mode* para alterar para o modo de edição de objetos.
- `Tab`: Alterna entre os modos *Object Mode* e *Edit Mode*.
- Um pouco à direita dos modos, existem três ícones: *Vertex select*, *Edge select* e *Face select*.
- *Vertex* (vértice): É um ponto que serve para formar bordas e faces.
- *Edge* (borda/linha): É uma linha que conecta dois vértices.
- *Face* (face): É composta por 3 ou mais linhas.

### Atividade 05 - A formação dos polígonos:

#### O que são Polígonos?:

- São figuras fechadas compostas por 4 lados (*Edges*) ou mais.
- Tudo que tiver mais que 4 lados, chamamos de *N polygons*.
- O que tiver menos que 4 lados chamamos de triângulos, onde 2 triângulos podem formar um polígono de 4 lados.
