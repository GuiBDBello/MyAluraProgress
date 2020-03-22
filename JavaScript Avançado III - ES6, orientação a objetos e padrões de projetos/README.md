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
