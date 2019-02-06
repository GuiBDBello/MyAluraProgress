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
- variavel.toFixed(numero): função retorna o valor de 'variavel' com a quantidade de casas decimais do parâmetro 'numero';

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
- Porém, ao adicionar o "ouvinte" no botão e clicá-lo, nada acontece. Isso ocorre pois o botão está dentro de um Formulário (&lt;form&gt;), e ao confirmar o envio do Formulário (clique do botão) a página é recarregada, e perde-se qualquer log ou alteração nela;