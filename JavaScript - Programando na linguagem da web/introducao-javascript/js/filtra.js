var campoFiltro = document.querySelector("#filtrar-tabela");
console.log(campoFiltro);

campoFiltro.addEventListener("input", function() {
	console.log("Digitaram no campo!");
	console.log(this.value);

	var pacientes = document.querySelectorAll(".paciente");
	for (var i = 0; i < pacientes.length; i++) {
		var paciente = pacientes[i];
		var tdNome = paciente.querySelector(".info-nome");
		var nome = paciente.textContent;
	}
});