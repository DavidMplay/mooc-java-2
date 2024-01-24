package application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
public class JokeApplication extends Application{
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        layout.setMinSize(200, 200);
        Button joke = new Button("Joke");
        Button punchline = new Button("Answer");
        Button explanation = new Button("Explanation");
        layout.setTop(buttons);
        buttons.getChildren().addAll(joke, punchline, explanation);
        
        StackPane firstLayout = createView("What do you call a bear with no teeth?");
        StackPane secondLayout = createView("A gummy bear.");
        StackPane thirdLayout = createView("You can come up with a suitable explanation by yourself");
        joke.setOnAction((event) -> layout.setCenter(firstLayout));
        punchline.setOnAction((event) -> layout.setCenter(secondLayout));        
        explanation.setOnAction((event) -> layout.setCenter(thirdLayout));       
        layout.setCenter(firstLayout);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

        private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
    
    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
