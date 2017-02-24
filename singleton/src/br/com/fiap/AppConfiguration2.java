package br.com.fiap;

public class AppConfiguration2 {
	
	/*
	 * Esse modelo de Singleton é instanciado somente
	 * se a aplicação fizer uso dele.
	 * Essa classe é instanciada no primeiro uso e
	 * cacheada para a as próximas vezes.
	 * O método getInstance() primeiro verifica se já
	 * existe uma instância antes de testar criar uma 
	 * nova instância. 
	 * No entanto, essa classe não é thread safe.
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
