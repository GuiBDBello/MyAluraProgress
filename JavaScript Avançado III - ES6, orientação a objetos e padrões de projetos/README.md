# JavaScript Avançado III: ES6, orientação a objetos e padrões de projetos

## Aula 01 - Guardando negociações offline com IndexedDB

### Atividade 02 - Browser possui banco de dados? Conheça o IndexedDB!:

- `window.indexedDB` ou `indexedDB`: retorna uma *Factory* para criar bancos no *IndexedDB*;
- `var openRequest = window.indexedDB.open('aluraframe', 1)`: requisição de abertura do banco, onde `'aluraframe'` é o nome do banco e `1` é a versão do banco;
- `openRequest.onupgradeneeded`, `openRequest.onsuccess` e `openRequest.onerror`: "tríade" de eventos disparados quando um banco no *IndexedDB* é acessado;
- `openRequest.onupgradeneeded`: recebe uma função que cria ou altera um banco já existente;
- `openRequest.onsuccess`: recebe uma função que obtém uma conexão com sucesso;
- `openRequest.onerror`: recebe uma função que obtém o problema que ocorreu na chamada do banco;
- No navegador (*Google Chrome*), é possível visualizar o banco na aba *Application* do console de desenvolvedor (F12), dentro de *IndexedDB*;

### Atividade 03 - Comunicando-se com o banco usando o IDBDatabase:

- `var connection;`: declara, fora da tríade de eventos do *IndexedDB*, a variável de conexão;
- `connection = e.target.result;`: dentro de `onsuccess`, obtém a conexão do *IDBDatabase*;
- `var minhaConnection = e.target.result;`: dentro de `onupgradeneeded`, obtém a conexão do *IDBDatabase*;
- `minhaConnection.createObjectStore('negociacoes');`: é como se fosse uma tabela, porém não possui *schema*;
- O método `onupgradeneeded` só é executado quando a versão do banco for alterada;

### Atividade 04 - Quero gravar em uma Object Store, mas onde está a transação?:

- `let transaction = connection.transaction(['negociacoes'], 'readwrite');`: cria uma nova transação a partir de uma conexão na *Object Store* `'negociacoes'` do tipo `'readwrite'` (leitura e escrita);
- `let store = transaction.objectStore('negociacoes');`: obtém a *Object Store* de `'negociacoes'`. Através dessa `store` é possível realizar operações de persistência (gravar, alterar, listar);
- `let request = store.add(negociacao);`: adiciona uma nova negociação na *Object Store* e armazena a requisição na variável `request`;
- `request.onsuccess = e => { };` e `request.onerror = e => { };`: tratamento de sucesso e erro da `request`;
- `minhaConnection.objectStoreNames`: retorna todos os nomes das *Object Stores* criadas;
- `minhaConnection.deleteObjectStore('negociacoes');`: deleta a *Object Store* `'negociacoes'`;
- `minhaConnection.createObjectStore('negociacoes', { autoIncrement: true });`: adicionado um novo parâmetro na criação da *Object Store*;

### Atividade 05 - Só acredito vendo: listando objetos de uma store:

- `let cursor = store.openCursor();`: cria um cursor que é utilizado para "navegar" pela *Object Store* e obter seus dados;
- Um cursor também utiliza os métodos `onsuccess` e `onerror`;
- `e.target.result`: retorna um valor diferente de acordo com o evento;
- `let atual = e.target.result;`: dentro de `cursor.onsuccess`, retorna o ponteiro atual de uma `'negociacao'` armazenada no banco;
- `var dado = atual.value;`: obtém o objeto negociação;
- `negociacoes.push(new Negociacao(dado._data, dado._quantidade, dado._valor));`: adiciona a negociação atual no vetor de negociações;
- `atual.continue();`: muda a posição do ponteiro e chama novamente o `onsuccess` até que uma condição seja satisfeita;
- `e.target.error.name`: dentro de `cursor.onerror`, retorna o nome do erro que ocorreu;


## Aula 02 - Gerenciando nossa conexão com o pattern Factory

### Atividade 01 - Uma conexão ou várias?:

- Regras de conexão:
a) getConnection vai ser um método estático
b) getConnection vai retornar uma promise
c) não importa o número de vezes que eu chamar o método estático, a conexão tem que ser a mesma
d) o programador não pode chamar close diretamente. Ela só pode ser fechada através da própria ConnectionFactory

### Atividade 03 - Criando stores:

