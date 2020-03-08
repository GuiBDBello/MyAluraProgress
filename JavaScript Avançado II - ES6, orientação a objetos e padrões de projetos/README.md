# JavaScript Avançado II: ES6, orientação a objetos e padrões de projetos

## Aula 01 - Como saber quando o modelo mudou?

### Atividade 01 - Você lembrou de atualizar a view? Nem eu!:

- `this._negociacoes = [];`: limpa/esvazia o array `_negociacoes`;

### Atividade 03 - API Reflection e as facetas de this:

- `Reflect.apply(function() {}, this._contexto, [param1, param2]);`: método que executa uma função `function() {}` no contexto `this._contexto`, utilizando um vetor de parâmetros `[param1, param2]`;

### Atividade 04 - Arrow function e seu escopo léxico:

- O escopo do `this` de uma arrow function é *léxico*, não é dinâmico como numa função. Ele não muda de acordo com o contexto;

### Atividade 09 - Contexto das arrows functions:

- É possível guardar um contexto em uma variável, por exemplo, `self`, e acessá-lo quando necessário.
- **Ex.:** `let self = this;`
