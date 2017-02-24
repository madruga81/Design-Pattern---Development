package br.com.fiap.teste;

import java.io.File;

import br.com.fiap.RegrasNegocio;
import br.com.fiap.common.InfoEstrutura;
import br.com.fiap.common.InterfaceNegocio;
import br.com.fiap.pattern.RegrasNegocioDecorator;

public class Teste {

	public static void main(String[] args) {

		// tela 1
		InterfaceNegocio objeto = new RegrasNegocio();
		InfoEstrutura info = objeto.obterTamanhoEstrutura(new File("c:\\windows\\system32\\sethc.exe"));
		System.out.println("\nTela 1\n" + info.getTamanho() + " bytes");

		// tela 2 com decorator
		InterfaceNegocio objetodecorado = new RegrasNegocioDecorator(objeto);
		InfoEstrutura info2 = objetodecorado.obterTamanhoEstrutura(new File("c:\\windows\\system32\\sethc.exe"));
		System.out.println("\nTela 2\n" +info2.getTamanho() + " MB");
		
		// tela 3
		System.out.println("\nTela 3\n" + info.getTamanho() + " bytes");
		
		// tela 4
		System.out.println("\nTela 4\n" +info.getTamanho() + " bytes");
		
		// tela 5
		System.out.println("\nTela 5\n" +info.getTamanho() + " bytes");
	}
}
