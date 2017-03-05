/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed9puntos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author repli
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("8 Puntos - REPSTAT");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creación sequencia juego
        //1- genera 8 números aleatorió.
        //2- comprueba si son validos
        // --> 2 bucles anidados, derecha mayor izquierda
        // --> si se da x vezes que numeros izq mayor numeros derecha, x debe ser par!!!
        
        
        //estructura Vbox, stackPane amb botoons
        
        launch(args);
    }
    
}
