package br.com.fiap;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//A concrete colleague
class BotaoBusca extends JButton implements Command {

	Mediator med;

	BotaoBusca(ActionListener al, Mediator m) {
		super("Busca");
		addActionListener(al);
		med = m;
		med.registerSearch(this);
	}

	public void execute() {
		med.search();
	}

}
