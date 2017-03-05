/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed9puntos.win;

import static java.lang.Thread.sleep;
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
 * @author repli
 */
public class TransparentStage extends Application {

    @Override
    public void start(Stage stage) {
        try {
            ImageView iv = new ImageView("/fixed9puntos/win/HasGanado.gif");
            VBox p = new VBox(iv);

            //make the background of the label white and opaque
            //add some borders to visualise the element' locations
//            p.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
            Scene scene = new Scene(p);
            stage.setScene(scene);

            //this is where the transparency is achieved:
            //the three layers must be made transparent
            //(i)  make the VBox transparent (the 4th parameter is the alpha)
            p.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            //(ii) set the scene fill to transparent
            scene.setFill(null);
            //(iii) set the stage background to transparent
            stage.initStyle(TRANSPARENT);
            stage.setAlwaysOnTop(true);
            stage.setWidth(510);
            stage.setHeight(60);

            stage.show();

//            PauseTransition delay = new PauseTransition(Duration.seconds(5));
//            delay.setOnFinished(event -> stage.close());
//            delay.play();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
