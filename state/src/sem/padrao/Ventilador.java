package sem.padrao;

class Ventilador {
	private int estado;

	public Ventilador() {
		estado = 0;
	}

	public void ligar() {
		if (estado == 0) {
			estado = 1;
			System.out.println("velocidade baixa");
		} else if (estado == 1) {
			estado = 2;
			System.out.println("velocidade media");
		} else if (estado == 2) {
			estado = 3;
			System.out.println("velocidade alta");
		} else {
			estado = 0;
			System.out.println("desligado");
		}
	}
}
