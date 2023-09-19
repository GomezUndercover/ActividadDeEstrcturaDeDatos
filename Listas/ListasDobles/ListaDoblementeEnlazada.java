/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas.ListasDobles;

/**
 *
 * @author ADMIN
 */
public class ListaDoblementeEnlazada {

    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int longitud;

    public ListaDoblementeEnlazada() {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.longitud = 0;
    }

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.setAnterior(ultimoNodo);
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }
        longitud++;
    }

    public int obtener(int indice) {
        if (indice < 0 || indice >= longitud) {
            System.err.println("Indice fuera de rango");
            return -1;
        }
        Nodo nodoActual;
            if (indice < longitud / 2) {
                nodoActual = primerNodo;
                for (int i = 0; i < indice; i++) {
                    nodoActual = nodoActual.getSiguiente();
                }
            }else{
                nodoActual = ultimoNodo;
                for (int i = longitud - 1; i > indice; i--){
                    nodoActual = nodoActual.getAnterior();
                }
            }
            return nodoActual.getDato();
    }

    public void eliminar(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo nodoEliminar;
        if (indice == 0) {
            nodoEliminar = primerNodo;
            primerNodo = primerNodo.getSiguiente();
        } else if (indice == longitud - 1) {
            nodoEliminar = ultimoNodo;
            ultimoNodo = ultimoNodo.getAnterior();
            ultimoNodo.setSiguiente(null);
        } else {
            Nodo nodoActual;
            if (indice < longitud / 2) {
                nodoActual = primerNodo;
                for (int i = 0; i < indice; i++) {
                    nodoActual = nodoActual.getSiguiente();
                }
            }else{
                nodoActual = ultimoNodo;
                for (int i = longitud - 1; i > indice; i--){
                    nodoActual = nodoActual.getAnterior();
                }
            }
            nodoEliminar = nodoActual;
            nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
            nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
        }
        nodoEliminar.setAnterior(null);
        nodoEliminar.setSiguiente(null);
        longitud--;
    }
    
    public int longitud() {
        return longitud;
    }
}
