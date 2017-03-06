/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed9puntos;

import fixed9puntos.win.TransparentStage;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 *
 * @author Alemendros Granero, Jordi (2017)
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox pancho;
    @FXML
    private GridPane gp1;

    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt3;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;

    @FXML
    private ImageView salida;
    @FXML
    private ImageView despl;
    @FXML
    private HBox padreNuestro;

    private byte vacioX;
    private byte vacioY;

    private int contador;

    //Necesario para la stage de victoria.
    public static double mainGpWidth;
    public static double mainGpHeight;
    @FXML
    private Label labelCont;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gp1.widthProperty().addListener((obs, oldVal, newVal) -> mainGpWidth = (double) newVal);
        gp1.heightProperty().addListener((obs, oldVal, newVal) -> mainGpHeight = (double) newVal);

        vacioX = 2;
        vacioY = 2;
        setUp();
    }

    @FXML
    private void mouseSoltado(MouseEvent event) {
        if (esLibre(event.getSource()) && !hasGanado) {
            byte posMouseX = (byte) ((event.getSceneX() - gp1.getLayoutX()) / (gp1.getWidth() / 3));
            byte posMouseY = (byte) ((event.getSceneY() - gp1.getLayoutY()) / (gp1.getHeight() / 3));

            Button but = (Button) event.getSource();

            if (posMouseX == vacioX && posMouseY == vacioY) {

                //FUTURE ANIMATION METHOD IN NEW THREAD(?)
                //no se puede emplear un Thread sobre la App porque salta excepción,se pueden usar PauseTransitions!!!
                int auxVoidX = gp1.getColumnIndex(but);
                int auxVoidY = gp1.getRowIndex(but);

                gp1.setColumnIndex(but, (int) vacioX);
                gp1.setRowIndex(but, (int) vacioY);

                //OJO de int a Byte
                vacioX = (byte) auxVoidX;
                vacioY = (byte) auxVoidY;

                but.setTranslateX(0);
                but.setTranslateY(0);

                checkWin();
                gestionContador(1);
            } else {
                but.setTranslateX(0);
                but.setTranslateY(0);
            }

        }
        event.consume();
    }

    @FXML
    private void mouseArrastrado(MouseEvent event) {
        if (esLibre(event.getSource()) && !hasGanado) {

            //primera_vez = false;
            Button but = (Button) event.getSource();

            //event.getScene() -> posicion relativa a la escena
            //gp1.getLayoutX() -> posicion relativa al Layout
            but.setTranslateX(event.getSceneX() - baseX);
            but.setTranslateY(event.getSceneY() - baseY);

        }
        event.consume();
    }

    @FXML
    private void mouseFuera(MouseEvent event) {
        Button but = (Button) event.getSource();
        but.setCursor(Cursor.DEFAULT);
        event.consume();
    }

    @FXML
    private void mouseDentro(MouseEvent event) {

        if (esLibre(event.getSource()) && !hasGanado) {
            System.out.println("Movimiento Posible:" + movPosible.name());

            Button but = (Button) event.getSource();
            but.setCursor(Cursor.OPEN_HAND);
        }
        //Comprobar que este libre() para iluminar con el OPEN_HAND
        event.consume();
    }

    private double baseX, baseY;

    @FXML
    private void mousePressionado(MouseEvent event) {
        if (esLibre(event.getSource()) && !hasGanado) {

            baseX = event.getSceneX();
            baseY = event.getSceneY();
        }
        event.consume();

    }

    private boolean ganado() {
        return true;
    }

    private void setUp() {
        gp1.getChildren().remove(0, 8);

        int[] arrayGuay = generarVectorAleatorio();

        gp1.add(bt1, getPosX(arrayGuay, 1), getPosY(arrayGuay, 1));
        gp1.add(bt2, getPosX(arrayGuay, 2), getPosY(arrayGuay, 2));
        gp1.add(bt3, getPosX(arrayGuay, 3), getPosY(arrayGuay, 3));
        gp1.add(bt4, getPosX(arrayGuay, 4), getPosY(arrayGuay, 4));
        gp1.add(bt5, getPosX(arrayGuay, 5), getPosY(arrayGuay, 5));
        gp1.add(bt6, getPosX(arrayGuay, 6), getPosY(arrayGuay, 6));
        gp1.add(bt7, getPosX(arrayGuay, 7), getPosY(arrayGuay, 7));
        gp1.add(bt8, getPosX(arrayGuay, 8), getPosY(arrayGuay, 8));
        
        hasGanado = false;
        gestionContador(0);
    }

    private int getPosX(int[] array, int numBoton) {
        int posicionNum = -1;
        for (int i = 0; i < array.length; i++) {
            if (numBoton == array[i]) {
                posicionNum = i + 1;

                if (posicionNum == 1 || posicionNum == 4 || posicionNum == 7) {
                    return 0; // X = 0
                }
                if (posicionNum == 2 || posicionNum == 5 || posicionNum == 8) {
                    return 1; // X = 0
                }
                if (posicionNum == 3 || posicionNum == 6) {
                    return 2; // X = 0
                }
            }
        }
        return -1;
    }

    private int getPosY(int[] array, int numBoton) {
        int posicionNum = -1;
        for (int i = 0; i < array.length; i++) {
            if (numBoton == array[i]) {
                posicionNum = i + 1;
                if (posicionNum == 1 || posicionNum == 2 || posicionNum == 3) {
                    return 0; // X = 0
                }
                if (posicionNum == 4 || posicionNum == 5 || posicionNum == 6) {
                    return 1; // X = 0
                }
                if (posicionNum == 7 || posicionNum == 8) {
                    return 2; // X = 0
                }
            }
        }

        return -1;
    }

    private TipoMovimiento movPosible;

    private boolean esLibre(Object source) {
        Node nod = (Node) source;
        // da error en los nodos no libres!!!!
        //source no tiene indice de Columna!!
        final int x = gp1.getColumnIndex(nod);
        final int y = gp1.getRowIndex(nod);

        boolean huecoLibre = false;

        if (y == vacioY) {
            if (x == vacioX + 1) {
                huecoLibre = true;
                movPosible = TipoMovimiento.IZQ;
            } else if (x == vacioX - 1) {
                huecoLibre = true;
                movPosible = TipoMovimiento.DER;
            }
        } else if (x == vacioX) {
            if (y == vacioY - 1) {
                huecoLibre = true;
                movPosible = TipoMovimiento.ABAJO;
            } else if (y == vacioY + 1) {
                huecoLibre = true;
                movPosible = TipoMovimiento.ARRIBA;
            }
        }
        return huecoLibre;
    }

    @FXML
    private void resetClick(ActionEvent event) {
        setUp();
        vacioX = 2;
        vacioY = 2;
        event.consume();

    }

    private int[] generarVectorAleatorio() {
        int inversiones;
        final int n = 8;
        int[] numeros = new int[n];
        int[] resultado = new int[n];
        Random rnd = new Random();

        do {
            for (int i = 0; i < n; i++) {
                numeros[i] = i + 1;
            }
            int k = n;
            int res;
            for (int i = 0; i < n; i++) {
                res = rnd.nextInt(k);
                resultado[i] = numeros[res];
                numeros[res] = numeros[k - 1];
                k--;
            }

            inversiones = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (resultado[i] > resultado[j]) {
                        inversiones++;
                    }

                }
            }
        } while (inversiones % 2 != 0);

        return resultado;
    }
    private boolean hasGanado;

    private void checkWin() {
        boolean bt1Bien = gp1.getColumnIndex(bt1) == 0 && gp1.getRowIndex(bt1) == 0;
        boolean bt2Bien = gp1.getColumnIndex(bt2) == 1 && gp1.getRowIndex(bt2) == 0;
        boolean bt3Bien = gp1.getColumnIndex(bt3) == 2 && gp1.getRowIndex(bt3) == 0;
        boolean bt4Bien = gp1.getColumnIndex(bt4) == 0 && gp1.getRowIndex(bt4) == 1;
        boolean bt5Bien = gp1.getColumnIndex(bt5) == 1 && gp1.getRowIndex(bt5) == 1;
        boolean bt6Bien = gp1.getColumnIndex(bt6) == 2 && gp1.getRowIndex(bt6) == 1;
        boolean bt7Bien = gp1.getColumnIndex(bt7) == 0 && gp1.getRowIndex(bt7) == 2;
        boolean bt8Bien = gp1.getColumnIndex(bt8) == 1 && gp1.getRowIndex(bt8) == 2;

        if (bt1Bien && bt2Bien && bt3Bien && bt4Bien && bt5Bien && bt6Bien && bt7Bien && bt8Bien) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    hasGanado = true;
                    TransparentStage ts = new TransparentStage();
                    ts.start(new Stage());

                    PauseTransition delay = new PauseTransition(Duration.seconds(3));
                    delay.setOnFinished(event -> setUp());

                    delay.play();
                }
            });
        }
    }

    @FXML
    private void salirJuego(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    private void salidaPresionada(MouseEvent event) {
        ImageView iv = (ImageView) event.getSource();
        iv.setScaleX(0.75);
        iv.setScaleY(0.75);
    }

    private double offsetX;
    private double offsetY;

    @FXML
    private void iniciaOffset(MouseEvent event) {
        Stage stage = (Stage) padreNuestro.getScene().getWindow();

        offsetX = stage.getX() - event.getScreenX();
        offsetY = stage.getY() - event.getScreenY();

    }

    @FXML
    private void arrastraVentana(MouseEvent event) {
        ImageView iv = (ImageView) event.getSource();
        Window window = iv.getScene().getWindow();

        window.setX(event.getScreenX() + offsetX);//- 494
        window.setY(event.getScreenY() + offsetY);//-83

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.5);
        iv.setEffect(colorAdjust);
    }

    @FXML
    private void finArrastraVentana(MouseEvent event) {
        ImageView iv = (ImageView) event.getSource();
        iv.setEffect(null);
    }

    private void gestionContador(int i) {
        switch (i) {
            case 0:
                contador = 0;
                break;
            case 1:
                contador++;
                break;
            case -1:
                contador--;
                break;
        }
        labelCont.setText("" + contador);
    }

    enum TipoMovimiento {
        ARRIBA, ABAJO, IZQ, DER, NADA
    };
}
