package com.padrao;

class Desligado implements Estado {
	public void ligar(Ventilador ventilador) {
		ventilador.setEstado(new Baixa());
		System.out.println("Velocidade baixa");
	}
}
