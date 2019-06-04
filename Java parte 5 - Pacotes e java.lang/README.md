# Java parte 5: Pacotes e java.lang

## Aula 01 - Organizando as classes com Pacotes

### Atividade 02 - Criação de pacotes:

- Os pacotes, em Java, servem para melhorar a organização do mesmo, dividindo as Classes com propósitos semelhantes em diretórios;
- Um pacote deve ser declarado na primeira linha compilável do código-fonte da Classe;
- **Ex.:** `package modelo;`;
- Quando uma Classe é adicionada a um pacote, o pacote faz parte do nome da Classe. Por exemplo, a Classe se chamará `modelo.ContaCorrente`. Esse nome completo é chamado de *Full Qualified Name (FQN)*;

### Atividade 05 - Importando pacotes:

- `br.com.empresa.projeto.diretorio`: o padrão Java para nomear pacotes segue esse exemplo, em ordem: código do país > subdomínio > nome da empresa > nome do projeto > diretório específico;
- Para facilitar a legibilidade e utilizar o nome simples da Classe no código-fonte, é possível **importar** pacotes, logo abaixo da declaração do `package`;
- **Ex.:** `import br.com.empresa.projeto.diretorio.*;`;

### Atividade 08 - Gerenciando pacotes com Eclipse:

#### Eclipse:

- `Ctrl + Shift + O`: organiza as importações (importa as Classes necessárias);
- `Ctrl + 1`: abre o pop-up de Sugestões (*Quick-fix*);


## Aula 02 - Todos os modificadores de acesso

### Atividade 01 - Revisitando modificadores de acesso:

- `public`: visível em todos os espaços;
- `protected`: visível dentro do pacote e público para os filhos;
- package private: visível apenas dentro do pacote. **Obs.:** Não existe uma palavra-chave para esse modificador de visibilidade. Ele é utilizado em Classes que não declaram explicitamente seu modificador de acesso;
- `private`: visível apenas dentro da classe;


## Aula 03 - Distribuição do seu código

### Atividade 01 - Conhecendo o Javadoc:

- `/** ... conteúdo ... */`: bloco de documentação Java (Javadoc);
- É possível utilizar *annotations* para representar itens específicos em um Javadoc;
- **Ex.:** `/** @author GuiDB @version 0.1 */`;
- Os blocos normalmente são criados em membros públicos, que serão disponibilizados a outros desenvolvedores;
- O Eclipse possui uma *view* que mostra o Javadoc do código onde o cursor se encontra;
- O Javadoc não é feito para o usuário final. É feita de **desenvolvedor para desenvolvedor**;

#### Gerar um Javadoc:

- Project > Generate Javadoc...;
- Em *Javadoc command*, defina o caminho da ferramenta "javadoc.exe";
- Clique em *Finish*;

### Atividade 04 - Para saber mais: Todas as tags:

- `@author`: (usado na classe ou interface) autor da Classe;
- `@version`: (usado na classe ou interface) versão da API que será mostrada ao utilizar o parâmetro `-version`;
- `@param`: (usado no método e construtor) nome e descrição do parâmetro;
- `@return`: (usado apenas no método) descrição do retorno do método;
- `@exception` ou `@throws`: (no método ou construtor) nome da Classe e descrição da exceção;
- `@see`: link com mais informações;
- `@since`: data de lançamento;
- `@serial`: campo serializável padrão;
- `@deprecated`: comentário indicando que essa API não deve mais ser utilizada;

### Atividade 05 - Criando uma biblioteca com JAR:

- JAR: Java Archive. Extensão de um pacote de Classes Java (.jar);

#### Gerar um JAR:

- Em Package Explorer, clique com o botão direito do mouse em um projeto e selecione Export... > Java > JAR file;
- Selecione ou remova os arquivos que você deseja;
- Escolha o caminho de saída e o nome do JAR;

#### Importar um JAR:

- É uma prática comum no mundo Java que seu projeto possua uma pasta chamada 'libs' para manter as bibliotecas externas;
- Copie o JAR gerado para essa pasta;
- Adicione o JAR ao *Build Path* de seu projeto clicando nele com o botão direito do mouse e selecionando Build Path > Add to Build Path;
- Importe os pacotes em seu projeto, e pronto! Pode utilizá-los!
