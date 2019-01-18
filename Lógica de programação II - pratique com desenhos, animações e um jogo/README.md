# Lógica de programação II: pratique com desenhos, animações e um jogo

## Aula 01 - Desenhando gráficos com Canvas

### Atividade 02 - O canvas será nossa tela!:

- Nesse curso não será necessário utilizar a tag '&lt;meta charset="UTF-8"&gt;', nem o 'document.write()', pois nada será escrito na página
- '&lt;canvas&gt;': significa "quadro", é uma área para desenhar, escrever com um pincel
- A tag &lt;canvas&gt; possui várias propriedades, como "largura", "altura", "cor", que serão vistos no decorrer do curso

### Atividade 03 - Desenhando com um pincel:

- Será utilizado, como no curso anterior, o método 'querySelector()' para buscar um elemento do HTML
- 'canvas.getContext('2d')': função do quadro (canvas) que define que o contexto da tela tem 2 dimensões (2d), e retorna um pincel (brush)
- 'brush.fillRect(x, y, largura, altura)': função do brush (pincel) que define uma área retangular a ser preenchida
- 'brush.fillStyle': propriedade do pincel que recebe uma cor. Deve ser definido antes do 'fillRect()'

### Atividade 05 - A vida não é só feita de retângulos!:

- 'brush.beginPath()': função do pincel que começa a "escrita" de um caminho
- 'brush.moveTo(x, y)': função do pincel que define a posição do pincel numa coordenada (vértice)
- 'brush.lineTo(x, y)': função do pincel que traça uma linha do vértice atual ao parâmetro
- 'brush.fill()': função do pincel que preenche o conteúdo entre os vértices

### Atividade 06 - Tem espaço para círculo também?:

- 'brush.arc(x, y, raio, anguloInicial, anguloFinal)': função do pincel que define uma área circular a ser preenchida
- Documentação da API Canvas 2D: https://developer.mozilla.org/pt-BR/docs/Web/API/CanvasRenderingContext2D


## Aula 02 - Extraindo funções

### Atividade 01 - Repetir código não rola, não é mesmo?:

- 'brush.strokeStyle': propriedade do pincel que define a cor da borda
- 'brush.strokeRect(x, y, largura, altura)': função do pincel que desenha uma borda


### Atividade 06 - Frações:

- 'brush.font = "tamanhopx fonte"': propriedade do pincel que define o tamanho da fonte e o tipo da fonte
- 'brush.fillText("texto", x, y)': função do pincel que define um texto e as coordenadas do local onde ele deve renderizar
