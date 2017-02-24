package br.com.fiap;

public class CommandPatternDemo {

	public static void main(String[] args) {
		Acao abcStock = new Acao();

		CompraAcao buyStockOrder = new CompraAcao(abcStock);
		VendeAcao sellStockOrder = new VendeAcao(abcStock);

		Corretor corretor = new Corretor();
		corretor.recebePedido(buyStockOrder);
		corretor.recebePedido(sellStockOrder);

		corretor.processaPedidos();
	}
}
