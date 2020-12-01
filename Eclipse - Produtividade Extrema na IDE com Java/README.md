# Eclipse: Produtividade Extrema na IDE com Java

## Aula 01 - Menos erros, mais produtividade

### Atividade 01 - Menos erros, mais produtividade:

- `Ctrl + M`: maximiza a janela com foco.
- Digite `main` e pressione `Ctrl + Space` e `Enter`: gera o método `public static void main(String[] args)`.
- Digite `new Obj` e pressione `Ctrl + Space`: gera o construtor da classe que inicia com o nome `Obj`. É possível navegar entre os atributos do construtor com a tecla `Tab` e a tecla `Esc` sai da navegação.
- Se uma variável não existe, pressione `Ctrl + 1` e selecione `Create local variable`. Isso também importa as classes necessárias automaticamente.
- Se um valor não foi atribuído à uma variável, vá até sua linha, pressione `Ctrl + 1` e selecione `Assign statement to new local variable`.
- Digite `syso` e pressione `Ctrl + Space` para abreviar a criação do método `System.out.println()`.
- `Ctrl + F11`: executa o método `main`.
- `F3`: abre a classe em que o cursor está sobreposto.
- `Ctrl + Page Down` e `Ctrl + Page Up`: troca de aba.

### Atividade 03 - (Obrigatório)Instalação do Eclipse e do projeto:

- Importar um projeto: `Ctrl + 3` e comece a digitar `existing projects into workspace` até que a opção de Import apareça, então pressione `Enter`.

### Atividade 06 - Instanciando a data de nascimento:

- `Ctrl + .`: move o cursor para o erro mais próximo.

### Atividade 07 - Impressão do funcionário:

- Digite `syserr` e pressione `Ctrl + Space` para abreviar a criação do método `System.err.println()`.
- Digite `systrace` e pressione `Ctrl + Space` para abreviar a criação do método `System.out.println("Classe.metodoAtual()")`.
- `Alt + Shift + X`: executar a classe.
- `Alt + Shift + X` + `J`: executar a classe como *Java application*.

### Atividade 08 - Navegando nas abas do editor:

- `Ctrl + F6`: seleciona uma das classes abertas no editor e vai até ela.

## Aula 02 - Gerando conteúdo eficientemente

### Atividade 01 - Gerando conteúdo eficientemente:

- `Ctrl + N`, digite `class` e pressione `Enter`: abre o wizard para criar uma nova classe.
- `Shift + Tab`: navega ao campo anterior.
- `Alt + Shift + A`: ativa o modo de seleção em bloco. Com esse modo, é possível editar várias linhas ao mesmo tempo. Para isso, segure a tecla `Shift` e mova o cursor com as setas.
- `Ctrl + 3`: como se fosse uma "busca" no Eclipse. Permite chamar qualquer menu por uma parte de seu nome ou por suas iniciais. **Ex.:** Digite "`Ctrl + 3` e `ggas`" para aparecer a opção *Generate Getters and Setters*.
- `Ctrl + Alt + Seta para baixo`: copia a linha atual para a linha abaixo. Se utilizar a tecla `Seta para cima`, copia a linha atual para a linha acima.

### Atividade 05 - Gerando getters e setters:

Existem várias maneiras de fazer o que desejamos no Eclipse, para escolhermos aquela que nos torna mais produtivos.

No caso dos getters e setters, além do menu podemos, por exemplo:

- Com o cursor em cima do nome do atributo, Ctrl+1 e "Create getter e setter for 'nomeDoAtributo'"
- Com o cursor em cima do nome do atributo, Alt+Shift+T e selecione Encapsulate Field, ou Ctrl + 3 encapsulate (ou ef). Nesse caso além dos getters e setters criados, os usos atuais do atributo podem ser mudados pra usar os getters/setters
- Dentro da classe, numa linha em branco fora de método, digite get ou set e escolha o getter/setter desejado

## Aula 03 - Melhorando a organização

### Atividade 01 - Melhorando a organização:

- `Ctrl + Shift + F`: identa e formata seu código.
- `Alt + Shift + R`: refatorar a palavra/classe/variável em que o cursor se encontra.
- `Alt + Seta para cima` e `Alt + Seta para baixo`: move o conteúdo da linha em que o cursor se encontra.
- `Alt + Shift + M`: extrai o código selecionado para um método.

### Atividade 09 - Refatorando no eclipse:

- `Alt + T`: abre o menu de refatoração.

Dentre as várias refatorações possíveis, podemos destacar:

- *Rename* (`alt + shift + R` ou `ctrl + 2 R`) - para melhorar o nome de algum elemento
- *Extract Method* (`alt + shift + M`) - para extrair um método de um código já existente
- *Extract Variable* (`alt + shift + L`) - para extrair uma variável a partir de alguma expressão
- *Move* (`alt + shift + V`) - para mover algum elemento para um lugar onde ele faça mais sentido
- *Change Method Signature* (`alt + shift + C`) - para mudar a assinatura de um método, adicionando, removendo ou reordenando parâmetros, trocando o tipo de retorno, mudando o nome, etc.
- *Inline* (`alt + shift + I`) - É o contrário do Extract Method/Variable. Para substituir uma chamada de método pelo seu corpo
