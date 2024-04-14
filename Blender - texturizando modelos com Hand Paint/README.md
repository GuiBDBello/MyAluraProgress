# Blender: texturizando modelos com Hand Paint

## Entendendo o UV Mapping

### O que é UV Mapping?

- UV Mapping: Processo de "abertura" de um objeto 3D, convertendo-o para um plano 2D. 
- U: Horizontal.
- V: Vertical.
- UV Editing: Viewport do Blender que permite trabalhar com a edição do UV de um objeto 3D.
- Ao selecionar um objeto e entrar no modo de edição (Tab), é possível ver a "malha aberta" do objeto.

### O UV Mapping Editor

- Texturas de caisa na internet: https://www.google.com/search?q=free+wood+box+texture&sxsrf=APq-WBv5Svgu7KeXAYeqi0VC6MueWmWESw:1646400090071&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiphZukxqz2AhUvrpUCHR-7B0IQ_AUoAXoECAEQAw&biw=1920&bih=979&dpr=1
- Ao adicionar um material em um objeto é possível alterar a propriedade "Base Color" para representar uma textura no objeto. Para isso, selecione o objeto e vá no menu de propriedades, sub-menu "Material", clique na "bolinha" do lado do "Base Color" e selecione "Image Texture".
- Ao adicionar uma textura, é possível visualizá-la no UV Editor. Nessa viewport, é necessário ajustar as faces do seu objeto para que elas contenham a parte correta da textura. Mova, escale, ajuste as faces para "texturizar" o objeto. Obs.: Alterar as faces nessa viewport NÃO altera o modelo do objeto 3D.

### Resolução e Mapa UV

- O Blender gera os UVs automaticamente de suas formas primitivas.
- Cada forma primitiva possui um formato diferente do UV.
- No modo de edição de um objeto, há o menu "UV" no topo da viewport, que permite fazer o "Unwrap" da UV de diferentes formas.

### Para saber mais: tipos de projeção

Como vimos em aula, a malha do objeto depende da sua forma base, pois todo objeto criado inicialmente possui uma malha predefinida e quanto mais moldamos a forma, criamos face, rotacionamos arestas, mais essa malha UV se distorce.

Para conseguir controlar melhor essa distorção e ajustar a malha no formato que queremos, podemos criar uma projeção automática quebrando as partes do objeto, como fizemos com o cubo. Muitas vezes, essas projeções facilitam muito a vida de quem vai abrir a malha do modelo.

#### Projeção Cilíndrica

A projeção cilíndrica vai tomar como base que a forma do objeto é um cilindro e vai gerar um corte no centro dele e abri-lo, como uma folha enrolada:

#### Projeção Planar

A projeção planar vai tomar como base um plano para criar o mapa UV (é um tipo de projeção comum nos softwares 3D). Dentro do Blender, podemos reconhecer como project from view, que é basicamente uma projeção plana baseada no que a câmera está vendo.

#### Projeção Esférica

A projeção esférica vai abrir a malha do objeto como se ele fosse uma esfera, gerando um corte de cima a baixo do objeto.

Também existe a projeção em caixa, que é a mais básica e que vimos nos primeiros vídeos.

## Organizando a UV da espada

### Abrindo a UV da lâmina

- A UV só aparece quando o objeto selecionado está no "Edit Mode".
- No UV Editor só aparecem as **faces selecionadas** do modelo 3D.
- Utilize a tecla de atalho "A" para mostrar o UV completo do objeto selecionado.
- "UV Sync Selection": Sincroniza a seleção das faces da UV com as faces do objeto em outras Viewports. O botão se encontra no canto superior esquerdo da janela "UV Editor".

#### Projetar UV

- É possível alterar o "modo de projeção" para faces específicas. Para isso, selecione as faces desejadas e selecione o tipo de "Unwrap" desejado.
- Para objetos simples é possível abrir o UV da seguinte forma:
1) Alterar o Viewpoint para o eixo X (Numpad 3)
2) Selecionar todas as faces do lado X do objeto
3) Selecionar no menu "UV" a opção "Project From View".
- A parte da frente do objeto deve ser corretamente representada na janela "UV Editor". Após isso, você pode escalar, movimentar e ajustar a UV livremente no "UV Editor".

### A UV do cabo com UNWRAP

- Shift + H: Oculta todos os objetos, exceto o objeto selecionado.
- Alt + H: Revela objetos ocultos.
- Seleção de aresta + Shift + Alt + Botão esquerdo do mouse: "Loop selection". Seleciona o "corte" do modelo 3D.
- Ao selecionar um "corte" inteiro da espada (por exemplo, a parte da frente, a parte de trás, a parte do lado, etc.) é possível clicar com o botão direito do mouse e selecionar "Mark Seam". Isso "separa" aquele pedaço selecionado para que o Blender saiba como separar a malha da melhor forma ao mapear o UV.

### Testando a UV

- Na janela "UV Editor" é possível abrir uma imagem para utilizar como referência.
- Selecione "New" e altere "Generated Type" para "Color Grid". Obs.: Essa imagem não é salva em seu computador, ela existe apenas no "cache" do Blender.
- A imagem de teste serve para verificar se a orientação da textura está correta, se existem distorções na textura, etc.

### Resolução e Mapa UV

- Quanto maior as faces no UV Editor, maior a resolução da textura aplicada na face. Quanto menor a face, menor a resolução da textura.
- Para jogos, os modelos 3D possuem toda a sua "pintura" em apenas uma textura. Uma forma de fazer isso é:
1) Selecionar todas as partes do objeto e pressionar "Ctrl + J" para juntar todas as partes em um objeto só.
2) Pressionar "Tab" para entrar no modo de edição do objeto.
3) Pressionar "A" para selecionar todas as faces.
4) No menu "UV" selecione "Pack Islands". O Blender "encaixa" todas as UVs no espaço definido para texturização.

## Técnica de pintura Hand Painting

### Organizando materiais

- Para começar a pintura, troque o layout do Blender para "Texture Paint".
- Crie uma textura para cada parte da espada.
- As texturas do Blender, quando criadas, ficam apenas em "cache" no Blender. Para salvar a textura em um arquivo, no Layout "Texture Paint", vá na janela "Paint", selecione "Image" e "Save".
