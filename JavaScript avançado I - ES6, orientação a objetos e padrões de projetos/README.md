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
