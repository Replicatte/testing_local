/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author repli
 */
public class Escritor {

    private String target;
    private FileOutputStream outStream;

    public Escritor(String target) {
        this.target = target;

    }

    public void escribirEnArchivo(byte[] lolis) {

        try {

            outStream = new FileOutputStream(target, false);

            File archivo = new File(target);

            outStream.write(lolis);
            outStream.close();

        } catch (FileNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "Archivo no encontrado ( en la escritura )");

        } catch (IOException io) {
            
            io.printStackTrace();
        }

    }

    public void enchufaTexto(String text) {
        byte[] res = text.getBytes();

        escribirEnArchivo(res);
    }
    
    public void enchufaBytes(byte[] bytes) {
        escribirEnArchivo(bytes);
    }
    
    

}
