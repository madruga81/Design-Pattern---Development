package br.com.fiap;

import java.util.ArrayList;
import java.util.List;

public class Corretor {

	   private List<Pedido> orderList = new ArrayList<Pedido>(); 

	   public void recebePedido(Pedido pedido){
	      orderList.add(pedido);		
	   }

	   public void processaPedidos(){
	   
	      for (Pedido pedido : orderList) {
	         pedido.execute();
	      }
	      orderList.clear();
	   }
}
