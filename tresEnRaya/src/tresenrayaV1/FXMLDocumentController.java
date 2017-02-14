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
import static tresenrayaV1.TresEnRaya.juego;

/**
 *
 * @author repli
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public Button top_left;
    @FXML
    public Button top_center;
    @FXML
    public Button top_right;
    @FXML
    public Button center_left;
    @FXML
    public Button center_center;
    @FXML
    public Button center_right;
    @FXML
    public Button bottom_left;
    @FXML
    public Button bottom_center;
    @FXML
    public Button bottom_right;

    void setLabel(int turnoActual) {

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
    public Label texto_top;

    @FXML
    private void top_left_clicked(ActionEvent event) {
        int estadoBoton = juego.getTop_leftState().getState();

        if (estadoBoton == State.MODO_UNSEL) {

            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getTop_leftState().pulsaO();
            } else {
                juego.getTop_leftState().pulsaX();
            }
            top_left.setText(juego.getSimbTurno());
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal AL TURNO NUEVO

        }
    }

    @FXML
    private void top_center_clicked(ActionEvent event) {
        int estadoBoton = juego.getTop_centerState().getState();

        if (estadoBoton == State.MODO_UNSEL) {

            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getTop_centerState().pulsaO();
            } else {
                juego.getTop_centerState().pulsaX();
            }

            top_center.setText(juego.getSimbTurno());
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal

        }
    }

    @FXML
    private void top_right_clicked(ActionEvent event) {
        int estadoBoton = juego.getTop_rightState().getState();

        if (estadoBoton == State.MODO_UNSEL) {

            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getTop_rightState().pulsaO();
            } else {
                juego.getTop_rightState().pulsaX();
            }

            top_right.setText(juego.getSimbTurno());
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal

        }
    }

    @FXML
    private void center_left_clicked(ActionEvent event) {
        int estadoBoton = juego.getCenter_leftState().getState();

        if (estadoBoton == State.MODO_UNSEL) {
            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getCenter_leftState().pulsaO();
            } else {
                juego.getCenter_leftState().pulsaX();
            }

            center_left.setText(juego.getSimbTurno());
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal

        }
    }

    @FXML
    private void center_center_clicked(ActionEvent event) {
        int estadoBoton = juego.getCenter_centerState().getState();

        if (estadoBoton == State.MODO_UNSEL) {
            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getCenter_centerState().pulsaO();
            } else {
                juego.getCenter_centerState().pulsaX();
            }
            center_center.setText(juego.getSimbTurno());
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal

        }
    }

    @FXML
    private void center_right_clicked(ActionEvent event) {
        int estadoBoton = juego.getCenter_rightState().getState();

        if (estadoBoton == State.MODO_UNSEL) {

            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getCenter_rightState().pulsaO();
            } else {
                juego.getCenter_rightState().pulsaX();
            }
            center_right.setText(juego.getSimbTurno());
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal

        }
    }

    @FXML
    private void bottom_left_clicked(ActionEvent event) {
        int estadoBoton = juego.getBottom_leftState().getState();

        if (estadoBoton == State.MODO_UNSEL) {
            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getBottom_leftState().pulsaO();
            } else {
                juego.getBottom_leftState().pulsaX();
            }
            bottom_left.setText(juego.getSimbTurno());
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal

        }
    }

    @FXML
    private void bottom_center_clicked(ActionEvent event) {
        int estadoBoton = juego.getBottom_centerState().getState();

        if (estadoBoton == State.MODO_UNSEL) {

            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getBottom_centerState().pulsaO();
            }
            if (juego.getTurno() == GameState.TURNO_O) {
                juego.getBottom_centerState().pulsaX();
            }

            bottom_center.setText(juego.getSimbTurno());
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal

        }
    }

    @FXML
    private void bottom_right_clicked(ActionEvent event) {
        // coje el estado actual del boton
        int estadoBoton = juego.getBottom_rightState().getState();

        if (estadoBoton == State.MODO_UNSEL) {
            //si el boton no se ha emplado anteriormente

            if (juego.getTurno() == GameState.TURNO_O) {//cambia el boton según el modo actual
                juego.getBottom_rightState().pulsaO();
            }

            if (juego.getTurno() == GameState.TURNO_X) {
                juego.getBottom_rightState().pulsaX();
            }

            bottom_right.setText(juego.getSimbTurno()); //pon el texto de el boton conforme el actual turno
            setLabel(juego.pasaTurno()); //pasa el turno y cambia el label principal al nuevo turno

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
