/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1.menu;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tresenrayaV1.TresEnRaya;

/**
 *
 * @author repli
 */
public class ExecMenu extends Thread {

    @Override
    public void run() {
        
        try {
            sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExecMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        Platform.runLater(() -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("FXMLmenu.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ExecMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            
            stage.setTitle("Menu desplegable");
            stage.setAlwaysOnTop(true);
            stage.setResizable(false);
            stage.sizeToScene();
            stage.setX(0);
            stage.setY(0);
            
            stage.show();
        });
 
        
    }

}
