'use strict';

System.register([], function (_export, _context) {
    "use strict";

    var _createClass, Conta;

    function _classCallCheck(instance, Constructor) {
        if (!(instance instanceof Constructor)) {
            throw new TypeError("Cannot call a class as a function");
        }
    }

    return {
        setters: [],
        execute: function () {
            _createClass = function () {
                function defineProperties(target, props) {
                    for (var i = 0; i < props.length; i++) {
                        var descriptor = props[i];
                        descriptor.enumerable = descriptor.enumerable || false;
                        descriptor.configurable = true;
                        if ("value" in descriptor) descriptor.writable = true;
                        Object.defineProperty(target, descriptor.key, descriptor);
                    }
                }

                return function (Constructor, protoProps, staticProps) {
                    if (protoProps) defineProperties(Constructor.prototype, protoProps);
                    if (staticProps) defineProperties(Constructor, staticProps);
                    return Constructor;
                };
            }();

            Conta = function () {
                function Conta() {
                    var saldo = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : '';

                    _classCallCheck(this, Conta);

                    this._saldo = saldo;
                }

                _createClass(Conta, [{
                    key: 'atualiza',
                    value: function atualiza(taxa) {
                        throw new Error('O método atualiza deve ser implementado.');
                    }
                }, {
                    key: 'saldo',
                    get: function get() {
                        return this._saldo;
                    }
                }]);

                return Conta;
            }();
        }
    };
});
//# sourceMappingURL=Conta.js.map