# Java parte 7: Trabalhando com java.io

## Aula 01 - Leitura com java.io

### Atividade 02 - Estabelecendo a entrada:

#### Entrada através de um arquivo:

- `FileInputStream fis = new FileInputStream("lorem.txt");`: carrega o fluxo do arquivo 'lorem.txt' na pasta raiz do projeto. É o "ponto de entrada" da leitura de um arquivo, e retorna os dados do arquivo em binários;
- O pacote java.io possui muitas exceções *checked*, pois pacotes de leitura e saída de dados não dependem, necessariamente, do compilado, se tornando um código "perigoso";
- `InputStreamReader isr = new InputStreamReader(fis);`: lê um `FileInputStream` (fluxo de entrada de arquivo). Transforma os bytes do arquivo em caracteres, e retorna os dados do arquivo em caracteres;
- `BufferedReader br = new BufferedReader();`: "guarda" caracteres de uma linha em um *buffer*, e retorna o conteúdo do arquivo como uma String;
- `br.readLine();`: retorna uma String com o conteúdo da primeira linha de um arquivo de texto. Caso retorne `null`, significa que a linha não possui caracteres;
- Existem duas principais exceções no pacote java.io: `FileNotFoundException` e `IOException`;
- Ao inicializar um `BufferedReader`, deve-se fechar essa entrada de dados, utilizando `br.close();`. Caso exista um `InputStreamReader` e um `FileInputStream` ligados à esse `BufferedReader`, eles também serão fechados;

### Atividade 04 - InputStream e Reader:

- Esse "incremento" que ocorre entre Objetos, onde um Objeto recebe outro, e esse processo é repetido sequencialmente (`BufferedReader > InputStreamReader > FileInputStream > lorem.txt`), é chamado de *decorator*;
- `java.io` possui vários padrões de projeto;
- `while(linha != null) { linha = br.readLine(); }`: o método `readLine()` retorna `null` quando uma linha não possui caracteres. Portanto, o laço acima é feito para ler um arquivo enquanto o mesmo possua caracteres;

#### Stream:

- Fluxo de leitura de bytes (dados binários);
- Mais utilizado em arquivos (imagem, PDF);
- `InputStream`: Classe abstrata que é 'mãe' de todas Classes com *Stream*;

#### Reader:

- Leitura de fluxos de caracteres (caracteres);
- Mais utilizado em arquivos de texto (txt);
- `Reader`: Classe abstrata que é 'mãe' de todas Classes com *Reader*;


## Aula 02 - Escrita com java.io

### Atividade 01 - OutpputStream e Writer:

- Inversamente proporcional aos conceitos de entrada;
- As Classes substituem "Input" por "Output" e "Reader" por "Writer";
- `OutputStream`, `FileOutputStream`, `Writer`, `OutputStreamWriter` e `BufferedWriter`;
- `bw.write("");`: método de `BufferedWriter` que insere o conteúdo da String parametrizada no arquivo de texto definido no Objeto `OutputStream`;
- `bw.newLine();`: método de `BufferedWriter` que insere uma nova linha no arquivo de texto definido no Objeto `OutputStream`;

### Atividade 04 - Outras entradas e saídas:

#### Entrada pelo teclado:

- `InputStream is = System.in;`: entrada do teclado;
- A condição do `while` não pode mais ser `!= null`, pois é impossível que `System.in` retorne um `null`. Portanto, deve-se alterar a condição para `!linha.isEmpty()`;

#### Saída pelo console:

- `System.out;`: escreve a saída no console, porém apenas quando o `BufferedWriter` é fechado (`bw.close()`);
- `bw.flush();`: dá uma "descarga" no `BufferedWriter`, jogando a saída no console;

#### Entrada/Saída pela rede:

- `Socket s = new Socket()`: um Socket realiza uma comunicação entre duas máquinas;
- `s.getInputStream();`: envia uma mensagem para outra máquina;
- `s.getOutputStream();`: recebe uma mensagem de outra máquina;

#### Servlet:

- "Mini-servidor";
- Recebe e devolve dados (java.io);
- Também utiliza *Input*, *Output*, *Reader*, *Writer*;


## Aula 03 - FileWriter e PrintStream

### Atividade 01 - Saída com FileWriter:

- `FileWriter fw = new FileWriter(arquivo);`: instancia um `FileWriter`, utilizado para escrever em um arquivo 'arquivo';
- `fw.write("texto");`: escreve a String 'texto' em um arquivo;
- `fw.write("\n");`: pula uma linha;
- `System.lineSeparator();`: retorna os caracteres utilizados para quebrar uma linha, independente do sistema operacional;

### Atividade 03 - PrintWriter e PrintStream:

- Se uma Classe for `public`, seu nome deve ser o mesmo do que o nome do arquivo;
- `PrintStream ps = new PrintStream("arquivo.txt");`: serve para imprimir caracteres;
- `ps.println("texto");`: imprime a String `"texto"` num arquivo, e após, pula uma linha;
- A referência `out` de `System.out.println()` referencia um Objeto da Classe `PrintStream`, porém, ao invés de escrever em um arquivo, ele escreve no Console;
- `PrintWriter pw = new PrintWriter;`: semelhante à `PrintStream`, porém herda de `Writer`, enquanto `PrintStream` herda de `OutputStream`;

### Atividade 07 - Para saber mais: currentTimeMilis:

