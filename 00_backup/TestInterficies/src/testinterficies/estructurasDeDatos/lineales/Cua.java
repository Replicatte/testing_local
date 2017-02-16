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
public interface Cua<E> {
    
    void encuar(E e);
    E desencuar();
    E primer();
    boolean esBuida();
}
