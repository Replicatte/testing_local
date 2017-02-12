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
public class LEGCua<E> {

    NodeLEG<E> primer, ultim;

    public LEGCua() {
        primer = ultim = null;
    }

    public void encuar(E e) {
        NodeLEG<E> nou = new NodeLEG<E>(e, null);

        //si la llista buida
        if (ultim == null || primer == null) {
            primer = ultim = null;
        } else {
            //Afegir a la llista
            ultim.setSeg(nou);
        }

        ultim = nou;
    }

    public E desencuar() {
        if (primer == null) {
            return null;
        }

        E aTornar = primer.getDada();
        primer = primer.getSeg();

        return primer.getDada();
    }

    public E primer() {
        if (primer == null) {
            return null;
        } else {
            return primer.getDada();
        }
    }
    
    public boolean esBuida(){
        return primer == null;
    }
}


