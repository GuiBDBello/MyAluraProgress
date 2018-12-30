public class TesteFuncionario {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Guilherme Brunetto Dall Bello");
		funcionario.setCpf("123.456.789-10");
		funcionario.setSalario(2600.00);
		
		System.out.println(funcionario.getNome());
		System.out.println(funcionario.getBonificacao());

	}

}