- `e.target.result.objectStoreNames.contains(store)`: Verifica se a *Object Store* de nome `store` existe;
- `e.target.result.deleteObjectStore()`: apaga a *Object Store* `store`;

### Atividade 04 - O padrão de projeto Module Pattern:

- Em uma condição, `0`, `''`, `null`, `undefined` são avaliados como `false`;
- *Module Pattern*: unidade de código confinada. O que está dentro de um módulo, ninguém tem acesso;
- **Ex.:**
```
var ConnectionFactory = (function () {
    return class ConnectionFactory {
        // ...
    }
})();
```

### Atividade 05 - Monkey Patch: grandes poderes trazem grandes responsabilidades:

- *Monkey Patching*: modificar uma API "na marra";
- **Ex.:** ("sobrescrevendo" o método close)
```
connection.close = function() {
    throw new Error('Você não pode fechar diretamente a conexão.');
}
```
- `var close = connection.close.bind(connection);`: como o método `close` pertence à `connection`, é necessário associar o método à conexão. Outra opção é fazer `Reflect.apply(close, connection, [])`;
- `const`: palavra-chave do ES6 que serve para definir uma constante (uma propriedade com valor imutável);


## Aula 03 - Padronizando acesso aos dados com o pattern DAO

### Atividade 01 - O padrão de projeto DAO:

- *DAO*: *Data Access Object* (ou Objeto de Acesso a Dados);

### Atividade 02 - Combinando padrões de projeto:

- `parseInt(this._inputQuantidade.value);`: converte `this._inputQuantidade.value` para inteiro;
- `parseFloat(this._inputValor.value);`: converte `this._inputValor.value` para decimal;

### Atividade 04 - Removendo todas as negociações:

- **Ex.:** (limpa uma object store)
```
let request = this._connection
    .transaction([this._store], 'readwrite')
    .objectStore(this._store)
    .clear();
```

### Atividade 09 - Para saber mais: IndexedDB e transações:

- Transações do IndexedDB são *auto commited*;
- Podemos cancelar uma transação através do método `abort`;
- **Ex.:**
```
// #### VAI CANCELAR A TRANSAÇÃO. O evento onerror será chamado.
transaction.abort(); 
```
- Ao executar o código a seguinte mensagem de erro será exibida no console: `DOMException: The transaction was aborted, so the request cannot be fulfilled.`;
- Trate o cancelamento de uma transação no evento `onabort` de transaction;
- **Ex.:**
```
transaction.onabort = e => {
    console.log(e);
    console.log('Transação abortada');
};
```

### Atividade 10 - Para saber mais: bibliotecas que encapsulam o IndexedDB:

- Para lidar também com o o IndexedDB outros desenvolvedores tornaram públicas suas bibliotecas. Por exemplo, há o Dexie e o Db.js, este último utiliza promises assim como fizemos;
- Dexie: https://dexie.org/
- db.js: http://aaronpowell.github.io/db.js/


## Aula 04 - Lapidando um pouco mais nossa aplicação

### Atividade 01 - Ops! Não podemos importar negociações duplicadas:

- `negociacoes.filter(/* critério */)`: método de um *array* que itera sobre todos os itens desse *array* e filtra-os com base em um critério;
- `negociacoes.indexOf(negociacao)`: método de um *array* que verifica se o item `negociacao` está contido nesse *array*;
- **Ex.:** (definindo um critério)
```
negociacoes.filter(negociacao =>
    this._listaNegociacoes.negociacoes.indexOf(negociacao) == -1
)
```
- Se o item não é encontrado no *array*, retorna `-1`;

### Atividade 03 - Usando o método some:

- Não é possível comparar dois objetos utilizando apenas `==`. Deve-se primeiramente convertê-los para `string` com `JSON.stringify()` e só então compará-los;
- **Ex.:** `JSON.stringify(n1) == JSON.stringify(n2)`
- `Array.some(item => /* critério */)`: varre cada item do array `Array`, compara com o critério e retorna `true` ou `false`. A iteração termina caso o critério seja verdadeiro;
- **Ex.:**
```
negociacoes.filter(negociacao =>
    !this._listaNegociacoes.negociacoes.some(negociacaoExistente =>
        JSON.stringify(negociacao) == JSON.stringify(negociacaoExistente)
    )
)
```

### Atividade 13 - Para saber mais: Igualdade de objetos:

