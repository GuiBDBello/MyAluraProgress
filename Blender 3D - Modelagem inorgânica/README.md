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

### Atividade 06 - Utilizando Loops Extrude:

- `Shift + A` (*Add*): Adiciona um objeto padrão do *Blender* à cena.

#### Extrude:

- `Alt + E` (*Extrude*) ou `E` (*Extrude Region*) ou *Extrude Individual*: .
- Possibilita realizar uma extrusão (para dentro ou para fora de um objeto).
- 99.9% das vezes o *Extrude* é utilizado em faces.
- No *Edit Mode*, no lado esquerdo da tela, dentro do submenu *Add*, selecione `Extrude Individual`.
- Para realizar um *Extrude* para dentro do objeto, selecione *Extrude* e pressione `S`, para escalonar o polígono que ficará na parte de dentro do objeto.

#### Loop:

- `Ctrl + R` (*Loop Cut and Slide*): "Recorta" uma face, criando novas faces nessa divisão.
- Linha de um ponto à outro. O ponto inicial deve ser o mesmo que o final.
- No *Edit Mode*, no lado esquerdo da tela, dentro do submenu *Add*, selecione `Loop Cut and Slide`. Agora, é preciso selecionar uma "face" para criar o *loop*. Selecione e clique com o `Botão esquerdo do mouse`.

## Aula 03 - Da referência à primeira blocagem

### Atividade 01 - Setando as blueprints blender:

- `N`: Abre a janela *Properties*.
- `Numpad 1`: Altera a visão da cena para *Front*.
- `Numpad 3`: Altera a visão da cena para *Right*.
- `Numpad 7`: Altera a visão da cena para *Top*.
- `Ctrl + Numpad 1`: Altera a visão da cena para *Back*.
- `Numpad 5`: Desabilita a perspectiva. Altera para o formato "ortogonal".

#### Blueprints:

- Um pouco mais limitado que outros *softwares* como o *Maya* ou o *3ds Max*.
- Para cada imagem adicionada, faça o seguinte:
1) `Numpad X` e `Numpad 5` (onde `X` é o número da visão): Altera a visão da cena e desabilita a perspectiva.
2) Na janela de *Properties*, vá na opção `Background Images`, ative-a e clique em `Add Image`.
3) Ainda nas *Properties*, clique em `Open` e selecione a imagem respectiva para a visão selecionada no passo 1.
4) Repita os passos 1-3 para cada visão.
- Pressione `Ctrl + Alt + Q` para alternar para a *Quad View*.
- **Obs.:** Recomenda-se adicionar as imagens para as visões *Front*, *Right* e *Back*, pois a *Quad View* mostra essas visões.

### Atividade 03 - Finalizando adição de blueprints:

- `Z`: Alterna entre o modo *Wireframe* (mostra apenas as linhas do objeto) e o modo *Solid*.
- Alinhe o seu objeto primitivo com as imagens de referência. A imagem é movida na janela *Properties*, nos valores `X` e `Y`. Utilize as ferramentas do *Edit Mode*, como escala, para ajustar o seu modelo.

### Atividade 05 - Blocagem inicial da TV:

- Ao criar objetos primitivos, é possível alterar a quantidade de vértices que ele possui, deixando-os mais ou menos detalhados.
- Ao adicionar um objeto, é aberta uma janela no canto inferior esquerdo da tela. **Obs.:** Se você mover ou editar o objeto, essa janela irá fechar, pois é dada como finalizada a criação do objeto.

### Atividade 07 - Compondo elementos menores:

- `Shift + D`: Duplica o objeto selecionado.

## Aula 04 - Definindo a estrutura final do blocking

### Atividade 01 - Adicionando a antena:

- *Transform Orientation* (ao lado dos ícones de *Translate*, *Rotate* e *Scale*): Permite alterar a orientação da "transformação" de um objeto. Alterando essa propriedade de `Global` para `Local`, é possível mover, rotacionar e escalonar utilizando suas transformações locais.

### Atividade 03 - Continuando a blocagem base:

- *Smooth* (dentro de *Shading* no menu lateral esquerdo): Altera o ângulo dos polígonos, para deixá-los mais suaves.

### Atividade 05 - Finalizando a guideline:

- *Guideline*: Linha guia de referência. Seria a base do *concept*, ou seja, o nosso objeto na forma mais "bruta", sem estar lapidado.

## Aula 05 - Trabalhando com profundidade

### Atividade 01 - Comandos do Pure Ref:

- https://www.pureref.com/about.php
- O *PureRef* foi criado para ser uma ferramenta simples e leve para os artistas organizar e visualizar suas imagens de referência.

#### Adicionar imagens:

- Você pode arrastar e soltar arquivos do seu computador ou imagens diretamente dos navegadores.
- Você também pode usar o menu do `Botão direito do mouse` ou `Ctrl + V` para colá-los.

#### Edite imagens:

Você pode editar suas imagens de algumas maneiras para atender às suas necessidades de referência. Você pode:
- Selecionar uma ou mais
- Focar em uma ou mais (`Duplo clique` / `Espaço`)
- Girar (livremente usando `Ctrl` ou com *Snap* adicionando `Shift`)
- Flipar
- Escalonar
- Cortar
- Alterar a opacidade
- Excluir
- Salvar imagens

#### Controle o canvas:

O *canvas* é sua cena que também pode ser usada de várias maneiras. Essas características incluem:
- Otimizar a tela em torno de suas imagens
- Encaixar suas imagens.
- Deixar ele sempre sobreposto sobre janelas
- Ficar transparente para o uso do *mouse*
- Bloqueie a tela para edição
- Tela clara
- Desfazer refazer
- Reinicie a câmera
- Salve / carregue suas cenas
- Exporte cenas

