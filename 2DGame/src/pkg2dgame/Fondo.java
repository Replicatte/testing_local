/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dgame;

import java.awt.Color;
import static java.awt.Color.black;
import java.awt.Image;
import static pkg2dgame.Gameloop.grf;

/**
 *
 * @author repli
 */
public class Fondo{
   private Image img;
    
    public Fondo(String ruta) {
       img = 	(Image) Image.getSource();
    }
    
    
    public void render(){
        grf.drawRect(0, 0, 1280, 720);
    }
    
}