- A classe `Negociacao` sabe quando uma negociação é igual a outra, essa **regra fica encapsulada** dentro da classe;
- **Ex.:**
```
isEquals(outraNegociacao) {
    return JSON.stringify(this) == JSON.stringify(outraNegociacao)
}
```


## Aula 05 - Simplificando requisições Ajax com a Fetch API

### Atividade 01 - xmlHttpRequest: será que existe algo de mais alto nível?:

- No ES 2016, foi incluída uma API com o objetivo de simplificar a criação de requisições Ajax: **Fetch API**, uma API de busca do JS;
- `fetch(url).then(res => res.json());`: exemplo de requisição utilizando a **Fetch API**;
- Não é possível abortar uma requisição utilizando a **Fetch API**;

### Atividade 02 - Método Post:

- Uma requisição *POST* utilizando a **Fetch API** necessita de algumas configurações, como o cabeçalho, método e corpo;
- **Ex.:**
```
fetch(url, {
    headers: { 'Content-type': 'application/json' },
    method: 'post',
    body: JSON.stringify(dado)
});
```


## Aula 06 - Tornando nosso código ainda mais compatível usando Babel

### Atividade 01 - O fantasma da incompatibilidade:

- Nós programaremos com o ES6 e depois, vamos compilar o código para o ES5. Este processo de *downgrade* recebe o nome de **transcompilação** e é feito com o uso de um *transpiler* (transcompilador);

### Atividade 02 - Babel, instalação e build-step:

- `npm init`: cria o arquivo `package.json`;
- `npm install babel-cli@6.10.1 --save-dev`: adiciona a dependência do *babel-cli* na versão 6.10.1 no arquivo `package.json`;
`npm install babel-preset-es2015@6.9.0 --save-dev`: adiciona a dependência do *babel-preset-es2015* na versão 6.9.0 no arquivo `package.json`;
- Criar, na raíz do projeto, o arquivo `.babelrc` e adicionar nele a configuração do *Babel*:
- **Ex.:**
```
{
    "presets": [ "es2015" ]
}
```

### Atividade 03 - Executando o Babel:

- Adicionar dentro da propriedade `"scripts"` do arquivo `package.json`, a configuração do *build*:
- **Ex.:** `"build": "babel js/app-es6 -d js/app"`
- Execute o comando `npm run build` para transcompilar a aplicação para *ES5*;
- `--source-maps`: parâmetro do `babel-cli` que adiciona um arquivo `.map` com a referência do arquivo antes da *transcompilação*;
- **Obs.:** Foi necessário adicionar o parâmetro `--ignore polyfill` pois o *Babel* estava realizando a *transcompilação* no arquivo `/polyfill/fetch.js` (que já está em *ES6*), o que estava ocasionando erros na aplicação;

### Atividade 04 - Compilando arquivos em tempo real:

- `--watch`: parâmetro do `babel-cli` que monitora as alterações nos seus arquivos e realiza a *transcompilação* em tempo real;


## Aula 07 - Trabalhando com módulos do ES2015!:

### Atividade 02 - ES2015 e módulos:

- `export`: palavra-chave do *ES6*/*ES2015* que **exporta** um módulo;
- **Ex.:** `export class View { }`
- `import`: palavra-chave do *ES6*/*ES2015* que **importa** um módulo;
- **Ex.:** `import { View } from './View'`

### Atividade 04 - SystemJs:

- `npm install systemjs@0.19.31 --save`: adiciona para produção a dependência do *systemjs* na versão 0.19.31 no arquivo `package.json`;
- `<script src="node_modules/systemjs/dist/system.js"></script>`: importa o *script* da biblioteca *SystemJS*, que servirá como *loader* da aplicação;
- **Ex.:** (utilização do *SystemJS* em seu `index.html`)
```
System.defaultJSExtensions = true; // permite omitir a extensão .js dos imports
System.import('js/app/boot').catch(function(err){ // define o primeiro módulo a ser carregado
    console.error(err);
});
```

### Atividade 06 - Babel e transcompilação de módulos:

- `npm install babel-plugin-transform-es2015-modules-systemjs@6.9.0 --save-dev`: adiciona a dependência de transformação do ES2015 de módulos para utilizar o *systemjs* na versão 6.9.0 no arquivo `package.json`;
- Adiciona, no arquivo `.babelrc`, a configuração da dependência instalada acima;
- **Ex.:** `"plugins" : ["transform-es2015-modules-systemjs"]`;
