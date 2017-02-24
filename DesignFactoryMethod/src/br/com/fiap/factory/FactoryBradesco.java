package br.com.fiap.factory;

import br.com.fiap.titulo.TituloPagamento;
import br.com.fiap.titulo.TituloPagamentoBradesco;
import br.com.fiap.titulo.TituloPagamentoItau;

public class FactoryBradesco implements Factory {

	@Override
	public TituloPagamento factoryMethod(String banco) {
		if (banco.equals("Bradesco")) { 
			return new TituloPagamentoBradesco();
		}
		else if (banco.equals("Itau")) { 
			return new TituloPagamentoItau();
		}
		return null;
	}
}