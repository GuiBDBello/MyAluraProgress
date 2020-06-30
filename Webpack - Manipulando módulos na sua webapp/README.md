# Webpack: Manipulando módulos na sua webapp

## Aula 01 - Introdução

### Atividade 01 - Webpack, o agrupador de módulos:

- `npm run watch`: executa o projeto *client*;
- `npm start`: executa o projeto *server*;

### Atividade 05 - Preparando o terreno para o Webpack:

- `<script src="dist/bundle.js"></script>`: carrega o bundle gerado pelo Webpack;
- `npm install webpack@3.1.0 babel-core@6.25.0 --save-dev`: instala o webpack e o babel-core nas versões utilizadas no curso;

### Atividade 07 - O temível webpack.config.js:

#### `webpack.config.js`:

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

#### `package.json`:

- Dentro de `"scripts"`, adicione a linha `"build-dev": "webpack --config webpack.config.js"`;
- `npm run build-dev`: executa o script;

### Atividade 11 - Babel-loader, a ponte entre o Webpack e o Babel:

- `npm install babel-loader@7.1.0 --save-dev`: instala o *loader* do babel utilizado pelo Webpack;
- `module`: propriedade adicionada no `webpack.config.js` para adicionar módulos para serem carregados pelo Webpack;
- **Ex.:** 
```
module: {
    rules: [
        {
            test: /\.js$/,
            exclude: /node_modules/,
            use: {
                loader: 'babel-loader'
            }
        }
    ]
}
```
- Cada regra é representada por um objeto Javascript;

## Aula 02 - Preparando o build de produção

### Atividade 01 - Preparando o build de produção:

#### `package.json`:
- Dentro de `"scripts"`, adicione a linha `"build-prod": "NODE_ENV=production webpack --config webpack.config.js"`: 
- `npm install babili-webpack-plugin@0.1.1 --save-dev`: adiciona a dependência `babili` para minificar o bundle criado pelo Webpack;
- Dentro do `webpack.config.js`, importe o `babili` com `const babiliPlugin = require('babili-webpack-plugin');`;
- Logo após, verifique se 
-
```
let plugins = [];
if (process.env.NODE_ENV == 'production') {
    plugins.push(new babiliPlugin());
}
```
- Então adicione, dentro do `module.exports`, seus plugins;