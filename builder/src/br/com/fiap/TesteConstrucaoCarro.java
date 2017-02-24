package br.com.fiap;
public class TesteConstrucaoCarro {

	public static void main(String[] args) {
		
		Carro carro = new Carro();
		
		//sem interface fluente
		carro.setModelo("Vectra");
		carro.setAnoFabricacao(2010);
		carro.setAnoModelo(2011);
		carro.setCategoria("passeio");
		carro.setCor("preta");
		carro.setPotencia("120CV");
		
		
		
		
		
		
		
		
		
		
		
		//com interface fluente
		carro.setModelo("Vectra").setAnoFabricacao(2010).setAnoModelo(2011).setCategoria("passeio")
				.setCor("preta").setPotencia("120CV");
		
		

		System.out.println(carro.getModelo());
		System.out.println(carro.getAnoFabricacao());
		System.out.println(carro.getAnoModelo());
		System.out.println(carro.getCategoria());
		System.out.println(carro.getCor());
		System.out.println(carro.getPotencia());
	}

}
