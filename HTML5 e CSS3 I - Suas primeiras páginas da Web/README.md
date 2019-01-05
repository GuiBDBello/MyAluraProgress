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

### Atividade 08 - Google Fonts:

- A Google disponibiliza o serviço chamado [Google Fonts](https://fonts.google.com/), que possui várias fontes para serem utilizadas no desenvolvimento de sites


## Aula 03 - Aprofundando no HTML

### Atividade 01 - Aprofundando no HTML:

#### Link relativo:

Qualquer link que não comece com 'http' é considerado um link relativo. Exemplos de links relativos:
- Endereço a partir do local do arquivo atual: href="blog.html"
- Endereço após o domínio: href="/projeto/blog.html"
- Endereço após o protocolo: href="//alura.com.br/projeto/blog.html"

#### Tags:

Um HTML semântico melhora a acessibilidade do site para todos. Algumas tags que auxiliam na semântica do HTML são:
- &lt;nav&gt;: é uma tag que auxilia na navegação da página. Agrega semântica ao HTML, facilitando também para os buscadores (google e afins) encontrar conteúdos específicos em seu site
- &lt;main&gt;: conteúdo principal da página
- &lt;header&gt;: cabeçalho da página ou de uma região dela
- &lt;footer&gt;: rodapé da página ou de uma região dela
- &lt;aside&gt;: conteúdo auxiliar ao conteúdo principal, como links relacionados ao conteúdo
- &lt;article&gt;: conteúdo que, por si só, já tem um sentido completo, como um post de um blog ou uma notícia
- &lt;section&gt;: parte/seção de uma página ou texto
- &lt;blockquote&gt;: indica uma citação
- &lt;cite&gt;: indica o autor de uma citação (deve ser utilizado dentro de um &lt;blockquote&gt;)

- Pode-se definir os atributos de elementos que estão dentro de outros elementos utilizando um arquivo .css. É necessário separá-los por 'Espaco' para determinar, hierarquicamente, qual elemento (o último da hierarquia) receberá os atributos definidos naquele seletor

#### Entidades:

O HTML nos permite especificar caracteres especiais por meio das **entidades**. Algumas delas são:
- `&euro;`: &euro;
- `&yen;`: &yen;
- `&pound;`: &pound;
- `&reg;`: &reg;
- `&hearts;`: &hearts;