#### Costumização:

Você pode personalizar a aparência e os atalhos de teclado do *PureRef* para atender às suas necessidades.
- Personalize cores
- Salvar temas de cores
- Altere a opacidade mestre
- Personalize as teclas de atalho

### Atividade 03 - Marcações para cortes:

#### PureRef:

- *Download* do *PureRef*: https://www.pureref.com/download.php
- `Botão direito do mouse` e `Arraste o mouse`: Move a janela do *PureRef*.
- `Botão esquerdo do mouse` (nas extremidades da janela): Redimensiona a janela.
- `Z + Botão esquerdo do mouse` e `Arraste o mouse para os lados`: Aumenta e diminui o *zoom*.
- `Ctrl + Shift + A`: Força com que a janela do *PureRef* fique por cima de outras janelas, sempre à vista.

#### Blender:

- Selecione um objeto e pressione `Shift + H`: Esconde todos os objetos não selecionados. Serve para "isolar" um objeto, para trabalhar apenas com ele. `Alt + H` faz os outros objetos reaparecerem.

##### Cortes/Curvas:

- Entre no `Edit Mode`.
- Altere para `Face Select` (seleção de face).
- Selecione uma ou mais faces.
- Pressione `Ctrl + F` e selecione `Inset Faces` (ou use o atalho `I`).
- Arraste o *mouse* para definir o tamanho do corte e clique com o `Botão esquerdo do mouse` para concluir.

### Atividade 05 - Dando profundidade:

#### Extrude:

- Entre no `Edit Mode`.
- Altere para `Face Select` (seleção de face).
- Selecione uma ou mais faces.
- Pressione `E` e arraste o *mouse* para fazer o *Extrude* e clique com o `Botão esquerdo do mouse` para concluir.

#### Subdivision Surface:

- No menu lateral direito, selecione o ícone da chave fixa, `Add Modifier` e selecione `Subdivision Surface`.

#### Arredondando bordas:

- Entre no `Edit Mode`.
- Altere para `Edge Select` (seleção de linha).
- Segure `Alt` e selecione uma ou mais linhas (selecione as bordas do objeto). Isso irá selecionar as linhas circularmente, até elas se encontrarem, formando um "círculo".
- Pressione `Ctrl + E` e selecione `Bevel` (ou utilize o atalho `Ctrl + B`). A ferramenta também é acessível pelo menu do canto inferior esquerdo `Mesh > Edges > Bevel`.
- Arraste o *mouse* para definir o `Bevel` e clique com o `Botão esquerdo do mouse` para concluir.
- Pressione `F6` caso queira editar as propriedades do `Bevel`. O campo `Segments` é a quantidade de "cortes" que a borda terá.

#### Dica:

- Para auxiliar a visualização da profundidade do modelo, vá em `View > Properties > Shading` (atalho `N`) e ative `Ambient Occlusion`.
- No `Face Select`, se você segurar `Alt` e selecionar uma face, serão selecionadas todas as faces "circularmente".

### Atividade 08 - Finalizando quadro TV:

- Selecione dois vértices e pressione `J` para adicionar uma nova linha entre eles.
- `Alt + M` e `At Last` (*Merge*): Une dois vértices no último vértice selecionado.

## Aula 06 - Refinando partes menores

### Atividade 01 - Criando quadros menores:

- `Ctrl + E` e `Bridge Edge Loops`: Preenche as lacunas entre dois loops.

## Aula 07 - Trabalhando no corpo do prop

### Atividade 01 - Criando a base vidro:

- `Ctrl + E` e selecione `Make Edge Face` (ou apenas `F`): Adiciona uma face dentro das linhas selecionadas.
- `Ctrl + I`: "Inverte" uma seleção. **Ex.:** No `Edit Mode`, se você escolher algumas faces e pressionar `Ctrl + I` as faces que você selecionou serão deselecionadas, e as que não estavam selecionadas serão selecionadas.

### Atividade 04 - Adicionando a tela:

- Em `Edit Mode`, no menu do lado esquerdo, em `Mesh Tools > Add`, o botão `Knife` serve para adicionar vértices em qualquer linha no caminho entre dois vértices.

#### Proportional Editing:

- No menu inferior, há um botão *dropdown* com a função de `Proportional Editing mode` que vem desabilitado por padrão. Habilite-o para editar proporcionalmente seus objetos.
- Pressione o `Botão esquerdo do mouse` e role o *scroll* do *mouse* para aumentar o raio que será alterado.

## Aula 08 - Definindo o modelo central

### Atividade 03 - Botões de canais:

- Selecione dois vértices e pressione `J` (*connect vertex*) para adicionar uma linha entre eles.

## Aula 09 - Adicionando os fios

### Atividade 03 - Um pouco de boolean:

- O *boolean* serve para "N" funções, então podemos utilizar ele à nosso favor para agilizar ou facilitar o desenvolvimento de projetos específicos.

#### Union:

- Dentro da ferramenta de *boolean* localizada na aba *modifiers* temos 3 comandos. Começando pelo `Union`, como nome já disse, podemos utilizar essa opção, para unirmos nossas meshas, formando assim dois objetos em um só e podendo assim criar formas com mais facilidade sem perder tempo.

#### Difference:

- A utilização do `Difference` é umas das opções do *Boolean* mais usadas no 3D. Com essa opção, podemos criar desenhos complexos em nossa malha, de uma forma rápida e precisa, já obtendo assim uma ideia inicial do resultado final da modelagem.

#### Insert:

- Já o `Intersection` faz o processo inverso do `Difference`, onde ele pega nossos dois objetos, e preserva apenas ponto de intercessão desses objetos, dando assim nova forma para o mesmo.
