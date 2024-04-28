# Blender: riggando e animando seu personagem

## A animação no 3D

### Tipos de animação

- Motion: Animação feita de forma automática, pelo software. É uma animação mais fluida, orgânica.
- Simulação: Baseada em física, existe colisão entre os elementos. Ex.: roupas, fluidos.
- Frame by frame: Mais comum em animações 2D. É desenhada quadro a quadro.
- Motion capture: Captura de movimentos de um corpo real, e levar para o computador aplicar em um modelo 3D.

### Organizando a área de trabalho

- `Numpad 0`: Alterna a visão da câmera.
- Output properties: Submenu no menu de propriedades que contém as propriedades de "saída" do objeto. Nesse menu, há propriedades como: formato de saída, Frame Rate, Frame Range, etc.
- Janela "Playback": Linha do tempo da animação. Contém propriedades básicas da animação.
- Janela "Dope Sheet": A linha do tempo da animação, porém com as propriedades de cada objeto animado. Define quais propriedades são alteradas em cada objeto.
- Janela "Graph Editor": Para quem trabalha com animações do tipo Motion.
- Janela "Drivers": Para quem trabalha com controladores. Gera pontos de controle.
- Janela "Nonlinear Animation": Cria blocos de animação para serem reutilizados.

### Para saber mais: janelas de animação

#### TIMELINE

A timeline ou linha do tempo é a janela mais padrão em qualquer software de animação. Nela é onde você vai conseguir definir os pontos de animação necessários para qualquer objeto, além de poder definir a quantidade de quadros que sua animação terá e dar o play, pausar, ir para o último quadro ou quadro seguinte (também conhecido como playback).

#### DOPE SHEET

A dope sheet pode ser vista como a janela de propriedades individuais da sua animação. Quando vamos animar algo, podemos movimentar no eixo X, Y ou no eixo Z, portanto, se você quiser visualizar de maneira individual cada uma dessas propriedades, a dope sheet é a janela que te auxiliará.

É importante saber que, diferentemente das outras janelas para animação, a dope sheet possui subcategorias de trabalho que você consegue achar clicando no menu *Dropdown*, que fica no canto superior esquerdo da janela.

Essas subcategorias funcionam para trabalhar de maneira distinta às configurações mais densas das propriedades animadas.

#### GRAPH EDITOR

O graph editor é uma janela de **extrema importância** para qualquer pessoa animadora em qualquer software. É através desta janela que podemos definir o fluxo da nossa animação, ou seja, trabalhar por meio de gráficos a intensidade dos movimentos, a suavidade, a fluidez. É uma ferramenta para se conseguir aplicar bem os conceitos teóricos da animação tradicional e do motion, como *eases in and out* (suavidades de entrada e saída).

#### DRIVERS

A janela de drivers é onde conseguimos trabalhar as animações via expressão, ou seja, animações automatizadas usando códigos e vínculos entre objetos.

É através dessa janela que conseguimos fazer com que, ao movimentar um objeto para cima, outro objeto rotacione criando esses vínculos de controle.

#### NONLINEAR ANIMATION

Imagem da janela de nonlinear animation

Esta janela é responsável por criar animações baseadas em ações criadas pela pessoa animadora. Por exemplo, podemos criar um bloco de animação da personagem andando e reutilizar esse bloco de animação sempre que for preciso.

Essa janela permite visualizar os Sets de animação que exportamos para as engines de games quando queremos que a personagem tenha a ação de pular, andar, correr etc.

### Entendendo os keyframes

- Z: Altera modo de visualização.
- As propriedades dos objetos estão no sub-menu "Object Properties", na janela de propriedades.
- A animação no Blender consiste em:
    - Selecionar frame inicial
    - Definir estado inicial do objeto
    - Marcar quadro-chave
    - Selecionar próximo frame
    - Modificar estado do objeto
    - Marcar quadro-chave novamente
- É possível animar qualquer propriedade de um objeto que possua o ícone de um "ponto" (Animate property) no lado da propriedade.
- A animação funciona baseado em "quadros-chave" (keyframes). O Blender interpreta os valores que deve salvar o estado do objeto.
- I: Adicionar keyset.
- K: Adicionar keyset por grupo/tipo.

