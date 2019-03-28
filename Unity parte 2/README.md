# Unity parte 2: Iluminação, interface e boas práticas

## Aula 01 - Interface na Unity

### Atividade 03 - Vida do Jogador:

#### Script:

- `void TomarDano() { Vida -= 30; }`: método que tira 'Vida' do 'Jogador';
- `Jogador.GetComponent<ControlaJogador>().TomarDano();`: acessa o Script "ControlaJogador" e executa o método 'TomarDano';
