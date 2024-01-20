package textstatistics;

import javafx.application.Application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.beans.value.ObservableValue;
import java.util.Arrays;

public class TextStatisticsApplication extends Application {

    public void start(Stage window) {
        BorderPane mainLayout = new BorderPane();

        TextArea textArea = new TextArea("");
        Label letterLabel = new Label();
        Label wordLabel = new Label();
        Label longestWord = new Label();
        mainLayout.setCenter(textArea);

        textArea.textProperty().addListener((ObservableValue<? extends String> change, String oldValue, String newValue) -> {
            int characterCount = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            letterLabel.setText("Letters: " + characterCount);
            wordLabel.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });

        HBox text = new HBox();
        text.setSpacing(15);
        text.getChildren().add(letterLabel);
        text.getChildren().add(wordLabel);
        text.getChildren().add(longestWord);

        mainLayout.setBottom(text);

        Scene view = new Scene(mainLayout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
