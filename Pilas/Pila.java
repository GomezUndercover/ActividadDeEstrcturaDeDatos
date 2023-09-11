
/*
excepcion que se tira cuando se intenta acceder a un elemento que no existe o que 
no se puede encontrar dentro de la pila, es para evitar tener un codigo no seguro.
*/
import java.util.NoSuchElementException;

public class Pila {

    Nodo cima;
    int size;

    /*
     * este contstructor se utiliza para crear una nueva pila, inicializando cima
     * como null y el tamaño (size) a el valor 0, lo que basicamente
     * nos representa que es una pila nueva vacia.
     */
    public Pila() {
        cima = null;
        size = 0;
    }

    /*
     * este metodo sirve para insertar un nuevo elemento a la pila, en el caso de
     * que este vacia (lo que representa una pila nueva) se crea un nuevo nodo con
     * el valor que se encuentre en el argumento (dato) y se le asigna como la cima
     * de la
     * pila. De lo contrario si la pila ya tiene algun elemento ingresado, se crea
     * un nuevo nodo con el valor del siguente dato
     * y de ahi se vuelve este nodo la cima de la pila, de ahi, se crea un nodo
     * temporal que nos apunta
     * al nodo que se encuentra como la cima en ese momento, despues de esto la cima
     * se actualiza para que nos apunte
     * a nuestro nuevo nodo creado, finalmente al nuevo nodo que se creo se le
     * asigna como la nueva cima de nuestra pila y el tamaño se incrementa por 1.
     */

    public void insertar(int dato) {
        if (estaVacia()) {
            cima = new Nodo(dato);
        } else {
            Nodo temp = cima;
            cima = new Nodo(dato);
            cima.setNodo(temp);
        }
        size++;
    }

    /*
     * Este metodo checa primero si esta vacia la pila, si es el caso nos tira la
     * excepcion "NoSuchElementExcpetion",
     * de lo contrario si la pila contiene datos, nos apunta al nodo que le sigue a
     * la cima y se le
     * disminuye el tamaño a la pila por 1.
     */
    public void quitar() {
        if (estaVacia()) {
            throw new NoSuchElementException();
        } else {
            cima = cima.getNodo();
            size--;
        }
    }

    // funcion que nos arroja un booleano si la pila se encuentra vacia o no.
    public boolean estaVacia() {
        return size == 0;
    }

    // funcion que vacia la pila completamente, asignandole valor nulo a la cima y
    // el tamaño se establece como 0.
    public void vaciar() {
        cima = null;
        size = 0;
    }

    /*
     * funcion que checa si esta vacia la pila, si es el caso arroja la excepcion
     * correspondiente, si no esta vacia
     * simplemente nos retorna el valor del dato que se encuentra en la cima de la
     * pila.
     */

    public int obtenerCima() {
        if (estaVacia()) {
            throw new NoSuchElementException();
        }
        return cima.getDato();
    }

    // funcion que nos retorna el tamaño de la pila
    public int getSize() {
        return size;
    }
}