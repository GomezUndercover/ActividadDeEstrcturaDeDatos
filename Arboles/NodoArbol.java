/**
 * Clase que representa un nodo en un árbol genérico.
 *
 * @param <T> Tipo de datos que contiene el nodo.
 */
public class NodoArbol<T> {
    private T dato;
    private boolean esBinario = false;
    private NodoArbol<T> primerHijo;
    private NodoArbol<T> siguienteHermano;

    /**
     * Constructor de la clase NodoArbol.
     *
     * @param dato Dato a almacenar en el nodo.
     */
    public NodoArbol(T dato) {
        this.dato = dato;
        primerHijo = null;
        siguienteHermano = null;
    }

    /**
     * Agrega un hijo al nodo, si no hay nodo raiz, se crea y el primer hijo (raiz) se le da el valor del dato en el parametro.
     * Si ya hay nodo raiz, se convierte el nodo anteriormente ingresado se crea un nodo hermano con él.
     * Luego checamos primero si es binario, el cual nos pone la restriccion que indican los arboles binarios, de que un nodo padre
     * no puede tener mas de dos hijos.
     * Si no es binario, se le agrega la cantidad de nodos hijos que se desean.
     *
     * @param hijo Nodo que se agregará como hijo.
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

    /**
     * Obtiene el primer hijo del nodo.
     *
     * @return NodoArbol que representa el primer hijo.
     */
    public NodoArbol<T> obtenerPrimerHijo() {
        return primerHijo;
    }

    /**
     * Obtiene el siguiente hermano del nodo.
     *
     * @return NodoArbol que representa el siguiente hermano.
     */
    public NodoArbol<T> obtenerSiguienteHermano() {
        return siguienteHermano;
    }

    /**
     * Obtiene el dato almacenado en el nodo.
     *
     * @return Dato almacenado en el nodo.
     */
    public T getDato() {
        return dato;
    }

    /**
     * Verifica si el nodo es parte de un árbol binario.
     *
     * @return true si el nodo es binario, false si no lo es.
     */
    public boolean esBinario() {
        return esBinario;
    }

    /**
     * Nos indica si el nodo es parte de un árbol binario.
     *
     * @param esBinario Valor que indica si el nodo es binario.
     */
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
