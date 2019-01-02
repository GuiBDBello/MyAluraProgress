// Gerente é Funcionário, Gerente herda da Classe Funcionario
public class Gerente extends Funcionario {

	public double getBonificacao() {
		System.out.println("Chamando o método de Bonificação do Gerente.");
		return super.getSalario();
	}
}