## Animação por Bones

### O que são Bones

- Para modelar um personagem, é utilizado uma "Armature".
- Armature: são os "ossos" do personagem. Deve ser vinculado à malha do objeto para quando movimentar o osso, a malha seja movimentada também.
- Dica: antes de criar a Armature, verifique se o personagem está apontando para o eixo Y. Se não estiver, podem ocorrer problemas com as técnicas de simetria, técnicas de espelho com os ossos (o Blender pega como referência o eixo X).
- Ao selecionar o osso, aparecem novos sub-menus na janela de propriedades:
    - Object Data Properties: propriedades da Armature.
    - Bone Properties: propriedades do osso.
    - Bone Constraint Properties: propriedades das "tensões" que o osso possui.
- Para começar, selecione a Armature/Bone > Object Data Properties > Viewport Display, marcar "Name" e "In Front".

### Montando o esqueleto

- Numpad 1: Visão -Y.
- Ctrl + Numpad 1: Visão Y.
- Numpad 3: Visão X.
- Selecionar o osso e pressionar Tab para mudar para o "Edit Mode".
- Selecionar a "saída" do osso e pressionar "E" para extrusão de um novo osso. Isso cria uma estrutura em "família" dos ossos, em que cada osso novo é dependente do osso anterior. Ou seja, se movimentar um osso, também irá movimentar os ossos criados a partir dele.
- É importante renomear os ossos para seguir um padrão.
- No modo edição de um osso, Shift + A: Cria um novo osso.
- Após criar os ossos de um lado, selecione todos os ossos, por exemplo, do lado direito, e então no menu superior "Armature", selecione "Names > Auto-Name Left-Right".

### Para saber mais: convenção de nomes

#### OS BONES

Os bones possuem propriedades distintas e sua organização afeta diretamente essas propriedades e script. Por isso, existe uma certa “convenção” no Blender para que você consiga nomear de forma correta os ossos para que ocorra tudo de maneira correta ao tentar espelhar ou aplicar outros tipos de script.

De acordo com o próprio manual do Blender estas são as indicações:

- Primeiro você deve dar nomes que tenham um bom significado aos ossos, como perna, braço, pé, etc.. Evite usar nomes vagos como bone01 ou parte_cima_perna.
- Se você for criar bones que serão replicados depois como um espelho use os separadores:
    - Esses separadores podem vir antes ou depois do nome “L_antebraco” ou “antebraco.R”: o L representa a palavra LEFT (esquerda) e o R representa a palavra RIGHT (direita)

O Blender reconhece outras extensões além de apenas L ou R, esta é a lista de extensões que podem ser usadas nos nomes:
- nada separando a palavra left ou right -> maoLeft → maoRight
- “_” (símbolo de underline) -> mao_L → mao_R
- “.” (símbolo de ponto) -> mao.l → mao.r
- “-” (símbolo de traço) -> mao-l → mao-r
- ” ” (símbolo de espaço) -> mao LEFT → mao RIGHT

### Criando as IK

- Ctrl + P: Para vincular ossos separados, selecione ambos os ossos e então selecione no menu superior "Armature > Parent" a opção "Make" e então clique em "Keep Offset" (ou use as teclas de atalho).
- IK (Inverse Kinematic): Tensão entre os ossos que causa um movimento "natural".
- Para fazer o IK da perna, siga os passos:
    - Edit Mode, extrusão de novo osso na "dobra", Alt + P > Clear Parent, selecionar osso, sub-menu "Bone Properties", desabilitar Deform. Isso ocorre pois esses elementos não se comportarão como ossos, mas sim como "Controladores".
    - Pose Mode, selecione o osso oposto adjacente ao osso do IK, sub-menu "Bone Constraint Properties" > Add Bone Constraint > Tracking > Inverse Kinematics. Em "Target", selecione a Armature. Em "Bone", selecione o osso oposto adjacente (o osso criado para o IK). Desmarcar "Use Tail". Em "Chain Lenght", selecionar a quantidade de ossos até o osso Root. Em "Pole Target", selecione Armature, e em "Bone", selecione o IK do joelho. Caso o pé rotacionar, altere o "Pole Angle" para 90°.
