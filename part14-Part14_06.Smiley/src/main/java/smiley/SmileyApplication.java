package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public void start(Stage stage) {
        Canvas paintingCanvas = new Canvas(640, 480);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        BorderPane layout = new BorderPane();

        layout.setCenter(paintingCanvas);

        painter.setFill(Color.BLACK);
        painter.fillRect(120, 40, 50, 50);
        painter.fillRect(310, 40, 50, 50);
        painter.fillRect(80, 200, 50, 50);
        painter.fillRect(350, 200, 50, 50);
        painter.fillRect(130, 250, 220, 50); 

        Scene view = new Scene(layout);

        stage.setScene(view);
        stage.show();

    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
