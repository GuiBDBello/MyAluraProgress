# JavaScript Avançado II: ES6, orientação a objetos e padrões de projetos

## Aula 01 - Como saber quando o modelo mudou?

### Atividade 01 - Você lembrou de atualizar a view? Nem eu!:

- `this._negociacoes = [];`: limpa/esvazia o array `_negociacoes`;

### Atividade 03 - API Reflection e as facetas de this:

- `Reflect.apply(function() {}, this._contexto, [param1, param2]);`: método que executa uma função `function() {}` no contexto `this._contexto`, utilizando um vetor de parâmetros `[param1, param2]`;

### Atividade 04 - Arrow function e seu escopo léxico:

- O escopo do `this` de uma arrow function é *léxico*, não é dinâmico como numa função. Ele não muda de acordo com o contexto;

### Atividade 09 - Contexto das arrows functions:

- É possível guardar um contexto em uma variável, por exemplo, `self`, e acessá-lo quando necessário;
- **Ex.:** `let self = this;`

### Atividade 13 - Reutilização de código com Composição e Mixin:

- `Reflect.apply(Aviao.prototype.voa, this, []);`: executa o método `voa` da classe `Aviao`, mas usando como contexto o `this` da instância atual;
- Métodos criados usando ES6 são adicionados no prototype. Qualquer método adicionado em prototype estará disponível para todas as instâncias;
- `Aviao.prototype.voa.apply(this, []);`: Essa solução é menos verbosa, mas a ideia do ES2015 foi centralizar operações como essa em `Reflect` e com o tempo esse deve se tornar o método mais indicado para realizar operações como essa.

### Atividade 15 - O padrão de projeto Observer:

- Usamos o padrão de projeto **Observer** sempre que queremos notificar partes do sistema interessadas quando um evento importante for disparado em nosso sistema;


## Aula 02 - Existe modelo mentiroso? O padrão de projeto Proxy!

### Atividade 02 - O padrão de projeto Proxy:

- Existe um famoso padrão de projeto chamado Proxy, que de forma resumida, é "um cara mentiroso";
- O Proxy delegará a chamada do método para o objeto encapsulado por ele;
- A vantagem está que colocaremos as armadilhas entre a chamada do Proxy e o objeto real. Toda vez que acessamos o Proxy, executaremos um código antes de chamarmos um método ou propriedade correspondente ao objeto real;
- A partir da versão 2015 do ECMAScript, a própria linguagem já possui um recurso de Proxy;

### Atividade 03 - Aprendendo a trabalhar com o Proxy:

- `new Proxy(negociacao, {});`: cria um novo **Proxy** que encapsula o objeto `negociacao` utilizando o *handler* `{}` (nesse caso, não há *handler*);

### Atividade 04 - Construindo armadilhas de leitura:

- `get: function(target, prop, receiver) { return ... }`: o `get` é chamado a cada vez que uma propriedade do objeto encapsulado pelo `Proxy` é obtida;
- `target` é a referência ao objeto original encapsulado pelo `Proxy`;
- `prop`: é a propriedade que está sendo acessada;
- `receiver`: é a referência do próprio `Proxy`;
- `return Reflect.get(target, prop, receiver);`: utiliza a API `Reflect` para realizar uma leitura do objeto original (`target`), na propriedade `prop` utilizando o objeto `receiver`, que é uma referência ao `Proxy`;

### Atividade 05 - Construindo armadilhas de escrita:

- `set: function(target, prop, value, receiver) { return ... }`: o `set` é chamado a cada vez que o valor de uma propriedade do objeto encapsulado pelo `Proxy` é alterada. Semelhante ao `get`, porém adiciona o parâmetro `value`;
- `return Reflect.set(target, prop, value, receiver);`: utiliza a API `Reflect` para realizar uma alteração do valor (`value`) da propriedade `prop` do objeto original (`target`), utilizando o objeto `receiver`, que é uma referência ao `Proxy`;
- `target[prop]`: obtém a propriedade `prop` do objeto `target`;

### Atividade 07 - Uma solução para método que não altera propriedade:

- Não há uma maneira de interceptar um método com `Proxy`;
- Quando é chamado um método/função, o `Proxy` realiza um *get* e depois um `Reflect.apply` para passar o valor à função;

### Atividade 08 - Construindo armadilhas para métodos:

- `if (['adiciona', 'esvazia'].includes(prop) && typeof(target[prop]) == typeof(Function)) { }`: verifica se a propriedade `prop` interceptada tem o nome `'adiciona'` ou `'esvazia'` **e** é uma função;
- Existe um objeto implícito em JavaScript chamado `arguments`, que possui todos os parâmetros passados para a função;

### Atividade 09 - Truque com ES2015:

- Sabemos que podemos declarar um objeto JavaScript com propriedades que podem armazenar funções;
- **Ex.:**
```
var objeto = {
    exibeMensagem : function(){
        console.log("Olá");
    }
};
```
- Com o ES2015, podemos reescrever aquele código da seguinte maneira:
- **Ex.:**
```
var objeto = {
    exibeMensagem() {
        console.log("Olá");
    }
}
```

### Atividade 19 - Arguments:

- Por mais que uma função não receba parâmetros, podemos ter acesso aos parâmetros passados com `arguments`;
- **Ex.:**
```
function exibeNomeCompleto() {
  alert(`${arguments[0]} ${arguments[1]}`);
}
exibeNomeCompleto('Flávio', 'Almeida');
```


## Aula 03 - E se alguém criasse nossos proxies? O Padrão de Projeto Factory

### Atividade 01 - Padrão de Projeto Factory:

