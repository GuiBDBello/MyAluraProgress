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
