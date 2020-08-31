# Testes: TDD com Java

## Aula 01 - Começando com testes de unidade

### Atividade 01 - Começando com testes de unidade:

- Testes manuais (mais caros):
1. Pensar em um cenário
2. Executar uma ação
3. Validar a saída
- Teste automatizado tem os mesmos 3 pontos, mas ele é muito mais "barato" para ser feito;

#### JUnit:

- Framework de teste de unidade;
- `Build Path > Add Libraries... > JUnit`;
- Para que o JUnit entenda o método de teste, o método deve ser, obrigatoriamente, público (modificador `public`), não pode ser estático, não deve possuir retorno (`void`), não deve possuir parâmetros e deve ser anotado com `@Test`;
- Para realizar a validação, o JUnit possui a class `Assert`, e o método `assertEquals`, que recebe dois parâmetros e valida se são iguais: o valor esperado, e o valor calculado;
- O último parâmetro (opcional) é o `delta`. Como o `double` tem problemas de arredondamento, o JUnit aceita essa diferença entre os valores;
- **Ex.:**
```
public class Teste {
    @Test
    public void test() {
        Assert.assertEquals(0, 0, 0.00001);
    }
}
```
- A classe não é mais executada como uma aplicação Java. Agora ela deve ser executada como um teste JUnit;
- `Clique com o botão direito na classe > Run As > JUnit Test`;

### Atividade 04 - Pasta que guardamos o teste:

- É comum separarmos as classes de teste das classes de produção. Nesse momento, todas nossas classes estão na pasta `src/`.
- Crie uma nova source folder chamada `test`. Para isso, clique com o botão direito no projeto, New -> Other -> Source Folder. Arraste então a classe de teste para essa pasta.
- Também colocamos a classe de teste no mesmo pacote da classe de produção. Ou seja, se a classe `Avaliador` está em `br.com.caelum.leilao.servico`, a classe de teste `AvaliadorTest` estará também em `br.com.caelum.leilao.servico`. Coloque-a nesse pacote.

## Aula 02 - Testando o que realmente é necessário

### Atividade 01 - Testando o que realmente é necessário:

- Quais testes devemos escrever? Quais testes não fazem sentido serem escritos?
- Classes de equivalência: testes que são similares;
- A regra geralmente é: escreva um teste por classe de equivalência;
- **Ex.:** Ordem Crescente, Ordem Decrescente, Ordem Randômica, Apenas um item;

### Atividade 05 - Testando listas:

**Pergunta:** Ao testar uma lista, quantas verificações (quantidade de asserts) geralmente fazemos?
**Resposta:** 1 + N, onde o primeiro é para garantir o tamanho da lista, e depois N asserts para garantir o conteúdo interno completo dessa lista;
- Precisamos sempre garantir todo o conteúdo da lista retornada. Veja que só garantir o tamanho da lista não nos ajuda muito, afinal a lista pode ter o tamanho certo, mas ter o conteúdo inválido.

### Atividade 06 - Casos que precisam de atenção no teste:

- Tratar o caso da lista com um elemento separado do caso da lista com vários elementos faz todo sentido. É muito comum, durante a implementação, pensarmos direto no caso complicado, e esquecermos de casos simples, mas que acontecem. Por esse motivo é importante testarmos esses casos.
- Quando lidamos com listas, por exemplo, é sempre interessante tratarmos o caso da **lista cheia**, da **lista com apenas um elemento**, e da **lista vazia**.
- Se estamos lidando com algoritmos cuja ordem é importante, precisamos testar **ordem crescente**, **decrescente**, e **randômica**.
- Um código que apresente um `if(salario>=2000)`, por exemplo, precisa de três diferentes testes:
1. Um cenário com salário menor do que 2000
2. Um cenário com salário maior do que 2000
3. Um cenário com salário igual a 2000
- Afinal, quem nunca confundiu um > por um >= ?
- O grande desafio da área dos testadores é encontrar todos as **classes de equivalência**; tarefa essa que não é fácil!

### Atividade 08 - Perceber erros sem testes de unidade:

- A bateria de testes automatizados nos ajuda a encontrar problemas na nossa implementação de forma muito rápida: basta clicarmos em um botão, e alguns segundos depois sabemos se nossa implementação realmente funciona ou não.
- Sem uma bateria de testes, dificilmente pegaríamos esse bug em tempo de desenvolvimento. Testes manuais são caros e, por esse motivo, o desenvolvedor comumente testa apenas a funcionalidade atual, deixando de lado os testes de regressão (ou seja, testes para garantir que o resto do sistema ainda continua funcionando mesmo após a implementação da nova funcionalidade).

## Aula 03 - Praticando Test-Driven Development (TDD)

### Atividade 01 - Praticando Test-Driven Development (TDD):

