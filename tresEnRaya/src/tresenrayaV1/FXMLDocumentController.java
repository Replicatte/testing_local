/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author repli
 */
public class FXMLDocumentController implements Initializable {
    
    static void setLabel(int turnoActual) {

        switch (turnoActual) {
            case GameState.TURNO_O:
                texto_top.setText("Turno O");
                break;
            case GameState.TURNO_X:
                texto_top.setText("Turno X");
                break;
            default:
                System.out.println("ERROR EN LA GESTIÓN DE TURNO");
        }
    }

    @FXML
    public static Label texto_top;

    @FXML
    private void top_left_clicked(ActionEvent event) {

        System.out.println("11 CLICK");
    }

    @FXML
    private void top_center_clicked(ActionEvent event) {

        System.out.println("12 CLICK");
    }

    @FXML
    private void top_right_clicked(ActionEvent event) {

        System.out.println("13 CLICK");
    }

    @FXML
    private void center_left_clicked(ActionEvent event) {

        System.out.println("21 CLICK");
    }

    @FXML
    private void center_center_clicked(ActionEvent event) {

        System.out.println("22 CLICK");
    }

    @FXML
    private void center_right_clicked(ActionEvent event) {

        System.out.println("23 CLICK");
    }

    @FXML
    private void bottom_left_clicked(ActionEvent event) {

        System.out.println("31 CLICK");
    }

    @FXML
    private void bottom_center_clicked(ActionEvent event) {

        System.out.println("32 CLICK");
    }

    @FXML
    private void bottom_right_clicked(ActionEvent event) {

        System.out.println("33 CLICK");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
