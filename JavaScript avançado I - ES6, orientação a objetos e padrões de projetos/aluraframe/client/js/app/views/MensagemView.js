class MensagemView extends View {

    _template(model) {
        return model.texto ? `<p class="alert alert-info">${model.texto}</p>` : '<p></p>';
    }
}