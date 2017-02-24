package br.com.fiap.titulo;

public class CobrancaItau extends Cobranca {
	
	TituloPagamento criarTituloPagamento() {
		return new TituloPagamentoItau("123456789");
	}
}
