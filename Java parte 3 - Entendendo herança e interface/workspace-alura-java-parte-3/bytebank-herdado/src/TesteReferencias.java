public class TesteReferencias {
	public static void main(String[] args) {
		
		Funcionario g1 = new Gerente();
		
		g1.setNome("Guilherme Brunetto Dall Bello");
		String nome = g1.getNome();
		
		System.out.println(nome);
	}
}