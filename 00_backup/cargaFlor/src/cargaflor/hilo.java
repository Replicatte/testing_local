/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargaflor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repli
 */
public class hilo extends Thread{

    @Override
    public void run() {
        while(true){
            Main.win.setBounds((int)(Math.random()*1000), (int)(Math.random()*1000+600), 800, 600);
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
