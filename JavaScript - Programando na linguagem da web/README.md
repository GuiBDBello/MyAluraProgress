# JavaScript: Programando na linguagem da web

## Aula 01 - Introdução

### Atividade 04 - Olá Mundo com JavaScript:

- Adicionado projeto base "introducao-javascript";

#### Saída de dados:

- alert(""): função JavaScript que mostra um pop-up na tela;
- console.log(""): função JavaScript que mostra uma mensagem no console do desenvolvedor (browser);

### Atividade 07 - Query Selector:

- DOM (Document Object Model): é a representação do HTML no JavaScript;
- document: palavra-chave utilizada para acessar o DOM. Toda a página é representada pelo 'document';
- querySelector(""): função do 'document' que retorna uma pesquisa do elemento da página equivalente ao parâmetro da função;
- É uma boa prática colocar os scripts no final do corpo da página, para garantir que os elementos estejam carregados quando forem chamados;
- textContent: propriedade de um elemento com o conteúdo de texto dele;

### Atividade 08 - Boas Práticas:

#### Query Selector:

- Além da tag, a função querySelector("") também aceita receber, como parâmetro, um id, classe ou seletor CSS;

- É uma boa prática separar todo o código JavaScript do código HTML e do código CSS. Para isso, cria-se um documento de extensão .js, e chama-o no HTML da página desejada;


## Aula 02 - Variáveis e Operadores

### Atividade 01 - Buscando dados do paciente:

- É possível utilizar o 'querySelector("")' em uma variável que não seja o 'document';


## Aula 03 - Arrays, Loop e Estilos

### Atividade 01 - Replicando a validação e o cálculo do IMC para todos os pacientes:

- querySelector(""): retorna apenas um elemento;
- querySelectorAll(""): retorna um vetor com todos os elementos;
- variavel.length: propriedade de um vetor que representa o seu número de posições;
- variavel.toFixed(numero): função que retorna o valor de 'variavel' com a quantidade de casas decimais do parâmetro 'numero';

### Atividade 02 - Estilos com JavaScript:

- É possível alterar o 'style' de um elemento HTML no JavaScript, utilizando 'elemento.style';
- Deve-se escolher uma propriedade a ser alterada, como 'elemento.style.propriedade';
- Propriedades com mais de uma palavra devem ser escritas em camelCase;
- **Ex.:** paciente.style.backgroundColor = "red";

- Porém, não é uma boa prática alterar o estilo diretamente pelo JavaScript;
- Para melhorar isso, deve-se criar uma nova classe no arquivo .css;
- Após, utilizar 'elemento.classList.add()' para adicionar uma nova classe ao elemento;


## Aula 04 - Eventos, Formulários e Criando Elementos

### Atividade 01 - Escutando eventos:

- elemento.addEventListener("click", nomeFuncao): adiciona um "ouvinte" de clique em um elemento, esperando uma ação de clique. Quando for clicado, executa a função do segundo parâmetro;
- function() { ...código... }: essa declaração de função é chamada de "Função Anônima". Ela possui esse nome pois não tem uma assinatura;
- Porém, ao adicionar o "ouvinte" no botão e clicá-lo, nada acontece. Isso ocorre pois o botão está dentro de um Formulário (&lt;form&gt;), e ao confirmar o envio do Formulário seus dados são enviados a outra página (nesse caso, a mesma, ocasionando no recarregamento da página), e perde-se qualquer log ou alteração nela;

### Atividade 04 - Evitando o comportamento padrão de um evento:

- event.preventDefault(): previne o comportamento padrão de um evento (no caso acima, envia o Formulário e recarrega a página);
- Para isso, deve-se passar um 'event' no parâmetro de uma função, e executar o código acima no corpo da função;

### Atividade 06 - Adicionando pacientes na tabela:

- Ao utilizar um 'querySelector()'' em um Formulário (&lt;form&gt;), é possível (caso exista a propriedade 'name') obter os valores dos campos (&lt;input&gt;) desse Formulário;
- document.createElement("tag"): cria um elemento vazio no HTML;
- elementoPai.appendChild(elementoFilho): adiciona, no HTML, o 'elementoFilho' dentro de 'elementoPai';

### Atividade 12 - Para saber mais: event shortcut:

- É uma forma de adicionar uma função diretamente a um evento;
- **Ex.1:** elemento.onclick = nomeFuncao;
- **Ex.2:** elemento.onmouseover = function() { // código...; };
- Vantagem: código mais limpo. Desvantagem: pode-se adicionar apenas uma função por evento, onde com um 'addEventListener()' é possível adicionar várias;


## Aula 05 - Boas Práticas com Javascript

### Atividade 01 - Quebrando o código em arquivos diferentes:

- É uma boa prática dividir o código por funcionalidades;
- Essa divisão ocorre em arquivos, onde cada arquivo possui uma funcionalidade específica;

### Atividade 03 - Criando funções:

- Uma Função é um bloco de código com uma *funcionalidade* específica;
- Funções são utilizadas, principalmente, para melhorar o *reaproveitamento* do código;

### Atividade 04 - Criando um objeto paciente:

- Objeto: um objeto representa alguma coisa do "mundo real" que possui características (propriedades) em comum;
- **Ex.:** var objeto = { propriedade1: valor1, propriedade2: valor2 }

### Atividade 06 - Melhorando ainda mais o código:

- form.reset(): função do elemento 'form' (&lt;form&gt;) que limpa todos os campos do Formulário;


## Aula 06 - Validação de Formulários

### Atividade 01 - Validando os dados do formulário:

- '!': operador lógico que representa **negação**;
- 'return;': retorno vazio, obriga a saída da função;

### Atividade 02 - Exibindo mensagens de erro:

- array.push(conteudo): adiciona 'conteudo' em uma nova posição de um 'array';

### Atividade 03 - Validando o restante dos campos:

- array.forEach(function(item) { }): itera sobre um 'array', executando a função do parâmetro para cada item desse array;
- elemento.innerHTML = "": altera o HTML interno de um elemento;


## Aula 07 - Remoção, Delegação e Animação

### Atividade 01 - Removendo pacientes:

- dblclick: evento de duplo-clique do mouse;
- **Ex.:** elemento.addEventListener("dblclick", function() { });
- elemento.remove(): apaga o elemento do DOM;
- this: palavra reservada do JavaScript que representa o contexto atual da execução;

### Atividade 03 - Delegando eventos:

- Event Bubbling: ao adicionar um 'evento' em um 'elemento', sua ativação faz com que o 'evento' percorra todos os elementos-pai, até chegar ao &&lt;body&gt;, onde ele "estoura" (analogia com bolhas de gás de um refrigerante);
- Ao criar um 'evento' em um 'elemento' é possível **Delegar** a atribuição do 'evento' ao mesmo 'elemento', fazendo-o atribuir a todos seus elementos-filho o 'evento' que lhe foi adicionado;
- event.target: o 'elemento' que acionou o 'evento';
- parentNode: propriedade de um 'elemento' que retorna seu 'elementoPai';

### Atividade 06 - Animando a remoção do paciente:

- setTimeout(function() { }, milissegundos): função JavaScript que "espera" um tempo (em 'milissegundos'), e após, executa uma função;
