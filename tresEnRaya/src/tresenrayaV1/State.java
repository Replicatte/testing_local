/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1;

/**
 *
 * @author repli
 */
public class State {

    void initState() {

    }
    
    
    //posibles estados del boton
    public static final int MODO_X = 1;
    public static final int MODO_O = 2;
    public static final int MODO_UNSEL = 0;
    
    
    //estado de un boton
    private int currentState;
    private String id = "NULL";
    
    //CONSTRUCTOR
    public State(int modo,String nombreBoton) {
        currentState = modo;
        id = nombreBoton;
    }
    
    public void pulsaX(){
        currentState = MODO_X;
    }
    
    public void pulsao(){
        currentState = MODO_O;
    }
}
