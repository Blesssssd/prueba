/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Persona;


/**
 *
 * @author HP
 */
public class SerializarPersona {
    
     public  void escritor(LSE<Persona> listaPersona) {
        try {
            FileOutputStream archivo = new FileOutputStream("Personas.dat");
            ObjectOutputStream escrituraArchivo = new ObjectOutputStream(archivo);
            escrituraArchivo.writeObject(listaPersona);
        } catch (IOException ex) {
            ex.printStackTrace();//detalles de donde sucedio, como sucedio.etc.imprime en consola
        }
    }

   public  LSE<Persona> leerPersonas() throws IOException , ClassNotFoundException {

        LSE<Persona> personas = null;
      
            FileInputStream archivo = new FileInputStream("Personas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            personas = (LSE<Persona>) lector.readObject();
        return personas;
    }
    
}
