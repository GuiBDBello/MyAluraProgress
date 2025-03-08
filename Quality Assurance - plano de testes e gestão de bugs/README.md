# Quality Assurance: plano de testes e gestão de bugs

## Testes e cenários de testes

### O que é teste?

Teste é uma maneira de colocar à prova e avaliar se uma aplicação funciona corretamente, com o objetivo de reduzir o risco de erros e falhas. Ele é essencial para garantir que o sistema seja resiliente e não apresente problemas que possam causar perda financeira, de reputação ou de tempo. O processo de teste envolve não apenas a execução dos testes em si, mas também o planejamento, a avaliação e a documentação dos resultados, como no caso do plano de teste.

### Faça como eu fiz: Fluxo de teste - Cadastro

Crie um fluxo para a funcionalidade de cadastro de acordo com as seguintes regras:

```
Funcionalidade: Cadastro

Comportamento esperado: Ao digitar e-mail, nome completo, usuário e senha e confirmar a senha, o usuário será cadastrado na plataforma.

Quando o cadastro for efetuado corretamente, o usuário deverá ser redirecionado para a tela de login. Em caso de erro, usuário deve receber uma mensagem informando qual é o erro.

Todos os campos são obrigatórios e o sistema deve indicar caso um campo não tenha sido digitado.

A senha deve ter no mínimo 8 caracteres.
```
- Cenário 1: Login bem sucedido, cadastra usuário e redireciona para tela de login.
- Cenário 2: Erro, campos obrigatórios não preenchidos, mostra mensagem.
- Cenário 3: Erro, e-mail já utilizado, mostra mensagem.
- Cenário 4: Erro, usuário já existe, mostra mensagem.
- Cenário 5: Erro, senha possui menos de 8 caracteres, mostra mensagem.
- Cenário 6: Erro, senhas não são iguais, mostra mensagem.

### Casos de teste

- Cenário de Teste: É uma descrição geral do que você precisa testar. Ele define a situação ou condição que será testada, mas não entra em detalhes sobre como isso será feito. Por exemplo, um cenário de teste pode ser "Login no sistema AluraPic".
- Caso de Teste: É uma versão mais detalhada do cenário de teste. Ele inclui informações específicas sobre como o teste será executado, como os passos a serem seguidos, os dados de entrada, as pré-condições, o resultado esperado, entre outros. Por exemplo, um caso de teste para o cenário "Login no sistema AluraPic" incluiria detalhes como o nome de usuário, a senha, os passos para realizar o login e o que deve acontecer após a execução do teste.

Em resumo, o cenário de teste é a visão geral do que será testado, enquanto o caso de teste é o detalhamento desse cenário, fornecendo um guia claro para a execução do teste. Se precisar de mais exemplos ou exercícios sobre isso, é só avisar!

#### Estrutura de um Caso de Teste:

- Nome: Um identificador exclusivo para o caso de teste.
- Pré-condições: O que é necessário ter antes de iniciar o teste (ex: um usuário e senha).
- Procedimentos: O passo a passo que deve ser seguido durante o teste.
- Resultado Esperado: O que deve acontecer após a execução do teste.
- Dados de Entrada: Informações específicas que serão usadas durante o teste.
- Critérios Especiais: Requisitos adicionais que podem ser necessários.
- Ambiente: O contexto em que o teste será realizado (ex: ambiente de desenvolvimento, homologação).
- Implementação: Se o teste será manual ou automatizado.
- Iteração: O número de vezes que o teste deve ser executado.

#### BDD: Desenvolvimento Guiado por Comportamento

- Do inglês "Behaviour Driven Development", é uma outra forma de descrever o cenário de teste. O BDD deve ser descrito em 3 etapas: "Given", "When", "Then".
- Given (Dado): Quais pré-condições devem ser verdadeiras para que eu execute o teste?
- When (Quando / E): Qual ação será executada no sistema que fornecerá o resultado validado?
- Then (Então): De acordo com a ação disparada qual o resultado esperado?

Exemplo:
- Dado: que eu tenho um Usuário no sistema AluraPic
- Quando: Eu digitar meu user name
- E: senha corretamente
- E: Apertar o botão confirmar
- Então: devo ser redirecionado para a página principal do sistema.

