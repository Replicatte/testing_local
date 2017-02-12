package tresenrayaV2;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.imageio.ImageIO;

public class ImageButton extends Parent {

    private ImageView iv;

    private final static Image NORMAL_IMG = new Image("tresenraya.img.empty.png");
    private final static Image PRESSED_IMG = new Image("tresenraya.img.pressed.png");
    public ImageButton() {
        super();
        this.iv = new ImageView(NORMAL_IMG);
        this.getChildren().add(this.iv);

        this.iv.setOnMousePressed(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent evt) {
                iv.setImage(PRESSED_IMG);
            }

        });
    }
//    public ImageButton() {
//        this.iv = new ImageView(NORMAL_IMAGE);
//        this.getChildren().add(this.iv);
//        this.iv.setOnMousePressed(new EventHandler<MouseEvent>() {
//
//            public void handle(MouseEvent evt) {
//                iv.setImage(PRESSED_IMAGE);
//            }
//
//        });
//
//        // TODO other event handlers like mouse up
//
//    } 

}
