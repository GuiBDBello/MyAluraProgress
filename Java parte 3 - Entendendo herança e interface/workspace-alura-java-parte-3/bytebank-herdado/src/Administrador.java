// Administrador é Funcionario, Administrador herda da Classe Funcionário
public class Administrador extends Funcionario {

	@Override
	public double getBonificacao() {
		System.out.println("Chamando o método de Bonificação do Administrador.");
		return 50;
	}
}