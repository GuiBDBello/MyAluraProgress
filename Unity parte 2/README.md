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
