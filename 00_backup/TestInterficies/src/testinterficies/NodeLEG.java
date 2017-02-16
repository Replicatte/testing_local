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
public class NodeLEG<E> {
    private NodeLEG<E> seg;
    private E dada;
    
    public NodeLEG(){
        dada = null;
        seg = null;
    }
    
    public NodeLEG(E dada, NodeLEG<E> seg){
        this.dada = dada;
    }
    
    
    //GETTER & SETTER

    public NodeLEG<E> getSeg() {
        return seg;
    }

    public void setSeg(NodeLEG<E> seg) {
        this.seg = seg;
    }

    public E getDada() {
        return dada;
    }

    public void setDada(E dada) {
        this.dada = dada;
    }
    
    
}
