package br.com.fiap;

abstract class TemplateMethod1 implements Strategy {

	   public void solve() {
		      start();
		      while (nextTry() && ! isSolution())
		         ;
		      stop();
		   }
		   protected abstract void    start();
		   protected abstract boolean nextTry();
		   protected abstract boolean isSolution();
		   protected abstract void    stop();

}
