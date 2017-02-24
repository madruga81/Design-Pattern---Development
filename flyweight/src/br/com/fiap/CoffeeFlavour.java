package br.com.fiap;


// Instancias de CoffeeFlavour serão os Flyweights
class CoffeeFlavour {
  private final String name;

  CoffeeFlavour(String newFlavor) {
    this.name = newFlavor;
  }

  @Override
  public String toString() {
    return name;
  }
}
