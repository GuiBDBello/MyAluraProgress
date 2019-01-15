# Lógica de programação I: Os primeiros programas com Javascript e HTML

## Aula 01 - Comece a programar hoje

### Atividade 03 - (Obrigatório) Editor de texto e navegador:

#### Qual editor de texto usar?

- **Sublime**: é o editor utilizado durante o treinamento. É interessante usá-lo para obter paridade visual ao longo do curso, mas não é obrigatório.
- **Notepad++**: existe apenas para Windows é uma alternativa interessante ao Sublime.

#### Qual navegador utilizar?

- Google Chrome
- 'Ctrl + O': abrir arquivo
- 'F12': abrir janela das ferramentas de desenvolvedor (DevTools)

Como falava o antigo filósofo Aristóteles: bem começado, metade feito.

### Atividade 06 - Dê olá ao mundo:

- HTML é estático, não é dinâmico
- Javascript é dinâmico

#### Javascript:

- A tag &lt;script&gt;&lt;/script&gt; define que seu conteúdo contém um código Javascript, assim fazendo o navegador interpretar seu conteúdo como Javascript
- Ao pressionar a tecla F12, um depurador do Javascript é aberto (Console). Esse depurador mostra erros de sintaxe no código Javascript

### Atividade 07 - Resumo:

- Aprendemos que desenvolver não exige um ambiente complexo;
- É possível utilizar o próprio navegador, e todo sistema operacional possui um. Ao longo do curso utilizaremos o Google Chrome;
- Podemos utilizar um editor de texto padrão. Nós usaremos o Sublime Text, disponível para todas as plataformas;
- Compreendemos que o HTML é uma linguagem de marcação, pois ela possibilita marcar conteúdos por meio de tags;
- Algumas tags não possuem marcação, como o &lt;br&gt;, que serve para pular uma linha;
- A tag &lt;a&gt; nos permite sair de uma página e mudar para outra;
- O HTML é estático, isto é, não muda. Não podemos fazer nada muito sofisticado com ele. Por esse motivo o navegador entende também a linguagem JavaScript, que é uma linguagem de programação dinâmica, com a qual podemos desenvolver de maneira mais avançada;
- Para o navegador interpretar uma instrução JavaScript, não basta colocarmos a instrução JavaScript direto no HTML. Temos que utilizar a tag &lt;script&gt;. Dessa forma o navegador saberá que deve processar essa parte do código como linguagem JavaScript e não como HTML;
- A primeira instrução que vimos do JavaScript foi o alert, que recebe como parâmetro um texto;
- Por último, aprendemos que todo texto em JavaScript vem entre aspas.

### Atividade 10 - Extensão de arquivo e convenção:

#### Convenção HTML:

- Uma convenção muito utilizada é criar arquivos com letras minúsculas e se houver mais de uma palavra usamos um " _ " como separador

### Atividade 13 - A importância da tag meta:

- Em alguns casos, o formato do arquivo pode ser incompatível com &lt;meta charset="UTF-8"&gt;, ou seja, deve-se mudar a formatação do **arquivo** para UTF-8


## Aula 02 - Comunique-se com o usuário

### Atividade 01 - Recapitulando:

- Convenção HTML: Tags devem ser escritas com letras minúsculas;
- Convenção JavaScript: A linguagem é case-sensitive, diferenciando maiúsculas e minúsculas;
- 'Ctrl + N': Abre um novo arquivo no Sublime;

- Estrutura mínima para criar um programa:
```
<meta charset="UTF-8">
<script>
</script>
```

### Atividade 04 - Concatenação:

- Escrever na página (HTML) pelo JavaScript: document.write("");
- O JavaScript interage dinamicamente com o HTML;
- document.write("") pode conter tags HTML: document.write("Meu nome é &lt;br&gt; Guilherme");
- Para concatenar duas Strings, usa-se o operador '+': document.write("Eu sou" + "o Douglas");
- Quando o operador é utilizado entre uma String e um número, eles também são concatenados;
- Porém, quando o operador é utilizado entre dois números, somam-se os números;

### Atividade 06 - Operações com textos e números:

- Assim como a matemática, a programação prioriza multiplicações e divisões sobre soma e subtração
- Para indicar uma ordem nas operações, deve-se utilizar parênteses, assim como na matemática, os parênteses são considerados primeiramente


