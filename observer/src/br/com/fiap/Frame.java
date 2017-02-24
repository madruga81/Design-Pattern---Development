package br.com.fiap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Frame extends JFrame implements Observer {

	Dados dados = null;
	JLabel label = new JLabel();
	JButton button = new JButton("update");

	public Frame(String title) {
		super(title);
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dados = Dados.getInstance();
		label.setText(String.valueOf(dados.getValue()));
		this.getContentPane().add(label);
		this.getContentPane().add(button, "South");

		dados.addObserver(this); // adiciona esse frame como um observador dos dados

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dados.setValue(dados.getValue() + 1); // altera o valor dos dados quando o botão eh clicado
			}
		});
	}

	/*
	 * Esse método é chamado sempre que o objeto Observable
	 * executar o método notifyObservers.
	 * 
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		Dados obj = (Dados) o;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				label.setText(String.valueOf(dados.getValue())); // alteracao do texto
			}
		});

	}

}
