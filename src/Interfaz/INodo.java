package Interfaz;

public interface INodo<T> {

    T getDato();
    void setDato(T dato);

    INodo<T> getIzq();
    INodo<T> getDer();

    void setIzq(INodo<T> izq);
    void setDer(INodo<T> der);
}
