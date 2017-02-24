package br.com.fiap;

public class CompraAcao implements Pedido {
	
	   private Acao abcStock;

	   public CompraAcao(Acao abcStock){
	      this.abcStock = abcStock;
	   }

	   public void execute() {
	      abcStock.compra();
	   }

}
