# Java parte 7: Trabalhando com java.io

## Aula 01 - Leitura com java.io

### Atividade 02 - Estabelecendo a entrada:

#### Entrada através de um arquivo:

- `FileInputStream fis = new FileInputStream("lorem.txt");`: carrega o fluxo do arquivo 'lorem.txt' na pasta raiz do projeto. É o "ponto de entrada" da leitura de um arquivo, e retorna os dados do arquivo em binários;
- O pacote java.io possui muitas exceções *checked*, pois pacotes de leitura e saída de dados não dependem, necessariamente, do compilado, se tornando um código "perigoso";
- `InputStreamReader isr = new InputStreamReader(fis);`: lê um `FileInputStream` (fluxo de entrada de arquivo). Transforma os bytes do arquivo em caracteres, e retorna os dados do arquivo em caracteres;
- `BufferedReader br = new BufferedReader();`: "guarda" caracteres de uma linha em um *buffer*, e retorna o conteúdo do arquivo como uma String;
- `br.readLine();`: retorna uma String com o conteúdo da primeira linha de um arquivo de texto;
- Existem duas principais exceções no pacote java.io: `FileNotFoundException` e `IOException`;
- Ao inicializar um `BufferedReader`, deve-se fechar essa entrada de dados, utilizando `br.close();`. Caso exista um `InputStreamReader` e um `FileInputStream` ligados à esse `BufferedReader`, eles também serão fechados;
