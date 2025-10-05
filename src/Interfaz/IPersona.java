package Interfaz;

import Modelo.Persona;

public interface IPersona {
        public int getDni();
        public void setDni(int dni);

        public String getNombre();
        public void setNombre(String nombre);
        int compareTo(Persona otra);
        String toString();
}
