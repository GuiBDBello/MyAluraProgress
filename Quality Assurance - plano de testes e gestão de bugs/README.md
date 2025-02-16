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
