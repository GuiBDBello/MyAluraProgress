'use strict';

var _NegociacaoController = require('./controllers/NegociacaoController');

require('./polyfill/fetch');

var negociacaoController = new _NegociacaoController.NegociacaoController();

document.querySelector('.form').onsubmit = negociacaoController.adiciona.bind(negociacaoController);
document.querySelector('[type=button]').onclick = negociacaoController.apaga.bind(negociacaoController);
//# sourceMappingURL=boot.js.map