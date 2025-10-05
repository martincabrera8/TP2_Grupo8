package Modelo;

import Interfaz.IPersona;

public class Persona implements IPersona, Comparable<Persona> {


    private int dni;
    private String nombre;

    /*nos sirve como bandera para saber como armamos el arbol si por dni o por nombre*/
    public static boolean compararPorDni = true;

    /*creamos a la persona con su dni y nombre*/
    public Persona(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    /*creamos los getters y setters*/
    /*--------------------------------------------*/

    @Override
    public int getDni() {
        return dni;
    }
    @Override
    public void setDni(int dni) {
        this.dni = dni;
    }
    /*--------------------------------------------*/

    /*--------------------------------------------*/
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /*--------------------------------------------*/


    /**
     * dependiendo si se eligio la opcion 1 o 2 en el main, le indicamos gracias a la bandera que manera de ordenar usar
     * encontramos la variable de opcion como int opcion = sc.nextInt(); en la linea 21
     * */

    @Override
    public int compareTo(Persona otra) {

        if (compararPorDni) {
            // comparamos por dni, le indicamos que compare el dni con el dni de la otra persona  de esa manera sabe como ordenarlos
            return Integer.compare(this.dni, otra.dni);
        } else {
            // comparamos por nombre, igual a dni y aca para evitar dos nombres iguales hacemos doble comparacion
            int primeraComparacion = this.nombre.compareToIgnoreCase(otra.nombre);
            if (primeraComparacion != 0) return primeraComparacion;
            // Desempatar por DNI para no confundir “Garcia 1” con “Garcia 2”
            return Integer.compare(this.dni, otra.dni);
        }
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre;
    }

    /*--------------------------------------------*/

}
