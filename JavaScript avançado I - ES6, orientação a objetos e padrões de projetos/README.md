# JavaScript avançado I: ES6, orientação a objetos e padrões de projetos

## Aula 01 - Prólogo: regras, código e manutenção

### Atividade 02 - (Obrigatório) Download do projeto e infraestrutra:

#### Google Chrome:

- **Atenção!** Para utilizar recursos específicos do ES6, deve-se usar o **Google Chrome versão 50** ou superior;

#### Dica:

- Para saber se determinada funcionalidade do ES2015+ (ES6) é suportada pelo navegador, acesse https://kangax.github.io/compat-table/es6/

#### Node.js:

- Faça o download em https://nodejs.org
- Para verificar se está funcionando, execute em seu terminal o comando `node --version`;
- Se a saída for a versão do Node, tudo certo. Se não for, tente o seguinte:
	- Windows: não mude o diretório padrão da instalação do Node.js. Há relatos que em algumas versões do Windows a pasta do Node não é colocada no PATH do Windows, sendo necessário adicioná-la manualmente. Não sabe como? Temos um treinamento de prompt no Windows que pode ajudá-lo nesta tarefa.
	- Linux: algumas distribuições Linux já possui um binário chamado node, que não tem nenhuma relação com o Node.js. Nestas distribuições, o binário passa a se chamar nodejs. Sendo assim, em todo lugar que eu referenciar o comando node ele deve ser trocado para nodejs.


## Aula 02 - Especificando uma Negociação

### Atividade 02 - A classe Negociação:

- Uma classe JavaScript segue a convenção *UpperCamelCase*, ou seja, o arquivo de nossa classe de negociação se chamará `Negociacao.js`;
- `class Negociacao { }`: sintaxe JavaScript que declara uma classe;
- `constructor() { }`: sintaxe JavaScript que declara o construtor de uma classe. O construtor define os atributos da classe, utilizando a palavra-chave `this`;
- `this.date = new Date();`: declara um atributo e instancia-o com o valor da data atual do sistema;
- `var n1 = new Negociacao();`: instancia um novo objeto da classe `Negociacao`;

### Atividade 03 - Construtor da classe e métodos:

- É possível instanciar uma negociação já com valores pré-definidos. Para isso, utiliza-se o construtor:
- **Ex.:** `var n1 = new Negociacao(new Date(), 5, 700);`
- É necessário definir o construtor na classe?
- **Ex.:** `constructor(data, quantidade, valor) { ... }`

#### Métodos x Funções:

- Um método é um comportamento de uma classe:
- **Ex.:** `obtemVolume() { return this.quantidade * this.valor; }`

### Atividade 04 - Encapsulamento:

- O JavaScript não possui modificadores de acesso. É adotada uma convenção para avisar o programador a não acessar -fora da classe- os atributos que possuem *underline* (**_**) no início;
- Para acessar um atributo de uma classe, deve-se utilizar o "método acessador" *get*:
- **Ex.:** `getData() { return this._data; }`

### Atividade 05 - A sintaxe get:

- A palavra-chave `get` no JavaScript é outra forma de criar um *getter*:
- **Ex.:** `get data() { return this._data; }`
- Isso possibilita acessar um atributo como se fosse uma propriedade, mas por baixo dos panos o JavaScript "encapsula" o atributo:
- **Ex.:** `n1.data; n1.quantidade; n1.valor;`
- Isso também impossibilita alterar o valor do atributo quando obtido pelo método `get`:
- **Ex.:** `n1.quantidade = 1000; // Não funciona, pois é um getter, ou seja, apenas leitura`

### Atividade 06 - Objetos imutáveis:

- `Object.freeze(n1);`: "congela" um objeto, impossibilitando que seus atributos sejam alterados;
- É possível colocar esse método diretamente no construtor, para sempre instanciar um objeto imutável;

### Atividade 07 - A instância é imutável mesmo?:

