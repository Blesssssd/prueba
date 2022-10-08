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
public class LSE<T> implements Serializable{

    private Nodo<T> primero;
    private int size;//opcional

    public LSE() {
        this.primero = null; //deja saber que la lista no tiene aun elementos agregados
        this.size = 0; //el tamaño debe empezar en cero

    }

    public int Size() {
        return size;
    }

    public void agregar(T dato) { //solo necesita el dato
        Nodo<T> nuevo = new Nodo(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> aux = primero;
            while (aux.getNodoSig() != null) {
                aux = aux.getNodoSig();
            }
            aux.setNodoSig(nuevo);
        }
        size++;
    }

    public T obtener(int index) {
        Nodo<T> auxiliar = primero;
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            if (index == 0) {
                return auxiliar.getDato();

            } else {
                int contador = 0;
                while (contador < index) {
                    auxiliar = auxiliar.getNodoSig();
                    contador++;
                }
            }
            return auxiliar.getDato();
        }

    }

    public boolean eliminar(int index) {

        Nodo aux = primero;
        if (index >= size && index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            if (index == 0) {

                primero = aux.getNodoSig();
                size--;
                return true;
            } else {
                int contador = 0;
                Nodo<T> temporal = aux.getNodoSig();
                while (contador < index - 1) {

                    aux = aux.getNodoSig();
                    temporal = temporal.getNodoSig();
                    contador++;

                }
                aux.setNodoSig(temporal.getNodoSig());
                size--;
            }
        }
        return false;
    }

    public void agregarEnPosicion(T dato, int index) {

        Nodo<T> nuevo = new Nodo(dato);
        Nodo aux = primero;
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (primero == null) {
                primero = nuevo;
            } else if (size  == index) {
                int contador = 0;

                Nodo<T> temporal = aux.getNodoSig();
                while (contador < index - 2) {
                    aux = aux.getNodoSig();
                    temporal = temporal.getNodoSig();
                    contador++;
                }
                aux.setNodoSig(nuevo);
            } else {
                int cont = 0;
                while (cont < index-1) {
                    aux = aux.getNodoSig();
                    cont++;
                }
                Nodo<T> siguiente = aux.getNodoSig();
                aux.setNodoSig(nuevo);
                    nuevo.setNodoSig(siguiente);
                }
            }

        }
    

    public void listar() {
        Nodo<T> aux = primero;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getNodoSig();
        }
    }

//            public void insertarEnPos(EquiposDeFutbol equipos, int pos) {
//        Nodo nodo = new Nodo(equipos);
//        if (inicio == null) {
//            inicio = nodo;
//        } else {
//            Nodo nodoAux = inicio;
//            for (int i = 0; i < pos-1; i++) {
//                nodoAux = nodoAux.siguiente;
//            }
//            nodo.siguiente = nodoAux.siguiente;
//            nodoAux.siguiente = nodo;
//        }
//        longitud++;
//    }
//    public void modificarEnPos(EquiposDeFutbol equipos, int pos) {
//        Nodo nodo = new Nodo(equipos);
//        if (inicio == null) {
//            inicio = nodo;
//        } else {
//            Nodo nodoAux = inicio;
//            for (int i = 0; i < pos-1; i++) {
//                nodoAux = nodoAux.siguiente;
//            }
//            nodoAux.equipo = nodo.equipo;
//
//        }
//    }
}
