import { currentInstance } from './controllers/NegociacaoController';
import {} from './polyfill/fetch';

var negociacaoController = currentInstance();

document.querySelector('.form').onsubmit = negociacaoController.adiciona.bind(negociacaoController);
document.querySelector('[type=button]').onclick = negociacaoController.apaga.bind(negociacaoController);
