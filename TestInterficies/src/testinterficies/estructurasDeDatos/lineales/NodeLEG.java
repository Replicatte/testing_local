package testinterficies.estructurasDeDatos.lineales;

public class NodeLEG<E> {

    private E dada;
    private NodeLEG<E> seg;

    public NodeLEG() {
        dada = null;
        seg = null;
    }

   

    public NodeLEG(E dada, NodeLEG<E> seg) {
        this.dada = dada;
        this.seg = seg;
    }

    public E getDada() {
        return dada;
    }

    public NodeLEG<E> getSeg() {
        return seg;
    }

    public void setSeg(NodeLEG<E> seg) {
        this.seg = seg;
    }
}
