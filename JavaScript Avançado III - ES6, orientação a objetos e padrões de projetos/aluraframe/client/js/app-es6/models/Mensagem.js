export class Mensagem {

    constructor(texto = '') {
        this._texto = texto || ''; // se texto for undefined, vai passar '';
    }

    get texto() {
        return this._texto;
    }

    set texto(texto) {
        this._texto = texto;
    }
}