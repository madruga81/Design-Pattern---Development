package br.com.fiap;
import java.util.Observable;

public class Dados extends Observable {

	private static Dados instance = null;

	private Integer value;

	private Dados() {
		this.setValue(0);
	}

	public static Dados getInstance() { // singleton
		if (instance == null) {
			synchronized (Dados.class) {
				if (instance == null) {
					instance = new Dados();
				}
			}
		}
		return instance;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
		setChanged(); //marca esse objeto observavel como alterado
		notifyObservers(); //notifica todos os observadores que esse objeto foi alterado
	}

}
