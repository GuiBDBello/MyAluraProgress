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

## Um gostinho do Maven:

### Download:

- https://maven.apache.org/download.cgi

### Terminal:

- O Maven baixado e descompactado é utilizado no *Terminal*, por meio de linha de comando (*cli*);
- Dentro do diretório `bin` do Maven, utilize `./mvn` para executá-lo;
- `./mvn --help`: mostra os comandos disponíveis pelo Maven;
- Para poder executar esse comando de qualquer lugar, adicione o caminho do Maven às variáveis de ambiente do seu sistema operacional;
- `mvn archetype:generate -DartifactId=produtos -DgroupId=br.com.alura.maven -DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-quickstart`: gera um projeto novo com o nome (`artifactId`) `produtos`, com o pacote base (`groupId`) `br.com.alura.maven`, deixando o resto das informações como padrão (`interactiveMode`) e utilizando como **arquétipo** (estrutura do projeto) `maven-archetype-quickstart`;
- A primeira execução do Maven irá demorar pois ele baixa todos os plugins e dependências necessários para executar a aplicação;
- `mvn compile`: compila a aplicação, facilitando o processo feito na aula anterior com o `javac`. **Obs.:** a primeira vez que o Maven compila um projeto ele irá baixar o *plugin* de compilação, o que pode demorar um tempo;
- `mvn test`: executa os testes da aplicação. Cria um diretório com relatórios informando o resultado do teste de cada classe;
- `mvn clean`: limpa o projeto. Remove o diretório `target`, deixando apenas a fonte;

### pom.xml:

- É o "modelo" do projeto;
- Possui as informações da versão do Maven, grupo, nome, forma de empacotamento, versão da aplicação, site, dependências externas e outras;

## Gerando relatórios:

- `compile`, `clean` e `test` são plugins padrões do Maven;

### Plugin surefire-report:

- `mvn surefire-report:report`: executa o objetivo `report` do plugin `surefire-report`;

### Packaging:

- `mvn package`: empacota o projeto em um `jar` ou `war`. Apenas cria o arquivo empacotado se compilar e se os testes finalizarem com sucesso;

### Executar:

- `java -cp produtos-1.0-SNAPSHOT.jar br.com.alura.maven.App`: roda a aplicação utilizando o pacote gerado;