## Qualidade

### O que é qualidade?

#### Atividades da pessoa de QA:

- **Testes**
- **Debug e logs**: Descobrir a origem do problema para reportar os erros e entender o que falhou.
- **Pequenas implementações com pair programming**
- **Gestão de erros**: Saber como reportar melhor os erros do sistema.
- **Papel na metodologia ágil**: Participar de todo o processo, da concepção à entrega.

#### Manifesto de Teste Ágil

- **Testar durante o desenvolvimento**: Testar em partes, conforme as coisas ficarem prontas, para pegar os erros o mais rápido possível.
- **Prevenir bugs**: Interagir com o time para ver se todos entenderam o que será construído.
- **Testar o entendimento, não só funcionalidades**
- **Construir um sistema melhor**
- **Time todo é responsável pela qualidade**

### Critérios de Aceite

- São os valores mínimos aceitáveis para um projeto.
- Eles podem ser funcionais (como campos obrigatórios e redirecionamento em caso de sucesso) ou não funcionais (como acessibilidade e redimensionamento da tela).
- Devem ser mensuráveis, e não subjetivos.

### Definição de Pronto

- O DOD (Definition of Done) é uma lista de critérios que precisam ser atendidos para que uma atividade ou funcionalidade seja considerada concluída. Ele serve para alinhar as expectativas de todos os envolvidos no projeto e garantir que o sistema esteja pronto para ser lançado.
- O DOD deve ser genérico e valer para todas as funcionalidades do sistema, e pode ser revisado e atualizado conforme o sistema for crescendo.

## Aprofundando nos tipos testes

### Teste relacionado à mudança

Após desenvolver uma nova funcionalidade é necessário garantir que todas as funcionalidades continuam funcionando como antes.

- Teste de Regressão: Quando uma nova funcionalidade é adicionada, é necessário testar todas as funcionalidades relacionadas para garantir que nada foi quebrado. Isso envolve analisar quais componentes são afetados pela mudança e testá-los novamente.
- Smoke Test: Teste mais simples e rápido das principais funcionalidades afetadas pela mudança. Não testa todos os cenários, apenas os mais críticos.
- Teste de Sanidade: Também um teste mais enxuto, focado em verificar se as funcionalidades mais importantes do sistema como um todo ainda estão funcionando corretamente. Geralmente inclui apenas os cenários felizes.

### Mais técnicas de teste

- Teste de Limite: Verifica o valor mínimo e valor máximo de um campo (pois geralmente é onde os problemas ocorrem).
- Testes de Estado: Verifica se o sistema está mudando corretamente o estado de um elemento (como o ícone de curtir) quando uma ação é realizada.
- Teste Exploratório: Teste mais informal, sem um "roteiro", sem cenários pré-definidos. Esse tipo de teste ajuda a conhecer melhor o sistema e identificar problemas de usabilidade.

### Testes não-funcionais

Testes não funcionais avaliam a qualidade geral do sistema, como a performance.

- Teste de Performance: verifica como o sistema se comporta quando várias pessoas acessam ao mesmo tempo, por exemplo, no login. A ferramenta Google Lighthouse é uma extensão do Google Chrome que permite fazer testes de performance básicos de forma gratuita.

#### Google Lighthouse

Ao testar o site com o Lighthouse, ele gera um relatório com métricas como o tempo de carregamento do primeiro conteúdo e da página completa, além do tempo de interação com elementos da página.

O relatório também fornece uma nota geral de performance (neste caso 58 de 100) e sugere oportunidades de melhoria, como compressão de texto.

Esse tipo de teste é importante para identificar gargalos de performance e compartilhar com a equipe de desenvolvimento para que possam ser resolvidos, melhorando a experiência do usuário.

### Outros testes não-funcionais

- Teste de Usabilidade: Observar usuários utilizando o sistema sem dar instruções, para avaliar a facilidade de uso.
- Teste de Acessibilidade: Verificar se o sistema pode ser utilizado por pessoas com deficiência, usando ferramentas como o Google Lighthouse.
- Teste de Segurança: Não é feito pelo time de QA. Serve para verificar a proteção de dados e resiliência do sistema a ataques, geralmente feitos por um time especializado.

