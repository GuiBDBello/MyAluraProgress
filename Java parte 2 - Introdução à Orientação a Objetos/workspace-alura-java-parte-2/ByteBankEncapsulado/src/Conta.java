public class Conta {
	private double saldo;
	private int agencia = 42;
	private int numero;
	private Cliente titular = new Cliente();

	public void deposita(double valor) {
		this.saldo += valor;
		// System.out.println("Foi depositado R$" + valor + ". Seu saldo atual é R$" +
		// this.saldo);
	}

	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			// System.out.println("Efetuado saque de R$" + valor);
			return true;
		} else {
			// System.out.println("O valor R$" + valor + " não está disponível para
			// saque.");
			return false;
		}
	}

	public boolean transfere(double valor, Conta conta) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			conta.deposita(valor);
			return true;
		}
		// if (this.saca(valor)) {;
		// conta.deposita(valor);
		// }
		return false;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
}