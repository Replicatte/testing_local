/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed9puntos;

import fixed9puntos.win.TransparentStage;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author repli
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox pancho;
    @FXML
    private GridPane gp1;

    private byte vacioX;
    private byte vacioY;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vacioX = 2;
        vacioY = 2;
        setUp();

        // TODO
        // GridPane.columnIndex="1" GridPane.rowIndex="1" getColumnIndex getRowIndex
//        bt11.setOnDragDetected(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//
//                int posX = (int) ((event.getSceneX() - gp1.getLayoutX()) / (gp1.getWidth() / 3));
//                int posY = (int) ((event.getSceneY() - gp1.getLayoutY()) / (gp1.getHeight() / 3));
//
//                event.consume();
//            }
//        });
    }

    public static void gameInit() {
        Pair bt1 = new Pair<Integer, Integer>(0, 0);
        Pair bt2 = new Pair<Integer, Integer>(0, 0);
        Pair bt3 = new Pair<Integer, Integer>(0, 0);
        Pair bt4 = new Pair<Integer, Integer>(0, 0);
        Pair bt5 = new Pair<Integer, Integer>(0, 0);
        Pair bt6 = new Pair<Integer, Integer>(0, 0);
        Pair bt7 = new Pair<Integer, Integer>(0, 0);
        Pair bt8 = new Pair<Integer, Integer>(0, 0);

    }

    @FXML
    private void mouseSoltado(MouseEvent event) {
        if (libre(event.getSource())) {
            byte posMouseX = (byte) ((event.getSceneX() - gp1.getLayoutX()) / (gp1.getWidth() / 3));
            byte posMouseY = (byte) ((event.getSceneY() - gp1.getLayoutY()) / (gp1.getHeight() / 3));

            System.out.println(posMouseX + " - " + posMouseY);
            Button but = (Button) event.getSource();

            if (posMouseX == vacioX && posMouseY == vacioY) {

                System.out.println("Valid translate");
                //FUTURE ANIMATION METHOD IN NEW THREAD(?)

//                new Thread(){
//                    @Override
//                    public void run() {
//                        
//                    }
//                    
//                }.start();
//                try {
//                    sleep(500);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//                }
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
            } else {

                but.setTranslateX(0);
                but.setTranslateY(0);
            }

        }
        event.consume();
    }

    @FXML
    private void mouseArrastrado(MouseEvent event) {
        if (libre(event.getSource())) {

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
        System.out.println("MouseSale del nodo");
        Button but = (Button) event.getSource();
        but.setCursor(Cursor.DEFAULT);
        event.consume();
    }

    @FXML
    private void mouseDentro(MouseEvent event) {

        if (libre(event.getSource())) {
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
        if (libre(event.getSource())) {
            System.out.println("MousePresionado");

            baseX = event.getSceneX();
            baseY = event.getSceneY();
        }
    }

    private boolean ganado() {
        return true;
    }

    private void setUp() {
        gp1.getChildren().remove(0, 8);

//        Button bt2 = new Button();
//        bt2.setText("2");
//        bt2.setOnKeyPressed(bt1.getOnKeyPressed());
//        bt2.setOnMouseEntered(bt1.getOnMouseEntered());
//        bt2.setOnMouseDragged(bt1.getOnMouseDragged());
//        bt2.setPrefHeight(bt1.getPrefHeight());
//        bt2.setPrefWidth(bt1.getPrefWidth());
//        bt2.setStyle(bt1.getStyle());
//        bt2.setFont(bt1.getFont());
//        (ISomething) i.getClass().getMethod("clone").invoke(i);
//        gp1.add(bt2, 1, 1);
        int[] arrayGuay = generarVectorAleatorio();
        for (int i = 0; i < arrayGuay.length; i++) {
            System.out.println(" Vector aleatorio: " + arrayGuay[i]);

        }

        gp1.add(bt1, getPosX(arrayGuay, 1), getPosY(arrayGuay, 1));
        gp1.add(bt2, getPosX(arrayGuay, 2), getPosY(arrayGuay, 2));
        gp1.add(bt3, getPosX(arrayGuay, 3), getPosY(arrayGuay, 3));
        gp1.add(bt4, getPosX(arrayGuay, 4), getPosY(arrayGuay, 4));
        gp1.add(bt5, getPosX(arrayGuay, 5), getPosY(arrayGuay, 5));
        gp1.add(bt6, getPosX(arrayGuay, 6), getPosY(arrayGuay, 6));
        gp1.add(bt7, getPosX(arrayGuay, 7), getPosY(arrayGuay, 7));
        gp1.add(bt8, getPosX(arrayGuay, 8), getPosY(arrayGuay, 8));

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

    private boolean libre(Object source) {
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
    }

    @FXML
    private void menuClick(ActionEvent event) {

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

    private void checkWin() {
        
        
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                TransparentStage ts = new TransparentStage();
                ts.start(new Stage());
            }
            
        });
        
    }

    enum TipoMovimiento {
        ARRIBA, ABAJO, IZQ, DER, NADA
    };

    enum EstadoPartida {
        GANADO, JUGANDO;
    };

}
