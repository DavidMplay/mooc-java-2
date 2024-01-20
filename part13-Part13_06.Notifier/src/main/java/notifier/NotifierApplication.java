package notifier;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class NotifierApplication extends Application{

    public void start(Stage window){
        VBox layout = new VBox();
        Button button = new Button("Update");
        TextField textField = new TextField();
        Label label = new Label();
        button.setOnAction((event)->{
            label.setText(textField.getText());
        });
        layout.getChildren().addAll(textField, button, label);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
