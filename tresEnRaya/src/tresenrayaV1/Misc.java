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
public class Misc {
    
    
    public static int generaAleat(int max, int min){
        //Si se equivoca esto lo corrige
        if (max<min){
            int aux = max;
            max = min;
            min= aux;
        }
        
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
