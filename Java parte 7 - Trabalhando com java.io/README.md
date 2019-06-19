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
