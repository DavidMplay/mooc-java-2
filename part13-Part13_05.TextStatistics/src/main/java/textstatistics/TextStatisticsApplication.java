package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class TextStatisticsApplication extends Application{

    public void start(Stage window){
        BorderPane mainLayout = new BorderPane();
        
        mainLayout.setCenter(new TextArea(""));
        
        HBox text = new HBox();
        
        text.getChildren().add(new Label("Letters: 0"));
        text.getChildren().add(new Label("Words: 0"));
        text.getChildren().add(new Label("The longest word is: "));
        
        mainLayout.setBottom(text);
        
        Scene view = new Scene (mainLayout);
        
        window.setScene(view);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
