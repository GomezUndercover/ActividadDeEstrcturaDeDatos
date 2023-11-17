public class ArbolAvl {

    public Nodo raiz;

    /**
     * Constructor vacio de la clase arbol
     */
    public ArbolAvl() {

        this.raiz = null;
    }

    /**
     * Se busca un nodo con el valor correspondiente ingresado, empezando desde la raiz
     * y dependiendo de si el valor se encuentra en la derecha o izquierda del nodo actual
     * (mayor o menor que el dato del nodo actual) traversa el arbol hasta hallar 
     * el nodo con el dato que se busca.
     *
     * @param valorBuscado 
     * @return Nodo con el valor buscado, retorna nulo si no se encuentra.
     */
    public Nodo buscarNodo(int valorBuscado) {
        Nodo nodoActual = raiz;
        while (nodoActual != null && valorBuscado != nodoActual.dato) {
            if (valorBuscado < nodoActual.dato) {
                nodoActual = nodoActual.izquierda;
            } else {
                nodoActual = nodoActual.derecha;
            }
        }
        return nodoActual;
    }

    /**
     * Inserta un nuevo nodo con el int ingresado en el param, se balancea el arbol
     * al ingresar el nodo y se reacomoda de la manera correspondiente tomando en cuenta altura de cada nodo
     * para calcular el factor de balanceo de cada nodo, el cual solo puede tener valores entre {-1, 0, 1}.
     *
     * @param raiz Nodo raiz del subarbol.
     * @param dato Valor a insertar en el arbol.
     * @return Nodo raiz del subarbol actualizado despues de la insercion.
     */
    public Nodo insertarNodo(Nodo raiz, int dato) {
        if (raiz == null) {
            return new Nodo(dato);
        } else if (dato < raiz.dato) {
            raiz.izquierda = insertarNodo(raiz.izquierda, dato);
        } else {
            raiz.derecha = insertarNodo(raiz.derecha, dato);
        }

        // Actualizamos las alturas del nodo actual
        raiz.altura = 1 + Math.max(getAltura(raiz.izquierda), getAltura(raiz.derecha));

        // Se actualiza el factor de balanceo y se balancea el arbol
        int balanceFactor = getBalanceFactor(raiz);

        if (balanceFactor > 1 && dato < raiz.izquierda.dato) {
            return rightRotate(raiz);
        }

        if (balanceFactor < -1 && dato > raiz.derecha.dato) {
            return leftRotate(raiz);
        }

        if (balanceFactor > 1 && dato > raiz.izquierda.dato) {
            raiz.izquierda = leftRotate(raiz.izquierda);
            return rightRotate(raiz);
        }

        if (balanceFactor < -1 && dato < raiz.derecha.dato) {
            raiz.derecha = rightRotate(raiz.derecha);
            return leftRotate(raiz);
        }

        return raiz;
    }

    /**
     * Elimina un nodo correspondiente con el valor proporcionado.
     *
     * @param raiz Nodo raiz del subárbol.
     * @param dato Valor a eliminar del arbol.
     * @return Nodo raiz del subarbol actualizado despues de la eliminacion.
     */
    public Nodo eliminarNodo(Nodo raiz, int dato) {
        if (raiz == null) {
            return raiz;
        } else if (dato < raiz.dato) {
            raiz.izquierda = eliminarNodo(raiz.izquierda, dato);
        } else if (dato > raiz.dato) {
            raiz.derecha = eliminarNodo(raiz.derecha, dato);
        } else {
            // En en el caso del que el nodo cuente con un solo hijo o sin hijos
            if (raiz.izquierda == null) {
                Nodo nodoTemp = raiz.derecha;
                raiz = null;
                return nodoTemp;
            } else if (raiz.derecha == null) {
                Nodo nodoTemp = raiz.izquierda;
                raiz = null;
                return nodoTemp;
            }

            
            // En el caso de un nodo con dos hijos, se calcula el sucesor en orden (nodo mínimo en el subárbol derecho)
            Nodo tempNodo = getNodoMinimo(raiz.derecha);
            raiz.dato = tempNodo.dato;
            raiz.derecha = eliminarNodo(raiz.derecha, raiz.dato);
        }

        // Actualizar altura del nodo actual
        raiz.altura = 1 + Math.max(getAltura(raiz.izquierda), getAltura(raiz.derecha));

        // Balancear el arbol despues de la eliminacion
        int balanceFactor = getBalanceFactor(raiz);

        // Despues de que se actualizan las alturas de cada nodo y utilizando el factor de balanceo se 
        // acomodan los nodos del arbol para mantenerlo balanceado de acuerdo a las propiedades de un arbol AVL.
        if (balanceFactor > 1 && getBalanceFactor(raiz.izquierda) >= 0) {
            return rightRotate(raiz);
        }

        if (balanceFactor < -1 && getBalanceFactor(raiz.derecha) <= 0) {
            return leftRotate(raiz);
        }

        if (balanceFactor > 1 && getBalanceFactor(raiz.izquierda) < 0) {
            raiz.izquierda = leftRotate(raiz.izquierda);
            return rightRotate(raiz);
        }

        if (balanceFactor < -1 && getBalanceFactor(raiz.derecha) > 0) {
            raiz.derecha = rightRotate(raiz.derecha);
            return leftRotate(raiz);
        }

        return raiz;
    }

    /**
     * Rotacion a la izquierda.
     *
     * @param nodoActual Nodo actual alrededor del cual se realiza la rotación.
     * @return Nueva raiz del subarbol despues de la rotacion.
     */
    public Nodo leftRotate(Nodo nodoActual) {
        Nodo nuevaRaiz = nodoActual.derecha;
        Nodo nodoSubArbol = nuevaRaiz.izquierda;

        nuevaRaiz.izquierda = nodoActual;
        nodoActual.derecha = nodoSubArbol;

        nodoActual.altura = 1 + Math.max(getAltura(nodoActual.izquierda), getAltura(nodoActual.derecha));
        nuevaRaiz.altura = 1 + Math.max(getAltura(nuevaRaiz.izquierda), getAltura(nuevaRaiz.derecha));

        return nuevaRaiz;
    }

    /**
     * Rotacion a la derecha.
     *
     * @param nodoActual Nodo actual alrededor del cual se realiza la rotacion.
     * @return Nueva raiz del subárbol despues de la rotacion.
     */
    public Nodo rightRotate(Nodo nodoActual) {
        Nodo nuevaRaiz = nodoActual.izquierda;
        Nodo nodoSubArbol = nuevaRaiz.derecha;

        nuevaRaiz.derecha = nodoActual;
        nodoActual.izquierda = nodoSubArbol;

        nodoActual.altura = 1 + Math.max(getAltura(nodoActual.izquierda), getAltura(nodoActual.derecha));
        nuevaRaiz.altura = 1 + Math.max(getAltura(nuevaRaiz.izquierda), getAltura(nuevaRaiz.derecha));

        return nuevaRaiz;
    }

    /**
     * Obtener altura de algun nodo dentro del arbol.
     * la altura se cuenta desde abajo hacia arriba
     * o mejor dicho, retorna cuantas nodos existe desde el nodo indicado
     * hasta el nodo con menor valor del sub arbol. si es hoja, retorna 1.
     *
     * @param nodo Nodo del cual se obtiene la altura.
     * @return Altura del nodo.
     */
    public int getAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.altura;
    }

    /**
     * Se obtiene el factor de balanceo del arbol AVL tomando en cuenta las alturas
     * de los nodos a la izq y derech del nodo actual, para luego realizar el cambio 
     * para mantener el arbol balanceado
     *
     * @param nodo Nodo del cual se obtiene el factor de balanceo.
     * @return Factor de balanceo del nodo.
     */
    public int getBalanceFactor(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        return (getAltura(nodo.izquierda) - getAltura(nodo.derecha));
    }

    /**
     * Obtiene el nodo minimo del subarbol del nodo dado.
     *
     * @param nodo Nodo raiz del subarbol.
     * @return Nodo minimo en el subarbol.
     */
    public Nodo getNodoMinimo(Nodo nodo) {
        if (nodo == null || nodo.izquierda == null) {
            return nodo;
        }
        return getNodoMinimo(nodo.izquierda);
    }

    /**
     * Imprime los nodos en orden prefija.
     *
     * @param nodo Nodo raiz del subarbol a imprimir.
     */
    public void imprimirEnPrefijo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            imprimirEnPrefijo(nodo.izquierda);
            imprimirEnPrefijo(nodo.derecha);
        }
    }
}
