# Unity parte 4 - Chefão, partículas e menu

## Aula 01 - Vida do Chefe

### Atividade 03 - Barra de Vida:

- É possível posicionar elementos da interface como se estivessem no cenário do jogo;
- 'Screen Space - Overlay': modo de renderização de um Canvas que renderiza os elementos da interface na "tela" do jogo;
- 'World Space': modo de renderização de um Canvas que renderiza os elementos da interface no espaço do "mundo" do jogo;

### Atividade 06 - Vida como Billboard:

- Billboard: sprite que sempre "olha" para a câmera;

#### Script (Billboard):

- `transform.LookAt(transform.position - Camera.main.transform.forward);`: define a rotação do Objeto como o oposto da direção que a câmera aponta, baseando-se em sua posição;
