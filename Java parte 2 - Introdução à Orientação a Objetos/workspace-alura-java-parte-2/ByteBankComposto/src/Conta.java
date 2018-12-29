public class Conta {
	private double saldo;
	private int agencia = 42;
	private int numero;
	Cliente titular = new Cliente();
	
	public double pegaSaldo() {
		return this.saldo;
	}

	public void deposita(double valor) {
		this.saldo += valor;
		//System.out.println("Foi depositado R$" + valor + ". Seu saldo atual é R$" + this.saldo);
	}

	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			//System.out.println("Efetuado saque de R$" + valor);
			return true;
		} else {
			//System.out.println("O valor R$" + valor + " não está disponível para saque.");
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta conta) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			conta.deposita(valor);
			return true;
		}
		//if (this.saca(valor)) {;
		//conta.deposita(valor);
		//}
		return false;
	}
}