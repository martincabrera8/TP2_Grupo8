package Modelo;

import Interfaz.IArbol;
import Interfaz.INodo;

public class Arbol<T extends Comparable<T>> implements IArbol<T> {

    /*la raíz del árbol*/
    private INodo<T> raiz;

    /* creamos un arbol vacio*/
    public Arbol() {this.raiz = null;}


    /*--------------------------------------------------------------------*/
    /**llamamos al metodo privado insertarRec que es recursivo
     * lo hacemos mediante el metodo insertar que es publico, asi mantenemos separado el manejo interno
     * */
    @Override
    /**/
    public void insertar(T dato) {raiz = insertarRec(raiz, dato);} /**/

    private INodo<T> insertarRec(INodo<T> nodoRaiz, T dato) {
        if (nodoRaiz == null) { /* verificamos que la raiz sea null*/
            return new Nodo<>(dato); /* si lo esta entonces creamos un nuevo nodo con el dato y se vuelve nuestra raiz */
        }

        /*EN CASO DE YA TENER RAIZ:*/
        /** ACA COMPARAMOS EL DATO NUEVO CON EL DATO DEL NODO QUE YA TENEMOS
         * EN NUESTRI CASO USAMOS EL compareTo DE LA CLASE Persona */

        int comp = dato.compareTo(nodoRaiz.getDato());
        if (comp < 0) {
            nodoRaiz.setIzq(insertarRec(nodoRaiz.getIzq(), dato)); /* si es menor va a la izq*/
        } else if (comp > 0) {
            nodoRaiz.setDer(insertarRec(nodoRaiz.getDer(), dato));/* si es mayor va a la derecha*/
        }
        return nodoRaiz; /*devolvemos el nodo actualizado con las ramas */
    }

    /*--------------------------------------------------------------------*/

    @Override
    /*al igual que insertar usamos el metodo publico eliminar para llamar al metodo privado y recursivo eliminarRec*/
    public void eliminar(T dato) {raiz = eliminarRec(raiz, dato);} /*actualiza la raiz si cambia*/

    private INodo<T> eliminarRec(INodo<T> nodoRaiz, T dato) {
        if (nodoRaiz == null) return null; /*verifica si esta vacia y si lo esta no hay nada para eliminar*/

        int comp = dato.compareTo(nodoRaiz.getDato()); /*comparamos el dato nuevo con el actual*/
        if (comp < 0) {
            nodoRaiz.setIzq(eliminarRec(nodoRaiz.getIzq(), dato)); /*si es menor buscamos a la izq*/
        } else if (comp > 0) {
            nodoRaiz.setDer(eliminarRec(nodoRaiz.getDer(), dato)); /*si es mayor buscamos a la derecha*/
        } else {
            /*en caso de que el nodo sea una hoja lo eliminamos de una*/
            if (nodoRaiz.getIzq() == null && nodoRaiz.getDer() == null) {
                return null;
            }
            /*en el caso de un hijo retornamos ese hijo y lo enlazamos con el padre del nodo que eliminamos asi de esa manera no queda desvinculado*/
            if (nodoRaiz.getIzq() == null) return nodoRaiz.getDer();
            if (nodoRaiz.getDer() == null) return nodoRaiz.getIzq();


            // caso 3: dos hijos
            /**
             * buscamos a la derecha ya que son los valores mas grandes
             * buscamos de los valores de la derecha el mas chico
             * ese valor chico ahora se vuelve el sucesor ya que permite mantener el orden del arbol*/
            INodo<T> sucesor = minValor(nodoRaiz.getDer());
            nodoRaiz.setDato(sucesor.getDato());
            nodoRaiz.setDer(eliminarRec(nodoRaiz.getDer(), sucesor.getDato()));
        }
        return nodoRaiz;
    }

    /*este metodo nos permite buscar el hijo mas chico del lado que nosotros elegimos IZQ O DER */
    private INodo<T> minValor(INodo<T> nodo) {
        INodo<T> actual = nodo;
        /*mientras que a la izq siga existiendo un nodo vamos buscando*/
        while (actual.getIzq() != null) {
            actual = actual.getIzq();
        }
        return actual; /*cuando llegamos al ultimo nodo de la izq ese es el menor y lo retornamos*/
    }
    /*--------------------------------------------------------------------*/


    @Override
    public INodo<T> buscar(T dato) {return buscarRec(raiz, dato);}

    private INodo<T> buscarRec(INodo<T> nodo, T dato) {
        if (nodo == null) return null; /*si no hay nodo entonces el dato no esta*/
        int comp = dato.compareTo(nodo.getDato()); /*comparamos el dato que buscamos con el dato actual*/
        if (comp == 0) return nodo; /*si son iguales lo encontramos*/
        if (comp < 0) return buscarRec(nodo.getIzq(), dato); /* si es menor seguimos buscando a la izq*/
        else return buscarRec(nodo.getDer(), dato); /*si es mayor buscamos a la derecha*/
    }
    /*--------------------------------------------------------------------*/

    @Override
    public void recorridoInorden() {inordenRec(raiz);}
    private void inordenRec(INodo<T> nodo) {
        if (nodo != null) {
            inordenRec(nodo.getIzq());
            System.out.println(nodo.getDato() + " ");
            inordenRec(nodo.getDer());
        }
    }

    /*--------------------------------------------------------------------*/

    @Override
    public void recorridoPreorden() {preordenRec(raiz);}

    private void preordenRec(INodo<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato() + " ");
            preordenRec(nodo.getIzq());
            preordenRec(nodo.getDer());
        }
    }

    /*--------------------------------------------------------------------*/

    @Override
    public void recorridoPostorden() {postordenRec(raiz);}


    private void postordenRec(INodo<T> nodo) {
        if (nodo != null) {
            postordenRec(nodo.getIzq());
            postordenRec(nodo.getDer());
            System.out.println(nodo.getDato() + " ");
        }
    }

    /*--------------------------------------------------------------------*/
}
