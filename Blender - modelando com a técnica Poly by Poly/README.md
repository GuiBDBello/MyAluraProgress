# Blender: modelando com a técnica Poly by Poly

## Técnica poly by poly

### Técnicas de modelagem

- Box modeling: Inicia com uma "caixa" ou uma forma primitiva, e vai "moldando" o objeto.
- Surface modeling: Cria linhas vetoriais e vincula essas linhas para criar "planos", e depois é dada a devida volumetria ao objeto. Muito utilizado em modelagem técnica (hard surface/objetos inorgânicos).
- Subdivision modeling: Parecida com Box modeling. Cria a forma base do objeto, com poucos polígonos, e depois aplica subdivisões para deixar o objeto mais "suave".
- Sculpting: Pega uma "massa" 3D e vai moldando essa massa. Gera modelos extremamente detalhados, mas não é muito utilizado para games, pois a contagem de polígonos é muito alta.
- Poly by poly: Cria face por face e vai vinculando elas para formar o modelo 3D. Permite melhor controle do fluxo de malha e da quantidade de polígonos.

### O que é retopologia

- Retopologia: reduz a "densidade" do modelo 3D.
- A retopologia é o processo de reconstrução da malha de um modelo 3D. Fazemos isso para corrigir eventuais erros e otimizar o modelo 3D. Quando recriamos um modelo através da retopologia, simplificamos a superfície tornando o arquivo mais leve e de fácil alteração.

### Para saber mais: Pipeline de modelagem

#### Primeiro passo

Durante a produção de qualquer elemento 3D dentro de um ambiente de trabalho e em caráter de estudo, é importante construir o concept da peça a ser produzida, sendo ela um personagem ou uma cena.

O concept, como já comentado, nada mais é do que uma **arte conceitual para identificar cores, formas e demais características do que vai ser modelado**.

#### Segundo passo

Após a criação do concept, podemos ter o model sheet ou blueprint. São aqueles desenhos técnicos sobre o que vai ser modelado, e essa etapa é bastante comum. No entanto, existem projetos em que apenas o concept é o suficiente para iniciar a produção.

#### Terceiro passo

Após ter as artes necessárias para conseguir dar início ao modelo, existe o momento de construí-lo em alta fidelidade. É nesse processo de escultura que a limitação de polígonos é ignorada e, para conseguir representar as referências de maneira fiel, é possível fazer o que chamamos de “bake”, que é extrair as texturas desse modelo de alta fidelidade para que sejam usadas mais tarde.

Durante o processo, a limitação de quantidade de polígonos não é levada em consideração. É possível detalhar à vontade como será o modelo.

#### Quarto passo

Essa é a etapa que vamos entender melhor durante o curso: a construção **Poly by Poly ou retopologia** do modelo.

A retopologia é um termo usado para definir o processo de pegar o modelo esculpido, sem limites de polígono e nem organização de malha, e remodelar em cima dessa escultura, organizando sua malha para que seja funcional em animações e engines de games e também para reduzir a quantidade de faces (polígonos) e otimizar o peso do modelo.

Após esses processos, as próximas etapas são animação, texturização entre outras, mas que já não fazem mais parte do processo de modelagem em si.

### Organizando o Blender

- Criar novas áreas com visão ortogonal para visualizar as referências.
- Adicionar as imagens de referência.
- Desabilitar os Overlays "Floor", "X" e "Y".
- Acessar "Edit > Preferences... > Keymap" e habilitar "Tab for Pie Menu".
- Habilitar os filtros de seleção de objetos no menu de Hierarquia da cena, e desabilitar a seleção das referências.

## Modelando a cabeça

### Iniciando a cabeça

- Criar um objeto plano (Shift + A > Mesh > Plane).
- Posicionar centralizado na imagem de referência.
- Criar um ponto de referência.
    - Alterar o ponto de origem (Shift + Botão direito do mouse) para o centro da face.
    - Shift + A > Empty > Plain Axes
- Criar um loop cut (Ctrl + R) na vertical.
- Deletar a face da esquerda.
- Adicionar modificador Mirror
    - Verificar se o "Axis" habilitado está correto.
    - Em "Mirror Object", selecione o objeto Plain Axes criado acima.
    - Habilitar "Clipping" e "Merge"

### Para saber mais: Add-ons

O Blender é uma ferramenta open source, ou seja, é uma ferramenta em que a comunidade que a utiliza tem liberdade de interagir com seu código-fonte para indicar novas funcionalidades e corrigir problemas.

Essa liberdade é o que incentiva a criação de muitos Add-ons, que é a mesma coisa que “plugins para a ferramenta”. Existem vários desses já inseridos no Blender, assim como outros que você pode baixar e instalar para auxiliar em seu projeto.

#### ADD-ON INTERNO

Para encontrá-los, podemos ir em EDIT > PREFERENCES > ADD-ON

Podemos, por exemplo, habilitar um ADD-ON cujo nome é CELL FRACTURE, que permite criar um elemento quebrado de forma rápida e simples. Caso queira trabalhar com animação de simulação, onde algo vai ser “espatifado”, esse é um ótimo ADD-ON para se utilizar.

#### ADD-ON EXTERNO

Podemos também usar esses Adds de maneira externa, ou seja, baixar ou comprar em algum site para inseri-los no Blender e utilizá-los.

### Dando forma à cabeça

