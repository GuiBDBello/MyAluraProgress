package br.com.caelum.empresa.modelo;

import java.util.Calendar;

public class Funcionario {
	private String nome;
	private int matricula;
	private Calendar dataNascimento;

	public Funcionario(String nome, int matricula, Calendar dataNascimento) {
		this.nome = nome;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return "Funcionario: " + nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
