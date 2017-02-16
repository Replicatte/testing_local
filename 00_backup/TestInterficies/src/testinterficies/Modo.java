/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinterficies;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author repli
 */
public class Modo extends JButton {

    private String texto;
    private int numBoton;

    public Modo(String texto, int numBoton, Thread ejec) {
        super(texto + " - modo_" + numBoton);
        this.texto = texto;
        this.numBoton = numBoton;
        this.addActionListener(new escuchadorDeAccion(ejec));
    }

    public void reSize(int x, int y, int width, int height) {
        this.setBounds(0, 200, width, height);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNumBoton() {
        return numBoton;
    }

    public void setNumBoton(int numBoton) {

        this.setText(texto + " - " + numBoton);
        this.numBoton = numBoton;

    }

}
