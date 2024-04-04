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
