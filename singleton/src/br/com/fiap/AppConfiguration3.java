package br.com.fiap;

public class AppConfiguration3 {
	
	/*
	 * Esse modelo de Singleton é instanciado somente
	 * se a aplicação fizer uso dele.
	 * Essa classe é instanciada no primeiro uso e
	 * cacheada para a as próximas vezes.
	 * O método getInstance() primeiro verifica se já
	 * existe uma instância antes de testar criar uma 
	 * nova instância. 
	 * Essa classe é trhead safe.
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
