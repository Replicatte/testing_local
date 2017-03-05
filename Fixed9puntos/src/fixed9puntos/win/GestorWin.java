/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed9puntos.win;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

/**
 *
 * @author repli
 */
public class GestorWin extends Thread{
    
    private Stage escena;

    public GestorWin(Stage escena) {
        this.escena = escena;
    }

    @Override
    public void run() {
        escena.show();
        try {
            sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorWin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
