package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private TextField inputField;

    @FXML
    private ListView<String> listView;

    private final ObservableList<String> wordsList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(wordsList);
    }

    @FXML
    public void addWord() {
        String word = inputField.getText();
        if (word.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input error");
            alert.setHeaderText("Empty message");
            alert.setContentText("Please enter some text in your message");
            alert.showAndWait();
            return;
        } else {
            addWordToList(word);
        }
        inputField.clear();
    }

    @FXML
    public void exit() {
        System.exit(1);
    }

    @FXML
    public void showAbout(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText("Chat");
        alert.setContentText("Geek brains course chat");
        alert.showAndWait();
        return;
    }

    private void addWordToList(String word) {
        listView.getItems().add("Me: " + word);
    }
}
