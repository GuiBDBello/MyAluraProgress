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
