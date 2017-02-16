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
public class GameSave extends File{
    private ArrayList datos;

    public GameSave(String pathname) {
        super(pathname);
        datos = new ArrayList();
    }
    
    
}
