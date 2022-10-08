/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Util.LSE;
import Util.SerializarPersona;
import Util.SerializarSillas;

/**
 *
 * @author HP
 */
public class Teatro {

    Silla[][] sillas;
    LSE<Persona> listaPersona;
    SerializarSillas serializarSilla;
    SerializarPersona serializarPersona;

    public Teatro() {
        sillas = new Silla[6][6];
        listaPersona = new LSE<>();
        serializarSilla = new SerializarSillas();
        serializarPersona = new SerializarPersona();
        initSillas();

        try {
            listaPersona = serializarPersona.leerPersonas();
            sillas = serializarSilla.leerSilla();

        } catch (Exception e) {
            listaPersona = new LSE<>();
            System.out.println(e.getMessage());
        }
    }

    private void initSillas() {
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[0].length; j++) {
                sillas[i][j] = new Silla();

            }

        }
    }

    public Persona buscarPersona(String cedula) {
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[0].length; j++) {
                if (sillas[i][j].getPersona() != null && sillas[i][j].getPersona().getCedula().equals(cedula)) {
                    return sillas[i][j].getPersona();

                }

            }

        }
        return null;
    }

    public boolean agregarPersona(Persona persona, Silla silla) {
        Persona aux = buscarPersona(persona.getCedula());
        if (aux == null) {
            silla.setPersona(persona);
            silla.setEstado(false);
            listaPersona.agregar(persona);
            serializarPersona.escritor(listaPersona);
            serializarSilla.escritor(sillas);
            return true;

        }
        return false;
    }

    public boolean eliminarPersona(String cedula) {
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[0].length; j++) {
                if (sillas[i][j].getPersona() != null && sillas[i][j].getPersona().getCedula().equals(cedula)) {
                    sillas[i][j].setPersona(null);
                    sillas[i][j].setEstado(true);

                }

            }

        }
        for (int i = 0; i < listaPersona.Size(); i++) {
            if (listaPersona.obtener(i).getCedula().equals(cedula)) {
                listaPersona.eliminar(i);
                serializarPersona.escritor(listaPersona);
                serializarSilla.escritor(sillas);
                return true;

            }

        }
        return false;
    }

    public Persona modificarPersona(String cedula) {
        for (int i = 0; i < listaPersona.Size(); i++) {
            if (listaPersona.obtener(i) != null && listaPersona.obtener(i).getCedula().equals(cedula)) {
                return listaPersona.obtener(i);
            }
        }
        return null;
    }

    public Silla obtenerSilla(int fila, int columna) {
        return sillas[fila][columna];

    }

    public LSE<Persona> getListaPersona() {
        return listaPersona;
    }

    public Silla buscarSilla(String cedula) {
        Silla silla = null;
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {
                if (sillas[i][j].getPersona() != null && sillas[i][j].getPersona().getCedula().equals(cedula)) {
                    silla = sillas[i][j];
                }
            }
        }
        return silla;
    }

    public void escritorSerializar() {
        serializarPersona.escritor(listaPersona);
        serializarSilla.escritor(sillas);
    }
}
