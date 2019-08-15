# HTML5 e CSS3 II: Turbinando as suas páginas

## Aula 01 - Pixels?

### Atividade 01 - Medidas relativas:

- Pixel: cada *pixel* é um "pontinho" na tela do seu computador;
- Além dos pixels, existem outras medidas, como o `%`, que é relativa ao elemento pai;
- Ao usar pixels, pode ocorrer um problema: se definir o tamanho da fonte da página em pixels, o usuário pode alterar o tamanho da fonte do navegador, o que pode alterar (ou não) vários elementos da página relativos à esse tamanho;
- O *padding*, ao utilizar `%`, se baseia no valor da largura do elemento. Para se basear no tamanho de fonte, utiliza-se `rem`;
- `1.25rem`: 1.25 x tamanho da fonte do navegador. Se a fonte for `20px`, ela se tornará `25px` (`20 * 1.25 = 25px`);
- `1ch`: largura do caractere `0` da fonte escolhida. É possível mudar o número 1 para o valor desejado;
- `1.25em`: 1.25 x tamanho da fonte do elemento;
- `px`: é absoluto;
- `em`: tem como padrão a fonte do elemento pai;
- `rem`: tem como padrão a fonte do navegador. É possível, também, controlá-lo pelo `font-size` do elemento/tag `html`;
- `ch`: tem como base a largura do caractere zero da fonte usada;


## Aula 02 - Absolute mais a fundo

### Atividade 01 - Usando o position absolute:

- Para tirar algum elemento do "fluxo" da página, pode-se utilizar a propriedade `position: absolute`;
- O `position: absolute` é relativo ao primeiro elemento-pai que possui um `position` definido. Se não possuir nenhum, é relativo ao navegador;
- Para isso, na classe do elemento-pai, adicione `position: relative`;


## Aula 03 - Bordas arredondadas e outras novidades do CSS3

### Atividade 01 - Propriedade border radius e novidades do CSS3:

- Antigamente, eram utilizadas imagens para criar um bloco com bordas arredondadas;
- Hoje, com o `CSS3`, existe uma propriedade chamada `border-radius` que simplifica a criação dessas bordas;
- `div { border-radius: 10px 0; }`: cria uma `div` com as bordas superior-esquerda e inferior-direita arredondadas em `10px`;
- É possível, também, criar bordas elípticas, no formato: `border-radius: rx rx rx rx / ry ry ry ry;`;
- Ainda assim, com o surgimento de novas funcionalidades, como a citada acima, os diversos navegadores divergem no formato em que seus valores são definidos;
- Os navegadores, para testar seu próprio formato das propriedades, adicionaram um prefixo para identificar-se:
  - `-webkit-`: *Google Chrome*, *Safari* e *Opera* (versões novas);
  - `-moz-`: *Mozilla Firefox*;
  - `-ms-`: *Internet Explorer* e *Edge*;
  - `-o-`: *Opera* (versões antigas);
- É importante ressaltar que quando os navegadores utilizam prefixo em uma propriedade, significa que ela está em *BETA*, ou seja, em fase de testes;
- <a>caniuse.com</a>: site que cataloga funcionalidades para mostrar as versões em que elas estão disponíveis;


## Aula 04 - Transformações

### Atividade 01 - Transformações geométricas usando CSS3:

- `transform`: propriedade que rotaciona elementos CSS;
- **Ex.:** `div { transform: rotate(30deg); }`
- É possível transformar o tamanho de um elemento:
- **Ex.:** `div { transform: scale(1.5); }`
- Também pode-se entortar um elemento:
- **Ex.:** `div { transform: skew(20deg); }`
- Ou até deslocar o elemento:
- **Ex.:** `div { transform: translate(10px, 50px); }`
- `translateX`, `translateY` e `translateZ`: desloca um elemento em um eixo específico;
- A projeção de uma cena 3D é chamada de "perspectiva". É possível regular essa projeção com a propriedade `perspective`;
- `perspective-origin`: o ponto de origem do "cone" de projeção de uma perspectiva;

#### Exemplos:

- `bolas { perspective: 4px; }`: define que a pespectiva do usuário está `4px` afastado da tela. Deve ser definida no elemento-pai dos elementos afetados por ela;
- `bola1 { transform: translateZ(2px); }`: move a bola1 `2px` mais perto do usuário (perspectiva);
- `bola2 { transform: translateZ(-1px); }`: afasta a bola2 `2px` do usuário;
- `transform-style: preserve-3d`: define que as transformações no elemento sejam feitas em 3D;

### Atividade 09 - Cubo:

- É possível testar código HTML e CSS em http://dabblet.com/ e http://cssdeck.com/


## Aula 05 - Sombras e opacidade

### Atividade 01 - Sombras e opacidade:

- É possível colocar sombras em um texto apenas com CSS3, utilizando a propriedade `text-shadow`;
- `text-shadow: 2px 2px #000;`: adiciona uma sombra preta 2 pixels para a direita e 2 pixels para baixo;
- Elementos HTML também podem receber sombras, com a propriedade `box-shadow`;
- `box-shadow: 0 0 1em #000;`: o terceiro parâmetro "difunde" a sombra;
- Também é possível colocar mais de uma sombra no mesmo elemento;
- **Ex.:** `box-shadow: 0 0 1em #000, inset 0 0 .5em #FFF;`
- A propriedade `opacity` é utilizada para deixar as palavras transparentes. Seu valor pode variar entre 0 e 1, sendo 0 invisível e 1 totalmente visível;
- A transparência (ou opacidade) pode ser definida também no `background-color`, utilizando a sintaxe rgb, que aceita um quarto parâmetro, o *alpha*:
- **Ex.:** `background-color: rgb(0, 0, 0, .3);`
