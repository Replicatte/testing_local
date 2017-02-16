/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentproject;

import java.util.ArrayList;

/**
 * Esto clase se encarga de devolver y escribir las lineas de datos de un bloque
 * en un arhivo.
 *
 * @author repli & Saúl
 */
public class FormatHandler {

    private String ruta;//asocia archivo.
    private String blocActiu;//asocia bloque.
    
    private String archivo;

    private final static byte DATOS_X_LINEA = 4;

    private ArrayList lineas;// lineas del bloque activo
    
    //cada linea = String[DATOS_X_LINEA]
    //private String[] datosLinea;

    public FormatHandler(String ruta, String blocActiu) {
        this.ruta = ruta;
        this.blocActiu = blocActiu;
        
        Lector reader = new Lector(this.ruta);
        archivo = reader.efectuaLecturaString();
    }

    public String[] dameLinea(int numLinea) {
        
        if (lineas.get(numLinea) instanceof String) {
            return  ((String) lineas.get(numLinea)).substring(3).split("\t");
        }
        return null;
    }
    
    

    //GETTER && SETTERS <3
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getBlocActiu() {
        return blocActiu;
    }

    public void setBlocActiu(String blocActiu) {
        this.blocActiu = blocActiu;
    }

    public ArrayList getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList lineas) {
        this.lineas = lineas;
    }

}
