public class Teste {
	public static void main(String[] args) {
		
		FuncionarioTeste f1 = new FuncionarioTeste();
		
		f1.setSalario(3000);
		System.out.println(f1.getTipo());
		System.out.println(f1.getBonificacao());
		
		FuncionarioTeste f2 = new FuncionarioTeste();
		
		f2.setTipo(1);
		f2.setSalario(3000);
		System.out.println(f2.getTipo());
		System.out.println(f2.getBonificacao());
		
		FuncionarioTeste f3 = new FuncionarioTeste();
		
		f3.setTipo(2);
		f3.setSalario(3000);
		System.out.println(f3.getTipo());
		System.out.println(f3.getBonificacao());
	}
}