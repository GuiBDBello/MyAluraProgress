# Maven: Build do zero a web

## Aula 01 - Do zero aos relatórios

### Atividade 02 - Sem Maven é fácil?

- O Maven compila, organiza, verifica, testa, executa, gerencia as bibliotecas e dependências, facilita a criação dos artefatos do projeto;
- Automatiza o processo de *build*;

#### Conceitos:

- `src`: diminutivo de *source*, é o diretório onde ficam os arquivos com o código-fonte da aplicação;
- `target`: alvo, é o diretório onde os arquivos compilados são enviados;
- `lib`: diminutivo de `libraries`, é o diretório onde ficam os arquivos de terceiros, chamados de bibliotecas;

#### Como é sem Maven?

- `javac`: comando para compilar arquivos `.java`;
- `javac -sourcepath src -d target src/Calculadora.java`: comando utilizado para compilar o arquivo `Calculadora.java` e enviá-lo ao diretório `target`;
- `javac -sourcepath src/main -d target/classes -cp lib/xstream-1.4.12.jar src/main/Calculadora.java`: comando utilizado para compilar o arquivo `Calculadora.java`, enviá-lo ao diretório `target/classes` enquanto usa a biblioteca `xstream`;

### Atividade 03 - Um gostinho do Maven:

#### Download:

- https://maven.apache.org/download.cgi

#### Terminal:

- O Maven baixado e descompactado é utilizado no *Terminal*, por meio de linha de comando (*cli*);
- Dentro do diretório `bin` do Maven, utilize `./mvn` para executá-lo;
- `./mvn --help`: mostra os comandos disponíveis pelo Maven;
- Para poder executar esse comando de qualquer lugar, adicione o caminho do Maven às variáveis de ambiente do seu sistema operacional;
- `mvn archetype:generate -DartifactId=produtos -DgroupId=br.com.alura.maven -DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-quickstart`: gera um projeto novo com o nome (`artifactId`) `produtos`, com o pacote base (`groupId`) `br.com.alura.maven`, deixando o resto das informações como padrão (`interactiveMode`) e utilizando como **arquétipo** (estrutura do projeto) `maven-archetype-quickstart`;
- A primeira execução do Maven irá demorar pois ele baixa todos os plugins e dependências necessários para executar a aplicação;
- `mvn compile`: compila a aplicação, facilitando o processo feito na aula anterior com o `javac`. **Obs.:** a primeira vez que o Maven compila um projeto ele irá baixar o *plugin* de compilação, o que pode demorar um tempo;
- `mvn test`: executa os testes da aplicação. Cria um diretório com relatórios informando o resultado do teste de cada classe;
- `mvn clean`: limpa o projeto. Remove o diretório `target`, deixando apenas a fonte;

#### pom.xml:

- É o "modelo" do projeto;
- Possui as informações da versão do Maven, grupo, nome, forma de empacotamento, versão da aplicação, site, dependências externas e outras;

### Atividade 04 - Gerando relatórios:

- `compile`, `clean` e `test` são plugins padrões do Maven;
- "Para descobrirmos o nome de todos esses plugins, digitaremos no buscador do Google algo como "maven plugins", e várias informações serão disponibilizadas. Caso seja necessário realizar uma busca mais direcionada, como o plugin de geração de relatório, utilize "maven plugins test report". Encontraremos instruções na documentação do Maven, sobre como utilizar o plugin mais adequado de acordo com a necessidade."

#### Plugin surefire-report:

- `mvn surefire-report:report`: executa o objetivo `report` do plugin `surefire-report`;

#### Packaging:

- `mvn package`: empacota o projeto em um `jar` ou `war`. Apenas cria o arquivo empacotado se compilar e se os testes finalizarem com sucesso;

#### Executar:

- `java -cp produtos-1.0-SNAPSHOT.jar br.com.alura.maven.App`: roda a aplicação utilizando o pacote gerado;

## Aula 02 - Maven no Eclipse

### Atividade 01 - Integrando Maven e Eclipse:

- No Eclipse, vá em `File > Import... > Existing Maven Projects` para importar o projeto das aulas anteriores;

#### Adicionar dependência no pom.xml:

- No Google, ao procurar "maven [nome da biblioteca]", é comum aparecer o site mvnrepository.com que possui muitas dependências do Maven para serem adicionadas em seus projetos;
- No mvnrepository.com, selecione o projeto que você quer adicionar como dependência ao seu projeto, selecione uma versão e copie o bloco de código onde há a dependência;
- **Ex.:**
```
<!-- https://mvnrepository.com/artifact/com.thoughtworks.xstream/xstream -->
<dependency>
    <groupId>com.thoughtworks.xstream</groupId>
    <artifactId>xstream</artifactId>
    <version>1.4.12</version>
</dependency>
```
- O mvnrepository também informa quais as dependências necessárias para compilar, testar e os pacotes que o projeto contém;
- Ao salvar o arquivo `pom.xml`, o Maven já baixa todas as dependências e compila o projeto sozinho;

## Aula 03 - Repositório remoto e local

### Atividade 01 - Repositório remoto e local:

