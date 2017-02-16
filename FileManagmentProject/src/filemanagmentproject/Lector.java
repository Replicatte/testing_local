/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//Existe un constructor BufferInputStream(new FileInputStream(path),buffersize)
// donde buffersize se escribe en un int con el número de bytes

/**
 *
 * @author repli
 */
public class Lector {

    //Ruta archivo
    private String target;
    private InputStream inStream;// NO FUNCIONAL

    public Lector(String target) {
        this.target = target;
        try {
            inStream = new FileInputStream(target);
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado.");
        }
    }

    public byte[] efecuaLecturaByte() {
        try {
            byte[] data = Files.readAllBytes(new File(target).toPath());
            return data;
        } catch (IOException ioe) {
            System.out.println(" IOException ");
        }
        return null;
    }

    public String efectuaLecturaString() {
        return new String(efecuaLecturaByte());
    }

}
