var botaoAdicionar = document.querySelector("#buscar-pacientes");

botaoAdicionar.addEventListener("click", function() {
	console.log("Buscando...");

	var xhr = new XMLHttpRequest();

	xhr.open("GET", "https://api-pacientes.herokuapp.com/pacientes");

	xhr.addEventListener("load", function() {

		if (xhr.status == 200) {
			console.log(xhr.responseText);
			console.log(typeof xhr.responseText);

			var pacientes = JSON.parse(xhr.responseText);
			console.log(pacientes);
			console.log(typeof pacientes);

			pacientes.forEach(function(paciente) {
				adicionaPacienteNaTabela(paciente);
			});
			document.querySelector("#erro-ajax").classList.add("invisivel");
		} else {
			alert("Erro " + xhr.status + ": " + xhr.responseText);
			document.querySelector("#erro-ajax").classList.remove("invisivel");
		}
	});

	xhr.send();
});