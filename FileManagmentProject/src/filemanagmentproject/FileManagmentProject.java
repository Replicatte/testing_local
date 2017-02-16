/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentproject;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repli
 */
public class FileManagmentProject {
    //RECUERDA EL 1 BYTE - 1 STRING

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Escritor paco = new Escritor("files/file1.pene");
        paco.enchufaTexto("\t");

        Lector maripaz = new Lector("files/file1.pene");

        String datos;
        System.out.println(maripaz.efecuaLecturaByte()[0]);
        try {
            datos = new String(maripaz.efecuaLecturaByte(),"UTF-8");
            System.out.println("" + datos);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileManagmentProject.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Saca el primer byte
    }

}
