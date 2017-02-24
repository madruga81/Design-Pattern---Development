package br.com.fiap.app;

import br.com.fiap.factory.Factory;
import br.com.fiap.factory.FactoryBradesco;
import br.com.fiap.factory.FactoryItau;
import br.com.fiap.titulo.TituloPagamento;

public class App {
	
	public static void main(String[] args) {
		exibeTituloItau();
		exibeTituloBradesco();
	}
	
	private static void exibeTituloItau() {
		Factory factory = new FactoryBradesco();
		TituloPagamento titulo = factory.factoryMethod("Itau");
		System.out.println("T�tulo de Pagamento Ita�: " + titulo.getCodigoBarra());
	}
	
	private static void exibeTituloBradesco() {
		Factory factory = new FactoryBradesco();
		TituloPagamento titulo = factory.factoryMethod("Bradesco");
		System.out.println("T�tulo de Pagamento Bradesco: " + titulo.getCodigoBarra());
	}
}