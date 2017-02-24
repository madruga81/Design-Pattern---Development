package br.com.fiap.factory;

import br.com.fiap.titulo.TituloPagamento;
import br.com.fiap.titulo.TituloPagamentoItau;

public class FactoryItau implements Factory {

	@Override
	public TituloPagamento factoryMethod(String branco) {
		return new TituloPagamentoItau();
	}
}