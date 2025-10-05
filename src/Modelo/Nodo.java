package Modelo;
import Interfaz.INodo;

public class Nodo<T> implements INodo<T>{
    private T dato;
    private INodo<T> izq;
    private INodo<T> der;

    /* creamos el constructor */
    public Nodo(T dato) {
        this.dato = dato;
    }


    /* creamos los setter y getter */
    /*--------------------------------------------*/
    @Override
    public INodo<T> getIzq() {
        return izq;
    }
    @Override
    public void setIzq(INodo<T> izq) {
        this.izq = izq;
    }
    /*--------------------------------------------*/
    @Override
    public INodo<T> getDer() {
        return der;
    }
    @Override
    public void setDer(INodo<T> derecho) {
        this.der = derecho;
    }
    /*--------------------------------------------*/
    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }
    /*--------------------------------------------*/

}
