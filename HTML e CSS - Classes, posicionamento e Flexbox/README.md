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

### Para saber mais: Class

- [Class (MDN)](https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/class)
- [Organizando o CSS no seu projeto](https://www.alura.com.br/artigos/organizando-o-css-no-seu-projeto)
- [SMACSS (Scalable and Modular Architecture for CSS)](https://smacss.com/)
- [Nomes de classes no CSS](https://www.alura.com.br/artigos/nomes-de-classes-no-css)
- [BEM (Block Element Modifier)](https://getbem.com/introduction/)

### Para saber mais: seletores

- [Seletores CSS (MDN)](https://developer.mozilla.org/pt-BR/docs/Web/CSS/CSS_selectors)
- [Reset CSS](https://www.alura.com.br/artigos/o-que-e-reset-css)
- [Eric Meyer's Reset CSS](https://meyerweb.com/eric/tools/css/reset/)
- [CSS: Seletores avançados][https://www.alura.com.br/artigos/css-seletores-avancados-aplicacoes-web]

### Box Model

O **Box Model** é um conceito fundamental no CSS que descreve como os elementos HTML são representados como caixas retangulares na página. Cada elemento possui quatro áreas principais que compõem essa caixa:
1. **Conteúdo**: É a parte visível do elemento, onde o texto, imagens ou outros conteúdos são exibidos. É o núcleo da caixa.
2. **Padding (preenchimento)**: É o espaço entre o conteúdo e a borda do elemento. O padding cria um espaço interno, afastando o conteúdo das bordas.
3. **Border (borda)**: É a linha que envolve o padding e o conteúdo. A borda pode ter diferentes estilos, espessuras e cores.
4. **Margin (margem)**: É o espaço externo que separa o elemento de outros elementos ao seu redor. A margem cria um espaço entre a borda do elemento e os elementos adjacentes.

- Reset CSS simples: 
```css
* {
    margin: 0;
    padding: 0;
}

```

## Posicionando mais elementos

### Height e box-sizing

- `vh`: Viewport Height. Ex.: `height: 100vh`.
- `box-sizing`: Define como as dimensões de um elemento são calculadas. Ex.: `box-sizing: content-box` e `box-sizing: border-box`.
