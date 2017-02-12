/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinterficies;

import testinterficies.syncro.*;
/**
 *
 * @author repli
 */
public class EjectModulo1 extends Thread {

    private int ID;

    public EjectModulo1(int ID) {
        this.ID = ID;
    }

    @Override
    public void run() {
        switch (ID) {
            case 1:
                TestInterficies.module1();
                break;
            case 2:
                module2();
                break;
            default:
                
        }
    }
    
    public static void module2(){
        Productor prod = new Productor();
        Consumidor cons = new Consumidor();
        
    }

}
