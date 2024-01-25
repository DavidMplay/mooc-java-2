package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {

    private Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = this.dictionary.getRandomWord();
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Translate the word " + this.word + ".");
        TextField translationInput = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button input = new Button("Check");

        Label feedback = new Label("");

        layout.add(wordLabel, 0, 0);
        layout.add(translationInput, 0, 1);
        layout.add(feedback, 1, 0);
        layout.add(input, 1, 1);

        input.setOnMouseClicked((event) -> {
            String translation = translationInput.getText();
            if (this.dictionary.get(word).equalsIgnoreCase(translation)) {
                feedback.setText("Correct!");
            } else {
                feedback.setText("Incorrect, the correct translation is: " + this.dictionary.get(word));
                return;
            }
            this.word = dictionary.getRandomWord();
            wordLabel.setText("Type the translation of the word '" + word + "'");
            translationInput.clear();
        });

        return layout;
    }
}
