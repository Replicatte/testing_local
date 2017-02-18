/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1.manage;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author repli
 */
public class GameSave {

    private ArrayList datos;
    private String[] rutas;
    private int numArchivos;

    public GameSave() {
        datos = new ArrayList();

        File carpeta = new File("saves/");
        File[] listaDeArchivos = carpeta.listFiles();
        numArchivos = listaDeArchivos.length;

        rutas = new String[numArchivos];

    }

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
