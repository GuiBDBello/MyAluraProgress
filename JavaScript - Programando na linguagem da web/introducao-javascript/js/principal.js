var titulo = document.querySelector(".titulo");
titulo.textContent = "Aparecida Nutricionista";

var pacientes = document.querySelectorAll(".paciente");

for (var i = 0; i < pacientes.length; i++) {
	console.log(pacientes[i]);

	var paciente = pacientes[i];

	var tdPeso = paciente.querySelector(".info-peso");
	var peso = tdPeso.textContent;

	var tdAltura = paciente.querySelector(".info-altura");
	var altura = tdAltura.textContent;

	var tdImc = paciente.querySelector(".info-imc");

	var pesoEhValido = true;
	var alturaEhValida = true;

	if (peso <= 1 || peso >= 1000) {
		console.log("Peso inválido!");
		pesoEhValido = false;
		tdImc.textContent = "Peso inválido!";
	}

	if (altura <= 0.1 || altura >= 3.00) {
		console.log("Altura inválida!");
		alturaEhValida = false;
		tdImc.textContent = "Altura inválida!";
	}

	if (pesoEhValido && alturaEhValida) {
		var imc = peso / (altura * altura);
		tdImc.textContent = imc.toFixed(2);
	} else {
		//paciente.style.color = "red";
		//paciente.style.backgroundColor = "lightcoral";
		paciente.classList.add("paciente-invalido");
	}

	/*
	console.log("Paciente: " + paciente);
	console.log("tdPeso: " + tdPeso);
	console.log("Peso: " + peso);
	console.log("tdAltura: " + tdAltura);
	console.log("Altura: " + altura);
	console.log("IMC: " + imc);
	*/
}

//titulo.addEventListener("click", mostraMensagem);
titulo.addEventListener("click", function() {
	console.log("Olá, eu sou uma função anônima.")
});

/*
function mostraMensagem() {
	console.log("Olá, eu fui clicado!");
}
*/

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