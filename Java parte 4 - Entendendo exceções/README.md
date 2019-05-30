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

- ``Debug As > Java Application``: executa a aplicação em modo de depuração, que é um modo onde você controla a pilha de execução da aplicação;
- Ao ativar o modo de depuração, existem vários comandos que podem ser utilizados:
1. Step Over: pula para a próxima linha, executando o comando da linha atual, e todos comandos que estão dentro dele;
2. Step Into: entra no comando da linha atual, indo até os comandos que estão contidos neste comando;
- Variables: janela que mostra as variáveis do escopo atual, e seus valores;
- Debug: janela que mostra a pilha de execução;

#### Perspectivas (Eclipse):

- No canto superior direito, existem ícones que representam as perspectivas da IDE, ao lado do "Quick Access";
- **Ex.:** Java EE, Java e Debug;
