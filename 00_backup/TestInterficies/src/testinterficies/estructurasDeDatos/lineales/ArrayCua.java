/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinterficies.estructurasDeDatos.lineales;

/**
 *
 * @author repli
 */
public class ArrayCua<E> implements Cua<E>{
    
    private E[] elArray;
    private int talla;
    private int primer,ultim;
    
    

    public ArrayCua(){
        talla = 0;
        elArray = (E[]) new Object[64];
        primer = 0;
        ultim = -1; //Ojo!
    }
    
    public ArrayCua(int tamany){
        talla = 0;
        elArray = (E[]) new Object[tamany];
        primer = 0;
        ultim = -1; //Ojo!
    }
    
    
    // Se encua per el ultim.
    @Override   
    public void encuar(E e){
        if (talla == elArray.length) return;
        
        ultim = (ultim + 1) % elArray.length;
        elArray[ultim] = e;
        talla++;
    }
    
    
    //Se desencua per el primer.
    @Override
    public E desencuar(){
        if (talla == 0) return null;
        
        E aTornar = elArray[primer];
        primer = (primer + 1) % elArray.length;
        talla--;
        
        return aTornar;
    }
    
    @Override
    public E primer(){
        if (talla==0) {
            return null;
        }
        return elArray[primer];
    }
    
    @Override
    public boolean esBuida(){
        return talla == 0;
    }
}
