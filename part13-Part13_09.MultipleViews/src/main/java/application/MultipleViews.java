package application;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MultipleViews extends Application {

    public void start(Stage window) {
        BorderPane layout1 = new BorderPane();
        layout1.setTop(new Label("First view!"));
        Button toSecond = new Button("To second view");
        layout1.setCenter(toSecond);

        VBox layout2 = new VBox();
        Button toThird = new Button("To the Third view!");
        Label secondText = new Label("Second view!");
        layout2.getChildren().addAll(toThird, secondText);

        GridPane layout3 = new GridPane();
        Button toFirst = new Button("To the first view!");
        layout3.add(new Label("Third View"), 0, 0);
        layout3.add(toFirst, 1, 1);
        
        Scene scene1 = new Scene(layout1);
        Scene scene2 = new Scene(layout2);
        Scene scene3 = new Scene(layout3);
        
        toThird.setOnAction((event) -> {
            window.setScene(scene3);
        });

        toSecond.setOnAction((event) -> {
            window.setScene(scene2);
        });
        
        toFirst.setOnAction((event) -> {
            window.setScene(scene1);
        });
        
        window.setScene(scene1);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
