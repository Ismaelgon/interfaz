import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    Nodo agregarRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = agregarRecursivo(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = agregarRecursivo(raiz.derecho, valor);
        }

        return raiz;
    }

    List<Integer> inorden() {
        List<Integer> resultado = new ArrayList<>();
        inordenRecursivo(raiz, resultado);
        return resultado;
    }

    void inordenRecursivo(Nodo raiz, List<Integer> resultado) {
        if (raiz != null) {
            inordenRecursivo(raiz.izquierdo, resultado);
            resultado.add(raiz.valor);
            inordenRecursivo(raiz.derecho, resultado);
        }
    }

    List<Integer> preorden() {
        List<Integer> resultado = new ArrayList<>();
        preordenRecursivo(raiz, resultado);
        return resultado;
    }

    void preordenRecursivo(Nodo raiz, List<Integer> resultado) {
        if (raiz != null) {
            resultado.add(raiz.valor);
            preordenRecursivo(raiz.izquierdo, resultado);
            preordenRecursivo(raiz.derecho, resultado);
        }
    }

    List<Integer> postorden() {
        List<Integer> resultado = new ArrayList<>();
        postordenRecursivo(raiz, resultado);
        return resultado;
    }

    void postordenRecursivo(Nodo raiz, List<Integer> resultado) {
        if (raiz != null) {
            postordenRecursivo(raiz.izquierdo, resultado);
            postordenRecursivo(raiz.derecho, resultado);
            resultado.add(raiz.valor);
        }
    }
}
