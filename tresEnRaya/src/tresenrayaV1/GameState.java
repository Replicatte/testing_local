/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author repli
 */
public class GameState {
    
        State top_left;
        State top_center;
        State top_right = new State(State.MODO_UNSEL,"13");
        State center_left = new State(State.MODO_UNSEL,"21");
        State center_center = new State(State.MODO_UNSEL,"22");
        State center_right = new State(State.MODO_UNSEL,"23");
        State bottom_left = new State(State.MODO_UNSEL,"31");
        State bottom_center  = new State(State.MODO_UNSEL,"32");
        State bottom_right = new State(State.MODO_UNSEL,"33");
    

    public final int TURNO_X = 1;
    public final int TURNO_O = 2;
    
    public final int GANADOR_X = 3;
    public final int GANADOR_O = 4;


    private int turnoActual = -1;

    public GameState() {
        turnoActual = Misc.generaAleat(TURNO_O, TURNO_X);
        top_left = new State(State.MODO_UNSEL,"11");
        top_center = new State(State.MODO_UNSEL,"12");
        top_right = new State(State.MODO_UNSEL,"13");
        center_left = new State(State.MODO_UNSEL,"21");
        center_center = new State(State.MODO_UNSEL,"22");
        center_right = new State(State.MODO_UNSEL,"23");
        bottom_left = new State(State.MODO_UNSEL,"31");
        bottom_center  = new State(State.MODO_UNSEL,"32");
        bottom_right = new State(State.MODO_UNSEL,"33");
        
    }

    public void pasaTurno() {
        
        checkWin();
        
        if(turnoActual == TURNO_X){
            turnoActual = TURNO_O;
        }else{
            turnoActual = TURNO_X;
        }
        
    }
    
    public int getTurno() {
        return turnoActual;
    }
    
    public void checkWin(){
        
    }
    
    
    
}
