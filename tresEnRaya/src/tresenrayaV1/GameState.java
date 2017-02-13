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
    

    private State top_left;
    private State top_center;
    private State top_right;
    private State center_left;
    private State center_center;
    private State center_right;
    private State bottom_left;
    private State bottom_center;
    private State bottom_right;

    public final static int TURNO_X = 1;
    public final static int TURNO_O = 2;

    public final static int GANADOR_X = 3;
    public final static int GANADOR_O = 4;
    
    public int turnoActual = -1;
    

    public void initGameState() {
        turnoActual = Misc.generaAleat(TURNO_O, TURNO_X);
        
        FXMLDocumentController.setLabel(turnoActual);
        
        top_left = new State(State.MODO_UNSEL, "11");
        top_center = new State(State.MODO_UNSEL, "12");
        top_right = new State(State.MODO_UNSEL, "13");
        center_left = new State(State.MODO_UNSEL, "21");
        center_center = new State(State.MODO_UNSEL, "22");
        center_right = new State(State.MODO_UNSEL, "23");
        bottom_left = new State(State.MODO_UNSEL, "31");
        bottom_center = new State(State.MODO_UNSEL, "32");
        bottom_right = new State(State.MODO_UNSEL, "33");

    }

    
    
    public void pasaTurno() {

        checkWin();

        if (turnoActual == TURNO_X) {
            turnoActual = TURNO_O;
        } else {
            turnoActual = TURNO_X;
        }

    }

    public int getTurno() {
        return turnoActual;
    }

    public void checkWin() {
        //Hay que comprobar 6 posibles combinaciones
        if (top_left.getState() != State.MODO_UNSEL) {
            if (top_left.getState() == top_center.getState() && top_center.getState() == top_right.getState()) {
                if (top_left.getState() == State.MODO_O) {
                    winsO();
                } else {
                    winsX();
                }

            }

            if (top_left.getState() == center_left.getState() && center_left.getState() == bottom_left.getState()) {
                if (top_left.getState() == State.MODO_O) {
                    winsO();
                } else {
                    winsX();
                }

            }

            if (top_left.getState() == center_center.getState() && center_center.getState() == bottom_right.getState()) {
                if (top_left.getState() == State.MODO_O) {
                    winsO();
                } else {
                    winsX();
                }

            }

        }
        
        if (bottom_right.getState() != State.MODO_UNSEL) {
            if (bottom_right.getState() == center_right.getState() && center_right.getState() == top_right.getState()) {
                if (bottom_right.getState() == State.MODO_O) {
                    winsO();
                } else {
                    winsX();
                }

            }
            if (bottom_right.getState() == bottom_center.getState() && bottom_center.getState() == bottom_left.getState()) {
                if (bottom_right.getState() == State.MODO_O) {
                    winsO();
                } else {
                    winsX();
                }

            }
        }
        
        if (center_center.getState() != State.MODO_UNSEL) {
            
            if (bottom_left.getState() == center_center.getState() && center_center.getState() == top_right.getState()) {
                if (bottom_right.getState() == State.MODO_O) {
                    winsO();
                } else {
                    winsX();
                }

            }
        }
    }

    private void winsO() {
        System.out.println("O WINS");
    }

    private void winsX() {
        System.out.println("X WINS");
    }

}
