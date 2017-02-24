package br.com.fiap;

public class VendeAcao implements Pedido {
	
	   private Acao abcStock;

	   public VendeAcao(Acao abcStock){
	      this.abcStock = abcStock;
	   }

	   public void execute() {
	      abcStock.vende();
	   }	

}
