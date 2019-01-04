# HTML5 e CSS3 I: Suas primeiras páginas da Web

## Aula 01 - Introdução ao HTML

### Atividade 01 - Iniciando com HTML:

- Começo de tudo: conteúdo. Após ter o conteúdo é que começa o desenvolvimento das telas
- Pode-se iniciar formatando o texto em um editor de texto. Isso ajuda a visualizar melhor o resultado desejado

#### Tag:
- bloco de construção da linguagem HTML que define propriedades para seu conteúdo
- **Ex.:** &lt;h1&gt;&lt;/h1&gt;

#### Codificação de texto: 

- Cada caractere possui um reconhecimento binário pelo computador
- Existem várias codificações diferentes, que não seguem os mesmos binários para cada caractere. Por isso, deve-se definir qual a codificação está sendo utilizada para o computador representar o binário correto para cada caractere
- A codificação "UTF-8" é uma das mais modernas; é universal, ou seja, é reconhecida em todos países

#### Atributo:

- atributo: é utilizado dentro de uma tag. Serve para determinar uma característica de uma tag
- **Ex.:** &lt;meta **charset**="UTF-8"&gt;

- A tag &lt;link&gt; serve para definir o ícone da aba com os atributos **rel** e **href**

#### Metainformações:

- Informações que o navegador mostra para o usuário
- A tag que separa essas informações do conteúdo da página é a tag &lt;head&gt;

#### Conteúdo:

- &lt;body&gt; é a tag utilizada para definir o conteúdo da página

#### Página HTML:

- A tag &lt;html&gt; comunica ao navegador que a &lt;head&gt; e o &lt;body&gt; pertencem à mesma página

#### DOCTYPE:

- O 'DOCTYPE' **não é uma tag**, serve para especificar a versão do HTML
- Utiliza-se &lt;!DOCTYPE html&gt; para comunicar ao navegador que a versão do HTML é a última disponível (atualmente a versão 5)
- DOCTYPE não vem do HTML, mas do SGML (Standard Generalized Markup Language)


## Aula 02 - Introdução a CSS

### Atividade 01 - Começando com CSS:

- Pode-se alterar o visual de uma tag utilizando o atributo **style**
- Isso não é uma boa prática, pois se houver muitas tags na página deverá ser inserido um **style** em cada tag, dificultando também possíveis alterações na página
- Para facilitar, é possível criar uma tag 'style' dentro da tag 'head' que aplicará alterações no visual de todas as tags definidas dentro dela

#### Seletor:

- Elemento que possui regras que serão aplicadas em todas "instâncias" desse elemento
- **Ex.:** 'tag' { 'regra': 'valor'; } ou h1 { font-size: 60px; }

- Para reutilizar o 'style' em outras páginas, deve-se criar um arquivo de formato '.css' e "chamar" esse arquivo em páginas HTML pela tag 'link' com o atributo **rel**="stylesheet" e **href**="nomeArquivo.css"

#### Cores:

- As cores podem ser definidas por 'rgb('red', 'green', 'blue');' ou pelo hexadecimal '#redgreenblue;'
- **Ex.:** 'rgb(250, 255, 250);' ou '#FAFFFA;'

- Centralizar texto: **text-align**

#### Fonte:

- Alterar fonte: **font-family**
- Pode-se inserir uma fonte específica (**Ex.:** "Arial") ou uma família (**Ex.:** sans-serif). A família não necessita estar entre aspas
- Também poderão ser definidas várias fontes diferentes, separando-as por vírgula (**Ex.:** "Arial", sans-serif)