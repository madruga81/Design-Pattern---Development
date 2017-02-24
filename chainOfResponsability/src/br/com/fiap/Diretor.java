package br.com.fiap;

public class Diretor extends Chefe {

	private final double valorPermitido = 20 * valor;

	public void processarRequisicao(double valor) {
		if (valor <= valorPermitido) {
			System.out.println("Diretor aprovou R$" + valor);
		} else if (successor != null) {
			successor.processarRequisicao(valor);
		}
	}
}
