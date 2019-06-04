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
