/**
 * Esta clase nos representa un árbol genérico.
 *
 * @param <T> Tipo de datos que almacenará el árbol, puede ser cualquiera pero por razones
 * de uso practico tenemos la letra T.
 */
public class Arbol<T> {

    private NodoArbol<T> raiz;
    private boolean esBinario = false;

    /**
     * Constructor de la clase Arbol.
     *
     * @param dato Dato a almacenar en la raíz del árbol.
     * @param esBinario Nos indica si el árbol es binario o no.
     */
    public Arbol(T dato, boolean esBinario) {
        raiz = new NodoArbol<T>(dato);
        raiz.setEsBinario(esBinario);
        this.esBinario = esBinario;
    }

    /**
     * Obtiene la raíz del árbol.
     *
     * @return NodoArbol que representa la raíz del árbol.
     */
    public NodoArbol<T> obtenerRaiz() {
        return raiz;
    }

    /**
     * Verifica si el árbol es binario.
     *
     * @return true si el árbol es binario, false sino lo es.
     */
    public boolean esBinario() {
        return esBinario;
    }

    /**
     * Agrega un nodo al árbol.
     *
     * @param nodoRaiz Nodo padre al que se le agregará el hijo.
     * @param nodoAgregado Nodo que se agregará como hijo.
     */
    public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) {
        if (esBinario) {
            nodoAgregado.setEsBinario(esBinario);
        }

        nodoRaiz.agregarHijo(nodoAgregado);
    }

    /**
     * Imprime el árbol en el recorrido que se indique.
     *
     * @param recorrido Tipo de recorrido a utilizar de la clase enum Recorrido.java (Prefijo, Infijo, Posfijo).
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