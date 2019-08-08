# HTML5 e CSS3 II: Turbinando as suas páginas

## Aula 01 - Pixels?

### Atividade 01 - Medidas relativas:

- Pixel: cada *pixel* é um "pontinho" na tela do seu computador;
- Além dos pixels, existem outras medidas, como o `%`, que é relativa ao elemento pai;
- Ao usar pixels, pode ocorrer um problema: se definir o tamanho da fonte da página em pixels, o usuário pode alterar o tamanho da fonte do navegador, o que pode alterar (ou não) vários elementos da página relativos à esse tamanho;
- O *padding*, ao utilizar `%`, se baseia no valor da largura do elemento. Para se basear no tamanho de fonte, utiliza-se `rem`;
- `1.25rem`: 1.25 x tamanho da fonte do navegador. Se a fonte for `20px`, ela se tornará `25px` (`20 * 1.25 = 25px`);
- `1ch`: largura do caractere `0` da fonte escolhida. É possível mudar o número 1 para o valor desejado;
- `1.25em`: 1.25 x tamanho da fonte do elemento;
- `px`: é absoluto;
- `em`: tem como padrão a fonte do elemento pai;
- `rem`: tem como padrão a fonte do navegador. É possível, também, controlá-lo pelo `font-size` do elemento/tag `html`;
- `ch`: tem como base a largura do caractere zero da fonte usada;