- Classes importantes devem ser testadas!
- TDD (*Test-Driven Development*): escrever primeiro o teste e depois a implementação/código de produção;
1. Escrever um teste (que falha)
2. Faz o teste passar da maneira mais simples
3. Refatora o código
- Isso garante que o código já "nasce testado" e dá segurança na refatoração, pois sempre há uma bateria de testes que garante que o comportamento existente não será quebrado;
- A classe de teste é o primeiro cliente da sua aplicação, o que, por consequência, faz você escrever um código fácil de ser usado e, por consequência, fácil de ser mantido;

### Atividade 10 - O que é TDD?

- TDD é uma prática de desenvolvimento de software na qual o programador escreve um teste antes do código. TDD nos traz segurança e feedback constante sobre a qualidade do nosso código.
- É uma boa prática para todo desenvolvedor de software!

## Aula 04 - Cuidando dos seus testes

### Atividade 01 - Cuidando dos seus testes:

- Código de instanciamento de objetos tende a se repetir nos testes;
- `@Before`: anotação do JUnit que faz um método ser executado antes da classe realizar os testes. É necessário que o método anotado seja `public`;
- `Test Data Builders`: é um padrão de projeto para código de testes. São classes que criam "cenários" para os testes e diminuem o acoplamento;
- Códigos de teste devem ser simples e fáceis de evoluir!

### Atividade 04 - Conhecendo o @After:

- Ao contrário do @Before, métodos anotados com @After são executados após a execução do método de teste.
- Utilizamos métodos @After quando nossos testes consomem recursos que precisam ser finalizados. Exemplos podem ser testes que acessam banco de dados, abrem arquivos, abrem sockets, e etc.
- (Apesar desses testes não serem mais considerados testes de unidade, afinal eles falam com outros sistemas, desenvolvedores utilizam JUnit para escrever testes de integração).

### Atividade 06 - @BeforeClass e @AfterClass:

- Métodos anotados com `@BeforeClass` são executados apenas uma vez, antes de todos os métodos de teste.
- O método anotado com `@AfterClass`, por sua vez, é executado uma vez, após a execução do último método de teste da classe.

## Aula 05 - Testando exceções

### Atividade 01 - Testando exceções:

- Para testar um código com exceção:
1. Utilize `try catch` com `Assert.fail();`. Se a exceção for lançada, o teste funcionou;
```
@Test
public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
    try {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();
        leiloeiro.avalia(leilao);
        Assert.fail();
    } catch(RuntimeException e) {
        // deu certo!
    }
}
```
2. Utilize `@Test(expected=RuntimeException.class)`
- **Ex.:**
```
@Test(expected=RuntimeException.class)
public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
    Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();
    leiloeiro.avalia(leilao);
}
```

#### Testes devem ser legíveis:

- `assertEquals(esperado, calculado)` não parece ter uma ordem "correta". O mais natural seria algo como: `assertThat(calculado, equalTo(esperado))`;

#### Hamcrest

- Para escrever expressões como a acima, podemos fazer uso de um *framework* chamado *Hamcrest*;
- Baixe o *Hamcrest* em http://bit.ly/caelum-hamcrest e adicione-o ao *Build Path* do projeto;
- O *Hamcrest* deve ser importado antes do *JUnit*. Para isso, clique com o botão direito do mouse em seu projeto, vá em `Configure Build Path... > Order and Export`, selecione *Hamcrest* e clique em *Up* até que esteja acima do *JUnit*;
- Agora seu código funciona com a sintaxe `assertThat(calculado, equalTo(esperado))`;
- O *Hamcrest* também possui outros *Matchers* para facilitar diferentes tipos de testes e exceções;
- **Antes:**
```
assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
```
- **Depois:**
```
assertThat(maiores, hasItems(
        new Lance(maria, 400),
        new Lance(joao, 300),
        new Lance(maria, 200)
));
```
- **Obs.:** O *Hamcrest* faz uso do método `equals`, que não existe na classe `Lance`, então é necessário gerá-lo;
- Documentação do *Hamcrest*: https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki

### Atividade 06 - Desafio: Criando um novo matcher:

- Veja um exemplo de matcher customizado aqui: http://jmock.org/custom-matchers.html
- Para criar um matcher, basta criar uma classe que seja filha de `TypeSafeMatcher`;
- Por exemplo, se quisermos que nosso matcher verifique a classe Leilao, precisamos fazer: `public class LeilaoMatcher extends TypeSafeMatcher<Leilao> { }`;
- Precisamos sobrescrever dois métodos: `boolean matchesSafely(Leilao item)` e `void describeTo(Description description)`.
- `matchesSafely`: retorna verdadeiro caso o lance exista ou falso caso não exista.
- `describeTo`: descrição do matcher;
- Por fim, vamos criar o método que instanciará nosso matcher nos testes:
```
public static Matcher<Leilao> temUmLance(Lance lance) {
    return new LeilaoMatcher(lance);
}
```
- Utilizando o matcher nos testes:
- **Antes:**
```
assertEquals(1, leilao.getLances().size());
assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
```
- **Depois:**
```
assertThat(leilao.getLances().size(), equalTo(1));
assertThat(leilao, temUmLance(lance));
```
