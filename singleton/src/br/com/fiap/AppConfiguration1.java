package br.com.fiap;

public class AppConfiguration1 {
	
	/*
	 * Esse modelo de Singleton � o mais simples de 
	 * implementar.
	 * No entanto � instanciado mesmo que n�o seja 
	 * utilizado pela aplica��o.
	 */
	
	private static final AppConfiguration1 instance = new AppConfiguration1();

	private AppConfiguration1() {
		// Carregar propriedades aqui...
	}
	
	public static AppConfiguration1 getInstance() {
		return instance;
	}
	
	public String getProperty(String name) {
		// Retornar propriedade aqui...
		return null;
	}

}
