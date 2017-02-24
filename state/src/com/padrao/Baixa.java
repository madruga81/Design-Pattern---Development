package com.padrao;

class Baixa implements Estado {
	public void ligar(Ventilador ventilador) {
		ventilador.setEstado(new Media());
		System.out.println("Velocidade alta");
	}
}