- `mvn -o test`: executa o plugin `test` do Maven de modo *offline* (`-o`), sem verificar por atualizações (se faltar algum `.jar` ocorrerão problemas na aplicação);
- Existe um lugar que mantém, de forma centralizada, os projetos do Maven;
- https://repo.maven.apache.org/maven2
- É nesse repositório remoto que o Maven busca, por padrão, para baixar suas dependências;
- As dependências já utilizadas são armazenados em um repositório local (no diretório de seu usuário, em `.m2/repository/`) após o primeiro *download*;
- É possível adicionar novos repositórios remotos utilizando a tag `<repositories></repositories>` no arquivo `pom.xml`;

#### Documentação do POM:

- https://maven.apache.org/pom.html

## Aula 04 - Relatórios de qualidade e cobertura

### Atividade 01 - As fases do Maven:

- https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html
```
1. Validação: verificamos se projeto possui todas as informações necessárias

2. Compilação: compilar os conteúdos

3. Teste: realizar testes diferentes no projeto

4. Pacote: geração de um pacote do projeto

5. Teste de integração: realizar testes de integração

6. Verificação: checagem do pacote gerado

7. Instalação: realizar a instalação do pacote no repositório local

8. Implantação: realizar a implantação no ambiente adequado
```
- Quando uma fase é executada, ela também roda todas as fases anteriores à ela, em ordem;
- `mvn -DskipTests=true package`: gera o pacote da aplicação sem executar a fase de testes;

### Atividade 03 - Incluindo plugins:

#### Maven PMD Plugin:

- https://maven.apache.org/plugins/maven-pmd-plugin/
- Analisa o código-fonte e detecta possíveis margens de *bugs*;
- `mvn pmd:pmd`: executa o relatório do PMD;
- `mvn verify`: verifica a qualidade do projeto;
- `mvn pmd:check`: falha o build se o código-fonte possui violações do PMD. É executado durante a fase `verify`;
- Veja exemplos de como utilizar o PMD aqui: https://maven.apache.org/plugins/maven-pmd-plugin/usage.html

#### Configurando o build:

- Para rodar **sempre** um *goal* de um *plugin*, é necessário configurar isso no `pom.xml`;
- Dentro da *tag* `<project></project>`, adicione a *tag* `<build></build>` para adicionar uma configuração de *build*;
- **Ex.:**
```
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-pmd-plugin</artifactId>
            <version>3.6</version>
            <executions>
                <execution>
                    <phase>verify</phase>
                    <goals>
                        <goal>check</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
- Dentro de `<build></build>` define o *plugin* (`<plugin></plugin>`) do PMD para ser utilizado durante a *build* e foi definida uma execução (`<execution></execution>`) na fase *verify* (`<phase>verify</phase>`) com o objetivo de checar a qualidade do código (`<goal>check</goal>`);
- Na próxima execução do `mvn verify`, serão executados os `<goals></goals>` definidos na *tag* `<build></build>` dessa fase;

### Atividade 07 - Um pouco das várias opções do Maven:

#### Plugin de cobertura de teste:

- https://www.eclemma.org/jacoco/trunk/doc/maven.html

#### JaCoCo:

- Dentro dos `<plugins></plugins>` da *build*, adicione a execução do JaCoCo:
```
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.5</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
- Note que não é obrigatório definir uma `<phase></phase>`, o próprio *plugin* já define uma fase padrão para cada `<goal></goal>`;
- Os arquivos são gerados em `target/site/jacoco/`;

#### Eclipse:

- Clique com o botão direito no projeto > *Run As* > *Maven build...* > Em *Name*, digite `produtos maven verify` e em *Goals*, digite `verify` > Clique em *Run*;

### Atividade 09 - Atualizando as dependências do projeto:

- Em projetos com muitas dependências, com o passar do tempo elas podem ficar desatualizadas, caso você queira atualizar as dependências para suas versões mais atuais, poderá utilizar o seguinte comando: `mvn versions:use-latest-versions`;
- Existe um outro *goal* que verifica por atualizações sem de fato alterar o `pom.xml`: `mvn versions:display-dependency-updates`;
- Os dois *goals* fazem parte do *plugin* `Versions`, cuja documentação pode ser encontrada aqui: http://www.mojohaus.org/versions-maven-plugin/

## Aula 05 - Criando um projeto web

### Atividade 01 - Começando nossa loja web:

#### Criando projeto web com o Maven no Eclipse:

- Clique com o botão direito no *Package Explorer* > *New* > *Project...* > Maven > *Maven Project* > Defina a localização do *Workspace* > Selecione o *archetype webapp* > Defina *Group Id* e *Artifact Id*;

#### Criando projeto web com o Maven no Terminal:

- `mvn archetype:generate -DartifactId=lojaweb -DgroupId=br.com.alura.maven -DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-webapp`

#### Executando projeto web com o servidor web Jetty:

- Para esse projeto, será utilizado o servidor web *Jetty*;
```
<plugin>
    <groupId>org.eclipse.jetty</groupId>
    <artifactId>jetty-maven-plugin</artifactId>
    <version>9.4.30.v20200611</version>
</plugin>
```
- `jetty:run`: baixa o Jetty (na primeira execução) e roda a aplicação utilizando o servidor Jetty;
