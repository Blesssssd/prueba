/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Util.LSE;
import Util.SerializarPersona;
import Util.SerializarSillas;
import modelo.Persona;
import modelo.Silla;
import modelo.Teatro;

/**
 *
 * @author HP
 */
public class ControladorVentanaSillas {

    Teatro teatro;


    public ControladorVentanaSillas() {
        teatro = new Teatro();

    }

    public Persona buscarPersona(String cedula) {
        return teatro.buscarPersona(cedula);

    }

    public boolean agregarPersona(Persona persona, Silla silla) {
        return teatro.agregarPersona(persona, silla);
    }

    public boolean eliminarPersona(String cedula) {
        return teatro.eliminarPersona(cedula);
    }
    
     public Persona modificarPersona(String cedula) {
         return teatro.modificarPersona(cedula);
     }

     public LSE<Persona> getListaPersona() {
        return teatro.getListaPersona();
    }
     
    public Silla obtenerSilla(int fila, int columna) {
        return teatro.obtenerSilla(fila, columna);
    }
    
        
    public Silla buscarSilla(String cedula){
        return teatro.buscarSilla(cedula);
    }

    public void escritorSerializar(){
        teatro.escritorSerializar();
    }
}
