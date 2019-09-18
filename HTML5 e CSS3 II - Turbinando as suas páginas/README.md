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
- A transparência (ou opacidade) pode ser definida também no `background-color`, utilizando a sintaxe `rgba`, que aceita um quarto parâmetro, o *alpha*:
- **Ex.:** `background-color: rgb(0, 0, 0, .3);`

### Atividade 04 - Simulando bordas com sombras:

- É possível, também, adicionar mais de uma sombra no mesmo elemento:
- **Ex.:** `box-shadow: 10px 10px black, -10px -10px orange;`
- Ou simular múltiplas bordas com a propriedade `box-shadow`:
```
box-shadow: 0 0 0 4px black,
            0 0 0 8px blue,
            0 0 0 12px black,
            0 0 0 16px blue,
            0 0 0 20px black;
```

### Atividade 09 - box-shadow para simular um modal:

```
<div style="width: 40%;
            height: 30%;
            background-color: #FFF;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            z-index: 9999;
            box-shadow: 0 0 0 9999px rgba(0, 0, 0, .75);
            padding: 3% 3%;
            text-align: center;
            font-size: 2em;
            color: #000;">
    Parabéns, você foi premiado com uma formação Java! Clique <a href="">aqui</a> para continuar
</div>
```


## Aula 06 - Gradientes

### Atividade 01 - Gradientes:

- É possível gerar um **gradiente** utilizando apenas CSS3. Para isso, utiliza-se a propriedade `background-image` com `linear-gradient('direcao', 'corinicial', 'corfinal')`:
- **Ex.:** `background-image: linear-gradient(to bottom, #F00, #000);`
- Também é possível utilizar mais cores e definir a posição que a cor deve aparecer:
- **Ex.:** `background-image: linear-gradient(to bottom, #F00, #888 80%, #000);`
- Pode-se alterar o tamanho do *background* que o gradiente irá utilizar (largura e altura):
- **Ex.:** `background-size: 100% 200px;`
- Por padrão, o gradiente se repetirá, até completar o *background* inteiro. Para alterar esse comportamento, existe a propriedade `background-repeat`:
- **Ex.:** `background-repeat: no-repeat;`
- A propriedade `background-attachment` com valor `fixed` permite que o fundo permaneça fixo na página:
- **Ex.:** `background-attachment: fixed;`

### Atividade 05 - As propriedades background-*:

- A propriedade `background-position` permite dizer onde a imagem começa a ser desenhada;
- **Ex.:** `background-position: center;` ou `background-position: 50% 50%;`

### Atividade 07 - Gradientes radiais:

- **Ex.:** `background-image: radial-gradient(yellow, red);`
- Assim como no gradiente linear, é possível especificar várias paradas de cor, e a posição:
- **Ex.:** `background-image: radial-gradient(circle at bottom left, yellow, red);`

### Atividade 08 - Gradiente no footer:

- Exemplo de elipse:
```
background-image: radial-gradient(
                    ellipse at left bottom,
                    rgba(60, 29, 61, 0.8),
                    rgba(60, 29, 61, 0.8) 65%,
                    black 65%,
                    black 70%,
                    transparent 70%,
                    transparent);
width: 100%;
background-size: 25% 100%;
background-repeat: no-repeat;
```


## Aula 07 - Seletores avançados do CSS

### Atividade 01 - Conhecendo outros seletores do CSS:

- `~`: depois. Para selecionar elementos **depois de** outro elemento, utiliza-se o caractere `~`;
- **Ex.:** `li ~ li { margin-top: 1em; }`
- `+`: logo depois. Para selecionar apenas o elemento **imediatamente após** outro elemento, utiliza-se o caractere `+`;
- **Ex.:** `img + p { text-indent: 0; }`
- `>`: pai e filho. Para selecionar apenas os elementos **imediatamente dentro** da div, utiliza-se o caractere `>`;
- **Ex.:** `div > p { text-indent: 4ch; }`
- Seletores: tag, **#**id, **.**classe, ancestral** **descendente (espaço), irmão **~** irmão, irmão **+** irmãoSeguinte, pai **>** filho;

### Atividade 10 - Seletor de atributo:

- Além dos seletores já vistos, existe mais um tipo, o de atributo. Dado o elemento `<a href="http://www.alura.com.br">`, podemos selecioná-lo com o seletor `[href="http://www.alura.com.br"]`;
- Além de selecionar pelo valor inteiro do atributo, é possível selecionar apenas por uma parte dele;
- Para selecionar todas as imagens com a extensão `.jpg` de uma página, pode-se utilizar o seletor: `[src$=".jpg"]`;
- O cifrão representa que queremos que o atributo **termine com** um valor;
- Para selecionar todos os links que começam com `http://`, pode-se utilizar o seletor: `[href^="http://"]`;
- O circunflexo representa que queremos que o atributo **comece com** um valor;
- Para selecionar todos os atributos que tenham qualquer classe, pode-se utilizar o seletor: `[class]`;


## Aula 08 - Pseudoclasses

### Atividade 01 - Pseudoclasses:

