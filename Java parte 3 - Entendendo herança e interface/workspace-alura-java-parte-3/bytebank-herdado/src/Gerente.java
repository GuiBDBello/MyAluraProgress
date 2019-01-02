// Gerente é Autenticável, Gerente herda da Classe Autenticavel
public class Gerente extends Funcionario {

	public double getBonificacao() {
		System.out.println("Chamando o método de Bonificação do Gerente.");
		return super.getSalario();
	}
}