- `n1.data.setDate(18);`: altera a data, mesmo se o objeto `n1` está congelado;

### Atividade 08 - Programação defensiva:

- Uma forma de impossibilitar a alteração do valor da data é devolver um novo objeto de `data`;
- **Ex.:** `get data() { return new Date(this._data.getTime()); }`
- Assim, cada vez que a data for alterada a partir de `n1.data`, o que será alterado é o novo objeto `Date` retornado, preservando o valor do atributo data do objeto `n1`;
- A mesma coisa pode ocorrer no construtor:
- **Ex.:** `var hoje = new Date(); var n1 = new Negociacao(hoje, 5, 700); hoje.setDate(18);`
- Para se proteger, ao receber um objeto, crie um novo objeto internamente na classe, para que a referência externa não possa alterar o atributo da classe:
- **Ex.:** `this_data = new Date(data.getTime());`

### Atividade 09 - Substituindo var por let:

- `var`: variável com escopo global;
- `let`: variável com escopo de bloco;

### Atividade 23 - Declarando duas vezes a mesma variável:

- **Ex.:** `let nome = 'Guilherme'; let nome = 'Dall Bello';`
- Ao fazer isso, nosso navegador retorna: `Uncaught TypeError: Identifier 'nome' has already been declared(…)`;
- Não podemos declarar mais de uma variável quando usamos `let`. Antes desse novo recurso de linguagem, podíamos fazer algo como:
- **Ex.:** `var nome = 'Flávio'; var nome = 'Almeida';`


## Aula 03 - A ligação entre as ações do usuário e o modelo

### Atividade 01 - A classe NegociacaoController:

- Criaremos um script para representar o *controller*:
- **Ex.:** `adiciona(event) { event.preventDefault(); }`
- Instanciaremos um objeto do *controller*:
- **Ex.:** `<script>let negociacaoController = new NegociacaoController();</script>`
- Adicionaremos uma ação dentro de um evento na *tag* do formulário:
- **Ex.:** `<form class="form" onsubmit="negociacaoController.adiciona(event)">`

### Atividade 02 - Associando métodos do controller às ações do usuário:

- É possível atribuir métodos à uma variável JavaScript, mantendo o contexto de execução do método:
- **Ex.:** `let $ = document.querySelector.bind(document);`
- É necessário vincular o método (`bind()`) ao objeto para executá-lo como se estivesse dentro do objeto `document`, pois fora desse contexto o método não existe (ele seria uma função);
- A variável pode ser utilizada como se fosse o nome do método:
- **Ex.:** `let inputData = $('#data');`

### Atividade 03 - Evitando percorrer o DOM muitas vezes:

- Ao invés de criar variáveis a cada clique no botão, utilizaremos atributos, que são instanciados apenas uma vez (no construtor) e não é preciso percorrer o *DOM* a cada novo clique no botão (num projeto grande, isso pode custar performance);

### Atividade 04 - Criando um objeto Date:

- O JavaScript define uma data com o padrão *YYYY-MM-DD*;
- O construtor do `Date` aceita como parâmetros uma string (no formato `'YYYY,MM,DD'`) ou um array (no formato `['YYYY', 'MM', 'DD']`);
- `let data = new Date(this._inputData.value.split('-'));`: cria uma data utilizando um *array* (pode ser de *string* ou de *number*). Internamente, esse construtor utiliza o método `join` para concatenar os valores em uma string;
- **Ex.:** `['2016', '11', '12'].join(',');`;
- `let data = new Date(this._inputData.value.replace(/-/g, ','));`: cria uma data utilizando uma *string*. Utiliza a expressão regular `/-/g`, que significa que irá trocar todo o conteúdo entre as barras (`-`), globalmente (`g`), pela string seguinte (`','`);

### Atividade 07 - O problema com datas:

