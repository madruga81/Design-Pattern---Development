package br.com.fiap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Teste extends JFrame implements ActionListener {

	Mediator med = new Mediator();

	Teste() {
		JPanel p = new JPanel();
		p.add(new BotaoBusca(this, med));
		p.add(new BotaoVisualizar(this, med));
		p.add(new BotaoReserva(this, med));
		getContentPane().add(new Tela(med), "North");
		getContentPane().add(p, "South");
		setSize(400, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		Command comd = (Command) ae.getSource();
		comd.execute();
	}

	public static void main(String[] args) {
		new Teste();
	}

}
