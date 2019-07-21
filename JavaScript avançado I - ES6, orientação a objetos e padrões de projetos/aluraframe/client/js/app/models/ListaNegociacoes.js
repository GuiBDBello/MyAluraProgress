class ListaNegociacoes {

    constructor() {
        this._negociacoes = [];
    }

    get negociacoes() {
        return this._negociacoes;
    }

    adiciona(negociacao) {
        this._negociacoes.push(negociacao);
    }

}