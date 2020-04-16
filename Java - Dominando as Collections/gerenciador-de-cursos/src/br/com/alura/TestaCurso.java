package br.com.alura;

public class TestaCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		// 1.
//		List<Aula> aulas = javaColecoes.getAulas();
//		System.out.println(aulas);
		
//		aulas.add(new Aula("Trabalhando com ArrayList", 21));
		
//		System.out.println(aulas);

		// 2.
//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
		
		System.out.println(javaColecoes.getAulas());
//		System.out.println(aulas == javaColecoes.getAulas());
	}
}
