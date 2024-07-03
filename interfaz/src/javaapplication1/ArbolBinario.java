/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Usuario
 */
public class ArbolBinario extends EstructuraDeDato {

    private int altura;
    private NodoArbol nodoRaiz;

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoArbol getNodoRaiz() {
        return nodoRaiz;
    }

    public void setNodoRaiz(NodoArbol nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    @Override
    public void agregarNodo(int valor) {
        if (this.nodoRaiz == null) {
            this.nodoRaiz = new NodoArbol(valor);
        } else {
            this.nodoRaiz.insertarNodo(valor);
        }
    }

    @Override
    public void insertarNodo(int dato, int posicion) {
    }

    @Override
    public void recorrer() {
    }

    @Override
    public void borrarNodo(int posicion) {
        if(nodoRaiz == null){
            return;
        }
        
        nodoRaiz = nodoRaiz.delete(nodoRaiz, posicion);
        recorrerInOrden();
    }

    @Override
    public void limpiar() {
    }

    @Override
    public void modificarNodo(int posicion) {
    }

    @Override
    public void ordenar() {
    }

    @Override
    public void buscarPorDato(int dato) {
    }

    //PreOrden: Raiz, Izquierdo, Derecho
    public void recorrerPreOrden() {
        this.preOrden(this.nodoRaiz);
    }

    private void preOrden(NodoArbol nodo) {
        if (nodo == null) {
            return; //Detener recursividad
        } else {
            System.out.print(nodo.getValor() + " - ");
            preOrden(nodo.getNodoIzquierdo());
            preOrden(nodo.getNodoDerecho());

        }
    }

    //InOrden: Izquierdo, Raiz, Derecho
    public void recorrerInOrden() {
        this.inOrden(this.nodoRaiz);
    }

    private void inOrden(NodoArbol nodo) {
        if (nodo == null) {
            return; //Detener recursividad
        } else {
            inOrden(nodo.getNodoIzquierdo());
            System.out.print(nodo.getValor() + " - ");
            inOrden(nodo.getNodoDerecho());
        }
    }

    //PostOrden: Izquierdo, Derecho, Raiz
    public void recorrerPostOrden() {
        this.postOrden(this.nodoRaiz);
    }

    public void postOrden(NodoArbol nodo) {
        if (nodo == null) {
            return; //Detener recursividad
        } else {
            postOrden(nodo.getNodoIzquierdo());
            postOrden(nodo.getNodoDerecho());
            System.out.print(nodo.getValor() + " - ");
        }
    }
}
