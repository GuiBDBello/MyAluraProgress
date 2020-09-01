# Refatorando na prática em Java

## Aula 01 - Código legado, procedural e teste de unidade

### Atividade 01 - Vídeo 1:

- Geralmente, **classes utilitárias fazem parte de algum modelo**;
- Criar classes de testes para as classes que não os possuem;
- A refatoração é feita para manter a compatibilidade, portanto é importante entender o que é a "compatibilidade" que deve ser mantida;
- Criação de teste posterior à criação do código obriga o programador a ir "aprendendo" o código durante a criação do teste;
- A criação dos testes é feita para auxiliar o processo de refatoração do código;

## Aula 02 - Movendo código

### Atividade 01 - Vídeo 1:

- Após criar os testes da classe utilitária, eles devem ser movidos à classe modelo que deve mantê-los;
- Deve-se, então, trocar a utilização da classe utilitária pela classe modelo, criando testes falhos (cujo código será criado posteriormente);
- Então, os métodos que falharam devem ser reimplementados para passarem;
- Por fim, a classe utilitária pode ser removida;
- Rode novamente os testes para ver se sua refatoração foi bem sucedida e o código continua funcionando;
