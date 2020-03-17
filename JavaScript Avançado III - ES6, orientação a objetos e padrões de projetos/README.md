# JavaScript Avançado II: ES6, orientação a objetos e padrões de projetos

## Aula 01 - Guardando negociações offline com IndexedDB

### Atividade 02 - Browser possui banco de dados? Conheça o IndexedDB!:

- `window.indexedDB` ou `indexedDB`: retorna uma *Factory* para criar bancos no *IndexedDB*;
- `var openRequest = window.indexedDB.open('aluraframe', 1)`: requisição de abertura do banco, onde `'aluraframe'` é o nome do banco e `1` é ;
- `openRequest.onupgradeneeded`, `openRequest.onsuccess` e `openRequest.onerror`: "tríade" de eventos disparados quando um banco no *IndexedDB* é acessado;
- `openRequest.onupgradeneeded`: recebe uma função que cria ou altera um banco já existente;
- `openRequest.onsuccess`: recebe uma função que obtém uma conexão com sucesso;
- `openRequest.onerror`: recebe uma função que obtém o problema que ocorreu na chamada do banco;
- No navegador (*Google Chrome*), é possível visualizar o banco na aba *Application* do console de desenvolvedor (F12), dentro de *IndexedDB*;