- As classes CSS são declaradas utilizando o caracter **.**, já as pseudoclasses utilizam o caracter **:**;
- `:nth-child(odd)`/`:nth-child(even)`, `:nth-child(3)`, `:first-child`/`:last-child`: pseudoclasse que permite selecionar elementos HTML específicos;
- É possível, também, passar "fórmulas" para selecionar os elementos. Por exemplo: `:nth-child(3n+2)` inicia no segundo elemento e pula três elementos a cada iteração;
- Ao identificar apenas a pseudoclasse, todos os elementos da página serão afetados. Para especificar melhor os elementos, normalmente combina-se uma tag à pseudoclasse: `table :nth-child(odd)`;
- **Cuidado!** Há diferenças entre o seletor `tr:first-child` e `tr :first-child`. O primeiro representa o elemento que é o primeiro filho de outro elemento, e o segundo representa uma relação pai-filho, ou seja, o primeiro filho do elemento especificado;
- `blockquote:nth-of-type(even)`: em um contexto com diversos tags no mesmo "escopo", conta os números pares apenas do elemento do tipo `blockquote`;

#### Interatividade:

- É possível melhorar a interatividade do usuário utilizando as pseudoclasses;
- `:hover`: pseudoclasse que é ativada pelo navegador quando ocorre um evento do mouse estar em cima do elemento;
- Além da `:hover`, existem também outras, como: `:focus` (teclado com foco em um elemento), `:active` (botão pressionado sobre o elemento), `:checked` (formulários);

### Atividade 04 - Selecionar filho único:

- É possível utilizar mais de uma pseudoclasse ao mesmo tempo;
- `p:nth-child(3):nth-last-child(1)`: seleciona os parágrafos que são o **terceiro e último** filhos de seus pais;
- `:nth-child(1):nth-last-child(1)` ou `:only-child`: seleciona os elementos que são **filhos únicos** de seus pais;

### Atividade 08 - O atributo tabindex:

- `tabindex="1"`: atributo HTML que torna um elemento acessível por teclado e toque. O número permite mudar a ordem de navegação pelo teclado. Para que o efeito fique visível, é necessário adicionar a pseudoclasse `:focus` ao seletor CSS;


## Aula 09 - Pseudoelementos

### Atividade 01 - Pseudoelementos:

- Letra capitular: primeira letra possui um estilo diferente, maior que o resto. Normalmente ela ocupa um "bloco" apenas para ela;
- `<p><span>L</span>orem ipsum...`: forma de adicionar letra capitular no HTML;
- `p:first-letter`: pseudoelemento que aplica o estilo apenas à primeira letra. Forma de adicionar letra capitular no CSS;
- `p::first-letter`: a partir do CSS3, foi alterada a sintaxe dos pseudoelementos para utilizar duas vezes o catactere `::`;
- Antes de adicionar conteúdo ao HTML da página, questione-se: "*é conteúdo?*" ou "*é decorativo?*". Se for conteúdo, adicione/altere no HTML. Se for decorativo, apenas no CSS.
- `blockquote:before` e `blockquote:after`: pega o primeiro e o último elemento de um blockquote;
- `content: '"'`: propriedade exclusiva dos pseudoelementos `:before` e `:after`. Sem essa propriedade, o elemento não é mostrado;

### Atividade 08 - Legenda nos links das redes sociais:

- A propriedade `content` pode assumir valores baseados em atributos do elemento da página. Por exemplo, se tivermos uma `<div>` na página com a seguinte declaração: `<div title="Teste">` conseguimos usar o texto do atributo `title` nos pseudoelementos:
- **Ex.:** `div::before { content: attr(title); }`
- Atributos customizados: a partir do HTML 5, podemos criar nossos próprios atributos em qualquer elemento do HTML sem deixá-lo inválido. Basta que o atributo comece com `data-`:
- **Ex.:** `<a href="#" data-legenda="Clique em mim">Link</a>`


## Aula 10 - Formulários

### Atividade 01 - Trabalhando com formulários:

- `<form></form>`: cria um formulário HTML;
- `<label for="nome">`: cria um rótulo que indica o valor do elemento de *id* "nome";
- `<input id="nome">`: cria uma entrada para que o usuário interaja;
- Ao associar um label com o *id* de um `input`, ao clicar no texto da `label`, o `input` ganha foco;
- `<label><input type="radio">Outro</label>`: outra forma de associar um `label` e um `input`;
- `<input type="radio" name="outro" value="">`: o atributo `name=""` utiliza seu conteúdo para distinguir a informação enviada ao servidor. Ao atribuir o mesmo `name` a vários `input` de `type="radio"`, é possível selecionar apenas um desses *radio buttons* por vez. O atributo value especifica o valor desse campo;
- `<textarea id="msg" name="mensagem" cols="30" rows="6"></textarea>`: o atributo `cols="30"` define que o texto possui 30 colunas (largura) e o atributo `rows="6"` define que o texto possui 6 linhas (altura);
- `<input type="submit" value="Enviar">`: botão que envia a requisição;
- `<button type="submit">Enviar</button>`: botão que envia a requisição. Possibilita mais customização que o `input`;
- `type="email"`: atributo do `input` que valida se um email possui ao menos um caractere `@`;
- `required`: atributo do `input` que define que o campo é obrigatório;
- `autofocus`: atributo do `input` que foca no campo quando a página é carregada;
- `<fieldset><legend>Dados pessoais</legend></fieldset>`: agrupa os campos relacionados (Dados pessoais, Assunto, etc.);
- Apesar das validações vistas, lembre-se: **Sempre valide no servidor!**;

