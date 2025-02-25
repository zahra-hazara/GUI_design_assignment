package View;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private DictionaryController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new DictionaryController();

        // Create UI components
        Label wordLabel = new Label("Enter a word:");
        TextField wordField = new TextField();
        Button searchButton = new Button("Search");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);

        // Set up the layout
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.getChildren().addAll(wordLabel, wordField, searchButton, resultArea);

        // Set up the event handler for the search button
        searchButton.setOnAction(event -> {
            String word = wordField.getText();
            String meaning = controller.searchWord(word);
            resultArea.setText(meaning);
        });

        // Set up the scene and stage
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Virtual Dictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}