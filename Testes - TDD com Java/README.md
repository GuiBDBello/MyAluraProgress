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