- Ao definir uma data por `new Date(2016, 11, 12)`, a data será definida como **12 de dezembro de 2016**. Isso acontece pois, se `Date` for instanciado com esse formato, o mês é obtido entre os valores 0 e 11 (0 sendo janeiro e 11 sendo dezembro);

### Atividade 08 - Resolvendo um problema com o paradigma funcional:

- *Spread operator* (`...`): separa um *array* em vários elementos e atribui cada um a um parâmetro diferente de uma função;
- `map(item, indice)`: função que todo *array* possui. Percorre os itens do *array*, podendo alterá-los;
- **Ex.:** `array.map(function(item) { return item + 10; });`
- Para resolver o problema com a data, utilizaremos ambos recursos acima mencionados;
- **Ex.:** `let data = new Date(...this._inputData.value.split('-').map(function(item, indice) { return item - indice % 2; }));`
- A linha acima instancia uma nova data, que recebe um *array*, tratado pela função `map` e separado em parâmetros individuais, pelo *spread operator*. **Obs.:** o módulo utilizado para tratar o parâmetro funciona nesse caso, pois são passados três parâmetros na função, e apenas o valor do **mês** é subtraído por 1, resolvendo, assim, o problema que tínhamos com a data;

### Atividade 09 - Arrow Functions: deixando o código ainda menos verboso:

- Vamos deixar o código menos verboso:
- **Ex.:** `.map(function(item, indice) { return item - indice % 2; })`
- Utilizando *arrow function*:
- **Ex.:** `.map((item, indice) => item - indice % 2)`
- Quando uma *arrow function* possui apenas uma instrução, o valor dessa instrução é retornado automaticamente;

### Atividade 15 - "Isso" não encaixa em um "Date"? Se vira!:

- Imagine que você possui uma data no formato 'DD-MM-YYYY' e quer convertê-la para 'YYYY/MM/DD', uma forma de fazer isso é a seguinte:
- **Ex.:** `let data = '17-05-2016'; data = new Date(data.split('-').reverse().join('/'));`

### Atividade 17 - O "mapa" da mina!:

- A instrução `if(item % 2) { ... }` resulta no mesmo que `if(item % 2 != 0) { ... }`. Por padrão, o JavaScript considera o número 0 como uma condição `false`, e qualquer outro número é considerado como `true`;


## Aula 04 - Ligar com data é trabalhoso? Chame um ajudante!:

### Atividade 01 - Exibindo o objeto Date no formato dia/mês/ano:

- `negociacao.data.getDate()`: método de um objeto do tipo `Date` que retorna o dia;
- `negociacao.data.getMonth()`: método de um objeto do tipo `Date` que retorna o mês;
- `negociacao.data.getFullYear()`: método de um objeto do tipo `Date` que retorna o ano;
- `let diaMesAno = negociacao.data.getDate() + '/' + (negociacao.data.getMonth() + 1) + '/' + negociacao.data.getFullYear();`: para obter o mês correto, deve-se somar 1 em seu valor, pois a classe `Date` armazena os meses com valores entre 0 e 11;

### Atividade 02 - Isolando a responsabilidade de conversão de datas:

- Uma classe *Helper* é uma classe "ajudante"/auxiliar. Por exemplo, a classe `DateHelper.js` possui métodos para converter `textoParaData(texto)` e `dataParaTexto(data)`;
- **Ex.:** `let data = new DateHelper().textoParaData(this._inputData.value);`

### Atividade 03 - Métodos estáticos:

- `static`: palavra-chave utilizada para definir que um método é **da classe**, ou seja, não é necessária uma instância da classe (objeto) para utilizar tal método;
- Uma classe *Helper* que possui apenas métodos estáticos não deve ser instanciada. Para isso, seu construtor deve ser escrito da seguinte forma:
- **Ex.:** `constructor() { throw new Error('Esta classe não pode ser instanciada!'); }`

### Atividade 04 - Template Strings:

