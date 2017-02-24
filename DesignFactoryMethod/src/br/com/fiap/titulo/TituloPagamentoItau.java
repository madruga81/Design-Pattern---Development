package br.com.fiap.titulo;

public class TituloPagamentoItau implements TituloPagamento {

	@Override
	public String getCodigoBarra() {
		return "0123.1032456.124564.6.8979872310312";
	}
}