## Pirâmide de testes

### Testes de Caixa Branca vs testes de Caixa Preta

Teste de caixa branca: realizado com base na arquitetura do sistema, permitindo que o tester compreenda como o código e os módulos funcionam. Esse tipo de teste é feito por QA's mais técnicos.
- Testes unitários
- Testes de integração

Teste de caixa preta: não requer conhecimento sobre o código. Ele se baseia nos requisitos e no plano de teste, permitindo que qualquer pessoa teste a funcionalidade do sistema.
- Testes de aceitação
- Testes de usabilidade

#### Pirâmide de testes

Ilustra a relação entre o custo e a velocidade dos testes. Os testes unitários são mais baratos e rápidos, seguidos pelos testes de serviço, enquanto os testes de interface são mais caros e lentos. A pirâmide sugere que devemos priorizar testes unitários e de serviço para garantir uma estratégia de testes eficiente e eficaz.

### Evidência de teste

- No Windows: utilizar a ferramenta "gravador de passos" para registrar a execução de um teste. Essa ferramenta captura cada ação realizada, como cliques e entradas de texto, e permite adicionar comentários, evidenciando os resultados dos testes.
- Outras formas: tirar prints da tela ou gravar vídeos. A documentação pode variar de acordo com as necessidades do time.

### Para saber mais: Pirâmide de testes

- A Pirâmide de Testes define que a "base" dos nossos testes são os testes de unidade (não confundir com "unitários"), o meio são os testes de integração, e no topo são os testes e2e (end-to-end), e ainda acima ficam os testes manuais.
- Quanto mais na "base" da pirâmide, mais rápidos são os testes. Quanto mais no topo, mais recursos são necessários, e podem quebrar com mais facilidade.
- Teste de Unidade: é um teste que verifica o funcionamento da menor unidade testável do seu sistema (normalmente, isso é um método público de uma classe).
    - Dublês de teste: Mocks, Stubs, Spies.
- Teste de Integração: testes que combinam uma funcionalidade do seu código com algum sistema externo. Exemplos:
    - Testes que utilizam mais de uma classe (sem mocks), ou seja, uma funcionalidade completa
    - Testes que realizam persistência no banco de dados
    - Testes que chamam API externa
    - Testes que realizam envio de email
- Teste de Ponta a Ponta: testar o sistema real, em funcionamento, porém em um ambiente controlado.

#### O que mais estudar?

- Testes de performance: testar o tempo de resposta de uma query, de uma request, etc.
- Testes de mutação: introduzir um bug no código e rodar o teste unitário, se o teste passar, tem algo errado com o teste.
- BDD (Behaviour Driven Development): escrever os testes utilizando uma sintaxe que uma pessoa não-técnica deve conseguir entendê-lo.

### Bugs, falhas defeitos

- Defeito: erro no código
- Falha: manifestação do erro
- Ambos são englobados pelo termo "bug", que representa qualquer comportamento inesperado ou indesejado no sistema.
- É muito importante prevenir bugs desde a concepção do projeto, pois quanto mais cedo um bug é encontrado, menor é o custo e o retrabalho para corrigi-lo.
- Também é muito importânte reportar os bugs de forma clara e eficiente para o time de desenvolvimento.

### Reportando bugs

É importantíssimo reportar bugs de forma clara e precisa. Ao encontrar um bug, devemos:

- Fornecer um título conciso que resuma o problema.
- Fornecer um passo a passo detalhado para reproduzi-lo, incluindo informações como usuário, senha e a sequência exata de ações que levam ao erro.
- É crucial indicar o resultado esperado, a versão do sistema, a plataforma (como Windows, Mac ou Linux) e o navegador utilizado.
- A criticidade do bug (quão impactante ele é) e o status (novo, em correção, corrigido) também são informações valiosas.

#### Boas práticas

- Reportar o bug o mais rápido possível.
- Reproduzí-lo pelo menos três vezes para confirmar sua ocorrência.
- Testá-lo em diferentes plataformas.
- Evitar linguagem abusiva ao descrever o problema.
