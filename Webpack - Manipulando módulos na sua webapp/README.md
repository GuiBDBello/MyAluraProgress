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

- Dentro de `"scripts"`, adicione a linha `"build-prod": "NODE_ENV=production webpack --config webpack.config.js"`;
- `npm install babili-webpack-plugin@0.1.1 --save-dev`: adiciona a dependência `babili` para minificar o bundle criado pelo Webpack;

#### `webpack.config.js`:

- Importe o `babili` com `const babiliPlugin = require('babili-webpack-plugin');`;
- Logo após, verifique se a variável de ambiente está definida;
-
```
let plugins = [];
if (process.env.NODE_ENV == 'production') {
    plugins.push(new babiliPlugin());
}
```
- Então adicione, dentro do `module.exports`, a variável `plugins`;

### Atividade 03 - Mudando o ambiente com cross-env:

- `npm install cross-env@5.0.1 --save-dev`: adiciona a dependência `cross-env` para definir variáveis de ambiente *cross-platform*;

## Aula 03 - Webpack Dev Server e configuração

### Atividade 01 - Instalação e configuração:

- `npm install webpack-dev-server@2.5.1 --save-dev`: adiciona a dependência `webpack-dev-server` para utilizar um servidor que integre com o Webpack;

#### `package.json`:

- Dentro de `"scripts"`, adicione a linha `"start": "webpack-dev-server"`;

#### `webpack.config.js`:

- Adicione, dentro do `output`, a linha `publicPath: 'dist'` para criar o `bundle.js` dentro do diretório `dist`;

#### webpack-dev-server:

- `webpack-dev-server` é um servidor que, por padrão, roda a aplicação na porta 8080;
- `npm start`: inicia a aplicação com o `webpack-dev-server`;

## Aula 04 - Tratando arquivos CSS como módulos

### Atividade 01 - Utilizando o npm para gerenciar dependências front-end:

- `npm install bootstrap@3.3.7 --save`: adiciona a dependência `bootstrap` para que o Webpack o gerencie também;

### Atividade 03 - Importando Bootstrap como um módulo:

- `import 'bootstrap/dist/css/bootstrap.css';`: importa, como se fosse um módulo, o *stylesheet* do bootstrap;
- `import 'bootstrap/dist/css/bootstrap-theme.css';`: importa, como se fosse um módulo, o *stylesheet* do bootstrap-theme;
- `npm install css-loader@0.28.4 style-loader@0.18.2 --save-dev`: adiciona as dependências `css-loader` e `style-loader` para carregar módulos *CSS* em formato *JSON*;
- `npm install url-loader@0.5.9 file-loader@0.11.2 --save-dev`: adiciona as dependências `url-loader` e `file-loader` para carregar ícones e arquivos;

#### `webpack.config.js`:

- Adicione uma nova regra, dentro de `rules`:
-
```
{
    test: /\.css$/,
    loader: 'style-loader!css-loader' // aplica os loaders da direita para a esquerda
}
```
- Copiar, também, as regras das fontes:
-
```
{
    test: /\.(woff|woff2)(\?v=\d+\.\d+\.\d+)?$/,
    loader: 'url-loader?limit=10000&mimetype=application/font-woff'
},
{
    test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
    loader: 'url-loader?limit=10000&mimetype=application/octet-stream'
},
{
    test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
    loader: 'file-loader'
},
{
    test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
    loader: 'url-loader?limit=10000&mimetype=image/svg+xml'
}
```

### Atividade 05 - Importando um CSS qualquer:

- `import '../css/meucss.css';`: importa um CSS de um diretório local;

### Atividade 07 - Resolvendo o FOUC (Flash of Unstyled Content):

- `<link rel="stylesheet" href="dist/styles.css" />`: carrega o estilo da página de um arquivo, que será gerado pelo Webpack;
- `npm install extract-text-webpack-plugin@3.0.0 --save-dev`: adiciona a dependência `extract-text-webpack-plugin` para exportar o arquivo com os estilos da aplicação;

#### `webpack.config.js`:

- Importe o `extract-text-webpack-plugin` com `const extractTextPlugin = require('extract-text-webpack-plugin');`;
- `plugins.push(new extractTextPlugin('styles.css'));`: adiciona o `extractTextPlugin` na lista de plugins;
- Logo após, altere a linha `loader: 'style-loader!css-loader'` por:
```
use: extractTextPlugin.extract({
    fallback: 'style-loader',
    use: 'css-loader'
})
```

