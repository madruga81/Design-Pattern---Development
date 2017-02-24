package br.com.fiap;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//A concrete colleague
class BotaoVisualizar extends JButton implements Command {

	Mediator med;

	BotaoVisualizar(ActionListener al, Mediator m) {
		super("Visualiza");
		addActionListener(al);
		med = m;
		med.registerView(this);
	}

	public void execute() {
		med.view();
	}

}
