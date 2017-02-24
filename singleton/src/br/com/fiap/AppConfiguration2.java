package br.com.fiap;

public class AppConfiguration2 {
	
	/*
	 * Esse modelo de Singleton � instanciado somente
	 * se a aplica��o fizer uso dele.
	 * Essa classe � instanciada no primeiro uso e
	 * cacheada para a as pr�ximas vezes.
	 * O m�todo getInstance() primeiro verifica se j�
	 * existe uma inst�ncia antes de testar criar uma 
	 * nova inst�ncia. 
	 * No entanto, essa classe n�o � thread safe.
	 */
	
	// Note que o final saiu daqui
	private static AppConfiguration2 instance = null;

	private AppConfiguration2() {
		// Carregar propriedades aqui...
	}
	
	public static AppConfiguration2 getInstance() {
		if (instance == null) {
			instance = new AppConfiguration2();
		}
		return instance;
	}
	
	public String getProperty(String name) {
		// Retornar propriedade aqui...
		return null;
	}

}
