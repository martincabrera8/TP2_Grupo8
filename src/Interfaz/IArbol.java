package Interfaz;

public interface IArbol<T extends Comparable<T>> {
    void insertar(T dato);
    void eliminar(T dato);
    INodo<T> buscar(T dato);

    void recorridoInorden();
    void recorridoPreorden();
    void recorridoPostorden();
}
