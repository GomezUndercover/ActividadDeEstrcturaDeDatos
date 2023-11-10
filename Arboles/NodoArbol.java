public class NodoArbol<T> {
  private T dato;
  private boolean esBinario = false;
  private NodoArbol<T> primerHijo;
  private NodoArbol<T> siguienteHermano;

  public NodoArbol(T dato) {
    this.dato = dato;
    primerHijo = null;
    siguienteHermano = null;
  }

  /*
   * se agrega un nodo hijo a la raiz, se checa si esta vacio el arbol y si es el
   * caso
   * se crea un primer hijo (la raiz).
   * si ya existe raiz, se crea el nodoArbol hermano y se convierte en el primer
   * hijo
   * del nodo anteriormente insertado en el arbol.
   * Por ultimo, se checa si el arbol es binario, si lo es, se limita la cantidad
   * de hijos que un nodo
   * padre pueda tener para mantener el orden de los arboles binarios.
   * Si no es binario, la cantidad de hijos que puede tener el nodo padre no esta
   * limitado.
   */
  public void agregarHijo(NodoArbol<T> hijo) {
    if (primerHijo == null) {
      primerHijo = hijo;
    } else {
      NodoArbol<T> hermano = this.primerHijo;

      if (esBinario) {
        if (hermano.siguienteHermano != null) {
          System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());
        } else {
          hermano.siguienteHermano = hijo;
        }
      } else {
        while (hermano.siguienteHermano != null) {
          hermano = hermano.siguienteHermano;
        }
        hermano.siguienteHermano = hijo;
      }
    }
  }

  public NodoArbol<T> obtenerPrimerHijo() {
    return primerHijo;
  }

  public NodoArbol<T> obtenerSiguienteHermano() {
    return siguienteHermano;
  }

  public T getDato() {
    return dato;
  }

  public boolean esBinario() {
    return esBinario;
  }

  public void setEsBinario(boolean esBinario) {
    this.esBinario = esBinario;
  }

  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }

  public void imprimirEnInfijo() {
    NodoArbol<T> hijo = primerHijo;

    if (hijo != null) {
      hijo.imprimirEnInfijo();
    }

    System.out.print(dato + "\t");
    while (hijo != null) {
      hijo = hijo.siguienteHermano;
      if (hijo != null) {
        hijo.imprimirEnInfijo();
      }
    }
  }

  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}
