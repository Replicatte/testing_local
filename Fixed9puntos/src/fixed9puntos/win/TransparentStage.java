/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed9puntos.win;

import static fixed9puntos.FXMLDocumentController.*;
import static fixed9puntos.Main.*;
import static java.lang.Thread.sleep;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static javafx.stage.StageStyle.TRANSPARENT;
import javafx.util.Duration;

/**
 *
 * @author Alemendros Granero, Jordi (2017)
 */
public class TransparentStage extends Application {

    @Override
    public void start(Stage stage) {
        try {
            ImageView iv = new ImageView("/fixed9puntos/win/HasGanado.gif");
            VBox p = new VBox(iv);

//            p.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
            Scene scene = new Scene(p);
            stage.setScene(scene);

            p.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            
            scene.setFill(null);
            
            stage.initStyle(TRANSPARENT);
            stage.setAlwaysOnTop(true);

            iv.fitWidthProperty().bind(stage.widthProperty());
            // ratio 51 :6
            double nuestroHeight = 60;
            if (mainGpWidth > 510) {
                nuestroHeight = (60 / 510)* mainGpWidth;

                stage.setWidth(mainGpWidth);
                stage.setHeight(nuestroHeight);

            } else {
                stage.setWidth(510);
                stage.setHeight(nuestroHeight);
            }

            stage.setX(mainStageX);
            stage.setY(mainStageY + (mainGpHeight / 2));

            stage.show();

            PauseTransition delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(event -> stage.close());
            delay.play();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
