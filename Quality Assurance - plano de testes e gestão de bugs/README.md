# Quality Assurance: plano de testes e gestão de bugs

## O que é teste?

Teste é uma maneira de colocar à prova e avaliar se uma aplicação funciona corretamente, com o objetivo de reduzir o risco de erros e falhas. Ele é essencial para garantir que o sistema seja resiliente e não apresente problemas que possam causar perda financeira, de reputação ou de tempo. O processo de teste envolve não apenas a execução dos testes em si, mas também o planejamento, a avaliação e a documentação dos resultados, como no caso do plano de teste.

## Faça como eu fiz: Fluxo de teste - Cadastro

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
