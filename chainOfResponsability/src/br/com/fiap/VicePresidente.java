package br.com.fiap;

public class VicePresidente extends Chefe {

	private final double valorPermitido = 30 * valor;

	public void processarRequisicao(double valor) {
		if (valor <= valorPermitido) {
			System.out.println("Vice presidente aprovou R$" + valor);
		} else if (successor != null) {
			successor.processarRequisicao(valor);
		}
	}
}
