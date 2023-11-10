public class Arbol<T> {
  private NodoArbol<T> raiz;
  private boolean esBinario = false;

  // constructor del objeto arbol
  public Arbol(T dato, boolean esBinario) {
    raiz = new NodoArbol<T>(dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  public NodoArbol<T> obtenerRaiz() {
    return raiz;
  }

  public boolean esBinario() {
    return esBinario;
  }

  /*
   * el siguiente metodo toma como parametros dos NodosArbol genericos,
   * estos nodos se ponen en el orden (nodo raiz, nodo que se agregara)
   * Al llamar este metodo y darle los parametros correspondientes le agrega
   * un nodo hijo al nodo raiz que se le indico
   */
  public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /*
   * Usando un switch case y tomando como parametro la clase enum Recorrido
   * se puede imprimir el tipo de recorrido de arbol que se indique
   * usando los metodos de NodoArbol
   */
  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");
        raiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;

      default:
        break;
    }
  }
}