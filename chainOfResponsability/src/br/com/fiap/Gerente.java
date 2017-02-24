package br.com.fiap;

public class Gerente extends Chefe {

	private final double valorPermitido = 10 * valor;

	public void processarRequisicao(double valor) {
		if (valor <= valorPermitido) {
			System.out.println("Gerente aprovou R$" + valor);
		} else if (successor != null) {
			successor.processarRequisicao(valor);
		}
	}
}