- `long millis = System.currentTimeMillis();`: retorna os milissegundos que passaram desde 1 de janeiro de 1970, data considerada o início da *Era Unix*. Ou seja, essa data é o marco zero no sistema de calendário usado nos sistemas operacionais UNIX;
- É comum utilizar esses métodos para medir o tempo de um trecho dé código, obtendo `long ini = System.currentTimeMillis();` antes do trecho e `long fim = System.currentTimeMillis();` depois, para então subtrair `fim - ini`, obtendo o tempo que passou;


## Aula 04 - Usando java.util.Scanner

### Atividade 01 - Leitura com Scanner:

- CSV: *comma separated values*;
- `Scanner scanner = new Scanner(new File("contas.csv"));`: pertence ao pacote java.util, muito utilizado para leitura de dados. Possui vários métodos de alto nível;
- `scanner.nextLine();`: retorna uma String com o conteúdo da próxima linha do arquivo, iniciando na primeira linha;
- `scanner.hasNextLine();`: retorna um boolean que representa se o arquivo possui conteúdo em sua próxima linha;
- `scanner.close();`: como Scanner é um recurso, ele também deve ser fechado, para encerrar seu consumo de memória;

### Atividade 03 - Parseando arquivo:

#### String:

- `linha.split(",");`: retorna um Array de Strings, dividida pelo argumento `","`, onde cada posição recebe o conteúdo da String até a próxima ',';
- `Arrays.toString(valores);`: retorna todos os valores de um Array 'valores';

#### Scanner:

- `Scanner linhaScanner = new Scanner(linha);`: instancia um novo Objeto `Scanner` utilizando uma String como parâmetro;
- `linhaScanner.useDelimiter(",");`: divide o conteúdo do `Scanner` ao encontrar a String `","`. Porém, ao contrário do `split()`, retorna um `Scanner`;
- `linhaScanner.next();`: após utilizar o método `useDelimiter(",")`, esse método retorna a próxima ocorrência do delimitador no conteúdo da String;
- Existem variações do método `next()`, sendo algumas: `nextInt()` e `nextDouble()`;
- `linhaScanner.useLocale(Locale.US);`: determina que o `Scanner` deve utilizar as regras regionais dos Estados Unidos para separação de números decimais, entre outras regras;

### Atividade 05 - Formatação de valores:

- `String.format("%s %s %s", args1, args2, args3);`: retorna o valor formatado (`%s` representa `String` e 'args' representam os valores que devem ser "jogados" em cada tipo);

#### Formatações com '%':

- `%s`: String;
- `%d`: int;
- `%f`: float;
- É possível, também, utilizar a quantidade de caracteres do valor formatado;
- O número `0` na frente de um valor formatado (`%010d`) indica que o conteúdo anterior ao valor deve ser preenchido com 0 (por exemplo, um número 10, formatado com `%04d`, será escrito no formato `0010`);
- `%n`: quebra de linha;
- **Ex.:** `String.format("%04d-%08d, %20s: %08.2f %n", numero, numero, nome, valor);`
- https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
- É possível passar na chamada do método a região de formatação da String, utilizando `new Locale("pt", "BR")`;
- Também é possível utilizar o método `System.out.format()` que já escreve a saída da formatação no console;
- **Ex.:** `String.format(new Locale("pt", "BR"), "%s - %04d-%08d, %20s: %08.2f %n", tipoConta, agencia, numero, titular, saldo);`

### Atividade 08 - Para saber mais: java.util.Properties:

- A Classe `java.util.Properties` trabalha com mapas que contém **chave** e **valor**;

#### Escrita de properties:

- `Properties props = new Properties();`: instancia um novo Objeto de propriedades;
- `props.setProperty("endereco", "www.alura.com.br");`: define a chave e o valor de uma propriedade;
- `props.store(new FileWriter("conf.properties"), "algum comentário");`: cria o arquivo 'conf.properties' com as propriedades já definidas;

#### Leitura de properties:

- `Properties props = new Properties();`: instancia um novo Objeto de propriedades;
- `props.load(new FileReader("conf.properties"));`: lê o arquivo 'conf.properties', guardando os dados dele no Objeto 'props';
- `props.getProperty("endereco");`: após lido o arquivo com o método `load()`, retorna uma String com o valor da chave 'endereco';


## Aula 05 - Encoding e Charsets

### Atividade 01 - Character Sets:

- *American Standard Code for Information Interchange*, mais conhecida por tabela ASCII, possui 127 caracteres: https://pt.wikipedia.org/wiki/ASCII
- *Codepages*: extensões da tabela ASCII, como a *Extended ASCII*: https://www.ascii.ca/ascii_standard.htm
- Problemas de *Encoding* ocorrem pois são utilizadas tabelas ASCII (ou extensões desta) diferentes para trocar informações;
- Unicode: criada por uma associação cujo objetivo é possuir todos os caracteres possíveis de todos idiomas, ou seja, uma tabela "universal" (é a tabela utilizada pelo Java);
- O número de uma tabela dessas, que identifica um caractere, é denominado *Codepoint*;

#### Encoding:

- Cada caractere de um texto possui um *Codepoint* para relacioná-lo ao Unicode;
- Uma outra tabela utiliza esse *Codepoint* para traduzí-lo em uma sequência binária (ASCII, UTF-8, UTF-16, ...);
- *Unicode Transformation Format* (UTF-8, UTF-16): traduz os *Codepoints* (faz um *Encode*) para o formato binário, gravando o caractere no HD;
