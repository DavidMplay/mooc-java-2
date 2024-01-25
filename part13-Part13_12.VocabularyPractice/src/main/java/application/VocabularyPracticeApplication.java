package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application{

	private Dictionary dictionary;


	public static void main(String[] args) {
		launch(VocabularyPracticeApplication.class);
	}

	@Override
	public void init() throws Exception{
		dictionary = new Dictionary();
	}

	@Override
	public void start(Stage window) throws Exception {
		PracticeView practiceView = new PracticeView(dictionary);
		InputView inputView = new InputView(dictionary);

		BorderPane layout = new BorderPane();

		HBox menu = new HBox();
		menu.setPadding(new Insets(10, 10, 10, 10));
		menu.setSpacing(10);

		Button practiceButton = new Button("Practice");
		Button inputButton = new Button("Input words");
		menu.getChildren().addAll(practiceButton, inputButton);

		layout.setTop(menu);

		practiceButton.setOnMouseClicked((event) -> {
			layout.setCenter(practiceView.getView());
		});

		inputButton.setOnMouseClicked((event) -> {
			layout.setCenter(inputView.getView());
		});

		layout.setCenter(practiceView.getView());

		Scene view = new Scene(layout, 400, 300);

		window.setScene(view);
		window.show();
	}
}