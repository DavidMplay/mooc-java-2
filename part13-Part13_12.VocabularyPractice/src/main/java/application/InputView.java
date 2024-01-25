package application;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class InputView {

    private Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = new Dictionary();
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Word:");
        TextField wordField = new TextField();
        Label translationLabel = new Label("Translation:");
        TextField translationField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button input = new Button("Add the word pair");

        layout.add(wordLabel, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(translationLabel, 1, 0);
        layout.add(translationField, 1, 1);
        layout.add(input, 0, 2);

        input.setOnMouseClicked((event) -> {
            this.dictionary.add(wordField.getText(), translationField.getText());
            wordField.clear();
            translationField.clear();
        });

        return layout;
    }
}
