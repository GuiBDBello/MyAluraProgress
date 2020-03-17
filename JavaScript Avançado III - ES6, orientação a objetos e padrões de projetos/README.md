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
