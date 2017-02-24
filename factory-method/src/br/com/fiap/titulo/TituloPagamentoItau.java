package br.com.fiap.titulo;

import java.util.Date;

public class TituloPagamentoItau implements TituloPagamento{
	
	private String codigoBarras;
	private Date vencimento;

	
	public TituloPagamentoItau(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}

	
	public Date getVencimento() {
		return vencimento;
	}


	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

}