- *Template string*: parecida com uma string normal, porém seu conteúdo fica entre crases (\`\`);
- `${nome}`: interpolação da variável `nome` dentro de uma *template string*;
- **Ex.:** ``console.log(`A idade de ${nome} é ${idade}.`);``

#### Expressão regular:

- Declara-se uma expressão regular entre duas barras (`/conteudo/`). Para retornar a data no formato `YYYY-MM-DD`, deve-se criar a expressão regular:
- **Ex.:** `/\d{4}-\d{2}-\d{2}/`
- `\d`: deve ser um número;
- `\d{4}`: deve ser quatro números em sequência;
- `\D`: deve ser diferente de um número;
- É possível testar uma expressão regular:
- **Ex.:** `if (!/\d{4}-\d{2}-\d{2}/.test(texto)) throw new Error('Deve estar no formato aaaa-mm-dd');`
- Qualquer outro caractere dentro da expressão regular será mostrado sem alterações;

### Atividade 05 - Criando nosso ListModel:

#### Lista:

- `this._negociacoes.push(negociacao);`: insere uma nova negociação no *array* `negociacoes`;

### Atividade 06 - Blindando as negociações dentro na lista:

- Deve-se blindar as negociações para que elas não possam ser alteradas de maneiras externas:
- **Ex.:** `get negociacoes() { return [].concat(this._negociacoes); }`
- Isso faz com que seja retornada uma "cópia" da lista que existe em um objeto, impossibilitando que a lista original seja acessada ou alterada;

### Atividade 14 - Expressão regular ainda melhor:

- `/^\d{4}-\d{2}-\d{2}$/`: O `ˆ` indica "começando com " e o `$` "terminando com".


## Aula 05 - Temos o modelo, mas e a view?

### Atividade 01 - Classes que representam nossas Views:

- Uma *view* é um "pedaço" do nosso HTML. No nosso sistema, a tabela de negociações será uma *view*;
- Esse "pedaço" do HTML deve ser referenciado em algum lugar de sua página. Uma prática comum é criar uma `<div></div>` vazia, que possui apenas um `id`, para receber o conteúdo da *view*:
- **Ex.:** `<div id="negociacoesView"></div>`

#### View no código:

- `_elemento`: atributo da classe que recebe, no construtor, o elemento *HTML* ao qual a *view* é relacionada;
- **Ex.:** `constructor(elemento) { this._elemento = elemento; }`
- Sua instanciação se dá por:
- **Ex.:** `this._negociacoesView = new NegociacoesView($('negociacoesView'));`
- `_template()`: retorna o conteúdo *HTML* da *view* em uma *template string*;
- `update()`: atribui o conteúdo do *HTML* ao elemento relacionado À *view* (normalmente uma `<div>` vazia):
- **Ex.:** `update() { this._elemento.innerHTML = this._template(); }`

### Atividade 02 - Construindo um template dinâmico com a função map:

- A tabela deverá se atualizar ao abrir a página e a cada adição de uma nova negociação;
- Alteraremos o conteúdo de `<tbody>` contido na *template string* da *view* utilizando uma interpolação:
- **Ex.:**
```
<tbody>
	${model.negociacoes.map(n => {
		return `
			<tr>
				<td>${DateHelper.dataParaTexto(n.data)}</td>
				<td>${n.quantidade}</td>
				<td>${n.valor}</td>
				<td>${n.volume}</td>
			</tr>
		`;
	}).join('')}
</tbody>
```
- O bloco de código acima é escrito dentro do método `_template()` da classe `NegociacoesView`. Ele cria uma nova negociação de uma linha e quatro colunas, e a adiciona ao corpo da tabela (`tbody`). O método `join('')` concatena todos os itens da lista gerada pelo `map()`, convertendo o *array* para *string*;

### Atividade 04 - Totalizando o volume em nosso Template:

- *Immediately Invoked Function Expression* (IIFE): é uma função auto-invocada;
- **Ex.:** `(function() { return total; })()`
