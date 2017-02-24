package br.com.fiap;

public abstract class TemplateMethod2 implements Strategy {

	   public void solve() {                             
		      while (true) {
		         preProcess();
		         if (search()) break;
		         postProcess();
		      }
		   }
		   protected abstract void preProcess();
		   protected abstract boolean search();
		   protected abstract void postProcess();

}
