var titulo = document.querySelector(".titulo");
titulo.textContent = "Aparecida Nutricionista";

var pacientes = document.querySelectorAll(".paciente");

for (var i = 0; i < pacientes.length; i++) {
	//console.log(pacientes[i]);

	var paciente = pacientes[i];

	var tdPeso = paciente.querySelector(".info-peso");
	var peso = tdPeso.textContent;

	var tdAltura = paciente.querySelector(".info-altura");
	var altura = tdAltura.textContent;

	var tdImc = paciente.querySelector(".info-imc");

	var pesoEhValido = validaPeso(peso);
	var alturaEhValida = validaAltura(altura);

	if (!pesoEhValido) {
		console.log("Peso inválido!");
		pesoEhValido = false;
		tdImc.textContent = "Peso inválido!";
	}

	if (!alturaEhValida) {
		console.log("Altura inválida!");
		alturaEhValida = false;
		tdImc.textContent = "Altura inválida!";
	}

	if (pesoEhValido && alturaEhValida) {
		var imc = calculaImc(peso, altura);
		tdImc.textContent = imc;
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

function validaPeso(peso) {
	if (peso >= 0 && peso < 1000) {
		return true;
	} else {
		return false;
	}
}

function validaAltura(altura) {
	if (altura >= 0 && altura < 3.00) {
		return true;
	} else {
		return false;
	}
}

function calculaImc(peso, altura) {
	var imc = 0;
	imc = peso / (altura * altura);

	return imc.toFixed(2);
}