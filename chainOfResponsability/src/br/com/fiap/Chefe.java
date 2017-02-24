package br.com.fiap;

abstract class Chefe {

	protected final double valor = 500;
	protected Chefe successor;

	public void setSuccessor(Chefe successor) {
		this.successor = successor;
	}

	abstract public void processarRequisicao(double valor);

}