- *Factory*: classe especializada em criar determinado tipo de objeto;

### Atividade 03 - Isolando a complexidade de associar o modelo com a view na classe Bind:

- *Data binding* unidirecional: associação entre o modelo e a view. Toda vez que o modelo mudar, atualiza a view;
- Em JavaScript, um `constructor` pode ter `return`;

### Atividade 04 - Parâmetros REST:

- `constructor(model, view, ...props) { }`: `...props` é um *REST operator*, ou seja, todos os parâmetros à partir da posição que está o `props` serão convertidos para um array;

### Atividade 08 - Fábricas na API JavaScript:

- As fábricas não só fazem parte do nosso código, como também da API do JavaScript. Já existem várias classes que aproveitam esse padrão;
- Por exemplo, a classe String possui um método (ou factory method) para transformar vários CharCode em uma string:
- `let abc = String.fromCharCode(65, 66, 67);  // "ABC"`
Outro exemplo é a classe Array, que pode receber uma string ou um iterável, como lista ou mapas, para criar um array:
- `let d = Array.from("abc"); // ["a", "b", "c"]`

### Atividade 09 - DateHelper é um Factory?:

- O padrão de projeto Factory ocorre quando temos uma classe que nos ajuda a criar um objeto complexo, ou seja, ela esconde de nós os detalhes de criação desse objeto. É por isso que uma classe Factory possui apenas um método;


## Aula 04 - Importando negociações

### Atividade 02 - Requisições Ajax com o objeto XMLHttpRequest:

- `let xhr = new XMLHttpRequest();`: cria um objeto que realiza requisições Ajax;
- `xhr.open('GET', 'negociacoes/semana');`: "abre" um endereço para realizar uma requisição do tipo `'GET'` na *URL* `'negociacoes/semana'`;
- `xhr.send()`: o método `open()` não realiza a requisição, apenas a prepara. O método `send()` envia a requisição;
- `xhr.onreadystatechange = () => { }`: função executada a cada vez que o estado do `xhr` mudar;
- `xhr.readyState == 4`: verifica se a requisição foi concluída e uma resposta foi fornecida;
- `xhr.status == 200`: verifica se a resposta possui *status* de sucesso;

### Atividade 03 - Realizando o parse da resposta:

- `xhr.responseText`: conteúdo da resposta da requisição;
- `JSON.parse()`: converte um texto para *JSON*;

### Atividade 04 - Separando as responsabilidades:

- *Callback*: função que vai ser chamada após o processamento dados/outra função;
- `(err, negociacoes) => { }`: função anônima de *callback* que realiza uma convenção chamada *error first*;
- `if (err) { this._mensagem.texto = err; return; }`: primeira linha do *error first*. Verifica se ocorreu um erro na chamada da função e encerra ela;
- `cb(null, JSON.parse(xhr.responseText))`: chamada da função de *callback* caso a requisição respondeu com sucesso;
- `cb('Não foi possível obter as negociações.', null);`: chamada da função de *callback* caso a requisição respondeu com erro. **Obs.:** o `null` é opcional;


## Aula 05 - Combatendo Callback Hell com Promises

### Atividade 01 - O problema da vida assíncrona:

- *Pyramid of Doom*: função aninhada dentro de outra. A pirâmide é um forte indício de que temos problemas de legibilidade do código, na verdade, é o sintoma de um problema maior, o *Callback Hell*;
- *Callback Hell*: ocorre quando temos requisições assíncronas executadas em determinada ordem, que chama vários callbacks seguidos;

### Atividade 02 - O padrão de projeto Promise:

- `let promise = createPromise();`: *resolve* é uma função de *callback* que recebe o retorno de sucesso, e *reject* recebe o erro;
- **Ex.:**
```
createPromise() {
    return new Promise((resolve, reject) => {
        if (...) 
            resolve(...);
        else
            reject(...);
    });
}
```
- `promise.then(negociacoes => {}).catch(error => {})`: executa a *promise*. O retorno de *resolve* é obtido no `then()` e o retorno de *reject* é obtido no `catch()`;

### Atividade 03 - Pyramid of Doom novamente? Claro que não, Promise.all nela!:

- `Promise.all([promise1, promise2, promise3]).then(negociacoes => {}).catch(error => {});`: resolve todas as promessas na ordem passada no vetor;

### Atividade 06 - Dissecando uma promise!:

- `setTimeout(() => { }, 5000);`: o método `setTimeout` recebe uma função para ser executada e o tempo de *timeout*. Após esse tempo será retornado algum dado passado na função;


## Aula 06 - Considerações finais e exercícios bônus

### Atividade 02 - Ah se eu pudesse ordenar minha tabela clicando na coluna...:

- `array.sort()`: ordena um array em ordem crescente;
- `array.reverse()`: inverte a ordem dos elementos de um array;
- `array.sort((a, b) => a.quantidade - b.quantidade)`: ordena um array baseado em um critério de ordenação (a > b);
- A regra é a seguinte: com o critério selecionado, se o valor retornado for 0 não há alteração a ser feita, se o valor retornado for positivo, b deve vir antes de a, se o valor for negativo, a deve vir antes de b;
- **Ex.:**
```
ordena(coluna) {
    this._listaNegociacoes.ordena((a, b) => a[coluna] - b[coluna]);
}
```
- Onde `coluna` é a propriedade do objeto a ser ordenada;

### Atividade 06 - Ah se meu código funcionasse no Edge!:

- Um *polyfill* é um script que emula o comportamento de um recurso quando esse não é suportado para garantir que nosso código funcione sem termos que abdicar do que é mais novo;
