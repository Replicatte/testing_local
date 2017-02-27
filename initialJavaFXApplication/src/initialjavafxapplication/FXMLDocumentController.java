/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initialjavafxapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author repli
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane pancho;

    @FXML
    private Slider slide;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        slide.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {
                String val = "-fx-background-color:rgb(" + newVal + "," + newVal
                        + "," + newVal + "); -fx-font-color: red";
                pancho.setStyle(val);

            }
        });
        
        
        slide.setOnKeyPressed((KeyEvent arg0) -> {
            System.out.println("CLICK EN TECLA"+ arg0);
        });

        //        slide.valueProperty().addListener((observable, oldVal, newVal)
        //                -> {
        //            System.out.println("" + newVal);
        //        });
    }

}
