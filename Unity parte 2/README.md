# Unity parte 2: Iluminação, interface e boas práticas

## Aula 01 - Interface na Unity

### Atividade 03 - Vida do Jogador:

#### Script:

- `void TomarDano() { Vida -= 30; }`: método que tira 'Vida' do 'Jogador';
- `Jogador.GetComponent<ControlaJogador>().TomarDano();`: acessa o Script "ControlaJogador" e executa o método 'TomarDano';

### Atividade 06 - Game Over pela Vida:

#### Script:

- `if (Vida <= 0) { /* Game Over */ }`: gera o "Game Over" quando o 'Jogador' estiver com a 'Vida' menor ou igual a zero;
- `void TomarDano(int dano) { Vida -= dano }`: diminui a 'Vida' do 'Jogador' baseado no 'dano';
- `int dano = Random.Range(20, 30);`: define um 'dano' variável que o 'Jogador' receberá;

### Atividade 09 - Slider de vida:

- Slider: barra de "rolagem" que contém um valor numérico. Pode ser utilizado para Menus, Barras de Vida e outros propósitos;
- Ao criar interfaces (UI), é recomendado utilizar o "Modo 2D" do editor. Para ativá-lo, clique no botão "2D", abaixo do título da aba "Scene";
- Remover o Objeto filho "Handle Slide Area";
- Value: propriedade que contém o valor da Slider;
- Para preencher a Slider completamente, selecione "Fill Area"  e, no "Inspector", zere os valores "Left" e "Right" do componente "Rect Transform";
- No Objeto filho de "Fill Area", "Fill", realizar o mesmo processo;
- Interactable: define se a Slider é interativa pelo input do usuário;
- Âncora: posição "fixa", relativa à tela, que um Objeto tem como referência para "acompanhar";

### Atividade 12 - Fazer a Slider Funcionar:

- Criar novo Script "ControlaInterface" e adicioná-lo ao "Canvas";
- "Min Value": o valor numérico mínimo do Slider;
- "Max Value": o valor numérico máximo do Slider;
- "Whole Numbers": define que a "Slider" conterá apenas números inteiros;

#### Script (ControlaInterface):

- `private ControlaJogador scriptControlaJogador;`: cria uma variável do tipo "ControlaJogador", que é o nome de um Script;
- `scriptControlaJogador = GameObject.FindWithTag("Jogador").GetComponent<ControlaJogador>();`: acessa os "Game Objects", busca o Jogador pela 'Tag' e retorna a referência do Script "ControlaJogador";
- `using UnityEngine.UI;`: importa a biblioteca que processa a Interface (UI) da Unity;
- `public Slider SliderVidaJogador;`: cria uma variável do tipo "Slider", que será a Vida do Jogador;
- `SliderVidaJogador.value = scriptControlaJogador.Vida;`: atualiza a "Slider de Vida" do Jogador. Deve ser inserido no método `AtualizarSliderVidaJogador()`;
- `SliderVidaJogador.maxValue = scriptControlaJogador.Vida;`: define a "Vida" inicial do Jogador. Deve ser inserido no método `Start()`;
- `public void AtualizarSliderVidaJogador() { }`: método que atualiza a "Vida" do Jogador. Deve ser chamado no método `TomarDano(dano)`;

#### Script (ControlaJogador):

- `public ControlaInterface scriptControlaInterface;`: cria uma variável do tipo "ControlaInterface", que referencia o Script "ControlaInterface";
- `scriptControlaInterface.AtualizarSliderVidaJogador()`: executa o método "AtualizarSliderVidaJogador". Deve ser chamado no método `TomarDano(dano)`;
