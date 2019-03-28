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
