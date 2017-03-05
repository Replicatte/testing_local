/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed9puntos;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author repli
 */
public class Main extends Application {

    public static double mainStageX;
    public static double mainStageY;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root);

        stage.setScene(scene);
//        gp1.heightProperty().addListener((obs, oldVal, newVal) -> gp1.setPrefSize((double)newVal,(double)newVal));
        stage.xProperty().addListener((obs, oldVal, newVal) -> mainStageX = (double) newVal);
        stage.yProperty().addListener((obs, oldVal, newVal) -> mainStageY = (double) newVal);

        stage.setTitle("8 Puntos - REPSTAT");
//        double ratio = 0.701425373; //47w:67h

//        scene.widthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
//                stage.setHeight(((double) newSceneWidth * 67) / 47);
//                System.out.println(stage.getWidth() + "w  - " + stage.getHeight() + "h");
//
//            }
//        });
//        scene.heightProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
////                stage.setWidth((double) newSceneHeight * ratio);
//                stage.setWidth(((double) newSceneHeight*(47/67)) );
//            }
//        });
//        try {
//            stage.showingProperty().addListener((ObservableValue<? extends Boolean> observable,
//                    Boolean oldValue, Boolean showing) -> {
//                if (showing) {
//                    stage.setMinHeight(stage.getHeight());
//                }
//                stage.setMinWidth(stage.getWidth());
//
////                stage.setTitle("Tamaño minimo: Ancho->" + stage.getMinWidth() + " Alto->" + stage.getMinHeight());
//            });
//        } catch (Exception e) {
//            System.out.println("No funciono el set de tamaño minimo D:");
//        }
        stage.show();
    }

    public double getMainStageX() {
        return mainStageX;
    }

    public double getMainStageY() {
        return mainStageY;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
