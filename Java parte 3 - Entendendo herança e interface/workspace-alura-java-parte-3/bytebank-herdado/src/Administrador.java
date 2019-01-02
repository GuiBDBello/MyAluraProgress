// Administrador é um Funcionário Autenticável, Administrador herda da Classe FuncionarioAutenticavel
public class Administrador extends FuncionarioAutenticavel {

	@Override
	public double getBonificacao() {
		System.out.println("Chamando o método de Bonificação do Administrador.");
		return 50;
	}
}