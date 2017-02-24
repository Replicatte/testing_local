/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puntos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author joralgra
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private GridPane gp1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gp1.setOnMouseMoved((event) -> {
            label.setText("(" + (int)((event.getSceneX()-gp1.getLayoutX())/(gp1.getWidth()/3))+ "," + (int)((event.getSceneY()-gp1.getLayoutY())/(gp1.getHeight()/3)) + ")");
        });
        
    }    
    
}
