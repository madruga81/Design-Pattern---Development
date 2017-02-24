package com.padrao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teste {
	public static void main(String[] args) {
		Ventilador ventilador = new Ventilador();
		while (true) {
			System.out.print("Pressione o botão controle [0-3]: ");
			getLine();
			ventilador.ligar();
		}
	}

	static String getLine() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return line;
	}
}
