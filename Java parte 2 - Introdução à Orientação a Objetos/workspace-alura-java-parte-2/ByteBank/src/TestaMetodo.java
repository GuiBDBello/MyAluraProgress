public class TestaMetodo {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.saldo = 100;
		System.out.println(conta.saldo);
		conta.deposita(50);
		System.out.println(conta.saldo);
	}
}