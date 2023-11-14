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


        System.out.println("---ARBOL GENERICO---");
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
        System.out.println("\nImpresion en infijo");
        arbol.imprimirArbol(Recorrido.INFIJO);
        System.out.println("\nImpresion en posfijo");
        arbol.imprimirArbol(Recorrido.POSFIJO);
        
        System.out.println("*******************************************");

        System.out.println("---ARBOL BINARIO---");

        Arbol<String> arbolBinario = new Arbol<String>(raiz, true);
        NodoArbol<String> B1 = new NodoArbol<String>("B");
        NodoArbol<String> C1 = new NodoArbol<String>("C");
        NodoArbol<String> D1 = new NodoArbol<String>("D");
        NodoArbol<String> E1 = new NodoArbol<String>("E");
        NodoArbol<String> F1 = new NodoArbol<String>("F");
        NodoArbol<String> G1 = new NodoArbol<String>("G");
        NodoArbol<String> H1 = new NodoArbol<String>("H");
        NodoArbol<String> I1 = new NodoArbol<String>("I");
        NodoArbol<String> J1 = new NodoArbol<String>("J");
        NodoArbol<String> K1 = new NodoArbol<String>("K");
        NodoArbol<String> L1 = new NodoArbol<String>("L");
        NodoArbol<String> M1 = new NodoArbol<String>("M");
        NodoArbol<String> N1 = new NodoArbol<String>("N");
        NodoArbol<String> O1 = new NodoArbol<String>("O");
        NodoArbol<String> P1 = new NodoArbol<String>("P");
        NodoArbol<String> Q1 = new NodoArbol<String>("Q");
        arbolBinario.agregarNodoArbol(arbolBinario.obtenerRaiz(), B1);
        arbolBinario.agregarNodoArbol(B1, E1);
        arbolBinario.agregarNodoArbol(B1, C1);

        arbolBinario.agregarNodoArbol(E1, F1);
        arbolBinario.agregarNodoArbol(F1, J1);
        arbolBinario.agregarNodoArbol(J1, K1);
        arbolBinario.agregarNodoArbol(K1, L1);

        arbolBinario.agregarNodoArbol(C1, D1);
        arbolBinario.agregarNodoArbol(D1, G1);

        arbolBinario.agregarNodoArbol(G1, M1);
        arbolBinario.agregarNodoArbol(G1, H1);
        arbolBinario.agregarNodoArbol(M1, P1);
        arbolBinario.agregarNodoArbol(P1, Q1);

        arbolBinario.agregarNodoArbol(H1, I1);
        arbolBinario.agregarNodoArbol(I1, N1);
        arbolBinario.agregarNodoArbol(N1, O1);

        System.out.println("Impresion en prefijo");
        arbolBinario.imprimirArbol(Recorrido.PREFIJO);
        System.out.println("\nImpresion en infijo");
        arbolBinario.imprimirArbol(Recorrido.INFIJO);
        System.out.println("\nImpresion en posfijo");
        arbolBinario.imprimirArbol(Recorrido.POSFIJO);

        System.out.println("\nArbol esta vacio? : " + arbolBinario.estaVacio());
        System.out.println("\nAltura de arbol: " + arbolBinario.obtenerAltura());

        System.out.println("------------------------------------------------");

        System.out.println("Impresion de subarbol a partir del nodo D del arbol binario");
        arbolBinario.imprimirSubArbol(D1);


        
    }
}
