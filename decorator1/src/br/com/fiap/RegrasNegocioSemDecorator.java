package br.com.fiap;

import java.io.File;

import br.com.fiap.common.InfoEstrutura;

public class RegrasNegocioSemDecorator {

	public InfoEstrutura obterTamanhoEstrutura(File file, byte tipoRetorno) {
		InfoEstrutura info = new InfoEstrutura();
		if (tipoRetorno == 1){
			info.setTamanho(file.length());	
		} else if (tipoRetorno == 2){
			info.setTamanho(file.length()/1024);
		}
		return info;
	}
}
