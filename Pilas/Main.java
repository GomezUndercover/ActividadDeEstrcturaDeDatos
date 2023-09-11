public class Main {
    public static void main(String[] args) {
        
        // se instancia la clase pila

        Pila pila = new Pila();
        
        // se crea un array con los elementos que indica el maestro
        int[] datosDePila = {14, 27, 1, 15, 10, 90, 71, 37, 2, 48};

        // se inserta cada elemento del array a la pila
        for (int i = 0; i < datosDePila.length; i++) {
            pila.insertar(datosDePila[i]);
        }

        System.out.println("1.- Se imprimir\u00E1 el tama\u00F1o de la Pila.");
        System.out.println("> " + pila.getSize() + "\n");
        System.out.println("Impresion de la pila con todos sus elementos: ");

        while (!pila.estaVacia()) {
            System.out.println(pila.obtenerCima());
            pila.quitar();
        }

        // como la impresion de cada elemento de la cima va quitando uno por uno cada nodo, volvemos a meter los datos de nuevo
        // para seguir con la practica sin problemas.
        for (int i = 0; i < datosDePila.length; i++) {
            pila.insertar(datosDePila[i]);
        }

        System.out.println("\n2.- Se quitar\u00E1n 4 elementos \n");
        for (int i = 0; i < 4; i++){
            pila.quitar();
        }

        System.out.println("3.- Se imprimir\u00E1 el elemento de la cima de la pila.");
        System.out.println("> " + pila.obtenerCima() + "\n");

        System.out.println("4.- Se vaciar\u00E1 la pila. \n");
        pila.vaciar();

        System.out.println("5.- Se imprimir\u00E1 si la pila est\u00E1 vac\u00EDa: \n> " + pila.estaVacia());


        // impresion de cada elemento dentro de la pila, probar individualmente para comprobar funcionamiento correcto de nodos y pilas:
        // while (!pila.estaVacia()) {
        //     System.out.println(pila.obtenerCima());
        //     pila.quitar();
        // }
    
    }
}