### Atividade 09 - Resolvemos um problema e criamos outro, mas tem solução!:

- `npm install optimize-css-assets-webpack-plugin@2.0.0 cssnano@3.10.0 --save-dev`: adiciona as dependências `optimize-css-assets-webpack-plugin` e `cssnano` para minificar os estilos da aplicação;

#### `webpack.config.js`:

- Importe o `optimize-css-assets-webpack-plugin` com `const optimizeCSSAssetsPlugin = require('optimize-css-assets-webpack-plugin');`;
- Dentro do *if* que verifica o ambiente de produção, adicione o seguinte código:
```
plugins.push(new optimizeCSSAssetsPlugin({
    cssProcessor: require('cssnano'),
    cssProcessorOptions: {
        discardComments: {
            removeAll: true
        }
    },
    canPrint: true
}));
```

## Aula 05 - Importando scripts

### Atividade 01 - Importando scripts:

- `import 'bootstrap/js/modal.js';`: importa, como se fosse um módulo, um *script* do bootstrap;
- `npm install jquery@3.2.1 --save`: adiciona a dependência do `jquery` para carregar os scripts do bootstrap;
- `import 'jquery/dist/jquery.js';`: importa, como se fosse um módulo, o *script* do jquery;

### Atividade 03 - Lidando com dependências globais:

- Utiliza o Webpack para configurar o plugin do jquery nas variáveis `$` e `jQuery`;
```
plugins.push(new webpack.ProvidePlugin({
    '$': 'jquery/dist/jquery.js',
    'jQuery': 'jquery/dist/jquery.js'
}));
```

## Aula 06 - Boas práticas

### Atividade 01 - Otimizando o build com Scope Hoisting:

#### `webpack.config.js`:

- Cada módulo do nosso bundle é envolvido por um wrapper, que resumidamente se trata de uma função. Contudo, a existência desses wrappers tornam a execução do script um pouco mais lenta no navegador. Entretanto, a partir do Webpack 3, podemos ativar o Scope Hoisting. Ele consiste em concatenar o escopo de todos os módulos em um único wrapper, permitindo assim que nosso código seja executado mais rapidamente no navegador.
- `plugins.push(new webpack.optimize.ModuleConcatenationPlugin());`: diminui a quantidade de "*closures*" durante o processo de criação de módulo para processá-los mais rapidamente. Deve ser feito apenas em produção;

### Atividade 03 - Separando o nosso código das bibliotecas:

#### `webpack.config.js`:

- Separa as bibliotecas de terceiros em um *bundle* separado:
```
plugins.push(new webpack.optimize.CommonsChunkPlugin({
    name: 'vendor',
    filename: 'vendor.bundle.js'
}));
```
- Dentro de `module.exports`, altere `entry: './app-src/app.js'` por:
```
entry: {
    app: './app-src/app.js',
    vendor: ['jquery', 'bootstrap', 'reflect-metadata']
}
```

### Atividade 05 - Gerando a página principal automaticamente:

- `npm install html-webpack-plugin@2.29.0 --save-dev`: adiciona a dependência do `html-webpack-plugin` para carregar módulos de estilo e scripts de terceiros dinamicamente;
- Renomeie seu `index.html` para `main.html` (esse arquivo servirá de "*template*" para criar seu `index.html`);

#### `webpack.config.js`:

- Importe o `htmlWebpackPlugin` com `const htmlWebpackPlugin = require('html-webpack-plugin');`;
- Defina a nova forma de gerar o `index.html`:
```
plugins.push(new htmlWebpackPlugin({
    hash: true,
    minify: {
        html5: true,
        collapseWhitespace: true,
        removeComments: true
    },
    filename: 'index.html',
    template: __dirname + 'main.html'
}));
```

### Atividade 06 - Code splitting e Lazy loading:

- `const { NegociacaoService } = await System.import('../domain/negociacao/NegociacaoService');`: carrega um módulo de forma assíncrona;

### Atividade 07 - System.import vs import:

- `npm install babel-plugin-syntax-dynamic-import@6 --save-dev`: adiciona a dependência `babel-plugin-syntax-dynamic-import`;
- Adiciona no `.babelrc`, na propriedade `plugins`, o valor `"babel-plugin-syntax-dynamic-import"`;
