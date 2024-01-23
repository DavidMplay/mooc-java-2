package application;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GreeterApplication extends Application {

    public void start(Stage window) {
        GridPane layout = new GridPane();
        GridPane welcoming = new GridPane();
        welcoming.setPrefSize(300, 200);
        welcoming.setAlignment(Pos.CENTER);
        Label welcome = new Label();
        Label error = new Label();
        welcoming.add(welcome, 0, 0);
        layout.setPrefSize(300, 200);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        TextField name = new TextField();
        Label nameLabel = new Label("Enter your name and start.");
        Button start = new Button("Start");
        Scene scene1 = new Scene(layout);
        Scene scene2 = new Scene(welcoming);
        start.setOnAction((event) -> {
            if(name.getText().isEmpty()){
                error.setText("Text field is empty.");
                return;
            }
            String Name = name.getText();
            welcome.setText("Welcome " + Name + "!");
            window.setScene(scene2);
        });
        
        
        name.setMaxSize(200, 0);
        layout.add(name, 0, 1);
        layout.add(nameLabel, 0, 0);
        layout.add(start, 0, 2);
        layout.add(error, 0, 3);
        window.setScene(scene1);
        window.show();

    }

    public static void main(String[] args) {

        launch(GreeterApplication.class);

    }
}
