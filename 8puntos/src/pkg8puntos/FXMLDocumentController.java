/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puntos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gp1.setOnMouseMoved((event) -> {
            label.setText("(" + (int) ((event.getSceneX() - gp1.getLayoutX()) / (gp1.getWidth() / 3)) + "," + (int) ((event.getSceneY() - gp1.getLayoutY()) / (gp1.getHeight() / 3)) + ")");
        });

        bt11.setOnDragEntered(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
 /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != gp1
                        && event.getDragboard().hasString()) {
                    bt11.setText(""+(event.getSceneX() - gp1.getLayoutX()));
                }

                event.consume();
            }
        });

    }

}
