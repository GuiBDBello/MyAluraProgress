var botaoAdicionar = document.querySelector("#adicionar-paciente");
console.log(botaoAdicionar);

botaoAdicionar.addEventListener("click", function(event) {
	event.preventDefault();

	var form = document.querySelector("#form-adiciona");
	console.log(form);
	console.log(form.peso.value);
	console.log(form.altura.value);

	// Busca pela propriedade 'name' de cada input
	var nome = form.nome.value;
	var peso = form.peso.value;
	var altura = form.altura.value;
	var gordura = form.gordura.value;

	console.log(nome);
	console.log(peso);
	console.log(altura);
	console.log(gordura);

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
	//tdImc.textContent = imc;

	trPaciente.appendChild(tdNome);
	trPaciente.appendChild(tdPeso);
	trPaciente.appendChild(tdAltura);
	trPaciente.appendChild(tdGordura);
	//trPaciente.appendChild(tdImc);

	var tabela = document.querySelector("#tabela-pacientes");
	tabela.appendChild(trPaciente);
});