package br.com.fiap;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//A concrete colleague
class BotaoReserva extends JButton implements Command {

	Mediator med;

	BotaoReserva(ActionListener al, Mediator m) {
		super("Reserva");
		addActionListener(al);
		med = m;
		med.registerBook(this);
	}

	public void execute() {
		med.book();
	}

}
