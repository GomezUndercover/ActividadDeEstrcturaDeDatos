// esta clase la utilizamos para representar nodos en una estructura de datos que
// puede estar formada por una serie nodos entrelazados entre si.

class Nodo {

    private int dato;
    private Nodo nodo;

    // constructor que toma un valor entero como argumento y lo asigna al atributo
    // dato de nuestro nodo.
    Nodo(int dato) {
        this.dato = dato;
        nodo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNodo() {
        return this.nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }
}