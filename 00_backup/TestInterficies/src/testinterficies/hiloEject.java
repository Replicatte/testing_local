/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinterficies;

/**
 *
 * @author repli
 */
public class hiloEject extends Thread{
    protected int n;
    public hiloEject(int n){
        this.n=n;
    }
    
    
    
    public static void ejec(){
        for (int i = 0; i < 3; ++i) {
            new hiloEject(i).start();
        }
    }
    
    public void run(){
        
        for (int i = 0; i < 5; ++i) {
            System.out.println("Fil"+ n +" iteració " + i);
            System.out.println(Thread.currentThread().getName());
            try{
            sleep((n+1)*1000);
            }catch(InterruptedException e){
                System.out.println("Interrupció.");
                
            }
           }   
        System.out.println("FI fil " + n);
    }
}
