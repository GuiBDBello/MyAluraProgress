# Java parte 4: Entendendo exceções

## Aula 01 - Pilha de execução

### Atividade 02 - Pilha de execução:

#### Eclipse:

- Quick access: serve para facilitar o acesso à várias funcionalidades do Eclipse.
- **Ex.:** Para aumentar a fonte, digite "font" e selecione "Preferences";
- No Java, qualquer programa é organizado em forma de uma "pilha". Ou seja, quando comandos são chamados, eles vão "empilhando" e o comando no topo da pilha (ou seja, o comando que foi chamado por último) possui prioridade na execução, e é removido dessa pilha após finalizado, seguindo ao próximo comando desta pilha;

### Atividade 05 - Depuração:

- Line breakpoint: "quebra" a execução na linha onde esse evento é adicionado;
- Para adicionar um "Line breakpoint" (Eclipse), clique duas vezes no número da linha que você deseja adicioná-lo;

#### Debug:

- `Debug As > Java Application`: executa a aplicação em modo de depuração, que é um modo onde você controla a pilha de execução da aplicação;
- Ao ativar o modo de depuração, existem vários comandos que podem ser utilizados:
1. Step Over: pula para a próxima linha, executando o comando da linha atual, e todos comandos que estão dentro dele;
2. Step Into: entra no comando da linha atual, indo até os comandos que estão contidos neste comando;
- Variables: janela que mostra as variáveis do escopo atual, e seus valores;
- Debug: janela que mostra a pilha de execução;

#### Perspectivas (Eclipse):

- No canto superior direito, existem ícones que representam as perspectivas da IDE, ao lado do "Quick Access";
- **Ex.:** Java EE, Java e Debug;


## Aula 02 - Tratamento de exceções

### Atividade 01 - Introdução a exceções:

- Exceções são problemas que ocorrem na execução do código, e alteram o fluxo da aplicação;
- Quando ocorre uma exceção, ela busca em toda a pilha de execução um tratamento para ela. Caso não encontre, a execução do fluxo da aplicação é encerrada;

### Atividade 03 - Try Catch:

- `try { } catch('Excecao' ex) { }`: tentativa e captura de erro. 'Excecao' é a exceção que deve ser obtida após a tentativa da execução deste bloco de código;
- O local de um try-catch em uma pilha de execução pode afetar o fluxo de uma aplicação;

### Atividade 05 - Variação do Catch:

- `ex.getMessage();`: retorna a mensagem da exceção;
- `ex.printStackTrace();`: retorna o rastro da pilha de execução;
- É possível concatenar 'catches', um após o outro, após o fim do bloco do catch anterior;
- Multi-Catch: a partir do Java 1.7, é possível utilizar 'ou' dentro dos parâmetros de um catch;
- **Ex.:** `... catch (ArithmeticException | NullPointerException ex) { ... }`;


## Aula 03 - Lançando exceções

### Atividade 01 - Revisão:

- Bugs são imprevistos e causam exceções. Por isso é importante que o desenvolvedor entenda a pilha de execução da aplicação, seu rastro e as exceções;
