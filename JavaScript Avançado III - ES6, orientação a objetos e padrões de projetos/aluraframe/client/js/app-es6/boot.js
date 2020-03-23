import { NegociacaoController } from './controllers/NegociacaoController';
import { } from './polyfill/fetch';

var negociacaoController = new NegociacaoController();

document.querySelector('.form').onsubmit = negociacaoController.adiciona.bind(negociacaoController);
document.querySelector('[type=button]').onclick = negociacaoController.apaga.bind(negociacaoController);
