package br.com.fiap;

import java.io.File;

import br.com.fiap.common.InfoEstrutura;
import br.com.fiap.common.InterfaceNegocio;

public class RegrasNegocio implements InterfaceNegocio {

	public InfoEstrutura obterTamanhoEstrutura(File file) {
		InfoEstrutura info = new InfoEstrutura();
		info.setTamanho(file.length());
		return info;
	}

}
