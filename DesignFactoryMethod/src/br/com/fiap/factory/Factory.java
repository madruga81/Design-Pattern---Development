package br.com.fiap.factory;

import br.com.fiap.titulo.TituloPagamento;

public interface Factory {
	
	TituloPagamento factoryMethod(String banco);
}