package br.com.fiap;

public class Teste {


	public static void main(String[] args) {
		Animal prototipo = new Ovelha("Dolly");
		
		Animal copia = (Animal) prototipo.clone();
		
		System.out.println(prototipo.getNome());
		System.out.println(copia.getNome());
	}

}
