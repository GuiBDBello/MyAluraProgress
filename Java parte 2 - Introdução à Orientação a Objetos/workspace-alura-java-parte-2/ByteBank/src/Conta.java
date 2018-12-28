public class Conta {
	double saldo;
	int agencia = 42;
	int numero;
	String titular;
	
	void deposita(double valor) {
		this.saldo += valor;
		System.out.println("Foi depositado R$" + valor + ". Seu saldo atual é R$" + this.saldo);
	}
}