package br.com.fiap.titulo.teste;

import br.com.fiap.titulo.Cobranca;
import br.com.fiap.titulo.CobrancaItau;

public class CobrancaItauTeste {

	public static void main(String[] args) {
		Cobranca cobrancaItau = new CobrancaItau();
		cobrancaItau.criarTitulo();
		System.out.println(cobrancaItau.obterCodigoBarras());
	}

}
