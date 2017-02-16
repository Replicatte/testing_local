/**
 * Sample Skeleton for "simple.fxml" Controller Class
 * Use copy/paste to copy paste this code into your favorite IDE
 **/

package cargaflor;

import static cargaflor.Main.win;
import java.awt.Paint;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


public class SimpleController
        
    //HAY QUE LLAMAR UN HILO PARA HACER GESTIÓN DE TODO EVENTO LARGO :)
        
    implements Initializable {

    @FXML //  fx:id="myButton"
    public Button myButton; // Value injected by FXMLLoader
  
    @FXML // fx:id="pane"
    public AnchorPane pane;
    
    
    

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert myButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert pane != null : "Parece ser que no se injecto el root D:";
        // initialize your logic here: all @FXML variables will have been injected
        myButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("BOTON1 PULSADO");
                Border br = new Border(new BorderStroke(javafx.scene.paint.Paint.valueOf(Color.BLACK.toString()),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.FULL));
                myButton.setBorder(br);
                win.setVisible(true);
       
        hilo lol = new hilo();
                lol.start();
            }
        });
        
       
    }

}
