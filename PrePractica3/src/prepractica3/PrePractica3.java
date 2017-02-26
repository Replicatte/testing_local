/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepractica3;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author repli
 */
public class PrePractica3 extends Application {

    public static int roig;
    public static int verd;
    public static int blau;

    @FXML
    public VBox padre;

    @FXML
    public TextField campoTexto;

    @FXML
    public Slider redSlide;

    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

       
        Scene scene = new Scene(root);
        
        campoTexto.textProperty().bindBidirectional(redSlide.valueProperty(), new NumberStringConverter());
        campoTexto.setText("pene");

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
