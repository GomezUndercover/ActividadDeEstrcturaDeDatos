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


        System.out.println("Arbol generico");
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

        System.out.println("Arbol esta vacio? : " + arbol.estaVacio());
        System.out.println("Altura de arbol: " + arbol.obtenerAltura());

        System.out.println("Arbol generico representado como binario");

        Arbol<String> arbolBinario = new Arbol<String>(raiz, true);
        arbolBinario.agregarNodoArbol(arbolBinario.obtenerRaiz(), B);
        arbolBinario.agregarNodoArbol(B, E);
        arbolBinario.agregarNodoArbol(B, F);

        arbolBinario.agregarNodoArbol(E, F);
        arbolBinario.agregarNodoArbol(F, J);
        arbolBinario.agregarNodoArbol(J, K);
        arbolBinario.agregarNodoArbol(K, L);

        arbolBinario.agregarNodoArbol(C, D);
        arbolBinario.agregarNodoArbol(D, G);

        arbolBinario.agregarNodoArbol(G, M);
        arbolBinario.agregarNodoArbol(G, H);
        arbolBinario.agregarNodoArbol(M, P);
        arbolBinario.agregarNodoArbol(P, Q);

        arbolBinario.agregarNodoArbol(H, I);
        arbolBinario.agregarNodoArbol(I, N);
        arbolBinario.agregarNodoArbol(N, O);

        System.out.println("Impresion en prefijo");
        arbolBinario.imprimirArbol(Recorrido.PREFIJO);
        System.out.println("Impresion en infijo");
        arbolBinario.imprimirArbol(Recorrido.INFIJO);
        System.out.println("Impresion en posfijo");
        arbolBinario.imprimirArbol(Recorrido.POSFIJO);

        System.out.println("Arbol esta vacio? : " + arbolBinario.estaVacio());
        System.out.println("Altura de arbol: " + arbolBinario.obtenerAltura());

        
    }
}