- Comece selecionando as arestas superior e inferior e use a extrusão para moldar a visão lateral da referência.
- Dica: não faça muitas extrusões, deixe o objeto mais "quadrado". Não é necessário muito detalhamento nessa fase da criação do modelo 3D. É assim que a modelagem "Poly by poly" funciona, primeiro faça o simples para depois ir para o complexo.
- Selecione uma das arestas laterais, e então segurando Alt, selecione a aresta adjacente, para que todo o "corte" lateral seja selecionado. O processo a seguir é: extrusão ("E"), escala ("S"), posicionamento ("G"). Mas atenção: Não "feche" a cabeça, pois terá problemas com o fluxo de malha. Faça esse processo até a orelha, e depois no curso veremos como fechar a cabeça.

### Fluxo de malha

- Para a lateral da face, é possível utilizar a ferramenta "Poly builder" ou realizar a extrusão das arestas.
    - Selecione a aresta da lateral e faça a extrusão para o centro da cabeça.
    - Para evitar a utilização de triângulos, selecione dois vértices e pressione "M", e selecione "Merge At Center" para ir "fechando" a lateral da cabeça, e mantendo o fluxo da malha.
- Selecione duas arestas próximas e pressione "F" para juntá-las, criando uma nova face.

### Modelando a orelha

- Ao criar um novo Mesh dentro do modo de edição, o novo Mesh fará parte do objeto existente.
- "L": Seleciona todos os elementos linkados àquele objeto 3D.
- "Shift + H": Esconde todos os objetos da sua visão, exceto o que está selecionado.
- "Alt + H": Mostra todos os objetos na sua visão.
- Para juntar os dois objetos, delete as faces que vão se juntar, selecione os vértices dos dois objetos e pressione "M" > "Merge At Center".

### Para saber mais: Join e Merge

#### JOIN

A propriedade Join tem como objetivo unir dois **OBJETOS** distintos, por exemplo: se formos modelar um carro, será um modelo composto por várias formas e, por mais simples que seja, teremos o chassi do carro e os pneus de forma separada.

Ao usar a propriedade **JOIN**, estamos informando para o Blender que os dois objetos que foram criados e modelados de forma separada agora fazem parte de uma coisa só, ambos se tornaram um objeto único.

Usamos essa propriedade para conseguir reduzir a quantidade de objetos, vincular duas malhas distintas em uma única malha (como fizemos com a orelha do nosso personagem), organizar elementos entre outras funções a depender do projeto.

#### MERGE

A propriedade de **MERGE** tem como finalidade unir as propriedades básicas do objeto. Quando usamos a propriedade JOIN, apesar dos dois objetos agora fazerem parte de uma coisa só dentro da sua edição, o Blender consegue entender que são duas coisas distintas e, por isso, eles não estão de fato juntos.

Com o **MERGE** sendo usado, podemos selecionar o vértice de um com o vértice de outro objeto e mesclá-los em um só. Existem algumas formas de executar essa tarefa, são elas:

- *Merge at center* - Vai unir no centro dos dois ou mais vértices selecionados.
- *Merge at cursor* - Vai unir baseado onde o cursor se encontra.
- *Collapse* - Vai unir os vértices ao centro mas individualmente entre objetos unidos.
- *Merge at last* - Vai unir todos os vértices em cima do último vértice selecionado.
- *Merge at first* - Vai unir todos os vértices em cima do primeiro vértice selecionado.
- *Merge by distance* - Vai unir os vértices baseado em uma distância mínima definida dentro do Blender.

## Modelando o corpo

### Modelando braços e pernas

- Ferramenta "Snap": A ferramenta Snap "gruda" vértices/arestas/faces durante o "Transform, porém mantém os dois separados.
    - Habilitar a ferramenta "Snap" e alterar "Snap To" de "Increment" para "Vertex".
- "N": Propriedades.
    - "N" > Tool > Options > "Auto Merge": Ativando o "Auto Merge" juntamente com o "Snap", habilita a fusão de vértices próximos durante o "Transform".

### Para saber mais: Separate e Split

#### SEPARATE

Separate tem o nome auto-explicativo. Quando usamos essa propriedade em um objeto, estamos **destacando as partes selecionadas** do objeto real e, quando estamos no modo de edição de objeto, podemos selecionar suas faces de forma independente e é exatamente por esse motivo que podemos destacar essas partes. O interessante é que esse objeto vai se tornar algo novo e que pode ser selecionado dentro do modo de objeto.

Essa propriedade é importante, pois imagine se você estiver modelando um braço, mas ao uni-lo de forma equivocada ou se por algum motivo você quiser destacar essa parte do modelo para fazer algum ajuste, é possível usar o separate.

Para encontrar o separate, basta ir até o Menu>Mesh>Separate ou apertar a tecla de atalho P e dentro das suas propriedades temos:

- *Separate Selection*: Como o nome diz, essa função pega o que está selecionado e faz a separação do objeto real;
- *Separate by Material*: Esse método de separação identifica todos os materiais diferentes aplicados no objeto e os separa;
- *Separate by Loose parts*: Esse método vai identificar todos os objetos que não estão vinculados em uma única malha, mas que ainda fazem parte do mesmo objeto. O Separate by Loose faz o contrário da ferramenta JOIN (lembra dela?): tudo o que foi dado “join” volta a ser separado.
Importante: o separate é muito útil para trabalhar em modelos mais complexos.

#### SPLIT

Essa propriedade separa partes do objeto sem criar um novo. Ela faz o contrário do que a propriedade Merge, então se quisermos separar uma face do objeto podemos apenas aplicar a propriedade MESH > SPLIT.

Ela possui também formas distintas de uso, como:

- *Selection*: Separa o que está selecionado;
- *Faces by Edges*: Separa a edge da face selecionada;
- *Faces e Edges by vertex*: Separa os vértices das faces selecionadas.
