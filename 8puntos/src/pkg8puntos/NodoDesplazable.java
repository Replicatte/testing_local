/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puntos;

import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author repli
 */
public class NodoDesplazable extends Button {
    
   
    double x = 0;
    double y = 0;

    double mousex = 0;
    double mousey = 0;

    @Override
    protected ObservableList<Node> getChildren() {
        return super.getChildren(); //To change body of generated methods, choose Tools | Templates.
    }

    public NodoDesplazable() {
        super();

        onMousePressedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousex = getLayoutX();
                mousey = getLayoutY();
            }

        });

        onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x += event.getSceneX() - mousex;
                y += event.getSceneX() - mousey;

                setLayoutX(x);
                setLayoutY(y);
                mousex= event.getSceneX();
                mousey = event.getSceneY();
            }

        });

    }

}
