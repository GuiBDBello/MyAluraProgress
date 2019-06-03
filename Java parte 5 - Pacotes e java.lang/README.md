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
