/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed9puntos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author repli
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private VBox pancho;
    @FXML
    private GridPane gp1;
    @FXML
    private Button bt11;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // GridPane.columnIndex="1" GridPane.rowIndex="1"
        int x=0;
        gp1.add(bt11.clone(), 0, 0);
    }    

    @FXML
    private void handleDragDropped(DragEvent event) {
        System.out.println("DD");
        
    }
    
}
