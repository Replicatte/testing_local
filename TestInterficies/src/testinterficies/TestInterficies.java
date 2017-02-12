/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinterficies;

import testinterficies.estructurasDeDatos.lineales.ArrayCua;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author repli
 */
public class TestInterficies extends JFrame{
    public TestInterficies(String title){
        super(title);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PARA AÑADIR UNA EJECUCIÓN:
        //añadir boton, añadir boton al panel aquí abajo y escribir función en EjectModulo1.
        TestInterficies win = new TestInterficies("Elige el modulo a ejecutar :");
       
        
        
        Modo modo1 = new Modo("Evaluación" , 1 , new EjectModulo1(1));
        Modo modo2 = new Modo("BufferTest" , 2 , new EjectModulo1(2));
        
        
        JPanel panel = new JPanel(); 
        panel.add(modo1);
        panel.add(modo2);
        
        final int BUTT_WIDTH= 100;
        final int BUTT_HEIGHT = 50;
        
        
        
        win.add(panel);
        
        
        modo1.reSize(0,0,BUTT_HEIGHT, BUTT_WIDTH);
                
        win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        win.setBounds(0, 0, 800, 600);
        win.setVisible(true);
        
        
    }
    
    
    public static long evalua(ArrayList lista){
        Long ini = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            lista.add(1);
            
        }
        
        Long fin= System.nanoTime();
        
        return (fin-ini);

    }
    public static long evalua(ArrayCua lista){
        Long ini = System.nanoTime();
      
        for (int i = 0; i < 100000; i++) {
            lista.encuar(1);
        }
        
        Long fin= System.nanoTime();
        return (fin-ini);
    }

    private static long evalua(int[] lista) {

        Long ini = System.nanoTime();
      
        for (int i = 0; i < 100000; i++) {
            lista[i] = 1;
        }
        
        Long fin= System.nanoTime();
       return (fin-ini);

    }

    private static double mitjaAritmetica(long[] costos) {
        int llarc = costos.length;
        int suma = 0;
        for (int i = 0; i < llarc; i++) {
            suma+= costos[i];
        }
        return (suma / llarc);
    }

    static void module1() {
       
        
        ArrayCua arrayCuaInt = new ArrayCua();
        ArrayList arrayListInt = new ArrayList();
        int[] arrayInt = new int[100000];

        final int NUM_EVALU = 3;
        long[] costosArrayCuaInt = new long[NUM_EVALU];
        long[] costosArrayListInt = new long[NUM_EVALU];
        long[] costosArrayInt = new long[NUM_EVALU];
        
        
        for (int i = 0; i < NUM_EVALU; i++) {
            costosArrayCuaInt[i] = evalua(arrayCuaInt);
        }
        
        for (int i = 0; i < NUM_EVALU; i++) {
            costosArrayListInt[i] = evalua(arrayListInt);
        }
        
        for (int i = 0; i < NUM_EVALU; i++) {
            costosArrayInt[i] = evalua(arrayInt);
        }
        
            System.out.println("Evaluació de ArrayCua(metode propi):");
            System.out.println("" + mitjaAritmetica(costosArrayCuaInt));
            System.out.println("Evaluació de ArrayList(implicit en jdk):");
            System.out.println("" + mitjaAritmetica(costosArrayListInt));
            System.out.println("Evaluació de array de java (Int[]):");
            System.out.println("" + mitjaAritmetica(costosArrayInt));
    }

    
    
}