## Aula 03 - Torne seu programa dinâmico com variáveis

### Atividade 01 - Reduzindo alterações:

- var nomeVariavel = "valorVariavel";
- **Ex.:**
```
var nome = "Guilherme";
var ano = 2018;
```

> O processo de "raciocínio" do JavaScript será questionar se determinado trecho está entre aspas. Se estiver, é uma string; se não, será feita uma próxima pergunta: trata-se de um número? Caso a resposta seja "não", significa que se trata de uma variável.

### Atividade 06 - Variáveis:

- Math.round(numero): Arredonda 'numero' para decimal;


## Aula 04 - Crie suas próprias funcionalidades

### Atividade 02 - Funções:

- Por convenção Javascript, as funções ficam no início do código
- O nome da função deve ser um verbo, pois indica uma **ação** do programa
- Uma função é um bloco de código que serve de "atalho" para várias outras instruções
- Sintaxe: function 'nomeDaFuncaoSemParametro'() { }

### Atividade 05 - Funções com parâmetros:

- Sintaxe: function 'nomeDaFuncao'('variavel') { }


## Aula 05 - Pratique resolvendo problemas do seu dia a dia

### Atividade 05 - Retorno de funções:

- 'NaN': Not a Number. Ocorre quando uma operação matemática possui um valor 'undefined'
- Uma função pode retornar um valor, que pode ser salvo em uma variável
- 'return' 'valor': define o valor retornado de uma função

### Atividade 11 - Interagindo com usuário:

- 'prompt()': função Javascript que recebe como parâmetro o texto que será exibido na caixa de diálogo e retorna o valor escrito pelo usuário (input/entrada)


## Aula 06 - Execute códigos diferentes dependendo da condição

### Atividade 01 - Convertendo texto em números:

- O retorno da função 'prompt()' é sempre do tipo texto
- O Javascript converte o tipo texto em número quando há uma multiplicação ou divisão
- 'parseInt()': função que converte texto em número (inteiro)

### Atividade 05 - Trabalhando com condições:

- 'if() { }': denota uma condição que deve ser cumprida para executar o código dentro de seu bloco
- '>, <, ==, !=': operadores lógicos que indicam 'maior, menor, igual, diferente'
- Uma condição (if) sempre retorna 'true' ou 'false'

### Atividade 07 - Melhorando programa de IMC:

- '&&', '||': operadores que significam, respectivamente, "e" e "ou"

### Atividade 09 - Jogo de adivinhação:

- 'else': condição contrária do 'if'. Significa, literalmente, "se não". É executado quando o 'if' correspondente é 'false'
- 'Math.random()': gera um número aleatório. Para gerar um número decimal, multiplica seu retorno por 10
- Combine o 'Math.random() * 10' com o 'Math.round()' para gerar um número de 0 a 10
- O número gerado por 'Math.random() * numero' será entre 0 e o número multiplicado
- 'console.log()': escreve o parâmetro no 'Console' do navegador


## Aula 07 - Repita tarefas

### Atividade 01 - Repetir enquanto...:

- 'while() { }': repete o que está dentro do bloco de código até que a condição seja verdadeira

### Atividade 09 - Outra forma de repetir:

- 'for("inicializacao"; "condicao"; "incremento";) { }'
- **Ex.:** for(var contador = 1; contador <= 10; contador++) { }
- 'nomeVariavel++;': denominado **pós-incremento**, é equivalente à sintaxe 'nomeVariavel = nomeVariavel + 1;'

### Atividade 12 - Acumulando valores:

- Para acumular um valor dentro de um laço de repetição, deve-se inicializar a variável **fora** do laço, para apenas incrementá-la dentro do laço. Caso contrário, a cada iteração, ela será reinicializada

### Atividade 15 - Interrompendo uma repetição:

- 'break;': quebra a execução do primeiro laço acima

### Atividade 17 - Repetições aninhadas:

- Dois laços de repetição aninhados formam uma matriz (NxN, onde N é o número de repetições de cada laço)

### Atividade 18 - Para saber mais: parseFloat e quando usar:

- 'parseFloat("");': função Javascript que converte um texto em um número com ponto flutuante (decimal)
- **Ex.:** parseFloat("12.13");
