package br.com.fiap;

public class Aluno {
	
	public Aluno() {};
	
	public Aluno(String matricula, String nome, boolean sorteado) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.sorteado = sorteado;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isSorteado() {
		return sorteado;
	}
	public void setSorteado(boolean sorteado) {
		this.sorteado = sorteado;
	}
	private String matricula;
	private String nome;
	private boolean sorteado;

}
