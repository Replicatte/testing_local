/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1.menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tresenrayaV1.GameState;
import static tresenrayaV1.TresEnRaya.juego;

/**
 *
 * @author repli
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public  Button npBoton;
    
    @FXML
    private void nuevaPartidaBoton(ActionEvent event) {
        System.out.println("Click nuevaPartida :)");
        juego.reset();
        //Oculta la actual ventana?
        Stage stage = (Stage) npBoton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void salirBoton(ActionEvent event) {
        System.out.println("Click salir :C");
        Platform.exit();

    }

    @FXML
    private void muestraScoreBoton(ActionEvent event) {
        System.out.println("ESTO AÚN NO ESTA IMPLEMENTADO");

        JOptionPane.showMessageDialog(null, "Esto esta por implementar");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
