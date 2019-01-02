// Gerente é Funcionário, herda da Classe Funcionario
// Gerente é Autenticável, assina o contrato Autenticavel
public class Gerente extends Funcionario implements Autenticavel {

	private int senha;
	
	public double getBonificacao() {
		System.out.println("Chamando o método de Bonificação do Gerente.");
		return super.getSalario();
	}

	@Override
	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}
}