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
	console.log(erros);

	if (erros.length > 0) {
		exibeMensagemErro(erros);
		return;
	}

	// Adicionando o paciente na tabela
	var tabela = document.querySelector("#tabela-pacientes");
	tabela.appendChild(trPaciente);

	form.reset();
	document.querySelector("#mensagem-erro").innerHTML = "";
});

function exibeMensagemErro(erros) {
	var ul = document.querySelector("#mensagem-erro");
	ul.innerHTML = "";

	erros.forEach(function(erro) {
		var li = document.createElement("li");
		li.textContent = erro;
		ul.appendChild(li);
	});

	var li;
}

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

	if (paciente.nome.length == 0)
		erros.push("Campo 'Nome' não pode estar em branco!");

	if (!validaPeso(paciente.peso))
		erros.push("Peso inválido!");

	if (paciente.peso.length == 0)
		erros.push("Campo 'Peso' não pode estar em branco!");

	if (!validaAltura(paciente.altura))
		erros.push("Altura inválida!");

	if (paciente.altura.length == 0)
		erros.push("Campo 'Altura' não pode estar em branco!");

	if (paciente.gordura.length == 0)
		erros.push("Campo 'Gordura' não pode estar em branco!");

	return erros;
}