# Maven: Build do zero a web

## Sem Maven é fácil?

- O Maven compila, organiza, verifica, testa, executa, gerencia as bibliotecas e dependências, facilita a criação dos artefatos do projeto;
- Automatiza o processo de *build*;

### Conceitos:

- `src`: diminutivo de *source*, é o diretório onde ficam os arquivos com o código-fonte da aplicação;
- `target`: alvo, é o diretório onde os arquivos compilados são enviados;
- `lib`: diminutivo de `libraries`, é o diretório onde ficam os arquivos de terceiros, chamados de bibliotecas;

### Como é sem Maven?

- `javac`: comando para compilar arquivos `.java`;
- `javac -sourcepath src -d target src/Calculadora.java`: comando utilizado para compilar o arquivo `Calculadora.java` e enviá-lo ao diretório `target`;
- `javac -sourcepath src/main -d target/classes -cp lib/xstream-1.4.12.jar src/main/Calculadora.java`: comando utilizado para compilar o arquivo `Calculadora.java`, enviá-lo ao diretório `target/classes` enquanto usa a biblioteca `xstream`;
