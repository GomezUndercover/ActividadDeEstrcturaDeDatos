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

     /**
     * (NUEVO DE TAREA) Verifica si el árbol está vacío.
     *
     * @return true si el árbol está vacío, false en caso contrario.
     */

    public boolean estaVacio(){
        return raiz == null;
    }

    /**
     * (NUEVO DE TAREA)
     * Obtiene la altura del árbol. 
     * Usando recursion podemos obtener la altura, considerando el el maximo de las dos alturas entre los nodos en cada camino
     * y luego se le suma 1, el mismo metodo se llamada para obtener la altura de cada subrama del arbol, y al final despues de 
     * que se haya terminado la recursion, retorna el max de las alturas obtenidas y se le suma + 1.
     *
     * @return La altura del árbol.
     * @param NodoArbol<T> este es el nodo que se usara en cada llamada del metodo para obtener la altura, los cuales
     * seran los nodos en cada camino.
     */

    public int obtenerAltura() {
        return obtenerAltura(raiz);
    }

    private int obtenerAltura(NodoArbol<T> nodo){
        if (nodo == null){
            return -1; // el nodo usado como parametro no tiene hijos
        }

        int alturaIzquierda = obtenerAltura(nodo.obtenerPrimerHijo());
        int alturaDerecha = obtenerAltura(nodo.obtenerSiguienteHermano());

        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    /**
     * Metodo que se llama en el main con el nodo a partir del cual se hara la impresion del subarbol.
     * 
     * Checamos si el nodo no es nulo y si no lo es, se hace las llamadas al metodo recursivo que realiza
     * la impresion en consola del subarbol.
     * 
     * @param nodoIndicado
     */
    public void imprimirSubArbol(NodoArbol<T> nodoIndicado){
        if(nodoIndicado != null){
            System.out.println("Subarbol a partir de " + nodoIndicado.getDato() + ":");
            imprimirSubArbol(nodoIndicado, 0);
        } else {
            System.out.println("El nodo es nulo. No es posible imprimir su subarbol");
        }
    }

    /**
     * Metodo que se llama dentro de la misma clase, para poder realizar la impresion del subarbol
     * toma como parametros los siguientes y checa si no es nulo el nodo, si no lo es pasa por un bucle 
     * que hace indentaciones segun el nivel de los nodos a partir del nodo indicado.
     * De ahi, hace una llamada recursiva que imprime tanto los hijos y los hermanos del nodo indicado
     * cada uno con sus propios hijos o hermanos.
     * 
     * @param nodo
     * @param nivel
     */
    private void imprimirSubArbol(NodoArbol<T> nodo, int nivel){
        if (nodo != null){
            // impresion de nodo actual con indentacion segun el nivel del nodo, para visualizar de mejor manera el la impresion del subarbol
            for(int i = 0; i < nivel ; i++){
                System.out.println("\t");
            }
            System.out.println("- " + nodo.getDato());

            //llamamos el metodo de nuevo para imprimir sus hijos y hermanos del nodo indicado
            imprimirSubArbol(nodo.obtenerPrimerHijo(), nivel + 1);
            imprimirSubArbol(nodo.obtenerSiguienteHermano(), nivel);
        }
    }
}