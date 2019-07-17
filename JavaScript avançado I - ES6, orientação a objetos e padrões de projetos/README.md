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
- Para acessar um atributo de uma classe, deve-se utilizar os "métodos acessadores" *get* e *set*;
- **Ex.:** `getData() { return this._data; }`

### Atividade 05 - A sintaxe get:

- A palavra-chave `get` no JavaScript é outra forma de criar um *getter*;
- **Ex.:** `get data() { return this._data; }`
- Isso possibilita acessar um atributo como se fosse uma propriedade, mas por baixo dos panos o JavaScript "encapsula" o atributo;
- **Ex.:** `n1.data; n1.quantidade; n1.valor;`
- Isso também impossibilita alterar o valor do atributo quando obtido pelo método `get`;
- **Ex.:** `n1.quantidade = 1000; // Não funciona, pois é um getter, ou seja, apenas leitura`

### Atividade 06 - Objetos imutáveis:

- `Object.freeze(n1);`: "congela" um objeto, impossibilitando que seus atributos sejam alterados;
- É possível colocar esse método diretamente no construtor, para sempre instanciar um objeto imutável;

### Atividade 07 - A instância é imutável mesmo?:

- `n1.data.setDate(18);`: altera a data, mesmo se o objeto `n1` está congelado;
