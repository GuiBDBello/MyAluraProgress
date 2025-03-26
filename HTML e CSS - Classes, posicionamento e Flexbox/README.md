# HTML e CSS: Classes, posicionamento e Flexbox

- https://cursos.alura.com.br/course/html-css-classes-posicionamento-flexbox

## Seletores e posicionamento

### Classes no CSS

- Seletores: Eles permitem que você escolha quais elementos do seu código HTML serão estilizados com as regras que você define no seu CSS.

#### Tipos de seletores

- Seletores de Elemento (ou de Tag): Selecionam todos os elementos de um determinado tipo. Por exemplo, o seletor `p` seleciona todos os parágrafos `<p>` no seu HTML.
- Seletores de Classe: Selecionam todos os elementos que possuem uma determinada classe. Por exemplo, o seletor `.destaque` seleciona todos os elementos que têm a classe `destaque`.
- Seletores de ID: Selecionam um único elemento com um ID específico. Por exemplo, o seletor `#titulo` seleciona o elemento com o ID `titulo`.
- Seletores de Atributo: Selecionam elementos com base em um atributo e seu valor. Por exemplo, o seletor `a[href="https://www.alura.com.br"]` seleciona todos os links `<a>` que apontam para o site da Alura.

- Seletores de Classe: Permitem aplicar estilos a elementos HTML específicos, sem afetar outros elementos do mesmo tipo. São definidos no HTML usando o atributo class dentro da tag desejada. No CSS, são referenciados com um ponto (.) seguido do nome da classe.

#### Como usar classes no CSS

- No HTML: `<tag class="nome-da-classe">Conteúdo</tag>`.
- No CSS: `.nome-da-classe { propriedades: valores; }`.

### Para saber mais: seletores

- [Organizando o CSS no seu projeto](https://www.alura.com.br/artigos/organizando-o-css-no-seu-projeto)
- [SMACSS (Scalable and Modular Architecture for CSS)](https://smacss.com/)
- [Nomes de classes no CSS](https://www.alura.com.br/artigos/nomes-de-classes-no-css)
- [BEM (Block Element Modifier)](https://getbem.com/introduction/)
