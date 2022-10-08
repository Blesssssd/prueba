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
import modelo.Silla;

/**
 *
 * @author HP
 */
public class SerializarSillas {
    
     public  void escritor(Silla [][] sillas) {
        try {
            FileOutputStream archivo = new FileOutputStream("Sillas.dat");
            ObjectOutputStream escrituraArchivo = new ObjectOutputStream(archivo);
            escrituraArchivo.writeObject(sillas);
        } catch (IOException ex) {
            ex.printStackTrace();//detalles de donde sucedio, como sucedio.etc.imprime en consola
        }
    }

    public Silla [][] leerSilla() throws IOException, ClassNotFoundException {

        Silla[][] sillas = null;

        FileInputStream archivo = new FileInputStream("Sillas.dat");
        ObjectInputStream lector = new ObjectInputStream(archivo);
        sillas = (Silla[][]) lector.readObject();
        return sillas;    }
    
}
