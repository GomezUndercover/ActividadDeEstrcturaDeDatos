package listas.ListasSimples;

public class ListaSimplementeEnlazada{
    private int longitud;
    private Nodo primerNodo;

    public ListaSimplementeEnlazada(){
        primerNodo = null;
        longitud = 0;
    }
    public boolean estaVacia(){
        return primerNodo == null;
    }
    
    
    public void insertar(int dato){
        Nodo nuevoNodo = new Nodo(dato);
        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            Nodo nodoActual = primerNodo;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        longitud++;

    }
    public int obtener(int indice){
        if (indice < 0 || indice >= longitud) {
            System.err.println("Indice fuera de rango");
            return -1;
        }

        Nodo actualNodo = primerNodo;

        for (int i = 0; i < indice; i++){
            actualNodo  = actualNodo.getSiguiente();
        }

        return actualNodo.getDato();
    }
    
    public void eliminar(int indice){
        if (indice < 0 || indice >= longitud) {
            System.err.println("Indice fuera de rango");
        }
        
        if (indice == 0 ){
            primerNodo = primerNodo.getSiguiente();
        }else{
            Nodo nodoAnterior = primerNodo;
            
            for (int i = 0; i < indice - 1; i++){
                nodoAnterior = nodoAnterior.getSiguiente();
            }
            
            Nodo nodoEliminar = nodoAnterior.getSiguiente();
            nodoAnterior.setSiguiente(nodoEliminar.getSiguiente());
        }
        longitud --;
    }
    
    public int longitud(){
        return longitud;
    }
}