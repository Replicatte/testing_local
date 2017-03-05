/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayaV1;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tresenrayaV1.manage.GameSave;

/**
 *
 * @author repli
 */
public class TresEnRaya extends Application {

    @FXML
    public BorderPane padreNuestro;

    public static GameState juego;
    public static GameSave guardado;

    public static FXMLDocumentController dc;

    public static Stage copyStage;

    @Override
    public void start(Stage stage) throws Exception {

        //+ Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

        Parent root = loader.load();
        dc = loader.getController();
        Scene scene = new Scene(root, 450, 600);

        stage.setScene(scene);
        stage.setTitle("Tres en raya - REPSTAT");

        try {
            stage.showingProperty().addListener((ObservableValue<? extends Boolean> observable,
                    Boolean oldValue, Boolean showing) -> {
                if (showing) {
                    stage.setMinHeight(stage.getHeight());
                }
                stage.setMinWidth(stage.getWidth());
//                stage.setTitle("Tamaño minimo: Ancho->" + stage.getMinWidth() + " Alto->" + stage.getMinHeight());

            });
        } catch (Exception e) {
            System.out.println("No funciono el set de tamaño minimo D:");
        }
        copyStage = stage;
        //stage.minWidthProperty().bind(padreNuestro.prefWidthProperty());
        copyStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        juego = new GameState();
        guardado = new GameSave();
        guardado.refrescaRutas();
        launch(args);
    }

}
