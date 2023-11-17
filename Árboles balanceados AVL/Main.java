import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArbolAvl avl = new ArbolAvl();
        Scanner sc = new Scanner(System.in);
        int[] datos = { 50, 25, 75, 15, 35, 60, 120, 10, 68, 90, 125, 83, 100 };

        for (int i = 0; i < datos.length; i++) {
            avl.raiz = avl.insertarNodo(avl.raiz, datos[i]);
        }
        System.out.println("Impresion de arbol avl en orden prefijo: ");

        avl.imprimirEnPrefijo(avl.raiz);

        System.out.println("\n\nDigite valor a buscar en el arbol: ");
        int valorBusacdo = sc.nextInt();

        if (avl.buscarNodo(valorBusacdo) == null) {
            System.out.println("El valor no existe en el arbol");
        } else {
            int altura = avl.getAltura(avl.buscarNodo(valorBusacdo));
            System.out.println("El valor fue hallado a la altura: " + altura + " del arbol AVL");
        }

        System.out.println("\nDigite valor eliminar del arbol: ");
        int valorBorrado = sc.nextInt();

        Nodo nodoEliminado = avl.eliminarNodo(avl.raiz, valorBorrado);

        if (nodoEliminado == null) {
            System.out.println("El valor que deseas eliminar no existe en el arbol");
        } else {
            avl.raiz = nodoEliminado;
            System.out.println("El valor fue borrado del arbol AVL");
        }

        System.out.println("\nComprobacion de balanceo despues de elimanar nodo (mismo orden traversal): ");

        avl.imprimirEnPrefijo(avl.raiz);
        sc.close();
    }
}

