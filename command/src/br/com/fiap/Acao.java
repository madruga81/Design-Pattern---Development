package br.com.fiap;

public class Acao {
	
		   private String name = "ABC";
		   private int quantity = 10;

		   public void compra(){
		      System.out.println("A��o [ Nome: "+name+", Quantidade: " + quantity +" ] comprada");
		   }
		   public void vende(){
		      System.out.println("A��o [ Nome: "+name+", Quantidade: " + quantity +" ] vendida");
		   }

}
