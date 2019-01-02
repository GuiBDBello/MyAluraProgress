// Gerente é um Funcionário Autenticável, Gerente herda da Classe FuncionarioAutenticavel
public class Gerente extends FuncionarioAutenticavel {

	public double getBonificacao() {
		System.out.println("Chamando o método de Bonificação do Gerente.");
		return super.getSalario();
	}
}