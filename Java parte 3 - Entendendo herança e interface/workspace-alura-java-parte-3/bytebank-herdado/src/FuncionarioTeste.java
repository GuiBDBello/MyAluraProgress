public class FuncionarioTeste {

	private String nome;
	private String cpf;
	private double salario;
	private int tipo = 0; // 0 - Funcionario comum, 1 - Gerente, 2 - Diretor
	private int senha;

	public FuncionarioTeste() {

	}

	public boolean autentica(int senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}

	public double getBonificacao() {
		if (this.tipo == 0) { // Funcionario comum
			return this.salario * 0.1;
		} else if (this.tipo == 1) { // Gerente
			return this.salario;
		} else { // Diretor
			return this.salario + 1000.0;
		}
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}