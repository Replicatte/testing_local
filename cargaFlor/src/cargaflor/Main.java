/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargaflor;

import java.io.IOException;
import static java.lang.Thread.sleep;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author repli
 */
public class Main extends Application {
    
    public static Ventana win;

    @Override
    public void init() throws Exception {
        System.out.println("__Init__");
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        System.out.println("__Start__");
        Parent raiz= FXMLLoader.load(getClass().getResource("dos_botones.fxml"));
        
        Scene escena = new Scene(raiz, 600, 400);
        escena.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        primaryStage.setTitle("Esto es el titulo :)!");
        primaryStage.setScene(escena);
        primaryStage.show();
    }
    
    //Solo me hacia falta un push?V2
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        win = new Ventana();
        
        
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("__Stop__");
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
