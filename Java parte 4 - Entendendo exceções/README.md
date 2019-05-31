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

### Atividade 03 - Lançando exceções:

- `ArithmeticException ex = new ArithmeticException();`: cria um objeto com uma referência a ArithmeticException;
- Obs.: a memória onde os objetos Java são armazenados chama-se HEAP;
- `throw ex;`: dispara uma exceção 'ex';
- É possível passar uma mensagem por parâmetro à exceção;
- **Ex.:** `ArithmeticException ex = new ArithmeticException("Ocorreu um erro!");`;
- Porém, é mais comum que uma exceção não seja guardada em um objeto;
- **Ex.:** `throw new ArithmeticException("Ocorreu um erro!");`;


## Aula 04 - Checked e Unchecked

### Atividade 01 - Hierarquia de exceções:

- `ArithmeticException` é filha de `RuntimeException` que é filha de `Exception` que é filha de `Throwable`;
- Para jogar um Objeto na pilha de execução/erros, é necessário que a Classe desse Objeto herde de `Throwable`;
- `Ctrl + O`: atalho do Eclipse que mostra todos os membros de uma Classe;

#### Criando uma exceção:

- Criar uma nova Classe `MinhaExcecao`;
- Herdar de `RuntimeException`;
- Criar construtores que chamam os construtores das Classes herdadas, utilizando `super()`;
- Capturar a exceção em algum local da pilha de execução, utilizando `catch(MinhaExcecao ex) { }`;

### Atividade 03 - Entendendo erros:

- Outra Classe que herda de `Throwable`, além da Classe `Exception`, é a Classe `Error`;
- A Classe `Error` não existe para desenvolvedores Java, mas sim da JVM;
- Um erro muito conhecido dessa Classe `Error` é o `StackOverflowError`, que representa a "sobrecarga" do tamanho máximo da pilha de execução (que ocorre, por exemplo, ao chamar um método recursivo infinitamente);

### Atividade 04 - Checked e unchecked:

- Ao herdar de `RuntimeException`, é possível disparar uma exceção quando quiser, utilizando `throw new 'excecao';`. Essas exceções são categorizadas como "unchecked", pois **não são** verificadas pelo compilador;
- Ao herdar de `Exception`, é necessário deixar explícito na assinatura do método que a exceção será disparada, utilizando `public void 'nomeMetodo' throws 'excecao' { }`  ou `try-catch`. Essas exceções são categorizadas como "checked", pois são, **obrigatoriamente**, verificadas pelo compilador;
- A diferença entre exceções "checked" e "unchecked" é o processo de compilação. Sua execução ocorre da mesma forma, como uma "bomba" na pilha;
- O conceito de exceções existe em várias linguagens, mas o que acabamos de estudar — checked e o unchecked — é algo específico do mundo Java.

### Atividade 09 - O que aprendemos?:

- Existe uma hierarquia grande de classes que representam exceções. Por exemplo, `ArithmeticException` é filha de `RuntimeException`, que herda de `Exception`, que por sua vez é filha da classe mais ancestral das exceções, `Throwable`. Conhecer bem essa hierarquia significa saber utilizar exceções em sua aplicação.
- `Throwable` é a classe que precisa ser extendida para que seja possível jogar um objeto na pilha (através da palavra reservada `throw`)
- É na classe `Throwable` que temos praticamente todo o código relacionada às exceções, inclusive `getMessage()` e `printStackTrace()`. Todo o resto da hierarquia apenas possui algumas sobrecargas de construtores para comunicar mensagens específicas
- A hierarquia iniciada com a classe `Throwable` é dividida em **exceções** e **erros**. Exceções são usadas em códigos de aplicação. Erros são usados exclusivamente pela máquina virtual.
- Classes que herdam de `Error` são usadas para comunicar erros na máquina virtual. Desenvolvedores de aplicação não devem criar erros que herdam de `Error`.
- `StackOverflowError` é um erro da máquina virtual para informar que a pilha de execução não tem mais memória.
- Exceções são separadas em duas grandes categorias: aquelas que são obrigatoriamente verificadas pelo compilador e as que não são verificadas.
- As primeiras são denominadas *checked* e são criadas através do pertencimento a uma hieraquia que não passe por `RuntimeException`.
- As segundas são as *unchecked*, e são criadas como descendentes de `RuntimeException`.
