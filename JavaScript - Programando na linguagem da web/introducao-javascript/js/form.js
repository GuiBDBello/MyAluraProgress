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
	console.log(paciente);

	// Cria a tr e a td do paciente
	var trPaciente = document.createElement("tr");

	var tdNome = document.createElement("td");
	var tdPeso = document.createElement("td");
	var tdAltura = document.createElement("td");
	var tdGordura = document.createElement("td");
	var tdImc = document.createElement("td");

	tdNome.textContent = nome;
	tdPeso.textContent = peso;
	tdAltura.textContent = altura;
	tdGordura.textContent = gordura;
	tdImc.textContent = calculaImc(peso, altura);

	trPaciente.appendChild(tdNome);
	trPaciente.appendChild(tdPeso);
	trPaciente.appendChild(tdAltura);
	trPaciente.appendChild(tdGordura);
	trPaciente.appendChild(tdImc);

	// Adicionando o paciente na tabela
	var tabela = document.querySelector("#tabela-pacientes");
	tabela.appendChild(trPaciente);
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