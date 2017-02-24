package br.com.fiap.titulo.teste;

import br.com.fiap.titulo.Cobranca;
import br.com.fiap.titulo.CobrancaBradesco;

public class CobrancaBradescoTeste {

	public static void main(String[] args) {
		Cobranca cobrancaBradesco = new CobrancaBradesco();
		cobrancaBradesco.criarTitulo();
		System.out.println(cobrancaBradesco.obterCodigoBarras());
	}

}
