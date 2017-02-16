/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dgame.ventana;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author repli
 */
public class Ventana extends JFrame {

    public static final short FRAME_HEIGHT = 1920;
    public static final short FRAME_WIDTH = 1080;
    
    
    
    public Ventana() throws HeadlessException {
        setBounds(WIDTH, WIDTH, FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
    }
    
    
    

}
