# HTML e CSS: ambientes de desenvolvimento, estrutura de arquivos e tags

## Documentação e HTML

### Documentação e estrutura básica do HTML

- https://www.w3schools.com/html/html_intro.asp
- HTML (HyperText Markup Language): O HTML é uma linguagem de marcação, não uma linguagem de programação. O HTML descreve a estrutura de uma página web, rotulando partes do conteúdo como títulos, parágrafos, links, etc.
- Tag: é usada para marcar os elementos da página web, como títulos, parágrafos, imagens, links, etc.

#### Tags

- `<!DOCTYPE html>`: define que este documento é um documento HTML5
- `<html>`: elemento raíz de uma página HTML
- `<head>`: contém meta informações sobre a página HTML, como o título
- `<title>`: especifica um título para a página HTML (que é mostrado na barra de título do navegador ou na guia da página)
- `<body>`: define o corpo do documento e é um contêiner para todo o conteúdo visível, como títulos, parágrafos, imagens, hiperlinks, tabelas, listas, etc.
- `<h1>`: define um grande título
- `<p>`: define um parágrafo

### Criando o corpo da página

- Propriedade: é um atributo que fornece informações adicionais sobre uma tag. As propriedades são escritas dentro da tag e geralmente têm um formato de "nome=valor".

### Quirks Mode e Live Server

- Quirks Mode: modo de renderização que os navegadores utilizam para exibir páginas da web que não seguem os padrões modernos de HTML e CSS. Ele foi criado para garantir que páginas mais antigas, que foram desenvolvidas em tempos em que os navegadores não seguiam um padrão unificado, ainda fossem exibidas corretamente.
- Extensão "Live Server": Adiciona um botão "Go Live" no canto inferior direito do VS Code. Ao clicar no botão, abre uma página no seu navegador que possui "hot reload".

### Para saber mais: estruturando uma página HTML

1. [O que é o HTML e suas tags: estrutura básica](https://www.alura.com.br/artigos/o-que-e-html-suas-tags-parte-1-estrutura-basica)
1. [O que é o HTML e suas tags? Parte 2: elementos inline](https://www.alura.com.br/artigos/o-que-e-html-suas-tags-parte-2-elementos-inline)
1. [O que é o HTML e suas tags? Parte 3: elementos block-level](https://www.alura.com.br/artigos/html-tags-elementos-block-level)
1. [O que é o HTML e suas tags? Parte 4: elementos de um formulário](https://www.alura.com.br/artigos/o-que-e-html-suas-tags-parte-4-elementos-formulario)
1. [O que é o HTML e suas tags? Parte 5: atributos dos elementos](https://www.alura.com.br/artigos/o-que-e-html-suas-tags-parte-5-atributos-elementos)

## Layout e tags semânticas

### Tags semânticas

`!`: Atalho do VS Code para criar a estrutura básica HTML.
`<header>, <main> e <footer>`: Tags para estruturar a página de forma organizada e compreensível.

### Acelere sua produtividade no VSCode com Emmet

- https://docs.emmet.io/
- O Emmet é uma ferramenta que permite escrever códigos HTML e CSS de forma extremamente rápida e produtiva. Ele utiliza abreviações para gerar estruturas complexas de código com apenas alguns comandos, aumentando significativamente a eficiência do desenvolvedor.
- O Emmet utiliza a sintaxe CSS-like para criar código HTML e CSS. Com apenas algumas letras-chave, você pode gerar rapidamente blocos inteiros de código. Por exemplo, ao digitar `ul>li*3`, o Emmet criará automaticamente uma lista não ordenada (ul) com três itens de lista (li).

#### Exemplos

- `html`: Gera a estrutura básica de um documento HTML.
- `ul>li*5`: Cria uma lista não ordenada com cinco itens de lista.
- `div>h1+p`: Cria uma div contendo um cabeçalho (h1) seguido de um parágrafo (p).
- `input[type=text]+input[type=password]`: Cria dois campos de entrada, um para texto e outro para senha.

## Estilizando o projeto com CSS

### Como funciona o CSS

- CSS (Cascading Style Sheets): Responsável por definir como os elementos devem ser exibidos visualmente, incluindo cores, tamanhos, posicionamentos e outros detalhes estéticos.

## Super estilizando o seu CSS

### Cores no CSS

- Adobe Color: https://color.adobe.com/pt/create/color-wheel

### Para saber mais: escolhendo as cores do projeto

- O [Coolors](https://coolors.co/) possui uma interface bem clara. Com a barra de espaço do seu teclado, você consegue criar várias combinações, e uma das funções mais legais é a opção travar, que você pode usar se gostar de apenas uma cor, e assim que você clica nela, consegue continuar elaborando outras combinações levando em conta a cor que você escolheu.
- O [Adobe color](https://color.adobe.com/pt/create/color-wheel) apresenta um Color Wheel (roda de cores) que pode ser ajustado de maneiras variadas para obter uma harmonia de cores, e você pode aplicar diversas regras de harmonia de cores, como o modo análogo, monocromático, tríade, complementar, quadrado, composto, entre outros.
- O [Color Hunt](https://colorhunt.co/) dispõe de diversas paletas elaboradas. Você consegue encontrar a combinação que mais te agrada e consegue buscar por palavras-chave como pastel, vintage, neon e assim por diante. E caso não encontre nenhuma que te agrade, você consegue criar a sua própria paleta clicando nos três pontinhos do canto superior direito da página.
- O [Color Tool](https://m2.material.io/resources/color/#!/?view.left=0&view.right=0&primary.color=6002ee) é ótimo para criar, compartilhar e aplicar paletas de cores à interface do usuário, bem como é possível medir o nível de acessibilidade de qualquer combinação de cores na aba accessibility.
