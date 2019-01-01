# Java parte 3: Entendendo herança e interface

## Aula 01 - Introdução a herança

### Atividade 06 - Começando com a herança:

- Uma Classe pode herdar os atributos e comportamentos de outra classe
- 'extends' 'NomeDaClasse: palavra-chave que é utilizada após o nome da Classe, e serve para definir uma Classe herdada

## Aula 02 - Super e reescrita de métodos

### Atividade 01 - Herança no diagrama de classes:

- Classe Pai/Mãe, Base class, Super class: A classe base, que será herdada pelas classes filhas
- Classe Filha, Sub class: Classe que herda as características e comportamentos da Classe Pai
- Ao construir um Objeto da Classe Filha, ele herda todos os atributos e métodos da hierarquia

### Atividade 02 - Reescrita de métodos:

#### Atalho para adicionar comentário:

- Ctrl + /

- 'protected': Modificador de visibilidade que representa 'public' para os filhos da Classe e 'private' para outras Classes
- 'super': Indica que o atributo é da Classe Pai

#### Reescrita de métodos:

- Também chamada de **sobrescrita**
- Utiliza-se a mesma assinatura (modificador, retorno, nome e parâmetros) do método original
- Redefine apenas o comportamento do método

### Atividade 09 - Para saber mais: Sobrecarga:

- Caso exista um método de assinatura 'public void nomeMetodo(int numero)', se for escrito um novo método de assinatura 'public void nomeMetodo(int numero, String nome)', a criação desse novo método é chamada de **sobrecarga**
- A sobrecarga não leva em conta a visibilidade ou retorno do método, apenas os parâmetros e não depende da herança

## Aula 03 - Entendendo Polimorfismo

### Atividade 01 - Introdução ao Polimorfismo:

- Uma Classe Pai pode receber uma referência de um Objeto que é uma Classe Filha dela
- Em alguns casos de Polimorfismo, não é possível chamar diretamente um método do Objeto instanciado (Classe Filha), pois o tipo do Objeto de referência (Classe Pai) não possui os métodos da Classe Filha

### Atividade 02 - Aplicando Polimorfismo:

- O polimorfismo evita a duplicação de métodos para Classes em hierarquia
- Cria-se apenas um método genérico, com a Classe Pai, para não criar um método específico para cada Classe Filha
- Mesmo usando uma referência genérica (Classe Pai), ao executar o código será chamado um método específico (da Classe Filha)