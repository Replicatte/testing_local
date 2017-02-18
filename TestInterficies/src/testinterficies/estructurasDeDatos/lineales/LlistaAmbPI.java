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
public interface LlistaAmbPI<E> {
    
    public void inserir(E e);
    
    public void eliminar();
    
    public E recuperar();
    
    public void inici();
    
    
    
    
    
    public boolean esBuida();
    
}
