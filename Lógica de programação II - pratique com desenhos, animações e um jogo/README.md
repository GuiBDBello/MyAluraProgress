# Lógica de programação II: pratique com desenhos, animações e um jogo

## Aula 01 - Desenhando gráficos com Canvas

### Atividade 02 - O cancas será nossa tela!:

- Nesse curso não será necessário utilizar a tag '&lt;meta charset="UTF-8"&gt;', nem o 'document.write()', pois nada será escrito na página
- '&lt;canvas&gt;': significa "quadro", é uma área para desenhar, escrever com um pincel
- A tag &lt;canvas&gt; possui várias propriedades, como "largura", "altura", "cor", que serão vistos no decorrer do curso

### Atividade 03 - Desenhando com um pincel:

- Será utilizado, como no curso anterior, o método 'querySelector()' para buscar um elemento do HTML
- 'canvas.getContext('2d')': função do quadro (canvas) que define que o contexto da tela tem 2 dimensões (2d), e retorna um pincel (brush)
- 'brush.fillRect(xInicial, yInicial, xFinal, yFinal)': função do brush (pincel) que define uma área retangular a ser preenchida
- 'brush.fillStyle': propriedade do pincel que recebe uma cor. Deve ser definido antes do 'fillRect()'

### Atividade 05 - A vida não é só feita de retângulos!:

- 'brush.beginPath()': função do pincel que começa a "escrita" de um caminho
- 'brush.moveTo(x, y)': função do pincel que define a posição do pincel numa coordenada (vértice)
- 'brush.lineTo(x, y)': função do pincel que traça uma linha do vértice atual ao parâmetro
- 'brush.fill()': função do pincel que preenche o conteúdo entre os vértices
