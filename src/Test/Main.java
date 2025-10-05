package Test;
import Modelo.Arbol;
import Modelo.Persona;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*--------------------------------------------------------------------*/
         /**
         * elegimos si queremos ordenar por dni o por nombre el arbol
         * esto afecta al metodo tipo boolean compararPorDni de la clase Persona
         */

        System.out.println("Cómo queres ordenar el árbol?");
        System.out.println("1- Por DNI");
        System.out.println("2- Por nombre");

        int opcion = sc.nextInt();
        if (opcion == 1) {
            Persona.compararPorDni = true;
        } else {
            Persona.compararPorDni = false;
        }
        /*--------------------------------------------------------------------*/
        /*Creamos el arbol y agregamos personas con su dni y nombre*/

        Arbol<Persona> arbol = new Arbol<>();

        arbol.insertar(new Persona(47321145, "Perez"));
        arbol.insertar(new Persona(38654912, "Garcia"));
        arbol.insertar(new Persona(52198347, "Lopez"));
        arbol.insertar(new Persona(41879236, "Fernandez"));
        arbol.insertar(new Persona(49213875, "Martinez"));
        arbol.insertar(new Persona(36742581, "Rodriguez"));
        arbol.insertar(new Persona(55123489, "Gomez"));
        arbol.insertar(new Persona(43658214, "Diaz"));
        arbol.insertar(new Persona(48951326, "Sanchez"));
        arbol.insertar(new Persona(37842159, "Romero"));
        arbol.insertar(new Persona(46329874, "Torres"));
        arbol.insertar(new Persona(50478632, "Ruiz"));
        arbol.insertar(new Persona(39654281, "Flores"));
        arbol.insertar(new Persona(42785913, "Acosta"));
        arbol.insertar(new Persona(51236489, "Mendoza"));

        /*--------------------------------------------------------------------*/
        /**
         * realizamos los tres recorridos
         */
        System.out.println("Inorden:");
        arbol.recorridoInorden();

        System.out.println("Preorden:");
        arbol.recorridoPreorden();

        System.out.println("Postorden:");
        arbol.recorridoPostorden();

        /*--------------------------------------------------------------------*/

        /* Buscar una persona */
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println(" Buscar persona ");
        Persona buscada = new Persona(38654912, "Garcia");
        if (arbol.buscar(buscada) != null) {
            System.out.println("Encontrado: " + buscada);
        } else {
            System.out.println("No encontrado: " + buscada);
        }

        /* Eliminar una persona*/
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Eliminar persona ");
        Persona eliminar = new Persona(41879236, "Fernandez");
        if (arbol.buscar(eliminar) != null) {
            arbol.eliminar(eliminar);
            System.out.println("Se eliminó: " + eliminar);
        } else {
            System.out.println("No se encontro: " + eliminar);
        }
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");

        /*luego de eliminar recorremos */
        System.out.println(" Recorremos devuelta ");
        System.out.println("Inorden:");
        arbol.recorridoInorden(); System.out.println();
        System.out.println("Preorden:");
        arbol.recorridoPreorden(); System.out.println();
        System.out.println("Postorden:");
        arbol.recorridoPostorden(); System.out.println();

    }
}
