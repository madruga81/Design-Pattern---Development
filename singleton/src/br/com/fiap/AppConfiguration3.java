package br.com.fiap;

public class AppConfiguration3 {
	
	/*
	 * Esse modelo de Singleton � instanciado somente
	 * se a aplica��o fizer uso dele.
	 * Essa classe � instanciada no primeiro uso e
	 * cacheada para a as pr�ximas vezes.
	 * O m�todo getInstance() primeiro verifica se j�
	 * existe uma inst�ncia antes de testar criar uma 
	 * nova inst�ncia. 
	 * Essa classe � trhead safe.
	 */
	
	// Note que o final saiu daqui
	private static AppConfiguration3 instance = null;

	private AppConfiguration3() {
		// Carregar propriedades aqui...
	}
	
	public static AppConfiguration3 getInstance() {
		if (instance == null) {
			synchronized (AppConfiguration3.class) {
				if (instance == null) {
					instance = new AppConfiguration3();
				}
			}
		}
		return instance;
	}
	
	public String getProperty(String name) {
		// Retornar propriedade aqui...
		return null;
	}

}
