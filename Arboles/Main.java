public class Main {
    public static void main(String[] args) {
        String raiz = "A";
        Arbol<String> arbol = new Arbol<String>(raiz, false);
        NodoArbol<String> B = new NodoArbol<String>("B");
        NodoArbol<String> C = new NodoArbol<String>("C");
        NodoArbol<String> D = new NodoArbol<String>("D");
        NodoArbol<String> E = new NodoArbol<String>("E");
        NodoArbol<String> F = new NodoArbol<String>("F");
        NodoArbol<String> G = new NodoArbol<String>("G");
        NodoArbol<String> H = new NodoArbol<String>("H");
        NodoArbol<String> I = new NodoArbol<String>("I");
        NodoArbol<String> J = new NodoArbol<String>("J");
        NodoArbol<String> K = new NodoArbol<String>("K");
        NodoArbol<String> L = new NodoArbol<String>("L");
        NodoArbol<String> M = new NodoArbol<String>("M");
        NodoArbol<String> N = new NodoArbol<String>("N");
        NodoArbol<String> O = new NodoArbol<String>("O");
        NodoArbol<String> P = new NodoArbol<String>("P");
        NodoArbol<String> Q = new NodoArbol<String>("Q");

        arbol.agregarNodoArbol(arbol.obtenerRaiz(), B);
        arbol.agregarNodoArbol(arbol.obtenerRaiz(), C);
        arbol.agregarNodoArbol(arbol.obtenerRaiz(), D);

        arbol.agregarNodoArbol(B, E);
        arbol.agregarNodoArbol(B, F);

        arbol.agregarNodoArbol(F, J);
        arbol.agregarNodoArbol(F, K);
        arbol.agregarNodoArbol(F, L);

        arbol.agregarNodoArbol(D, G);
        arbol.agregarNodoArbol(D, H);
        arbol.agregarNodoArbol(D, I);

        arbol.agregarNodoArbol(G, M);

        arbol.agregarNodoArbol(M, P);
        arbol.agregarNodoArbol(M, Q);

        arbol.agregarNodoArbol(I, N);
        arbol.agregarNodoArbol(I, O);

        System.out.println("Impresion en prefijo");
        arbol.imprimirArbol(Recorrido.PREFIJO);
        System.out.println("Impresion en infijo");
        arbol.imprimirArbol(Recorrido.INFIJO);
        System.out.println("Impresion en posfijo");
        arbol.imprimirArbol(Recorrido.POSFIJO);
    }
}
