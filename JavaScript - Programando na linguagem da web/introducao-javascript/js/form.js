var botaoAdicionar = document.querySelector("#adicionar-paciente");
//console.log(botaoAdicionar);

botaoAdicionar.addEventListener("click", function(event) {
	event.preventDefault();

	var form = document.querySelector("#form-adiciona");
	/*
	console.log(form);
	console.log(form.peso.value);
	console.log(form.altura.value);
	*/

	// Extraindo informações do paciente do form
	var paciente = obtemPacienteDoFormulario(form);
	//console.log(paciente);

	// Cria a tr e a td do paciente
	var trPaciente = montaTr(paciente);

	var erros = validaPaciente(paciente);

	if (erros.length > 0) {
		var mensagemErro = document.querySelector("#mensagem-erro");
		mensagemErro.textContent = erros;
		return;
	}

	// Adicionando o paciente na tabela
	var tabela = document.querySelector("#tabela-pacientes");
	tabela.appendChild(trPaciente);

	form.reset();
});

function obtemPacienteDoFormulario(form) {

	var paciente = {
		nome: form.nome.value,
		peso: form.peso.value,
		altura: form.altura.value,
		gordura: form.gordura.value,
		imc: calculaImc(form.peso.value, form.altura.value)
	}

	return paciente;
}

function montaTr(paciente) {

	var trPaciente = document.createElement("tr");
	trPaciente.classList.add("paciente");

	trPaciente.appendChild(montaTd(paciente.nome, "info-nome"));
	trPaciente.appendChild(montaTd(paciente.peso, "info-peso"));
	trPaciente.appendChild(montaTd(paciente.altura, "info-altura"));
	trPaciente.appendChild(montaTd(paciente.gordura, "info-gordura"));
	trPaciente.appendChild(montaTd(paciente.imc, "info-imc"));

	return trPaciente;
}

function montaTd(dado, classe) {
	var td = document.createElement("td");
	td.textContent = dado;
	td.classList.add(classe);

	return td;
}

function validaPaciente(paciente) {

	var erros = [];

	if (!validaPeso(paciente.peso))
		erros.push("Peso inválido!");

	if (!validaAltura(paciente.altura))
		erros.push("Altura inválida!");

	return erros;
}