### Atividade 02 - Criando um formulário de contato:

- Um `<label>` não pode ter dois `<input>` dentro dele. Para esse caso, é possível utilizar um `<fieldset>`;
- **Ex.:**
```
<fieldset>
    <input type="radio" value="Outro">
    <label>Outro</label>
    <input type="text">
</fieldset>
```

### Atividade 04 - Tipos de input:

- `date`, usado para que o usuário possa fornecer uma data como seu aniversário ou data de nascimento.
- `datetime`, para que o usuário possa fornecer, além da data, um horário, útil para que ele forneça um momento para ser lembrado de algo.
- `datetime-local`, para quando a data e o horário que o usuário fornecer sejam independentes de local ou quando o sistema é feito para trabalhar sempre no mesmo fuso horário, como por exemplo quando o usuário precisa fornecer a data e o horário de nascimento dele no horário de Brasília.
- `hidden`, usado para enviar informações extra para o servidor além daquelas fornecidas pelo usuário, como um identificador do usuário gerado pelo sistema.
- `image`, usado para enviar os dados do formulário com um botão gráfico, pode ser usado para não apenas ter um botão mais bonito, como também para fazer uma interação mais dinâmica com o usuário, em que o resultado da ação depende do local onde ele clica na imagem, uma vez que esse tipo de botão envia as coordenadas do clique para o servidor.
- `month`, usado para que o usuário forneça um mês e um ano, útil para que ele forneça a validade de um cartão de crédito, por exemplo.
- `number`, para que o usuário forneça um número como sua idade ou a quantidade de um produto num carrinho de compras.
- `range`, usado para que se possa escolher um valor numérico numa faixa de valores possíveis, normalmente sem muita preocupação com a precisão, como por exemplo quando se deseja que o usuário dê uma nota para um serviço.

### Atividade 07 - O atributo pattern:

- No atributo `pattern`, podemos especificar qual padrão deve seguir um determinado campo, para que o usuário preencha-o corretamente. Especificamos esse padrão usando uma linguagem chamada expressão regular. Para garantir que um campo só tenha letras e números, por exemplo, podemos fazer:
- **Ex.:** `<input pattern="[A-Za-z0-9]*">`
- Se quisermos garantir uma quantidade mínima de letras e números, podemos fazer:
- **Ex.:** `<input pattern="[A-Za-z0-9]{8,}">`

### Atividade 08 - Descrevendo o pattern:

- É possível mudar a mensagem padrão de um `pattern`, da seguinte forma:
- **Ex.:** `<input pattern="[0-9]*" title="Preencha somente com números">`

### Atividade 09 - Estilizando formulários:

- `label[for="mensagem"] { }`: seletor de atributo;

### Atividade 10 - Melhorando a usabilidade com truques CSS:

- Para esconder um campo por padrão e mostrá-lo apenas quando certa opção for selecionada, podemos utilizar a pseudoclasse `:checked`:
- **Ex.:**
```
/* Não selecionado: esconde o elemento */
input[value="Outro"] ~ input {
    display: none;
}
/* Selecionado: mostra o elemento */
input[value="Outro"]:checked ~ input {
    display: inline;
}
```


## Aula 11 - Cálculos com CSS

### Atividade 01 - Cálculos com CSS:

- É possível realizar cálculos no CSS, utilizando a função `calc()`;
- Por exemplo, para afastar um elemento da borda, podemos utilizar:
- **Ex.:**
```
#nome {
    width: calc(100% - 2em);
    position: relative;
    left: 2em;
}
```

### Atividade 06 - Vantagens de usar o calc:

- A função `calc()` traz três grandes vantagens para nosso código.
- A primeira é a **legibilidade**: podemos deixar algumas contas explícitas, facilitando o entendimento e a manutenção do código.
- A segunda é o **poder**: conseguimos criar layouts que não eram possíveis sem JavaScript antes, como elementos que ocupam um espaço que outros deixaram sobrando.
- A terceira é a **flexibilidade**: como podemos misturar unidades nas contas, conseguimos deixar nosso layout ainda mais flexível, com um comportamento adequado em tamanhos de tela diferentes e com fontes diferentes.


## Aula 12 - Tabelas semânticas

### Atividade 01 - Tabelas Semânticas:

- Por padrão HTML, quando duas bordas estão uma ao lado da outra, elas se unem. Para alterar esse comportamento, altere o valor do atributo `border-collapse: separate`;
- `border-spacing: 5px`: define um espaçamento de `5px` para as bordas do elemento. Semelhante ao `margin`;
