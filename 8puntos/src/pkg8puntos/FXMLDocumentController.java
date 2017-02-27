/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puntos;

import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javax.print.DocFlavor.URL;


/**
 *
 * @author joralgra
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private GridPane gp1;

    @FXML
    private Button bt11;

    @FXML
    private VBox pancho;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        bt11.setOnDragDropped(new EventHandler() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("Pene");
                event.consume();
            }
        });
        // TODO

//        gp1.setOnMouseMoved((event) -> {
//            label.setText("(" + (int) ((event.getSceneX() - gp1.getLayoutX()) / (gp1.getWidth() / 3)) + "," + (int) ((event.getSceneY() - gp1.getLayoutY()) / (gp1.getHeight() / 3)) + ")");
//        });
//        new Thread() {
//            public void run() {
//                bt11.setOnDragDetected(new EventHandler<MouseEvent>() {
//                    public void handle(MouseEvent event) {
//                        System.out.println("DD");
//
//                        int posX = (int) ((event.getSceneX() - gp1.getLayoutX()) / (gp1.getWidth() / 3));
//                        int posY = (int) ((event.getSceneY() - gp1.getLayoutY()) / (gp1.getHeight()/ 3));
//                        
//                        
//                        System.out.println(posX+" - " + posY);
//                        event.consume();
//                    }
//                });
//            }
//        }.start();
//        bt11.setOnKeyPressed((KeyEvent arg0) -> {
//            System.out.println("CLICK EN TECLA" + arg0);
//        });
    }

    

//    private void handleKeyPressed(KeyEvent event) {
//        System.out.println("INKEY");
//        System.out.println("KeyPressed: " + event.getCharacter());
//    }


}
