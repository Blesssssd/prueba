/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Nodo<T> implements Serializable{

    private T dato;
    private Nodo<T> nodoSig;

    public Nodo(T dato) {
        this.dato = dato;
        this.nodoSig = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getNodoSig() {
        return nodoSig;
    }

    public void setNodoSig(Nodo<T> nodoSig) {
        this.nodoSig = nodoSig;
    }

}
