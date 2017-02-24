package br.com.fiap;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Teste {

	public static void main(String[] args) {

		Gerente gerente = new Gerente();
		Diretor diretor = new Diretor();
		VicePresidente vp = new VicePresidente();

		gerente.setSuccessor(diretor);
		diretor.setSuccessor(vp);

		try {
			while (true) {
				System.out.print("Valor a ser aprovado: ");
				System.out.print(">");
				double valor = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
				gerente.processarRequisicao(valor);
			}
		} catch (Exception e) {
			System.out.print(e);
			System.exit(1);
		}

	}

}
