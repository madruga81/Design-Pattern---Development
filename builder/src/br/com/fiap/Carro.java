package br.com.fiap;

//exemplo de Interface Fluente
public class Carro {

	private int anoFabricacao;
	private int anoModelo;
	private String modelo;
	private String cor;
	private String potencia;
	private String categoria;
	
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public Carro setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
		return this;
	}
	
	public int getAnoModelo() {
		return anoModelo;
	}
	public Carro setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
		return this;
	}
	
	public String getModelo() {
		return modelo;
	}
	public Carro setModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public String getCor() {
		return cor;
	}
	public Carro setCor(String cor) {
		this.cor = cor;
		return this;
	}
	
	public String getPotencia() {
		return potencia;
	}
	public Carro setPotencia(String potencia) {
		this.potencia = potencia;
		return this;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public Carro setCategoria(String categoria) {
		this.categoria = categoria;
		return this;
	}
}
