public class Nodo {
    public int dato;
    public Nodo izquierda;
    public Nodo derecha;
    public int altura;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
        this.altura = 1;
    }
}
