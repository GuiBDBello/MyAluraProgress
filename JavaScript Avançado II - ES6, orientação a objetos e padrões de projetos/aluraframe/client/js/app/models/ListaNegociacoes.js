class ListaNegociacoes {

    constructor(contexto, armadilha) {
        this._negociacoes = [];
        this._armadilha = armadilha;
        this._contexto = contexto;
    }

    get negociacoes() {
        return [].concat(this._negociacoes);
    }

    adiciona(negociacao) {
        this._negociacoes.push(negociacao);
        // this._armadilha(this);
        Reflect.apply(this._armadilha, this._contexto, [this]);
    }

    esvazia() {
        this._negociacoes = [];
        this.armadilha(this);
    }

}