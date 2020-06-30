# Webpack: Manipulando módulos na sua webapp

## Aula 01 - Introdução

## Atividade 01 - Webpack, o agrupador de módulos:

- `npm run watch`: executa o projeto *client*;
- `npm start`: executa o projeto *server*;

## Atividade 05 - Preparando o terreno para o Webpack:

- `<script src="dist/bundle.js"></script>`: carrega o bundle gerado pelo Webpack;
- `npm install webpack@3.1.0 babel-core@6.25.0 --save-dev`: instala o webpack e o babel-core nas versões utilizadas no curso;

## Atividade 07 - O temível webpack.config.js:

### `webpack.config.js`:
-
```
module.exports = {
    entry: './app-src/app.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'dist')
    }
}
```
- `entry`: define qual é o "ponto de entrada" da aplicação;
- `output`: define o arquivo gerado (*bundle*) pelo Webpack;

### `package.json`
- Dentro de `"scripts"`, adicione a linha `"build-dev": "webpack --config webpack.config.js"`;
- `npm run build-dev`: executa o script;
