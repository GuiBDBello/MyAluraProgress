public class TestaMetodo {
	public static void main(String[] args) {
		Conta conta = new Conta();
		boolean conseguiuRetirar;
		
		conta.saldo = 100;
		System.out.println(conta.saldo);
		conta.deposita(50);
		System.out.println(conta.saldo);
		conseguiuRetirar = conta.saca(100);
		System.out.println(conta.saldo);
		System.out.println(conseguiuRetirar);
		conseguiuRetirar = conta.saca(100);
		System.out.println(conta.saldo);
		System.out.println(conseguiuRetirar);
	}
}