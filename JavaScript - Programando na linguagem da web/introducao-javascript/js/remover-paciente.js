/*
var pacientes = document.querySelectorAll(".paciente");
console.log(pacientes);

pacientes.forEach(function(paciente) {
	paciente.addEventListener("dblclick", function() {
		//console.log("Duplo clique em " + this.textContent);
		this.remove();
	});
});
 */

var tabela = document.querySelector("#tabela-pacientes");
console.log(tabela);

tabela.addEventListener("dblclick", function(event) {
	//console.log(event.target);
	//console.log(event.target.parentNode);
	event.target.parentNode.remove();
});