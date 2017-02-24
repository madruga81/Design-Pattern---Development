package br.com.fiap;
import java.awt.Font;

import javax.swing.JLabel;

class Tela extends JLabel {

	Mediator med;

	Tela(Mediator m) {
		super("Sistema de reserva de livros");
		med = m;
		med.registerDisplay(this);
		setFont(new Font("Arial", Font.BOLD, 24));
	}

}
