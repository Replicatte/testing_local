/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dgame;

import static pkg2dgame.Principal.juego;

/**
 *
 * @author repli
 */
public class Gameloop extends Thread{
    private static final byte FPS = 30;
    
    private boolean funcionando;
    
    @Override
    public void run() {
        
        while(juego.isActive()){
            
            
            
            
            
            try{
                sleep((long)(1000/FPS));
            }catch(InterruptedException ie){
                System.out.println("Sleep interrumpido en hilo principal.");
            }
        }
    }

    
    
   
}
