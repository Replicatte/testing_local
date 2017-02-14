/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.event.ChangeListener;

/**
 *
 * @author repli
 */
public class TresEnRaya extends Application {

    @FXML
    public BorderPane padreNuestro;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root, 450, 600);

        stage.setScene(scene);
        
        try {
            stage.showingProperty().addListener(new javafx.beans.value.ChangeListener<Boolean>() {

                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean showing) {
                    if (showing) {
                        stage.setMinHeight(stage.getHeight());
                    }
                    stage.setMinWidth(stage.getWidth());
                    stage.setTitle("Tamaño minimo: W->" + stage.getMinWidth() + " H->" + stage.getMinHeight());
                }
            });
        }catch(Exception e){
            System.out.println("SIDA.");
        }
        //stage.minWidthProperty().bind(padreNuestro.prefWidthProperty());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
