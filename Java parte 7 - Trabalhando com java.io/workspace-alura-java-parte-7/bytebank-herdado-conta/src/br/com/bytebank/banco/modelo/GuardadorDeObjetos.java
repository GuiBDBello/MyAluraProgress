package br.com.bytebank.banco.modelo;

public class GuardadorDeObjetos {

	private Object[] referencias;
	private int posicaoLivre;
	
	public GuardadorDeObjetos() {
		this.referencias = new Conta[10];
		this.posicaoLivre = 0;
	}
	
	public int getQuantidadeDeElementos() {
		return this.posicaoLivre;
	};
	
	public void adiciona(Object ref) {
		this.referencias[this.posicaoLivre] = ref;
		this.posicaoLivre++;
	}

	public Object getReferencia(int pos) {
		return referencias[pos];
	}
	
}
