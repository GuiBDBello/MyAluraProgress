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
