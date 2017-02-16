/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dgame;

/**
 *
 * @author repli
 */
public class Principal {
    public static Game juego;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        juego = new Game(Game.STATE_ACTIVE, true);
        juego.gameLaunch();
    }
    
}
