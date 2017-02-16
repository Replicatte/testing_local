/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinterficies;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author repli
 */
public class escuchadorDeAccion implements ActionListener{
    Thread t = new Thread();
    public escuchadorDeAccion(Thread t) {
        this.t= t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        t.run();
        System.out.println("FIN");
    }
    
}
