/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1.manage;

import java.io.File;
import java.util.ArrayList;

/** Un GameSave por partida al dar al boton Score, se crea un archivo.
 *
 * @author repli
 */
public class GameSave {

    private ArrayList datos;
    private String[] rutas;
    private int numArchivos;

    /* El constructor inicializa los datos sin introducir nada, también
    * inicializa las rutas según el número de ficheros de las partidas.
    */
    public GameSave() {
        datos = new ArrayList();

        File carpeta = new File("saves/");
        File[] listaDeArchivos = carpeta.listFiles();
        numArchivos = listaDeArchivos.length;

        rutas = new String[numArchivos];

    }

    /* Coje el nombre de todas la rutas existentes y las mete en rutas.
    */
    public void refrescaRutas() {
        File carpeta = new File("saves/");
        File[] listaDeArchivos = carpeta.listFiles();

        for (int i = 0; i < listaDeArchivos.length; i++) {
            File listaDeArchivo = listaDeArchivos[i];
            rutas[i] = listaDeArchivo.getName();;

        }

    }

    public static void main(String[] args) {
        GameSave testSave = new GameSave();

        testSave.refrescaRutas();
    }
}
