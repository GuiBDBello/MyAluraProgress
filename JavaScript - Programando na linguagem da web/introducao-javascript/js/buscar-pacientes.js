var botaoAdicionar = document.querySelector("#buscar-pacientes");

botaoAdicionar.addEventListener("click", function() {
	console.log("Buscando...");

	var xhr = new XMLHttpRequest();

	xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes");

	xhr.addEventListener("load", function() {
		console.log(xhr.responseText);
		console.log(typeof xhr.responseText);

		var pacientes = JSON.parse(xhr.responseText);
		console.log(pacientes);
		console.log(typeof pacientes);

		pacientes.forEach(function(paciente) {
			adicionaPacienteNaTabela(paciente);
		});
	});

	xhr.send();
});