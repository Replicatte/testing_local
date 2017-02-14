/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ResourceBundle;
import sun.plugin2.message.StartAppletAckMessage;

/**
 *
 * @author repli
 */
public class GameState {

    private State top_leftState;
    private State top_centerState;
    private State top_rightState;
    private State center_leftState;
    private State center_centerState;
    private State center_rightState;
    private State bottom_leftState;
    private State bottom_centerState;
    private State bottom_rightState;

    public final static int TURNO_X = 1;
    public final static int TURNO_O = 2;

    public final static int GANADOR_X = 3;
    public final static int GANADOR_O = 4;

    public static int turnoActual = -1;

    public GameState() {
        turnoActual = TURNO_X;

        top_leftState = new State(State.MODO_UNSEL, "11");
        top_centerState = new State(State.MODO_UNSEL, "12");
        top_rightState = new State(State.MODO_UNSEL, "13");
        center_leftState = new State(State.MODO_UNSEL, "21");
        center_centerState = new State(State.MODO_UNSEL, "22");
        center_rightState = new State(State.MODO_UNSEL, "23");
        bottom_leftState = new State(State.MODO_UNSEL, "31");
        bottom_centerState = new State(State.MODO_UNSEL, "32");
        bottom_rightState = new State(State.MODO_UNSEL, "33");

    }

    public int pasaTurno() {

        checkWin();

        if (turnoActual == TURNO_X) {
            turnoActual = TURNO_O;
        } else {
            if (turnoActual == TURNO_O) {
                turnoActual = TURNO_X;
            }
        }

        return turnoActual;
    }

    public State getTop_leftState() {
        return top_leftState;
    }

    public State getTop_centerState() {
        return top_centerState;
    }

    public State getTop_rightState() {
        return top_rightState;
    }

    public State getCenter_leftState() {
        return center_leftState;
    }

    public State getCenter_centerState() {
        return center_centerState;
    }

    public State getCenter_rightState() {
        return center_rightState;
    }

    public State getBottom_leftState() {
        return bottom_leftState;
    }

    public State getBottom_centerState() {
        return bottom_centerState;
    }

    public State getBottom_rightState() {
        return bottom_rightState;
    }

    public static int getTurnoActual() {
        return turnoActual;
    }

    public int getTurno() {
        return turnoActual;
    }

    public void checkWin() {
        int tl = top_leftState.getState();
        int tc = top_centerState.getState();
        int tr = top_rightState.getState();

        int cl = center_leftState.getState();
        int cc = center_centerState.getState();
        int cr = center_rightState.getState();

        int bl = bottom_leftState.getState();
        int bc = bottom_centerState.getState();
        int br = bottom_rightState.getState();
        
        
        if (tl == tc
                && tc == tr) {
            if (tr == State.MODO_O) {
                winsO();
            }
            if (tr == State.MODO_X) {
                winsX();
            }
        }

    }
    //Hay que comprobar 6 posibles combinaciones
//        
//        
//        if (top_leftState.getState() != State.MODO_UNSEL) {
//            if (top_leftState.getState() == top_centerState.getState() && top_centerState.getState() == top_rightState.getState()) {
//                if (turnoActual == TURNO_O) {
//                    winsO();
//                } else {
//                    winsX();
//                }
//
//            }
//
//            if (top_leftState.getState() == center_leftState.getState() && center_leftState.getState() == bottom_leftState.getState()) {
//                if (turnoActual == TURNO_O) {
//                    winsO();
//                } else {
//                    winsX();
//                }
//
//            }
//
//            if (top_leftState.getState() == center_centerState.getState() && center_centerState.getState() == bottom_rightState.getState()) {
//                if (turnoActual == TURNO_O) {
//                    winsO();
//                } else {
//                    winsX();
//                }
//
//            }
//
//        }
//        
//        if (bottom_rightState.getState() != State.MODO_UNSEL) {
//            if (bottom_rightState.getState() == center_rightState.getState() && center_rightState.getState() == top_rightState.getState()) {
//                if (turnoActual == TURNO_O) {
//                    winsO();
//                } else {
//                    winsX();
//                }
//
//            }
//            if (bottom_rightState.getState() == bottom_centerState.getState() && bottom_centerState.getState() == bottom_leftState.getState()) {
//                if (turnoActual == TURNO_O) {
//                    winsO();
//                } else {
//                    winsX();
//                }
//
//            }

//        if (center_centerState.getState() != State.MODO_UNSEL) {
//            
//            if (bottom_leftState.getState() == center_centerState.getState() && center_centerState.getState() == top_rightState.getState()) {
//                if (turnoActual == TURNO_O) {
//                    winsO();
//                } else {
//                    winsX();
//                }
//
//            }
//        }
//    }
    private void winsO() {
        turnoActual = GANADOR_O;
        System.out.println("O WINS");
    }

    private void winsX() {
        turnoActual = GANADOR_X;
        System.out.println("X WINS");
    }

    String getSimbTurno() {
        switch (turnoActual) {
            case TURNO_O:
                return "O";
            case TURNO_X:
                return "X";
        }
        return " - ";
    }

}
