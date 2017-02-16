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
public class Game {

    private boolean activeGame;

    private byte GameState;
    
    private Gameloop hiloPrincipal;

    public static final byte STATE_INACTIVE = 0;
    public static final byte STATE_ACTIVE = 1;
    public static final byte STATE_PAUSED = 2;
    public static final byte STATE_SHOP = 3;
    public static final byte STATE_LEVELING = 4;

    public Game(byte GameState, boolean activeGame) {
        this.GameState = GameState;
        this.activeGame = activeGame;
    }
    
    public void gameLaunch(){
        hiloPrincipal = new Gameloop();
        hiloPrincipal.start();
    }
    
    

    public boolean isActive() {
        return activeGame;
    }
}
