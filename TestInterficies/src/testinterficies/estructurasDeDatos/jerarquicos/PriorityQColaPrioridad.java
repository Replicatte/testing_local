/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinterficies.estructurasDeDatos.jerarquicos;

// comprueba que lo has puesto en el lugar correcto
// package librerias.estructurasDeDatos.jerarquicos;
import java.util.PriorityQueue;

/**
 * Implementacion de una Cola de Prioridad mediante una PriorityQueue (Heap)
 *
 * @version Febrero 2017
 * @param <E> tipo de datos de la estructura, debe implementar Comparable<E>
 */
public class PriorityQColaPrioridad<E extends Comparable<E>>
        extends PriorityQueue {

    /**
     * crea una Cola de Prioridad (CP) vacia
     */
    public PriorityQColaPrioridad() {
        super();
    }

    /**
     * atendiendo a su prioridad, inserta el Elemento e en una Cola de Prioridad
     * (CP)
     *
     * @param e Elemento a agnadir a una Cola de Prioridad
     */
    public void insertar(E e) {
        try {
            this.add(e);
        } catch (Exception err) {
            System.out.println("Error " + err);
        }
    }

    /**
     * SII !esVacia(): obtiene el Elemento con maxima prioridad de una CP
     *
     * @return E Elemento con maxima prioridad de una CP
     */
    public E recuperarMin() {
        return (E) peek();
    }

    /**
     * SII !esVacia(): obtiene y elimina el Elemento con maxima prioridad de una
     * CP
     *
     * @return E Elemento con maxima prioridad de una CP
     */
    public E eliminarMin() {
        return (E) poll();
    }

    /**
     * comprueba si una Cola de Prioridad esta vacia
     *
     * @return true si una CP esta vacia y false en caso contrario
     */
    public boolean esVacia() {
        return size() == 0;
    }

}
