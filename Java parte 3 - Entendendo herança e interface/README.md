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
